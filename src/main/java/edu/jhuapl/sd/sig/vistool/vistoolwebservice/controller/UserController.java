package edu.jhuapl.sd.sig.vistool.vistoolwebservice.controller;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.DimHRPerson;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.VistoolUserDTO;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.VistoolUserRole;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.VistoolUserRoleAssignment;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.security.SecurityUtilities;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.service.DenodoService;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.service.VistoolPermissionService;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.service.VistoolRoleService;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.service.VistoolUserRoleAssignmentService;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.VistoolUtilities;
import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
@RestController
public class UserController {
    @Autowired
    private DenodoService denodoService;

    @Autowired
    private SecurityUtilities securityUtilities;

    @Autowired
    private VistoolUserRoleAssignmentService vistoolUserRoleAssignmentService;

    @Autowired
    private VistoolPermissionService vistoolPermissionService;

    @Autowired
    private VistoolRoleService vistoolRoleService;

    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VistoolUserDTO> getUserInformation() {
        if (VistoolUtilities.getCurrentUser(securityUtilities) != null) {
            return ResponseEntity.ok(
                new VistoolUserDTO(
                    VistoolUtilities.getCurrentUser(securityUtilities)
                )
            );
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/user/permissions", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> getCurrentUserEditableFields() {
        if (VistoolUtilities.getCurrentUser(securityUtilities) != null) {
            return ResponseEntity.ok(
                vistoolPermissionService.findAllEditableFieldBindingsByRole(
                    VistoolUtilities.getCurrentUser(securityUtilities).getVistoolUserRole()
                )
            );
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @GetMapping(value = "/roles", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> getAllRoles() {
        try {
            if (!VistoolUtilities.currentUserIsAdmin(
                    VistoolUtilities.getCurrentUser(securityUtilities))) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }

            return ResponseEntity.ok(vistoolRoleService.findAllRoleNames());
        } catch (Exception e) {
            log.error("Could not retrieve vistool roles!", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(value = "/user/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VistoolUserDTO> getUserByUsername(@PathVariable("username") String username) {
        try {
            Optional<DimHRPerson> optionalDimHrPerson =
                denodoService.getDimHRPersonWithUserId(username);

            if (optionalDimHrPerson.isPresent()) {
                Optional<VistoolUserRoleAssignment> optionalVistoolUserRoles =
                    vistoolUserRoleAssignmentService.findOneVistoolUserRoleAssignmentByUserId(
                        optionalDimHrPerson.get().getPersonNumber()
                    );

                if (optionalVistoolUserRoles.isPresent()) {
                    return ResponseEntity.ok(
                        new VistoolUserDTO(
                            optionalDimHrPerson.get(),
                            optionalVistoolUserRoles.get().getRole()
                        )
                    );
                } else {
                    VistoolUserRoleAssignment assignment =
                        vistoolUserRoleAssignmentService.changeUserRole(
                            optionalDimHrPerson.get().getPersonNumber(),
                            VistoolUserRole.VIEWER
                        );

                    return ResponseEntity.ok(
                        new VistoolUserDTO(
                            optionalDimHrPerson.get(),
                            assignment.getRole()
                        )
                    );
                }
            }

            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            log.error("Error while searching for user with username: " + username, e);
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value = "/user/role/{roleName}")
    public ResponseEntity<List<VistoolUserDTO>> getAllUsersForRole(
            @PathVariable("roleName") String vistoolUserRole) {

        List<VistoolUserRoleAssignment> vistoolUserRoleAssignments =
            vistoolUserRoleAssignmentService.findAllVistoolUserRoleAssignmentsByRole(vistoolUserRole);

        List<VistoolUserDTO> usersWithRole = new ArrayList<>();

        for (VistoolUserRoleAssignment vistoolUserRoleAssignment : vistoolUserRoleAssignments) {
            Optional<DimHRPerson> optionalHRPersonAll =
                denodoService.getDimHRPersonWithPersonNumber(
                    vistoolUserRoleAssignment.getUserId()
                );

            if (optionalHRPersonAll.isPresent()) {
                usersWithRole.add(
                    new VistoolUserDTO(
                        optionalHRPersonAll.get(),
                        vistoolUserRoleAssignment.getRole()
                    )
                );
            }
        }

        return ResponseEntity.ok(usersWithRole);
    }

    @PutMapping(value = "/user/role")
    public ResponseEntity<?> assignRolesToListOfUsers(@RequestBody List<VistoolUserDTO> vistoolUsers) {
        try {
            if (!VistoolUtilities.currentUserIsAdmin(
                    VistoolUtilities.getCurrentUser(securityUtilities))) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }

            for (VistoolUserDTO vistoolUser : vistoolUsers) {
                vistoolUserRoleAssignmentService.changeUserRole(
                    vistoolUser.getEmployeeId(),
                    vistoolUser.getVistoolUserRole()
                );
            }

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error("Could not save list of roles for users!", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}