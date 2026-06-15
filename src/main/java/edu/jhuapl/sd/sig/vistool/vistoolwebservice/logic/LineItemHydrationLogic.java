package edu.jhuapl.sd.sig.vistool.vistoolwebservice.logic;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.AbstractLineItem;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.HydratedLineItem;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.LineItem;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.WorkItem;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.service.WorkItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LineItemHydrationLogic {
    @Autowired WorkItemService workItemService;

    public HydratedLineItem hydrateLineItem(AbstractLineItem lineItem) {
        HydratedLineItem hydratedLineItem = new HydratedLineItem(lineItem);
        List<WorkItem> workItems = workItemService.getAllWorkItemsByParentLineItem((LineItem) lineItem);
        hydratedLineItem.setWorkItems(workItems);
        return hydratedLineItem;
    }

    public List<HydratedLineItem> hydrateLineItems(List<AbstractLineItem> lineItems) {
        List<HydratedLineItem> hydratedLineItems = new ArrayList<>();
        for(AbstractLineItem lineItem : lineItems) {
            hydratedLineItems.add(hydrateLineItem(lineItem));
        }
        return hydratedLineItems;
    }
}
