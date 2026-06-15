package edu.jhuapl.sd.sig.vistool.vistoolwebservice.util;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.*;
import okhttp3.*;
import okio.BufferedSource;
import okio.Okio;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.VistoolUtilities.*;

@SpringBootTest
@MockBean(ScheduledTasks.class)
@ActiveProfiles({"local-dev-secure-h2"})
public class DenodoUtilitiesTest {
    private enum DenodoEndpoint {
        DIM_HR_PERSON,
        VE_MASTER_WO,
        VE_MASTER_WO_OPS,
        VE_PARTS,
        VE_SHOP_RESOURCE,
        VE_SPECIAL_PARTS,
        VE_USERS,
        VE_WO,
        VE_WO_LABOR_TOTALS,
        VE_WO_OPS,
        VE_WO_OPS_EQUIPMENT,
        VE_WO_OPS_LABOR,
        VE_WO_OPS_MATERIAL,
        VMSYS_DATA_DICTIONARY,
        VMSYS_WORKAUTH_CHANGE_HISTORY_VISTOOL,
        VMSYS_WORK_AUTH_DOC
    }

    private class MockDenodoUtilities extends DenodoUtilities {
        private DenodoEndpoint denodoEndpoint;

        public MockDenodoUtilities(DenodoEndpoint denodoEndpoint) {
            this.denodoEndpoint = denodoEndpoint;
        }

        @Override
        public Response makeRequest(String endpoint, Optional<String> filter, Optional<Integer> limit) throws IOException {
            Request request = new Request.Builder().url("http://localhost").build();

            MockResponseBody mockResponseBody = new MockResponseBody(denodoEndpoint);
            return new Response.Builder()
                .request(request)
                .protocol(Protocol.HTTP_1_1)
                .message("OK")
                .code(200)
                .body(mockResponseBody)
                .build();

        }
    }

    private class MockResponseBody extends ResponseBody {

        private DenodoEndpoint denodoEndpoint;

        public MockResponseBody(DenodoEndpoint denodoEndpoint) {
            this.denodoEndpoint = denodoEndpoint;
        }

        @Override
        public long contentLength() {
            return 100;
        }

        @Nullable
        @Override
        public MediaType contentType() {
            return MediaType.parse("application/text");
        }

        @NotNull
        @Override
        public BufferedSource source() {
            InputStream inputStream = null;

            try {
                switch (denodoEndpoint) {
                    case DIM_HR_PERSON:
                        inputStream = new FileInputStream(new File("src/test/resources/denodo/dim_hr_person.json"));
                        break;
                    case VE_MASTER_WO:
                        inputStream = new FileInputStream(new File("src/test/resources/denodo/ve_master_wo.json"));
                        break;
                    case VE_MASTER_WO_OPS:
                        inputStream = new FileInputStream(new File("src/test/resources/denodo/ve_master_wo_ops.json"));
                        break;
                    case VE_PARTS:
                        inputStream = new FileInputStream(new File("src/test/resources/denodo/ve_parts.json"));
                        break;
                    case VE_SHOP_RESOURCE:
                        inputStream = new FileInputStream(new File("src/test/resources/denodo/ve_shop_resource.json"));
                        break;
                    case VE_SPECIAL_PARTS:
                        inputStream = new FileInputStream(new File("src/test/resources/denodo/ve_special_parts.json"));
                        break;
                    case VE_USERS:
                        inputStream = new FileInputStream(new File("src/test/resources/denodo/ve_users.json"));
                        break;
                    case VE_WO:
                        inputStream = new FileInputStream(new File("src/test/resources/denodo/ve_wo.json"));
                        break;
                    case VE_WO_LABOR_TOTALS:
                        inputStream = new FileInputStream(new File("src/test/resources/denodo/ve_wo_labor_totals.json"));
                        break;
                    case VE_WO_OPS:
                        inputStream = new FileInputStream(new File("src/test/resources/denodo/ve_wo_ops.json"));
                        break;
                    case VE_WO_OPS_EQUIPMENT:
                        inputStream = new FileInputStream(new File("src/test/resources/denodo/ve_wo_ops_equipment.json"));
                        break;
                    case VE_WO_OPS_LABOR:
                        inputStream = new FileInputStream(new File("src/test/resources/denodo/ve_wo_ops_labor.json"));
                        break;
                    case VE_WO_OPS_MATERIAL:
                        inputStream = new FileInputStream(new File("src/test/resources/denodo/ve_wo_ops_material.json"));
                        break;
                    case VMSYS_DATA_DICTIONARY:
                        inputStream = new FileInputStream(new File("src/test/resources/denodo/vmsys_data_dictionary.json"));
                        break;
                    case VMSYS_WORKAUTH_CHANGE_HISTORY_VISTOOL:
                        inputStream = new FileInputStream(
                                new File("src/test/resources/denodo/vmsys_work_auth_change_history_vistool.json"));
                        break;
                    case VMSYS_WORK_AUTH_DOC:
                        inputStream = new FileInputStream(new File("src/test/resources/denodo/vmsys_work_auth_doc.json"));
                        break;
                }
            }
            catch(Exception exception){
            	exception.printStackTrace();
            }
            return Okio.buffer(Okio.source(inputStream));
        }

        @Override
        public String toString() {
            try {
                return source().readString(StandardCharsets.UTF_8);
            }
            catch(Exception exception) {
                exception.printStackTrace();
                return "EXCEPTION";
            }
        }
    }

