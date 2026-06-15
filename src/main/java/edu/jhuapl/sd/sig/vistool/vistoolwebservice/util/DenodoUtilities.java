package edu.jhuapl.sd.sig.vistool.vistoolwebservice.util;

import com.google.gson.reflect.TypeToken;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.*;
import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Component
@Log4j2
public class DenodoUtilities {

    @Value("${denodo.username}")
    private String denodoUsername;

    @Value("${denodo.password}")
    private String denodoPassword;

    @Value("${denodo.url}")
    private String denodoUrl;

    @Value("${denodo.request.timeout}")
    private int denodoRequestTimeout;

    private final String DENODO_API_RETURN_JSON = "?$format=JSON";
    private final String DENODO_API_LIMIT_COUNT = "&$count=";

    private final String DENODO_API_APL_ENGINEERING = "/APL_Engineering";
    private final String DENODO_API_MFG_ERP = "/MfgERP/views";
    private final String DENODO_API_VE_MASTER_WO = DENODO_API_APL_ENGINEERING + DENODO_API_MFG_ERP + "/ve_master_wo";
    private final String DENODO_API_VE_MASTER_WO_OPS = DENODO_API_APL_ENGINEERING + DENODO_API_MFG_ERP + "/ve_master_wo_ops";
    private final String DENODO_API_VE_PARTS = DENODO_API_APL_ENGINEERING + DENODO_API_MFG_ERP + "/ve_parts";
    private final String DENODO_API_VE_SHOP_RESOURCE = DENODO_API_APL_ENGINEERING + DENODO_API_MFG_ERP + "/ve_shop_resource";
    private final String DENODO_API_VE_SPECIAL_PARTS = DENODO_API_APL_ENGINEERING + DENODO_API_MFG_ERP + "/ve_special_parts";
    private final String DENODO_API_VE_USERS = DENODO_API_APL_ENGINEERING + DENODO_API_MFG_ERP + "/ve_users";
    private final String DENODO_API_VE_WO = DENODO_API_APL_ENGINEERING + DENODO_API_MFG_ERP + "/ve_wo";
    private final String DENODO_API_VE_WO_LABOR_TOTALS = DENODO_API_APL_ENGINEERING + DENODO_API_MFG_ERP + "/ve_wo_labor_totals";
    private final String DENODO_API_VE_WO_OPS_MODIFIED_DATE = DENODO_API_APL_ENGINEERING + DENODO_API_MFG_ERP + "/ve_wo_ops_modified_date";
    private final String DENODO_API_VE_WO_OPS_EQUIPMENT = DENODO_API_APL_ENGINEERING + DENODO_API_MFG_ERP + "/ve_wo_ops_equipment";
    private final String DENODO_API_VE_WO_OPS_LABOR = DENODO_API_APL_ENGINEERING + DENODO_API_MFG_ERP + "/ve_wo_ops_labor";
    private final String DENODO_API_VE_WO_OPS_MATERIAL = DENODO_API_APL_ENGINEERING + DENODO_API_MFG_ERP + "/ve_wo_ops_material";
    private final String DENODO_API_VMSYS_DATA_DICTIONARY = DENODO_API_APL_ENGINEERING + DENODO_API_MFG_ERP + "/vmsys_data_dictionary";
    private final String DENODO_API_VMSYS_WORKAUTH_DETAIL_CHANGE_HISTORY_VISTOOL = DENODO_API_APL_ENGINEERING
            + DENODO_API_MFG_ERP + "/vmsys_workauth_detail_change_history_vistool";
    private final String DENODO_API_VMSYS_WORKAUTH_DOC = DENODO_API_APL_ENGINEERING + DENODO_API_MFG_ERP + "/vmsys_workauth_doc";

    private final String DENODO_API_ADDIT = "/addit";
    private final String DENODO_API_ADDIT_DIMENSIONS = "/dimensions/views";
    private final String DENODO_API_DIM_HR_PERSON = DENODO_API_ADDIT + DENODO_API_ADDIT_DIMENSIONS + "/dim_hr_person";

