package edu.jhuapl.sd.sig.vistool.vistoolwebservice.service;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.*;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.denodo.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.constants.denodo.DenodoServiceConstants.*;
import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.denodo.VeUsersRepository.personIDEqualTo;
import static org.springframework.data.jpa.domain.Specification.where;

@Service
@Log4j2
public class DenodoService {
    @Autowired private DimHRPersonRepository dimHrPersonRepository;
    @Autowired private VeMasterWoOpsRepository veMasterWoOpsRepository;
    @Autowired private VeMasterWoRepository veMasterWoRepository; 
    @Autowired private VePartsRepository vePartsRepository; 
    @Autowired private VeShopResourceRepository veShopResourceRepository; 
    @Autowired private VeSpecialPartsRepository veSpecialPartsRepository; 
    @Autowired private VeUsersRepository veUsersRepository; 
    @Autowired private VeWoRepository veWoRepository; 
    @Autowired private VeWoLaborTotalsRepository veWoLaborTotalsRepository; 
    @Autowired private VeWoOpsRepository veWoOpsRepository; 
    @Autowired private VeWoOpsEquipmentRepository veWoOpsEquipmentRepository; 
    @Autowired private VeWoOpsLaborRepository veWoOpsLaborRepository;
    @Autowired private VeWoOpsMaterialRepository veWoOpsMaterialRepository; 
    @Autowired
    private VmSysDataDictionaryRepository vmSysDataDictionaryRepository;
    @Autowired
    private VmSysWorkAuthDetailChangeHistoryVistoolRepository vmSysWorkAuthChangeHistoryVistoolRepository;
    @Autowired private VmSysWorkAuthDocRepository vmSysWorkAuthDocRepository;

    public List<DimHRPerson> getAllDimHRPerson() {
        return dimHrPersonRepository.findAll();
    }

    public Optional<DimHRPerson> getDimHRPersonWithPersonNumber(String personNumber) {
        return dimHrPersonRepository.findOne(
                where(DimHRPersonRepository.personNumberEqualTo(personNumber))
        );
    }

    public Optional<DimHRPerson> getDimHRPersonWithUserId(String userId) {
        return dimHrPersonRepository.findOne(
                where(DimHRPersonRepository.userIdEqualTo(userId))
        );
    }

    public List<DimHRPerson> addDimHRPerson(List<DimHRPerson> dimHrPersonList) {
        List<DimHRPerson> dimHrPersonAdded = new ArrayList<>();
        if (dimHrPersonList != null && !dimHrPersonList.isEmpty()) {
            dimHrPersonAdded = dimHrPersonRepository.saveAll(dimHrPersonList);
        }
        return dimHrPersonAdded;
    }

    public void deleteAllDimHRPerson() {
        dimHrPersonRepository.deleteAll();
    }

    public List<VeMasterWoOps> getAllVeMasterWoOps() {
        return veMasterWoOpsRepository.findAll();
    }

    public List<VeMasterWoOps> addVeMasterWoOps(List<VeMasterWoOps> veMasterWoOpsList) {
        List<VeMasterWoOps> veMasterWoOpsAdded = new ArrayList<VeMasterWoOps>();
        if (veMasterWoOpsList != null && !veMasterWoOpsList.isEmpty()) {
            veMasterWoOpsAdded = veMasterWoOpsRepository.saveAll(veMasterWoOpsList);
        }
        return veMasterWoOpsAdded;
    }

    public void deleteAllVeMasterWoOps() {
        veMasterWoOpsRepository.deleteAll();
    }

    public List<VeMasterWo> getAllVeMasterWo() {
        return veMasterWoRepository.findAll();
    }

    public List<VeMasterWo> addVeMasterWo(List<VeMasterWo> veMasterWoList) {
        List<VeMasterWo> veMasterWoAdded = new ArrayList<VeMasterWo>();
        if (veMasterWoList != null && !veMasterWoList.isEmpty()) {
            veMasterWoAdded = veMasterWoRepository.saveAll(veMasterWoList);
        }
        return veMasterWoAdded;
    }

    public void deleteAllVeMasterWo() {
        veMasterWoRepository.deleteAll();
    }

