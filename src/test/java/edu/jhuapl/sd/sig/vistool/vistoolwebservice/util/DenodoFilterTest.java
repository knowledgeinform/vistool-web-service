package edu.jhuapl.sd.sig.vistool.vistoolwebservice.util;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.exceptions.InvalidFilterException;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.VmSysWorkAuthDetailChangeHistoryVistool;

import org.junit.Assert;
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

import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.constants.denodo.VmSysWorkAuthDetailChangeHistoryVistoolConstants.*;
import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.exceptions.InvalidFilterException.NOT_ENOUGH_CONSTRAINTS;
import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.DenodoFilter.Constraints.*;
import static org.junit.Assume.assumeTrue;

@SpringBootTest
@MockBean(ScheduledTasks.class)
@ActiveProfiles({"local-dev-secure-h2"})
public class DenodoFilterTest {
    @Autowired private DenodoUtilities denodoUtilities;

    @Value("${testing.integration.denodo}")
    private Boolean testsEnabled;

    @BeforeEach
    public void beforeEach() {
        assumeTrue(testsEnabled);
    }

    private final String testWorkAuthorizationID = "000002";

    public List<VmSysWorkAuthDetailChangeHistoryVistool> getAndVerifyVmSysWorkAuthList(String filter)
            throws Exception {
        List<VmSysWorkAuthDetailChangeHistoryVistool> vmSysWorkAuthList = denodoUtilities
                .getVmSysWorkAuthDetailChangeHistoryVistoolList(Optional.of(filter), Optional.empty());
        Assert.assertFalse(vmSysWorkAuthList.isEmpty());
        return vmSysWorkAuthList;
    }

    @Test
    public void testGetVmSysWorkAuthDetailWithEqualsConstraint() throws Exception {
        String filter = DenodoFilter.builder()
                .addConstraint(WORKAUTH_DETAIL_WORK_AUTHORIZATION_ID, EQUALS, testWorkAuthorizationID)
            .create();

        List<VmSysWorkAuthDetailChangeHistoryVistool> vmSysWorkAuthDetailList = getAndVerifyVmSysWorkAuthList(
                filter);
        Assertions.assertEquals(6, vmSysWorkAuthDetailList.size());

        for (VmSysWorkAuthDetailChangeHistoryVistool vmSysWorkAuthDetail : vmSysWorkAuthDetailList) {
            Assertions.assertEquals(testWorkAuthorizationID, vmSysWorkAuthDetail.getWorkAuthorizationId());
        }
    }

    @Test
    public void testGetVmSysWorkAuthDetailWithEqualsAndNotEqualsConstraint() throws Exception {
        String filter = DenodoFilter.builder()
                .addConstraint(WORKAUTH_DETAIL_WORK_AUTHORIZATION_ID, EQUALS, testWorkAuthorizationID)
                .addConstraint(WORKAUTH_DETAIL_LINE_ITEM, NOT_EQUALS, "1")
            .create();

        List<VmSysWorkAuthDetailChangeHistoryVistool> vmSysWorkAuthDetailList = getAndVerifyVmSysWorkAuthList(
                filter);
        Assertions.assertEquals(5, vmSysWorkAuthDetailList.size());

        for (VmSysWorkAuthDetailChangeHistoryVistool vmSysWorkAuthDetail : vmSysWorkAuthDetailList) {
            Assertions.assertEquals(testWorkAuthorizationID, vmSysWorkAuthDetail.getWorkAuthorizationId());
            Assertions.assertNotEquals("1", vmSysWorkAuthDetail.getLineItem());
        }
    }

    @Test
    public void testGetVmSysWorkAuthDetailWithEqualsAndNotEqualsAndLessThanConstraint() throws Exception {
        String filter = DenodoFilter.builder()
                .addConstraint(WORKAUTH_DETAIL_WORK_AUTHORIZATION_ID, EQUALS, testWorkAuthorizationID)
                .addConstraint(WORKAUTH_DETAIL_LINE_ITEM, NOT_EQUALS, "1")
                .addConstraint(WORKAUTH_DETAIL_QUANTITY, LESS_THAN, "2")
            .create();

        List<VmSysWorkAuthDetailChangeHistoryVistool> vmSysWorkAuthDetailList = getAndVerifyVmSysWorkAuthList(
                filter);
        Assertions.assertEquals(0, vmSysWorkAuthDetailList.size());
    }

