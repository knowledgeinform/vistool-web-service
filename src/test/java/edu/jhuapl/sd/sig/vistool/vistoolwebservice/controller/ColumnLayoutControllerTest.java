package edu.jhuapl.sd.sig.vistool.vistoolwebservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.VistoolTestUtilities;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.DimHRPerson;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.ColumnLayout;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.VistoolUserDTO;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.VistoolUserRole;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.VistoolUserRoleAssignment;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.denodo.DimHRPersonRepository;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.vistool.ColumnLayoutRepository;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.vistool.VistoolUserRoleAssignmentRepository;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.ScheduledTasks;

import org.junit.jupiter.api.AfterEach;
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

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@MockBean(ScheduledTasks.class)
@ActiveProfiles({"local-dev-secure-h2"})
public class ColumnLayoutControllerTest {
    @Autowired private MockMvc mockMvc;
    @Autowired private ObjectMapper objectMapper;
    @Autowired private DimHRPersonRepository dimHRPersonRepository;
    @Autowired private VistoolUserRoleAssignmentRepository roleAssignmentRepository;
    @Autowired private ColumnLayoutRepository columnLayoutRepository;

    // Test column layouts
    private final ColumnLayout visibleViewer = new ColumnLayout("USER", "Visible Viewer", "JSON", true);
    private final ColumnLayout visibleAdmin = new ColumnLayout("ADMIN-USER", "Visible Admin", "JSON", true);
    private final ColumnLayout hiddenViewer = new ColumnLayout("USER", "Hidden Viewer", "JSON", false);
    private final ColumnLayout hiddenAdmin = new ColumnLayout("ADMIN-USER", "Hidden Admin", "JSON", false);

    // Test Users
    private DimHRPerson viewer;
    private DimHRPerson admin;


    private DimHRPerson createTestUser(String username, String personId, VistoolUserRole role) {
        DimHRPerson dimHRPerson = createDimHrPerson(username, personId);
        dimHRPersonRepository.save(dimHRPerson);

        VistoolUserRoleAssignment vistoolUserRoleAssignment = new VistoolUserRoleAssignment(username,
                role.toString());
        roleAssignmentRepository.save(vistoolUserRoleAssignment);
        return dimHRPerson;
    }

    @BeforeEach
    public void beforeEach() {
        // Clear the repositories
        dimHRPersonRepository.deleteAll();
        columnLayoutRepository.deleteAll();

        // Add users
        admin = createTestUser("ADMIN-USER", "ADMIN-USER", VistoolUserRole.ADMIN);
        viewer = createTestUser("USER", "USER", VistoolUserRole.VIEWER);

        // Add test column layouts
        columnLayoutRepository.saveAll(List.of(visibleViewer, visibleAdmin, hiddenViewer, hiddenAdmin));
    }

    @AfterEach
    public void afterEach() {
        roleAssignmentRepository.deleteAll();
    }