    public List<VeParts> getAllVeParts() {
        return vePartsRepository.findAll();
    }

    public List<VeParts> addVeParts(List<VeParts> vePartsList) {
        List<VeParts> vePartsAdded = new ArrayList<VeParts>();
        if (vePartsList != null && !vePartsList.isEmpty()) {
            vePartsAdded = vePartsRepository.saveAll(vePartsList);
        }
        return vePartsAdded;
    }

    public void deleteAllVeParts() {
        vePartsRepository.deleteAll();
    }

    public List<VeShopResource> getAllVeShopResource() {
        return veShopResourceRepository.findAll();
    }

    public List<VeShopResource> addVeShopResource(List<VeShopResource> veShopResourceList) {
        List<VeShopResource> veShopResourceAdded = new ArrayList<VeShopResource>();
        if (veShopResourceList != null && !veShopResourceList.isEmpty()) {
            veShopResourceAdded = veShopResourceRepository.saveAll(veShopResourceList);
        }
        return veShopResourceAdded;
    }

    public void deleteAllVeShopResource() {
        veShopResourceRepository.deleteAll();
    }

    public List<VeSpecialParts> getAllVeSpecialParts() {
        return veSpecialPartsRepository.findAll();
    }

    public List<VeSpecialParts> addVeSpecialParts(List<VeSpecialParts> veSpecialPartsList) {
        List<VeSpecialParts> veSpecialPartsAdded = new ArrayList<VeSpecialParts>();
        if (veSpecialPartsList != null && !veSpecialPartsList.isEmpty()) {
            veSpecialPartsAdded = veSpecialPartsRepository.saveAll(veSpecialPartsList);
        }
        return veSpecialPartsAdded;
    }

    public void deleteAllVeSpecialParts() {
        veSpecialPartsRepository.deleteAll();
    }

    public List<VeUsers> getAllVeUsers() {
        return veUsersRepository.findAll();
    }

    public Optional<VeUsers> findVeUserById(String id) {
        return veUsersRepository.findOne(
                where(personIDEqualTo(id))
        );
    }

    public List<VeUsers> addVeUsers(List<VeUsers> veUsersList) {
        List<VeUsers> veUsersAdded = new ArrayList<VeUsers>();
        if (veUsersList != null && !veUsersList.isEmpty()) {
            veUsersAdded = veUsersRepository.saveAll(veUsersList);
        }
        return veUsersAdded;
    }

    public void deleteAllVeUsers() {
        veUsersRepository.deleteAll();
    }

    public List<VeWo> getAllVeWo() {
        return veWoRepository.findAll();
    }

    public Optional<VeWo> getVeWoWithWorkOrderNumber(String woNumber) {
        return veWoRepository.findOne(
                where(VeWoRepository.workOrderNumberEqualTo(woNumber))
        );
    }

    public List<String> getAllVeWoNumbers() {
        List<VeWo> veWos = getAllVeWo();
        List<String> workOrderNumbers = new ArrayList<>();
        for (VeWo veWo : veWos) {
            workOrderNumbers.add(veWo.getWorkOrderNumber());
        }
        return workOrderNumbers;
    }

    public List<String> getAllVeWoNumbersWithPartId(String partId) {
        List<String> veWoNums = new ArrayList<String>();
        List<VeWo> veWos = veWoRepository.findAll(where(VeWoRepository.partIDEqualTo(partId)));
        for (VeWo veWo : veWos) {
            veWoNums.add(veWo.getWorkOrderNumber());
        }

        return veWoNums;
    }

    public List<VeWo> addVeWo(List<VeWo> veWoList) {
        List<VeWo> veWoAdded = new ArrayList<VeWo>();
        if (veWoList != null && !veWoList.isEmpty()) {
            veWoAdded = veWoRepository.saveAll(veWoList);
        }
        return veWoAdded;
    }

    public void deleteAllVeWo() {
        veWoRepository.deleteAll();
    }

    public List<VeWoLaborTotals> getAllVeWoLaborTotals() {
        return veWoLaborTotalsRepository.findAll();
    }

