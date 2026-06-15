package edu.jhuapl.sd.sig.vistool.vistoolwebservice.logic;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.VmSysWorkAuthDetailChangeHistoryVistool;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.LineItem;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.Status;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.WorkItem;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.service.WaChangesService;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.service.DenodoService;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.service.LineItemService;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.service.WorkItemService;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.VistoolUtilities;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Log4j2
@Component
public class LineItemLogic {
    @Autowired
    private LineItemService lineItemService;
    @Autowired
    private WorkItemService workItemService;
    @Autowired
    private DenodoService denodoService;
    @Autowired
    private WorkItemLogic workItemLogic;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private WaChangesService waChangesService;

    @Value("classpath:openWorkAuthorizations.json")
    private Resource openWorkAuthorizationsFile;
    @Value("classpath:completedWorkAuthorizations.json")
    private Resource completedWorkAuthorizationsFile;

    private List<String> openWorkAuthorizations = null;
    private List<String> completedWorkAuthorizations = null;
    private boolean initialWorkAuthorizationsLoaded = false;

    public void createNewLineItems(Optional<Date> lastScheduledTaskRun) throws IOException {
        loadInitialWorkAuthorizations();
        // If lastScheduledTaskRun exists, then this is not the first time this method
        // is called. Get WAs since the given date
        if (lastScheduledTaskRun.isPresent()) {

            List<VmSysWorkAuthDetailChangeHistoryVistool> vmSysWorkAuthDetailChangeHistoryVistools = new ArrayList<>();
            // get the list of new work auths
            vmSysWorkAuthDetailChangeHistoryVistools
                    .addAll(denodoService.getVmSysWorkAuthWhereSubmitDateOnOrAfter(lastScheduledTaskRun.get()));
            // get the list of new change histories
            vmSysWorkAuthDetailChangeHistoryVistools.addAll(
                    denodoService.getAllVmSysWorkAuthChangeHistoryWhereSubmitDateOnOrAfter(lastScheduledTaskRun.get()));

            // remove duplicates
            vmSysWorkAuthDetailChangeHistoryVistools = new ArrayList<>(new HashSet<>(vmSysWorkAuthDetailChangeHistoryVistools));
            Set<String> ids = vmSysWorkAuthDetailChangeHistoryVistools.stream().map(VmSysWorkAuthDetailChangeHistoryVistool::getWorkAuthorizationId).collect(Collectors.toSet());

            List<VmSysWorkAuthDetailChangeHistoryVistool> vmSysWorkAuthDetails = denodoService.getAllVmSysWorkAuthDetailForProvidedVmSysWorkAuthIds(ids);

            for (VmSysWorkAuthDetailChangeHistoryVistool vmSysWorkAuthDetailChangeHistoryVistool : vmSysWorkAuthDetails) {
                Optional<LineItem> optionalLineItem = getExistingLineItemIfExists(
                        vmSysWorkAuthDetailChangeHistoryVistool);
                if (optionalLineItem.isEmpty()) {
                    optionalLineItem = Optional.of(createNewLineItem(vmSysWorkAuthDetailChangeHistoryVistool,
                            Optional.empty(), Optional.empty()));
                }
                updateExistingLineItem(optionalLineItem.get(), lastScheduledTaskRun.get());
            }
        } else {
            // will be here the first time that the server runs the scheduled tasks.
            List<VmSysWorkAuthDetailChangeHistoryVistool> vmSysWorkAuths = denodoService
                    .getAllVmSysWorkAuthWhereSubmitDateNotNull();
            for (VmSysWorkAuthDetailChangeHistoryVistool vmSysWorkAuth : vmSysWorkAuths) {
                Optional<LineItem> optionalLineItem = getExistingLineItemIfExists(vmSysWorkAuth);
                if (optionalLineItem.isEmpty()) {
                    LineItem lineItem = null;
                    // Create line items for open WAs in configurable json file
                    if (openWorkAuthorizations.contains(vmSysWorkAuth.getWorkAuthorizationId())) {
                        lineItem = createNewLineItem(vmSysWorkAuth, Optional.empty(), Optional.of(Status.INPROCESS));
                    }
                    // Create line items for completed WAs in configurable json file
                    else if (completedWorkAuthorizations.contains(vmSysWorkAuth.getWorkAuthorizationId())) {
                        lineItem = createNewLineItem(vmSysWorkAuth, Optional.empty(), Optional.of(Status.COMPLETED));
                    }

                    if (lineItem != null) {
                        updateExistingLineItem(lineItem, null);
                    }
                } else {
                    updateExistingLineItem(optionalLineItem.get(), null);
                }

                // regardless of status add WA to wa changes table, if it does not exist
                waChangesService.saveChanges(vmSysWorkAuth);
            }
        }
    }

