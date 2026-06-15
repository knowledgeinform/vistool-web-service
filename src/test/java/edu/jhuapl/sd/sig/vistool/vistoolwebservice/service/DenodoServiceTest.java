package edu.jhuapl.sd.sig.vistool.vistoolwebservice.service;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.*;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.DenodoUtilities;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.ScheduledTasks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.junit.Assume.assumeTrue;

@SpringBootTest
@MockBean(ScheduledTasks.class)
@ActiveProfiles({"local-dev-secure-h2"})
public class DenodoServiceTest {
    @Autowired private DenodoService denodoService;
    @Autowired private DenodoUtilities denodoUtilities;

    @Value("${testing.integration.denodo}")
	private Boolean testsEnabled;

    private final Integer LIMIT = 10;

    @BeforeEach
	public void beforeEach() {
		assumeTrue(testsEnabled);
	}

	@Test
	public void testDimHRPerson() throws Exception {
    	List<DimHRPerson> expected = denodoUtilities.getDimHRPersonList(Optional.empty(), Optional.of(LIMIT));
		Assertions.assertFalse(expected.isEmpty());

		denodoService.deleteAllDimHRPerson();
		denodoService.addDimHRPerson(expected);
		List<DimHRPerson> actual = denodoService.getAllDimHRPerson();
		Assertions.assertFalse(actual.isEmpty());
		Assertions.assertEquals(actual.size(), actual.size());

		denodoService.deleteAllDimHRPerson();
		actual = denodoService.getAllDimHRPerson();
		Assertions.assertTrue(actual.isEmpty());
	}

    @Test
	public void testVeMasterWoOps() throws Exception {
        List<VeMasterWoOps> expected = denodoUtilities.getVeMasterWoOpsList(Optional.empty(), Optional.of(LIMIT));
        Assertions.assertFalse(expected.isEmpty());

		denodoService.deleteAllVeMasterWoOps();
        denodoService.addVeMasterWoOps(expected);
        List<VeMasterWoOps> actual = denodoService.getAllVeMasterWoOps();
        Assertions.assertFalse(actual.isEmpty());
        Assertions.assertEquals(expected.size(), actual.size());

        denodoService.deleteAllVeMasterWoOps();
        actual = denodoService.getAllVeMasterWoOps();
        Assertions.assertTrue(actual.isEmpty());
    }
    
    @Test
	public void testVeMasterWo() throws Exception {
    	List<VeMasterWo> expected =denodoUtilities.getVeMasterWoList(Optional.empty(), Optional.of(LIMIT));
    	Assertions.assertFalse(expected.isEmpty());

		denodoService.deleteAllVeMasterWo();
    	denodoService.addVeMasterWo(expected);
    	List<VeMasterWo> actual = denodoService.getAllVeMasterWo();
    	Assertions.assertFalse(actual.isEmpty());
    	Assertions.assertEquals(expected.size(), actual.size());
    	
    	denodoService.deleteAllVeMasterWo();
    	actual = denodoService.getAllVeMasterWo();
    	Assertions.assertTrue(actual.isEmpty());
    }
    
    @Test
    public void testVeParts() throws Exception {
    	List<VeParts> expected = denodoUtilities.getVePartsList(Optional.empty(), Optional.of(LIMIT));
    	Assertions.assertFalse(expected.isEmpty());

		denodoService.deleteAllVeParts();
    	denodoService.addVeParts(expected);
    	List<VeParts> actual = denodoService.getAllVeParts();
    	Assertions.assertFalse(actual.isEmpty());
    	Assertions.assertEquals(expected.size(), actual.size());
    	
    	denodoService.deleteAllVeParts();
    	actual = denodoService.getAllVeParts();
    	Assertions.assertTrue(actual.isEmpty());
    }
    
    @Test
    public void testVeShopResource() throws Exception {
    	List<VeShopResource> expected = denodoUtilities.getVeShopResourceList(Optional.empty(), Optional.of(LIMIT));
    	Assertions.assertFalse(expected.isEmpty());

		denodoService.deleteAllVeShopResource();
    	denodoService.addVeShopResource(expected);
    	List<VeShopResource> actual = denodoService.getAllVeShopResource();
    	Assertions.assertFalse(actual.isEmpty());
    	Assertions.assertEquals(expected.size(), actual.size());
    	
    	denodoService.deleteAllVeShopResource();
    	actual = denodoService.getAllVeShopResource();
    	Assertions.assertTrue(actual.isEmpty());
    }
    
