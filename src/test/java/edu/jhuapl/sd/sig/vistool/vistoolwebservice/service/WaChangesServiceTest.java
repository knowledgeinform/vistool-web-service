package edu.jhuapl.sd.sig.vistool.vistoolwebservice.service;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.VmSysWorkAuthDetailChangeHistoryVistool;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.WaChanges;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.vistool.WaChangesRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WaChangesServiceTest {
    @Mock
    private WaChangesRepository waChangesRepository;

    @InjectMocks
    private WaChangesService waChangesService;

    @Test
    public void isChanged_originalLineItemChangedSameAsPrevChange_returnsFalseNoSave() {
        VmSysWorkAuthDetailChangeHistoryVistool previousChange = createChange("WA-1", "PART-1", 1, 2);
        VmSysWorkAuthDetailChangeHistoryVistool latestChange = createChange("WA-1", "PART-1", 1, 2);

        when(waChangesRepository.findOneByWorkAuthorizationIdAndPartId("WA-1", "PART-1"))
                .thenReturn(Optional.of(new WaChanges(previousChange)));

        boolean result = waChangesService.isChanged(latestChange);

        assertFalse(result);
        verify(waChangesRepository, never()).save(any(WaChanges.class));
    }

    @Test
    public void isChanged_lineItemChangedWithPrevChange_returnsTrue() {
        VmSysWorkAuthDetailChangeHistoryVistool previousChange = createChange("WA-1", "PART-1", 1, 3);
        WaChanges previous = new WaChanges(previousChange);
        VmSysWorkAuthDetailChangeHistoryVistool latestChange = createChange("WA-1", "PART-1", 1, 2);

        when(waChangesRepository.findOneByWorkAuthorizationIdAndPartId("WA-1", "PART-1"))
                .thenReturn(Optional.of(previous));

        boolean result = waChangesService.isChanged(latestChange);

        assertTrue(result);
        verify(waChangesRepository).save(any(WaChanges.class));
    }

    @Test
    public void isChanged_noLineItemChanges_returnsFalseNoSave() {

        // the original quantity matches the changed quantity - so no changes for this WA line item
        VmSysWorkAuthDetailChangeHistoryVistool latestChange = createChange("WA-1", "PART-1", 1, 1);

        boolean result = waChangesService.isChanged(latestChange);

        assertFalse(result);
        verify(waChangesRepository, never()).findOneByWorkAuthorizationIdAndPartId("WA-1", "PART-1");
        verify(waChangesRepository, never()).save(any(WaChanges.class));
    }


    @Test
    public void isChanged_changeExistsNoPriorChangesExist_returnsTrueSavesTheItem() {
        VmSysWorkAuthDetailChangeHistoryVistool latestChange = createChange("WA-1", "PART-1", 1, 2);

        when(waChangesRepository.findOneByWorkAuthorizationIdAndPartId("WA-1", "PART-1"))
                .thenReturn(Optional.empty());

        boolean result = waChangesService.isChanged(latestChange);

        assertTrue(result);
        verify(waChangesRepository).save(any(WaChanges.class));
    }

    @Test
    public void saveChanges_workAuthorizationIdMissing_noSavePerformed() {
        VmSysWorkAuthDetailChangeHistoryVistool change = createChange(null, "PART-1", 1, 1);

        waChangesService.saveChanges(change, 10L);

        verify(waChangesRepository, never()).save(any(WaChanges.class));
    }

    @Test
    public void saveChanges_workAuthorizationIdValid_savePerformed() {
        VmSysWorkAuthDetailChangeHistoryVistool change = createChange("WA-1", "PART-1", 1, 1);

        waChangesService.saveChanges(change, 10L);

        verify(waChangesRepository).save(any(WaChanges.class));
    }

    private VmSysWorkAuthDetailChangeHistoryVistool createChange(String workAuthorizationId, String partId, Integer quantity, Integer changeLineQuantity) {
        VmSysWorkAuthDetailChangeHistoryVistool change = new VmSysWorkAuthDetailChangeHistoryVistool();
        change.setWorkAuthorizationId(workAuthorizationId);
        change.setPartId(partId);
        change.setLineItem("LI-1");
        change.setQuantity(quantity);
        change.setChangeLineQuantity(changeLineQuantity);
        return change;
    }

}
