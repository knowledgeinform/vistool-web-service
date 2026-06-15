package edu.jhuapl.sd.sig.vistool.vistoolwebservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.VistoolTestUtilities;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.DimHRPerson;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.VistoolUserDTO;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.VistoolUserRole;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.VistoolUserRoleAssignment;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.denodo.DimHRPersonRepository;
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
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;
import java.util.Optional;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@MockBean(ScheduledTasks.class)
@ActiveProfiles({"local-dev-secure-h2"})
public class UserControllerTest {
    @Autowired private MockMvc mockMvc;
    @Autowired private ObjectMapper objectMapper;
    @Autowired private DimHRPersonRepository dimHrPersonRepository;
    @Autowired private VistoolUserRoleAssignmentService vistoolUserRoleAssignmentService;
    @Autowired private VistoolUserRoleAssignmentRepository vistoolUserRoleAssignmentRepository;

    @BeforeEach
    public void beforeEach() {
        dimHrPersonRepository.deleteAll();
    }

    @AfterEach
    public void afterEach() {
        vistoolUserRoleAssignmentRepository.deleteAll();
    }

    @Test
    @WithMockUser
    public void testGetUserInformation() throws Exception {
        VistoolUserDTO expected = VistoolTestUtilities.setCurrentUserContextTo("USER", VistoolUserRole.VIEWER);
        mockMvc.perform(MockMvcRequestBuilders.get("/user"))
            .andExpect(status().isOk())
            .andExpect(content().json(objectMapper.writeValueAsString(expected)));
    }

    @Test
    @WithMockUser
    public void testGetUserInformationNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user")).andExpect(status().isNotFound());
    }

    @Test
    @WithMockUser
    public void testGetUserByUsernameWithPreviouslyAssignedRole() throws Exception {
        DimHRPerson hrPersonAll = createDimHrPerson("USERNAME", "ID");
        dimHrPersonRepository.save(hrPersonAll);

        VistoolUserRoleAssignment vistoolUserRoleAssignment = new VistoolUserRoleAssignment("ID", VistoolUserRole.VIEWER.toString());
        vistoolUserRoleAssignmentRepository.save(vistoolUserRoleAssignment);

        VistoolUserDTO expected = new VistoolUserDTO(hrPersonAll, VistoolUserRole.VIEWER);
        mockMvc.perform(MockMvcRequestBuilders.get("/user/USERNAME"))
            .andExpect(status().isOk())
            .andExpect(content().json(objectMapper.writeValueAsString(expected)));
    }

    @Test
    @WithMockUser
    public void testGetUserByUsernameWithUnassignedRole() throws Exception {
        DimHRPerson hrPersonAll = createDimHrPerson("USERNAME", "ID");
        dimHrPersonRepository.save(hrPersonAll);

        VistoolUserDTO expected = new VistoolUserDTO(hrPersonAll, VistoolUserRole.VIEWER);
        mockMvc.perform(MockMvcRequestBuilders.get("/user/USERNAME"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(expected)));
    }

    @Test
    @WithMockUser
    public void testGetUserByUsernameNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/USERNAME")).andExpect(status().isNotFound());
    }

    @Test
    @WithMockUser
    public void testGetAllUsersForRole() throws Exception {
        vistoolUserRoleAssignmentService.changeUserRole("VIEWER_ONE", VistoolUserRole.VIEWER);
        vistoolUserRoleAssignmentService.changeUserRole("VIEWER_TWO", VistoolUserRole.VIEWER);
        vistoolUserRoleAssignmentService.changeUserRole("COMMENTER", VistoolUserRole.COMMENTER);
        List<DimHRPerson> hrPersonAllList = List.of(
            createDimHrPerson("VIEWER_ONE", "VIEWER_ONE"),
            createDimHrPerson("VIEWER_TWO", "VIEWER_TWO"),
            createDimHrPerson("COMMENTER", "COMMENTER")
        );
        dimHrPersonRepository.saveAll(hrPersonAllList);
        List<VistoolUserDTO> expected = List.of(
            new VistoolUserDTO(hrPersonAllList.get(0), VistoolUserRole.VIEWER),
            new VistoolUserDTO(hrPersonAllList.get(1), VistoolUserRole.VIEWER)
        );
        mockMvc.perform(MockMvcRequestBuilders.get("/user/role/VIEWER"))
            .andExpect(status().isOk())
            .andExpect(content().json(objectMapper.writeValueAsString(expected)));
    }

    @Test
    @WithMockUser
    public void testAssignRolesToListOfUsers() throws Exception {
        DimHRPerson hrPersonAll = createDimHrPerson("USER", "USER");
        dimHrPersonRepository.save(hrPersonAll);
        VistoolUserRoleAssignment vistoolUserRoleAssignment = new VistoolUserRoleAssignment("USER", VistoolUserRole.ADMIN.toString());
        vistoolUserRoleAssignmentRepository.save(vistoolUserRoleAssignment);

        VistoolUserDTO expectedVistoolUser = VistoolTestUtilities.setCurrentUserContextTo("USER", VistoolUserRole.ADMIN);
        mockMvc.perform(MockMvcRequestBuilders.put("/user/role")
            .with(csrf())
            .content(objectMapper.writeValueAsString(List.of(expectedVistoolUser))).contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());

        VistoolUserRoleAssignment expectedVistoolUserRoleAssignment =
            new VistoolUserRoleAssignment("USER", VistoolUserRole.ADMIN.toString());
        Optional<VistoolUserRoleAssignment> actualVistoolUserRoleAssignment =
            vistoolUserRoleAssignmentService.findOneVistoolUserRoleAssignmentByUserId("USER");
        Assertions.assertEquals(expectedVistoolUserRoleAssignment, actualVistoolUserRoleAssignment.get());
    }

    @Test
    @WithMockUser("USER")
    public void testAssignRolesToListOfUsersByNonAdmin() throws Exception {
        VistoolUserDTO expectedVistoolUser = VistoolTestUtilities.setCurrentUserContextTo("USER", VistoolUserRole.VIEWER);
        mockMvc.perform(MockMvcRequestBuilders.put("/user/role")
                        .with(csrf())
                        .content(objectMapper.writeValueAsString(List.of(expectedVistoolUser))).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized());
    }

    private DimHRPerson createDimHrPerson(String username, String personID) {
        DimHRPerson dimHrPerson = new DimHRPerson();
        dimHrPerson.setUserId(username);
        dimHrPerson.setPersonNumber(personID);
        return dimHrPerson;
    }
}
