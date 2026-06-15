package edu.jhuapl.sd.sig.vistool.vistoolwebservice.util;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.constants.denodo.*;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.logic.LineItemLogic;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.*;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.service.DenodoService;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.*;

import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.constants.denodo.DenodoServiceConstants.R1J_WORK_AREA_ID_NEW1;
import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.constants.denodo.DenodoServiceConstants.R1J_WORK_AREA_ID_NEW2;
import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.constants.denodo.DenodoServiceConstants.R1J_WORK_AREA_NAME;
import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.DenodoFilter.Constraints.EQUALS;

@Log4j2
@Component
public class ScheduledTasks {
    @Autowired
    private DenodoUtilities denodoUtilities;
    @Autowired
    private DenodoService denodoService;
    @Autowired
    private LineItemLogic lineItemLogic;

    private Date lastScheduledTaskRun;
    private final Date R1J_DATA_RETRIEVAL_START_DATE_STRING;

    {
        Date date;
        try {
            // date is set to March 30th 4:00 PM since that is the agreed upon time with R1J
            // for transitioning to
            // VisTool
            date = VistoolUtilities.YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_DATE_FORMAT.parse("2022-03-30T16:00:00");
        } catch (ParseException parseException) {
            log.error(parseException);
            date = new Date();
        }
        R1J_DATA_RETRIEVAL_START_DATE_STRING = date;
    }

    /**
     * Refresh WoOpsData at midnight and noon
     */
    @Scheduled(cron = "${denodo.scheduled.task.wo-ops-data-refresh.fixed.rate}")
    public void refreshWoOpsData() {
        try {
            log.info("Starting scheduled VE WO Ops Data refresh.");
            getVeWoOpsData(null);
            log.info("Completed scheduled VE WO Ops Data refresh.");
        } catch (Exception e) {
            log.error("CFailed scheduled VE WO Ops Data refresh.", e);
        }
    }

    @Scheduled(fixedRateString = "${denodo.scheduled.task.fixed.rate}")
    public void cacheDenodoDataAndCreateNewLineItems() {
        boolean dataCacheAndLineItemCreationSuccessful = false;

        while (!dataCacheAndLineItemCreationSuccessful) {
            try {
                log.info("Starting scheduled task: cacheDenodoDataAndCreateNewLineItems.");
                dataCacheAndLineItemCreationSuccessful = performTasksAndCreateLineItems();
            } catch (Exception exception) {
                log.error(
                        "Failed to complete scheduled task: cacheDenodoDataAndCreateNewLineItems. Will reattempt in 60 seconds.");
                log.error(ExceptionUtils.getStackTrace(exception));
                try {
                    Thread.sleep(60000);
                } catch (Exception e) {
                    log.error("Failed to sleep for 60 seconds before reattempting Denodo pull");
                    log.error(ExceptionUtils.getStackTrace(e));
                }
                log.info("Retrying scheduled task: cacheDenodoDataAndCreateNewLineItems");
            }
        }
        log.info("Completed scheduled task: cacheDenodoDataAndCreateNewLineItems");
    }

    private boolean performTasksAndCreateLineItems() throws Exception {
        boolean successfulCompletion = false;

        // Pull initial data from denodo into the repositories
        getDimHRPersonData();
        getVeWoData();
        getVeWoOpsData(lastScheduledTaskRun);
        getVmSysWorkAuthDetailChangeHistoryVistoolData();
        try {
            // if lastScheduledTaskRun is null, this is the first execution
            if (lastScheduledTaskRun == null) {
                // Create Line Items from WAs listed in the open and completed JSON
                // configuration files
                lineItemLogic.createNewLineItems(Optional.empty());
                // Set last Scheduled Task date to the VisTool transition date
                lastScheduledTaskRun = R1J_DATA_RETRIEVAL_START_DATE_STRING;
                // Update/Create Line Items from denodo data after the VisTool transition date
                lineItemLogic.createNewLineItems(Optional.of(lastScheduledTaskRun));
                // Set lastScheduledTaskRun to the current date/time - 1 hour, so that on the
                // next pull from Denodo all new WAs
                // start being pulled in. The -1 hour is to catch any WAs created during the
                // Denodo pull
                lastScheduledTaskRun = new Date(System.currentTimeMillis() - 3600000);
            } else {
                // Update/Create Line Items from denodo after the time of the last denodo pull
                lineItemLogic.createNewLineItems(Optional.of(lastScheduledTaskRun));
                // Set lastScheduledTaskRun to the current date/time - 1 hour, so that on the
                // next pull from Denodo all new WAs
                // start being pulled in. The -1 hour is to catch any WAs created during the
                // Denodo pull
                lastScheduledTaskRun = new Date(System.currentTimeMillis() - 3600000);
            }

            successfulCompletion = true;

        } catch (Exception exception) {
            log.error("Failed to create new line items: performTasksAndCreateLineItems");
            log.error(ExceptionUtils.getStackTrace(exception));
        }

        return successfulCompletion;
    }

