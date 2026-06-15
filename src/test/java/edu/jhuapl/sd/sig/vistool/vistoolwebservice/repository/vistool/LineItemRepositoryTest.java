package edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.vistool;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.VistoolTestUtilities;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.LineItem;
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

import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.vistool.LineItemRepository.*;
import static org.springframework.data.jpa.domain.Specification.where;

@SpringBootTest
@MockBean(ScheduledTasks.class)
@ActiveProfiles({"local-dev-secure-h2"})
public class LineItemRepositoryTest {
    @Autowired private LineItemRepository lineItemRepository;

    private List<LineItem> lineItems;

    @BeforeEach
    public void beforeEach() {
        lineItems = VistoolTestUtilities.createCompleteLineItems();
        lineItemRepository.saveAll(lineItems);
    }

    @AfterEach
    public void afterEach() {
        lineItemRepository.deleteAll();
    }

    @Test
    public void testFindLineItemById() {
        List<LineItem> expected = Arrays.asList(lineItems.get(0));
        List<LineItem> actual = findAllWhereIdEqualTo(1L);
        Assertions.assertEquals(expected, actual);

        // expected = Arrays.asList(lineItems.get(1), lineItems.get(2));
        // actual = findAllWhereIdEqualTo(2L);
        // Assertions.assertEquals(expected, actual);

        // expected = Arrays.asList(lineItems.get(3), lineItems.get(4), lineItems.get(5));
        // actual = findAllWhereIdEqualTo(3L);
        // Assertions.assertEquals(expected, actual);
    }

    // @Test
    // public void testFindAllLineItemsWithGreatestId() {
    //     List<LineItem> expected = Arrays.asList(lineItems.get(3), lineItems.get(4), lineItems.get(5));
    //     List<LineItem> actual = findAllWhereIdMaximum();
    //     Assertions.assertEquals(expected, actual);
    // }

    // @Test
    // public void testFindAllLineItemsWithGreatestVersion() {
    //     List<LineItem> expected = Arrays.asList(lineItems.get(0), lineItems.get(2), lineItems.get(5));
    //     List<LineItem> actual = findAllWhereVersionMaximum();
    //     Assertions.assertEquals(expected, actual);
    // }

    // @Test
    // public void testFindLineItemByIdWithGreatestVersion() {
    //     LineItem expected = lineItems.get(0);
    //     LineItem actual = findOneWhereIdEqualToAndVersionMaximum(1L).get();
    //     Assertions.assertEquals(expected, actual);

    //     expected = lineItems.get(2);
    //     actual = findOneWhereIdEqualToAndVersionMaximum(2L).get();
    //     Assertions.assertEquals(expected, actual);

    //     expected = lineItems.get(5);
    //     actual = findOneWhereIdEqualToAndVersionMaximum(3L).get();
    //     Assertions.assertEquals(expected, actual);
    // }

    @Test
    public void testFindLineItemByIdAndVersion() {
        LineItem expected = lineItems.get(0);
        LineItem actual = findOneWhereIdEqualToAndVersionEqualTo(1L, 0L).get();
        Assertions.assertEquals(expected, actual);

        // expected = lineItems.get(1);
        // actual = findOneWhereIdEqualToAndVersionEqualTo(2L, 0L).get();
        // Assertions.assertEquals(expected, actual);

        // expected = lineItems.get(2);
        // actual = findOneWhereIdEqualToAndVersionEqualTo(3L, 0L).get();
        // Assertions.assertEquals(expected, actual);

        // expected = lineItems.get(3);
        // actual = findOneWhereIdEqualToAndVersionEqualTo(4L, 1L).get();
        // Assertions.assertEquals(expected, actual);

        // expected = lineItems.get(4);
        // actual = findOneWhereIdEqualToAndVersionEqualTo(5L, 2L).get();
        // Assertions.assertEquals(expected, actual);

        // expected = lineItems.get(5);
        // actual = findOneWhereIdEqualToAndVersionEqualTo(6L, 3L).get();
        // Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findLineItemsByWorkAuthorizationNumberAndLineItemNumber() {
        List<LineItem> expected = Arrays.asList(lineItems.get(0));
        List<LineItem> actual = findAllWhereWorkAuthorizationNumberAndLineItemNumberEqualTo("WA-1",
                "LI-1");
        Assertions.assertEquals(expected, actual);

        // expected = Arrays.asList(lineItems.get(1), lineItems.get(2));
        // actual = findAllWhereWorkAuthorizationNumberAndLineItemNumberEqualTo("WA-2",
        //         "LI-2");
        // Assertions.assertEquals(expected, actual);

        // expected = Arrays.asList(lineItems.get(3), lineItems.get(4), lineItems.get(5));
        // actual = findAllWhereWorkAuthorizationNumberAndLineItemNumberEqualTo("WA-3",
        //         "LI-3");
        // Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findLineItemByWorkAuthorizationNumberAndLineItemNumberWithGreatestVersion() {
        LineItem expected = lineItems.get(0);
        LineItem actual = findOneWhereWorkAuthorizationNumberAndLineItemNumber("WA-1",
                "LI-1").get();
        Assertions.assertEquals(expected, actual);

        expected = lineItems.get(2);
        actual = findOneWhereWorkAuthorizationNumberAndLineItemNumber("WA-2",
                "LI-2").get();
        Assertions.assertEquals(expected, actual);

        expected = lineItems.get(5);
        actual = findOneWhereWorkAuthorizationNumberAndLineItemNumber("WA-3",
                "LI-3").get();
        Assertions.assertEquals(expected, actual);
    }

    private List<LineItem> findAllWhereIdEqualTo(Long id) {
        return lineItemRepository.findAll(
            where(
                idEqualTo(id)
            )
        );
    }

    private List<LineItem> findAllWhereIdMaximum() {
        return lineItemRepository.findAll(
            where(
                idMaximum()
            )
        );
    }

    // private List<LineItem> findAllWhereVersionMaximum() {
    //     return lineItemRepository.findAll(
    //         where(
    //             versionMaximum()
    //         )
    //     );
    // }

    // private Optional<LineItem> findOneWhereIdEqualToAndVersionMaximum(Long id) {
    //     return lineItemRepository.findOne(
    //         where(
    //             idEqualTo(id)
    //             .and(versionMaximum())
    //         )
    //     );
    // }

    private Optional<LineItem> findOneWhereIdEqualToAndVersionEqualTo(Long id, Long version) {
        return lineItemRepository.findOne(
            where(
                idEqualTo(id)
                .and(versionEqualTo(version))
            )
        );
    }

    private List<LineItem> findAllWhereWorkAuthorizationNumberAndLineItemNumberEqualTo(
            String workAuthorizationNumber, String lineItemNumber)
    {
        return lineItemRepository.findAll(
            where(
                workAuthorizationNumberEqualTo(workAuthorizationNumber)
                .and(lineItemNumberEqualTo(lineItemNumber))
            )
        );
    }

    private Optional<LineItem> findOneWhereWorkAuthorizationNumberAndLineItemNumber(
            String workAuthorizationNumber, String lineItemNumber)
    {
        return lineItemRepository.findOne(
            where(
                workAuthorizationNumberEqualTo(workAuthorizationNumber)
                .and(lineItemNumberEqualTo(lineItemNumber))
            )
        );
    }
}
