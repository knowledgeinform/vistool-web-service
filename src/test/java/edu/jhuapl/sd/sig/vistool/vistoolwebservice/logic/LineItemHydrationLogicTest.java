package edu.jhuapl.sd.sig.vistool.vistoolwebservice.logic;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.VistoolTestUtilities;
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
import org.springframework.test.context.ActiveProfiles;

import java.util.Collections;
import java.util.List;

@SpringBootTest
@MockBean(ScheduledTasks.class)
@MockBean(SecurityUtilities.class)
@ActiveProfiles({"local-dev-secure-h2"})
public class LineItemHydrationLogicTest {
    @Autowired private WorkItemService workItemService;
    @Autowired private LineItemService lineItemService;
    @Autowired private LineItemHydrationLogic lineItemHydrationLogic;

    private List<LineItem> lineItems;
    private List<WorkItem> workItems;

    @BeforeEach
    public void beforeEach() {
        lineItems = VistoolTestUtilities.createCompleteLineItems();
        workItems = VistoolTestUtilities.createCompleteWorkItems();
        lineItemService.saveLineItems(lineItems);
        workItemService.saveWorkItems(workItems, false);
    }

    @AfterEach
    public void afterEach() {
        workItemService.deleteAllWorkItems();
        lineItemService.deleteAllLineItems();
    }

    @Test
    public void testHydrateLineItem() {
        LineItem lineItem = lineItems.get(0);
        WorkItem workItem = workItems.get(0);
        HydratedLineItem hydratedLineItem1 = lineItemHydrationLogic.hydrateLineItem(lineItem);
        Assertions.assertEquals(lineItem.getId(), hydratedLineItem1.getId());
        Assertions.assertEquals(lineItem.getVersion(), hydratedLineItem1.getVersion());
        Assertions.assertEquals(lineItem.getWorkAuthorizationNumber(), hydratedLineItem1.getWorkAuthorizationNumber());
        Assertions.assertEquals(lineItem.getLineItemNumber(), hydratedLineItem1.getLineItemNumber());
        Assertions.assertEquals(lineItem.getQuantity(), hydratedLineItem1.getQuantity());
        Assertions.assertEquals(Collections.singletonList(workItem), hydratedLineItem1.getWorkItems());
    }
}
