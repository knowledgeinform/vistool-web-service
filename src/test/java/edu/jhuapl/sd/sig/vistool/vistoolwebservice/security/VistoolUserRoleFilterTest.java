package edu.jhuapl.sd.sig.vistool.vistoolwebservice.security;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.VistoolUser;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.VistoolUserDTO;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.VistoolUserRole;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.VistoolUserRoleAssignment;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.vistool.VistoolUserRoleAssignmentRepository;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.service.VistoolUserRoleAssignmentService;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.ScheduledTasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@MockBean(ScheduledTasks.class)
@ActiveProfiles("local-dev-secure-h2")
public class VistoolUserRoleFilterTest {
    @Autowired private MockMvc mockMvc;
    @Autowired private VistoolUserRoleAssignmentService vistoolUserRoleAssignmentService;
    @Autowired private VistoolUserRoleAssignmentRepository vistoolUserRoleAssignmentRepository;
    

    @AfterEach
    public void afterEach() {
        vistoolUserRoleAssignmentRepository.deleteAll();
    }

    @Test
    @WithMockUser
    public void test() throws Exception {
        Optional<VistoolUserRoleAssignment> actual = vistoolUserRoleAssignmentService.findOneVistoolUserRoleAssignmentByUserId("USER");
        Assertions.assertEquals(Optional.empty(), actual);
        setCurrentUserContextTo("USER", "USER", VistoolUserRole.VIEWER);
        mockMvc.perform(MockMvcRequestBuilders.get("/user"))
            .andExpect(status().isOk());
        actual = vistoolUserRoleAssignmentService.findOneVistoolUserRoleAssignmentByUserId("USER");
        Optional<VistoolUserRoleAssignment> expected = Optional.of(new VistoolUserRoleAssignment("USER", VistoolUserRole.VIEWER.toString()));
        Assertions.assertEquals(expected, actual);
    }

    private VistoolUserDTO setCurrentUserContextTo(String username, String userId, VistoolUserRole vistoolUserRole) {
        VistoolUser vistoolUser = new VistoolUser(username, "", List.of(new SimpleGrantedAuthority(vistoolUserRole.toString())), vistoolUserRole);
        vistoolUser.setEmployeeId(userId);
        vistoolUserRoleAssignmentService.changeUserRole(vistoolUser.getUsername(), vistoolUserRole);

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                vistoolUser,
                SecurityContextHolder.getContext().getAuthentication().getCredentials(),
                List.of(new SimpleGrantedAuthority(vistoolUserRole.toString())));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new VistoolUserDTO(vistoolUser);
    }
}
