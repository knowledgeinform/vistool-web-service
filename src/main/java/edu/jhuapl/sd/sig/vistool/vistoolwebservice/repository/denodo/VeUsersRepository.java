package edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.denodo;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.VeUsers;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Date;

public interface VeUsersRepository extends JpaRepository<VeUsers, Long>, JpaSpecificationExecutor<VeUsers>{
    static Specification<VeUsers> deptIDIsNull() {
        return (veUsers, cq, cb) -> cb.isNull(veUsers.get("deptID"));
    }
    static Specification<VeUsers> deptIDIsNotNull() {
        return (veUsers, cq, cb) -> cb.isNotNull(veUsers.get("deptID"));
    }
    static Specification<VeUsers> deptIDEqualTo(String deptID) {
        return (veUsers, cq, cb) -> cb.equal(veUsers.get("deptID"), deptID);
    }
    static Specification<VeUsers> deptIDNotEqualTo(String deptID) {
        return (veUsers, cq, cb) -> cb.notEqual(veUsers.get("deptID"), deptID);
    }
    static Specification<VeUsers> emailAddressIsNull() {
        return (veUsers, cq, cb) -> cb.isNull(veUsers.get("emailAddress"));
    }
    static Specification<VeUsers> emailAddressIsNotNull() {
        return (veUsers, cq, cb) -> cb.isNotNull(veUsers.get("emailAddress"));
    }
    static Specification<VeUsers> emailAddressEqualTo(String emailAddress) {
        return (veUsers, cq, cb) -> cb.equal(veUsers.get("emailAddress"), emailAddress);
    }
    static Specification<VeUsers> emailAddressNotEqualTo(String emailAddress) {
        return (veUsers, cq, cb) -> cb.notEqual(veUsers.get("emailAddress"), emailAddress);
    }
    static Specification<VeUsers> firstNameIsNull() {
        return (veUsers, cq, cb) -> cb.isNull(veUsers.get("firstName"));
    }
    static Specification<VeUsers> firstNameIsNotNull() {
        return (veUsers, cq, cb) -> cb.isNotNull(veUsers.get("firstName"));
    }
    static Specification<VeUsers> firstNameEqualTo(String firstName) {
        return (veUsers, cq, cb) -> cb.equal(veUsers.get("firstName"), firstName);
    }
    static Specification<VeUsers> firstNameNotEqualTo(String firstName) {
        return (veUsers, cq, cb) -> cb.notEqual(veUsers.get("firstName"), firstName);
    }
    static Specification<VeUsers> groupIDIsNull() {
        return (veUsers, cq, cb) -> cb.isNull(veUsers.get("groupID"));
    }
    static Specification<VeUsers> groupIDIsNotNull() {
        return (veUsers, cq, cb) -> cb.isNotNull(veUsers.get("groupID"));
    }
    static Specification<VeUsers> groupIDEqualTo(String groupID) {
        return (veUsers, cq, cb) -> cb.equal(veUsers.get("groupID"), groupID);
    }
    static Specification<VeUsers> groupIDNotEqualTo(String groupID) {
        return (veUsers, cq, cb) -> cb.notEqual(veUsers.get("groupID"), groupID);
    }
    static Specification<VeUsers> labPhone1ExtensionIsNull() {
        return (veUsers, cq, cb) -> cb.isNull(veUsers.get("labPhone1Extension"));
    }
    static Specification<VeUsers> labPhone1ExtensionIsNotNull() {
        return (veUsers, cq, cb) -> cb.isNotNull(veUsers.get("labPhone1Extension"));
    }
    static Specification<VeUsers> labPhone1ExtensionEqualTo(String labPhone1Extension) {
        return (veUsers, cq, cb) -> cb.equal(veUsers.get("labPhone1Extension"), labPhone1Extension);
    }
    static Specification<VeUsers> labPhone1ExtensionNotEqualTo(String labPhone1Extension) {
        return (veUsers, cq, cb) -> cb.notEqual(veUsers.get("labPhone1Extension"), labPhone1Extension);
    }
    static Specification<VeUsers> lastNameIsNull() {
        return (veUsers, cq, cb) -> cb.isNull(veUsers.get("lastName"));
    }
    static Specification<VeUsers> lastNameIsNotNull() {
        return (veUsers, cq, cb) -> cb.isNotNull(veUsers.get("lastName"));
    }
    static Specification<VeUsers> lastNameEqualTo(String lastName) {
        return (veUsers, cq, cb) -> cb.equal(veUsers.get("lastName"), lastName);
    }
    static Specification<VeUsers> lastNameNotEqualTo(String lastName) {
        return (veUsers, cq, cb) -> cb.notEqual(veUsers.get("lastName"), lastName);
    }
    static Specification<VeUsers> lastUpdateDateIsNull() {
        return (veUsers, cq, cb) -> cb.isNull(veUsers.get("lastUpdateDate"));
    }
    static Specification<VeUsers> lastUpdateDateIsNotNull() {
        return (veUsers, cq, cb) -> cb.isNotNull(veUsers.get("lastUpdateDate"));
    }
    static Specification<VeUsers> lastUpdateDateEqualTo(Date lastUpdateDate) {
        return (veUsers, cq, cb) -> cb.equal(veUsers.get("lastUpdateDate"), lastUpdateDate);
    }
    static Specification<VeUsers> lastUpdateDateNotEqualTo(Date lastUpdateDate) {
        return (veUsers, cq, cb) -> cb.notEqual(veUsers.get("lastUpdateDate"), lastUpdateDate);
    }
    static Specification<VeUsers> lastUpdateDateBefore(Date lastUpdateDate) {
        return (veUsers, cq, cb) -> cb.lessThan(veUsers.get("lastUpdateDate"), lastUpdateDate);
    }
    static Specification<VeUsers> lastUpdateDateAfter(Date lastUpdateDate) {
        return (veUsers, cq, cb) -> cb.greaterThan(veUsers.get("lastUpdateDate"), lastUpdateDate);
    }
    static Specification<VeUsers> middleNameIsNull() {
        return (veUsers, cq, cb) -> cb.isNull(veUsers.get("middleName"));
    }
    static Specification<VeUsers> middleNameIsNotNull() {
        return (veUsers, cq, cb) -> cb.isNotNull(veUsers.get("middleName"));
    }
    static Specification<VeUsers> middleNameEqualTo(String middleName) {
        return (veUsers, cq, cb) -> cb.equal(veUsers.get("middleName"), middleName);
    }
    static Specification<VeUsers> middleNameNotEqualTo(String middleName) {
        return (veUsers, cq, cb) -> cb.notEqual(veUsers.get("middleName"), middleName);
    }
    static Specification<VeUsers> officeIsNull() {
        return (veUsers, cq, cb) -> cb.isNull(veUsers.get("office"));
    }
    static Specification<VeUsers> officeIsNotNull() {
        return (veUsers, cq, cb) -> cb.isNotNull(veUsers.get("office"));
    }
    static Specification<VeUsers> officeEqualTo(String office) {
        return (veUsers, cq, cb) -> cb.equal(veUsers.get("office"), office);
    }
    static Specification<VeUsers> officeNotEqualTo(String office) {
        return (veUsers, cq, cb) -> cb.notEqual(veUsers.get("office"), office);
    }
    static Specification<VeUsers> personIDIsNull() {
        return (veUsers, cq, cb) -> cb.isNull(veUsers.get("personID"));
    }
    static Specification<VeUsers> personIDIsNotNull() {
        return (veUsers, cq, cb) -> cb.isNotNull(veUsers.get("personID"));
    }
    static Specification<VeUsers> personIDEqualTo(String personID) {
        return (veUsers, cq, cb) -> cb.equal(veUsers.get("personID"), personID);
    }
    static Specification<VeUsers> personIDNotEqualTo(String personID) {
        return (veUsers, cq, cb) -> cb.notEqual(veUsers.get("personID"), personID);
    }
    static Specification<VeUsers> personStatusCodeIsNull() {
        return (veUsers, cq, cb) -> cb.isNull(veUsers.get("personStatusCode"));
    }
    static Specification<VeUsers> personStatusCodeIsNotNull() {
        return (veUsers, cq, cb) -> cb.isNotNull(veUsers.get("personStatusCode"));
    }
    static Specification<VeUsers> personStatusCodeEqualTo(String personStatusCode) {
        return (veUsers, cq, cb) -> cb.equal(veUsers.get("personStatusCode"), personStatusCode);
    }
    static Specification<VeUsers> personStatusCodeNotEqualTo(String personStatusCode) {
        return (veUsers, cq, cb) -> cb.notEqual(veUsers.get("personStatusCode"), personStatusCode);
    }
    static Specification<VeUsers> personSubstatusCodeIsNull() {
        return (veUsers, cq, cb) -> cb.isNull(veUsers.get("personSubstatusCode"));
    }
    static Specification<VeUsers> personSubstatusCodeIsNotNull() {
        return (veUsers, cq, cb) -> cb.isNotNull(veUsers.get("personSubstatusCode"));
    }
    static Specification<VeUsers> personSubstatusCodeEqualTo(String personSubstatusCode) {
        return (veUsers, cq, cb) -> cb.equal(veUsers.get("personSubstatusCode"), personSubstatusCode);
    }
    static Specification<VeUsers> personSubstatusCodeNotEqualTo(String personSubstatusCode) {
        return (veUsers, cq, cb) -> cb.notEqual(veUsers.get("personSubstatusCode"), personSubstatusCode);
    }
    static Specification<VeUsers> preferredNameIsNull() {
        return (veUsers, cq, cb) -> cb.isNull(veUsers.get("preferredName"));
    }
    static Specification<VeUsers> preferredNameIsNotNull() {
        return (veUsers, cq, cb) -> cb.isNotNull(veUsers.get("preferredName"));
    }
    static Specification<VeUsers> preferredNameEqualTo(String preferredName) {
        return (veUsers, cq, cb) -> cb.equal(veUsers.get("preferredName"), preferredName);
    }
    static Specification<VeUsers> preferredNameNotEqualTo(String preferredName) {
        return (veUsers, cq, cb) -> cb.notEqual(veUsers.get("preferredName"), preferredName);
    }
    static Specification<VeUsers> prefixNameIsNull() {
        return (veUsers, cq, cb) -> cb.isNull(veUsers.get("prefixName"));
    }
    static Specification<VeUsers> prefixNameIsNotNull() {
        return (veUsers, cq, cb) -> cb.isNotNull(veUsers.get("prefixName"));
    }
    static Specification<VeUsers> prefixNameEqualTo(String prefixName) {
        return (veUsers, cq, cb) -> cb.equal(veUsers.get("prefixName"), prefixName);
    }
    static Specification<VeUsers> prefixNameNotEqualTo(String prefixName) {
        return (veUsers, cq, cb) -> cb.notEqual(veUsers.get("prefixName"), prefixName);
    }
    static Specification<VeUsers> usernameIsNull() {
        return (veUsers, cq, cb) -> cb.isNull(veUsers.get("username"));
    }
    static Specification<VeUsers> usernameIsNotNull() {
        return (veUsers, cq, cb) -> cb.isNotNull(veUsers.get("username"));
    }
    static Specification<VeUsers> usernameEqualTo(String username) {
        return (veUsers, cq, cb) -> cb.equal(veUsers.get("username"), username);
    }
    static Specification<VeUsers> usernameNotEqualTo(String username) {
        return (veUsers, cq, cb) -> cb.notEqual(veUsers.get("username"), username);
    }

}
