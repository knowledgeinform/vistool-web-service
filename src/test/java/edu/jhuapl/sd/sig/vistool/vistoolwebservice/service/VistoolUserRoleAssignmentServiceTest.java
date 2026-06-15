package edu.jhuapl.sd.sig.vistool.vistoolwebservice.service;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.VistoolUserRole;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.VistoolUserRoleAssignment;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.vistool.VistoolUserRoleAssignmentRepository;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.ScheduledTasks;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@SpringBootTest
@MockBean(ScheduledTasks.class)
@ActiveProfiles("local-dev-secure-h2")
public class VistoolUserRoleAssignmentServiceTest {
    @Autowired private VistoolUserRoleAssignmentService vistoolUserRoleAssignmentService;
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
    public void testChangeUserRole() {
        VistoolUserRoleAssignment expected = new VistoolUserRoleAssignment(viewerRoleAssignment.getUserId(), VistoolUserRole.ADMIN.toString());
        VistoolUserRoleAssignment actual = vistoolUserRoleAssignmentService.changeUserRole(viewerRoleAssignment.getUserId(), VistoolUserRole.ADMIN);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFindOneUserRoleAssignmentByUserId() {
        VistoolUserRoleAssignment expected = viewerRoleAssignment;
        VistoolUserRoleAssignment actual = vistoolUserRoleAssignmentService.findOneVistoolUserRoleAssignmentByUserId(viewerRoleAssignment.getUserId()).get();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFindAllVistoolUserRoleAssignmentsByRole() {
        List<VistoolUserRoleAssignment> expected = List.of(commenterRoleAssignment);
        List<VistoolUserRoleAssignment> actual = vistoolUserRoleAssignmentService.findAllVistoolUserRoleAssignmentsByRole(VistoolUserRole.COMMENTER);
        Assertions.assertEquals(expected, actual);
    }
}
