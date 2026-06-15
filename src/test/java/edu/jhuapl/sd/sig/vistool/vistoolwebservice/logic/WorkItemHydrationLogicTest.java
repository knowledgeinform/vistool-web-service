package edu.jhuapl.sd.sig.vistool.vistoolwebservice.logic;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.VistoolTestUtilities;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.*;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.*;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.service.DenodoService;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.ScheduledTasks;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.VistoolUtilities;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.*;

import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.VistoolUtilities.MONTH_DAY_YEAR_DATE_FORMAT;

@SpringBootTest
@MockBean(ScheduledTasks.class)
@ActiveProfiles({"local-dev-secure-h2"})
public class WorkItemHydrationLogicTest {
    @Autowired private LineItemLogic lineItemLogic;
    @Autowired private DenodoService denodoService;
    @Autowired private WorkItemHydrationLogic workItemHydrationLogic;

    @AfterEach
    public void afterEach() {
        denodoService.deleteAllVmSysWorkAuthChangeHistoryVistool();
        denodoService.deleteAllVeWo();
        denodoService.deleteAllDimHRPerson();
    }

    @Test
    public void testHydrateWorkItem() {
        VmSysWorkAuthDetailChangeHistoryVistool vmSysWorkAuth = createTestVmSysWorkAuthChangeHistoryVistool();
        VeWo veWo = createTestVeWo();
        WorkItem workItem = createTestWorkItem();
        List<DimHRPerson> dimHrPersonList = createTestDimHRPersonList();

        denodoService.addVmSysWorkAuthChangeHistoryVistool(Collections.singletonList(vmSysWorkAuth));
        denodoService.addVeWo(Collections.singletonList(veWo));
        denodoService.addDimHRPerson(dimHrPersonList);

        HydratedWorkItem hydratedWorkItem = workItemHydrationLogic.hydrateWorkItem(workItem);
        Assertions.assertEquals(workItem.getId(), hydratedWorkItem.getId());
        Assertions.assertEquals(workItem.getVersion(), hydratedWorkItem.getVersion());
        Assertions.assertEquals(workItem.getParentLineItem(), hydratedWorkItem.getParentLineItem());
        Assertions.assertEquals(workItem.getLinkedWorkOrder(), hydratedWorkItem.getLinkedWorkOrder());
        Assertions.assertEquals(workItem.getSerialNumber(), hydratedWorkItem.getSerialNumber());
        Assertions.assertEquals(workItem.getQuantity(), hydratedWorkItem.getQuantity());
        Assertions.assertEquals(workItem.getQuantityComplete(), hydratedWorkItem.getQuantityComplete());
        Assertions.assertEquals(workItem.getBalance(), hydratedWorkItem.getBalance());
        Assertions.assertEquals(workItem.getExpedite(), hydratedWorkItem.getExpedite());
        Assertions.assertEquals(workItem.getSubsystem(), hydratedWorkItem.getSubsystem());
        Assertions.assertEquals(workItem.getPickAndPlace(), hydratedWorkItem.getPickAndPlace());
        Assertions.assertEquals(workItem.getProductionPlanning(), hydratedWorkItem.getProductionPlanning());
        Assertions.assertEquals(workItem.getStatus(), hydratedWorkItem.getStatus());
        Assertions.assertEquals(workItem.getStatusComments(), hydratedWorkItem.getStatusComments());
        Assertions.assertEquals(workItem.getManufacturingEngineer(), hydratedWorkItem.getManufacturingEngineer());
        Assertions.assertEquals(workItem.getCurrentTechnician(), hydratedWorkItem.getCurrentTechnician());
        Assertions.assertEquals(workItem.getProgramPriority(), hydratedWorkItem.getProgramPriority());
        Assertions.assertEquals(workItem.getTechnicianPriority(), hydratedWorkItem.getTechnicianPriority());
        Assertions.assertEquals(workItem.getPolymericsPriority(), hydratedWorkItem.getPolymericsPriority());
        Assertions.assertEquals(workItem.getInspectionPriority(), hydratedWorkItem.getInspectionPriority());
        Assertions.assertEquals(workItem.getDateComplete(), hydratedWorkItem.getDateComplete());
        Assertions.assertEquals(workItem.getKitPartDueDate(), hydratedWorkItem.getKitPartDueDate());
        Assertions.assertEquals(workItem.getEstimateToComplete(), hydratedWorkItem.getEstimateToComplete());
        Assertions.assertEquals(workItem.getEstimateToTest(), hydratedWorkItem.getEstimateToTest());
        Assertions.assertEquals(workItem.getEstimateReturnToAssembly(), hydratedWorkItem.getEstimateReturnToAssembly());
        Assertions.assertEquals(workItem.getEeeKit(), hydratedWorkItem.getEeeKit());
        Assertions.assertEquals(workItem.getMechKit(), hydratedWorkItem.getMechKit());

        Assertions.assertEquals("Person One", hydratedWorkItem.getWorkAuthorizationCustomer());
        Assertions.assertEquals(vmSysWorkAuth.getDepartmentId(), hydratedWorkItem.getWorkAuthorizationDepartmentID());
        Assertions.assertEquals(vmSysWorkAuth.getHeaderId(), hydratedWorkItem.getParentLineItem().getWorkAuthorizationNumber());
        Assertions.assertEquals(vmSysWorkAuth.getSubmitDate(), hydratedWorkItem.getWorkAuthorizationSubmitDate());
        Assertions.assertEquals(vmSysWorkAuth.getHeaderTa(), hydratedWorkItem.getWorkAuthorizationTaskAuthorization());
        Assertions.assertEquals(vmSysWorkAuth.getDescription(), hydratedWorkItem.getWorkAuthorizationDescription());
        Assertions.assertEquals(vmSysWorkAuth.getWorkAuthorizationFlowId(),
                hydratedWorkItem.getWorkAuthorizationFlowId());
        Assertions.assertEquals(vmSysWorkAuth.getDetailTa(), hydratedWorkItem.getWorkAuthorizationTaskAuthorization());
        Assertions.assertEquals(vmSysWorkAuth.getPartId(), hydratedWorkItem.getWorkAuthorizationPartNumber());
        Assertions.assertEquals(vmSysWorkAuth.getWantDate(), hydratedWorkItem.getWorkAuthorizationDueDate());
        Assertions.assertEquals(vmSysWorkAuth.getWorkAuthorizationId(),
                hydratedWorkItem.getParentLineItem().getWorkAuthorizationNumber());

        Assertions.assertEquals(veWo.getSerialNumber(), hydratedWorkItem.getWorkOrderSerialNumber());
        Assertions.assertEquals(veWo.getWorkOrderNumber(), hydratedWorkItem.getWorkOrderNumber());
    }