    private LineItem createNewLineItem(VmSysWorkAuthDetailChangeHistoryVistool vmSysWorkAuthDetailChangeHistoryVistool,
                                       Optional<Integer> quantity, Optional<Status> status) {
        log.debug("Creating brand new line item with modified date.");
        LineItem lineItem = new LineItem();
        lineItem.setModifiedDate(vmSysWorkAuthDetailChangeHistoryVistool.getChangeSubmitDate() != null ? new Date(vmSysWorkAuthDetailChangeHistoryVistool.getChangeSubmitDate().getTime() + 5000) : new Date(System.currentTimeMillis()));
        lineItem.setWorkAuthorizationNumber(vmSysWorkAuthDetailChangeHistoryVistool.getWorkAuthorizationId());
        lineItem.setLineItemNumber(vmSysWorkAuthDetailChangeHistoryVistool.getLineItem());
        lineItem.setQuantity(vmSysWorkAuthDetailChangeHistoryVistool.getQuantity());
        lineItem = lineItemService.saveLineItem(lineItem);

        workItemLogic.createAndSaveNewWorkItem(lineItem, quantity, status);

        waChangesService.saveChanges(vmSysWorkAuthDetailChangeHistoryVistool, lineItem.getId());

        return lineItem;
    }

    private Optional<LineItem> getExistingLineItemIfExists(
            VmSysWorkAuthDetailChangeHistoryVistool vmSysWorkAuthDetailChangeHistoryVistool) {
        return lineItemService.getLineItemByWorkAuthorizationNumberAndLineItemNumber(
                vmSysWorkAuthDetailChangeHistoryVistool.getWorkAuthorizationId(),
                vmSysWorkAuthDetailChangeHistoryVistool.getLineItem());
    }

