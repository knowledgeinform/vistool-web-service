package edu.jhuapl.sd.sig.vistool.vistoolwebservice.logic;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.*;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.AbstractWorkItem;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.HydratedWorkItem;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.Step;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.WorkItem;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.service.DenodoService;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.VistoolUtilities;
import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.constants.denodo.DenodoServiceConstants.R1J_MINIMUM_SEQUENCE_NUMBER;

@Log4j2
@Component
public class WorkItemHydrationLogic {
    @Autowired DenodoService denodoService;

    /* WorkItem objects are currently hydrated using the following Denodo services:
       1. VmSysWorkAuth
       2. VmSysWorkAuthDetail
       3. VeWo
       4. DimHRPerson
    */
    public HydratedWorkItem hydrateWorkItem(AbstractWorkItem workItem) {
        HydratedWorkItem hydratedWorkItem = new HydratedWorkItem((WorkItem) workItem);
        hydrateWithVmSysWorkAuthData(hydratedWorkItem);
        hydrateWithVeWoData(hydratedWorkItem);
        hydrateWithVeWoOpsData(hydratedWorkItem);
        return hydratedWorkItem;
    }

    public List<HydratedWorkItem> hydrateWorkItems(List<AbstractWorkItem> workItems) {
        List<HydratedWorkItem> hydratedWorkItems = new ArrayList<>();
        for(AbstractWorkItem workItem : workItems) {
            hydratedWorkItems.add(hydrateWorkItem(workItem));
        }
        return hydratedWorkItems;
    }

    private void hydrateWithVmSysWorkAuthData(HydratedWorkItem hydratedWorkItem) {
        Optional<VmSysWorkAuthDetailChangeHistoryVistool> optionalVmSysWorkAuth = denodoService
                .getVmSysWorkAuthDetailWithSpecifiedValues(
                        hydratedWorkItem.getParentLineItem().getWorkAuthorizationNumber(),
                        hydratedWorkItem.getParentLineItem().getLineItemNumber());

        if(optionalVmSysWorkAuth.isPresent()) {
            VmSysWorkAuthDetailChangeHistoryVistool vmSysWorkAuth = optionalVmSysWorkAuth.get();

            hydratedWorkItem.setWorkAuthorizationDepartmentID(vmSysWorkAuth.getDepartmentId());

            Optional<DimHRPerson> optionalDimHRPerson = denodoService.getDimHRPersonWithPersonNumber(vmSysWorkAuth.getCustomer());
            if(optionalDimHRPerson.isPresent()) {
                hydratedWorkItem.setWorkAuthorizationCustomer(optionalDimHRPerson.get().getPreferredFullName());
            }

            hydratedWorkItem.setWorkAuthorizationSubmitDate(vmSysWorkAuth.getSubmitDate());
            hydratedWorkItem.setWorkAuthorizationDescription(vmSysWorkAuth.getDescription());
            hydratedWorkItem.setWorkAuthorizationFlowId(vmSysWorkAuth.getChangeLineFlow() != null ? vmSysWorkAuth.getChangeLineFlow() : vmSysWorkAuth.getWorkAuthorizationFlowId());
            hydratedWorkItem.setWorkAuthorizationTaskAuthorization(vmSysWorkAuth.getChangeTa() != null ? vmSysWorkAuth.getChangeTa() : vmSysWorkAuth.getDetailTa());
            hydratedWorkItem.setWorkAuthorizationPartNumber(vmSysWorkAuth.getChangeLinePartId() != null ? vmSysWorkAuth.getChangeLinePartId() : vmSysWorkAuth.getPartId());
            hydratedWorkItem.setWorkAuthorizationRevision(vmSysWorkAuth.getChangeLinePartRevision() != null ? vmSysWorkAuth.getChangeLinePartRevision() : vmSysWorkAuth.getRevision());
            hydratedWorkItem.setWorkAuthorizationDueDate(vmSysWorkAuth.getChangeLineNeedDate() != null ? vmSysWorkAuth.getChangeLineNeedDate() : vmSysWorkAuth.getWantDate());
        }
    }

    private void hydrateWithVeWoData(HydratedWorkItem hydratedWorkItem) {
        if(!VistoolUtilities.isStringNullOrEmpty(hydratedWorkItem.getLinkedWorkOrder())) {
            Optional<VeWo> optionalVeWo = denodoService.getVeWoWithWorkOrderNumber(hydratedWorkItem.getLinkedWorkOrder());
            if(optionalVeWo.isPresent()){
                VeWo veWo = optionalVeWo.get();
                hydratedWorkItem.setWorkOrderSerialNumber(veWo.getSerialNumber());
                hydratedWorkItem.setWorkOrderNumber(veWo.getWorkOrderNumber());
            }
        }
    }

    private void hydrateWithVeWoOpsData(HydratedWorkItem hydratedWorkItem) {
        if(!VistoolUtilities.isStringNullOrEmpty(hydratedWorkItem.getLinkedWorkOrder())) {
            List<VeWoOps> veWoOpsList = null;
            Optional<VeWoOps> optionalVeWoOps = denodoService.findCurrentStep(hydratedWorkItem.getLinkedWorkOrder());
            Step step = null;
            if(optionalVeWoOps.isPresent()) {
                VeWoOps veWoOps = optionalVeWoOps.get();
                step = new Step(preformatStep(veWoOps), veWoOps.getOperationType(), veWoOps.getResourceID(),
                        veWoOps.getSequenceNumber(), veWoOps.getStatus());
                veWoOpsList = denodoService.findNextSteps(hydratedWorkItem.getLinkedWorkOrder(), veWoOps.getSequenceNumber());
            }
            else {
                veWoOpsList = denodoService.findNextSteps(hydratedWorkItem.getLinkedWorkOrder(), R1J_MINIMUM_SEQUENCE_NUMBER );
            }
            hydratedWorkItem.setCurrentStep(step != null ? step : new Step("N/A", null, null, null, null));
            List<Step> nextSteps = new ArrayList<>();
            if(veWoOpsList != null && !veWoOpsList.isEmpty()) {

                for (VeWoOps veWoOps : veWoOpsList) {
                    step = new Step(preformatStep(veWoOps), veWoOps.getOperationType(), veWoOps.getResourceID(),
                            veWoOps.getSequenceNumber(), veWoOps.getStatus());
                    nextSteps.add(step);
                }
            } else {
                nextSteps.add(new Step("N/A", null, null, null, null));
            }
            hydratedWorkItem.setNextSteps(nextSteps);
        }
    }

    private String preformatStep(VeWoOps veWoOps) {
        return String.format("%s %s %s %s",
                veWoOps.getStatus(),
                new DecimalFormat("#").format(veWoOps.getSequenceNumber()),
                VistoolUtilities.nullToString(veWoOps.getOperationType()).replaceAll(",", " "),
                veWoOps.getResourceID());
    }
}