    private void getDimHRPersonData() throws Exception {
        List<DimHRPerson> dimHrPersonData = Collections.emptyList();
        if (lastScheduledTaskRun == null) {
            dimHrPersonData = denodoUtilities.getDimHRPersonList(Optional.empty(), Optional.empty());
        } else {
            String filter = DenodoFilter.builder().addConstraint(
                    DimHRPersonConstants.UPDATE_DATETIME,
                    DenodoFilter.Constraints.GREATER_THAN_OR_EQUAL_TO,
                    VistoolUtilities.YEAR_MONTH_DAY_DATE_FORMAT.format(lastScheduledTaskRun)).create();
            dimHrPersonData = denodoUtilities.getDimHRPersonList(Optional.of(filter), Optional.empty());
        }
        denodoService.addDimHRPerson(dimHrPersonData);
    }

    private void getVeMasterWoData() throws Exception {
        List<VeMasterWo> veMasterWoData = Collections.emptyList();
        if (lastScheduledTaskRun == null) {
            veMasterWoData = denodoUtilities.getVeMasterWoList(Optional.empty(), Optional.empty());
        } else {
            String filter = DenodoFilter.builder().addConstraint(
                    VeMasterWoConstants.CREATE_DATE,
                    DenodoFilter.Constraints.GREATER_THAN_OR_EQUAL_TO,
                    VistoolUtilities.YEAR_MONTH_DAY_DATE_FORMAT.format(lastScheduledTaskRun)).create();
            veMasterWoData = denodoUtilities.getVeMasterWoList(Optional.of(filter), Optional.empty());
        }
        denodoService.addVeMasterWo(veMasterWoData);
    }

    private void getVePartsData() throws Exception {
        List<VeParts> vePartsData = Collections.emptyList();
        if (lastScheduledTaskRun == null) {
            vePartsData = denodoUtilities.getVePartsList(Optional.empty(), Optional.empty());
        } else {
            String filter = DenodoFilter.builder().addConstraint(
                    VePartsConstants.CREATE_DATE,
                    DenodoFilter.Constraints.GREATER_THAN_OR_EQUAL_TO,
                    VistoolUtilities.YEAR_MONTH_DAY_DATE_FORMAT.format(lastScheduledTaskRun)).create();
            vePartsData = denodoUtilities.getVePartsList(Optional.of(filter), Optional.empty());
        }
        denodoService.addVeParts(vePartsData);
    }

    private void getVeShopResourceData() throws Exception {
        List<VeShopResource> veShopResourceData = denodoUtilities.getVeShopResourceList(Optional.empty(),
                Optional.empty());
        denodoService.addVeShopResource(veShopResourceData);
    }

    private void getVeSpecialPartsData() throws Exception {
        List<VeSpecialParts> veSpecialPartsData = Collections.emptyList();
        if (lastScheduledTaskRun == null) {
            veSpecialPartsData = denodoUtilities.getVeSpecialPartsList(Optional.empty(), Optional.empty());
        } else {
            String filter = DenodoFilter.builder().addConstraint(
                    VeSpecialPartsConstants.CREATE_DATE,
                    DenodoFilter.Constraints.GREATER_THAN_OR_EQUAL_TO,
                    VistoolUtilities.YEAR_MONTH_DAY_DATE_FORMAT.format(lastScheduledTaskRun)).create();
            veSpecialPartsData = denodoUtilities.getVeSpecialPartsList(Optional.of(filter), Optional.empty());
        }
        denodoService.addVeSpecialParts(veSpecialPartsData);
    }