    public List<VeWoLaborTotals> addVeWoLaborTotals(List<VeWoLaborTotals> veWoLaborTotalsList) {
        List<VeWoLaborTotals> veWoLaborTotalsAdded = new ArrayList<VeWoLaborTotals>();
        if (veWoLaborTotalsList != null && !veWoLaborTotalsList.isEmpty()) {
            veWoLaborTotalsAdded = veWoLaborTotalsRepository.saveAll(veWoLaborTotalsList);
        }
        return veWoLaborTotalsAdded;
    }

    public void deleteAllVeWoLaborTotals() {
        veWoLaborTotalsRepository.deleteAll();
    }

    public List<VeWoOps> getAllVeWoOps() {
        return veWoOpsRepository.findAll();
    }

    public List<VeWoOps> getVeWoOpsByWorkOrderNumber(String workOrderNumber) {
        return veWoOpsRepository.findAll(
                where(VeWoOpsRepository.workOrderNumberEqualTo(workOrderNumber)
                ));
    }

    public Optional<VeWoOps> findCurrentStep(String workOrderNumber) {
        List<VeWoOps> veWoOps = veWoOpsRepository.findAll(
                where(VeWoOpsRepository.workOrderNumberEqualTo(workOrderNumber)
                        .and(VeWoOpsRepository.statusEqualTo(RELEASED))
                ));
        if (!veWoOps.isEmpty()) {
            veWoOps.sort(Comparator.comparing(VeWoOps::getSequenceNumber));
            return Optional.of(veWoOps.get(0));
        }
        return Optional.empty();
    }

    public List<VeWoOps> findNextSteps(String workOrderNumber, Double sequenceNumber) {
        return veWoOpsRepository.findAll(
                where(VeWoOpsRepository.workOrderNumberEqualTo(workOrderNumber)
                        .and(VeWoOpsRepository.sequenceNumberGreaterThan(sequenceNumber))
                        .and(VeWoOpsRepository.statusEqualTo(RELEASED).or(VeWoOpsRepository.statusEqualTo(COMPLETED)))
                ));
    }

    /**
     * Refresh veWoOpsRepository with veWoOps data.
     *
     * <ul>
     *     <li>Find and delete existing WO data</li>
     *     <li>Update repo with latest weWoOpsList</li>
     * </ul>
     *
     * @param veWoOpsList lastest veWoOpsList
     */
    public void refreshVeWoOpsRepo(List<VeWoOps> veWoOpsList) {
        List<VeWoOps> validVeWoOpsList = normalizeAndFilterVeWoOps(veWoOpsList, "refresh");
        if(!validVeWoOpsList.isEmpty()) {
            validVeWoOpsList.stream().map(VeWoOps::getWorkOrderBaseID).collect(Collectors.toSet()).forEach((woBaseId) -> {
                veWoOpsRepository.deleteAll(
                        veWoOpsRepository.findAll(where(VeWoOpsRepository.workOrderBaseIDEqualTo(woBaseId)))
                );
            });

            veWoOpsRepository.saveAll(validVeWoOpsList);
        }
    }

    public List<VeWoOps> addVeWoOps(List<VeWoOps> veWoOpsList) {
        List<VeWoOps> veWoOpsAdded = new ArrayList<VeWoOps>();
        List<VeWoOps> validVeWoOpsList = normalizeAndFilterVeWoOps(veWoOpsList, "insert");
        if (!validVeWoOpsList.isEmpty()) {
            for (VeWoOps veWoOps : validVeWoOpsList) {
                Optional<VeWoOps> veWoOpsOptional = veWoOpsRepository.findOne(
                        where(VeWoOpsRepository.workOrderNumberEqualTo(veWoOps.getWorkOrderNumber())
                                .and(VeWoOpsRepository.sequenceNumberEqualTo(veWoOps.getSequenceNumber()))));
                if (veWoOpsOptional.isPresent()) {
                    veWoOpsRepository.delete(veWoOpsOptional.get());
                }
            }
            veWoOpsAdded = veWoOpsRepository.saveAll(validVeWoOpsList);
        }
        return veWoOpsAdded;
    }

