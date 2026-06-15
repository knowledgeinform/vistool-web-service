package edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.denodo;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.VeShopResource;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VeShopResourceRepository extends JpaRepository<VeShopResource, Long>, JpaSpecificationExecutor<VeShopResource> {
    static Specification<VeShopResource> costCategoryIDIsNull() {
        return (veShopResource, cq, cb) -> cb.isNull(veShopResource.get("costCategoryID"));
    }
    static Specification<VeShopResource> costCategoryIDIsNotNull() {
        return (veShopResource, cq, cb) -> cb.isNotNull(veShopResource.get("costCategoryID"));
    }
    static Specification<VeShopResource> costCategoryIDEqualTo(String costCategoryID) {
        return (veShopResource, cq, cb) -> cb.equal(veShopResource.get("costCategoryID"), costCategoryID);
    }
    static Specification<VeShopResource> costCategoryIDNotEqualTo(String costCategoryID) {
        return (veShopResource, cq, cb) -> cb.notEqual(veShopResource.get("costCategoryID"), costCategoryID);
    }
    static Specification<VeShopResource> departmentIDIsNull() {
        return (veShopResource, cq, cb) -> cb.isNull(veShopResource.get("departmentID"));
    }
    static Specification<VeShopResource> departmentIDIsNotNull() {
        return (veShopResource, cq, cb) -> cb.isNotNull(veShopResource.get("departmentID"));
    }
    static Specification<VeShopResource> departmentIDEqualTo(String departmentID) {
        return (veShopResource, cq, cb) -> cb.equal(veShopResource.get("departmentID"), departmentID);
    }
    static Specification<VeShopResource> departmentIDNotEqualTo(String departmentID) {
        return (veShopResource, cq, cb) -> cb.notEqual(veShopResource.get("departmentID"), departmentID);
    }
    static Specification<VeShopResource> descriptionIsNull() {
        return (veShopResource, cq, cb) -> cb.isNull(veShopResource.get("description"));
    }
    static Specification<VeShopResource> descriptionIsNotNull() {
        return (veShopResource, cq, cb) -> cb.isNotNull(veShopResource.get("description"));
    }
    static Specification<VeShopResource> descriptionEqualTo(String description) {
        return (veShopResource, cq, cb) -> cb.equal(veShopResource.get("description"), description);
    }
    static Specification<VeShopResource> descriptionNotEqualTo(String description) {
        return (veShopResource, cq, cb) -> cb.notEqual(veShopResource.get("description"), description);
    }
    static Specification<VeShopResource> idIsNull() {
        return (veShopResource, cq, cb) -> cb.isNull(veShopResource.get("id"));
    }
    static Specification<VeShopResource> idIsNotNull() {
        return (veShopResource, cq, cb) -> cb.isNotNull(veShopResource.get("id"));
    }
    static Specification<VeShopResource> idEqualTo(String id) {
        return (veShopResource, cq, cb) -> cb.equal(veShopResource.get("id"), id);
    }
    static Specification<VeShopResource> idNotEqualTo(String id) {
        return (veShopResource, cq, cb) -> cb.notEqual(veShopResource.get("id"), id);
    }
    static Specification<VeShopResource> scheduleNormallyIsNull() {
        return (veShopResource, cq, cb) -> cb.isNull(veShopResource.get("scheduleNormally"));
    }
    static Specification<VeShopResource> scheduleNormallyIsNotNull() {
        return (veShopResource, cq, cb) -> cb.isNotNull(veShopResource.get("scheduleNormally"));
    }
    static Specification<VeShopResource> scheduleNormallyEqualTo(String scheduleNormally) {
        return (veShopResource, cq, cb) -> cb.equal(veShopResource.get("scheduleNormally"), scheduleNormally);
    }
    static Specification<VeShopResource> scheduleNormallyNotEqualTo(String scheduleNormally) {
        return (veShopResource, cq, cb) -> cb.notEqual(veShopResource.get("scheduleNormally"), scheduleNormally);
    }
    static Specification<VeShopResource> shift1CapacityIsNull() {
        return (veShopResource, cq, cb) -> cb.isNull(veShopResource.get("shift1Capacity"));
    }
    static Specification<VeShopResource> shift1CapacityIsNotNull() {
        return (veShopResource, cq, cb) -> cb.isNotNull(veShopResource.get("shift1Capacity"));
    }
    static Specification<VeShopResource> shift1CapacityEqualTo(Double shift1Capacity) {
        return (veShopResource, cq, cb) -> cb.equal(veShopResource.get("shift1Capacity"), shift1Capacity);
    }
    static Specification<VeShopResource> shift1CapacityNotEqualTo(Double shift1Capacity) {
        return (veShopResource, cq, cb) -> cb.notEqual(veShopResource.get("shift1Capacity"), shift1Capacity);
    }
    static Specification<VeShopResource> shift1CapacityLessThan(Double shift1Capacity) {
        return (veShopResource, cq, cb) -> cb.lessThan(veShopResource.get("shift1Capacity"), shift1Capacity);
    }
    static Specification<VeShopResource> shift1CapacityGreaterThan(Double shift1Capacity) {
        return (veShopResource, cq, cb) -> cb.greaterThan(veShopResource.get("shift1Capacity"), shift1Capacity);
    }
    static Specification<VeShopResource> statusIsNull() {
        return (veShopResource, cq, cb) -> cb.isNull(veShopResource.get("status"));
    }
    static Specification<VeShopResource> statusIsNotNull() {
        return (veShopResource, cq, cb) -> cb.isNotNull(veShopResource.get("status"));
    }
    static Specification<VeShopResource> statusEqualTo(String status) {
        return (veShopResource, cq, cb) -> cb.equal(veShopResource.get("status"), status);
    }
    static Specification<VeShopResource> statusNotEqualTo(String status) {
        return (veShopResource, cq, cb) -> cb.notEqual(veShopResource.get("status"), status);
    }
    static Specification<VeShopResource> statusRankIsNull() {
        return (veShopResource, cq, cb) -> cb.isNull(veShopResource.get("statusRank"));
    }
    static Specification<VeShopResource> statusRankIsNotNull() {
        return (veShopResource, cq, cb) -> cb.isNotNull(veShopResource.get("statusRank"));
    }
    static Specification<VeShopResource> statusRankEqualTo(Double statusRank) {
        return (veShopResource, cq, cb) -> cb.equal(veShopResource.get("statusRank"), statusRank);
    }
    static Specification<VeShopResource> statusRankNotEqualTo(Double statusRank) {
        return (veShopResource, cq, cb) -> cb.notEqual(veShopResource.get("statusRank"), statusRank);
    }
    static Specification<VeShopResource> statusRankLessThan(Double statusRank) {
        return (veShopResource, cq, cb) -> cb.lessThan(veShopResource.get("statusRank"), statusRank);
    }
    static Specification<VeShopResource> statusRankGreaterThan(Double statusRank) {
        return (veShopResource, cq, cb) -> cb.greaterThan(veShopResource.get("statusRank"), statusRank);
    }
    static Specification<VeShopResource> typeIsNull() {
        return (veShopResource, cq, cb) -> cb.isNull(veShopResource.get("type"));
    }
    static Specification<VeShopResource> typeIsNotNull() {
        return (veShopResource, cq, cb) -> cb.isNotNull(veShopResource.get("type"));
    }
    static Specification<VeShopResource> typeEqualTo(String type) {
        return (veShopResource, cq, cb) -> cb.equal(veShopResource.get("type"), type);
    }
    static Specification<VeShopResource> typeNotEqualTo(String type) {
        return (veShopResource, cq, cb) -> cb.notEqual(veShopResource.get("type"), type);
    }
    static Specification<VeShopResource> udfLayoutIDIsNull() {
        return (veShopResource, cq, cb) -> cb.isNull(veShopResource.get("udfLayoutID"));
    }
    static Specification<VeShopResource> udfLayoutIDIsNotNull() {
        return (veShopResource, cq, cb) -> cb.isNotNull(veShopResource.get("udfLayoutID"));
    }
    static Specification<VeShopResource> udfLayoutIDEqualTo(String udfLayoutID) {
        return (veShopResource, cq, cb) -> cb.equal(veShopResource.get("udfLayoutID"), udfLayoutID);
    }
    static Specification<VeShopResource> udfLayoutIDNotEqualTo(String udfLayoutID) {
        return (veShopResource, cq, cb) -> cb.notEqual(veShopResource.get("udfLayoutID"), udfLayoutID);
    }
    static Specification<VeShopResource> userDefinedField1IsNull() {
        return (veShopResource, cq, cb) -> cb.isNull(veShopResource.get("userDefinedField1"));
    }
    static Specification<VeShopResource> userDefinedField1IsNotNull() {
        return (veShopResource, cq, cb) -> cb.isNotNull(veShopResource.get("userDefinedField1"));
    }
    static Specification<VeShopResource> userDefinedField1EqualTo(String userDefinedField1) {
        return (veShopResource, cq, cb) -> cb.equal(veShopResource.get("userDefinedField1"), userDefinedField1);
    }
    static Specification<VeShopResource> userDefinedField1NotEqualTo(String userDefinedField1) {
        return (veShopResource, cq, cb) -> cb.notEqual(veShopResource.get("userDefinedField1"), userDefinedField1);
    }
    static Specification<VeShopResource> userDefinedField10IsNull() {
        return (veShopResource, cq, cb) -> cb.isNull(veShopResource.get("userDefinedField10"));
    }
    static Specification<VeShopResource> userDefinedField10IsNotNull() {
        return (veShopResource, cq, cb) -> cb.isNotNull(veShopResource.get("userDefinedField10"));
    }
    static Specification<VeShopResource> userDefinedField10EqualTo(String userDefinedField10) {
        return (veShopResource, cq, cb) -> cb.equal(veShopResource.get("userDefinedField10"), userDefinedField10);
    }
    static Specification<VeShopResource> userDefinedField10NotEqualTo(String userDefinedField10) {
        return (veShopResource, cq, cb) -> cb.notEqual(veShopResource.get("userDefinedField10"), userDefinedField10);
    }
    static Specification<VeShopResource> userDefinedField2IsNull() {
        return (veShopResource, cq, cb) -> cb.isNull(veShopResource.get("userDefinedField2"));
    }
    static Specification<VeShopResource> userDefinedField2IsNotNull() {
        return (veShopResource, cq, cb) -> cb.isNotNull(veShopResource.get("userDefinedField2"));
    }
    static Specification<VeShopResource> userDefinedField2EqualTo(String userDefinedField2) {
        return (veShopResource, cq, cb) -> cb.equal(veShopResource.get("userDefinedField2"), userDefinedField2);
    }
    static Specification<VeShopResource> userDefinedField2NotEqualTo(String userDefinedField2) {
        return (veShopResource, cq, cb) -> cb.notEqual(veShopResource.get("userDefinedField2"), userDefinedField2);
    }
    static Specification<VeShopResource> userDefinedField3IsNull() {
        return (veShopResource, cq, cb) -> cb.isNull(veShopResource.get("userDefinedField3"));
    }
    static Specification<VeShopResource> userDefinedField3IsNotNull() {
        return (veShopResource, cq, cb) -> cb.isNotNull(veShopResource.get("userDefinedField3"));
    }
    static Specification<VeShopResource> userDefinedField3EqualTo(String userDefinedField3) {
        return (veShopResource, cq, cb) -> cb.equal(veShopResource.get("userDefinedField3"), userDefinedField3);
    }
    static Specification<VeShopResource> userDefinedField3NotEqualTo(String userDefinedField3) {
        return (veShopResource, cq, cb) -> cb.notEqual(veShopResource.get("userDefinedField3"), userDefinedField3);
    }
    static Specification<VeShopResource> userDefinedField4IsNull() {
        return (veShopResource, cq, cb) -> cb.isNull(veShopResource.get("userDefinedField4"));
    }
    static Specification<VeShopResource> userDefinedField4IsNotNull() {
        return (veShopResource, cq, cb) -> cb.isNotNull(veShopResource.get("userDefinedField4"));
    }
    static Specification<VeShopResource> userDefinedField4EqualTo(String userDefinedField4) {
        return (veShopResource, cq, cb) -> cb.equal(veShopResource.get("userDefinedField4"), userDefinedField4);
    }
    static Specification<VeShopResource> userDefinedField4NotEqualTo(String userDefinedField4) {
        return (veShopResource, cq, cb) -> cb.notEqual(veShopResource.get("userDefinedField4"), userDefinedField4);
    }
    static Specification<VeShopResource> userDefinedField5IsNull() {
        return (veShopResource, cq, cb) -> cb.isNull(veShopResource.get("userDefinedField5"));
    }
    static Specification<VeShopResource> userDefinedField5IsNotNull() {
        return (veShopResource, cq, cb) -> cb.isNotNull(veShopResource.get("userDefinedField5"));
    }
    static Specification<VeShopResource> userDefinedField5EqualTo(String userDefinedField5) {
        return (veShopResource, cq, cb) -> cb.equal(veShopResource.get("userDefinedField5"), userDefinedField5);
    }
    static Specification<VeShopResource> userDefinedField5NotEqualTo(String userDefinedField5) {
        return (veShopResource, cq, cb) -> cb.notEqual(veShopResource.get("userDefinedField5"), userDefinedField5);
    }
    static Specification<VeShopResource> userDefinedField6IsNull() {
        return (veShopResource, cq, cb) -> cb.isNull(veShopResource.get("userDefinedField6"));
    }
    static Specification<VeShopResource> userDefinedField6IsNotNull() {
        return (veShopResource, cq, cb) -> cb.isNotNull(veShopResource.get("userDefinedField6"));
    }
    static Specification<VeShopResource> userDefinedField6EqualTo(String userDefinedField6) {
        return (veShopResource, cq, cb) -> cb.equal(veShopResource.get("userDefinedField6"), userDefinedField6);
    }
    static Specification<VeShopResource> userDefinedField6NotEqualTo(String userDefinedField6) {
        return (veShopResource, cq, cb) -> cb.notEqual(veShopResource.get("userDefinedField6"), userDefinedField6);
    }
    static Specification<VeShopResource> userDefinedField7IsNull() {
        return (veShopResource, cq, cb) -> cb.isNull(veShopResource.get("userDefinedField7"));
    }
    static Specification<VeShopResource> userDefinedField7IsNotNull() {
        return (veShopResource, cq, cb) -> cb.isNotNull(veShopResource.get("userDefinedField7"));
    }
    static Specification<VeShopResource> userDefinedField7EqualTo(String userDefinedField7) {
        return (veShopResource, cq, cb) -> cb.equal(veShopResource.get("userDefinedField7"), userDefinedField7);
    }
    static Specification<VeShopResource> userDefinedField7NotEqualTo(String userDefinedField7) {
        return (veShopResource, cq, cb) -> cb.notEqual(veShopResource.get("userDefinedField7"), userDefinedField7);
    }
    static Specification<VeShopResource> userDefinedField8IsNull() {
        return (veShopResource, cq, cb) -> cb.isNull(veShopResource.get("userDefinedField8"));
    }
    static Specification<VeShopResource> userDefinedField8IsNotNull() {
        return (veShopResource, cq, cb) -> cb.isNotNull(veShopResource.get("userDefinedField8"));
    }
    static Specification<VeShopResource> userDefinedField8EqualTo(String userDefinedField8) {
        return (veShopResource, cq, cb) -> cb.equal(veShopResource.get("userDefinedField8"), userDefinedField8);
    }
    static Specification<VeShopResource> userDefinedField8NotEqualTo(String userDefinedField8) {
        return (veShopResource, cq, cb) -> cb.notEqual(veShopResource.get("userDefinedField8"), userDefinedField8);
    }
    static Specification<VeShopResource> userDefinedField9IsNull() {
        return (veShopResource, cq, cb) -> cb.isNull(veShopResource.get("userDefinedField9"));
    }
    static Specification<VeShopResource> userDefinedField9IsNotNull() {
        return (veShopResource, cq, cb) -> cb.isNotNull(veShopResource.get("userDefinedField9"));
    }
    static Specification<VeShopResource> userDefinedField9EqualTo(String userDefinedField9) {
        return (veShopResource, cq, cb) -> cb.equal(veShopResource.get("userDefinedField9"), userDefinedField9);
    }
    static Specification<VeShopResource> userDefinedField9NotEqualTo(String userDefinedField9) {
        return (veShopResource, cq, cb) -> cb.notEqual(veShopResource.get("userDefinedField9"), userDefinedField9);
    }
    static Specification<VeShopResource> wbsResourceTypeIsNull() {
        return (veShopResource, cq, cb) -> cb.isNull(veShopResource.get("wbsResourceType"));
    }
    static Specification<VeShopResource> wbsResourceTypeIsNotNull() {
        return (veShopResource, cq, cb) -> cb.isNotNull(veShopResource.get("wbsResourceType"));
    }
    static Specification<VeShopResource> wbsResourceTypeEqualTo(String wbsResourceType) {
        return (veShopResource, cq, cb) -> cb.equal(veShopResource.get("wbsResourceType"), wbsResourceType);
    }
    static Specification<VeShopResource> wbsResourceTypeNotEqualTo(String wbsResourceType) {
        return (veShopResource, cq, cb) -> cb.notEqual(veShopResource.get("wbsResourceType"), wbsResourceType);
    }
}
