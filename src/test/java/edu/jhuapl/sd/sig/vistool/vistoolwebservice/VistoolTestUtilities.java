package edu.jhuapl.sd.sig.vistool.vistoolwebservice;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.VmSysWorkAuthDetailChangeHistoryVistool;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.*;
import lombok.SneakyThrows;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.VistoolUtilities.MONTH_DAY_YEAR_FORMAT;
import static org.junit.jupiter.api.Assertions.fail;

public class VistoolTestUtilities {
    public final static Gson LINE_ITEM_SERIALIZER = new GsonBuilder().create();
    public final static Gson WORK_ITEM_SERIALIZER = new GsonBuilder().setDateFormat(MONTH_DAY_YEAR_FORMAT).create();

    public static LineItem clone(LineItem lineItem) {
        return LINE_ITEM_SERIALIZER.fromJson(LINE_ITEM_SERIALIZER.toJson(lineItem), LineItem.class);
    }

    public static WorkItem clone(WorkItem workItem) {
        return WORK_ITEM_SERIALIZER.fromJson(WORK_ITEM_SERIALIZER.toJson(workItem), WorkItem.class);
    }

    public static LineItem createLineItem() {
        String json = loadJsonFromFile("src/test/resources/LineItem.json");
        return LINE_ITEM_SERIALIZER.fromJson(json, LineItem.class);
    }

    public static List<LineItem> createIncompleteLineItems() {
        return Arrays.asList(
                new LineItem(null, 0L, "", "", -1, null, null, null),
                new LineItem(null, 0L, "", "", -1, null, null, null)
        );
    }

    public static List<LineItem> createCompleteLineItems() {
        return Arrays.asList(
                new LineItem(1L, 0L, "WA-1", "LI-1", 100, null, null, null),
                new LineItem(2L, 0L, "WA-2", "LI-1", 200, null, null, null),
                new LineItem(3L, 1L, "WA-2", "LI-2", 201, null, null, null),
                new LineItem(4L, 0L, "WA-3", "LI-1", 300, null, null, null),
                new LineItem(5L, 1L, "WA-3", "LI-2", 301, null, null, null),
                new LineItem(6L, 2L, "WA-3", "LI-3", 302, null, null, null)
        );
    }

    public static List<WorkItem> createIncompleteWorkItems() {
        List<LineItem> lineItems = createIncompleteLineItems();
        lineItems.get(0).setId(1L);
        lineItems.get(0).setVersion(lineItems.get(0).getVersion() + 1);
        lineItems.get(1).setId(2L);
        lineItems.get(1).setVersion(lineItems.get(1).getVersion() + 1);

        return Arrays.asList(
                new WorkItem(null, 1L, null, new Date(), lineItems.get(0), null, null, -1,
                        null, null, null, null, createPickAndPlace(),
                        createProductionPlanning(), null, null, null,
                        null, null, null, null,
                        null, null, null, null,
                        null, null, null, null, null, null),
                new WorkItem(null, 1L, null, new Date(), lineItems.get(1), null, null, -1,
                        null, null, null, null, createPickAndPlace(),
                        createProductionPlanning(), null, null, null,
                        null, null, null, null,
                        null, null, null, null,
                        null, null, null, null, null, null)
        );
    }

    public static List<WorkItem> createCompleteWorkItems() {
        try {
            List<LineItem> lineItems = createCompleteLineItems();
            for(LineItem lineItem : lineItems) {
                lineItem.setVersion(lineItem.getVersion() + 1);
            }
            return Arrays.asList(
                new WorkItem(1L, 1L, null, new Date(), lineItems.get(0), "WO-1", "SN-1", 100,
                        100, 100, true, "subsystem",
                        createPickAndPlace(), createProductionPlanning(), Status.INPROCESS, "statusComments",
                        "manufacturingEngineer", "currentTechnician", 100,
                        100, 100, 100, null, null,
                        null, null, null, Kit.YES, Kit.NO,
                        "comments", WorkOrderExists.CREATED_AND_APPROVED),
                new WorkItem(2L, 1L, null, new Date(), lineItems.get(1), "WO-2", "SN-2", 200,
                        200, 200, true, "subsystem",
                        createPickAndPlace(), createProductionPlanning(), Status.INPROCESS, "statusComments",
                        "manufacturingEngineer", "currentTechnician", 200,
                        200, 200, 200, null, null,
                        null, null, null, Kit.YES, Kit.NO,
                        "comments", WorkOrderExists.CREATED_AND_APPROVED),
                new WorkItem(3L, 2L, null, new Date(), lineItems.get(2), "WO-2", "SN-2", 201,
                        201, 201, true, "subsystem",
                        createPickAndPlace(), createProductionPlanning(), Status.INPROCESS, "statusComments",
                        "manufacturingEngineer", "currentTechnician", 201,
                        201, 201, 201, null, null,
                        null, null, null, Kit.YES, Kit.NO,
                        "comments", WorkOrderExists.CREATED_AND_APPROVED),
                new WorkItem(4L, 1L, null, new Date(), lineItems.get(3), "WO-3", "SN-3", 300,
                        300, 300, true, "subsystem",
                        createPickAndPlace(), createProductionPlanning(), Status.INPROCESS, "statusComments",
                        "manufacturingEngineer", "currentTechnician", 300,
                        300, 300, 300, null, null,
                        null, null, null, Kit.YES, Kit.NO,
                        "comments", WorkOrderExists.CREATED_AND_APPROVED),
                new WorkItem(5L, 2L, null, new Date(), lineItems.get(4), "WO-3", "SN-3", 301,
                        301, 301, true, "subsystem",
                        createPickAndPlace(), createProductionPlanning(), Status.INPROCESS, "statusComments",
                        "manufacturingEngineer", "currentTechnician", 301,
                        301, 301, 301, null, null,
                        null, null, null, Kit.YES, Kit.NO,
                        "comments", WorkOrderExists.CREATED_AND_APPROVED),
                new WorkItem(6L, 3L, null, new Date(), lineItems.get(5), "WO-3", "SN-3", 302,
                        302, 302, true, "subsystem",
                        createPickAndPlace(), createProductionPlanning(), Status.INPROCESS, "statusComments",
                        "manufacturingEngineer", "currentTechnician", 302,
                        302, 302, 302, null, null,
                        null, null, null, Kit.YES, Kit.NO,
                        "comments", WorkOrderExists.CREATED_AND_APPROVED)
            );
        } catch(Exception e) {
            e.printStackTrace();
            return fail();
        }
        
    }