    private List<VeWoOps> normalizeAndFilterVeWoOps(List<VeWoOps> veWoOpsList, String operation) {
        if (veWoOpsList == null || veWoOpsList.isEmpty()) {
            return Collections.emptyList();
        }

        List<VeWoOps> invalidVeWoOpsList = veWoOpsList.stream()
                .filter(Objects::nonNull)
                .filter(veWoOps -> veWoOps.getWorkOrderNumber() == null)
                .collect(Collectors.toList());

        if (!invalidVeWoOpsList.isEmpty()) {
            log.warn("Skipping {} invalid VeWoOps rows during {}. Example row: primaryKey={}, workOrderNumber={}, sequenceNumber={}, runType={}, resourceID={}, workOrderBaseID={}",
                    invalidVeWoOpsList.size(),
                    operation,
                    invalidVeWoOpsList.get(0).getPrimaryKey(),
                    invalidVeWoOpsList.get(0).getWorkOrderNumber(),
                    invalidVeWoOpsList.get(0).getSequenceNumber(),
                    invalidVeWoOpsList.get(0).getRunType(),
                    invalidVeWoOpsList.get(0).getResourceID(),
                    invalidVeWoOpsList.get(0).getWorkOrderBaseID());
        }

        return veWoOpsList.stream()
                .filter(Objects::nonNull)
                .filter(veWoOps -> veWoOps.getWorkOrderNumber() != null)
                .collect(Collectors.toList());
    }

    public void deleteAllVeWoOps() {
        veWoOpsRepository.deleteAll();
    }

    public List<VeWoOpsEquipment> getAllVeWoOpsEquipment() {
        return veWoOpsEquipmentRepository.findAll();
    }

    public List<VeWoOpsEquipment> addVeWoOpsEquipment(List<VeWoOpsEquipment> veWoOpsEquipmentList) {
        List<VeWoOpsEquipment> veWoOpsEquipmentAdded = new ArrayList<VeWoOpsEquipment>();
        if (veWoOpsEquipmentList != null && !veWoOpsEquipmentList.isEmpty()) {
            veWoOpsEquipmentAdded = veWoOpsEquipmentRepository.saveAll(veWoOpsEquipmentList);
        }
        return veWoOpsEquipmentAdded;
    }

    public void deleteAllVeWoOpsEquipment() {
        veWoOpsEquipmentRepository.deleteAll();
    }

    public List<VeWoOpsLabor> getAllVeWoOpsLabor() {
        return veWoOpsLaborRepository.findAll();
    }

    public List<VeWoOpsLabor> addVeWoOpsLabor(List<VeWoOpsLabor> veWoOpsLaborList) {
        List<VeWoOpsLabor> veWoOpsLaborAdded = new ArrayList<VeWoOpsLabor>();
        if (veWoOpsLaborList != null && !veWoOpsLaborList.isEmpty()) {
            veWoOpsLaborAdded = veWoOpsLaborRepository.saveAll(veWoOpsLaborList);
        }
        return veWoOpsLaborAdded;
    }

    public void deleteAllVeWoOpsLabor() {
        veWoOpsLaborRepository.deleteAll();
    }

    public List<VeWoOpsMaterial> getAllVeWoOpsMaterial() {
        return veWoOpsMaterialRepository.findAll();
    }

    public List<VeWoOpsMaterial> addVeWoOpsMaterial(List<VeWoOpsMaterial> veWoOpsMaterialList) {
        List<VeWoOpsMaterial> veWoOpsMaterialAdded = new ArrayList<VeWoOpsMaterial>();
        if (veWoOpsMaterialList != null && !veWoOpsMaterialList.isEmpty()) {
            veWoOpsMaterialAdded = veWoOpsMaterialRepository.saveAll(veWoOpsMaterialList);
        }
        return veWoOpsMaterialAdded;
    }

    public void deleteAllVeWoOpsMaterial() {
        veWoOpsMaterialRepository.deleteAll();
    }

    public List<VmSysDataDictionary> getAllVmSysDataDictionary() {
        return vmSysDataDictionaryRepository.findAll();
    }