    @Test
    public void testCurrentAndNextSteps(){
        List<WorkItem> workItems = VistoolTestUtilities.createCompleteWorkItems();
        WorkItem workItem = workItems.get(0);
        workItem.setLinkedWorkOrder("WO-1");

        VeWoOps veWoOps = new VeWoOps();
        veWoOps.setResourceID("R-1");
        veWoOps.setOperationType("O-1");
        veWoOps.setSequenceNumber(100.00);
        veWoOps.setStatus("Z");
        veWoOps.setWorkOrderNumber("WO-1");
        veWoOps.setRunType("");
        denodoService.addVeWoOps(Collections.singletonList(veWoOps));

        veWoOps = new VeWoOps();
        veWoOps.setResourceID("R-2");
        veWoOps.setOperationType("O-2");
        veWoOps.setSequenceNumber(301.00);
        veWoOps.setStatus("R");
        veWoOps.setWorkOrderNumber("WO-1");
        veWoOps.setRunType("");
        denodoService.addVeWoOps(Collections.singletonList(veWoOps));

        veWoOps = new VeWoOps();
        veWoOps.setResourceID("R-3");
        veWoOps.setOperationType("O-3");
        veWoOps.setSequenceNumber(302.00);
        veWoOps.setStatus("C");
        veWoOps.setWorkOrderNumber("WO-1");
        veWoOps.setRunType("");
        denodoService.addVeWoOps(Collections.singletonList(veWoOps));

        veWoOps = new VeWoOps();
        veWoOps.setResourceID("R-4");
        veWoOps.setOperationType("O-4");
        veWoOps.setSequenceNumber(303.00);
        veWoOps.setStatus("");
        veWoOps.setWorkOrderNumber("WO-1");
        veWoOps.setRunType("");
        denodoService.addVeWoOps(Collections.singletonList(veWoOps));

        veWoOps = new VeWoOps();
        veWoOps.setResourceID("R-5");
        veWoOps.setOperationType("O-5");
        veWoOps.setSequenceNumber(301.00);
        veWoOps.setStatus("X");
        veWoOps.setWorkOrderNumber("WO-2");
        veWoOps.setRunType("");
        denodoService.addVeWoOps(Collections.singletonList(veWoOps));

        veWoOps = new VeWoOps();
        veWoOps.setResourceID("R-6");
        veWoOps.setOperationType("O-6");
        veWoOps.setSequenceNumber(304.00);
        veWoOps.setStatus("R");
        veWoOps.setWorkOrderNumber("WO-1");
        veWoOps.setRunType("");
        denodoService.addVeWoOps(Collections.singletonList(veWoOps));

        HydratedWorkItem hydratedWorkItem = workItemHydrationLogic.hydrateWorkItem(workItem);
        Assertions.assertEquals("R-2", hydratedWorkItem.getCurrentStep().getResourceID());
        Assertions.assertEquals(2, hydratedWorkItem.getNextSteps().size());
        Assertions.assertEquals("R-3", hydratedWorkItem.getNextSteps().get(0).getResourceID());
        Assertions.assertEquals("R-6", hydratedWorkItem.getNextSteps().get(1).getResourceID());
        for(int i = 0; i < hydratedWorkItem.getNextSteps().size(); i++) {
            Assertions.assertNotEquals("R-1", hydratedWorkItem.getNextSteps().get(i).getResourceID());
            Assertions.assertNotEquals("R-2", hydratedWorkItem.getNextSteps().get(i).getResourceID());
            Assertions.assertNotEquals("R-4", hydratedWorkItem.getNextSteps().get(i).getResourceID());
            Assertions.assertNotEquals("R-5", hydratedWorkItem.getNextSteps().get(i).getResourceID());
        }
    }

