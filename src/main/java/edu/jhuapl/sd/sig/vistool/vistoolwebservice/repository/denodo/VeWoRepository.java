package edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.denodo;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.VeWo;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Date;

public interface VeWoRepository extends JpaRepository<VeWo, Long>, JpaSpecificationExecutor<VeWo> {
    static Specification<VeWo> baseIDIsNull() {
        return (veWo, cq, cb) -> cb.isNull(veWo.get("baseID"));
    }
    static Specification<VeWo> baseIDIsNotNull() {
        return (veWo, cq, cb) -> cb.isNotNull(veWo.get("baseID"));
    }
    static Specification<VeWo> baseIDEqualTo(String baseID) {
        return (veWo, cq, cb) -> cb.equal(veWo.get("baseID"), baseID);
    }
    static Specification<VeWo> baseIDNotEqualTo(String baseID) {
        return (veWo, cq, cb) -> cb.notEqual(veWo.get("baseID"), baseID);
    }
    static Specification<VeWo> chargeGroupIsNull() {
        return (veWo, cq, cb) -> cb.isNull(veWo.get("chargeGroup"));
    }
    static Specification<VeWo> chargeGroupIsNotNull() {
        return (veWo, cq, cb) -> cb.isNotNull(veWo.get("chargeGroup"));
    }
    static Specification<VeWo> chargeGroupEqualTo(String chargeGroup) {
        return (veWo, cq, cb) -> cb.equal(veWo.get("chargeGroup"), chargeGroup);
    }
    static Specification<VeWo> chargeGroupNotEqualTo(String chargeGroup) {
        return (veWo, cq, cb) -> cb.notEqual(veWo.get("chargeGroup"), chargeGroup);
    }
    static Specification<VeWo> createDateIsNull() {
        return (veWo, cq, cb) -> cb.isNull(veWo.get("createDate"));
    }
    static Specification<VeWo> createDateIsNotNull() {
        return (veWo, cq, cb) -> cb.isNotNull(veWo.get("createDate"));
    }
    static Specification<VeWo> createDateEqualTo(Date createDate) {
        return (veWo, cq, cb) -> cb.equal(veWo.get("createDate"), createDate);
    }
    static Specification<VeWo> createDateNotEqualTo(Date createDate) {
        return (veWo, cq, cb) -> cb.notEqual(veWo.get("createDate"), createDate);
    }
    static Specification<VeWo> createDateBefore(Date createDate) {
        return (veWo, cq, cb) -> cb.lessThan(veWo.get("createDate"), createDate);
    }
    static Specification<VeWo> createDateAfter(Date createDate) {
        return (veWo, cq, cb) -> cb.greaterThan(veWo.get("createDate"), createDate);
    }
    static Specification<VeWo> customerIsNull() {
        return (veWo, cq, cb) -> cb.isNull(veWo.get("customer"));
    }
    static Specification<VeWo> customerIsNotNull() {
        return (veWo, cq, cb) -> cb.isNotNull(veWo.get("customer"));
    }
    static Specification<VeWo> customerEqualTo(String customer) {
        return (veWo, cq, cb) -> cb.equal(veWo.get("customer"), customer);
    }
    static Specification<VeWo> customerNotEqualTo(String customer) {
        return (veWo, cq, cb) -> cb.notEqual(veWo.get("customer"), customer);
    }
    static Specification<VeWo> descriptionIsNull() {
        return (veWo, cq, cb) -> cb.isNull(veWo.get("description"));
    }
    static Specification<VeWo> descriptionIsNotNull() {
        return (veWo, cq, cb) -> cb.isNotNull(veWo.get("description"));
    }
    static Specification<VeWo> descriptionEqualTo(String description) {
        return (veWo, cq, cb) -> cb.equal(veWo.get("description"), description);
    }
    static Specification<VeWo> descriptionNotEqualTo(String description) {
        return (veWo, cq, cb) -> cb.notEqual(veWo.get("description"), description);
    }
    static Specification<VeWo> hardwareLevelIsNull() {
        return (veWo, cq, cb) -> cb.isNull(veWo.get("hardwareLevel"));
    }
    static Specification<VeWo> hardwareLevelIsNotNull() {
        return (veWo, cq, cb) -> cb.isNotNull(veWo.get("hardwareLevel"));
    }
    static Specification<VeWo> hardwareLevelEqualTo(String hardwareLevel) {
        return (veWo, cq, cb) -> cb.equal(veWo.get("hardwareLevel"), hardwareLevel);
    }
    static Specification<VeWo> hardwareLevelNotEqualTo(String hardwareLevel) {
        return (veWo, cq, cb) -> cb.notEqual(veWo.get("hardwareLevel"), hardwareLevel);
    }
    static Specification<VeWo> lotIDIsNull() {
        return (veWo, cq, cb) -> cb.isNull(veWo.get("lotID"));
    }
    static Specification<VeWo> lotIDIsNotNull() {
        return (veWo, cq, cb) -> cb.isNotNull(veWo.get("lotID"));
    }
    static Specification<VeWo> lotIDEqualTo(String lotID) {
        return (veWo, cq, cb) -> cb.equal(veWo.get("lotID"), lotID);
    }
    static Specification<VeWo> lotIDNotEqualTo(String lotID) {
        return (veWo, cq, cb) -> cb.notEqual(veWo.get("lotID"), lotID);
    }
    static Specification<VeWo> originalWorkOrderIsNull() {
        return (veWo, cq, cb) -> cb.isNull(veWo.get("originalWorkOrder"));
    }
    static Specification<VeWo> originalWorkOrderIsNotNull() {
        return (veWo, cq, cb) -> cb.isNotNull(veWo.get("originalWorkOrder"));
    }
    static Specification<VeWo> originalWorkOrderEqualTo(String originalWorkOrder) {
        return (veWo, cq, cb) -> cb.equal(veWo.get("originalWorkOrder"), originalWorkOrder);
    }
    static Specification<VeWo> originalWorkOrderNotEqualTo(String originalWorkOrder) {
        return (veWo, cq, cb) -> cb.notEqual(veWo.get("originalWorkOrder"), originalWorkOrder);
    }
    static Specification<VeWo> partIDIsNull() {
        return (veWo, cq, cb) -> cb.isNull(veWo.get("partID"));
    }
    static Specification<VeWo> partIDIsNotNull() {
        return (veWo, cq, cb) -> cb.isNotNull(veWo.get("partID"));
    }
    static Specification<VeWo> partIDEqualTo(String partID) {
        return (veWo, cq, cb) -> cb.equal(veWo.get("partID"), partID);
    }
    static Specification<VeWo> partIDNotEqualTo(String partID) {
        return (veWo, cq, cb) -> cb.notEqual(veWo.get("partID"), partID);
    }
    static Specification<VeWo> plannerIsNull() {
        return (veWo, cq, cb) -> cb.isNull(veWo.get("planner"));
    }
    static Specification<VeWo> plannerIsNotNull() {
        return (veWo, cq, cb) -> cb.isNotNull(veWo.get("planner"));
    }
    static Specification<VeWo> plannerEqualTo(String planner) {
        return (veWo, cq, cb) -> cb.equal(veWo.get("planner"), planner);
    }
    static Specification<VeWo> plannerNotEqualTo(String planner) {
        return (veWo, cq, cb) -> cb.notEqual(veWo.get("planner"), planner);
    }
    static Specification<VeWo> serialNumberIsNull() {
        return (veWo, cq, cb) -> cb.isNull(veWo.get("serialNumber"));
    }
    static Specification<VeWo> serialNumberIsNotNull() {
        return (veWo, cq, cb) -> cb.isNotNull(veWo.get("serialNumber"));
    }
    static Specification<VeWo> serialNumberEqualTo(String serialNumber) {
        return (veWo, cq, cb) -> cb.equal(veWo.get("serialNumber"), serialNumber);
    }
    static Specification<VeWo> serialNumberNotEqualTo(String serialNumber) {
        return (veWo, cq, cb) -> cb.notEqual(veWo.get("serialNumber"), serialNumber);
    }
    static Specification<VeWo> splitIDIsNull() {
        return (veWo, cq, cb) -> cb.isNull(veWo.get("splitID"));
    }
    static Specification<VeWo> splitIDIsNotNull() {
        return (veWo, cq, cb) -> cb.isNotNull(veWo.get("splitID"));
    }
    static Specification<VeWo> splitIDEqualTo(String splitID) {
        return (veWo, cq, cb) -> cb.equal(veWo.get("splitID"), splitID);
    }
    static Specification<VeWo> splitIDNotEqualTo(String splitID) {
        return (veWo, cq, cb) -> cb.notEqual(veWo.get("splitID"), splitID);
    }
    static Specification<VeWo> statusIsNull() {
        return (veWo, cq, cb) -> cb.isNull(veWo.get("status"));
    }
    static Specification<VeWo> statusIsNotNull() {
        return (veWo, cq, cb) -> cb.isNotNull(veWo.get("status"));
    }
    static Specification<VeWo> statusEqualTo(String status) {
        return (veWo, cq, cb) -> cb.equal(veWo.get("status"), status);
    }
    static Specification<VeWo> statusNotEqualTo(String status) {
        return (veWo, cq, cb) -> cb.notEqual(veWo.get("status"), status);
    }
    static Specification<VeWo> subIDIsNull() {
        return (veWo, cq, cb) -> cb.isNull(veWo.get("subID"));
    }
    static Specification<VeWo> subIDIsNotNull() {
        return (veWo, cq, cb) -> cb.isNotNull(veWo.get("subID"));
    }
    static Specification<VeWo> subIDEqualTo(String subID) {
        return (veWo, cq, cb) -> cb.equal(veWo.get("subID"), subID);
    }
    static Specification<VeWo> subIDNotEqualTo(String subID) {
        return (veWo, cq, cb) -> cb.notEqual(veWo.get("subID"), subID);
    }
    static Specification<VeWo> timestampIsNull() {
        return (veWo, cq, cb) -> cb.isNull(veWo.get("timestamp"));
    }
    static Specification<VeWo> timestampIsNotNull() {
        return (veWo, cq, cb) -> cb.isNotNull(veWo.get("timestamp"));
    }
    static Specification<VeWo> timestampEqualTo(String timestamp) {
        return (veWo, cq, cb) -> cb.equal(veWo.get("timestamp"), timestamp);
    }
    static Specification<VeWo> timestampNotEqualTo(String timestamp) {
        return (veWo, cq, cb) -> cb.notEqual(veWo.get("timestamp"), timestamp);
    }
    static Specification<VeWo> workAuthorizationIsNull() {
        return (veWo, cq, cb) -> cb.isNull(veWo.get("workAuthorization"));
    }
    static Specification<VeWo> workAuthorizationIsNotNull() {
        return (veWo, cq, cb) -> cb.isNotNull(veWo.get("workAuthorization"));
    }
    static Specification<VeWo> workAuthorizationEqualTo(String workAuthorization) {
        return (veWo, cq, cb) -> cb.equal(veWo.get("workAuthorization"), workAuthorization);
    }
    static Specification<VeWo> workAuthorizationNotEqualTo(String workAuthorization) {
        return (veWo, cq, cb) -> cb.notEqual(veWo.get("workAuthorization"), workAuthorization);
    }
    static Specification<VeWo> wbsCodeIsNull() {
        return (veWo, cq, cb) -> cb.isNull(veWo.get("wbsCode"));
    }
    static Specification<VeWo> wbsCodeIsNotNull() {
        return (veWo, cq, cb) -> cb.isNotNull(veWo.get("wbsCode"));
    }
    static Specification<VeWo> wbsCodeEqualTo(String wbsCode) {
        return (veWo, cq, cb) -> cb.equal(veWo.get("wbsCode"), wbsCode);
    }
    static Specification<VeWo> wbsCodeNotEqualTo(String wbsCode) {
        return (veWo, cq, cb) -> cb.notEqual(veWo.get("wbsCode"), wbsCode);
    }
    static Specification<VeWo> wbsProjectIsNull() {
        return (veWo, cq, cb) -> cb.isNull(veWo.get("wbsProject"));
    }
    static Specification<VeWo> wbsProjectIsNotNull() {
        return (veWo, cq, cb) -> cb.isNotNull(veWo.get("wbsProject"));
    }
    static Specification<VeWo> wbsProjectEqualTo(String wbsProject) {
        return (veWo, cq, cb) -> cb.equal(veWo.get("wbsProject"), wbsProject);
    }
    static Specification<VeWo> wbsProjectNotEqualTo(String wbsProject) {
        return (veWo, cq, cb) -> cb.notEqual(veWo.get("wbsProject"), wbsProject);
    }
    static Specification<VeWo> workOrderAssigneeIsNull() {
        return (veWo, cq, cb) -> cb.isNull(veWo.get("workOrderAssignee"));
    }
    static Specification<VeWo> workOrderAssigneeIsNotNull() {
        return (veWo, cq, cb) -> cb.isNotNull(veWo.get("workOrderAssignee"));
    }
    static Specification<VeWo> workOrderAssigneeEqualTo(String workOrderAssignee) {
        return (veWo, cq, cb) -> cb.equal(veWo.get("workOrderAssignee"), workOrderAssignee);
    }
    static Specification<VeWo> workOrderAssigneeNotEqualTo(String workOrderAssignee) {
        return (veWo, cq, cb) -> cb.notEqual(veWo.get("workOrderAssignee"), workOrderAssignee);
    }
    static Specification<VeWo> workOrderNumberIsNull() {
        return (veWo, cq, cb) -> cb.isNull(veWo.get("workOrderNumber"));
    }
    static Specification<VeWo> workOrderNumberIsNotNull() {
        return (veWo, cq, cb) -> cb.isNotNull(veWo.get("workOrderNumber"));
    }
    static Specification<VeWo> workOrderNumberEqualTo(String workOrderNumber) {
        return (veWo, cq, cb) -> cb.equal(veWo.get("workOrderNumber"), workOrderNumber);
    }
    static Specification<VeWo> workOrderNumberNotEqualTo(String workOrderNumber) {
        return (veWo, cq, cb) -> cb.notEqual(veWo.get("workOrderNumber"), workOrderNumber);
    }
}