    private void getVeUsersData() throws Exception {
        List<VeUsers> veUsersData = Collections.emptyList();
        if (lastScheduledTaskRun == null) {
            veUsersData = denodoUtilities.getVeUsersList(Optional.empty(), Optional.empty());
        } else {
            String filter = DenodoFilter.builder().addConstraint(
                    VeUsersConstants.LAST_UPDATE_DATE,
                    DenodoFilter.Constraints.GREATER_THAN_OR_EQUAL_TO,
                    VistoolUtilities.YEAR_MONTH_DAY_DATE_FORMAT.format(lastScheduledTaskRun)).create();
            veUsersData = denodoUtilities.getVeUsersList(Optional.of(filter), Optional.empty());
        }
        denodoService.addVeUsers(veUsersData);
    }

    private void getVeWoData() throws Exception {
        List<VeWo> veWoData = Collections.emptyList();
        veWoData = denodoUtilities.getVeWoList(Optional.empty(), Optional.empty());
        denodoService.deleteAllVeWo();
        denodoService.addVeWo(veWoData);
    }

    private void getVeWoLaborTotalsData() throws Exception {
        List<VeWoLaborTotals> veWoLaborTotals = denodoUtilities.getVeWoLaborTotalsList(Optional.empty(),
                Optional.empty());
        denodoService.addVeWoLaborTotals(veWoLaborTotals);
    }

    private void getVeWoOpsData(Date lastScheduledTaskRun) throws Exception {
        if (lastScheduledTaskRun == null) {
            String filter = DenodoFilter.builder().addConstraint(
                    VeWoOpsConstants.SEQUENCE_NO,
                    DenodoFilter.Constraints.GREATER_THAN,
                    Double.toString(DenodoServiceConstants.R1J_MINIMUM_SEQUENCE_NUMBER)).create();
            List<VeWoOps> veWoOpsData = denodoUtilities.getVeWoOpsList(Optional.of(filter), Optional.empty());
            denodoService.deleteAllVeWoOps();
            denodoService.addVeWoOps(veWoOpsData);
        } else {
            String filter = DenodoFilter.builder()
                    .addConstraint(
                            VeWoOpsConstants.SEQUENCE_NO,
                            DenodoFilter.Constraints.GREATER_THAN,
                            Double.toString(DenodoServiceConstants.R1J_MINIMUM_SEQUENCE_NUMBER))
                    .addConstraint(
                            VeWoOpsConstants.MODIFIED_DATE,
                            DenodoFilter.Constraints.GREATER_THAN,
                            VistoolUtilities.YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_DATE_FORMAT.format(lastScheduledTaskRun))
                    .create();
            List<VeWoOps> veWoOpsData = denodoUtilities.getVeWoOpsList(Optional.of(filter), Optional.empty());

            // for every updated veWoOpsData get all steps to refresh VT db
            if (!veWoOpsData.isEmpty()) {
                log.info("Starting vistool WO refresh with new updates");
                Set<VeWoOps> allVeWopsData = new HashSet<>(veWoOpsData); // add veWoOpsData in case there is something that does not exist in VT repo
                veWoOpsData.forEach((veWoOps -> {
                    try {
                        String tempFilter = DenodoFilter.builder().addConstraint(
                                VeWoOpsConstants.WORK_ORDER_BASE_ID,
                                DenodoFilter.Constraints.EQUALS,
                                veWoOps.getWorkOrderBaseID())
                                .addConstraint(
                                        VeWoOpsConstants.SEQUENCE_NO,
                                        DenodoFilter.Constraints.GREATER_THAN,
                                        Double.toString(DenodoServiceConstants.R1J_MINIMUM_SEQUENCE_NUMBER))
                                .create();
                        allVeWopsData.addAll(denodoUtilities.getVeWoOpsList(Optional.of(tempFilter), Optional.empty()));
                    } catch (Exception e) {
                        log.error("Failed to get VE work order ops list for work order base id {}. " +
                                "VE work order ops data for this work order will not be refreshed in VisTool database.",
                                veWoOps.getWorkOrderBaseID(), e);
                    }
                }));

                denodoService.refreshVeWoOpsRepo(new ArrayList<>(allVeWopsData));
                log.info("Completed vistool vistool WO refresh with new updates");
            }
        }
    }

    private void getVeWoOpsEquipmentData() throws Exception {
        List<VeWoOpsEquipment> veWoOpsEquipmentData = denodoUtilities.getVeWoOpsEquipmentList(Optional.empty(),
                Optional.empty());
        denodoService.addVeWoOpsEquipment(veWoOpsEquipmentData);
    }

    private void getVeWoOpsLaborData() throws Exception {
        List<VeWoOpsLabor> veWoOpsLaborData = denodoUtilities.getVeWoOpsLaborList(Optional.empty(), Optional.empty());
        denodoService.addVeWoOpsLabor(veWoOpsLaborData);
    }

