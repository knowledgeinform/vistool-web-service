package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.Kit;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.LineItem;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.LoadingPriorities;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.WorkItem;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.Status;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.ScheduledTasks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.VistoolTestUtilities.WORK_ITEM_SERIALIZER;
import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.VistoolTestUtilities.createWorkItem;
import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.VistoolUtilities.MONTH_DAY_YEAR_DATE_FORMAT;

@SpringBootTest
@MockBean(ScheduledTasks.class)
@ActiveProfiles({"local-dev-secure-h2"})
public class WorkItemTest {
    @Test
    public void testSerialization() {
        try {
            WorkItem workItem = createWorkItem();
            String jsonString = WORK_ITEM_SERIALIZER.toJson(workItem);
            workItem = WORK_ITEM_SERIALIZER.fromJson(jsonString, WorkItem.class);

            Assertions.assertEquals(1L, workItem.getId());
            Assertions.assertEquals(1L, workItem.getVersion());

            LineItem lineItem = new LineItem(1L, 1L, "WA-1", "LI-1", 10, null, null, null);
            Assertions.assertEquals(lineItem, workItem.getParentLineItem());

            Assertions.assertEquals("WO-1", workItem.getLinkedWorkOrder());
            Assertions.assertEquals("SN-1", workItem.getSerialNumber());
            Assertions.assertEquals(10, workItem.getQuantity());
            Assertions.assertEquals(3, workItem.getQuantityComplete());
            Assertions.assertEquals(7, workItem.getBalance());
            Assertions.assertEquals(true, workItem.getExpedite());
            Assertions.assertEquals("subsystem", workItem.getSubsystem());
            Assertions.assertEquals(LoadingPriorities.LOADED,
                    workItem.getPickAndPlace().getLoadingPriorities());
            Assertions.assertEquals("sizeAndMagazines", workItem.getPickAndPlace().getSizeAndMagazines());
            Assertions.assertEquals("pickAndPlaceNotes", workItem.getPickAndPlace().getPickAndPlaceNotes());
            Assertions.assertEquals(MONTH_DAY_YEAR_DATE_FORMAT.parse("01/01/2021"), workItem.getPickAndPlace().getTargetStartDate());
            Assertions.assertEquals(true, workItem.getProductionPlanning().isProductionPlanning());
            Assertions.assertEquals("productionPlanningNotes", workItem.getProductionPlanning().getProductionPlanningNotes());
            Assertions.assertEquals("actionItems", workItem.getProductionPlanning().getActionItems());
            Assertions.assertEquals(Status.INPROCESS, workItem.getStatus());
            Assertions.assertEquals("statusComments", workItem.getStatusComments());
            Assertions.assertEquals("manufacturingEngineer", workItem.getManufacturingEngineer());
            Assertions.assertEquals("currentTechnician", workItem.getCurrentTechnician());
            Assertions.assertEquals(2, workItem.getProgramPriority());
            Assertions.assertEquals(4, workItem.getTechnicianPriority());
            Assertions.assertEquals(6, workItem.getPolymericsPriority());
            Assertions.assertEquals(8, workItem.getInspectionPriority());
            Assertions.assertEquals(MONTH_DAY_YEAR_DATE_FORMAT.parse("02/02/2021"), workItem.getDateComplete());
            Assertions.assertEquals(MONTH_DAY_YEAR_DATE_FORMAT.parse("03/03/2021"), workItem.getKitPartDueDate());
            Assertions.assertEquals(MONTH_DAY_YEAR_DATE_FORMAT.parse("04/04/2021"), workItem.getEstimateToComplete());
            Assertions.assertEquals(MONTH_DAY_YEAR_DATE_FORMAT.parse("05/05/2021"), workItem.getEstimateToTest());
            Assertions.assertEquals(MONTH_DAY_YEAR_DATE_FORMAT.parse("06/06/2021"), workItem.getEstimateReturnToAssembly());
            Assertions.assertEquals(Kit.NO, workItem.getEeeKit());
            Assertions.assertEquals(Kit.YES, workItem.getMechKit());
            Assertions.assertEquals("comments", workItem.getComments());
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.fail(e.getMessage());
        }
    }
}