    @Test
    public void testHydrateWithVmSysWorkAuthChangeHistoryData() throws Exception {
        Date date = VistoolUtilities.YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_DATE_FORMAT.parse("2021-01-01T01:01:01");
        WorkItem workItem = VistoolTestUtilities.createCompleteWorkItems().get(0);
        workItem.getParentLineItem().setWorkAuthorizationChangeTADate(date);

        VmSysWorkAuthDetailChangeHistoryVistool vmSysWorkAuth = createTestVmSysWorkAuthChangeHistoryVistool();
        vmSysWorkAuth.setChangeHeaderId(1);
        vmSysWorkAuth.setChangeLineId(1);
        vmSysWorkAuth.setChangeWorkAuthorizationId(vmSysWorkAuth.getWorkAuthorizationId());
        vmSysWorkAuth.setChangeLineItemNumber("LI-1");
        vmSysWorkAuth.setChangeSubmitDate(date);
        vmSysWorkAuth.setChangeTa("New Task Authorization");
        denodoService.addVmSysWorkAuthChangeHistoryVistool(List.of(vmSysWorkAuth));
        lineItemLogic.createNewLineItems(Optional.empty());

        HydratedWorkItem hydratedWorkItem = workItemHydrationLogic.hydrateWorkItem(workItem);
        Assertions.assertEquals("New Task Authorization", hydratedWorkItem.getWorkAuthorizationTaskAuthorization());
    }