    @Test
    public void testGetVmSysWorkAuthDetailWithEqualsAndNotEqualsAndLessThanOrEqualToConstraint() throws Exception {
        String filter = DenodoFilter.builder()
                .addConstraint(WORKAUTH_DETAIL_WORK_AUTHORIZATION_ID, EQUALS, testWorkAuthorizationID)
                .addConstraint(WORKAUTH_DETAIL_LINE_ITEM, NOT_EQUALS, "1")
                .addConstraint(WORKAUTH_DETAIL_QUANTITY, LESS_THAN_OR_EQUAL_TO, "2")
            .create();

        List<VmSysWorkAuthDetailChangeHistoryVistool> vmSysWorkAuthDetailList = getAndVerifyVmSysWorkAuthList(
                filter);
        Assertions.assertEquals(5, vmSysWorkAuthDetailList.size());

        for (VmSysWorkAuthDetailChangeHistoryVistool vmSysWorkAuthDetail : vmSysWorkAuthDetailList) {
            Assertions.assertEquals(testWorkAuthorizationID, vmSysWorkAuthDetail.getWorkAuthorizationId());
            Assertions.assertNotEquals("1", vmSysWorkAuthDetail.getLineItem());
            Assertions.assertTrue(vmSysWorkAuthDetail.getQuantity() <= 2);
        }
    }

    @Test
    public void testGetVmSysWorkAuthDetailWithEqualsAndGreaterThanConstraint() throws Exception {
        String filter = DenodoFilter.builder()
                .addConstraint(WORKAUTH_DETAIL_WORK_AUTHORIZATION_ID, EQUALS, testWorkAuthorizationID)
                .addConstraint(WORKAUTH_DETAIL_LINE_ITEM, GREATER_THAN, "2")
                .create();

        List<VmSysWorkAuthDetailChangeHistoryVistool> vmSysWorkAuthDetailList = getAndVerifyVmSysWorkAuthList(
                filter);
        Assertions.assertEquals(4, vmSysWorkAuthDetailList.size());

        for (VmSysWorkAuthDetailChangeHistoryVistool vmSysWorkAuthDetail : vmSysWorkAuthDetailList) {
            Assertions.assertEquals(testWorkAuthorizationID, vmSysWorkAuthDetail.getWorkAuthorizationId());
            Assertions.assertTrue(Integer.parseInt(vmSysWorkAuthDetail.getLineItem()) > 2);
        }
    }

    @Test
    public void testGetVmSysWorkAuthDetailWithEqualsAndGreaterThanOrEqualToConstraint() throws Exception {
        String filter = DenodoFilter.builder()
                .addConstraint(WORKAUTH_DETAIL_WORK_AUTHORIZATION_ID, EQUALS, testWorkAuthorizationID)
                .addConstraint(WORKAUTH_DETAIL_LINE_ITEM, GREATER_THAN_OR_EQUAL_TO, "5")
                .create();

        List<VmSysWorkAuthDetailChangeHistoryVistool> vmSysWorkAuthDetailList = getAndVerifyVmSysWorkAuthList(
                filter);
        Assertions.assertEquals(2, vmSysWorkAuthDetailList.size());

        for (VmSysWorkAuthDetailChangeHistoryVistool vmSysWorkAuthDetail : vmSysWorkAuthDetailList) {
            Assertions.assertEquals(testWorkAuthorizationID, vmSysWorkAuthDetail.getWorkAuthorizationId());
            Assertions.assertTrue(Integer.parseInt(vmSysWorkAuthDetail.getLineItem()) >= 5);
        }
    }

