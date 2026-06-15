package edu.jhuapl.sd.sig.vistool.vistoolwebservice.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.configuration.vistool.WebSocketTopic;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.logic.WorkItemHydrationLogic;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.*;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.concurrentediting.ConcurrentEditingMessage;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.vistool.WorkItemRepository;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.security.SecurityUtilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.vistool.WorkItemRepository.*;
import static org.springframework.data.jpa.domain.Specification.where;

@Service
public class WorkItemService {
    @Autowired private WorkItemRepository workItemRepository;
    @Autowired private WorkItemHydrationLogic workItemHydrationLogic;
    @Autowired private SimpMessagingTemplate simpMessagingTemplate;
    @Autowired private SecurityUtilities securityUtilities;
    @Autowired private ObjectMapper objectMapper;

    private final Object LOCK = new Object();

    public List<WorkItem> getAllWorkItems() {
        return this.workItemRepository.findAll();
    }


    public Optional<WorkItem> getWorkItemById(Long id) {
        return workItemRepository.findOne(
            where(
                idEqualTo(id)
            )
        );
    }

    public List<WorkItem> getAllWorkItemsByParentLineItem(AbstractLineItem parentLineItem) {
        return workItemRepository.findAll(
            where(parentLineItemEqualTo(parentLineItem))
        );
    }

    public List<HydratedWorkItem> getAllHydratedWorkItems() {
        List<WorkItem> workItems = getAllWorkItems();
        return workItemHydrationLogic.hydrateWorkItems(new ArrayList<AbstractWorkItem>(workItems));
    }

    public Optional<HydratedWorkItem> getHydratedWorkItemById(Long id) {
        Optional<WorkItem> optionalWorkItem = getWorkItemById(id);
        if(optionalWorkItem.isPresent()) {
            HydratedWorkItem hydratedWorkItem = workItemHydrationLogic.hydrateWorkItem(optionalWorkItem.get());
            return Optional.of(hydratedWorkItem);
        }
        return Optional.empty();
    }

    public List<HydratedWorkItem> getHydratedWorkItems(List<WorkItem> workItems) {
        return workItemHydrationLogic.hydrateWorkItems(new ArrayList<>(workItems));
    }

    public HydratedWorkItem getHydratedWorkItem(WorkItem workItem) {
        return workItemHydrationLogic.hydrateWorkItem(workItem);
    }

    public List<HydratedWorkItem> getAllHydratedWorkItemVersionsById(Long id) {
        Optional<WorkItem> workItem = getWorkItemById(id);
        return workItemHydrationLogic.hydrateWorkItems(Arrays.asList(workItem.get()));
    }

    // TODO: Consider removing
    public List<HydratedWorkItem> getAllHydratedWorkItemsByParentLineItem(LineItem parentLineItem) {
        List<WorkItem> workItems = getAllWorkItemsByParentLineItem(parentLineItem);
        return workItemHydrationLogic.hydrateWorkItems(new ArrayList<>(workItems));
    }

    public WorkItem saveWorkItem(WorkItem workItem, boolean isUserInitiatedAction) {
        synchronized(LOCK) {
            if(workItem.getId() == null) {
                Optional<Long> optionalMaxId = getMaxId();
                if(optionalMaxId.isPresent()) {
                    workItem.setId(optionalMaxId.get() + 1);
                } else {
                    workItem.setId(1L);
                }
            }
            // increment the version
            List<WorkItem> workItems = workItemRepository.findAll(where(idEqualTo(workItem.getId())));
            WorkItem latestWorkItemInDB = null;
            Long latestVersionInDB = null;
            if (!workItems.isEmpty()) {
                workItems.sort(Comparator.comparing(WorkItem::getVersion).reversed());
                latestWorkItemInDB = workItems.get(0);
                latestVersionInDB = latestWorkItemInDB.getVersion();
            }
            
            Long workItemVersion;
            if (latestVersionInDB == null) {
                workItemVersion = 0L;
            } else {
                workItemVersion = latestVersionInDB;
                workItemRepository.delete(latestWorkItemInDB);
            }
            workItem.setVersion(++workItemVersion);
            workItem.setModifiedDate(new Date(System.currentTimeMillis()));

            if (isUserInitiatedAction) {
                // check if user logged in if yes, then publish to websocket
                Optional<VistoolUser> vistoolUser = securityUtilities.getCurrentUser();

                if(vistoolUser.isPresent()) {
                    workItem.setUserId(vistoolUser.get().getEmployeeId());
                    ConcurrentEditingMessage concurrentEditingMessage = new ConcurrentEditingMessage(vistoolUser.get());
                    concurrentEditingMessage.setWorkItemId(workItem.getId());
                    concurrentEditingMessage.setValue(workItem.getVersion());

                    publishMessagesToWebSocket(concurrentEditingMessage, WebSocketTopic.WORK_ORDER_SAVED);
                }
            }
            workItem = workItemRepository.save(workItem);

            return workItem;
        }
    }