    public List<VmSysDataDictionary> addVmSysDataDictionary(List<VmSysDataDictionary> vmSysDataDictionaryList) {
        List<VmSysDataDictionary> vmSysDataDictionaryAdded = new ArrayList<VmSysDataDictionary>();
        if (vmSysDataDictionaryList != null && !vmSysDataDictionaryList.isEmpty()) {
            vmSysDataDictionaryAdded = vmSysDataDictionaryRepository.saveAll(vmSysDataDictionaryList);
        }
        return vmSysDataDictionaryAdded;
    }

    public void deleteAllVmSysDataDictionary() {
        vmSysDataDictionaryRepository.deleteAll();
    }

    public List<VmSysWorkAuthDetailChangeHistoryVistool> getAllVmSysWorkAuthChangeHistoryVistool() {
        return vmSysWorkAuthChangeHistoryVistoolRepository.findAll();
    }

    public List<VmSysWorkAuthDetailChangeHistoryVistool> getAllVmSysWorkAuthWhereSubmitDateNotNull() {
        return vmSysWorkAuthChangeHistoryVistoolRepository.findAll(
                Specification.where(
                        VmSysWorkAuthDetailChangeHistoryVistoolRepository.submitDateIsNotNull()
                )
        );
    }

    public List<VmSysWorkAuthDetailChangeHistoryVistool> getVmSysWorkAuthWhereSubmitDateOnOrAfter(Date date) {
        return vmSysWorkAuthChangeHistoryVistoolRepository.findAll(
                Specification.where(
                        VmSysWorkAuthDetailChangeHistoryVistoolRepository.submitDateOnOrAfter(date)
                )
        );
    }

    public Optional<VmSysWorkAuthDetailChangeHistoryVistool> getVmSysWorkAuthWithSpecifiedValues(
            String workAuthorizationNumber) {
        return vmSysWorkAuthChangeHistoryVistoolRepository.findOne(
                Specification.where(VmSysWorkAuthDetailChangeHistoryVistoolRepository
                        .workAuthorizationIdEqualTo(workAuthorizationNumber)));
    }

    public void deleteAllVmSysWorkAuthChangeHistoryVistool() {
        vmSysWorkAuthChangeHistoryVistoolRepository.deleteAll();
    }

    public Optional<VmSysWorkAuthDetailChangeHistoryVistool> getVmSysWorkAuthChangeHistoryWithSpecifiedValues(
            String workAuthorizationNumber, String lineItemNumber) {
        return vmSysWorkAuthChangeHistoryVistoolRepository.findOne(
                where(VmSysWorkAuthDetailChangeHistoryVistoolRepository
                        .changeWorkAuthorizationIdEqualTo(workAuthorizationNumber))
                        .and(VmSysWorkAuthDetailChangeHistoryVistoolRepository
                                .changeLineItemNumberEqualTo(lineItemNumber)));
    }

    public List<VmSysWorkAuthDetailChangeHistoryVistool> getAllVmSysWorkAuthChangeHistoryWithSpecifiedValues(
            String workAuthorizationNumber, String lineItemNumber) {
        return vmSysWorkAuthChangeHistoryVistoolRepository.findAll(
                where(VmSysWorkAuthDetailChangeHistoryVistoolRepository
                        .changeWorkAuthorizationIdEqualTo(workAuthorizationNumber))
                        .and(VmSysWorkAuthDetailChangeHistoryVistoolRepository
                                .changeLineItemNumberEqualTo(lineItemNumber))
        );
    }

    public List<VmSysWorkAuthDetailChangeHistoryVistool> getAllVmSysWorkAuthChangeHistoryWhereSubmitDateOnOrAfter(
            Date date) {
        return vmSysWorkAuthChangeHistoryVistoolRepository.findAll(
                Specification.where(VmSysWorkAuthDetailChangeHistoryVistoolRepository.changeSubmitDateOnOrAfter(date))
        );
    }

