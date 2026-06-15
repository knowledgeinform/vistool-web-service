package edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.denodo;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.VeMasterWo;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Date;

public interface VeMasterWoRepository extends JpaRepository<VeMasterWo, Long>, JpaSpecificationExecutor<VeMasterWo>{	static Specification<VeMasterWo> baseIDIsNull() {
    return (veMasterWo, cq, cb) -> cb.isNull(veMasterWo.get("baseID"));
}
    static Specification<VeMasterWo> baseIDIsNotNull() {
        return (veMasterWo, cq, cb) -> cb.isNotNull(veMasterWo.get("baseID"));
    }
    static Specification<VeMasterWo> baseIDEqualTo(String baseID) {
        return (veMasterWo, cq, cb) -> cb.equal(veMasterWo.get("baseID"), baseID);
    }
    static Specification<VeMasterWo> baseIDNotEqualTo(String baseID) {
        return (veMasterWo, cq, cb) -> cb.notEqual(veMasterWo.get("baseID"), baseID);
    }
    static Specification<VeMasterWo> chargeGroupIsNull() {
        return (veMasterWo, cq, cb) -> cb.isNull(veMasterWo.get("chargeGroup"));
    }
    static Specification<VeMasterWo> chargeGroupIsNotNull() {
        return (veMasterWo, cq, cb) -> cb.isNotNull(veMasterWo.get("chargeGroup"));
    }
    static Specification<VeMasterWo> chargeGroupEqualTo(String chargeGroup) {
        return (veMasterWo, cq, cb) -> cb.equal(veMasterWo.get("chargeGroup"), chargeGroup);
    }
    static Specification<VeMasterWo> chargeGroupNotEqualTo(String chargeGroup) {
        return (veMasterWo, cq, cb) -> cb.notEqual(veMasterWo.get("chargeGroup"), chargeGroup);
    }
    static Specification<VeMasterWo> createDateIsNull() {
        return (veMasterWo, cq, cb) -> cb.isNull(veMasterWo.get("createDate"));
    }
    static Specification<VeMasterWo> createDateIsNotNull() {
        return (veMasterWo, cq, cb) -> cb.isNotNull(veMasterWo.get("createDate"));
    }
    static Specification<VeMasterWo> createDateEqualTo(Date createDate) {
        return (veMasterWo, cq, cb) -> cb.equal(veMasterWo.get("createDate"), createDate);
    }
    static Specification<VeMasterWo> createDateNotEqualTo(Date createDate) {
        return (veMasterWo, cq, cb) -> cb.notEqual(veMasterWo.get("createDate"), createDate);
    }
    static Specification<VeMasterWo> createDateBefore(Date createDate) {
        return (veMasterWo, cq, cb) -> cb.lessThan(veMasterWo.get("createDate"), createDate);
    }
    static Specification<VeMasterWo> createDateAfter(Date createDate) {
        return (veMasterWo, cq, cb) -> cb.greaterThan(veMasterWo.get("createDate"), createDate);
    }
    static Specification<VeMasterWo> customerIsNull() {
        return (veMasterWo, cq, cb) -> cb.isNull(veMasterWo.get("customer"));
    }
    static Specification<VeMasterWo> customerIsNotNull() {
        return (veMasterWo, cq, cb) -> cb.isNotNull(veMasterWo.get("customer"));
    }
    static Specification<VeMasterWo> customerEqualTo(String customer) {
        return (veMasterWo, cq, cb) -> cb.equal(veMasterWo.get("customer"), customer);
    }
    static Specification<VeMasterWo> customerNotEqualTo(String customer) {
        return (veMasterWo, cq, cb) -> cb.notEqual(veMasterWo.get("customer"), customer);
    }
    static Specification<VeMasterWo> descriptionIsNull() {
        return (veMasterWo, cq, cb) -> cb.isNull(veMasterWo.get("description"));
    }
    static Specification<VeMasterWo> descriptionIsNotNull() {
        return (veMasterWo, cq, cb) -> cb.isNotNull(veMasterWo.get("description"));
    }
    static Specification<VeMasterWo> descriptionEqualTo(String description) {
        return (veMasterWo, cq, cb) -> cb.equal(veMasterWo.get("description"), description);
    }
    static Specification<VeMasterWo> descriptionNotEqualTo(String description) {
        return (veMasterWo, cq, cb) -> cb.notEqual(veMasterWo.get("description"), description);
    }
    static Specification<VeMasterWo> hardwareLevelIsNull() {
        return (veMasterWo, cq, cb) -> cb.isNull(veMasterWo.get("hardwareLevel"));
    }
    static Specification<VeMasterWo> hardwareLevelIsNotNull() {
        return (veMasterWo, cq, cb) -> cb.isNotNull(veMasterWo.get("hardwareLevel"));
    }
    static Specification<VeMasterWo> hardwareLevelEqualTo(String hardwareLevel) {
        return (veMasterWo, cq, cb) -> cb.equal(veMasterWo.get("hardwareLevel"), hardwareLevel);
    }
    static Specification<VeMasterWo> hardwareLevelNotEqualTo(String hardwareLevel) {
        return (veMasterWo, cq, cb) -> cb.notEqual(veMasterWo.get("hardwareLevel"), hardwareLevel);
    }
    static Specification<VeMasterWo> lotIDIsNull() {
        return (veMasterWo, cq, cb) -> cb.isNull(veMasterWo.get("lotID"));
    }
    static Specification<VeMasterWo> lotIDIsNotNull() {
        return (veMasterWo, cq, cb) -> cb.isNotNull(veMasterWo.get("lotID"));
    }
    static Specification<VeMasterWo> lotIDEqualTo(String lotID) {
        return (veMasterWo, cq, cb) -> cb.equal(veMasterWo.get("lotID"), lotID);
    }
    static Specification<VeMasterWo> lotIDNotEqualTo(String lotID) {
        return (veMasterWo, cq, cb) -> cb.notEqual(veMasterWo.get("lotID"), lotID);
    }
    static Specification<VeMasterWo> originalWorkOrderIsNull() {
        return (veMasterWo, cq, cb) -> cb.isNull(veMasterWo.get("originalWorkOrder"));
    }
    static Specification<VeMasterWo> originalWorkOrderIsNotNull() {
        return (veMasterWo, cq, cb) -> cb.isNotNull(veMasterWo.get("originalWorkOrder"));
    }
    static Specification<VeMasterWo> originalWorkOrderEqualTo(String originalWorkOrder) {
        return (veMasterWo, cq, cb) -> cb.equal(veMasterWo.get("originalWorkOrder"), originalWorkOrder);
    }
    static Specification<VeMasterWo> originalWorkOrderNotEqualTo(String originalWorkOrder) {
        return (veMasterWo, cq, cb) -> cb.notEqual(veMasterWo.get("originalWorkOrder"), originalWorkOrder);
    }
    static Specification<VeMasterWo> partIDIsNull() {
        return (veMasterWo, cq, cb) -> cb.isNull(veMasterWo.get("partID"));
    }
    static Specification<VeMasterWo> partIDIsNotNull() {
        return (veMasterWo, cq, cb) -> cb.isNotNull(veMasterWo.get("partID"));
    }
    static Specification<VeMasterWo> partIDEqualTo(String partID) {
        return (veMasterWo, cq, cb) -> cb.equal(veMasterWo.get("partID"), partID);
    }
    static Specification<VeMasterWo> partIDNotEqualTo(String partID) {
        return (veMasterWo, cq, cb) -> cb.notEqual(veMasterWo.get("partID"), partID);
    }
    static Specification<VeMasterWo> plannerIsNull() {
        return (veMasterWo, cq, cb) -> cb.isNull(veMasterWo.get("planner"));
    }
    static Specification<VeMasterWo> plannerIsNotNull() {
        return (veMasterWo, cq, cb) -> cb.isNotNull(veMasterWo.get("planner"));
    }
    static Specification<VeMasterWo> plannerEqualTo(String planner) {
        return (veMasterWo, cq, cb) -> cb.equal(veMasterWo.get("planner"), planner);
    }
    static Specification<VeMasterWo> plannerNotEqualTo(String planner) {
        return (veMasterWo, cq, cb) -> cb.notEqual(veMasterWo.get("planner"), planner);
    }
    static Specification<VeMasterWo> serialNumIsNull() {
        return (veMasterWo, cq, cb) -> cb.isNull(veMasterWo.get("serialNum"));
    }
    static Specification<VeMasterWo> serialNumIsNotNull() {
        return (veMasterWo, cq, cb) -> cb.isNotNull(veMasterWo.get("serialNum"));
    }
    static Specification<VeMasterWo> serialNumEqualTo(String serialNum) {
        return (veMasterWo, cq, cb) -> cb.equal(veMasterWo.get("serialNum"), serialNum);
    }
    static Specification<VeMasterWo> serialNumNotEqualTo(String serialNum) {
        return (veMasterWo, cq, cb) -> cb.notEqual(veMasterWo.get("serialNum"), serialNum);
    }
    static Specification<VeMasterWo> splitIDIsNull() {
        return (veMasterWo, cq, cb) -> cb.isNull(veMasterWo.get("splitID"));
    }
    static Specification<VeMasterWo> splitIDIsNotNull() {
        return (veMasterWo, cq, cb) -> cb.isNotNull(veMasterWo.get("splitID"));
    }
    static Specification<VeMasterWo> splitIDEqualTo(String splitID) {
        return (veMasterWo, cq, cb) -> cb.equal(veMasterWo.get("splitID"), splitID);
    }
    static Specification<VeMasterWo> splitIDNotEqualTo(String splitID) {
        return (veMasterWo, cq, cb) -> cb.notEqual(veMasterWo.get("splitID"), splitID);
    }
    static Specification<VeMasterWo> statusIsNull() {
        return (veMasterWo, cq, cb) -> cb.isNull(veMasterWo.get("status"));
    }
    static Specification<VeMasterWo> statusIsNotNull() {
        return (veMasterWo, cq, cb) -> cb.isNotNull(veMasterWo.get("status"));
    }
    static Specification<VeMasterWo> statusEqualTo(String status) {
        return (veMasterWo, cq, cb) -> cb.equal(veMasterWo.get("status"), status);
    }
    static Specification<VeMasterWo> statusNotEqualTo(String status) {
        return (veMasterWo, cq, cb) -> cb.notEqual(veMasterWo.get("status"), status);
    }
    static Specification<VeMasterWo> subIDIsNull() {
        return (veMasterWo, cq, cb) -> cb.isNull(veMasterWo.get("subID"));
    }
    static Specification<VeMasterWo> subIDIsNotNull() {
        return (veMasterWo, cq, cb) -> cb.isNotNull(veMasterWo.get("subID"));
    }
    static Specification<VeMasterWo> subIDEqualTo(String subID) {
        return (veMasterWo, cq, cb) -> cb.equal(veMasterWo.get("subID"), subID);
    }
    static Specification<VeMasterWo> subIDNotEqualTo(String subID) {
        return (veMasterWo, cq, cb) -> cb.notEqual(veMasterWo.get("subID"), subID);
    }
    static Specification<VeMasterWo> timestampIsNull() {
        return (veMasterWo, cq, cb) -> cb.isNull(veMasterWo.get("timestamp"));
    }
    static Specification<VeMasterWo> timestampIsNotNull() {
        return (veMasterWo, cq, cb) -> cb.isNotNull(veMasterWo.get("timestamp"));
    }
    static Specification<VeMasterWo> timestampEqualTo(String timestamp) {
        return (veMasterWo, cq, cb) -> cb.equal(veMasterWo.get("timestamp"), timestamp);
    }
    static Specification<VeMasterWo> timestampNotEqualTo(String timestamp) {
        return (veMasterWo, cq, cb) -> cb.notEqual(veMasterWo.get("timestamp"), timestamp);
    }
    static Specification<VeMasterWo> workAuthorizationIsNull() {
        return (veMasterWo, cq, cb) -> cb.isNull(veMasterWo.get("workAuthorization"));
    }
    static Specification<VeMasterWo> workAuthorizationIsNotNull() {
        return (veMasterWo, cq, cb) -> cb.isNotNull(veMasterWo.get("workAuthorization"));
    }
    static Specification<VeMasterWo> workAuthorizationEqualTo(String workAuthorization) {
        return (veMasterWo, cq, cb) -> cb.equal(veMasterWo.get("workAuthorization"), workAuthorization);
    }
    static Specification<VeMasterWo> workAuthorizationNotEqualTo(String workAuthorization) {
        return (veMasterWo, cq, cb) -> cb.notEqual(veMasterWo.get("workAuthorization"), workAuthorization);
    }
    static Specification<VeMasterWo> wbsCodeIsNull() {
        return (veMasterWo, cq, cb) -> cb.isNull(veMasterWo.get("wbsCode"));
    }
    static Specification<VeMasterWo> wbsCodeIsNotNull() {
        return (veMasterWo, cq, cb) -> cb.isNotNull(veMasterWo.get("wbsCode"));
    }
    static Specification<VeMasterWo> wbsCodeEqualTo(String wbsCode) {
        return (veMasterWo, cq, cb) -> cb.equal(veMasterWo.get("wbsCode"), wbsCode);
    }
    static Specification<VeMasterWo> wbsCodeNotEqualTo(String wbsCode) {
        return (veMasterWo, cq, cb) -> cb.notEqual(veMasterWo.get("wbsCode"), wbsCode);
    }
    static Specification<VeMasterWo> wbsProjectIsNull() {
        return (veMasterWo, cq, cb) -> cb.isNull(veMasterWo.get("wbsProject"));
    }
    static Specification<VeMasterWo> wbsProjectIsNotNull() {
        return (veMasterWo, cq, cb) -> cb.isNotNull(veMasterWo.get("wbsProject"));
    }
    static Specification<VeMasterWo> wbsProjectEqualTo(String wbsProject) {
        return (veMasterWo, cq, cb) -> cb.equal(veMasterWo.get("wbsProject"), wbsProject);
    }
    static Specification<VeMasterWo> wbsProjectNotEqualTo(String wbsProject) {
        return (veMasterWo, cq, cb) -> cb.notEqual(veMasterWo.get("wbsProject"), wbsProject);
    }
    static Specification<VeMasterWo> workOrderAssigneeIsNull() {
        return (veMasterWo, cq, cb) -> cb.isNull(veMasterWo.get("workOrderAssignee"));
    }
    static Specification<VeMasterWo> workOrderAssigneeIsNotNull() {
        return (veMasterWo, cq, cb) -> cb.isNotNull(veMasterWo.get("workOrderAssignee"));
    }
    static Specification<VeMasterWo> workOrderAssigneeEqualTo(String workOrderAssignee) {
        return (veMasterWo, cq, cb) -> cb.equal(veMasterWo.get("workOrderAssignee"), workOrderAssignee);
    }
    static Specification<VeMasterWo> workOrderAssigneeNotEqualTo(String workOrderAssignee) {
        return (veMasterWo, cq, cb) -> cb.notEqual(veMasterWo.get("workOrderAssignee"), workOrderAssignee);
    }
    static Specification<VeMasterWo> workOrderNumberIsNull() {
        return (veMasterWo, cq, cb) -> cb.isNull(veMasterWo.get("workOrderNumber"));
    }
    static Specification<VeMasterWo> workOrderNumberIsNotNull() {
        return (veMasterWo, cq, cb) -> cb.isNotNull(veMasterWo.get("workOrderNumber"));
    }
    static Specification<VeMasterWo> workOrderNumberEqualTo(String workOrderNumber) {
        return (veMasterWo, cq, cb) -> cb.equal(veMasterWo.get("workOrderNumber"), workOrderNumber);
    }
    static Specification<VeMasterWo> workOrderNumberNotEqualTo(String workOrderNumber) {
        return (veMasterWo, cq, cb) -> cb.notEqual(veMasterWo.get("workOrderNumber"), workOrderNumber);
    }
}
