package edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.denodo;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.DimHRPerson;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Date;

/* Per team discussion, not updating the repository at this time (04/25/2023) with all the new fields in the dim_hr_person interface.
 * New methods for fields to be added as they become needed.
 */
public interface DimHRPersonRepository extends JpaRepository<DimHRPerson, Long>, JpaSpecificationExecutor<DimHRPerson>  {
    static Specification<DimHRPerson> branchCodeIsNull() {
        return (dimHRPerson, cq, cb) -> cb.isNull(dimHRPerson.get("branchCode"));
    }
    static Specification<DimHRPerson> branchCodeIsNotNull() {
        return (dimHRPerson, cq, cb) -> cb.isNotNull(dimHRPerson.get("branchCode"));
    }
    static Specification<DimHRPerson> branchCodeEqualTo(String branchCode) {
        return (dimHRPerson, cq, cb) -> cb.equal(dimHRPerson.get("branchCode"), branchCode);
    }
    static Specification<DimHRPerson> branchCodeNotEqualTo(String branchCode) {
        return (dimHRPerson, cq, cb) -> cb.notEqual(dimHRPerson.get("branchCode"), branchCode);
    }
    static Specification<DimHRPerson> deptIDIsNull() {
        return (dimHRPerson, cq, cb) -> cb.isNull(dimHRPerson.get("deptID"));
    }
    static Specification<DimHRPerson> deptIDIsNotNull() {
        return (dimHRPerson, cq, cb) -> cb.isNotNull(dimHRPerson.get("deptID"));
    }
    static Specification<DimHRPerson> deptIDEqualTo(String deptID) {
        return (dimHRPerson, cq, cb) -> cb.equal(dimHRPerson.get("deptID"), deptID);
    }
    static Specification<DimHRPerson> deptIDNotEqualTo(String deptID) {
        return (dimHRPerson, cq, cb) -> cb.notEqual(dimHRPerson.get("deptID"), deptID);
    }
    static Specification<DimHRPerson> deptNameIsNull() {
        return (dimHRPerson, cq, cb) -> cb.isNull(dimHRPerson.get("deptName"));
    }
    static Specification<DimHRPerson> deptNameIsNotNull() {
        return (dimHRPerson, cq, cb) -> cb.isNotNull(dimHRPerson.get("deptName"));
    }
    static Specification<DimHRPerson> deptNameEqualTo(String deptName) {
        return (dimHRPerson, cq, cb) -> cb.equal(dimHRPerson.get("deptName"), deptName);
    }
    static Specification<DimHRPerson> deptNameNotEqualTo(String deptName) {
        return (dimHRPerson, cq, cb) -> cb.notEqual(dimHRPerson.get("deptName"), deptName);
    }
    static Specification<DimHRPerson> emailIdIsNull() {
        return (dimHRPerson, cq, cb) -> cb.isNull(dimHRPerson.get("emailId"));
    }
    static Specification<DimHRPerson> emailIdIsNotNull() {
        return (dimHRPerson, cq, cb) -> cb.isNotNull(dimHRPerson.get("emailId"));
    }
    static Specification<DimHRPerson> emailIdEqualTo(String emailId) {
        return (dimHRPerson, cq, cb) -> cb.equal(dimHRPerson.get("emailId"), emailId);
    }
    static Specification<DimHRPerson> emailIdNotEqualTo(String emailId) {
        return (dimHRPerson, cq, cb) -> cb.notEqual(dimHRPerson.get("emailId"), emailId);
    }
    static Specification<DimHRPerson> facilityCodeIsNull() {
        return (dimHRPerson, cq, cb) -> cb.isNull(dimHRPerson.get("facilityCode"));
    }
    static Specification<DimHRPerson> facilityCodeIsNotNull() {
        return (dimHRPerson, cq, cb) -> cb.isNotNull(dimHRPerson.get("facilityCode"));
    }
    static Specification<DimHRPerson> facilityCodeEqualTo(String facilityCode) {
        return (dimHRPerson, cq, cb) -> cb.equal(dimHRPerson.get("facilityCode"), facilityCode);
    }
    static Specification<DimHRPerson> facilityCodeNotEqualTo(String facilityCode) {
        return (dimHRPerson, cq, cb) -> cb.notEqual(dimHRPerson.get("facilityCode"), facilityCode);
    }
    static Specification<DimHRPerson> firstNameIsNull() {
        return (dimHRPerson, cq, cb) -> cb.isNull(dimHRPerson.get("firstName"));
    }
    static Specification<DimHRPerson> firstNameIsNotNull() {
        return (dimHRPerson, cq, cb) -> cb.isNotNull(dimHRPerson.get("firstName"));
    }
    static Specification<DimHRPerson> firstNameEqualTo(String firstName) {
        return (dimHRPerson, cq, cb) -> cb.equal(dimHRPerson.get("firstName"), firstName);
    }
    static Specification<DimHRPerson> firstNameNotEqualTo(String firstName) {
        return (dimHRPerson, cq, cb) -> cb.notEqual(dimHRPerson.get("firstName"), firstName);
    }
    static Specification<DimHRPerson> fullLabPhone1NumIsNull() {
        return (dimHRPerson, cq, cb) -> cb.isNull(dimHRPerson.get("fullLabPhone1Num"));
    }
    static Specification<DimHRPerson> fullLabPhone1NumIsNotNull() {
        return (dimHRPerson, cq, cb) -> cb.isNotNull(dimHRPerson.get("fullLabPhone1Num"));
    }
    static Specification<DimHRPerson> fullLabPhone1NumEqualTo(String fullLabPhone1Num) {
        return (dimHRPerson, cq, cb) -> cb.equal(dimHRPerson.get("fullLabPhone1Num"), fullLabPhone1Num);
    }
    static Specification<DimHRPerson> fullLabPhone1NumNotEqualTo(String fullLabPhone1Num) {
        return (dimHRPerson, cq, cb) -> cb.notEqual(dimHRPerson.get("fullLabPhone1Num"), fullLabPhone1Num);
    }
    static Specification<DimHRPerson> fullNameIsNull() {
        return (dimHRPerson, cq, cb) -> cb.isNull(dimHRPerson.get("fullName"));
    }
    static Specification<DimHRPerson> fullNameIsNotNull() {
        return (dimHRPerson, cq, cb) -> cb.isNotNull(dimHRPerson.get("fullName"));
    }
    static Specification<DimHRPerson> fullNameEqualTo(String fullName) {
        return (dimHRPerson, cq, cb) -> cb.equal(dimHRPerson.get("fullName"), fullName);
    }
    static Specification<DimHRPerson> fullNameNotEqualTo(String fullName) {
        return (dimHRPerson, cq, cb) -> cb.notEqual(dimHRPerson.get("fullName"), fullName);
    }
    static Specification<DimHRPerson> fullPartIndIsNull() {
        return (dimHRPerson, cq, cb) -> cb.isNull(dimHRPerson.get("fullPartInd"));
    }
    static Specification<DimHRPerson> fullPartIndIsNotNull() {
        return (dimHRPerson, cq, cb) -> cb.isNotNull(dimHRPerson.get("fullPartInd"));
    }
    static Specification<DimHRPerson> fullPartIndEqualTo(String fullPartInd) {
        return (dimHRPerson, cq, cb) -> cb.equal(dimHRPerson.get("fullPartInd"), fullPartInd);
    }
    static Specification<DimHRPerson> fullPartIndNotEqualTo(String fullPartInd) {
        return (dimHRPerson, cq, cb) -> cb.notEqual(dimHRPerson.get("fullPartInd"), fullPartInd);
    }
    static Specification<DimHRPerson> groupCodeIsNull() {
        return (dimHRPerson, cq, cb) -> cb.isNull(dimHRPerson.get("groupCode"));
    }
    static Specification<DimHRPerson> groupCodeIsNotNull() {
        return (dimHRPerson, cq, cb) -> cb.isNotNull(dimHRPerson.get("groupCode"));
    }
    static Specification<DimHRPerson> groupCodeEqualTo(String groupCode) {
        return (dimHRPerson, cq, cb) -> cb.equal(dimHRPerson.get("groupCode"), groupCode);
    }
    static Specification<DimHRPerson> groupCodeNotEqualTo(String groupCode) {
        return (dimHRPerson, cq, cb) -> cb.notEqual(dimHRPerson.get("groupCode"), groupCode);
    }
    static Specification<DimHRPerson> groupNameIsNull() {
        return (dimHRPerson, cq, cb) -> cb.isNull(dimHRPerson.get("groupName"));
    }
    static Specification<DimHRPerson> groupNameIsNotNull() {
        return (dimHRPerson, cq, cb) -> cb.isNotNull(dimHRPerson.get("groupName"));
    }
    static Specification<DimHRPerson> groupNameEqualTo(String groupName) {
        return (dimHRPerson, cq, cb) -> cb.equal(dimHRPerson.get("groupName"), groupName);
    }
    static Specification<DimHRPerson> groupNameNotEqualTo(String groupName) {
        return (dimHRPerson, cq, cb) -> cb.notEqual(dimHRPerson.get("groupName"), groupName);
    }
    static Specification<DimHRPerson> groupSupervisorNumberIsNull() {
        return (dimHRPerson, cq, cb) -> cb.isNull(dimHRPerson.get("groupSupervisorNumber"));
    }
    static Specification<DimHRPerson> groupSupervisorNumberIsNotNull() {
        return (dimHRPerson, cq, cb) -> cb.isNotNull(dimHRPerson.get("groupSupervisorNumber"));
    }
    static Specification<DimHRPerson> groupSupervisorNumberEqualTo(String groupSupervisorNumber) {
        return (dimHRPerson, cq, cb) -> cb.equal(dimHRPerson.get("groupSupervisorNumber"), groupSupervisorNumber);
    }
    static Specification<DimHRPerson> groupSupervisorNumberNotEqualTo(String groupSupervisorNumber) {
        return (dimHRPerson, cq, cb) -> cb.notEqual(dimHRPerson.get("groupSupervisorNumber"), groupSupervisorNumber);
    }
    static Specification<DimHRPerson> groupSupervisorFullNameIsNull() {
        return (dimHRPerson, cq, cb) -> cb.isNull(dimHRPerson.get("groupSupervisorFullName"));
    }
    static Specification<DimHRPerson> groupSupervisorFullNameIsNotNull() {
        return (dimHRPerson, cq, cb) -> cb.isNotNull(dimHRPerson.get("groupSupervisorFullName"));
    }
    static Specification<DimHRPerson> groupSupervisorFullNameEqualTo(String groupSupervisorFullName) {
        return (dimHRPerson, cq, cb) -> cb.equal(dimHRPerson.get("groupSupervisorFullName"), groupSupervisorFullName);
    }
    static Specification<DimHRPerson> groupSupervisorFullNameNotEqualTo(String groupSupervisorFullName) {
        return (dimHRPerson, cq, cb) -> cb.notEqual(dimHRPerson.get("groupSupervisorFullName"), groupSupervisorFullName);
    }
    static Specification<DimHRPerson> jobClassIsNull() {
        return (dimHRPerson, cq, cb) -> cb.isNull(dimHRPerson.get("jobClass"));
    }
    static Specification<DimHRPerson> jobClassIsNotNull() {
        return (dimHRPerson, cq, cb) -> cb.isNotNull(dimHRPerson.get("jobClass"));
    }
    static Specification<DimHRPerson> jobClassEqualTo(String jobClass) {
        return (dimHRPerson, cq, cb) -> cb.equal(dimHRPerson.get("jobClass"), jobClass);
    }
    static Specification<DimHRPerson> jobClassNotEqualTo(String jobClass) {
        return (dimHRPerson, cq, cb) -> cb.notEqual(dimHRPerson.get("jobClass"), jobClass);
    }
    static Specification<DimHRPerson> jobDesignationCodeIsNull() {
        return (dimHRPerson, cq, cb) -> cb.isNull(dimHRPerson.get("jobDesignationCode"));
    }
    static Specification<DimHRPerson> jobDesignationCodeIsNotNull() {
        return (dimHRPerson, cq, cb) -> cb.isNotNull(dimHRPerson.get("jobDesignationCode"));
    }
    static Specification<DimHRPerson> jobDesignationCodeEqualTo(String jobDesignationCode) {
        return (dimHRPerson, cq, cb) -> cb.equal(dimHRPerson.get("jobDesignationCode"), jobDesignationCode);
    }
    static Specification<DimHRPerson> jobDesignationCodeNotEqualTo(String jobDesignationCode) {
        return (dimHRPerson, cq, cb) -> cb.notEqual(dimHRPerson.get("jobDesignationCode"), jobDesignationCode);
    }
    static Specification<DimHRPerson> laborClassCodeIsNull() {
        return (dimHRPerson, cq, cb) -> cb.isNull(dimHRPerson.get("laborClassCode"));
    }
    static Specification<DimHRPerson> laborClassCodeIsNotNull() {
        return (dimHRPerson, cq, cb) -> cb.isNotNull(dimHRPerson.get("laborClassCode"));
    }
    static Specification<DimHRPerson> laborClassCodeEqualTo(String laborClassCode) {
        return (dimHRPerson, cq, cb) -> cb.equal(dimHRPerson.get("laborClassCode"), laborClassCode);
    }
    static Specification<DimHRPerson> laborClassCodeNotEqualTo(String laborClassCode) {
        return (dimHRPerson, cq, cb) -> cb.notEqual(dimHRPerson.get("laborClassCode"), laborClassCode);
    }
    static Specification<DimHRPerson> laborClassDescriptionIsNull() {
        return (dimHRPerson, cq, cb) -> cb.isNull(dimHRPerson.get("laborClassDescription"));
    }
    static Specification<DimHRPerson> laborClassDescriptionIsNotNull() {
        return (dimHRPerson, cq, cb) -> cb.isNotNull(dimHRPerson.get("laborClassDescription"));
    }
    static Specification<DimHRPerson> laborClassDescriptionEqualTo(String laborClassDescription) {
        return (dimHRPerson, cq, cb) -> cb.equal(dimHRPerson.get("laborClassDescription"), laborClassDescription);
    }
    static Specification<DimHRPerson> laborClassDescriptionNotEqualTo(String laborClassDescription) {
        return (dimHRPerson, cq, cb) -> cb.notEqual(dimHRPerson.get("laborClassDescription"), laborClassDescription);
    }
    static Specification<DimHRPerson> labPhone1ExtIsNull() {
        return (dimHRPerson, cq, cb) -> cb.isNull(dimHRPerson.get("labPhone1Ext"));
    }
    static Specification<DimHRPerson> labPhone1ExtIsNotNull() {
        return (dimHRPerson, cq, cb) -> cb.isNotNull(dimHRPerson.get("labPhone1Ext"));
    }
    static Specification<DimHRPerson> labPhone1ExtEqualTo(String labPhone1Ext) {
        return (dimHRPerson, cq, cb) -> cb.equal(dimHRPerson.get("labPhone1Ext"), labPhone1Ext);
    }
    static Specification<DimHRPerson> labPhone1ExtNotEqualTo(String labPhone1Ext) {
        return (dimHRPerson, cq, cb) -> cb.notEqual(dimHRPerson.get("labPhone1Ext"), labPhone1Ext);
    }
    static Specification<DimHRPerson> lastNameIsNull() {
        return (dimHRPerson, cq, cb) -> cb.isNull(dimHRPerson.get("lastName"));
    }
    static Specification<DimHRPerson> lastNameIsNotNull() {
        return (dimHRPerson, cq, cb) -> cb.isNotNull(dimHRPerson.get("lastName"));
    }
    static Specification<DimHRPerson> lastNameEqualTo(String lastName) {
        return (dimHRPerson, cq, cb) -> cb.equal(dimHRPerson.get("lastName"), lastName);
    }
    static Specification<DimHRPerson> lastNameNotEqualTo(String lastName) {
        return (dimHRPerson, cq, cb) -> cb.notEqual(dimHRPerson.get("lastName"), lastName);
    }
    static Specification<DimHRPerson> lastUpdatedDateIsNull() {
        return (dimHRPerson, cq, cb) -> cb.isNull(dimHRPerson.get("lastUpdatedDate"));
    }
    static Specification<DimHRPerson> lastUpdatedDateIsNotNull() {
        return (dimHRPerson, cq, cb) -> cb.isNotNull(dimHRPerson.get("lastUpdatedDate"));
    }
    static Specification<DimHRPerson> lastUpdatedDateEqualTo(Date lastUpdatedDate) {
        return (dimHRPerson, cq, cb) -> cb.equal(dimHRPerson.get("lastUpdatedDate"), lastUpdatedDate);
    }
    static Specification<DimHRPerson> lastUpdatedDateNotEqualTo(Date lastUpdatedDate) {
        return (dimHRPerson, cq, cb) -> cb.notEqual(dimHRPerson.get("lastUpdatedDate"), lastUpdatedDate);
    }
    static Specification<DimHRPerson> lastUpdatedDateBefore(Date lastUpdatedDate) {
        return (dimHRPerson, cq, cb) -> cb.lessThan(dimHRPerson.get("lastUpdatedDate"), lastUpdatedDate);
    }
    static Specification<DimHRPerson> lastUpdatedDateAfter(Date lastUpdatedDate) {
        return (dimHRPerson, cq, cb) -> cb.greaterThan(dimHRPerson.get("lastUpdatedDate"), lastUpdatedDate);
    }
    static Specification<DimHRPerson> middleNameIsNull() {
        return (dimHRPerson, cq, cb) -> cb.isNull(dimHRPerson.get("middleName"));
    }
    static Specification<DimHRPerson> middleNameIsNotNull() {
        return (dimHRPerson, cq, cb) -> cb.isNotNull(dimHRPerson.get("middleName"));
    }
    static Specification<DimHRPerson> middleNameEqualTo(String middleName) {
        return (dimHRPerson, cq, cb) -> cb.equal(dimHRPerson.get("middleName"), middleName);
    }
    static Specification<DimHRPerson> middleNameNotEqualTo(String middleName) {
        return (dimHRPerson, cq, cb) -> cb.notEqual(dimHRPerson.get("middleName"), middleName);
    }
    static Specification<DimHRPerson> officeBuildingNumberIsNull() {
        return (dimHRPerson, cq, cb) -> cb.isNull(dimHRPerson.get("officeBuildingNumber"));
    }
    static Specification<DimHRPerson> officeBuildingNumberIsNotNull() {
        return (dimHRPerson, cq, cb) -> cb.isNotNull(dimHRPerson.get("officeBuildingNumber"));
    }
    static Specification<DimHRPerson> officeBuildingNumberEqualTo(String officeBuildingNumber) {
        return (dimHRPerson, cq, cb) -> cb.equal(dimHRPerson.get("officeBuildingNumber"), officeBuildingNumber);
    }
    static Specification<DimHRPerson> officeBuildingNumberNotEqualTo(String officeBuildingNumber) {
        return (dimHRPerson, cq, cb) -> cb.notEqual(dimHRPerson.get("officeBuildingNumber"), officeBuildingNumber);
    }
    static Specification<DimHRPerson> offsiteCodeIsNull() {
        return (dimHRPerson, cq, cb) -> cb.isNull(dimHRPerson.get("offsiteCode"));
    }
    static Specification<DimHRPerson> offsiteCodeIsNotNull() {
        return (dimHRPerson, cq, cb) -> cb.isNotNull(dimHRPerson.get("offsiteCode"));
    }
    static Specification<DimHRPerson> offsiteCodeEqualTo(String offsiteCode) {
        return (dimHRPerson, cq, cb) -> cb.equal(dimHRPerson.get("offsiteCode"), offsiteCode);
    }
    static Specification<DimHRPerson> offsiteCodeNotEqualTo(String offsiteCode) {
        return (dimHRPerson, cq, cb) -> cb.notEqual(dimHRPerson.get("offsiteCode"), offsiteCode);
    }
    static Specification<DimHRPerson> personNumberIsNull() {
        return (dimHRPerson, cq, cb) -> cb.isNull(dimHRPerson.get("personNumber"));
    }
    static Specification<DimHRPerson> personNumberIsNotNull() {
        return (dimHRPerson, cq, cb) -> cb.isNotNull(dimHRPerson.get("personNumber"));
    }
    static Specification<DimHRPerson> personNumberEqualTo(String personNumber) {
        return (dimHRPerson, cq, cb) -> cb.equal(dimHRPerson.get("personNumber"), personNumber);
    }
    static Specification<DimHRPerson> personNumberNotEqualTo(String personNumber) {
        return (dimHRPerson, cq, cb) -> cb.notEqual(dimHRPerson.get("personNumber"), personNumber);
    }
    static Specification<DimHRPerson> personStatusCodeIsNull() {
        return (dimHRPerson, cq, cb) -> cb.isNull(dimHRPerson.get("personStatusCode"));
    }
    static Specification<DimHRPerson> personStatusCodeIsNotNull() {
        return (dimHRPerson, cq, cb) -> cb.isNotNull(dimHRPerson.get("personStatusCode"));
    }
    static Specification<DimHRPerson> personStatusCodeEqualTo(String personStatusCode) {
        return (dimHRPerson, cq, cb) -> cb.equal(dimHRPerson.get("personStatusCode"), personStatusCode);
    }
    static Specification<DimHRPerson> personStatusCodeNotEqualTo(String personStatusCode) {
        return (dimHRPerson, cq, cb) -> cb.notEqual(dimHRPerson.get("personStatusCode"), personStatusCode);
    }
    static Specification<DimHRPerson> personTypeCodeIsNull() {
        return (dimHRPerson, cq, cb) -> cb.isNull(dimHRPerson.get("personTypeCode"));
    }
    static Specification<DimHRPerson> personTypeCodeIsNotNull() {
        return (dimHRPerson, cq, cb) -> cb.isNotNull(dimHRPerson.get("personTypeCode"));
    }
    static Specification<DimHRPerson> personTypeCodeEqualTo(String personTypeCode) {
        return (dimHRPerson, cq, cb) -> cb.equal(dimHRPerson.get("personTypeCode"), personTypeCode);
    }
    static Specification<DimHRPerson> personTypeCodeNotEqualTo(String personTypeCode) {
        return (dimHRPerson, cq, cb) -> cb.notEqual(dimHRPerson.get("personTypeCode"), personTypeCode);
    }
    static Specification<DimHRPerson> preferredFullNameIsNull() {
        return (dimHRPerson, cq, cb) -> cb.isNull(dimHRPerson.get("preferredFullName"));
    }
    static Specification<DimHRPerson> preferredFullNameIsNotNull() {
        return (dimHRPerson, cq, cb) -> cb.isNotNull(dimHRPerson.get("preferredFullName"));
    }
    static Specification<DimHRPerson> preferredFullNameEqualTo(String preferredFullName) {
        return (dimHRPerson, cq, cb) -> cb.equal(dimHRPerson.get("preferredFullName"), preferredFullName);
    }
    static Specification<DimHRPerson> preferredFullNameNotEqualTo(String preferredFullName) {
        return (dimHRPerson, cq, cb) -> cb.notEqual(dimHRPerson.get("preferredFullName"), preferredFullName);
    }
    static Specification<DimHRPerson> prefixNameIsNull() {
        return (dimHRPerson, cq, cb) -> cb.isNull(dimHRPerson.get("prefixName"));
    }
    static Specification<DimHRPerson> prefixNameIsNotNull() {
        return (dimHRPerson, cq, cb) -> cb.isNotNull(dimHRPerson.get("prefixName"));
    }
    static Specification<DimHRPerson> prefixNameEqualTo(String prefixName) {
        return (dimHRPerson, cq, cb) -> cb.equal(dimHRPerson.get("prefixName"), prefixName);
    }
    static Specification<DimHRPerson> prefixNameNotEqualTo(String prefixName) {
        return (dimHRPerson, cq, cb) -> cb.notEqual(dimHRPerson.get("prefixName"), prefixName);
    }
    static Specification<DimHRPerson> programLevelNumberIsNull() {
        return (dimHRPerson, cq, cb) -> cb.isNull(dimHRPerson.get("programLevelNumber"));
    }
    static Specification<DimHRPerson> programLevelNumberIsNotNull() {
        return (dimHRPerson, cq, cb) -> cb.isNotNull(dimHRPerson.get("programLevelNumber"));
    }
    static Specification<DimHRPerson> programLevelNumberEqualTo(String programLevelNumber) {
        return (dimHRPerson, cq, cb) -> cb.equal(dimHRPerson.get("programLevelNumber"), programLevelNumber);
    }
    static Specification<DimHRPerson> programLevelNumberNotEqualTo(String programLevelNumber) {
        return (dimHRPerson, cq, cb) -> cb.notEqual(dimHRPerson.get("programLevelNumber"), programLevelNumber);
    }
    static Specification<DimHRPerson> regOrTempEmployeeIsNull() {
        return (dimHRPerson, cq, cb) -> cb.isNull(dimHRPerson.get("regOrTempEmployee"));
    }
    static Specification<DimHRPerson> regOrTempEmployeeIsNotNull() {
        return (dimHRPerson, cq, cb) -> cb.isNotNull(dimHRPerson.get("regOrTempEmployee"));
    }
    static Specification<DimHRPerson> regOrTempEmployeeEqualTo(String regOrTempEmployee) {
        return (dimHRPerson, cq, cb) -> cb.equal(dimHRPerson.get("regOrTempEmployee"), regOrTempEmployee);
    }
    static Specification<DimHRPerson> regOrTempEmployeeNotEqualTo(String regOrTempEmployee) {
        return (dimHRPerson, cq, cb) -> cb.notEqual(dimHRPerson.get("regOrTempEmployee"), regOrTempEmployee);
    }
    static Specification<DimHRPerson> sectionCodeIsNull() {
        return (dimHRPerson, cq, cb) -> cb.isNull(dimHRPerson.get("sectionCode"));
    }
    static Specification<DimHRPerson> sectionCodeIsNotNull() {
        return (dimHRPerson, cq, cb) -> cb.isNotNull(dimHRPerson.get("sectionCode"));
    }
    static Specification<DimHRPerson> sectionCodeEqualTo(String sectionCode) {
        return (dimHRPerson, cq, cb) -> cb.equal(dimHRPerson.get("sectionCode"), sectionCode);
    }
    static Specification<DimHRPerson> sectionCodeNotEqualTo(String sectionCode) {
        return (dimHRPerson, cq, cb) -> cb.notEqual(dimHRPerson.get("sectionCode"), sectionCode);
    }
    static Specification<DimHRPerson> sectionNameIsNull() {
        return (dimHRPerson, cq, cb) -> cb.isNull(dimHRPerson.get("sectionName"));
    }
    static Specification<DimHRPerson> sectionNameIsNotNull() {
        return (dimHRPerson, cq, cb) -> cb.isNotNull(dimHRPerson.get("sectionName"));
    }
    static Specification<DimHRPerson> sectionNameEqualTo(String sectionName) {
        return (dimHRPerson, cq, cb) -> cb.equal(dimHRPerson.get("sectionName"), sectionName);
    }
    static Specification<DimHRPerson> sectionNameNotEqualTo(String sectionName) {
        return (dimHRPerson, cq, cb) -> cb.notEqual(dimHRPerson.get("sectionName"), sectionName);
    }
    static Specification<DimHRPerson> sectionSupervisorIDIsNull() {
        return (dimHRPerson, cq, cb) -> cb.isNull(dimHRPerson.get("sectionSupervisorID"));
    }
    static Specification<DimHRPerson> sectionSupervisorIDIsNotNull() {
        return (dimHRPerson, cq, cb) -> cb.isNotNull(dimHRPerson.get("sectionSupervisorID"));
    }
    static Specification<DimHRPerson> sectionSupervisorIDEqualTo(String sectionSupervisorID) {
        return (dimHRPerson, cq, cb) -> cb.equal(dimHRPerson.get("sectionSupervisorID"), sectionSupervisorID);
    }
    static Specification<DimHRPerson> sectionSupervisorIDNotEqualTo(String sectionSupervisorID) {
        return (dimHRPerson, cq, cb) -> cb.notEqual(dimHRPerson.get("sectionSupervisorID"), sectionSupervisorID);
    }
    static Specification<DimHRPerson> sectionSupervisorNameIsNull() {
        return (dimHRPerson, cq, cb) -> cb.isNull(dimHRPerson.get("sectionSupervisorName"));
    }
    static Specification<DimHRPerson> sectionSupervisorNameIsNotNull() {
        return (dimHRPerson, cq, cb) -> cb.isNotNull(dimHRPerson.get("sectionSupervisorName"));
    }
    static Specification<DimHRPerson> sectionSupervisorNameEqualTo(String sectionSupervisorName) {
        return (dimHRPerson, cq, cb) -> cb.equal(dimHRPerson.get("sectionSupervisorName"), sectionSupervisorName);
    }
    static Specification<DimHRPerson> sectionSupervisorNameNotEqualTo(String sectionSupervisorName) {
        return (dimHRPerson, cq, cb) -> cb.notEqual(dimHRPerson.get("sectionSupervisorName"), sectionSupervisorName);
    }
    static Specification<DimHRPerson> suffixIsNull() {
        return (dimHRPerson, cq, cb) -> cb.isNull(dimHRPerson.get("suffix"));
    }
    static Specification<DimHRPerson> suffixIsNotNull() {
        return (dimHRPerson, cq, cb) -> cb.isNotNull(dimHRPerson.get("suffix"));
    }
    static Specification<DimHRPerson> suffixEqualTo(String suffix) {
        return (dimHRPerson, cq, cb) -> cb.equal(dimHRPerson.get("suffix"), suffix);
    }
    static Specification<DimHRPerson> suffixNotEqualTo(String suffix) {
        return (dimHRPerson, cq, cb) -> cb.notEqual(dimHRPerson.get("suffix"), suffix);
    }
    static Specification<DimHRPerson> supervisorLevelCodeIsNull() {
        return (dimHRPerson, cq, cb) -> cb.isNull(dimHRPerson.get("supervisorLevelCode"));
    }
    static Specification<DimHRPerson> supervisorLevelCodeIsNotNull() {
        return (dimHRPerson, cq, cb) -> cb.isNotNull(dimHRPerson.get("supervisorLevelCode"));
    }
    static Specification<DimHRPerson> supervisorLevelCodeEqualTo(String supervisorLevelCode) {
        return (dimHRPerson, cq, cb) -> cb.equal(dimHRPerson.get("supervisorLevelCode"), supervisorLevelCode);
    }
    static Specification<DimHRPerson> supervisorLevelCodeNotEqualTo(String supervisorLevelCode) {
        return (dimHRPerson, cq, cb) -> cb.notEqual(dimHRPerson.get("supervisorLevelCode"), supervisorLevelCode);
    }
    static Specification<DimHRPerson> userIdIsNull() {
        return (dimHRPerson, cq, cb) -> cb.isNull(dimHRPerson.get("userId"));
    }
    static Specification<DimHRPerson> userIdIsNotNull() {
        return (dimHRPerson, cq, cb) -> cb.isNotNull(dimHRPerson.get("userId"));
    }
    static Specification<DimHRPerson> userIdEqualTo(String userId) {
        return (dimHRPerson, cq, cb) -> cb.equal(dimHRPerson.get("userId"), userId);
    }
    static Specification<DimHRPerson> userIdNotEqualTo(String userId) {
        return (dimHRPerson, cq, cb) -> cb.notEqual(dimHRPerson.get("userId"), userId);
    }
    static Specification<DimHRPerson> workPercentIsNull() {
        return (dimHRPerson, cq, cb) -> cb.isNull(dimHRPerson.get("workPercent"));
    }
    static Specification<DimHRPerson> workPercentIsNotNull() {
        return (dimHRPerson, cq, cb) -> cb.isNotNull(dimHRPerson.get("workPercent"));
    }
    static Specification<DimHRPerson> workPercentEqualTo(Integer workPercent) {
        return (dimHRPerson, cq, cb) -> cb.equal(dimHRPerson.get("workPercent"), workPercent);
    }
    static Specification<DimHRPerson> workPercentNotEqualTo(Integer workPercent) {
        return (dimHRPerson, cq, cb) -> cb.notEqual(dimHRPerson.get("workPercent"), workPercent);
    }
    static Specification<DimHRPerson> workPercentLessThan(Integer workPercent) {
        return (dimHRPerson, cq, cb) -> cb.lessThan(dimHRPerson.get("workPercent"), workPercent);
    }
    static Specification<DimHRPerson> workPercentGreaterThan(Integer workPercent) {
        return (dimHRPerson, cq, cb) -> cb.greaterThan(dimHRPerson.get("workPercent"), workPercent);
    }
}
