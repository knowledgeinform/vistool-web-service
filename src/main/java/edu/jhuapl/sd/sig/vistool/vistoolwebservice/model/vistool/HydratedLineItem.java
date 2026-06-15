package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool;

import lombok.Data;

import java.util.List;

@Data
public class HydratedLineItem extends AbstractLineItem {
    private List<WorkItem> workItems;

    public HydratedLineItem(AbstractLineItem lineItem) {
        super(lineItem.getId(), lineItem.getVersion(), lineItem.getWorkAuthorizationNumber(),
                lineItem.getLineItemNumber(), lineItem.getQuantity(), lineItem.getWorkAuthorizationChangeStopDate(),
                lineItem.getWorkAuthorizationChangeTADate(), lineItem.getModifiedDate());
    }
}
