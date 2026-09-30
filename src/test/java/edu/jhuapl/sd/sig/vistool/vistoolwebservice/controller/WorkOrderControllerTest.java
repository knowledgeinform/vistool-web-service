package edu.jhuapl.sd.sig.vistool.vistoolwebservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.logic.WorkItemLogic;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.*;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.*;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.denodo.DimHRPersonRepository;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.vistool.VistoolUserRoleAssignmentRepository;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.service.DenodoService;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.service.LineItemService;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.service.WorkItemService;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.ScheduledTasks;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.VistoolTestUtilities;

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

import java.util.Arrays;
import java.util.List;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@MockBean(ScheduledTasks.class)
@ActiveProfiles({"local-dev-secure-h2"})
@WithMockUser(username = "mock_user", password = "mock_user", roles = "USER")
public class WorkOrderControllerTest {
    @Autowired private MockMvc mockMvc;
    @Autowired private DenodoService denodoService;
    @Autowired private ObjectMapper objectMapper;
    @Autowired private LineItemService lineItemService;
    @Autowired private WorkItemService workItemService;
    @Autowired private DimHRPersonRepository dimHrPersonRepository;
    @Autowired private VistoolUserRoleAssignmentRepository vistoolUserRoleAssignmentRepository;

    @MockBean WorkItemLogic workItemLogic;

    private VeWo veWoOne = null;
    private VeWo veWoTwo = null;
    private List<LineItem> lineItems;
    private List<WorkItem> workItems;

    @BeforeEach
    public void beforeEach() {
        if(veWoOne == null) {
            veWoOne = new VeWo();
            veWoOne.setWorkOrderNumber("1");
        }
        if(veWoTwo == null) {
            veWoTwo = new VeWo();
            veWoTwo.setWorkOrderNumber("2");
        }

        denodoService.addVeWo(Arrays.asList(veWoOne, veWoTwo));

        lineItems = VistoolTestUtilities.createCompleteLineItems();
        workItems = VistoolTestUtilities.createCompleteWorkItems();
        lineItemService.saveLineItems(lineItems);
        workItemService.saveWorkItems(workItems, false);
        dimHrPersonRepository.deleteAll();
        vistoolUserRoleAssignmentRepository.deleteAll();
    }

    @AfterEach
    public void afterEach() {
        workItemService.deleteAllWorkItems();
        lineItemService.deleteAllLineItems();
        vistoolUserRoleAssignmentRepository.deleteAll();
    }

    @Test
    public void testGetWorkOrders() throws Exception {
        List<VeWo> expected = Arrays.asList(veWoOne, veWoTwo);
        mockMvc.perform(MockMvcRequestBuilders.get("/WorkOrders"))
            .andExpect(status().isOk())
            .andExpect(content().json(objectMapper.writeValueAsString(expected)));
    }

    @Test
    public void testGetWorkOrder() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/WorkOrder")
            .param("workOrderNumber", "1"))
            .andExpect(status().isOk())
            .andExpect(content().json(objectMapper.writeValueAsString(veWoOne)));
    }

    @Test
    public void testGetWorkOrderNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/WorkOrder")
            .param("workOrderNumber", "3"))
            .andExpect(status().isNotFound());
    }

    @Test
    public void testGetWorkOrderNumbers() throws Exception {
        List<String> expected = Arrays.asList("1", "2");
        mockMvc.perform(MockMvcRequestBuilders.get("/WorkOrderNumbers"))
            .andExpect(status().isOk())
            .andExpect(content().json(objectMapper.writeValueAsString(expected)));
    }

    @Test
    public void testLinkWorkOrderSuccess() throws Exception {
        testLinkWorkOrder(VistoolUserRole.EDITOR, "2", true, 200);
    }

    // TODO: Add this test back in when VIS-873 is addressed.
    // @Test
    // public void testLinkWorkOrderLinkFailure() throws Exception {
    //     testLinkWorkOrder(VistoolUserRole.EDITOR, "2", false, 400);
    // }

    @Test
    public void testLinkWorkOrderPermissionFailure() throws Exception {
        testLinkWorkOrder(VistoolUserRole.VIEWER, "2", true, 401);
    }

    @Test
    public void testLinkWorkOrderLookupFailure() throws Exception {
        testLinkWorkOrder(VistoolUserRole.EDITOR, "3", true, 404);
    }

    public void testLinkWorkOrder(String userRole, String workOrderNumber, boolean canLinkWorkOrder, int expectedStatus) throws Exception {
        DimHRPerson dimHrPerson = new DimHRPerson();
        dimHrPerson.setUserId("USER");
        dimHrPerson.setPersonNumber("USER");
        dimHrPersonRepository.save(dimHrPerson);

        VistoolUserRoleAssignment vistoolUserRoleAssignment = new VistoolUserRoleAssignment("USER", userRole);
        vistoolUserRoleAssignmentRepository.save(vistoolUserRoleAssignment);

        VistoolTestUtilities.setCurrentUserContextTo("USER", userRole);

        WorkItem workItem = workItems.get(0);
        String workItemJson = objectMapper.writeValueAsString(workItem);

        mockMvc.perform(MockMvcRequestBuilders.put("/LinkWorkOrder")
            .with(csrf())
            .param("workOrderNumber", workOrderNumber)
            .content(workItemJson).contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().is(expectedStatus));
    }
}