    @Test
    public void testGetVmSysWorkAuthDetailWithEqualsAndLikeConstraint() throws Exception {
        String filter = DenodoFilter.builder()
                .addConstraint(WORKAUTH_DETAIL_WORK_AUTHORIZATION_ID, EQUALS, testWorkAuthorizationID)
                .addConstraint(WORKAUTH_DETAIL_DESCRIPTION, LIKE, "'%AMP%'")
            .create();

        List<VmSysWorkAuthDetailChangeHistoryVistool> vmSysWorkAuthDetailList = getAndVerifyVmSysWorkAuthList(
                filter);
        Assertions.assertEquals(2, vmSysWorkAuthDetailList.size());

        for (VmSysWorkAuthDetailChangeHistoryVistool vmSysWorkAuthDetail : vmSysWorkAuthDetailList) {
            Assertions.assertEquals(testWorkAuthorizationID, vmSysWorkAuthDetail.getWorkAuthorizationId());
            Assertions.assertTrue(vmSysWorkAuthDetail.getDescription().contains("AMP"));
        }
    }

    @Test
    public void testGetVmSysWorkAuthDetailWithEqualsAndLikeAndNotLikeConstraint() throws Exception {
        String filter = DenodoFilter.builder()
                .addConstraint(WORKAUTH_DETAIL_WORK_AUTHORIZATION_ID, EQUALS, testWorkAuthorizationID)
                .addConstraint(WORKAUTH_DETAIL_DESCRIPTION, LIKE, "'%AMP%'")
                .addConstraint(WORKAUTH_DETAIL_PART_ID, NOT_LIKE, "'%7014%'")
            .create();

        List<VmSysWorkAuthDetailChangeHistoryVistool> vmSysWorkAuthDetailList = getAndVerifyVmSysWorkAuthList(
                filter);
        Assertions.assertEquals(1, vmSysWorkAuthDetailList.size());

        for (VmSysWorkAuthDetailChangeHistoryVistool vmSysWorkAuthDetail : vmSysWorkAuthDetailList) {
            Assertions.assertEquals(testWorkAuthorizationID, vmSysWorkAuthDetail.getWorkAuthorizationId());
            Assertions.assertTrue(vmSysWorkAuthDetail.getDescription().contains("AMP"));
            Assertions.assertFalse(vmSysWorkAuthDetail.getDescription().contains("20"));
        }
    }

    @Test
    public void testGetVmSysWorkAuthDetailWithEqualsAndIsNullConstraint() throws Exception {
        String filter = DenodoFilter.builder()
                .addConstraint(WORKAUTH_DETAIL_WORK_AUTHORIZATION_ID, EQUALS, testWorkAuthorizationID)
                .addConstraint(WORKAUTH_DETAIL_TA, IS_NULL, null)
                .create();

        List<VmSysWorkAuthDetailChangeHistoryVistool> vmSysWorkAuthDetailList = getAndVerifyVmSysWorkAuthList(
                filter);
        Assertions.assertEquals(0, vmSysWorkAuthDetailList.size());
    }

    @Test
    public void testGetVmSysWorkAuthDetailWithEqualsAndIsNotNullConstraint() throws Exception {
        String filter = DenodoFilter.builder()
                .addConstraint(WORKAUTH_DETAIL_WORK_AUTHORIZATION_ID, EQUALS, testWorkAuthorizationID)
                .addConstraint(WORKAUTH_DETAIL_REDD_FLOW_ID, IS_NOT_NULL, null)
                .create();

        List<VmSysWorkAuthDetailChangeHistoryVistool> vmSysWorkAuthDetailList = getAndVerifyVmSysWorkAuthList(
                filter);
        Assertions.assertEquals(0, vmSysWorkAuthDetailList.size());
    }

    @Test
    public void testFilterWithNoConstraints() {
        try {
            String filter = DenodoFilter.builder().create();
        }
        catch(InvalidFilterException invalidFilterException) {
            Assertions.assertEquals(NOT_ENOUGH_CONSTRAINTS, invalidFilterException.getMessage());
            return;
        }
        Assertions.fail("Exception expected but didn't occur!");
    }

}