    public static WorkItem createWorkItem() {
        String json = loadJsonFromFile("src/test/resources/WorkItem.json");
        return WORK_ITEM_SERIALIZER.fromJson(json, WorkItem.class);
    }

    public static VmSysWorkAuthDetailChangeHistoryVistool createVmSysWorkAuth(String workAuthorizationID, String lineItem,
    String splitID, Integer quantity) {
        VmSysWorkAuthDetailChangeHistoryVistool vmSysWorkAuth = new VmSysWorkAuthDetailChangeHistoryVistool();
        vmSysWorkAuth.setPartId(lineItem);
        vmSysWorkAuth.setHeaderId(workAuthorizationID);
        vmSysWorkAuth.setHeaderCreateDate(new Date());
        vmSysWorkAuth.setSubmitDate(new Date());
        vmSysWorkAuth.setWorkAuthorizationId(workAuthorizationID);
        vmSysWorkAuth.setLineItem(lineItem);
        vmSysWorkAuth.setSplitId(splitID);
        vmSysWorkAuth.setQuantity(quantity);
        vmSysWorkAuth.setDetailCreateDate(new Date());
        return vmSysWorkAuth;
    }


    public static VmSysWorkAuthDetailChangeHistoryVistool addChangeHistoryToVmSysWorkAuth(
            VmSysWorkAuthDetailChangeHistoryVistool vmSysWorkAuth, 
            Integer changeHeaderId,
            Integer changeLineId,
            Integer changeLineQuantity, Date changeSubmitDate,
            String changeLineItemNumber) {
            vmSysWorkAuth.setChangeHeaderId(changeHeaderId);
            vmSysWorkAuth.setChangeLineId(changeLineId);
            vmSysWorkAuth.setChangeLineQuantity(changeLineQuantity);
            vmSysWorkAuth.setChangeSubmitDate(changeSubmitDate);
            vmSysWorkAuth.setChangeWorkAuthorizationId(vmSysWorkAuth.getWorkAuthorizationId());
            vmSysWorkAuth.setChangeLineItemNumber(changeLineItemNumber);
        return vmSysWorkAuth;
    }

    @SneakyThrows
    public static String loadJsonFromFile(String filePath) {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

        String line, json = "";
        while ((line = bufferedReader.readLine()) != null) {
            json += line;
        }
        bufferedReader.close();
        return json;
    }

    public static PickAndPlace createPickAndPlace() {
        return new PickAndPlace(false, LoadingPriorities.LOADED, "sizeAndMagazines", "pickAndPlaceNotes", null);
    }

    public static ProductionPlanning createProductionPlanning() {
        return new ProductionPlanning(true, "productionPlanningNotes", "actionItems");
    }

    public static VistoolUserDTO setCurrentUserContextTo(String username, VistoolUserRole vistoolUserRole) {
        VistoolUser vistoolUser = new VistoolUser(username, "", List.of(new SimpleGrantedAuthority(vistoolUserRole.toString())), vistoolUserRole);
        vistoolUser.setEmployeeId(username);
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                vistoolUser,
                SecurityContextHolder.getContext().getAuthentication().getCredentials(),
                List.of(new SimpleGrantedAuthority(vistoolUserRole.toString())));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new VistoolUserDTO(vistoolUser);
    }

    public static ColumnLayout createDemoColumnLayout(String employeeID, boolean visibility) {
        //TODO: fill with json data
        return new ColumnLayout(employeeID, "demo column layout", "TODO", visibility);
    }
}