    public List<WorkItem> saveWorkItems(List<WorkItem> workItems, boolean isUserInitiatedAction) {
       List<WorkItem> savedWorkItems = new ArrayList<>();
       for(WorkItem workItem : workItems) {
           savedWorkItems.add(saveWorkItem(workItem, isUserInitiatedAction));
       }
       return savedWorkItems;
     }

    /**
     * Applies a conflict-aware save for an existing work item by comparing the
     * user's original copy to the current server copy, rejecting overlapping
     * edits, and merging non-conflicting user changes onto the latest version.
     */
    public WorkItem mergeAndSaveWorkItem(WorkItem workItem, WorkItem originalWorkItem, boolean isUserInitiatedAction) {
        synchronized (LOCK) {
            if (workItem.getId() == null) {
                return saveWorkItem(workItem, isUserInitiatedAction);
            }

            WorkItem latestWorkItem = getRequiredLatestWorkItem(workItem.getId());

            if (originalWorkItem == null) {
                throw new IllegalArgumentException("originalWorkItem is required for merge saves");
            }

            List<String> changedFields = getChangedFields(originalWorkItem, workItem);

            List<String> conflictingFields = getConflictingFields(originalWorkItem, latestWorkItem, workItem, changedFields);

            if (!conflictingFields.isEmpty()) {
                HydratedWorkItem latestHydratedWorkItem = workItemHydrationLogic.hydrateWorkItem(latestWorkItem);
                throw new WorkItemConflictException(new WorkItemConflict(
                    workItem.getId(),
                    conflictingFields,
                    latestHydratedWorkItem,
                    "The work item was updated by another user before your save completed."
                ));
            }

            WorkItem mergedWorkItem = new WorkItem(latestWorkItem);
            applyChangedFields(mergedWorkItem, workItem, changedFields);
            return saveWorkItem(mergedWorkItem, isUserInitiatedAction);
        }
    }

    /**
     * Processes a batch of conflict-aware save requests, returning both the
     * successfully saved rows and any conflicts so the UI can partially commit
     * the batch and prompt only for unresolved rows.
     */
    public WorkItemBatchSaveResponse mergeAndSaveWorkItems(List<WorkItemSaveRequest> workItemSaveRequests, boolean isUserInitiatedAction) {
        WorkItemBatchSaveResponse response = new WorkItemBatchSaveResponse();

        for (WorkItemSaveRequest workItemSaveRequest : workItemSaveRequests) {
            try {
                WorkItem savedWorkItem = mergeAndSaveWorkItem(
                    workItemSaveRequest.getWorkItem(),
                    workItemSaveRequest.getOriginalWorkItem(),
                    isUserInitiatedAction
                );
                response.getSavedWorkItems().add(workItemHydrationLogic.hydrateWorkItem(savedWorkItem));
            } catch (WorkItemConflictException e) {
                response.getConflicts().add(e.getWorkItemConflict());
            }
        }

        return response;
    }

    public void deleteWorkItem(WorkItem workItem) {
        synchronized(LOCK) {
            workItemRepository.delete(workItem);
        }
    }

    public void deleteAllWorkItems() {
        synchronized(LOCK) {
            workItemRepository.deleteAll();
        }
    }

