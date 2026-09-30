package edu.jhuapl.sd.sig.vistool.vistoolwebservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.VistoolTestUtilities;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.DimHRPerson;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.*;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.denodo.DimHRPersonRepository;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.vistool.VistoolRoleFieldPermissionRepository;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.vistool.VistoolUserRoleAssignmentRepository;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.service.LineItemService;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.service.WorkItemService;
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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@MockBean(ScheduledTasks.class)
@ActiveProfiles({"local-dev-secure-h2"})
@WithMockUser(username = "mock_user", password = "mock_user", roles = "USER")
public class WorkItemControllerTest {
    @Autowired private MockMvc mvc;
    @Autowired private ObjectMapper objectMapper;
    @Autowired private LineItemService lineItemService;
    @Autowired private WorkItemService workItemService;
    @Autowired private DimHRPersonRepository dimHrPersonRepository;
    @Autowired private VistoolUserRoleAssignmentRepository vistoolUserRoleAssignmentRepository;
    @Autowired private VistoolRoleFieldPermissionRepository vistoolRoleFieldPermissionRepository;

    private List<LineItem> lineItems;
    private List<WorkItem> workItems;

    @BeforeEach
    public void beforeEach() {
        lineItems = VistoolTestUtilities.createCompleteLineItems();
        workItems = VistoolTestUtilities.createCompleteWorkItems();
        lineItemService.saveLineItems(lineItems);
        workItemService.saveWorkItems(workItems, false);
        dimHrPersonRepository.deleteAll();
        vistoolUserRoleAssignmentRepository.deleteAll();
        vistoolRoleFieldPermissionRepository.deleteAll();
    }

    @AfterEach
    public void afterEach() {
        workItemService.deleteAllWorkItems();
        lineItemService.deleteAllLineItems();
        vistoolUserRoleAssignmentRepository.deleteAll();
        vistoolRoleFieldPermissionRepository.deleteAll();
    }

    @Test
    public void testGetHydratedWorkItems() throws Exception {
        List<HydratedWorkItem> hydratedWorkItems = workItemService.getAllHydratedWorkItems();
        mvc.perform(MockMvcRequestBuilders.get("/WorkItems"))
            .andExpect(status().isOk())
            .andExpect(content().json(objectMapper.writeValueAsString(hydratedWorkItems)));
    }