    @Test
    public void getHRPersonAll() {
        try {
            MockDenodoUtilities mockDenodoUtilities = new MockDenodoUtilities(DenodoEndpoint.DIM_HR_PERSON);
            List<DimHRPerson> dimHRPersonList = mockDenodoUtilities.getDimHRPersonList(Optional.empty(), Optional.empty());
            Assertions.assertFalse(dimHRPersonList.isEmpty());

            DimHRPerson dimHRPerson = dimHRPersonList.get(0);
            Assertions.assertEquals("person_num", dimHRPerson.getPersonNumber());
            Assertions.assertEquals("person_status_code", dimHRPerson.getPersonStatusCode());
            Assertions.assertEquals("person_substatus_code", dimHRPerson.getPersonSubStatusCode());
            Assertions.assertEquals("user_id", dimHRPerson.getUserId());
            Assertions.assertEquals("full_name", dimHRPerson.getFullName());
            Assertions.assertEquals("prefix_name", dimHRPerson.getPrefixName());
            Assertions.assertEquals("last_name", dimHRPerson.getLastName());
            Assertions.assertEquals("first_name", dimHRPerson.getFirstName());
            Assertions.assertEquals("middle_name", dimHRPerson.getMiddleName());
            Assertions.assertEquals("preferred_full_name", dimHRPerson.getPreferredFullName());
            Assertions.assertEquals("branch_code", dimHRPerson.getBranchCode());
            Assertions.assertEquals("dept_code", dimHRPerson.getDeptID());
            Assertions.assertEquals("group_code", dimHRPerson.getGroupCode());
            Assertions.assertEquals("section_code", dimHRPerson.getSectionCode());
            Assertions.assertEquals("lab_phone1_ext", dimHRPerson.getLabPhone1Ext());
            Assertions.assertEquals("full_lab_phone1_num", dimHRPerson.getFullLabPhone1Num());
            Assertions.assertEquals("email_id", dimHRPerson.getEmailId());
            Assertions.assertEquals("supervisor_level_code", dimHRPerson.getSupervisorLevelCode());
            Assertions.assertEquals("person_type_code", dimHRPerson.getPersonTypeCode());
            Assertions.assertEquals("job_class_desc", dimHRPerson.getJobClass());
            Assertions.assertEquals("lbr_class_desc", dimHRPerson.getLaborClassDescription());
            Assertions.assertEquals("job_designation_code", dimHRPerson.getJobDesignationCode());
            Assertions.assertEquals("offsite_flg", dimHRPerson.getOffsiteCode());
            Assertions.assertEquals("reg_temp_ind", dimHRPerson.getRegOrTempEmployee());
            Assertions.assertEquals("full_part_ind", dimHRPerson.getFullPartInd());
            Assertions.assertEquals(100, dimHRPerson.getWorkPercent());
            Assertions.assertEquals("group_supervisor_num", dimHRPerson.getGroupSupervisorNumber());
            Assertions.assertEquals("group_supervisor_full_name", dimHRPerson.getGroupSupervisorFullName());
            Assertions.assertEquals("section_supervisor_num", dimHRPerson.getSectionSupervisorNumber());
            Assertions.assertEquals("section_supervisor_full_name", dimHRPerson.getSectionSupervisorFullName());
            Assertions.assertEquals("program_level_num", dimHRPerson.getProgramLevelNumber());
            Assertions.assertEquals("office_bldg_num", dimHRPerson.getOfficeBuildingNumber());
            Assertions.assertEquals("facility_code", dimHRPerson.getFacilityCode());
            Assertions.assertEquals(YEAR_MONTH_DAY_DATE_FORMAT.parse("2020-03-14"), dimHRPerson.getLastUpdatedDate());
            Assertions.assertEquals("lbr_class_code", dimHRPerson.getLaborClassCode());
            Assertions.assertEquals("dept_name", dimHRPerson.getDeptName());
            Assertions.assertEquals("group_name", dimHRPerson.getGroupName());
            Assertions.assertEquals("section_name", dimHRPerson.getSectionName());
            Assertions.assertEquals("suffix_name", dimHRPerson.getSuffix());

        } catch(Exception e) {
            e.printStackTrace();
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void testGetVeMasterWo() {
        try {
            MockDenodoUtilities mockDenodoUtilities = new MockDenodoUtilities(DenodoEndpoint.VE_MASTER_WO);
            List<VeMasterWo> veMasterWoList = mockDenodoUtilities.getVeMasterWoList(Optional.empty(), Optional.empty());
            Assertions.assertFalse(veMasterWoList.isEmpty());

            VeMasterWo veMasterWo = veMasterWoList.get(0);
            Assertions.assertEquals("#9", veMasterWo.getBaseID());
            Assertions.assertEquals("SEH", veMasterWo.getChargeGroup());
            Assertions.assertEquals(YEAR_MONTH_DAY_DATE_FORMAT.parse("2017-03-17"), veMasterWo.getCreateDate());
            Assertions.assertEquals("89078, LANGLEY T", veMasterWo.getCustomer());
            Assertions.assertEquals("SEH-TESTING-3-REV.6", veMasterWo.getDescription());
            Assertions.assertEquals("Z", veMasterWo.getHardwareLevel());
            Assertions.assertEquals("1", veMasterWo.getLotID());
            Assertions.assertNull(veMasterWo.getOriginalWorkOrder());
            Assertions.assertEquals("#9", veMasterWo.getPartID());
            Assertions.assertEquals("89410, GARDNER M", veMasterWo.getPlanner());
            Assertions.assertNull(veMasterWo.getSerialNum());
            Assertions.assertEquals("0", veMasterWo.getSplitID());
            Assertions.assertEquals("U", veMasterWo.getStatus());
            Assertions.assertEquals("0", veMasterWo.getSubID());
            Assertions.assertEquals("GARDNMW1, 12/11/2017", veMasterWo.getTimestamp());
            Assertions.assertNull(veMasterWo.getWorkAuthorization());
            Assertions.assertNull(veMasterWo.getWbsCode());
            Assertions.assertEquals("N", veMasterWo.getWbsProject());
            Assertions.assertEquals("SEH", veMasterWo.getWorkOrderAssignee());
            Assertions.assertEquals("#9/1.0", veMasterWo.getWorkOrderNumber());
        } catch (Exception exception) {
            exception.printStackTrace();
            Assertions.fail(exception.getMessage());
        }
    }

    @Test
    public void testGetVeMasterWoOps() {
    	try {
    		MockDenodoUtilities mockDenodoUtilities = new MockDenodoUtilities(DenodoEndpoint.VE_MASTER_WO_OPS);
            List<VeMasterWoOps> veMasterWoOpsList = mockDenodoUtilities.getVeMasterWoOpsList(Optional.empty(), Optional.empty());
            Assertions.assertFalse(veMasterWoOpsList.isEmpty());

            VeMasterWoOps veMasterWoOps = veMasterWoOpsList.get(0);
            Assertions.assertEquals(0.0, veMasterWoOps.getActRunHours());
            Assertions.assertEquals(0.0, veMasterWoOps.getActSetupHours());
            Assertions.assertNull(veMasterWoOps.getCloseDate());
            Assertions.assertEquals(0.0, veMasterWoOps.getCompletedQuantity());
            Assertions.assertNull(veMasterWoOps.getEvwpms());
            Assertions.assertEquals(1000.0, veMasterWoOps.getLoadSizeQuantity());
            Assertions.assertEquals(0.0, veMasterWoOps.getMoveHours());
            Assertions.assertNull(veMasterWoOps.getOperationAssignee());
            Assertions.assertEquals("PLANNING-MAT-SE", veMasterWoOps.getOperationType());
            Assertions.assertEquals("PLAN-MATL", veMasterWoOps.getResourceID());
            Assertions.assertEquals(0.3, veMasterWoOps.getRun());
            Assertions.assertEquals(0.3, veMasterWoOps.getRunHours());
            Assertions.assertEquals("HRS/LOAD", veMasterWoOps.getRunType());
            Assertions.assertEquals(60.0, veMasterWoOps.getSequenceNumber());
            Assertions.assertEquals("N", veMasterWoOps.getSetupCompleted());
            Assertions.assertEquals(4.0, veMasterWoOps.getSetupHours());
            Assertions.assertEquals("U", veMasterWoOps.getStatus());
            Assertions.assertEquals("SANFOKB1, 3/10/2017", veMasterWoOps.getTimestamp());
            Assertions.assertNull(veMasterWoOps.getUserDefinedField2());
            Assertions.assertNull(veMasterWoOps.getUserDefinedField4());
            Assertions.assertNull(veMasterWoOps.getUserDefinedField5());
            Assertions.assertNull(veMasterWoOps.getUserDefinedField6());
            Assertions.assertNull(veMasterWoOps.getUserDefinedField7());
            Assertions.assertNull(veMasterWoOps.getUserDefinedField8());
            Assertions.assertNull(veMasterWoOps.getUserDefinedField9());
            Assertions.assertEquals("#9/1.0", veMasterWoOps.getWorkOrderNumber());
            Assertions.assertEquals("#9", veMasterWoOps.getWorkOrderBaseID());
            Assertions.assertEquals("1", veMasterWoOps.getWorkOrderLotID());
            Assertions.assertEquals("0", veMasterWoOps.getWorkOrderSplitID());
            Assertions.assertEquals("0", veMasterWoOps.getWorkOrderSubID());

    	}catch(Exception e) {
    		e.printStackTrace();
            Assertions.fail(e.getMessage());
    	}
    }

    @Test
    public void testGetVeParts() {
    	try {
    		MockDenodoUtilities mockDenodoUtilities = new MockDenodoUtilities(DenodoEndpoint.VE_PARTS);
            List<VeParts> vePartsList = mockDenodoUtilities.getVePartsList(Optional.empty(), Optional.empty());
            Assertions.assertFalse(vePartsList.isEmpty());

            VeParts veParts = vePartsList.get(0);
            Assertions.assertEquals("FOR ABLESTIK-285", veParts.getAttributes());
            Assertions.assertEquals("GARDNMW1", veParts.getBuyerUserID());
            Assertions.assertEquals("POLYMERIC", veParts.getCommodityCode());
            Assertions.assertNull(veParts.getConfigLevel());
            Assertions.assertEquals(YEAR_MONTH_DAY_DATE_FORMAT.parse("2019-03-06"), veParts.getCreateDate());
            Assertions.assertEquals("EPOXY,CATALYST", veParts.getDescription());
            Assertions.assertEquals("NEED 56C OR 2850FT", veParts.getDrawingID());
            Assertions.assertNull(veParts.getEsdClass());
            Assertions.assertEquals("EPOXY,CATALYST", veParts.getExtendedDescription());
            Assertions.assertEquals("Y", veParts.getFabricated());
            Assertions.assertEquals("CATALYST", veParts.getGpn());
            Assertions.assertEquals("#11", veParts.getId());
            Assertions.assertNull(veParts.getLeadEngineer());
            Assertions.assertNull(veParts.getMaximumOrderQuantity());
            Assertions.assertNull(veParts.getManufacturerName());
            Assertions.assertNull(veParts.getManufacturerPartID());
            Assertions.assertNull(veParts.getMinimumOrderQuantity());
            Assertions.assertEquals(YEAR_MONTH_DAY_DATE_FORMAT.parse("2020-08-03"), veParts.getModifyDate());
            Assertions.assertNull(veParts.getMrpExceptions());
            Assertions.assertEquals("Y", veParts.getMrpRequired());
            Assertions.assertEquals("FORMULA", veParts.getNmfcCodeId());
            Assertions.assertNull(veParts.getPackageType());
            Assertions.assertEquals("GARDNMW1", veParts.getPlannerUserID());
            Assertions.assertEquals(5.0, veParts.getPlanningLeadTime());
            Assertions.assertEquals("ZPURC-MECH", veParts.getProductCode());
            Assertions.assertEquals("Y", veParts.getPurchased());
            Assertions.assertEquals(1.0, veParts.getQuantityAvaliableISS());
            Assertions.assertEquals(1.0, veParts.getQuantityAvaliableMRP());
            Assertions.assertEquals(0, veParts.getQuantityInDemand());
            Assertions.assertEquals(1.0, veParts.getQuantityOnHand());
            Assertions.assertEquals(0.0, veParts.getQuantityOnOrder());
            Assertions.assertNull(veParts.getSafetyStockQty());
            Assertions.assertEquals("A", veParts.getStatus());
            Assertions.assertEquals("EA", veParts.getStockUM());
            Assertions.assertNull(veParts.getTapeWidth());
            Assertions.assertEquals("GARDNMW1, 3/6/2019", veParts.getTimestamp());
            Assertions.assertEquals("1LB", veParts.getValueSize());
            Assertions.assertEquals(0.0, veParts.getWeight());
            Assertions.assertNull(veParts.getWeightUM());

    	}catch(Exception e) {
    		e.printStackTrace();
            Assertions.fail(e.getMessage());
    	}
    }

    @Test
    public void testGetVeShopResource() {
    	try {
    		MockDenodoUtilities mockDenodoUtilities = new MockDenodoUtilities(DenodoEndpoint.VE_SHOP_RESOURCE);
            List<VeShopResource> veShopResourceList = mockDenodoUtilities.getVeShopResourceList(Optional.empty(), Optional.empty());
            Assertions.assertFalse(veShopResourceList.isEmpty());

    		VeShopResource veShopResource = veShopResourceList.get(0);
    		Assertions.assertEquals("LABOR", veShopResource.getCostCategoryID());
    		Assertions.assertEquals("SEH", veShopResource.getDepartmentID());
    		Assertions.assertEquals("PROJECT TASK", veShopResource.getDescription());
    		Assertions.assertEquals("P-TASK", veShopResource.getId());
    		Assertions.assertEquals("N", veShopResource.getScheduleNormally());
    		Assertions.assertEquals(0.0, veShopResource.getShift1Capacity());
    		Assertions.assertNull(veShopResource.getStatus());
    		Assertions.assertEquals(0.0, veShopResource.getStatusRank());
    		Assertions.assertEquals("W", veShopResource.getType());
    		Assertions.assertEquals("RESMNT", veShopResource.getUdfLayoutID());
    		Assertions.assertEquals("SD POWER AND PARTS", veShopResource.getUserDefinedField1());
    		Assertions.assertEquals("SANFOKB1, 9/29/2017", veShopResource.getUserDefinedField10());
    		Assertions.assertEquals("SEH", veShopResource.getUserDefinedField2());
    		Assertions.assertNull(veShopResource.getUserDefinedField3());
    		Assertions.assertNull(veShopResource.getUserDefinedField4());
    		Assertions.assertNull(veShopResource.getUserDefinedField5());
    		Assertions.assertNull(veShopResource.getUserDefinedField6());
    		Assertions.assertNull(veShopResource.getUserDefinedField7());
    		Assertions.assertNull(veShopResource.getUserDefinedField8());
    		Assertions.assertNull(veShopResource.getUserDefinedField9());
    		Assertions.assertEquals("Y", veShopResource.getWbsResourceType());

    	}catch(Exception e) {
    		e.printStackTrace();
            Assertions.fail(e.getMessage());
    	}
    }

    @Test
    public void testGetVeSpecialParts() {
    	try {
    		MockDenodoUtilities mockDenodoUtilities = new MockDenodoUtilities(DenodoEndpoint.VE_SPECIAL_PARTS);
            List<VeSpecialParts> veSpecialPartsList = mockDenodoUtilities.getVeSpecialPartsList(Optional.empty(), Optional.empty());
            Assertions.assertFalse(veSpecialPartsList.isEmpty());

    		VeSpecialParts veSpecialParts = veSpecialPartsList.get(0);
    		Assertions.assertEquals("Sn,SMT,ESD0", veSpecialParts.getAttributes());
    		Assertions.assertEquals("2", veSpecialParts.getConfigLevel());
    		Assertions.assertEquals(YEAR_MONTH_DAY_DATE_FORMAT.parse("2017-12-01"), veSpecialParts.getCreateDate());
    		Assertions.assertEquals("ERJ-1GEF", veSpecialParts.getDescription());
    		Assertions.assertEquals("0", veSpecialParts.getEsdClass());
    		Assertions.assertEquals("RESISTOR-CHIP", veSpecialParts.getExtendedPartDescription());
    		Assertions.assertEquals("Y", veSpecialParts.getFabricated());
    		Assertions.assertEquals("ERJ-1GE", veSpecialParts.getGpn());
    		Assertions.assertEquals("9", veSpecialParts.getGrade());
    		Assertions.assertEquals("ERJ-1GEF8201C-", veSpecialParts.getId());
    		Assertions.assertNull(veSpecialParts.getLeadEngineer());
    		Assertions.assertEquals(YEAR_MONTH_DAY_DATE_FORMAT.parse("2021-05-22"), veSpecialParts.getModifyDate());
    		Assertions.assertEquals("N", veSpecialParts.getPurchased());
    		Assertions.assertEquals("EA", veSpecialParts.getStockUM());
    		Assertions.assertNull(veSpecialParts.getTapeWidth());
    		Assertions.assertEquals("MIRANCM1, 2/28/2018", veSpecialParts.getTimestamp());
    		Assertions.assertNull(veSpecialParts.getValueSize());

    	}catch(Exception e) {
    		e.printStackTrace();
            Assertions.fail(e.getMessage());
    	}
    }

    @Test
    public void testGetVeUsers() {
    	try {
    		MockDenodoUtilities mockDenodoUtilities = new MockDenodoUtilities(DenodoEndpoint.VE_USERS);
    		List<VeUsers> veUsersList = mockDenodoUtilities.getVeUsersList(Optional.empty(), Optional.empty());
    		Assertions.assertFalse(veUsersList.isEmpty());

    		VeUsers veUsers = veUsersList.get(0);
    		Assertions.assertEquals("AMDS", veUsers.getDeptID());
    		Assertions.assertEquals("Jibu.Abraham@jhuapl.edu", veUsers.getEmailAddress());
    		Assertions.assertEquals("Jibu", veUsers.getFirstName());
    		Assertions.assertEquals("A1C", veUsers.getGroupID());
    		Assertions.assertEquals("22361", veUsers.getLabPhone1Extension());
    		Assertions.assertEquals("Abraham", veUsers.getLastName());
    		Assertions.assertEquals(YEAR_MONTH_DAY_DATE_FORMAT.parse("2020-07-29"), veUsers.getLastUpdateDate());
    		Assertions.assertEquals("Varghese", veUsers.getMiddleName());
    		Assertions.assertEquals("1-E241", veUsers.getOffice());
    		Assertions.assertEquals("00109490", veUsers.getPersonID());
    		Assertions.assertEquals("A", veUsers.getPersonStatusCode());
    		Assertions.assertEquals("A", veUsers.getPersonSubstatusCode());
    		Assertions.assertEquals("Abraham,Jibu V.", veUsers.getPreferredName());
    		Assertions.assertEquals("Mr.", veUsers.getPrefixName());
    		Assertions.assertEquals("ABRAHJV1", veUsers.getUsername());

    	}catch(Exception e) {
    		e.printStackTrace();
            Assertions.fail(e.getMessage());
    	}
    }

    @Test
    public void testGetVeWo() {
    	try {
    		MockDenodoUtilities mockDenodoUtilities = new MockDenodoUtilities(DenodoEndpoint.VE_WO);
    		List<VeWo> veWoList = mockDenodoUtilities.getVeWoList(Optional.empty(), Optional.empty());
    		Assertions.assertFalse(veWoList.isEmpty());

    		VeWo veWo = veWoList.get(0);
    		Assertions.assertEquals("00001", veWo.getBaseID());
    		Assertions.assertEquals("TEM-1", veWo.getChargeGroup());
    		Assertions.assertEquals(YEAR_MONTH_DAY_DATE_FORMAT.parse("2011-08-25"), veWo.getCreateDate());
    		Assertions.assertEquals("80790, ALVAREZ, BENJAMIN B", veWo.getCustomer());
    		Assertions.assertEquals("FP-11164-VIBE PLATE-MS", veWo.getDescription());
    		Assertions.assertEquals("1", veWo.getHardwareLevel());
    		Assertions.assertEquals("1", veWo.getLotID());
    		Assertions.assertNull(veWo.getOriginalWorkOrder());
    		Assertions.assertNull(veWo.getPartID());
    		Assertions.assertEquals("89039,BARLEY,LANCE", veWo.getPlanner());
    		Assertions.assertNull(veWo.getSerialNumber());
    		Assertions.assertEquals("0", veWo.getSplitID());
    		Assertions.assertEquals("C", veWo.getStatus());
    		Assertions.assertEquals("0", veWo.getSubID());
    		Assertions.assertNull(veWo.getTimestamp());
    		Assertions.assertEquals("11164", veWo.getWorkAuthorization());
    		Assertions.assertEquals("1WB", veWo.getWbsCode());
    		Assertions.assertEquals("N", veWo.getWbsProject());
    		Assertions.assertNull(veWo.getWorkOrderAssignee());
    		Assertions.assertEquals("00001/1.0", veWo.getWorkOrderNumber());

    	}catch(Exception e) {
    		e.printStackTrace();
            Assertions.fail(e.getMessage());
    	}
    }

    @Test
    public void testGetVeWoLaborTotals() {
    	try {
    		MockDenodoUtilities mockDenodoUtilities = new MockDenodoUtilities(DenodoEndpoint.VE_WO_LABOR_TOTALS);
    		List<VeWoLaborTotals> veWoLaborTotalsList = mockDenodoUtilities.getVeWoLaborTotalsList(Optional.empty(), Optional.empty());
    		Assertions.assertFalse(veWoLaborTotalsList.isEmpty());

    		VeWoLaborTotals veWoLaborTotals = veWoLaborTotalsList.get(0);
    		Assertions.assertEquals(143.5, veWoLaborTotals.getLaborTotals());
    		Assertions.assertEquals("S", veWoLaborTotals.getType());
    		Assertions.assertEquals("Y29X1/0.0", veWoLaborTotals.getWorkOrderNumber());

    	}catch(Exception e) {
    		e.printStackTrace();
            Assertions.fail(e.getMessage());
    	}
    }

    @Test
    public void testGetVeWoOps() {
    	try {
    		MockDenodoUtilities mockDenodoUtilities = new MockDenodoUtilities(DenodoEndpoint.VE_WO_OPS);
    		List<VeWoOps> veWoOpsList = mockDenodoUtilities.getVeWoOpsList(Optional.empty(), Optional.empty());
    		Assertions.assertFalse(veWoOpsList.isEmpty());

    		VeWoOps veWoOps = veWoOpsList.get(0);
    		Assertions.assertEquals(0.5, veWoOps.getActualRunHours());
    		Assertions.assertEquals(0.0, veWoOps.getActualSetupHours());
    		Assertions.assertEquals(YEAR_MONTH_DAY_DATE_FORMAT.parse("2011-09-01"), veWoOps.getCloseDate());
    		Assertions.assertEquals(1.0, veWoOps.getCompletedQuantity());
    		Assertions.assertNull(veWoOps.getEvwpms());
    		Assertions.assertNull(veWoOps.getLoadSizeQuantity());
    		Assertions.assertEquals(1.0, veWoOps.getMoveHours());
    		Assertions.assertNull(veWoOps.getOperationAssignee());
    		Assertions.assertEquals("PLANNING-M", veWoOps.getOperationType());
    		Assertions.assertEquals("M-PROD PLANNER", veWoOps.getResourceID());
    		Assertions.assertEquals(0.5, veWoOps.getRun());
    		Assertions.assertEquals(0.5, veWoOps.getRunHours());
    		Assertions.assertEquals("HRS/PC", veWoOps.getRunType());
    		Assertions.assertEquals(10.0, veWoOps.getSequenceNumber());
    		Assertions.assertEquals("Y", veWoOps.getSetupComplete());
    		Assertions.assertEquals(0.0, veWoOps.getSetupHours());
    		Assertions.assertEquals("C", veWoOps.getStatus());
    		Assertions.assertNull(veWoOps.getUserDefinedField10());
    		Assertions.assertEquals("00001/1.0", veWoOps.getWorkOrderNumber());
    		Assertions.assertEquals("00001", veWoOps.getWorkOrderBaseID());
    		Assertions.assertEquals("1", veWoOps.getWorkOrderLotID());
    		Assertions.assertEquals("0", veWoOps.getWorkOrderSplitID());
    		Assertions.assertEquals("0", veWoOps.getWorkOrderSubID());

    	}catch(Exception e) {
    		e.printStackTrace();
            Assertions.fail(e.getMessage());
    	}
    }

    @Test
    public void testGetVeWoOpsEquipment() {
    	try {
    		MockDenodoUtilities mockDenodoUtilities = new MockDenodoUtilities(DenodoEndpoint.VE_WO_OPS_EQUIPMENT);
    		List<VeWoOpsEquipment> veWoOpsEquipmentList = mockDenodoUtilities.getVeWoOpsEquipmentList(Optional.empty(), Optional.empty());
    		Assertions.assertFalse(veWoOpsEquipmentList.isEmpty());

    		VeWoOpsEquipment veWoOpsEquipment = veWoOpsEquipmentList.get(0);
    		Assertions.assertEquals(MONTH_DAY_YEAR_DATE_FORMAT.parse("02/25/2012"), veWoOpsEquipment.getEquipmentDateCalibrated());
    		Assertions.assertEquals(MONTH_DAY_YEAR_DATE_FORMAT.parse("09/08/2011"), veWoOpsEquipment.getEquipmentDateUsed());
    		Assertions.assertEquals("Scale", veWoOpsEquipment.getEquipmentDescription());
    		Assertions.assertEquals("210746", veWoOpsEquipment.getEquipmentID());
    		Assertions.assertEquals(150, veWoOpsEquipment.getOperationSequenceNumber());
    		Assertions.assertNull(veWoOpsEquipment.getPartID());
    		Assertions.assertEquals(40, veWoOpsEquipment.getPieceNumber());
    		Assertions.assertEquals(0.0, veWoOpsEquipment.getQuantityPer());
    		Assertions.assertEquals("C", veWoOpsEquipment.getStatus());
    		Assertions.assertEquals("LEESECB1 09/20/2011 10:45:10 AM", veWoOpsEquipment.getTimestamp());
    		Assertions.assertNull(veWoOpsEquipment.getUserDefinedField5());
    		Assertions.assertEquals("00005/1.0", veWoOpsEquipment.getWorkOrderNumber());
    		Assertions.assertEquals("00005", veWoOpsEquipment.getWorkOrderBaseID());
    		Assertions.assertEquals("1", veWoOpsEquipment.getWorkOrderLotID());
    		Assertions.assertEquals("0", veWoOpsEquipment.getWorkOrderSplitID());
    		Assertions.assertEquals("0", veWoOpsEquipment.getWorkOrderSubID());

    	}catch(Exception e) {
    		e.printStackTrace();
            Assertions.fail(e.getMessage());
    	}
    }

    @Test
    public void testGetVeWoOpsLabor() {
    	try {
    		MockDenodoUtilities mockDenodoUtilities = new MockDenodoUtilities(DenodoEndpoint.VE_WO_OPS_LABOR);
    		List<VeWoOpsLabor> veWoOpsLaborList = mockDenodoUtilities.getVeWoOpsLaborList(Optional.empty(), Optional.empty());
    		Assertions.assertFalse(veWoOpsLaborList.isEmpty());

    		VeWoOpsLabor veWoOpsLabor = veWoOpsLaborList.get(0);
    		Assertions.assertEquals(0.0, veWoOpsLabor.getBadQuantity());
    		Assertions.assertEquals("TEP", veWoOpsLabor.getDepartmentID());
    		Assertions.assertEquals("Labor Recorded By MDC Application", veWoOpsLabor.getDescription());
    		Assertions.assertEquals("00103031", veWoOpsLabor.getEmployeeID());
    		Assertions.assertEquals(0.0, veWoOpsLabor.getGoodQuantity());
    		Assertions.assertEquals(0.5, veWoOpsLabor.getHoursWorked());
    		Assertions.assertEquals(10, veWoOpsLabor.getOperationSequenceNumber());
    		Assertions.assertEquals("M-PROD PLANNER", veWoOpsLabor.getResourceID());
    		Assertions.assertEquals("Y", veWoOpsLabor.getSetupCompleted());
    		Assertions.assertEquals("2011-08-25", veWoOpsLabor.getTransactionDate());
    		Assertions.assertEquals(21, veWoOpsLabor.getTransactionID());
    		Assertions.assertEquals("R", veWoOpsLabor.getType());
    		Assertions.assertEquals("BARLELC1", veWoOpsLabor.getUserID());
    		Assertions.assertEquals("00001/1.0", veWoOpsLabor.getWorkOrderNumber());
    		Assertions.assertEquals("00001", veWoOpsLabor.getWorkOrderBaseID());
    		Assertions.assertEquals("1", veWoOpsLabor.getWorkOrderLotID());
    		Assertions.assertEquals("0", veWoOpsLabor.getWorkOrderSplitID());
    		Assertions.assertEquals("0", veWoOpsLabor.getWorkOrderSubID());

    	}catch(Exception e) {
    		e.printStackTrace();
            Assertions.fail(e.getMessage());
    	}
    }

    @Test
    public void testGetVeWoOpsMaterial() {
    	try {
    		MockDenodoUtilities mockDenodoUtilities = new MockDenodoUtilities(DenodoEndpoint.VE_WO_OPS_MATERIAL);
    		List<VeWoOpsMaterial> veWoOpsMaterialList = mockDenodoUtilities.getVeWoOpsMaterialList(Optional.empty(), Optional.empty());
    		Assertions.assertFalse(veWoOpsMaterialList.isEmpty());

    		VeWoOpsMaterial veWoOpsMaterial = veWoOpsMaterialList.get(0);
    		Assertions.assertEquals(MONTH_DAY_YEAR_DATE_FORMAT.parse("12/02/2011"), veWoOpsMaterial.getMaterialDateUsed());
    		Assertions.assertEquals("film adhesive", veWoOpsMaterial.getMaterialDescription());
    		Assertions.assertEquals("0287A3", veWoOpsMaterial.getMaterialID());
    		Assertions.assertEquals("038356", veWoOpsMaterial.getMaterialSerialNumber());
    		Assertions.assertEquals(50, veWoOpsMaterial.getOperationSequenceNumber());
    		Assertions.assertNull(veWoOpsMaterial.getPartID());
    		Assertions.assertEquals(10, veWoOpsMaterial.getPieceNumber());
    		Assertions.assertEquals(0.0, veWoOpsMaterial.getQuantityPer());
    		Assertions.assertEquals("C", veWoOpsMaterial.getStatus());
    		Assertions.assertEquals("SETZLWR1 09/20/2011 02:45:10 PM", veWoOpsMaterial.getTimestamp());
    		Assertions.assertEquals("00005/1.0", veWoOpsMaterial.getWorkOrderNumber());
    		Assertions.assertEquals("00005", veWoOpsMaterial.getWorkOrderBaseID());
    		Assertions.assertEquals("1", veWoOpsMaterial.getWorkOrderLotID());
    		Assertions.assertEquals("0", veWoOpsMaterial.getWorkOrderSplitID());
    		Assertions.assertEquals("0", veWoOpsMaterial.getWorkOrderSubID());

    	}catch(Exception e) {
    		e.printStackTrace();
            Assertions.fail(e.getMessage());
    	}
    }

    @Test
    public void testGetVmSysDataDictionary() {
    	try {
    		MockDenodoUtilities mockDenodoUtilities = new MockDenodoUtilities(DenodoEndpoint.VMSYS_DATA_DICTIONARY);
    		List<VmSysDataDictionary> vmSysDataDictionaryList = mockDenodoUtilities.getVmSysDataDictionaryList(Optional.empty(), Optional.empty());
    		Assertions.assertTrue(vmSysDataDictionaryList.isEmpty());

    	}catch(Exception e) {
    		e.printStackTrace();
            Assertions.fail(e.getMessage());
    	}
    }

    @Test
    public void testGetVmSysWorkAuth() {
    	try {
            MockDenodoUtilities mockDenodoUtilities = new MockDenodoUtilities(
                    DenodoEndpoint.VMSYS_WORKAUTH_CHANGE_HISTORY_VISTOOL);
            List<VmSysWorkAuthDetailChangeHistoryVistool> vmSysWorkAuthList = mockDenodoUtilities
                    .getVmSysWorkAuthDetailChangeHistoryVistoolList(Optional.empty(), Optional.empty());
    		Assertions.assertFalse(vmSysWorkAuthList.isEmpty());

            VmSysWorkAuthDetailChangeHistoryVistool vmSysWorkAuth = vmSysWorkAuthList.get(0);
            Assertions.assertEquals(YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_DATE_FORMAT.parse("2013-05-13T00:00:00"),
                    vmSysWorkAuth.getHeaderCreateDate());
    		Assertions.assertEquals("00095137", vmSysWorkAuth.getCustomer());
            Assertions.assertEquals("REDD", vmSysWorkAuth.getDepartmentId());
            Assertions.assertEquals("000005", vmSysWorkAuth.getHeaderId());
            Assertions.assertEquals(YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_DATE_FORMAT.parse("2013-05-13T07:59:09"),
                    vmSysWorkAuth.getHeaderLastModified());
    		Assertions.assertEquals("00104592", vmSysWorkAuth.getOriginator());
    		Assertions.assertEquals("T", vmSysWorkAuth.getStatus());
    		Assertions.assertEquals(YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_DATE_FORMAT.parse("2013-05-13T00:00:00"), vmSysWorkAuth.getSubmitDate());
            Assertions.assertEquals("YGTQAQXX", vmSysWorkAuth.getHeaderTa());
            Assertions.assertEquals("019", vmSysWorkAuth.getWorkAreaId());
            Assertions.assertEquals("minor change to the drawing", vmSysWorkAuth.getChangeComment());
            Assertions.assertEquals(121, vmSysWorkAuth.getChangeHeaderId());
            Assertions.assertFalse(vmSysWorkAuth.getChangeHeaderStopOrder());
            Assertions.assertEquals("2", vmSysWorkAuth.getChangeLineItemNumber());
            Assertions.assertEquals(122, vmSysWorkAuth.getChangeLineId());
            Assertions.assertFalse(vmSysWorkAuth.getChangeLineStopOrder());
            Assertions.assertNull(vmSysWorkAuth.getChangeLineQuantity());
            Assertions.assertEquals("CHIANS1", vmSysWorkAuth.getRequestor());
            Assertions.assertEquals("0", vmSysWorkAuth.getSplitId());
            Assertions.assertEquals(YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_DATE_FORMAT.parse("2015-09-02T15:00:20"), vmSysWorkAuth.getChangeSubmitDate());
            Assertions.assertEquals("0", vmSysWorkAuth.getSubId());
            Assertions.assertNull(vmSysWorkAuth.getChangeTa());
            Assertions.assertEquals("007274", vmSysWorkAuth.getChangeWorkAuthorizationId());
            Assertions.assertNull(vmSysWorkAuth.getAplGroupsId());
    		Assertions.assertNull(vmSysWorkAuth.getComments());
            Assertions.assertEquals(YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_DATE_FORMAT.parse("2013-05-13T00:00:00"),
                vmSysWorkAuth.getDetailCreateDate());
    		Assertions.assertEquals("IPC MIL-SPEC", vmSysWorkAuth.getDescription());
    		Assertions.assertNull(vmSysWorkAuth.getFlow());
    		Assertions.assertEquals("N", vmSysWorkAuth.getInPLM());
            Assertions.assertEquals(YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_DATE_FORMAT.parse("2014-04-23T17:08:38"),
                vmSysWorkAuth.getDetailLastModified());
    		Assertions.assertEquals("1", vmSysWorkAuth.getLineItem());
    		Assertions.assertNull(vmSysWorkAuth.getOriginalWorkOrder());
    		Assertions.assertNull(vmSysWorkAuth.getParentLot());
    		Assertions.assertNull(vmSysWorkAuth.getParentOperation());
            Assertions.assertNull(vmSysWorkAuth.getParentSplitId());
    		Assertions.assertNull(vmSysWorkAuth.getParentWorkOrder());
            Assertions.assertEquals("IPC-A-43RIGID", vmSysWorkAuth.getPartId());
    		Assertions.assertEquals(4, vmSysWorkAuth.getQuantity());
            Assertions.assertNull(vmSysWorkAuth.getReddFlowId());
    		Assertions.assertEquals("-", vmSysWorkAuth.getRevision());
            Assertions.assertEquals("0", vmSysWorkAuth.getSplitId());
            Assertions.assertEquals("YGTQAQXX", vmSysWorkAuth.getDetailTa());
    		Assertions.assertNull(vmSysWorkAuth.getUsingSN());
            Assertions.assertNull(vmSysWorkAuth.getWorkAuthorizationFlowId());
    		Assertions.assertEquals(YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_DATE_FORMAT.parse("2013-09-30T00:00:00"), vmSysWorkAuth.getWantDate());
            Assertions.assertEquals("000005", vmSysWorkAuth.getWorkAuthorizationId());
    	}catch(Exception e) {
    		e.printStackTrace();
            Assertions.fail(e.getMessage());
    	}
    }

    @Test
    public void testGetVmSysWorkAuthDoc() {
    	try {
    		MockDenodoUtilities mockDenodoUtilities = new MockDenodoUtilities(DenodoEndpoint.VMSYS_WORK_AUTH_DOC);
    		List<VmSysWorkAuthDoc> vmSysWorkAuthDocList = mockDenodoUtilities.getVmSysWorkAuthDocList(Optional.empty(), Optional.empty());
    		Assertions.assertFalse(vmSysWorkAuthDocList.isEmpty());

    		VmSysWorkAuthDoc vmSysWorkAuthDoc = vmSysWorkAuthDocList.get(0);
    		Assertions.assertNull(vmSysWorkAuthDoc.getDocumentType());
    		Assertions.assertEquals("DEV-BOARD-GERBER[572013124243713].zip", vmSysWorkAuthDoc.getDocumentName());
    		Assertions.assertEquals("\\prod\\WA-000003-1-0-0\\", vmSysWorkAuthDoc.getDocumentPath());
    		Assertions.assertEquals(1, vmSysWorkAuthDoc.getDocumentID());
    		Assertions.assertEquals("1", vmSysWorkAuthDoc.getWorkAuthorizationLineNumber());
    		Assertions.assertEquals("0", vmSysWorkAuthDoc.getSplitID());
    		Assertions.assertEquals("000003", vmSysWorkAuthDoc.getWorkAuthorizationID());

    	}catch(Exception e) {
    		e.printStackTrace();
            Assertions.fail(e.getMessage());
    	}
    }
}
