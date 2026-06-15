package edu.jhuapl.sd.sig.vistool.vistoolwebservice.service;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.exceptions.ColumnLayoutException;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.ColumnLayout;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.vistool.ColumnLayoutRepository;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.ScheduledTasks;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@MockBean(ScheduledTasks.class)
@ActiveProfiles("local-dev-secure-h2")
public class ColumnLayoutServiceTest {
    @Autowired private ColumnLayoutService columnLayoutService;
    @Autowired private ColumnLayoutRepository columnLayoutRepository;
    private final ColumnLayout columnLayoutVisible1 = new ColumnLayout("user1", "Visible 1", "JSON", true);
    private final ColumnLayout columnLayoutVisible2 = new ColumnLayout("user2", "Visible 2", "JSON", true);
    private final ColumnLayout columnLayoutHidden1 = new ColumnLayout("user1", "Hidden 1", "JSON", false);
    private final ColumnLayout columnLayoutHidden2 = new ColumnLayout("user2", "Hidden 2", "JSON", false);
    private final ColumnLayout columnLayoutToAdd = new ColumnLayout("user1", "Add me", "JSON", false);

    @BeforeEach
    public void beforeEach() {
        columnLayoutRepository.deleteAll();
        columnLayoutRepository.saveAll(List.of(columnLayoutVisible1, columnLayoutVisible2, columnLayoutHidden1,
                columnLayoutHidden2));
    }

    @AfterEach
    public void afterEach() {
        columnLayoutRepository.deleteAll();
    }

    @Test
    public void testFindColumnLayoutsByUserId() {
        List<ColumnLayout> expected = List.of(columnLayoutVisible1, columnLayoutHidden1);
        List<ColumnLayout> actual = columnLayoutService.findAllColumnLayoutsByUserId("user1");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFindHiddenColumnLayouts() {
        List<ColumnLayout> expected = List.of(columnLayoutHidden1, columnLayoutHidden2);
        List<ColumnLayout> actual = columnLayoutService.findAllColumnLayoutsByVisibility(false);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFindVisibleColumnLayouts() {
        List<ColumnLayout> expected = List.of(columnLayoutVisible1, columnLayoutVisible2);
        List<ColumnLayout> actual = columnLayoutService.findAllColumnLayoutsByVisibility(true);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFindColumnLayoutById() {
        ColumnLayout expected = columnLayoutVisible1;
        int expectedId = columnLayoutVisible1.getId().intValue();
        Optional<ColumnLayout> actual = columnLayoutService.findOneColumnLayoutById(expectedId);
        if (actual.isPresent()) {
            Assertions.assertEquals(expected, actual.get());
        } else {
            Assertions.fail("Could not find the column layout by id: " + 1);
        }
    }

    @Test
    public void testAddColumnLayout() {
        long expected = columnLayoutRepository.count() + 1;
        columnLayoutService.addColumnLayout(columnLayoutToAdd);
        long actual = columnLayoutRepository.count();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testUpdateColumnLayoutName() {
        String expected = "Changed Name";
        String actual = "";
        try {
            columnLayoutService.updateColumnLayoutName(columnLayoutVisible1.getId().intValue(), expected);
            Optional<ColumnLayout> updatedColLayout =
                    columnLayoutService.findOneColumnLayoutById(columnLayoutVisible1.getId().intValue());
            if (updatedColLayout.isPresent()) {
                actual = updatedColLayout.get().getName();
            } else {
                Assertions.fail("Could not find the updated column layout");
            }
        } catch (ColumnLayoutException e) {
            Assertions.fail(e.getMessage());
        }
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testUpdateColumnLayoutVisibility() {
        boolean expected = !columnLayoutVisible1.isVisible();
        boolean actual = columnLayoutVisible1.isVisible();
        try {
            columnLayoutService.updateColumnLayoutVisibility(columnLayoutVisible1.getId().intValue(), expected);
            Optional<ColumnLayout> updatedColLayout =
                    columnLayoutService.findOneColumnLayoutById(columnLayoutVisible1.getId().intValue());
            if (updatedColLayout.isPresent()) {
                actual = updatedColLayout.get().isVisible();
            } else {
                Assertions.fail("Could not find the updated column layout");
            }
        } catch (ColumnLayoutException e) {
            Assertions.fail(e.getMessage());
        }
        Assertions.assertEquals(expected, actual);
    }

}
