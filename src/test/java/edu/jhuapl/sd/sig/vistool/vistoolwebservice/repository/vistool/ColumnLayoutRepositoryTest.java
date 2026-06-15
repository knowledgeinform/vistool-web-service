package edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.vistool;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.ColumnLayout;
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
public class ColumnLayoutRepositoryTest {
    @Autowired private ColumnLayoutRepository columnLayoutRepository;
    private final ColumnLayout columnLayoutVisible1 = new ColumnLayout("user1", "Visible 1", "JSON", true);
    private final ColumnLayout columnLayoutVisible2 = new ColumnLayout("user2", "Visible 2", "JSON", true);
    private final ColumnLayout columnLayoutHidden1 = new ColumnLayout("user1", "Hidden 1", "JSON", false);
    private final ColumnLayout columnLayoutHidden2 = new ColumnLayout("user2", "Hidden 2", "JSON", false);

    @BeforeEach
    public void beforeEach() {
        columnLayoutRepository.deleteAll();
        columnLayoutRepository.saveAll(List.of(columnLayoutVisible1, columnLayoutVisible2, columnLayoutHidden1, columnLayoutHidden2));
    }

    @AfterEach
    public void afterEach() {
        columnLayoutRepository.deleteAll();
    }

    @Test
    public void testSave() {
        Assertions.assertEquals(4, columnLayoutRepository.count());
    }

    @Test
    public void findVisibleColumnLayouts() {
        List<ColumnLayout> expected = List.of(columnLayoutVisible1, columnLayoutVisible2);
        List<ColumnLayout> actual = matchesVisibility(true);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findHiddenColumnLayouts() {
        List<ColumnLayout> expected = List.of(columnLayoutHidden1, columnLayoutHidden2);
        List<ColumnLayout> actual = matchesVisibility(false);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findColumnLayoutsByUser() {
        List<ColumnLayout> expected = List.of(columnLayoutVisible1, columnLayoutHidden1);
        List<ColumnLayout> actual = matchesUser("user1");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findColumnLayoutById() {
        ColumnLayout expected = columnLayoutVisible1;
        int expectedId = columnLayoutVisible1.getId().intValue();
        Optional<ColumnLayout> actual = matchesId(expectedId);
        if (actual.isPresent()) {
            Assertions.assertEquals(expected, actual.get());
        } else {
            Assertions.fail();
        }
    }

    private List<ColumnLayout> matchesVisibility(boolean visibility) {
        return columnLayoutRepository.findAll(ColumnLayoutRepository.matchesVisibility(visibility));
    }

    private List<ColumnLayout> matchesUser(String user) {
        return columnLayoutRepository.findAll(ColumnLayoutRepository.userIdEqualTo(user));
    }

    private Optional<ColumnLayout> matchesId(int id) {
        return columnLayoutRepository.findOne(ColumnLayoutRepository.columnLayoutIdEqualTo(id));
    }
}