    @Test
    @WithMockUser
    public void testGetColumnLayoutById() throws Exception {
        VistoolUserDTO user = VistoolTestUtilities.setCurrentUserContextTo("ADMIN-USER", VistoolUserRole.ADMIN);
        int expectedId = visibleViewer.getId().intValue();
        mockMvc.perform(MockMvcRequestBuilders.get("/ColumnLayout/Id/" + expectedId)
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(visibleViewer)));
    }

    @Test
    @WithMockUser
    public void testSaveColumnLayout() throws Exception {
        VistoolUserDTO user = VistoolTestUtilities.setCurrentUserContextTo("USER", VistoolUserRole.VIEWER);
        ColumnLayout newLayout = new ColumnLayout("ID", "Visible Viewer 2", "JSON", true);
        mockMvc.perform(MockMvcRequestBuilders.post("/ColumnLayout")
                        .with(csrf())
                        .content(objectMapper.writeValueAsString(newLayout)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    public void testGetColumnLayoutByUsername() throws Exception {
        VistoolUserDTO user = VistoolTestUtilities.setCurrentUserContextTo("USER", VistoolUserRole.VIEWER);
        mockMvc.perform(MockMvcRequestBuilders.get("/ColumnLayout/User/" + user.getUsername())
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(List.of(visibleViewer, hiddenViewer))));
    }

    @Test
    @WithMockUser
    public void testGetColumnLayoutByVisibility() throws Exception {
        VistoolUserDTO user = VistoolTestUtilities.setCurrentUserContextTo("ADMIN-USER", VistoolUserRole.ADMIN);
        mockMvc.perform(MockMvcRequestBuilders.get("/ColumnLayout/Visibility/" + false)
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(List.of(hiddenViewer, hiddenAdmin))));
    }

    @Test
    @WithMockUser
    public void testUpdateColumnLayoutName() throws Exception {
        VistoolUserDTO user = VistoolTestUtilities.setCurrentUserContextTo("USER", VistoolUserRole.VIEWER);
        String expectedName = "New Name";
        long expectedId = visibleViewer.getId();
        visibleViewer.setName(expectedName);
        // Update name
        mockMvc.perform(MockMvcRequestBuilders.put("/ColumnLayout/Update/Name")
                        .with(csrf())
                        .content(objectMapper.writeValueAsString(visibleViewer)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        // Verify that name updated
        mockMvc.perform(MockMvcRequestBuilders.get("/ColumnLayout/Id/" + expectedId)
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(visibleViewer)));
    }

    @Test
    @WithMockUser
    public void testUpdateColumnLayoutVisibility() throws Exception {
        VistoolUserDTO user = VistoolTestUtilities.setCurrentUserContextTo("USER", VistoolUserRole.VIEWER);
        long expectedId = visibleViewer.getId();
        visibleViewer.setVisible(!visibleViewer.isVisible());
        // Update name
        mockMvc.perform(MockMvcRequestBuilders.put("/ColumnLayout/Update/Visibility")
                        .with(csrf())
                        .content(objectMapper.writeValueAsString(visibleViewer)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        // Verify that visibility updated
        mockMvc.perform(MockMvcRequestBuilders.get("/ColumnLayout/Id/" + expectedId)
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(visibleViewer)));
    }


    @Test
    @WithMockUser
    public void testCannotGetColumnLayoutOfDifferentAuthor() throws Exception {
        // TODO: revert back to status().isUnauthorized once roles are implemented
        VistoolUserDTO user = VistoolTestUtilities.setCurrentUserContextTo("USER", VistoolUserRole.VIEWER);
        mockMvc.perform(MockMvcRequestBuilders.get("/ColumnLayout/User/" + admin.getUserId())
                        .with(csrf()))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    public void testViewerCannotGetPrivateLayouts() throws Exception {
        VistoolUserDTO user = VistoolTestUtilities.setCurrentUserContextTo("USER", VistoolUserRole.VIEWER);
        mockMvc.perform(MockMvcRequestBuilders.get("/ColumnLayout/Visibility/" + false)
                        .with(csrf()))
                .andExpect(status().isUnauthorized());
    }

    // TODO: disabling as per todo under:
    // @GetMapping(value = "/ColumnLayout/User/{username}")
    // public ResponseEntity<List<ColumnLayout>> getColumnLayoutsByUsername(@PathVariable("username") String username)

//    @Test
//    @WithMockUser
    public void testAdminGetColumnLayoutOfDifferentAuthor() throws Exception {
        VistoolUserDTO user = VistoolTestUtilities.setCurrentUserContextTo("ADMIN-USER", VistoolUserRole.ADMIN);
        mockMvc.perform(MockMvcRequestBuilders.get("/ColumnLayout/User/" + viewer.getUserId())
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(List.of(visibleViewer, hiddenViewer))));
    }

    @Test
    @WithMockUser
    public void testCannotViewColumnLayoutBeforeAuth() throws Exception {
        long expectedId = visibleViewer.getId();
        mockMvc.perform(MockMvcRequestBuilders.get("/ColumnLayout/Id/" + expectedId))
                .andExpect(status().isForbidden());
    }

    private DimHRPerson createDimHrPerson(String username, String personID) {
        DimHRPerson dimHrPerson = new DimHRPerson();
        dimHrPerson.setUserId(username);
        dimHrPerson.setPersonNumber(personID);
        return dimHrPerson;
    }
}