    @SneakyThrows
    private VmSysWorkAuthDetailChangeHistoryVistool createTestVmSysWorkAuthChangeHistoryVistool() {
        VmSysWorkAuthDetailChangeHistoryVistool vmSysWorkAuth = new VmSysWorkAuthDetailChangeHistoryVistool();
        vmSysWorkAuth.setHeaderCreateDate(MONTH_DAY_YEAR_DATE_FORMAT.parse("03/07/2021"));
        vmSysWorkAuth.setCustomer("11111111");
        vmSysWorkAuth.setDepartmentId("SES");
        vmSysWorkAuth.setHeaderId("WA-1");
        vmSysWorkAuth.setHeaderLastModified(MONTH_DAY_YEAR_DATE_FORMAT.parse("02/07/2021"));
        vmSysWorkAuth.setOriginator("22222222");
        vmSysWorkAuth.setStatus("In progress");
        vmSysWorkAuth.setSubmitDate(MONTH_DAY_YEAR_DATE_FORMAT.parse("07/21/2021"));
        vmSysWorkAuth.setHeaderTa("Kim");
        vmSysWorkAuth.setWorkAreaId("99999");
        vmSysWorkAuth.setAplGroupsId("231434");
        vmSysWorkAuth.setComments("Please return kit by Monday");
        vmSysWorkAuth.setDetailCreateDate(MONTH_DAY_YEAR_DATE_FORMAT.parse("01/01/2020"));
        vmSysWorkAuth.setDescription("The kit #124324 is being used in R1J");
        vmSysWorkAuth.setFlow("Flow A");
        vmSysWorkAuth.setInPLM("0");
        vmSysWorkAuth.setDetailLastModified(MONTH_DAY_YEAR_DATE_FORMAT.parse("01/01/2020"));
        vmSysWorkAuth.setLineItem("LI-1");
        vmSysWorkAuth.setOriginalWorkOrder("WO-1");
        vmSysWorkAuth.setParentLot("LOT-1");
        vmSysWorkAuth.setParentWorkOrder("WO-0");
        vmSysWorkAuth.setPartId("PART-1");
        vmSysWorkAuth.setQuantity(10);
        vmSysWorkAuth.setReddFlowId("Flow B");
        vmSysWorkAuth.setRevision("42");
        vmSysWorkAuth.setSplitId("55555");
        vmSysWorkAuth.setDetailTa("Kim");
        vmSysWorkAuth.setUsingSN("0");
        vmSysWorkAuth.setWorkAuthorizationFlowId("Flow C");
        vmSysWorkAuth.setWantDate(MONTH_DAY_YEAR_DATE_FORMAT.parse("05/05/2022"));
        vmSysWorkAuth.setWorkAuthorizationId("WA-1");
        return vmSysWorkAuth;
    }

    private LineItem createTestLineItem() {
        LineItem lineItem = new LineItem();
        lineItem.setId(1L);
        lineItem.setVersion(1L);
        lineItem.setWorkAuthorizationNumber("WA-1");
        lineItem.setLineItemNumber("LI-1");
        lineItem.setQuantity(10);
        return lineItem;
    }