    @Test
    public void testVeSpecialParts() throws Exception {
    	List<VeSpecialParts> expected = denodoUtilities.getVeSpecialPartsList(Optional.empty(), Optional.of(LIMIT));
    	Assertions.assertFalse(expected.isEmpty());

		denodoService.deleteAllVeSpecialParts();
    	denodoService.addVeSpecialParts(expected);
    	List<VeSpecialParts> actual = denodoService.getAllVeSpecialParts();
    	Assertions.assertFalse(actual.isEmpty());
    	Assertions.assertEquals(expected.size(), actual.size());
    	
    	denodoService.deleteAllVeSpecialParts();
    	actual = denodoService.getAllVeSpecialParts();
    	Assertions.assertTrue(actual.isEmpty());
    }
    
    @Test
    public void testVeUsers() throws Exception {
    	List<VeUsers> expected = denodoUtilities.getVeUsersList(Optional.empty(), Optional.of(LIMIT));
    	Assertions.assertFalse(expected.isEmpty());

		denodoService.deleteAllVeUsers();
    	denodoService.addVeUsers(expected);
    	List<VeUsers> actual = denodoService.getAllVeUsers();
    	Assertions.assertFalse(actual.isEmpty());
    	Assertions.assertEquals(expected.size(), actual.size());
    	
    	denodoService.deleteAllVeUsers();
    	actual = denodoService.getAllVeUsers();
    	Assertions.assertTrue(actual.isEmpty());
    }
    
    @Test
    public void testVeWo() throws Exception {
    	List<VeWo> expected = denodoUtilities.getVeWoList(Optional.empty(), Optional.of(LIMIT));
    	Assertions.assertFalse(expected.isEmpty());

		denodoService.deleteAllVeWo();
    	denodoService.addVeWo(expected);
    	List<VeWo> actual = denodoService.getAllVeWo();
    	Assertions.assertFalse(actual.isEmpty());
    	Assertions.assertEquals(expected.size(), actual.size());
    	
    	denodoService.deleteAllVeWo();
    	actual = denodoService.getAllVeWo();
    	Assertions.assertTrue(actual.isEmpty());
    }

    @Test
    public void testVeWoLaborTotals() throws Exception {
    	List<VeWoLaborTotals> expected = denodoUtilities.getVeWoLaborTotalsList(Optional.empty(), Optional.of(LIMIT));
    	Assertions.assertFalse(expected.isEmpty());

		denodoService.deleteAllVeWoLaborTotals();
    	denodoService.addVeWoLaborTotals(expected);
    	List<VeWoLaborTotals> actual = denodoService.getAllVeWoLaborTotals();
    	Assertions.assertFalse(actual.isEmpty());
    	Assertions.assertTrue(expected.size() >= actual.size());
    	
    	denodoService.deleteAllVeWoLaborTotals();
    	actual = denodoService.getAllVeWoLaborTotals();
    	Assertions.assertTrue(actual.isEmpty());
    }
    
    @Test
    public void testVeWoOps() throws Exception {
    	List<VeWoOps> expected = denodoUtilities.getVeWoOpsList(Optional.empty(), Optional.of(LIMIT));
    	Assertions.assertFalse(expected.isEmpty());

		denodoService.deleteAllVeWoOps();
    	denodoService.addVeWoOps(expected);
    	List<VeWoOps> actual = denodoService.getAllVeWoOps();
    	Assertions.assertFalse(actual.isEmpty());
    	Assertions.assertEquals(expected.size(), actual.size());
    	
    	denodoService.deleteAllVeWoOps();
    	actual = denodoService.getAllVeWoOps();
    	Assertions.assertTrue(actual.isEmpty());
    }
    
    @Test
    public void testVeWoOpsEquipment() throws Exception {
    	List<VeWoOpsEquipment> expected = denodoUtilities.getVeWoOpsEquipmentList(Optional.empty(), Optional.of(LIMIT));
    	Assertions.assertFalse(expected.isEmpty());

		denodoService.deleteAllVeWoOpsEquipment();
    	denodoService.addVeWoOpsEquipment(expected);
    	List<VeWoOpsEquipment> actual = denodoService.getAllVeWoOpsEquipment();
    	Assertions.assertFalse(actual.isEmpty());
    	Assertions.assertEquals(expected.size(), actual.size());
    	
    	denodoService.deleteAllVeWoOpsEquipment();
    	actual = denodoService.getAllVeWoOpsEquipment();
    	Assertions.assertTrue(actual.isEmpty());
    }
    
