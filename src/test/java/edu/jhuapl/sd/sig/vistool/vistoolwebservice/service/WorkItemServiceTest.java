package edu.jhuapl.sd.sig.vistool.vistoolwebservice.service;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.VistoolTestUtilities;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.logic.WorkItemHydrationLogic;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.HydratedWorkItem;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.LineItem;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.VistoolUser;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.WorkItem;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.WorkItemConflict;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.concurrentediting.ConcurrentEditingMessage;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.configuration.vistool.WebSocketTopic.WORK_ORDER_SAVED;

@SpringBootTest
@MockBean(ScheduledTasks.class)
@MockBean(SecurityUtilities.class)
@ActiveProfiles({"local-dev-secure-h2"})
public class WorkItemServiceTest {
    @Autowired
    private WorkItemService workItemService;
    @Autowired
    private LineItemService lineItemService;
    @Autowired
    private WorkItemHydrationLogic workItemHydrationLogic;

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
    // public void testGetAllWorkItemsWithMaxVersion() {
    //     List<WorkItem> expected = Arrays.asList(workItems.get(0), workItems.get(2), workItems.get(5));
    //     List<WorkItem> actual = workItemService.getAllWorkItems();
    //     Assertions.assertEquals(expected, actual);
    // }

    @Test
    public void testGetWorkItemWithMaxVersionById() {
        WorkItem expected = workItems.get(0);
        WorkItem actual = workItemService.getWorkItemById(1L).get();
        Assertions.assertEquals(expected, actual);

        expected = workItems.get(2);
        actual = workItemService.getWorkItemById(2L).get();
        Assertions.assertEquals(expected, actual);

        expected = workItems.get(5);
        actual = workItemService.getWorkItemById(3L).get();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetAllWorkItemVersionsById() {
        List<WorkItem> expected = Arrays.asList(workItems.get(0));
        List<WorkItem> actual = Arrays.asList(workItemService.getWorkItemById(1L).get());
        Assertions.assertEquals(expected, actual);

        // expected = Arrays.asList(workItems.get(1), workItems.get(2));
        // actual = Arrays.asList(workItemService.getWorkItemById(2L).get());
        // Assertions.assertEquals(expected, actual);

        // expected = Arrays.asList(workItems.get(3), workItems.get(4), workItems.get(5));
        // actual = Arrays.asList(workItemService.getWorkItemById(3L).get());
        // Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetAllWorkItemsWithMaxVersionByParentLineItem() {
        List<WorkItem> expected = Arrays.asList(workItems.get(0));
        List<WorkItem> actual = workItemService.getAllWorkItemsByParentLineItem(lineItems.get(0));
        Assertions.assertEquals(expected, actual);

        expected = Arrays.asList(workItems.get(2));
        actual = workItemService.getAllWorkItemsByParentLineItem(lineItems.get(2));
        Assertions.assertEquals(expected, actual);

        expected = Arrays.asList(workItems.get(5));
        actual = workItemService.getAllWorkItemsByParentLineItem(lineItems.get(5));
        Assertions.assertEquals(expected, actual);
    }

    // @Test
    // public void testGetAllHydratedWorkItemsWithMaxVersion() {
    //     List<HydratedWorkItem> expected = Arrays.asList(
    //         workItemHydrationLogic.hydrateWorkItem(workItems.get(0)),
    //         workItemHydrationLogic.hydrateWorkItem(workItems.get(2)),
    //         workItemHydrationLogic.hydrateWorkItem(workItems.get(5))
    //     );
    //     List<HydratedWorkItem> actual = workItemService.getAllHydratedWorkItems();
    //     Assertions.assertEquals(expected, actual);
    // }

    @Test
    public void testGetHydratedWorkItemWithMaxVersionById() {
        HydratedWorkItem expected = workItemHydrationLogic.hydrateWorkItem(workItems.get(0));
        HydratedWorkItem actual = workItemService.getHydratedWorkItemById(1L).get();
        Assertions.assertEquals(expected, actual);

        expected = workItemHydrationLogic.hydrateWorkItem(workItems.get(2));
        actual = workItemService.getHydratedWorkItemById(2L).get();
        Assertions.assertEquals(expected, actual);

        expected = workItemHydrationLogic.hydrateWorkItem(workItems.get(5));
        actual = workItemService.getHydratedWorkItemById(3L).get();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getAllHydratedWorkItemVersionsById() {
        List<HydratedWorkItem> expected = Arrays.asList(workItemHydrationLogic.hydrateWorkItem(workItems.get(0)));
        List<HydratedWorkItem> actual = workItemService.getAllHydratedWorkItemVersionsById(1L);
        Assertions.assertEquals(expected, actual);

        // expected = Arrays.asList(
        //     workItemHydrationLogic.hydrateWorkItem(workItems.get(1)),
        //     workItemHydrationLogic.hydrateWorkItem(workItems.get(2))
        // );
        // actual = workItemService.getAllHydratedWorkItemVersionsById(2L);
        // Assertions.assertEquals(expected, actual);

        // expected = Arrays.asList(
        //     workItemHydrationLogic.hydrateWorkItem(workItems.get(3)),
        //     workItemHydrationLogic.hydrateWorkItem(workItems.get(4)),
        //     workItemHydrationLogic.hydrateWorkItem(workItems.get(5))
        // );
        // actual = workItemService.getAllHydratedWorkItemVersionsById(3L);
        // Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetAllHydratedWorkItemsWithMaxVersionByParentLineItem() {
        List<HydratedWorkItem> expected = Arrays.asList(workItemHydrationLogic.hydrateWorkItem(workItems.get(0)));
        List<HydratedWorkItem> actual = workItemService.getAllHydratedWorkItemsByParentLineItem(lineItems.get(0));
        Assertions.assertEquals(expected, actual);

        expected = Arrays.asList(workItemHydrationLogic.hydrateWorkItem(workItems.get(2)));
        actual = workItemService.getAllHydratedWorkItemsByParentLineItem(lineItems.get(2));
        Assertions.assertEquals(expected, actual);

        Arrays.asList(workItemHydrationLogic.hydrateWorkItem(workItems.get(5)));
        workItemService.getAllHydratedWorkItemsByParentLineItem(lineItems.get(5));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSaveWorkItem() {
        testSave(false);
    }

    @Test
    public void testSaveWorkItems() {
        testSave(true);
    }

    @Test
    public void testMergeAndSaveWorkItemPreservesNonConflictingLatestChanges() {
        WorkItem originalWorkItem = VistoolTestUtilities.clone(workItems.get(0));

        WorkItem latestWorkItem = VistoolTestUtilities.clone(workItems.get(0));
        latestWorkItem.setStatusComments("saved by another user");
        workItemService.saveWorkItem(latestWorkItem, false);

        WorkItem userEditedWorkItem = VistoolTestUtilities.clone(originalWorkItem);
        userEditedWorkItem.setComments("my updated comment");

        WorkItem savedWorkItem = workItemService.mergeAndSaveWorkItem(userEditedWorkItem, originalWorkItem, false);

        Assertions.assertEquals("saved by another user", savedWorkItem.getStatusComments());
        Assertions.assertEquals("my updated comment", savedWorkItem.getComments());
    }

    @Test
    public void testMergeAndSaveWorkItemDetectsConflicts() {
        WorkItem originalWorkItem = VistoolTestUtilities.clone(workItems.get(0));

        WorkItem latestWorkItem = VistoolTestUtilities.clone(workItems.get(0));
        latestWorkItem.setStatusComments("saved by another user");
        workItemService.saveWorkItem(latestWorkItem, false);

        WorkItem userEditedWorkItem = VistoolTestUtilities.clone(originalWorkItem);
        userEditedWorkItem.setStatusComments("my conflicting update");

        WorkItemConflictException exception = Assertions.assertThrows(
            WorkItemConflictException.class,
            () -> workItemService.mergeAndSaveWorkItem(userEditedWorkItem, originalWorkItem, false)
        );

        WorkItemConflict workItemConflict = exception.getWorkItemConflict();
        Assertions.assertEquals(workItems.get(0).getId(), workItemConflict.getWorkItemId());
        Assertions.assertEquals(List.of("statusComments"), workItemConflict.getConflictingFields());
    }

    @Test
    public void testMergeAndSaveWorkItemDoesNotConflictWhenLatestMatchesEditedValue() {
        WorkItem originalWorkItem = VistoolTestUtilities.clone(workItems.get(0));

        WorkItem latestWorkItem = VistoolTestUtilities.clone(workItems.get(0));
        latestWorkItem.setStatusComments("new");
        workItemService.saveWorkItem(latestWorkItem, false);

        WorkItem userEditedWorkItem = VistoolTestUtilities.clone(originalWorkItem);
        userEditedWorkItem.setStatusComments("new");
        userEditedWorkItem.setComments("my updated comment");

        WorkItem savedWorkItem = workItemService.mergeAndSaveWorkItem(userEditedWorkItem, originalWorkItem, false);

        Assertions.assertEquals("new", savedWorkItem.getStatusComments());
        Assertions.assertEquals("my updated comment", savedWorkItem.getComments());
    }

    @Test
    public void testMergeAndSaveWorkItemDetectsNestedFieldConflicts() {
        WorkItem originalWorkItem = VistoolTestUtilities.clone(workItems.get(0));

        WorkItem latestWorkItem = VistoolTestUtilities.clone(workItems.get(0));
        latestWorkItem.getPickAndPlace().setPickAndPlaceNotes("saved by another user");
        workItemService.saveWorkItem(latestWorkItem, false);

        WorkItem userEditedWorkItem = VistoolTestUtilities.clone(originalWorkItem);
        userEditedWorkItem.getPickAndPlace().setPickAndPlaceNotes("my conflicting update");

        WorkItemConflictException exception = Assertions.assertThrows(
                WorkItemConflictException.class,
                () -> workItemService.mergeAndSaveWorkItem(userEditedWorkItem, originalWorkItem, false)
        );

        Assertions.assertEquals(List.of("pickAndPlace.pickAndPlaceNotes"), exception.getWorkItemConflict().getConflictingFields());
    }

    @Test
    public void testDeleteWorkItem() {
        workItemService.deleteWorkItem(workItems.get(0));
        Assertions.assertEquals(Optional.empty(), workItemService.getWorkItemById(1L).empty());
    }

    @Test
    public void testDeleteAllWorkItems() {
        workItemService.deleteAllWorkItems();
        List<WorkItem> expected = Collections.emptyList();
        List<WorkItem> actual = workItemService.getAllWorkItems();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testPublishConcurrentEditingToWebSocket() {
        Assertions.assertDoesNotThrow(() -> {
            WorkItem workItem = new WorkItem();
            workItem.setId(new Random().nextLong());
            workItem.setVersion(new Random().nextLong());

            ConcurrentEditingMessage concurrentEditingMessage = new ConcurrentEditingMessage(new VistoolUser("test", "test", new ArrayList<>()));
            concurrentEditingMessage.setWorkItemId(workItem.getId());
            concurrentEditingMessage.setValue(workItem.getVersion());

            workItemService.publishMessagesToWebSocket(concurrentEditingMessage, WORK_ORDER_SAVED);
        });
    }

    private void testSave(boolean batched) {
        workItemService.deleteAllWorkItems();
        lineItemService.deleteAllLineItems();

        List<LineItem> incompleteLineItems = VistoolTestUtilities.createIncompleteLineItems();
        List<WorkItem> incompleteWorkItems = VistoolTestUtilities.createIncompleteWorkItems();

        if(batched) {
            lineItemService.saveLineItems(incompleteLineItems);
            workItemService.saveWorkItems(incompleteWorkItems, false);
        }
        else {
            for(LineItem lineItem : incompleteLineItems) {
                lineItemService.saveLineItem(lineItem);
            }
           for(WorkItem workItem : incompleteWorkItems) {
               workItemService.saveWorkItem(workItem, false);
           }
        }

        incompleteLineItems.get(0).setId(1L);
        incompleteLineItems.get(1).setId(2L);
        incompleteWorkItems.get(0).setId(1L);
        incompleteWorkItems.get(1).setId(2L);

        List<WorkItem> expected = Arrays.asList(incompleteWorkItems.get(0));
        List<WorkItem> actual = Arrays.asList(workItemService.getWorkItemById(1L).get());
        Assertions.assertEquals(expected, actual);

        expected = Arrays.asList(incompleteWorkItems.get(1));
        actual = Arrays.asList(workItemService.getWorkItemById(2L).get());
        Assertions.assertEquals(expected, actual);
    }
}
