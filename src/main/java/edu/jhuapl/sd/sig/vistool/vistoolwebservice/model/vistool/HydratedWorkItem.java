package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class HydratedWorkItem extends WorkItem implements Comparable<HydratedWorkItem> {
    // Fields hydrated from VmSysWorkAuth
    private String workAuthorizationCustomer;
    private String workAuthorizationDepartmentID;
    private Date workAuthorizationSubmitDate;
    private String workAuthorizationTaskAuthorization;

    // Fields hydrated from VmSysWorkAuthDetail
    private String workAuthorizationDescription;
    private String workAuthorizationFlowId;
    private String workAuthorizationPartNumber;
    private String workAuthorizationRevision;
    private Date workAuthorizationDueDate;

    // Fields hydrated from VeWo
    private String workOrderSerialNumber;
    private String workOrderNumber;

    //Fields hydrated from VeWoOps
    private Step currentStep;
    private List<Step> nextSteps;

    public HydratedWorkItem(WorkItem workItem) {
        super(workItem.getId(), workItem.getVersion(), workItem.getUserId(), workItem.getModifiedDate(), workItem.getParentLineItem(), workItem.getLinkedWorkOrder(),
                workItem.getSerialNumber(), workItem.getQuantity(), workItem.getQuantityComplete(),
                workItem.getBalance(), workItem.getExpedite(), workItem.getSubsystem(),
                workItem.getPickAndPlace(), workItem.getProductionPlanning(), workItem.getStatus(),
                workItem.getStatusComments(), workItem.getManufacturingEngineer(), workItem.getCurrentTechnician(),
                workItem.getProgramPriority(), workItem.getTechnicianPriority(), workItem.getPolymericsPriority(),
                workItem.getInspectionPriority(), workItem.getDateComplete(), workItem.getKitPartDueDate(),
                workItem.getEstimateToComplete(), workItem.getEstimateToTest(), workItem.getEstimateReturnToAssembly(),
                workItem.getEeeKit(), workItem.getMechKit(), workItem.getComments(),
                workItem.getWorkOrderExists());
    }

    /*
     * 0 means the current object is = to the pass in object
     *
     * 1 means the current object is > to the pass in object
     *
     * -1 means the current object is < to the pass in object
     * */

    public HydratedWorkItem(AbstractWorkItem workItem) {
    }

    public void setNextSteps(List<Step> nextSteps) {
        nextSteps.sort(Comparator.comparingDouble(Step::getSequenceNumber));
        this.nextSteps = nextSteps;
    }

    @Override
    public int compareTo(HydratedWorkItem hydratedWorkItem) {
        if (hydratedWorkItem == null) {
            return 1;
        }
        if (this.getWorkAuthorizationSubmitDate() == null && hydratedWorkItem.getWorkAuthorizationSubmitDate() == null) {
            return 0;
        }
        if (this.getWorkAuthorizationSubmitDate() != null && hydratedWorkItem.getWorkAuthorizationSubmitDate() == null) {
            return 1;
        }
        if (this.getWorkAuthorizationSubmitDate() == null && hydratedWorkItem.getWorkAuthorizationSubmitDate() != null) {
            return -1;
        }
        return this.getWorkAuthorizationSubmitDate().compareTo(hydratedWorkItem.getWorkAuthorizationSubmitDate());
    }
}
