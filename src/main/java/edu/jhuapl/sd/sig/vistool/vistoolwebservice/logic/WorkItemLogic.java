package edu.jhuapl.sd.sig.vistool.vistoolwebservice.logic;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.VeWo;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.*;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.Status;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.service.WorkItemService;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Log4j2
@Component
public class WorkItemLogic {
    @Autowired private LineItemLogic lineItemLogic;
    @Autowired private WorkItemService workItemService;

    private PickAndPlace createDefaultPickAndPlace() {
        PickAndPlace pickAndPlace = new PickAndPlace();
        // Set loading priorities to default value to ensure P&P object is not null
        pickAndPlace.setLoadingPriorities(LoadingPriorities.TBD);
        return pickAndPlace;
    }

    private ProductionPlanning createDefaultProductionPlanning() {
        ProductionPlanning productionPlanning = new ProductionPlanning();
        productionPlanning.setProductionPlanning(false);
        return productionPlanning;
    }

    private WorkItem createNewWorkItem(LineItem lineItem, Optional<Integer> quantity, Optional<Status> optionalStatus) {
        WorkItem workItem = new WorkItem();
        workItem.setParentLineItem(lineItem);
        if(quantity.isPresent()) {
            workItem.setQuantity(quantity.get());
        }
        else {
            workItem.setQuantity(lineItem.getQuantity());
        }
        workItem.setPickAndPlace(createDefaultPickAndPlace());
        workItem.setProductionPlanning(createDefaultProductionPlanning());
        optionalStatus.ifPresent(workItem::setStatus);

        if(lineItemLogic.checkIfWorkAuthorizationInInitialCompletedSet(lineItem.getWorkAuthorizationNumber())) {
            workItem.setStatus(Status.COMPLETED);
            workItem.setStatusComments("Status auto-assigned to completed based on 12/30/21 R1J Spreadsheet.");
        }
        return workItem;
    }

    public WorkItem createAndSaveNewWorkItem(LineItem lineItem, Optional<Integer> quantity, Optional<Status> status) {
        return workItemService.saveWorkItem(createNewWorkItem(lineItem, quantity, status), false);
    }

    public List<WorkItem> setParentLineItemForRelatedWorkItems(LineItem oldLineItem, LineItem newLineItem) {
        List<WorkItem> workItems = workItemService.getAllWorkItemsByParentLineItem(oldLineItem);
        for(WorkItem workItem : workItems) {
            workItem.setParentLineItem(newLineItem);
        }
        return workItems;
    }

    public List<WorkItem> setStatusAndCommentForRelatedWorkItems(List<WorkItem> workItems, Status status, String statusComments) {
        for(WorkItem workItem : workItems) {
            workItem.setStatus(status);
            if(StringUtils.isBlank(workItem.getStatusComments())) {
                workItem.setStatusComments(statusComments);
            }
            else {
                workItem.setStatusComments(workItem.getStatusComments() + " -- " + statusComments);
            }
        }
        return workItems;
    }

    /**
     * This method checks to see if the WA number for the line item is contained within the work order WA number.
     * Note that WO WA numbers are not necessarily an exact match to the id coming from a WA, but the WA id should be
     * contained within the WO WA id String.
     * Per R1J 2022-09-29, only match WA ids, not part numbers or anything else.
     * @param workOrder
     * @param workItem
     * @return
     */
    public boolean canLinkWorkOrderToWorkItem(VeWo workOrder, WorkItem workItem) {
        String workOrderWA = workOrder.getWorkAuthorization();
        String workItemWA = workItem.getParentLineItem().getWorkAuthorizationNumber();

        if (workOrderWA == null || workItemWA == null) {
            return false;
        } else
        {
            return workOrderWA.contains(workItemWA);
        }
    }
}