    @Test
    public void testGetHydratedWorkItem() throws Exception {
        HydratedWorkItem hydratedWorkItem = workItemService.getHydratedWorkItemById(workItems.get(0).getId()).get();

        mvc.perform(MockMvcRequestBuilders.get("/WorkItem/" + workItems.get(0).getId()))
            .andExpect(status().isOk())
            .andExpect(content().json(objectMapper.writeValueAsString(hydratedWorkItem)));

        mvc.perform(MockMvcRequestBuilders.get("/WorkItem/" + Integer.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    public void testGetHydratedWorkItemVersions() throws Exception {
        List<HydratedWorkItem> hydratedWorkItems = workItemService.getAllHydratedWorkItemVersionsById(2L);

        mvc.perform(MockMvcRequestBuilders.get("/WorkItem/" + workItems.get(1).getId() + "/versions"))
            .andExpect(status().isOk())
            .andExpect(content().json(objectMapper.writeValueAsString(hydratedWorkItems)));

        mvc.perform(MockMvcRequestBuilders.get("/WorkItem/" + Integer.MAX_VALUE + "/versions"))
            .andExpect(status().isBadRequest());
    }

    @Test
    public void testPutNewWorkItemsByEditor() throws Exception {
        grantAllPermissions(VistoolUserRole.ADMIN.toString());
        VistoolUserDTO expectedVistoolUser = setupCurrentUser(VistoolUserRole.ADMIN.toString());
        testPutNew(true, expectedVistoolUser, true);
    }

    @Test
    public void testPutNewWorkItemByEditor() throws Exception {
        grantAllPermissions(VistoolUserRole.EDITOR.toString());
        VistoolUserDTO expectedVistoolUser = setupCurrentUser(VistoolUserRole.EDITOR.toString());
        testPutNew(false, expectedVistoolUser, true);
    }

    @Test
    public void testPutExistingWorkItemsByEditor() throws Exception {
        grantAllPermissions(VistoolUserRole.ADMIN.toString());
        VistoolUserDTO expectedVistoolUser = setupCurrentUser(VistoolUserRole.ADMIN.toString());
        testPutExisting(true, expectedVistoolUser, true);
    }

    @Test
    public void testPutExistingWorkItemByEditor() throws Exception {
        grantAllPermissions(VistoolUserRole.EDITOR.toString());
        VistoolUserDTO expectedVistoolUser = setupCurrentUser(VistoolUserRole.EDITOR.toString());
        testPutExisting(false, expectedVistoolUser, true);
    }

    @Test
    public void testPutExistingWorkItemsReturnsConflictWhenSameFieldChanged() throws Exception {
        grantAllPermissions(VistoolUserRole.ADMIN.toString());
        setupCurrentUser(VistoolUserRole.ADMIN.toString());

        WorkItem originalWorkItem = VistoolTestUtilities.clone(workItems.get(0));

        WorkItem latestWorkItem = VistoolTestUtilities.clone(workItems.get(0));
        latestWorkItem.setStatusComments("saved by another user");
        workItemService.saveWorkItem(latestWorkItem, false);

        WorkItem userEditedWorkItem = VistoolTestUtilities.clone(originalWorkItem);
        userEditedWorkItem.setStatusComments("my conflicting update");

        mvc.perform(MockMvcRequestBuilders.put("/WorkItems")
                .with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(Arrays.asList(createSaveRequest(userEditedWorkItem, originalWorkItem)))))
            .andExpect(status().isConflict())
            .andExpect(content().json("{\"conflicts\":[{\"workItemId\":1,\"conflictingFields\":[\"statusComments\"]}]}"));
    }

    @Test
    public void testPutNewWorkItemsByNonEditor() throws Exception {
        VistoolUserDTO expectedVistoolUser = setupCurrentUser(VistoolUserRole.VIEWER.toString());
        testPutNew(true, expectedVistoolUser, false);
    }

    @Test
    public void testPutNewWorkItemByNonEditor() throws Exception {
        VistoolUserDTO expectedVistoolUser = setupCurrentUser(VistoolUserRole.COMMENTER.toString());
        testPutNew(false, expectedVistoolUser, false);
    }

    @Test
    public void testPutExistingWorkItemsByNonEditor() throws Exception {
        VistoolUserDTO expectedVistoolUser = setupCurrentUser(VistoolUserRole.VIEWER.toString());
        testPutExisting(true, expectedVistoolUser, false);
    }

    @Test
    public void testPutExistingWorkItemByNonEditor() throws Exception {
        VistoolUserDTO expectedVistoolUser = setupCurrentUser(VistoolUserRole.COMMENTER.toString());
        testPutExisting(false, expectedVistoolUser, false);
    }

    private void testPutNew(boolean batched, VistoolUserDTO currentUser, boolean expectAuthorized) throws Exception {
        WorkItem actualWorkItem = createAdditionalWorkItem();
        WorkItem originalWorkItem = VistoolTestUtilities.clone(actualWorkItem);

        if (!expectAuthorized) {
            originalWorkItem.setQuantity(actualWorkItem.getQuantity() - 1);
        }

        WorkItem expectedWorkItem = VistoolTestUtilities.clone(actualWorkItem);
        expectedWorkItem.setId(7L);
        expectedWorkItem.setVersion(1L);

        String actual;
        String endpoint;

        if (batched) {
            actual = objectMapper.writeValueAsString(Arrays.asList(createSaveRequest(actualWorkItem, originalWorkItem)));
            endpoint = "/WorkItems";
        } else {
            actual = objectMapper.writeValueAsString(createSaveRequest(actualWorkItem, originalWorkItem));
            endpoint = "/WorkItem";
        }

        if (expectAuthorized) {
            MvcResult result = mvc.perform(MockMvcRequestBuilders.put(endpoint)
                    .with(csrf())
                    .content(actual)
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

            if (batched) {
                WorkItemBatchSaveResponse response = objectMapper.readValue(
                    result.getResponse().getContentAsByteArray(),
                    WorkItemBatchSaveResponse.class
                );
                actualWorkItem = response.getSavedWorkItems().get(0);
            } else {
                actualWorkItem = objectMapper.readValue(
                    result.getResponse().getContentAsByteArray(),
                    WorkItem.class
                );
            }

            expectedWorkItem.setModifiedDate(actualWorkItem.getModifiedDate());
            assertEquals(expectedWorkItem.getId(), actualWorkItem.getId());
            assertEquals(expectedWorkItem.getVersion(), actualWorkItem.getVersion());
        } else {
            mvc.perform(MockMvcRequestBuilders.put(endpoint)
                    .with(csrf())
                    .content(actual)
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized());
        }
    }

    public void testPutExisting(boolean batched, VistoolUserDTO currentUser, boolean expectAuthorized) throws Exception {
        WorkItem originalWorkItem = VistoolTestUtilities.clone(workItems.get(0));

        WorkItem workItem = VistoolTestUtilities.clone(workItems.get(0));
        workItem.setQuantity(101);

        WorkItem expectedWorkItem = VistoolTestUtilities.clone(workItem);
        expectedWorkItem.setVersion(workItem.getVersion() + 1);

        String originalWorkItemJson;
        String endpoint;

        if (batched) {
            originalWorkItemJson = objectMapper.writeValueAsString(
                Arrays.asList(createSaveRequest(workItem, originalWorkItem))
            );
            endpoint = "/WorkItems";
        } else {
            originalWorkItemJson = objectMapper.writeValueAsString(
                createSaveRequest(workItem, originalWorkItem)
            );
            endpoint = "/WorkItem";
        }

        if (expectAuthorized) {
            MvcResult result = mvc.perform(MockMvcRequestBuilders.put(endpoint)
                    .with(csrf())
                    .content(originalWorkItemJson)
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

            if (batched) {
                WorkItemBatchSaveResponse response = objectMapper.readValue(
                    result.getResponse().getContentAsByteArray(),
                    WorkItemBatchSaveResponse.class
                );
                workItem = response.getSavedWorkItems().get(0);
            } else {
                workItem = objectMapper.readValue(
                    result.getResponse().getContentAsByteArray(),
                    WorkItem.class
                );
            }

            expectedWorkItem.setModifiedDate(workItem.getModifiedDate());
            assertEquals(expectedWorkItem, new WorkItem(workItem));
        } else {
            mvc.perform(MockMvcRequestBuilders.put(endpoint)
                    .with(csrf())
                    .content(originalWorkItemJson)
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized());
        }
    }

    private VistoolUserDTO setupCurrentUser(String role) {
        DimHRPerson dimHrPerson = createDimHrPerson("USER", "USER");
        dimHrPersonRepository.save(dimHrPerson);

        VistoolUserRoleAssignment vistoolUserRoleAssignment =
            new VistoolUserRoleAssignment("USER", role);
        vistoolUserRoleAssignmentRepository.save(vistoolUserRoleAssignment);

        return VistoolTestUtilities.setCurrentUserContextTo("USER", role);
    }

    private void grantAllPermissions(String role) {
        VistoolRoleFieldPermission permission = new VistoolRoleFieldPermission();
        permission.setRole(role);
        permission.setFieldBinding("*");
        vistoolRoleFieldPermissionRepository.save(permission);
    }

    private WorkItem createAdditionalWorkItem() {
        WorkItem workItem = new WorkItem();
        workItem.setParentLineItem(lineItems.get(0));
        workItem.setLinkedWorkOrder("WO-4");
        workItem.setSerialNumber("SN-4");
        workItem.setQuantity(400);
        workItem.setPickAndPlace(VistoolTestUtilities.createPickAndPlace());
        workItem.setProductionPlanning(VistoolTestUtilities.createProductionPlanning());
        return workItem;
    }

    private WorkItemSaveRequest createSaveRequest(WorkItem workItem, WorkItem originalWorkItem) {
        WorkItemSaveRequest workItemSaveRequest = new WorkItemSaveRequest();
        workItemSaveRequest.setWorkItem(workItem);
        workItemSaveRequest.setOriginalWorkItem(originalWorkItem);
        return workItemSaveRequest;
    }

    private DimHRPerson createDimHrPerson(String username, String personID) {
        DimHRPerson dimHrPerson = new DimHRPerson();
        dimHrPerson.setUserId(username);
        dimHrPerson.setPersonNumber(personID);
        return dimHrPerson;
    }
}