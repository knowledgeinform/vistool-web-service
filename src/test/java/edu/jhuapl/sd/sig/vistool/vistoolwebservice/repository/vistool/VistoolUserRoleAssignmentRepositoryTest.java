package edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.vistool;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.VistoolUserRole;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.VistoolUserRoleAssignment;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.ScheduledTasks;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@MockBean(ScheduledTasks.class)
@ActiveProfiles("local-dev-secure-h2")
public class VistoolUserRoleAssignmentRepositoryTest {
    @Autowired private VistoolUserRoleAssignmentRepository vistoolUserRoleAssignmentRepository;
    private final VistoolUserRoleAssignment viewerRoleAssignment = new VistoolUserRoleAssignment("VIEWER", VistoolUserRole.VIEWER.toString());
    private final VistoolUserRoleAssignment commenterRoleAssignment = new VistoolUserRoleAssignment("COMMENTER", VistoolUserRole.COMMENTER.toString());

    @BeforeEach
    public void beforeEach() {
        vistoolUserRoleAssignmentRepository.deleteAll();
        vistoolUserRoleAssignmentRepository.saveAll(List.of(viewerRoleAssignment, commenterRoleAssignment));
    }

    @AfterEach
    public void afterEach() {
        vistoolUserRoleAssignmentRepository.deleteAll();
    }

    @Test
    public void testSave() {
        Assertions.assertEquals(2, vistoolUserRoleAssignmentRepository.count());
    }

    @Test
    public void findOneVistoolUserRoleAssignmentByUserId() {
        Optional<VistoolUserRoleAssignment> expected = Optional.of(viewerRoleAssignment);
        Optional<VistoolUserRoleAssignment> actual = userIdEqualTo(viewerRoleAssignment.getUserId());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findAllVistoolUserRoleAssignmentsByRole() {
        List<VistoolUserRoleAssignment> expected = List.of(commenterRoleAssignment);
        List<VistoolUserRoleAssignment> actual = hasRole(commenterRoleAssignment.getRole());
        Assertions.assertEquals(expected, actual);
    }

    private Optional<VistoolUserRoleAssignment> userIdEqualTo(String userId) {
        return vistoolUserRoleAssignmentRepository.findOne(
            Specification.where(
                VistoolUserRoleAssignmentRepository.userIdEqualTo(userId)
            )
        );
    }

    private List<VistoolUserRoleAssignment> hasRole(String role) {
        return vistoolUserRoleAssignmentRepository.findAll(
            Specification.where(
                VistoolUserRoleAssignmentRepository.hasRole(role)
            )
        );
    }
}
