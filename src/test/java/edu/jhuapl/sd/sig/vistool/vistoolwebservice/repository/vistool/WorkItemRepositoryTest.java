package edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.vistool;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.VistoolTestUtilities;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.LineItem;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.WorkItem;
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
import java.util.List;
import java.util.Optional;

import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.vistool.WorkItemRepository.*;
import static org.springframework.data.jpa.domain.Specification.where;

@SpringBootTest
@MockBean(ScheduledTasks.class)
@ActiveProfiles({"local-dev-secure-h2"})
public class WorkItemRepositoryTest {
    @Autowired private LineItemRepository lineItemRepository;
    @Autowired private WorkItemRepository workItemRepository;

    private List<LineItem> lineItems;
    private List<WorkItem> workItems;

    @BeforeEach
    public void beforeEach() {
        lineItems = VistoolTestUtilities.createCompleteLineItems();
        workItems = VistoolTestUtilities.createCompleteWorkItems();
        for(WorkItem workItem : workItems) {
            LineItem lineItem = workItem.getParentLineItem();
            lineItem.setVersion(lineItem.getVersion() - 1);
            workItem.setParentLineItem(lineItem);
        }
        lineItemRepository.saveAll(lineItems);
        workItemRepository.saveAll(workItems);
    }

    @AfterEach
    public void afterEach() {
        workItemRepository.deleteAll();
        lineItemRepository.deleteAll();
    }

    @Test
    public void testFindWorkItemById() {
        List<WorkItem> expected = Arrays.asList(workItems.get(0));
        List<WorkItem> actual = findAllWhereIdEqualTo(1L);
        Assertions.assertEquals(expected, actual);

        // expected = Arrays.asList(workItems.get(1), workItems.get(2));
        // actual = findAllWhereIdEqualTo(2L);
        // Assertions.assertEquals(expected, actual);

        // expected = Arrays.asList(workItems.get(3), workItems.get(4), workItems.get(5));
        // actual = findAllWhereIdEqualTo(3L);
        // Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFindAllWorkItemsWithGreatestId() {
        List<WorkItem> expected = Arrays.asList(workItems.get(5));
        List<WorkItem> actual = findAllWhereIdMaximum();
        Assertions.assertEquals(expected, actual);
    }

    // @Test
    // public void testFindAllWorkItemsWithVersionMaximum() {
    //     List<WorkItem> expected = Arrays.asList(workItems.get(0), workItems.get(2), workItems.get(5));
    //     List<WorkItem> actual = findAllWhereVersionMaximum();
    //     Assertions.assertEquals(expected, actual);
    // }

    // @Test
    // public void testFindWorkItemByIdWithGreatestVersion() {
    //     WorkItem expected = workItems.get(0);
    //     WorkItem actual = findOneWhereIdEqualToAndVersionMaximum(1L).get();
    //     Assertions.assertEquals(expected, actual);

    //     expected = workItems.get(2);
    //     actual = findOneWhereIdEqualTo(2L).get();
    //     Assertions.assertEquals(expected, actual);

    //     expected = workItems.get(5);
    //     actual = findOneWhereIdEqualTo(3L).get();
    //     Assertions.assertEquals(expected, actual);
    // }

    @Test
    public void testFindWorkItemByIdAndVersion() {
        WorkItem expected = workItems.get(0);
        WorkItem actual = findOneWhereIdEqualTo(1L).get();
        Assertions.assertEquals(expected, actual);

        expected = workItems.get(1);
        actual = findOneWhereIdEqualTo(2L).get();
        Assertions.assertEquals(expected, actual);

        expected = workItems.get(2);
        actual = findOneWhereIdEqualTo(2L).get();
        Assertions.assertEquals(expected, actual);

        expected = workItems.get(3);
        actual = findOneWhereIdEqualTo(3L).get();
        Assertions.assertEquals(expected, actual);

        expected = workItems.get(4);
        actual = findOneWhereIdEqualTo(3L).get();
        Assertions.assertEquals(expected, actual);

        expected = workItems.get(5);
        actual = findOneWhereIdEqualTo(3L).get();
        Assertions.assertEquals(expected, actual);
    }

    private List<WorkItem> findAllWhereIdEqualTo(Long id) {
        return workItemRepository.findAll(
            where(
                idEqualTo(id)
            )
        );
    }

    private List<WorkItem> findAllWhereIdMaximum() {
        return workItemRepository.findAll(
            where(
                idMaximum()
            )
        );
    }

    // private List<WorkItem> findAllWhereVersionMaximum() {
    //     return workItemRepository.findAll(
    //         where(
    //             versionMaximum()
    //         )
    //     );
    // }

    // private Optional<WorkItem> findOneWhereIdEqualToAndVersionMaximum(Long id) {
    //     return workItemRepository.findOne(
    //         where(
    //             idEqualTo(id)
    //             .and(versionMaximum())
    //         )
    //     );
    // }

    private Optional<WorkItem> findOneWhereIdEqualTo(Long id) {
        return workItemRepository.findOne(
            where(
                idEqualTo(id)
            )
        );
    }
}
