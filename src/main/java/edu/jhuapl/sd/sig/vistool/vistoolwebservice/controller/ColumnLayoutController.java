package edu.jhuapl.sd.sig.vistool.vistoolwebservice.controller;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.exceptions.ColumnLayoutException;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.DimHRPerson;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.VistoolUser;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.service.ColumnLayoutService;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.VistoolUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.ColumnLayout;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.security.SecurityUtilities;
import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.Optional;

@Log4j2
@RestController
public class ColumnLayoutController {
    @Autowired SecurityUtilities securityUtilities;
    @Autowired ColumnLayoutService columnLayoutService;

    @GetMapping(value= "/ColumnLayout/Id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ColumnLayout> getColumnLayoutById(@PathVariable("id") int id ) {
        ResponseEntity<ColumnLayout> response;
        Optional<ColumnLayout> columnLayout = columnLayoutService.findOneColumnLayoutById(id);
        if (columnLayout.isPresent()) {
            if (userIsColumnLayoutAuthor(columnLayout.get()) || VistoolUtilities.currentUserIsAdmin(VistoolUtilities.getCurrentUser(securityUtilities))) {
                response = ResponseEntity.ok(columnLayout.get());
            } else {
                response = ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
        } else {
            response = ResponseEntity.badRequest().build();
        }
        return response;
    }

    @PostMapping(value = "/ColumnLayout",  produces = MediaType.APPLICATION_JSON_VALUE, consumes =
            MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createColumnLayout(@RequestBody ColumnLayout columnLayout){
        ResponseEntity response;
        // Save columnLayout
        try {
            columnLayoutService.addColumnLayout(columnLayout);
            response = ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error("Could not save the column layout.", e);
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return response;
    }

    @GetMapping(value = "/ColumnLayout/User/{username}")
    public ResponseEntity<List<ColumnLayout>> getColumnLayoutsByUsername(@PathVariable("username") String username) {
        // TODO: removed previously implemented logic until we need to have column layout based on the user role.
        return ResponseEntity.ok(columnLayoutService.findAllColumnLayoutsByUserId(VistoolUtilities.getCurrentUser(securityUtilities).getEmployeeId()));
    }

    @GetMapping(value = "/ColumnLayout/Visibility/{visible}")
    public ResponseEntity<List<ColumnLayout>> getColumnLayoutsByVisibility(@PathVariable("visible") boolean visible) {
        // If requesting public layouts, OR if the current user is an admin, return the column layout
        if (visible || VistoolUtilities.currentUserIsAdmin(VistoolUtilities.getCurrentUser(securityUtilities))) {
            return ResponseEntity.ok(columnLayoutService.findAllColumnLayoutsByVisibility(visible));
        } else {
            // If requesting public layouts AND current user is not an admin, do not return column layout
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PutMapping(value = "/ColumnLayout/Update/Name")
    public ResponseEntity<ColumnLayout> updateColumnLayoutName(@RequestBody ColumnLayout columnLayout) {
        ResponseEntity<ColumnLayout> responseEntity;
        try {
            // Only update the column layout if the user is the original author or is an admin
            if (userIsColumnLayoutAuthor(columnLayout) || VistoolUtilities.currentUserIsAdmin(VistoolUtilities.getCurrentUser(securityUtilities))) {
                columnLayoutService.updateColumnLayoutName(columnLayout.getId().intValue(), columnLayout.getName());
                responseEntity = ResponseEntity.ok().build();
            } else {
                responseEntity = ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
        } catch (ColumnLayoutException e) {
            log.error(e.getMessage());
            responseEntity = ResponseEntity.badRequest().build();
        }
        return responseEntity;
    }

    @PutMapping(value = "/ColumnLayout/Update/Visibility")
    public ResponseEntity<ColumnLayout> updateColumnLayoutVisibility(@RequestBody ColumnLayout columnLayout) {
        try {
            columnLayoutService.updateColumnLayoutVisibility(columnLayout.getId().intValue(), columnLayout.isVisible());
            return ResponseEntity.ok().build();
        } catch (ColumnLayoutException e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    private boolean userIsAuthenticated() {
        VistoolUser currentUser = VistoolUtilities.getCurrentUser(securityUtilities);
        return currentUser != null;
    }

    private boolean currentUserIsEqualTo(DimHRPerson employee) {
        VistoolUser currentUser = VistoolUtilities.getCurrentUser(securityUtilities);
        // if the current user does not exist, return false
        if (currentUser == null) return false;
        String userId = employee.getPersonNumber();
        return currentUser.getEmployeeId().equals(userId);
    }

    private boolean userIsColumnLayoutAuthor(ColumnLayout columnLayout) {
        VistoolUser currentUser = VistoolUtilities.getCurrentUser(securityUtilities);
        // if current user does not exist, return false
        if (currentUser == null) return false;
        return currentUser.getEmployeeId().equals(columnLayout.getUserId());
    }
}
