package edu.jhuapl.sd.sig.vistool.vistoolwebservice.service;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.VmSysWorkAuthDetailChangeHistoryVistool;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.WaChanges;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.vistool.WaChangesRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Encapsulates change detection and persistence for work-authorization line item snapshots
 * (i.e whenever we are notified that we have a WA change).
 * Provides a single place to compare incoming Denodo changes against stored WaChanges line items and
 * to create missing/new change entries in the wa_changes table.
 */
@Log4j2
@Service
public class WaChangesService {
    @Autowired
    private WaChangesRepository waChangesRepository;

    /**
     * Saves a WaChanges snapshot for the provided work authorization data.
     * Convenience overload when no line item id is available for logging.
     *
     * @param workAuthorization incoming Denodo snapshot used to seed WaChanges
     */
    public void saveChanges(VmSysWorkAuthDetailChangeHistoryVistool workAuthorization) {
        saveChanges(workAuthorization, null);
    }

    /**
     * Saves a WaChanges snapshot for the provided work authorization data.
     * Logs an error when the work authorization id is missing; no write is performed in that case.
     *
     * @param workAuthorization incoming Denodo data used for the WaChanges
     * @param lineItemId line item id for log context; may be null
     */
    public void saveChanges(VmSysWorkAuthDetailChangeHistoryVistool workAuthorization, Long lineItemId) {
        if (workAuthorization.getWorkAuthorizationId() != null) {
            waChangesRepository.save(new WaChanges(workAuthorization));
        } else {
            log.error("Failed to save new WA changes - missing work authorization ID for line item with id {}",
                    lineItemId);
        }
    }

    /**
     * Compares the latest change against the stored WaChanges snapshot  (if there is one) and persists updates when changed.
     *
     * @param latestWorkAuthorizationChange latest Denodo change details for a particular line item on a WA
     * @return true when a change is detected or when no prior snapshot exists; false otherwise
     */
    public boolean isChanged(VmSysWorkAuthDetailChangeHistoryVistool latestWorkAuthorizationChange) {
        // first, check to see if the change request contains an actual change
        if (!hasChangeComparedToOriginal(latestWorkAuthorizationChange)) {
            return false;
        }

        // if we get here, then the line item has changed since it was originally created. However, this change record could
        // have details from a previous change. Therefore, compare against the stored details in the VisTool db to determine if this
        // is a recent change or if another line item on this WA has changed and these details are changes we've already
        // seen for this line item.
        Optional<WaChanges> previouslySavedWaChanges = waChangesRepository
                .findOneByWorkAuthorizationIdAndPartId(latestWorkAuthorizationChange.getWorkAuthorizationId(),
                        latestWorkAuthorizationChange.getPartId());

        if (previouslySavedWaChanges.isPresent()) {
            if (previouslySavedWaChanges.get().compareTo(latestWorkAuthorizationChange)) {
                waChangesRepository.save(new WaChanges(latestWorkAuthorizationChange));
                return true;
            }
        } else {
            log.warn("Failed to find WA changes entry for latest work authorization change with work authorization id {} and line item {}." +
                            "Creating new WaChanges entry. Investigate reason why line item was missing from WA changes table.",
                    latestWorkAuthorizationChange.getWorkAuthorizationId(), latestWorkAuthorizationChange.getLineItem());
            waChangesRepository.save(new WaChanges(latestWorkAuthorizationChange));

            // assuming this is actual change
            return true;
        }

        return false;
    }

    /**
     * When a WA changes, change request details from Denodo contain a change request record for each line item on the WA.
     * However, not all line items on the WA may have changed, so this method is comparing the change details against
     * the original WA details (i.e. when the line item was first created). If these are different, then there is an actual
     * change for the line item.
     * @param latestWorkAuthorizationChange details from Denodo regarding the change
     * @return true if there is a change compared to the original WA line item data
     */
    private boolean hasChangeComparedToOriginal(VmSysWorkAuthDetailChangeHistoryVistool latestWorkAuthorizationChange) {
        return hasChange(latestWorkAuthorizationChange.getChangeWorkAuthorizationId(), latestWorkAuthorizationChange.getHeaderId()) ||
                hasChange(latestWorkAuthorizationChange.getChangeLineItemNumber(), latestWorkAuthorizationChange.getLineItem()) ||
                hasChange(latestWorkAuthorizationChange.getChangeLineQuantity(), latestWorkAuthorizationChange.getQuantity()) ||
                hasChange(latestWorkAuthorizationChange.getChangeLineSplitId(), latestWorkAuthorizationChange.getSplitId()) ||
                hasChange(latestWorkAuthorizationChange.getChangeTa(), latestWorkAuthorizationChange.getDetailTa()) ||
                hasChange(latestWorkAuthorizationChange.getChangeLinePartId(), latestWorkAuthorizationChange.getPartId()) ||
                hasChange(latestWorkAuthorizationChange.getChangeLinePartRevision(), latestWorkAuthorizationChange.getRevision()) ||
                hasChange(latestWorkAuthorizationChange.getChangeLineFlow(), latestWorkAuthorizationChange.getWorkAuthorizationFlowId()) ||
                hasChange(latestWorkAuthorizationChange.getChangeLineNeedDate(), latestWorkAuthorizationChange.getWantDate());
    }

    private boolean hasChange(Object changeValue, Object originalValue) {
        return changeValue != null && !changeValue.equals(originalValue);
    }
}