    @Test
    public void testVeWoOpsLabor() throws Exception {
    	List<VeWoOpsLabor> expected = denodoUtilities.getVeWoOpsLaborList(Optional.empty(), Optional.of(LIMIT));
    	Assertions.assertFalse(expected.isEmpty());

		denodoService.deleteAllVeWoOpsLabor();
    	denodoService.addVeWoOpsLabor(expected);
    	List<VeWoOpsLabor> actual = denodoService.getAllVeWoOpsLabor();
    	Assertions.assertFalse(actual.isEmpty());
    	Assertions.assertEquals(expected.size(), actual.size());
    	
    	denodoService.deleteAllVeWoOpsLabor();
    	actual = denodoService.getAllVeWoOpsLabor();
    	Assertions.assertTrue(actual.isEmpty());
    }
    
    @Test
    public void testVeWoOpsMaterial() throws Exception {
    	List<VeWoOpsMaterial> expected = denodoUtilities.getVeWoOpsMaterialList(Optional.empty(), Optional.of(LIMIT));
    	Assertions.assertFalse(expected.isEmpty());

    	denodoService.deleteAllVeWoOpsMaterial();
    	denodoService.addVeWoOpsMaterial(expected);
    	List<VeWoOpsMaterial> actual = denodoService.getAllVeWoOpsMaterial();
    	Assertions.assertFalse(actual.isEmpty());
    	Assertions.assertEquals(expected.size(), actual.size());
    	
    	denodoService.deleteAllVeWoOpsMaterial();
    	actual = denodoService.getAllVeWoOpsMaterial();
    	Assertions.assertTrue(actual.isEmpty());
    }
    
    @Test
    public void testVmSysDataDictionary() throws Exception {
    	List<VmSysDataDictionary> expected = denodoUtilities.getVmSysDataDictionaryList(Optional.empty(), Optional.of(LIMIT));
    	Assertions.assertFalse(expected.isEmpty());

    	denodoService.deleteAllVmSysDataDictionary();
    	denodoService.addVmSysDataDictionary(expected);
    	List<VmSysDataDictionary> actual = denodoService.getAllVmSysDataDictionary();
    	Assertions.assertFalse(actual.isEmpty());
		Assertions.assertEquals(expected.size(), actual.size());

		denodoService.deleteAllVmSysDataDictionary();
		actual = denodoService.getAllVmSysDataDictionary();
		Assertions.assertTrue(actual.isEmpty());
    }
    
    @Test
    public void testVmSysWorkAuth() throws Exception {
		List<VmSysWorkAuthDetailChangeHistoryVistool> expected = denodoUtilities
				.getVmSysWorkAuthDetailChangeHistoryVistoolList(Optional.empty(),
				Optional.of(LIMIT));
    	Assertions.assertFalse(expected.isEmpty());

		denodoService.deleteAllVmSysWorkAuthChangeHistoryVistool();
		denodoService.addVmSysWorkAuthChangeHistoryVistool(expected);
		List<VmSysWorkAuthDetailChangeHistoryVistool> actual = denodoService.getAllVmSysWorkAuthChangeHistoryVistool();
    	Assertions.assertFalse(actual.isEmpty());
    	Assertions.assertEquals(expected.size(), actual.size());
    	
		denodoService.deleteAllVmSysWorkAuthChangeHistoryVistool();
		actual = denodoService.getAllVmSysWorkAuthChangeHistoryVistool();
    	Assertions.assertTrue(actual.isEmpty());
    }
    
    @Test
    public void testVmSysWorkAuthDoc() throws Exception {
    	List<VmSysWorkAuthDoc> expected = denodoUtilities.getVmSysWorkAuthDocList(Optional.empty(), Optional.of(LIMIT));
    	Assertions.assertFalse(expected.isEmpty());

    	denodoService.deleteAllVmSysWorkAuthDoc();
    	denodoService.addVmSysWorkAuthDoc(expected);
    	List<VmSysWorkAuthDoc> actual = denodoService.getAllVmSysWorkAuthDoc();
    	Assertions.assertFalse(actual.isEmpty());
    	Assertions.assertEquals(expected.size(), actual.size());
    	
    	denodoService.deleteAllVmSysWorkAuthDoc();
    	actual = denodoService.getAllVmSysWorkAuthDoc();
    	Assertions.assertTrue(actual.isEmpty());
    }
}
