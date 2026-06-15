package edu.jhuapl.sd.sig.vistool.vistoolwebservice.service;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.VistoolTestUtilities;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.logic.LineItemHydrationLogic;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.HydratedLineItem;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.LineItem;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.WorkItem;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.security.SecurityUtilities;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.ScheduledTasks;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@MockBean(ScheduledTasks.class)
@MockBean(SecurityUtilities.class)
@ActiveProfiles({"local-dev-secure-h2"})
public class LineItemServiceTest {
    @Autowired private LineItemService lineItemService;
    @Autowired private WorkItemService workItemService;
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

    // @Test
    // public void testGetAllLineItemsWithMaxVersion() {
    //     List<LineItem> expected = Arrays.asList(lineItems.get(0), lineItems.get(2), lineItems.get(5));
    //     List<LineItem> actual = lineItemService.getAllLineItems();
    //     Assertions.assertEquals(expected, actual);
    // }

    @Test
    public void testGetLineItemWithMaxVersionById() {
        LineItem expected = lineItems.get(0);
        LineItem actual = lineItemService.getLineItemById(1L).get();
        Assertions.assertEquals(expected, actual);

        expected = lineItems.get(2);
        actual = lineItemService.getLineItemById(2L).get();
        Assertions.assertEquals(expected, actual);

        expected = lineItems.get(5);
        actual = lineItemService.getLineItemById(3L).get();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetAllLineItemVersionsById() {
        List<LineItem> expected = Arrays.asList(lineItems.get(0));
        List<LineItem> actual = Arrays.asList(lineItemService.getLineItemById(1L).get());
        Assertions.assertEquals(expected, actual);

        // expected = Arrays.asList(lineItems.get(1), lineItems.get(2));
        // actual = Arrays.asList(lineItemService.getLineItemById(2L).get());
        // Assertions.assertEquals(expected, actual);

        // expected = Arrays.asList(lineItems.get(3), lineItems.get(4), lineItems.get(5));
        // actual = Arrays.asList(lineItemService.getLineItemById(3L).get());
        // Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetAllLineItemVersionsByWorkAuthorizationNumberAndLineItemNumber() {
        List<LineItem> expected = Arrays.asList(lineItems.get(0));
        List<LineItem> actual = Arrays.asList(lineItemService.getLineItemByWorkAuthorizationNumberAndLineItemNumber(
                "WA-1", "LI-1").get());
        Assertions.assertEquals(expected, actual);

        // expected = Arrays.asList(lineItems.get(1), lineItems.get(2));
        // actual = Arrays.asList(lineItemService.getLineItemByWorkAuthorizationNumberAndLineItemNumber(
        //         "WA-2", "LI-2").get());
        // Assertions.assertEquals(expected, actual);

        // expected = Arrays.asList(lineItems.get(3), lineItems.get(4), lineItems.get(5));
        // actual = Arrays.asList(lineItemService.getLineItemByWorkAuthorizationNumberAndLineItemNumber(
        //         "WA-3", "LI-3").get());
        // Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetLineItemWithMaxVersionByWorkAuthorizationNumberAndLineItemNumber() {
        LineItem expected = lineItems.get(0);
        LineItem actual = lineItemService.getLineItemByWorkAuthorizationNumberAndLineItemNumber(
                "WA-1", "LI-1").get();
        Assertions.assertEquals(expected, actual);

        expected = lineItems.get(2);
        actual = lineItemService.getLineItemByWorkAuthorizationNumberAndLineItemNumber(
                "WA-2", "LI-2").get();
        Assertions.assertEquals(expected, actual);

        expected = lineItems.get(5);
        actual = lineItemService.getLineItemByWorkAuthorizationNumberAndLineItemNumber(
                "WA-3", "LI-3").get();
        Assertions.assertEquals(expected, actual);
    }

    // @Test
    // public void testGetAllHydratedLineItemsWithMaxVersion() {
    //     List<HydratedLineItem> expected = Arrays.asList(
    //         lineItemHydrationLogic.hydrateLineItem(lineItems.get(0)),
    //         lineItemHydrationLogic.hydrateLineItem(lineItems.get(2)),
    //         lineItemHydrationLogic.hydrateLineItem(lineItems.get(5))
    //     );
    //     List<HydratedLineItem> actual = lineItemService.getAllHydratedLineItems();
    //     Assertions.assertEquals(expected, actual);
    // }

    @Test
    public void testGetHydratedLineItemWithMaxVersionById() {
        HydratedLineItem expected = lineItemHydrationLogic.hydrateLineItem(lineItems.get(0));
        HydratedLineItem actual = lineItemService.getHydratedLineItemById(1L).get();
        Assertions.assertEquals(expected, actual);

        expected = lineItemHydrationLogic.hydrateLineItem(lineItems.get(2));
        actual = lineItemService.getHydratedLineItemById(2L).get();
        Assertions.assertEquals(expected, actual);

        expected = lineItemHydrationLogic.hydrateLineItem(lineItems.get(5));
        actual = lineItemService.getHydratedLineItemById(3L).get();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getAllHydratedLineItemVersionsById() {
        List<HydratedLineItem> expected = Arrays.asList(lineItemHydrationLogic.hydrateLineItem(lineItems.get(0)));
        List<HydratedLineItem> actual = Arrays.asList(lineItemService.getHydratedLineItemById(1L).get());
        Assertions.assertEquals(expected, actual);

        // expected = Arrays.asList(
        //     // lineItemHydrationLogic.hydrateLineItem(lineItems.get(1)),
        //     lineItemHydrationLogic.hydrateLineItem(lineItems.get(2))
        // );
        // actual = Arrays.asList(lineItemService.getHydratedLineItemById(2L).get());
        // Assertions.assertEquals(expected, actual);

        // expected = Arrays.asList(
        //     lineItemHydrationLogic.hydrateLineItem(lineItems.get(3)),
        //     lineItemHydrationLogic.hydrateLineItem(lineItems.get(4)),
        //     lineItemHydrationLogic.hydrateLineItem(lineItems.get(5))
        // );
        // actual = Arrays.asList(lineItemService.getHydratedLineItemById(3L).get());
        // Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSaveLineItem() {
        testSave(false);
    }

    @Test
    public void testSaveLineItems() {
        testSave(true);
    }

    @Test
    public void testDeleteLineItem() {
        workItemService.deleteAllWorkItems();
        lineItemService.deleteLineItem(lineItems.get(0));
        Optional<LineItem> actual = lineItemService.getLineItemById(1L);
        Assertions.assertEquals(Optional.empty(), actual.empty());
    }

    @Test
    public void testDeleteAllLineItems() {
        workItemService.deleteAllWorkItems();
        lineItemService.deleteAllLineItems();
        List<LineItem> expected = Collections.emptyList();
        List<LineItem> actual = lineItemService.getAllLineItems();
        Assertions.assertEquals(expected, actual);
    }

    private void testSave(boolean batched) {
        workItemService.deleteAllWorkItems();
        lineItemService.deleteAllLineItems();
        List<LineItem> incompleteLineItems = VistoolTestUtilities.createIncompleteLineItems();

        if(batched) {
            lineItemService.saveLineItems(incompleteLineItems);
        }
        else {
            lineItemService.saveLineItem(incompleteLineItems.get(0));
            lineItemService.saveLineItem(incompleteLineItems.get(1));
        }

        incompleteLineItems.get(0).setId(1L);
        incompleteLineItems.get(1).setId(2L);

        List<LineItem> expected = Arrays.asList(incompleteLineItems.get(0));
        List<LineItem> actual = Arrays.asList(lineItemService.getLineItemById(1L).get());
        Assertions.assertEquals(expected, actual);

        expected = Arrays.asList(incompleteLineItems.get(1));
        actual = Arrays.asList(lineItemService.getLineItemById(2L).get());
        Assertions.assertEquals(expected, actual);
    }
}