    protected Response makeRequest(String endpoint, Optional<String> filter, Optional<Integer> limit) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS))
                .connectTimeout(denodoRequestTimeout, TimeUnit.SECONDS)
                .readTimeout(denodoRequestTimeout, TimeUnit.SECONDS)
                .writeTimeout(denodoRequestTimeout, TimeUnit.SECONDS)
                .build();

        String credentials = Credentials.basic(denodoUsername, denodoPassword);
        String url = denodoUrl + endpoint + DENODO_API_RETURN_JSON;
        if(limit.isPresent()) {
            url += DENODO_API_LIMIT_COUNT + limit.get();
        }
        if(filter.isPresent() && !VistoolUtilities.isStringNullOrEmpty(filter.get())) {
            url += filter.get();
        }

        log.info("Start request: {}", url);
        Request request = new Request.Builder().url(url).header("Authorization", credentials).build();
        Response response = okHttpClient.newCall(request).execute();
        log.info("End request: {}", url);

        return response;
    }
    
    public List<VeMasterWo> getVeMasterWoList(Optional<String> filter, Optional<Integer> limit) throws Exception {
        @Cleanup Response response = makeRequest(DENODO_API_VE_MASTER_WO, filter, limit);
        if(response.isSuccessful()) {
            String responseJSON = response.body().string();
            Type rootVeMasterWoType = new TypeToken<Root<VeMasterWo>>(){}.getType();
            Root<VeMasterWo> rootVeMasterWo = VeMasterWo.SERIALIZER.fromJson(responseJSON, rootVeMasterWoType);
            return List.of(rootVeMasterWo.getElements());
        }
    	return Collections.emptyList();
    }

    public List<VeMasterWoOps> getVeMasterWoOpsList(Optional<String> filter, Optional<Integer> limit) throws Exception {
        @Cleanup Response response = makeRequest(DENODO_API_VE_MASTER_WO_OPS, filter, limit);
        if(response.isSuccessful()) {
            String responseJSON = response.body().string();
            Type rootVeMasterWoOpsType = new TypeToken<Root<VeMasterWoOps>>(){}.getType();
            Root<VeMasterWoOps> rootVeMasterWoOps = VeMasterWoOps.SERIALIZER.fromJson(responseJSON, rootVeMasterWoOpsType);
            return List.of(rootVeMasterWoOps.getElements());
        }
        return Collections.emptyList();
    }
    
    public List<VeParts> getVePartsList(Optional<String> filter, Optional<Integer> limit) throws Exception {
        @Cleanup Response response = makeRequest(DENODO_API_VE_PARTS, filter, limit);
        if(response.isSuccessful()) {
            String responseJSON = response.body().string();
            Type rootVePartsType = new TypeToken<Root<VeParts>>(){}.getType();
            Root<VeParts> rootVeParts = VeParts.SERIALIZER.fromJson(responseJSON, rootVePartsType);
            return List.of(rootVeParts.getElements());
        }
        return Collections.emptyList();
    }
    
    public List<VeShopResource> getVeShopResourceList(Optional<String> filter, Optional<Integer> limit) throws Exception {
        @Cleanup Response response = makeRequest(DENODO_API_VE_SHOP_RESOURCE, filter, limit);
        if(response.isSuccessful()) {
            String responseJSON = response.body().string();
            Type rootVeShopResourceType = new TypeToken<Root<VeShopResource>>(){}.getType();
            Root<VeShopResource> rootVeShopResource = VeShopResource.SERIALIZER.fromJson(responseJSON, rootVeShopResourceType);
            return List.of(rootVeShopResource.getElements());
        }
        return Collections.emptyList();
    }
    
    public List<VeSpecialParts> getVeSpecialPartsList(Optional<String> filter, Optional<Integer> limit) throws Exception {
        @Cleanup Response response = makeRequest(DENODO_API_VE_SPECIAL_PARTS, filter, limit);
        if(response.isSuccessful()) {
            String responseJSON = response.body().string();
            Type rootVeSpecialPartsType = new TypeToken<Root<VeSpecialParts>>(){}.getType();
            Root<VeSpecialParts> rootVeSpecialParts = VeSpecialParts.SERIALIZER.fromJson(responseJSON, rootVeSpecialPartsType);
            return List.of(rootVeSpecialParts.getElements());
        }
        return Collections.emptyList();
    }
    
    public List<VeUsers> getVeUsersList(Optional<String> filter, Optional<Integer> limit) throws Exception {
        @Cleanup Response response = makeRequest(DENODO_API_VE_USERS, filter, limit);
        if(response.isSuccessful()) {
            String responseJSON = response.body().string();
            Type rootVeUsersType = new TypeToken<Root<VeUsers>>(){}.getType();
            Root<VeUsers> rootVeUsers = VeUsers.SERIALIZER.fromJson(responseJSON, rootVeUsersType);
            return List.of(rootVeUsers.getElements());
        }
        return Collections.emptyList();
    }
    
    public List<VeWo> getVeWoList(Optional<String> filter, Optional<Integer> limit) throws Exception {
        @Cleanup Response response = makeRequest(DENODO_API_VE_WO, filter, limit);
        if(response.isSuccessful()) {
            String responseJSON = response.body().string();
            Type rootVeWoType = new TypeToken<Root<VeWo>>(){}.getType();
            Root<VeWo> rootVeWo = VeWo.SERIALIZER.fromJson(responseJSON, rootVeWoType);
            return List.of(rootVeWo.getElements());
        }
        return Collections.emptyList();
    }
    
    public List<VeWoLaborTotals> getVeWoLaborTotalsList(Optional<String> filter, Optional<Integer> limit) throws Exception {
        @Cleanup Response response = makeRequest(DENODO_API_VE_WO_LABOR_TOTALS, filter, limit);
        if(response.isSuccessful()) {
            String responseJSON = response.body().string();
            Type rootVeWoLaborTotalsType = new TypeToken<Root<VeWoLaborTotals>>(){}.getType();
            Root<VeWoLaborTotals> rootVeWoLaborTotals = VeWoLaborTotals.SERIALIZER.fromJson(responseJSON, rootVeWoLaborTotalsType);
            return List.of(rootVeWoLaborTotals.getElements());
        }
        return Collections.emptyList();
    }
    
    public List<VeWoOps> getVeWoOpsList(Optional<String> filter, Optional<Integer> limit) throws Exception {
        @Cleanup Response response = makeRequest(DENODO_API_VE_WO_OPS_MODIFIED_DATE, filter, limit);
        if(response.isSuccessful()) {
            String responseJSON = response.body().string();
            Type rootVeWoOpsType = new TypeToken<Root<VeWoOps>>(){}.getType();
            Root<VeWoOps> rootVeWoOps = VeWoOps.SERIALIZER.fromJson(responseJSON, rootVeWoOpsType);
            return List.of(rootVeWoOps.getElements());
        }
        return Collections.emptyList();
    }
    
    public List<VeWoOpsEquipment> getVeWoOpsEquipmentList(Optional<String> filter, Optional<Integer> limit) throws Exception {
        @Cleanup Response response = makeRequest(DENODO_API_VE_WO_OPS_EQUIPMENT, filter, limit);
        if(response.isSuccessful()) {
            String responseJSON = response.body().string();
            Type rootVeWoOpsEquipmentType = new TypeToken<Root<VeWoOpsEquipment>>(){}.getType();
            Root<VeWoOpsEquipment> rootVeWoOpsEquipment = VeWoOpsEquipment.SERIALIZER.fromJson(responseJSON, rootVeWoOpsEquipmentType);
            return List.of(rootVeWoOpsEquipment.getElements());
        }
        return Collections.emptyList();
    }
    
    public List<VeWoOpsLabor> getVeWoOpsLaborList(Optional<String> filter, Optional<Integer> limit) throws Exception {
        @Cleanup Response response = makeRequest(DENODO_API_VE_WO_OPS_LABOR, filter, limit);
        if(response.isSuccessful()) {
            String responseJSON = response.body().string();
            Type rootVeWoOpsLaborType = new TypeToken<Root<VeWoOpsLabor>>(){}.getType();
            Root<VeWoOpsLabor> rootVeWoOpsLabor = VeWoOpsLabor.SERIALIZER.fromJson(responseJSON, rootVeWoOpsLaborType);
            return List.of(rootVeWoOpsLabor.getElements());
        }
        return Collections.emptyList();
    }
    
    public List<VeWoOpsMaterial> getVeWoOpsMaterialList(Optional<String> filter, Optional<Integer> limit) throws Exception {
        @Cleanup Response response = makeRequest(DENODO_API_VE_WO_OPS_MATERIAL, filter, limit);
        if(response.isSuccessful()) {
            String responseJSON = response.body().string();
            Type rootVeWoOpsMaterialType = new TypeToken<Root<VeWoOpsMaterial>>(){}.getType();
            Root<VeWoOpsMaterial> rootVeWoOpsMaterial = VeWoOpsMaterial.SERIALIZER.fromJson(responseJSON, rootVeWoOpsMaterialType);
            return List.of(rootVeWoOpsMaterial.getElements());
        }
        return Collections.emptyList();
    }
    
    public List<VmSysDataDictionary> getVmSysDataDictionaryList(Optional<String> filter, Optional<Integer> limit) throws Exception {
        @Cleanup Response response = makeRequest(DENODO_API_VMSYS_DATA_DICTIONARY, filter, limit);
        if(response.isSuccessful()) {
            String responseJSON = response.body().string();
            Type rootVmSysDataDictionaryType = new TypeToken<Root<VmSysDataDictionary>>(){}.getType();
            Root<VmSysDataDictionary> rootVmSysDataDictionary = VmSysDataDictionary.SERIALIZER.fromJson(responseJSON, rootVmSysDataDictionaryType);
            return List.of(rootVmSysDataDictionary.getElements());
        }
        return Collections.emptyList();
    }

    public List<VmSysWorkAuthDetailChangeHistoryVistool> getVmSysWorkAuthDetailChangeHistoryVistoolList(
            Optional<String> filter, Optional<Integer> limit) throws Exception {
        @Cleanup
        Response response = makeRequest(DENODO_API_VMSYS_WORKAUTH_DETAIL_CHANGE_HISTORY_VISTOOL, filter, limit);
        if(response.isSuccessful()) {
            String responseJSON = response.body().string();
            Type rootVmSysWorkAuthDetailChangeHistoryVistoolType = new TypeToken<Root<VmSysWorkAuthDetailChangeHistoryVistool>>() {
            }.getType();
            Root<VmSysWorkAuthDetailChangeHistoryVistool> rootVmSysWorkAuthDetailChangeHistoryVistool = VmSysWorkAuthDetailChangeHistoryVistool.SERIALIZER
                    .fromJson(responseJSON, rootVmSysWorkAuthDetailChangeHistoryVistoolType);
            return List.of(rootVmSysWorkAuthDetailChangeHistoryVistool.getElements());
        }
        return Collections.emptyList();
    }

    public List<VmSysWorkAuthDoc> getVmSysWorkAuthDocList(Optional<String> filter, Optional<Integer> limit) throws Exception {
        @Cleanup Response response = makeRequest(DENODO_API_VMSYS_WORKAUTH_DOC, filter, limit);
        if(response.isSuccessful()) {
            String responseJSON = response.body().string();
            Type rootVmSysWorkAuthDocType = new TypeToken<Root<VmSysWorkAuthDoc>>(){}.getType();
            Root<VmSysWorkAuthDoc> rootVmSysWorkAuthDoc = VmSysWorkAuthDoc.SERIALIZER.fromJson(responseJSON, rootVmSysWorkAuthDocType);
            return List.of(rootVmSysWorkAuthDoc.getElements());
        }
        return Collections.emptyList();
    }

    public List<DimHRPerson> getDimHRPersonList(Optional<String> filter, Optional<Integer> limit) throws Exception {
        @Cleanup Response response = makeRequest(DENODO_API_DIM_HR_PERSON, filter, limit);
        if(response.isSuccessful()) {
            String responseJSON = response.body().string();
            Type rootEmployeeType = new TypeToken<Root<DimHRPerson>>(){}.getType();
            Root<DimHRPerson> rootEmployee = DimHRPerson.SERIALIZER.fromJson(responseJSON, rootEmployeeType);
            return List.of(rootEmployee.getElements());
        }
        return Collections.emptyList();
    }
}