    public List<VmSysWorkAuthDetailChangeHistoryVistool> addVmSysWorkAuthChangeHistoryVistool(
            List<VmSysWorkAuthDetailChangeHistoryVistool> vmSysWorkAuthChangeHistoryVistoolList) {
        List<VmSysWorkAuthDetailChangeHistoryVistool> vmSysWorkAuthChangeHistoryAdded = new ArrayList<VmSysWorkAuthDetailChangeHistoryVistool>();
        if (vmSysWorkAuthChangeHistoryVistoolList != null && !vmSysWorkAuthChangeHistoryVistoolList.isEmpty()) {
            vmSysWorkAuthChangeHistoryAdded = vmSysWorkAuthChangeHistoryVistoolRepository
                    .saveAll(vmSysWorkAuthChangeHistoryVistoolList);
        }
        return vmSysWorkAuthChangeHistoryAdded;
    }

    public List<VmSysWorkAuthDetailChangeHistoryVistool> getAllVmSysWorkAuthDetailForProvidedVmSysWorkAuths(
            List<VmSysWorkAuthDetailChangeHistoryVistool> vmSysWorkAuths) {
        List<VmSysWorkAuthDetailChangeHistoryVistool> vmSysWorkAuthDetails = new ArrayList<>();
        for (VmSysWorkAuthDetailChangeHistoryVistool vmSysWorkAuth : vmSysWorkAuths) {
            vmSysWorkAuthDetails.addAll(
                    vmSysWorkAuthChangeHistoryVistoolRepository.findAll(
                            where(VmSysWorkAuthDetailChangeHistoryVistoolRepository
                                    .workAuthorizationIdEqualTo(vmSysWorkAuth.getHeaderId()))
                    )
            );
        }
        return vmSysWorkAuthDetails;
    }

    public List<VmSysWorkAuthDetailChangeHistoryVistool> getAllVmSysWorkAuthDetailForProvidedVmSysWorkAuthIds(
            Set<String> vmSysWorkAuthIds) {
        List<VmSysWorkAuthDetailChangeHistoryVistool> vmSysWorkAuthDetails = new ArrayList<>();
        vmSysWorkAuthDetails.addAll(
                vmSysWorkAuthChangeHistoryVistoolRepository.findAll(
                        where(VmSysWorkAuthDetailChangeHistoryVistoolRepository
                                .workAuthorizationIdInSet(vmSysWorkAuthIds))
                )
        );
        return vmSysWorkAuthDetails;
    }

    public List<VmSysWorkAuthDetailChangeHistoryVistool> getVmSysWorkAuthDetailWhereCreateDateAfterOrOn(Date date) {
        return vmSysWorkAuthChangeHistoryVistoolRepository.findAll(
                Specification.where(
                        VmSysWorkAuthDetailChangeHistoryVistoolRepository.detailCreateDateAfterOrOn(date)
                )
        );
    }

    public Optional<VmSysWorkAuthDetailChangeHistoryVistool> getVmSysWorkAuthDetailWithSpecifiedValues(
            String workAuthorizationNumber, String lineItemNumber) {
        return vmSysWorkAuthChangeHistoryVistoolRepository.findOne(
                Specification
                        .where(VmSysWorkAuthDetailChangeHistoryVistoolRepository
                                .workAuthorizationIdEqualTo(workAuthorizationNumber))
                        .and(VmSysWorkAuthDetailChangeHistoryVistoolRepository.lineItemEqualTo(lineItemNumber))
        );
    }

    public List<VmSysWorkAuthDoc> getAllVmSysWorkAuthDoc() {
        return vmSysWorkAuthDocRepository.findAll();
    }

    public List<VmSysWorkAuthDoc> addVmSysWorkAuthDoc(List<VmSysWorkAuthDoc> vmSysWorkAuthDocList) {
        List<VmSysWorkAuthDoc> vmSysWorkAuthDocAdded = new ArrayList<VmSysWorkAuthDoc>();
        if (vmSysWorkAuthDocList != null && !vmSysWorkAuthDocList.isEmpty()) {
            vmSysWorkAuthDocAdded = vmSysWorkAuthDocRepository.saveAll(vmSysWorkAuthDocList);
        }
        return vmSysWorkAuthDocAdded;
    }

    public void deleteAllVmSysWorkAuthDoc() {
        vmSysWorkAuthDocRepository.deleteAll();
    }
}