    public <T> void publishMessagesToWebSocket(T message, WebSocketTopic webSocketTopic) {
        this.simpMessagingTemplate.convertAndSend(webSocketTopic.value(), message);
    }

    private Optional<Long> getMaxId() {
        List<WorkItem> workItems = workItemRepository.findAll(where(idMaximum()));
        if(!workItems.isEmpty()) {
            return Optional.of(workItems.get(0).getId());
        }
        return Optional.empty();
    }

    private WorkItem getRequiredLatestWorkItem(Long id) {
        List<WorkItem> workItems = workItemRepository.findAll(where(idEqualTo(id)));
        if (workItems.isEmpty()) {
            throw new IllegalArgumentException("Could not find work item with id " + id);
        }

        workItems.sort(Comparator.comparing(WorkItem::getVersion).reversed());
        return workItems.get(0);
    }

    private List<String> getConflictingFields(WorkItem originalWorkItem, WorkItem latestWorkItem, WorkItem updatedWorkItem, List<String> changedFields) {
        List<String> conflictingFields = new ArrayList<>();

        for (String changedField : changedFields) {
            Object originalValue = getFieldValue(originalWorkItem, changedField);
            Object latestValue = getFieldValue(latestWorkItem, changedField);
            Object updatedValue = getFieldValue(updatedWorkItem, changedField);

            if (!Objects.equals(originalValue, latestValue) && !Objects.equals(updatedValue, latestValue)) {
                conflictingFields.add(changedField);
            }
        }

        return conflictingFields;
    }

    private List<String> getChangedFields(WorkItem originalWorkItem, WorkItem updatedWorkItem) {
        List<String> changedFields = new ArrayList<>();
        collectChangedFields(
                objectMapper.valueToTree(originalWorkItem),
                objectMapper.valueToTree(updatedWorkItem),
                "",
                changedFields
        );
        return changedFields;
    }

    private void collectChangedFields(JsonNode originalNode, JsonNode updatedNode, String basePath, List<String> changedFields) {
        if ((originalNode != null && originalNode.isObject()) || (updatedNode != null && updatedNode.isObject())) {
            Set<String> keys = new LinkedHashSet<>();
            if (originalNode != null) {
                originalNode.fieldNames().forEachRemaining(keys::add);
            }
            if (updatedNode != null) {
                updatedNode.fieldNames().forEachRemaining(keys::add);
            }

            for (String key : keys) {
                String path = basePath.isEmpty() ? key : basePath + "." + key;
                JsonNode originalChildNode = originalNode == null ? null : originalNode.get(key);
                JsonNode updatedChildNode = updatedNode == null ? null : updatedNode.get(key);
                collectChangedFields(originalChildNode, updatedChildNode, path, changedFields);
            }
            return;
        }

        if (!Objects.equals(originalNode, updatedNode) && !basePath.isEmpty()) {
            changedFields.add(basePath);
        }
    }

    private void applyChangedFields(WorkItem mergedWorkItem, WorkItem updatedWorkItem, List<String> changedFields) {
        for (String changedField : changedFields) {
            setFieldValue(mergedWorkItem, changedField, getFieldValue(updatedWorkItem, changedField));
        }
    }

    private Object getFieldValue(WorkItem workItem, String path) {
        try {
            Object currentValue = workItem;
            for (String pathSegment : path.split("\\.")) {
                if (currentValue == null) {
                    return null;
                }
                BeanWrapperImpl beanWrapper = new BeanWrapperImpl(currentValue);
                currentValue = beanWrapper.getPropertyValue(pathSegment);
            }
            return currentValue;
        } catch (Exception e) {
            throw new IllegalArgumentException("Unsupported work item field path: " + path, e);
        }
    }

    private void setFieldValue(WorkItem workItem, String path, Object value) {
        try {
            BeanWrapperImpl beanWrapper = new BeanWrapperImpl(workItem);
            beanWrapper.setAutoGrowNestedPaths(true);
            beanWrapper.setPropertyValue(path, value);
        } catch (Exception e) {
            throw new IllegalArgumentException("Unsupported work item field path: " + path, e);
        }
    }
}
