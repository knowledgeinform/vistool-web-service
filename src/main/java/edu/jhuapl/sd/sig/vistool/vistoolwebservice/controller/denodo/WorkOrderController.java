package edu.jhuapl.sd.sig.vistool.vistoolwebservice.controller.denodo;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.VeWo;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.WorkItem;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.service.DenodoService;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.service.WorkItemService;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.security.SecurityUtilities;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.VistoolUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class WorkOrderController {
    @Autowired private DenodoService denodoService;
    @Autowired private SecurityUtilities securityUtilities;
    @Autowired private WorkItemService workItemService;

    @GetMapping("/WorkOrders")
    public ResponseEntity<List<VeWo>> getWorkOrders() {
        return ResponseEntity.ok(denodoService.getAllVeWo());
    }

    @GetMapping("/WorkOrder")
    public ResponseEntity<VeWo> getWorkOrder(@RequestParam("workOrderNumber") String workOrderNumber) {
        Optional<VeWo> optionalVeWo = denodoService.getVeWoWithWorkOrderNumber(workOrderNumber);
        if(optionalVeWo.isPresent()) {
            return ResponseEntity.ok(optionalVeWo.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/WorkOrderNumbers")
    public ResponseEntity<List<String>> getWorkOrderNumbers() {
        return ResponseEntity.ok(denodoService.getAllVeWoNumbers());
    }

    @Transactional
    @PutMapping(value = "/LinkWorkOrder", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity linkWorkOrder(@RequestParam("workOrderNumber") String workOrderNumber, @RequestBody WorkItem workItem) {
        if (!VistoolUtilities.currentUserCanEdit(VistoolUtilities.getCurrentUser(securityUtilities))) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You do not have authorization to edit this field for this work item.");
        }

        Optional<VeWo> optionalVeWo = denodoService.getVeWoWithWorkOrderNumber(workOrderNumber);
        if (!optionalVeWo.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No work order was found for the given work order number.");
        }

        VeWo veWo = optionalVeWo.get();
        // TODO: When addressing VIS-873, re-enable this part of the code.
        // if (!workItemLogic.canLinkWorkOrderToWorkItem(veWo, workItem)) {
        //     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Work order could not be linked; the work authorization number on the work order is not a match.");
        // }

        workItem.setLinkedWorkOrder(veWo.getWorkOrderNumber());
        WorkItem savedWorkItem = workItemService.saveWorkItem(workItem, true);
        return ResponseEntity.ok(workItemService.getHydratedWorkItem(savedWorkItem));
    }

}
