package edu.jhuapl.sd.sig.vistool.vistoolwebservice.controller;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.HydratedWorkItem;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.WorkItem;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.WorkItemBatchSaveResponse;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.WorkItemSaveRequest;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.security.SecurityUtilities;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.service.WorkItemService;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.service.WorkItemConflictException;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.VistoolUtilities;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Log4j2
@RestController
public class WorkItemController {
    @Autowired private WorkItemService workItemService;
    @Autowired private SecurityUtilities securityUtilities;

    @GetMapping(value = "/WorkItems", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<HydratedWorkItem>> getHydratedWorkItems() {
        List<HydratedWorkItem> hydratedWorkItems = workItemService.getAllHydratedWorkItems();
        Collections.sort(hydratedWorkItems);
        return ResponseEntity.ok(hydratedWorkItems);
    }

    @GetMapping(value = "/WorkItem/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HydratedWorkItem> getHydratedWorkItem(@PathVariable("id") Long id) {
        Optional<HydratedWorkItem> optionalHydratedWorkItem = workItemService.getHydratedWorkItemById(id);
        if(optionalHydratedWorkItem.isPresent()) {
            return ResponseEntity.ok(optionalHydratedWorkItem.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/WorkItem/{id}/versions", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<HydratedWorkItem>> getHydratedWorkItemVersions(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(workItemService.getAllHydratedWorkItemVersionsById(id));
        } catch(Exception e) {
            log.error("Could not find work items for id " + id);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @Transactional
    @PutMapping(value = "/WorkItems", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WorkItemBatchSaveResponse> putWorkItems(@RequestBody List<WorkItemSaveRequest> workItemSaveRequests) {
        if (!VistoolUtilities.currentUserCanEdit(VistoolUtilities.getCurrentUser(securityUtilities))) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        WorkItemBatchSaveResponse response = workItemService.mergeAndSaveWorkItems(workItemSaveRequests, true);
        if (!response.getConflicts().isEmpty()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }
        return ResponseEntity.ok(response);
    }

    @Transactional
    @PutMapping(value = "/WorkItem", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> putWorkItem(@RequestBody WorkItemSaveRequest workItemSaveRequest) {
        if (!VistoolUtilities.currentUserCanEdit(VistoolUtilities.getCurrentUser(securityUtilities))) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        try {
            WorkItem savedWorkItem = workItemService.mergeAndSaveWorkItem(
                workItemSaveRequest.getWorkItem(),
                workItemSaveRequest.getOriginalWorkItem(),
                true
            );
            return ResponseEntity.ok(workItemService.getHydratedWorkItem(savedWorkItem));
        } catch (WorkItemConflictException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getWorkItemConflict());
        }
    }
}