    private void updateExistingLineItem(LineItem lineItem, Date lastScheduledTaskRun) {
        List<VmSysWorkAuthDetailChangeHistoryVistool> workAuthorizationChanges = denodoService
                .getAllVmSysWorkAuthChangeHistoryWithSpecifiedValues(lineItem.getWorkAuthorizationNumber(),
                        lineItem.getLineItemNumber());
        if (workAuthorizationChanges.isEmpty()) {
            return;
        }
        workAuthorizationChanges = workAuthorizationChanges.stream()
                .filter(list -> list.getChangeSubmitDate() != null)
                .collect(Collectors.toList());

        // Only update the line item if the last modified date or last scheduled task
        // run is later than the change submit date or both are null.
        Date lineItemModifiedDate = lineItem.getModifiedDate();
        Date checkDate = null;
        if (lineItemModifiedDate != null) {
            checkDate = lineItemModifiedDate;
            if (lastScheduledTaskRun != null) {
                if (lastScheduledTaskRun.after(lineItemModifiedDate)) {
                    checkDate = lastScheduledTaskRun;
                }
            }
        }
        if (checkDate != null) {
            // get only changes that were submitted after last scheduled task run
            Date checkDateFinal = checkDate;
            workAuthorizationChanges = workAuthorizationChanges.stream()
                    .filter(list -> !list.getChangeSubmitDate().before(checkDateFinal))
                    .collect(Collectors.toList());
        }

        if (!workAuthorizationChanges.isEmpty()) {
            log.debug("Found work authorization changes.");
            workAuthorizationChanges
                    .sort(Comparator.comparing(VmSysWorkAuthDetailChangeHistoryVistool::getChangeSubmitDate)
                            .reversed());

            VmSysWorkAuthDetailChangeHistoryVistool latestWorkAuthorizationChange = workAuthorizationChanges.get(0);

            log.debug("Latest work authorization change: {}", latestWorkAuthorizationChange.toString());
            log.debug("Last scheduled task run: {}", lastScheduledTaskRun);

            /*
                The below code is used only for 1.2.1 -> 1.3.x upgrade in order to update newly added lineitem modified_date column.
                The code runs at boot time only when modified_date column is present but not up to date.

                Note that SQL solution of updating modified date was considered instead of the below code.
                However, due to denodo query requirement, denodoService.getAllVmSysWorkAuthWhereSubmitDateNotNull();, the idea was abandoned.
             */
            if (lineItemModifiedDate == null && lastScheduledTaskRun == null) {
                log.debug("Line item modified date and last scheduled task run are null.");

                LineItem oldLineItem = VistoolUtilities.cloneLineItem(lineItem);
                lineItem.setModifiedDate(new Date(latestWorkAuthorizationChange.getChangeSubmitDate().getTime() + 5000));
                lineItem = lineItemService.saveLineItem(lineItem);

                waChangesService.saveChanges(latestWorkAuthorizationChange, lineItem.getId());

                List<WorkItem> workItems = workItemLogic.setParentLineItemForRelatedWorkItems(oldLineItem, lineItem);
                workItemService.saveWorkItems(workItems, false);
                lineItemService.deleteLineItem(oldLineItem);

                return;
            }

            if (waChangesService.isChanged(latestWorkAuthorizationChange)) {
                LineItem oldLineItem = VistoolUtilities.cloneLineItem(lineItem);
                if (latestWorkAuthorizationChange.getChangeLineQuantity() != null &&
                        latestWorkAuthorizationChange.getChangeLineQuantity().intValue() != lineItem.getQuantity()
                                .intValue()) {
                    lineItem.setQuantity(latestWorkAuthorizationChange.getChangeLineQuantity());
                }

                lineItem.setModifiedDate(new Date(System.currentTimeMillis()));
                lineItem = lineItemService.saveLineItem(lineItem);
                List<WorkItem> workItems = workItemLogic.setParentLineItemForRelatedWorkItems(oldLineItem, lineItem);
                String changeComment = "";
                if ((latestWorkAuthorizationChange.getChangeComment() != null)) {
                    changeComment = latestWorkAuthorizationChange.getChangeComment();
                }
                workItems = workItemLogic.setStatusAndCommentForRelatedWorkItems(workItems, Status.CHANGED, changeComment);
                log.debug("Set work item status to changed and save work item.");
                workItemService.saveWorkItems(workItems, false);

                // create new line item only when quantity changes
                if (latestWorkAuthorizationChange.getChangeLineQuantity() != null && latestWorkAuthorizationChange
                        .getChangeLineQuantity() > oldLineItem.getQuantity()) {
                    log.debug("Quantity changed - create and save new work item. Set line item status to changed.");
                    workItemLogic.createAndSaveNewWorkItem(
                            lineItem,
                            Optional.of(latestWorkAuthorizationChange.getChangeLineQuantity()
                                    - oldLineItem.getQuantity()),
                            Optional.of(Status.CHANGED));
                }

                lineItemService.deleteLineItem(oldLineItem);
            }

        }
    }

    public boolean checkIfWorkAuthorizationInInitialCompletedSet(@NonNull String workAuthorizationNumber) {
        loadInitialWorkAuthorizations();
        if (completedWorkAuthorizations.contains(workAuthorizationNumber)) {
            return true;
        }
        return false;
    }

    private void loadInitialWorkAuthorizations() {
        {
            if (!initialWorkAuthorizationsLoaded) {
                try {
                    openWorkAuthorizations = objectMapper.readValue(openWorkAuthorizationsFile.getFile(),
                            objectMapper.getTypeFactory().constructCollectionType(List.class, String.class));
                } catch (Exception exception) {
                    log.error(exception);
                    openWorkAuthorizations = Collections.emptyList();
                }
                try {
                    completedWorkAuthorizations = objectMapper.readValue(completedWorkAuthorizationsFile.getFile(),
                            objectMapper.getTypeFactory().constructCollectionType(List.class, String.class));
                } catch (Exception exception) {
                    log.error(exception);
                    completedWorkAuthorizations = Collections.emptyList();
                }
                initialWorkAuthorizationsLoaded = true;
            }
        }
    }
}
