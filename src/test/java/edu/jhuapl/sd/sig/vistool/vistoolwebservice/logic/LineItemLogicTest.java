package edu.jhuapl.sd.sig.vistool.vistoolwebservice.logic;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.VistoolTestUtilities;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.VmSysWorkAuthDetailChangeHistoryVistool;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.*;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.vistool.WaChangesRepository;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.security.SecurityUtilities;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.service.DenodoService;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.service.LineItemService;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.service.WorkItemService;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.ScheduledTasks;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.VistoolUtilities;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@MockBean(ScheduledTasks.class)
@MockBean(SecurityUtilities.class)
@ActiveProfiles({"local-dev-secure-h2"})
public class LineItemLogicTest {
    @Autowired private LineItemLogic lineItemLogic;
    @Autowired private LineItemService lineItemService;
    @Autowired private WorkItemService workItemService;
    @Autowired private DenodoService denodoService;
    @Autowired private WaChangesRepository waChangesRepository;

    private List<LineItem> lineItems;
    private List<WorkItem> workItems;
    private List<VmSysWorkAuthDetailChangeHistoryVistool> vmSysWorkAuths;

    @BeforeEach
    public void beforeEach() throws ParseException {
        lineItems = VistoolTestUtilities.createCompleteLineItems();
        lineItems = lineItemService.saveLineItems(lineItems);
        workItems = VistoolTestUtilities.createCompleteWorkItems();
        workItems = workItemService.saveWorkItems(workItems, false);
        vmSysWorkAuths = Arrays.asList(
                VistoolTestUtilities.createVmSysWorkAuth("WA-1", "LI-1", "SI-1", 999));
        denodoService.addVmSysWorkAuthChangeHistoryVistool(vmSysWorkAuths);
        waChangesRepository.deleteAll();
        vmSysWorkAuths.forEach(vmSysWorkAuth -> waChangesRepository.save(new WaChanges(vmSysWorkAuth)));
    }

    @AfterEach
    public void afterEach() {
        workItemService.deleteAllWorkItems();
        lineItemService.deleteAllLineItems();
        denodoService.deleteAllVmSysWorkAuthChangeHistoryVistool();
    }

    @Test
    public void testCreateWithExistingLineItems() throws Exception {
        lineItemLogic.createNewLineItems(Optional.empty());

        LineItem expectedLineItem = VistoolTestUtilities.clone(lineItems.get(0));
        LineItem actualLineItem = lineItemService.getLineItemByWorkAuthorizationNumberAndLineItemNumber(
                "WA-1", "LI-1").get();
        Assertions.assertEquals(expectedLineItem, actualLineItem);

        WorkItem expectedWorkItem = VistoolTestUtilities.clone(workItems.get(0));
        WorkItem actualWorkItem = workItemService.getAllWorkItemsByParentLineItem(expectedLineItem).get(0);
        Assertions.assertEquals(expectedWorkItem, actualWorkItem);
    }

    @Test
    public void testCreateNewLineItems() throws Exception {
        workItemService.deleteAllWorkItems();
        lineItemService.deleteAllLineItems();
        lineItemLogic.createNewLineItems(Optional.of(VistoolUtilities.MONTH_DAY_YEAR_DATE_FORMAT.parse("01/01/2001")));

        LineItem expectedLineItem = VistoolTestUtilities.clone(lineItems.get(0));
        expectedLineItem.setQuantity(999);

        LineItem actualLineItem = lineItemService.getLineItemByWorkAuthorizationNumberAndLineItemNumber(
                "WA-1", "LI-1").get();
        Assertions.assertEquals(expectedLineItem, actualLineItem);

        WorkItem expectedWorkItem = VistoolTestUtilities.createIncompleteWorkItems().get(0);
        expectedWorkItem.setId(1L);
        expectedWorkItem.setVersion(1L);
        expectedWorkItem.setParentLineItem(actualLineItem);
        expectedWorkItem.setQuantity(999);
        expectedWorkItem.setPickAndPlace(new PickAndPlace(null, LoadingPriorities.TBD, null, null, null));
        expectedWorkItem.setProductionPlanning(new ProductionPlanning());

        WorkItem actualWorkItem = workItemService.getAllWorkItemsByParentLineItem(actualLineItem).get(0);
        Assertions.assertEquals(expectedWorkItem, actualWorkItem);
    }

    @Test
    public void testUpdateLineItemWithWorkAuthorizationChangeQuantityIncrease() throws Exception {
        List<VmSysWorkAuthDetailChangeHistoryVistool> vmSysWorkAuthChangeHistoryList = List.of(
                VistoolTestUtilities.addChangeHistoryToVmSysWorkAuth(vmSysWorkAuths.get(0), 1, 1, 101,
                        VistoolUtilities.YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_DATE_FORMAT.parse("2021-01-01T01:01:01"),
                        "LI-1"),
                VistoolTestUtilities.addChangeHistoryToVmSysWorkAuth(vmSysWorkAuths.get(0), 2, 2, 102,
                        VistoolUtilities.YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_DATE_FORMAT.parse("2021-02-02T02:02:02"),
                        "LI-1"));
        for (VmSysWorkAuthDetailChangeHistoryVistool vmSysWorkAuthChangeHistory : vmSysWorkAuthChangeHistoryList) {
            vmSysWorkAuthChangeHistory.setSubmitDate(VistoolUtilities.YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_DATE_FORMAT.parse("2000-01-01T01:01:01"));
        }
        denodoService.addVmSysWorkAuthChangeHistoryVistool(vmSysWorkAuthChangeHistoryList);
        lineItemLogic.createNewLineItems(Optional.of(VistoolUtilities.MONTH_DAY_YEAR_DATE_FORMAT.parse("01/01/2001")));

        // Check if the Line Item (WA-1, LI-1) was updated with a new version and
        // quantity.
        LineItem actualLineItem = lineItemService.getLineItemByWorkAuthorizationNumberAndLineItemNumber(
                "WA-1", "LI-1").get();
        Assertions.assertEquals(2, actualLineItem.getVersion());
        Assertions.assertEquals(102, actualLineItem.getQuantity());

        // Check if the new Work Item was created with the surplus quantity (2) for Line
        // Item (WA-1, LI-1).
        checkWorkItemUpdatedWithLineItemQuantityChange(actualLineItem);

        // Check that the same VmSysWorkAuthChangeHistory isn't applied again. No new
        // versions should be created.
        lineItemLogic.createNewLineItems(Optional.empty());
        checkWorkItemUpdatedWithLineItemQuantityChange(actualLineItem);
    }