    @SneakyThrows
    private WorkItem createTestWorkItem() {
        WorkItem workItem = new WorkItem();
        workItem.setId(1L);
        workItem.setVersion(1L);
        workItem.setParentLineItem(createTestLineItem());
        workItem.setLinkedWorkOrder("WO-1");
        workItem.setSerialNumber("SN-1");
        workItem.setQuantity(10);
        workItem.setQuantityComplete(5);
        workItem.setBalance(5);
        workItem.setExpedite(true);
        workItem.setSubsystem("subsystem");

        PickAndPlace pickAndPlace = new PickAndPlace();
        pickAndPlace.setLoadingPriorities(LoadingPriorities.LOADED);
        pickAndPlace.setPickAndPlaceNotes("Very interesting PickAndPlace notes");
        pickAndPlace.setSizeAndMagazines("PickAndPlace size and magazines");
        pickAndPlace.setTargetStartDate(MONTH_DAY_YEAR_DATE_FORMAT.parse("01/01/2021"));
        workItem.setPickAndPlace(pickAndPlace);

        ProductionPlanning productionPlanning = new ProductionPlanning();
        productionPlanning.setActionItems("ProductionPlanning action items");
        productionPlanning.setProductionPlanning(true);
        productionPlanning.setProductionPlanningNotes("ProductionPlanning notes");
        workItem.setProductionPlanning(productionPlanning);

        workItem.setStatus(Status.INPROCESS);
        workItem.setStatusComments("statusComments");
        workItem.setManufacturingEngineer("manufacturingEngineer");
        workItem.setCurrentTechnician("currentTechnician");
        workItem.setProgramPriority(2);
        workItem.setTechnicianPriority(4);
        workItem.setPolymericsPriority(6);
        workItem.setInspectionPriority(8);
        workItem.setDateComplete(MONTH_DAY_YEAR_DATE_FORMAT.parse("02/02/2021"));
        workItem.setKitPartDueDate(MONTH_DAY_YEAR_DATE_FORMAT.parse("03/03/2021"));
        workItem.setEstimateToComplete(MONTH_DAY_YEAR_DATE_FORMAT.parse("08/21/2022"));
        workItem.setEstimateToTest(MONTH_DAY_YEAR_DATE_FORMAT.parse("05/21/2022"));
        workItem.setEstimateReturnToAssembly(MONTH_DAY_YEAR_DATE_FORMAT.parse("06/06/2021"));
        workItem.setEeeKit(Kit.YES);
        workItem.setMechKit(Kit.YES);
        workItem.setWorkOrderExists(WorkOrderExists.CREATED_AND_APPROVED);

        return workItem;
    }

    @SneakyThrows
    private VeWo createTestVeWo() {
        VeWo veWo = new VeWo();
        veWo.setBaseID("00034");
        veWo.setChargeGroup("R1J");
        veWo.setCreateDate(MONTH_DAY_YEAR_DATE_FORMAT.parse("01/01/2020"));
        veWo.setCustomer("SES");
        veWo.setDescription("A hardware component for space subsystem");
        veWo.setHardwareLevel("Step 4");
        veWo.setLotID("00045");
        veWo.setOriginalWorkOrder("0005/01");
        veWo.setPartID("44444");
        veWo.setPlanner("Planner: work on steps 1-4 with other R1J folks");
        veWo.setSerialNumber("SN-1");
        veWo.setSplitID("01");
        veWo.setStatus("Testing");
        veWo.setSubID("4");
        veWo.setTimestamp("12:00 pm 8/30/21");
        veWo.setWorkAuthorization("000007");
        veWo.setWbsCode("56");
        veWo.setWbsProject("Internal Components");
        veWo.setWorkOrderAssignee("Assignee");
        veWo.setWorkOrderNumber("WO-1");

        return veWo;
    }

    @SneakyThrows
    private List<DimHRPerson> createTestDimHRPersonList() {
        List<DimHRPerson> dimHrPersonList = new ArrayList<>();

        DimHRPerson dimHrPersonOne = new DimHRPerson();
        dimHrPersonOne.setPersonNumber("11111111");
        dimHrPersonOne.setPreferredFullName("Person One");

        DimHRPerson dimHrPersonTwo = new DimHRPerson();
        dimHrPersonTwo.setPersonNumber("22222222");
        dimHrPersonTwo.setPreferredFullName("Person Two");

        dimHrPersonList.add(dimHrPersonOne);
        dimHrPersonList.add(dimHrPersonTwo);
        return dimHrPersonList;
    }
}
