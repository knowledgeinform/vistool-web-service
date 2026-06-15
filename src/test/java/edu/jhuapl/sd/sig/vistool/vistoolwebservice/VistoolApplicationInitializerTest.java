package edu.jhuapl.sd.sig.vistool.vistoolwebservice;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.VistoolUserRole;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.VistoolUserRoleAssignment;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.vistool.VistoolUserRoleAssignmentRepository;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.EmailUtilities;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.ScheduledTasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@SpringBootTest
@MockBean(EmailUtilities.class)
@MockBean(ScheduledTasks.class)
@ActiveProfiles("local-dev-secure-h2")
@AutoConfigureMockMvc
public class VistoolApplicationInitializerTest {
    @Value("${vistool.security.enabled}")
    private boolean vistoolSecurityEnabled;

    @Autowired private VistoolUserRoleAssignmentRepository vistoolUserRoleAssignmentRepository;

    @AfterEach
    public void afterEach() {
        vistoolUserRoleAssignmentRepository.deleteAll();
    }

    @Test @WithMockUser
    public void testInitialAdminsLoaded() throws Exception {
        if(vistoolSecurityEnabled) {
            List<VistoolUserRoleAssignment> vistoolUserRoleAssignments = vistoolUserRoleAssignmentRepository.findAll();
            for(VistoolUserRoleAssignment vistoolUserRoleAssignment : vistoolUserRoleAssignments) {
                Assertions.assertEquals(VistoolUserRole.ADMIN.toString(), vistoolUserRoleAssignment.getRole());
            }
        }
        else {
            Assertions.assertEquals(0, vistoolUserRoleAssignmentRepository.count());
        }
    }
}