    private void getVeWoOpsMaterialData() throws Exception {
        List<VeWoOpsMaterial> veWoOpsMaterialData = denodoUtilities.getVeWoOpsMaterialList(Optional.empty(),
                Optional.empty());
        denodoService.addVeWoOpsMaterial(veWoOpsMaterialData);
    }

    private void getVmSysDataDictionaryData() throws Exception {
        List<VmSysDataDictionary> vmSysDataDictionaryData = denodoUtilities.getVmSysDataDictionaryList(Optional.empty(),
                Optional.empty());
        denodoService.addVmSysDataDictionary(vmSysDataDictionaryData);
    }

    private void getVmSysWorkAuthDetailChangeHistoryVistoolData() throws Exception {
        List<VmSysWorkAuthDetailChangeHistoryVistool> vmSysWorkAuthDetailChangeHistoryVistoolData = Collections
                .emptyList();
        if (lastScheduledTaskRun == null) {
            String filter = DenodoFilter.builder()
                    .addOrConstraint(VmSysWorkAuthDetailChangeHistoryVistoolConstants.WORKAUTH_HEADER_WORK_AREA_ID_NEW,
                            EQUALS, R1J_WORK_AREA_ID_NEW1)
                    .addOrConstraint(VmSysWorkAuthDetailChangeHistoryVistoolConstants.WORKAUTH_HEADER_WORK_AREA_ID_NEW,
                            EQUALS, R1J_WORK_AREA_ID_NEW2)
                    .addOrConstraint(VmSysWorkAuthDetailChangeHistoryVistoolConstants.CHANGE_LINE_WORK_AREA_NAME,
                            EQUALS, R1J_WORK_AREA_NAME)
                    .create();
            vmSysWorkAuthDetailChangeHistoryVistoolData = denodoUtilities
                    .getVmSysWorkAuthDetailChangeHistoryVistoolList(Optional.of(filter), Optional.empty());
        } else {
            String filter1 = DenodoFilter.builder()
                    .addOrConstraint(VmSysWorkAuthDetailChangeHistoryVistoolConstants.WORKAUTH_HEADER_WORK_AREA_ID_NEW,
                            EQUALS, R1J_WORK_AREA_ID_NEW1)
                    .addOrConstraint(VmSysWorkAuthDetailChangeHistoryVistoolConstants.WORKAUTH_HEADER_WORK_AREA_ID_NEW,
                            EQUALS, R1J_WORK_AREA_ID_NEW2)
                    .addOrConstraint(VmSysWorkAuthDetailChangeHistoryVistoolConstants.CHANGE_LINE_WORK_AREA_NAME,
                            EQUALS, R1J_WORK_AREA_NAME)
                    .create();
            String filter2 = DenodoFilter.builder()
                    .addOrConstraint(
                            VmSysWorkAuthDetailChangeHistoryVistoolConstants.WORKAUTH_HEADER_SUBMIT_DATE,
                            DenodoFilter.Constraints.GREATER_THAN_OR_EQUAL_TO,
                            VistoolUtilities.YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_DATE_FORMAT
                                    .format(lastScheduledTaskRun))
                    .addOrConstraint(
                            VmSysWorkAuthDetailChangeHistoryVistoolConstants.CHANGE_SUBMIT_DATE,
                            DenodoFilter.Constraints.GREATER_THAN_OR_EQUAL_TO,
                            VistoolUtilities.YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_DATE_FORMAT
                                    .format(lastScheduledTaskRun))
                    .create();
            String finalFilter = DenodoFilter.builder()
                    .addAndFilter(filter1, filter2)
                    .create();
            vmSysWorkAuthDetailChangeHistoryVistoolData = denodoUtilities
                    .getVmSysWorkAuthDetailChangeHistoryVistoolList(Optional.of(finalFilter), Optional.empty());
        }
        denodoService.addVmSysWorkAuthChangeHistoryVistool(vmSysWorkAuthDetailChangeHistoryVistoolData);
    }

    private void getVmSysWorkAuthDoc() throws Exception {
        List<VmSysWorkAuthDoc> vmSysWorkAuthDocData = denodoUtilities.getVmSysWorkAuthDocList(Optional.empty(),
                Optional.empty());
        denodoService.addVmSysWorkAuthDoc(vmSysWorkAuthDocData);
    }
}
