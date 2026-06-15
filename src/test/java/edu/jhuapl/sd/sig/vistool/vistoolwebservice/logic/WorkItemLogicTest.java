package edu.jhuapl.sd.sig.vistool.vistoolwebservice.logic;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.VistoolTestUtilities;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.*;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.*;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.security.SecurityUtilities;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.service.LineItemService;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.service.WorkItemService;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.ScheduledTasks;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doReturn;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@MockBean(ScheduledTasks.class)
@MockBean(SecurityUtilities.class)
@ActiveProfiles({"local-dev-secure-h2"})
public class WorkItemLogicTest {
    @Autowired private WorkItemLogic workItemlogic;
    @Autowired private LineItemService lineItemService;
    @SpyBean private WorkItemService workItemService;

    private List<LineItem> lineItems;
    private List<WorkItem> workItems;

    @BeforeEach
    public void beforeEach() {
        lineItems = VistoolTestUtilities.createCompleteLineItems();
        workItems = VistoolTestUtilities.createCompleteWorkItems();
    }

    @AfterEach
    public void afterEach() {
        workItemService.deleteAllWorkItems();
        lineItemService.deleteAllLineItems();
    }

    @Test
    public void testCreateNewWorkItemWithClosedWorkAuth() {
        testCreateNewWorkItem(true);
    }

    @Test
    public void testCreateNewWorkItemWithoutClosedWorkAuth() {
        testCreateNewWorkItem(false);
    }

    public void testCreateNewWorkItem(boolean closedWorkAuth) {
        LineItem lineItem = VistoolTestUtilities.clone(lineItems.get(0));
        if(closedWorkAuth) {
            lineItem.setWorkAuthorizationNumber("026840");
        }
        lineItem = lineItemService.saveLineItem(lineItem);

        workItemlogic.createAndSaveNewWorkItem(lineItem, Optional.empty(), Optional.empty());
        WorkItem expectedWorkItem = new WorkItem();
        expectedWorkItem.setId(1L);
        expectedWorkItem.setVersion(1L);
        expectedWorkItem.setParentLineItem(lineItem);
        expectedWorkItem.setQuantity(lineItem.getQuantity());
        expectedWorkItem.setPickAndPlace(new PickAndPlace(null, LoadingPriorities.TBD, null, null, null));
        expectedWorkItem.setProductionPlanning(new ProductionPlanning());

        if(closedWorkAuth) {
            expectedWorkItem.setStatus(Status.COMPLETED);
            expectedWorkItem.setStatusComments("Status auto-assigned to completed based on 12/30/21 R1J Spreadsheet.");
        }

        WorkItem actualWorkItem = workItemService.getAllWorkItemsByParentLineItem(lineItem).get(0);
        Assertions.assertEquals(expectedWorkItem, actualWorkItem);
    }

    @Test
    public void testUpdateRelatedWorkItems() {
        LineItem oldLineItem = VistoolTestUtilities.clone(lineItems.get(0));
        LineItem newLineItem = VistoolTestUtilities.clone(oldLineItem);
        newLineItem.setQuantity(101);
        lineItemService.saveLineItems(Arrays.asList(oldLineItem, newLineItem));

        WorkItem expectedWorkItem = VistoolTestUtilities.clone(workItems.get(0));
        expectedWorkItem = workItemService.saveWorkItem(expectedWorkItem, false);

        workItemlogic.setParentLineItemForRelatedWorkItems(oldLineItem, newLineItem);
        expectedWorkItem.setParentLineItem(newLineItem);
        expectedWorkItem.setVersion(3L);

        WorkItem actualWorkItem = workItemService.getAllWorkItemsByParentLineItem(newLineItem).get(0);
        Assertions.assertEquals(expectedWorkItem, actualWorkItem);
    }

    @Test
    public void testCanLinkWorkOrderToWorkItemWithSameWorkAuthNumbers() {
        testCanLinkWorkOrderToWorkItem("12345", "12345", true);
    }

    @Test
    public void testCanLinkWorkOrderToWorkItemWithSimilarWorkAuthNumbers() {
        testCanLinkWorkOrderToWorkItem("WA-12345", "12345", true);
    }

    @Test
    public void testCanLinkWorkOrderToWorkItemWithDifferentWorkAuthNumbers() {
        testCanLinkWorkOrderToWorkItem("WA-12345", "12346", false);
    }

    public void testCanLinkWorkOrderToWorkItem(String workOrderWA, String workItemWA, boolean expected) {
        WorkItem workItem = workItems.get(0);
        HydratedWorkItem hydratedWorkItem = new HydratedWorkItem(workItem);
        hydratedWorkItem.getParentLineItem().setWorkAuthorizationNumber(workItemWA);
        doReturn(hydratedWorkItem).when(workItemService).getHydratedWorkItem(any());

        VeWo veWo = new VeWo();
        veWo.setWorkAuthorization(workOrderWA);

        boolean result = workItemlogic.canLinkWorkOrderToWorkItem(veWo, workItem);
        Assertions.assertEquals(result, expected);
    }
}