    @Test
    public void testUpdateLineItemWithWithWorkAuthorizationChangeStopOrder() throws Exception {
        VmSysWorkAuthDetailChangeHistoryVistool vmSysWorkAuthChangeHistory = vmSysWorkAuths.get(0);
        VistoolTestUtilities.addChangeHistoryToVmSysWorkAuth(vmSysWorkAuthChangeHistory, 1, 1, vmSysWorkAuthChangeHistory.getChangeLineQuantity(),
                VistoolUtilities.YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_DATE_FORMAT.parse("2021-01-01T01:01:01"),
                "LI-1");
        vmSysWorkAuthChangeHistory.setChangeLineStopOrder(true);
        vmSysWorkAuthChangeHistory.setChangeHeaderStopOrder(true);
        // need to really change something in the work item (adding a change comment isn't enough - the change has to modify the original work item)
        vmSysWorkAuthChangeHistory.setChangeLineQuantity(10);
        vmSysWorkAuthChangeHistory.setChangeComment("CHANGE COMMENT");
        vmSysWorkAuthChangeHistory.setSubmitDate(VistoolUtilities.YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_DATE_FORMAT.parse("2000-01-01T01:01:01"));
        denodoService.addVmSysWorkAuthChangeHistoryVistool(List.of(vmSysWorkAuthChangeHistory));
        lineItemLogic.createNewLineItems(Optional.of(VistoolUtilities.MONTH_DAY_YEAR_DATE_FORMAT.parse("01/01/2001")));

        // Check if the Line Item (WA-1, LI-1) was updated with a new version and
        // workAuthorizationChangeDate.
        LineItem actualLineItem = lineItemService.getLineItemByWorkAuthorizationNumberAndLineItemNumber(
                "WA-1", "LI-1").get();
        Assertions.assertEquals(2, actualLineItem.getVersion());

        // Check if the WorkItem's status and statusComments were updated.
        List<WorkItem> actualWorkItems = workItemService.getAllWorkItemsByParentLineItem(actualLineItem);
        Assertions.assertEquals(1, actualWorkItems.size());
        Assertions.assertEquals(2, actualWorkItems.get(0).getVersion());
        Assertions.assertEquals(Status.CHANGED, actualWorkItems.get(0).getStatus());
        Assertions.assertEquals(workItems.get(0).getStatusComments() + " -- " + "CHANGE COMMENT",
                actualWorkItems.get(0).getStatusComments());

        // Test updating the WorkItem's status and statusComments. Re-process the
        // VmSysWorkAuthChangeHistory and check
        // that it isn't applied again.
        WorkItem workItem = actualWorkItems.get(0);
        workItem.setStatus(Status.TEST);
        workItem.setStatusComments("NEW STATUS COMMENTS");
        workItemService.saveWorkItem(workItem, false);
        lineItemLogic.createNewLineItems(Optional.empty());
        actualWorkItems = workItemService.getAllWorkItemsByParentLineItem(actualLineItem);
        Assertions.assertEquals(1, actualWorkItems.size());
        Assertions.assertEquals(3, actualWorkItems.get(0).getVersion());
        Assertions.assertEquals(Status.TEST, actualWorkItems.get(0).getStatus());
        Assertions.assertEquals("NEW STATUS COMMENTS", actualWorkItems.get(0).getStatusComments());

    }

    private void checkWorkItemUpdatedWithLineItemQuantityChange(LineItem lineItem) {
        List<WorkItem> actualWorkItems = workItemService.getAllWorkItemsByParentLineItem(lineItem);
        Assertions.assertEquals(2, actualWorkItems.size());
        Assertions.assertEquals(2, actualWorkItems.get(0).getVersion());
        Assertions.assertEquals("WA-1", actualWorkItems.get(0).getParentLineItem().getWorkAuthorizationNumber());
        Assertions.assertEquals("LI-1", actualWorkItems.get(0).getParentLineItem().getLineItemNumber());
        Assertions.assertEquals(100, actualWorkItems.get(0).getQuantity());
        Assertions.assertEquals(1, actualWorkItems.get(1).getVersion());
        Assertions.assertEquals("WA-1", actualWorkItems.get(1).getParentLineItem().getWorkAuthorizationNumber());
        Assertions.assertEquals("LI-1", actualWorkItems.get(1).getParentLineItem().getLineItemNumber());
        Assertions.assertEquals(2, actualWorkItems.get(1).getQuantity());
    }
}
