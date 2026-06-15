package edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.denodo;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.VeWoOps;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Date;

public interface VeWoOpsRepository extends JpaRepository<VeWoOps, Long>, JpaSpecificationExecutor<VeWoOps> {
    static Specification<VeWoOps> actualRunHoursIsNull() {
        return (veWoOps, cq, cb) -> cb.isNull(veWoOps.get("actualRunHours"));
    }
    static Specification<VeWoOps> actualRunHoursIsNotNull() {
        return (veWoOps, cq, cb) -> cb.isNotNull(veWoOps.get("actualRunHours"));
    }
    static Specification<VeWoOps> actualRunHoursEqualTo(Double actualRunHours) {
        return (veWoOps, cq, cb) -> cb.equal(veWoOps.get("actualRunHours"), actualRunHours);
    }
    static Specification<VeWoOps> actualRunHoursNotEqualTo(Double actualRunHours) {
        return (veWoOps, cq, cb) -> cb.notEqual(veWoOps.get("actualRunHours"), actualRunHours);
    }
    static Specification<VeWoOps> actualRunHoursLessThan(Double actualRunHours) {
        return (veWoOps, cq, cb) -> cb.lessThan(veWoOps.get("actualRunHours"), actualRunHours);
    }
    static Specification<VeWoOps> actualRunHoursGreaterThan(Double actualRunHours) {
        return (veWoOps, cq, cb) -> cb.greaterThan(veWoOps.get("actualRunHours"), actualRunHours);
    }
    static Specification<VeWoOps> actualSetupHoursIsNull() {
        return (veWoOps, cq, cb) -> cb.isNull(veWoOps.get("actualSetupHours"));
    }
    static Specification<VeWoOps> actualSetupHoursIsNotNull() {
        return (veWoOps, cq, cb) -> cb.isNotNull(veWoOps.get("actualSetupHours"));
    }
    static Specification<VeWoOps> actualSetupHoursEqualTo(Double actualSetupHours) {
        return (veWoOps, cq, cb) -> cb.equal(veWoOps.get("actualSetupHours"), actualSetupHours);
    }
    static Specification<VeWoOps> actualSetupHoursNotEqualTo(Double actualSetupHours) {
        return (veWoOps, cq, cb) -> cb.notEqual(veWoOps.get("actualSetupHours"), actualSetupHours);
    }
    static Specification<VeWoOps> actualSetupHoursLessThan(Double actualSetupHours) {
        return (veWoOps, cq, cb) -> cb.lessThan(veWoOps.get("actualSetupHours"), actualSetupHours);
    }
    static Specification<VeWoOps> actualSetupHoursGreaterThan(Double actualSetupHours) {
        return (veWoOps, cq, cb) -> cb.greaterThan(veWoOps.get("actualSetupHours"), actualSetupHours);
    }
    static Specification<VeWoOps> closeDateIsNull() {
        return (veWoOps, cq, cb) -> cb.isNull(veWoOps.get("closeDate"));
    }
    static Specification<VeWoOps> closeDateIsNotNull() {
        return (veWoOps, cq, cb) -> cb.isNotNull(veWoOps.get("closeDate"));
    }
    static Specification<VeWoOps> closeDateEqualTo(Date closeDate) {
        return (veWoOps, cq, cb) -> cb.equal(veWoOps.get("closeDate"), closeDate);
    }
    static Specification<VeWoOps> closeDateNotEqualTo(Date closeDate) {
        return (veWoOps, cq, cb) -> cb.notEqual(veWoOps.get("closeDate"), closeDate);
    }
    static Specification<VeWoOps> closeDateBefore(Date closeDate) {
        return (veWoOps, cq, cb) -> cb.lessThan(veWoOps.get("closeDate"), closeDate);
    }
    static Specification<VeWoOps> closeDateAfter(Date closeDate) {
        return (veWoOps, cq, cb) -> cb.greaterThan(veWoOps.get("closeDate"), closeDate);
    }
    static Specification<VeWoOps> completedQuantityIsNull() {
        return (veWoOps, cq, cb) -> cb.isNull(veWoOps.get("completedQuantity"));
    }
    static Specification<VeWoOps> completedQuantityIsNotNull() {
        return (veWoOps, cq, cb) -> cb.isNotNull(veWoOps.get("completedQuantity"));
    }
    static Specification<VeWoOps> completedQuantityEqualTo(Double completedQuantity) {
        return (veWoOps, cq, cb) -> cb.equal(veWoOps.get("completedQuantity"), completedQuantity);
    }
    static Specification<VeWoOps> completedQuantityNotEqualTo(Double completedQuantity) {
        return (veWoOps, cq, cb) -> cb.notEqual(veWoOps.get("completedQuantity"), completedQuantity);
    }
    static Specification<VeWoOps> completedQuantityLessThan(Double completedQuantity) {
        return (veWoOps, cq, cb) -> cb.lessThan(veWoOps.get("completedQuantity"), completedQuantity);
    }
    static Specification<VeWoOps> completedQuantityGreaterThan(Double completedQuantity) {
        return (veWoOps, cq, cb) -> cb.greaterThan(veWoOps.get("completedQuantity"), completedQuantity);
    }
    static Specification<VeWoOps> evwpmsIsNull() {
        return (veWoOps, cq, cb) -> cb.isNull(veWoOps.get("evwpms"));
    }
    static Specification<VeWoOps> evwpmsIsNotNull() {
        return (veWoOps, cq, cb) -> cb.isNotNull(veWoOps.get("evwpms"));
    }
    static Specification<VeWoOps> evwpmsEqualTo(String evwpms) {
        return (veWoOps, cq, cb) -> cb.equal(veWoOps.get("evwpms"), evwpms);
    }
    static Specification<VeWoOps> evwpmsNotEqualTo(String evwpms) {
        return (veWoOps, cq, cb) -> cb.notEqual(veWoOps.get("evwpms"), evwpms);
    }
    static Specification<VeWoOps> loadSizeQuantityIsNull() {
        return (veWoOps, cq, cb) -> cb.isNull(veWoOps.get("loadSizeQuantity"));
    }
    static Specification<VeWoOps> loadSizeQuantityIsNotNull() {
        return (veWoOps, cq, cb) -> cb.isNotNull(veWoOps.get("loadSizeQuantity"));
    }
    static Specification<VeWoOps> loadSizeQuantityEqualTo(Double loadSizeQuantity) {
        return (veWoOps, cq, cb) -> cb.equal(veWoOps.get("loadSizeQuantity"), loadSizeQuantity);
    }
    static Specification<VeWoOps> loadSizeQuantityNotEqualTo(Double loadSizeQuantity) {
        return (veWoOps, cq, cb) -> cb.notEqual(veWoOps.get("loadSizeQuantity"), loadSizeQuantity);
    }
    static Specification<VeWoOps> loadSizeQuantityLessThan(Double loadSizeQuantity) {
        return (veWoOps, cq, cb) -> cb.lessThan(veWoOps.get("loadSizeQuantity"), loadSizeQuantity);
    }
    static Specification<VeWoOps> loadSizeQuantityGreaterThan(Double loadSizeQuantity) {
        return (veWoOps, cq, cb) -> cb.greaterThan(veWoOps.get("loadSizeQuantity"), loadSizeQuantity);
    }
    static Specification<VeWoOps> moveHoursIsNull() {
        return (veWoOps, cq, cb) -> cb.isNull(veWoOps.get("moveHours"));
    }
    static Specification<VeWoOps> moveHoursIsNotNull() {
        return (veWoOps, cq, cb) -> cb.isNotNull(veWoOps.get("moveHours"));
    }
    static Specification<VeWoOps> moveHoursEqualTo(Double moveHours) {
        return (veWoOps, cq, cb) -> cb.equal(veWoOps.get("moveHours"), moveHours);
    }
    static Specification<VeWoOps> moveHoursNotEqualTo(Double moveHours) {
        return (veWoOps, cq, cb) -> cb.notEqual(veWoOps.get("moveHours"), moveHours);
    }
    static Specification<VeWoOps> moveHoursLessThan(Double moveHours) {
        return (veWoOps, cq, cb) -> cb.lessThan(veWoOps.get("moveHours"), moveHours);
    }
    static Specification<VeWoOps> moveHoursGreaterThan(Double moveHours) {
        return (veWoOps, cq, cb) -> cb.greaterThan(veWoOps.get("moveHours"), moveHours);
    }
    static Specification<VeWoOps> operationAssigneeIsNull() {
        return (veWoOps, cq, cb) -> cb.isNull(veWoOps.get("operationAssignee"));
    }
    static Specification<VeWoOps> operationAssigneeIsNotNull() {
        return (veWoOps, cq, cb) -> cb.isNotNull(veWoOps.get("operationAssignee"));
    }
    static Specification<VeWoOps> operationAssigneeEqualTo(String operationAssignee) {
        return (veWoOps, cq, cb) -> cb.equal(veWoOps.get("operationAssignee"), operationAssignee);
    }
    static Specification<VeWoOps> operationAssigneeNotEqualTo(String operationAssignee) {
        return (veWoOps, cq, cb) -> cb.notEqual(veWoOps.get("operationAssignee"), operationAssignee);
    }
    static Specification<VeWoOps> operationTypeIsNull() {
        return (veWoOps, cq, cb) -> cb.isNull(veWoOps.get("operationType"));
    }
    static Specification<VeWoOps> operationTypeIsNotNull() {
        return (veWoOps, cq, cb) -> cb.isNotNull(veWoOps.get("operationType"));
    }
    static Specification<VeWoOps> operationTypeEqualTo(String operationType) {
        return (veWoOps, cq, cb) -> cb.equal(veWoOps.get("operationType"), operationType);
    }
    static Specification<VeWoOps> operationTypeNotEqualTo(String operationType) {
        return (veWoOps, cq, cb) -> cb.notEqual(veWoOps.get("operationType"), operationType);
    }
    static Specification<VeWoOps> resourceIDIsNull() {
        return (veWoOps, cq, cb) -> cb.isNull(veWoOps.get("resourceID"));
    }
    static Specification<VeWoOps> resourceIDIsNotNull() {
        return (veWoOps, cq, cb) -> cb.isNotNull(veWoOps.get("resourceID"));
    }
    static Specification<VeWoOps> resourceIDEqualTo(String resourceID) {
        return (veWoOps, cq, cb) -> cb.equal(veWoOps.get("resourceID"), resourceID);
    }
    static Specification<VeWoOps> resourceIDNotEqualTo(String resourceID) {
        return (veWoOps, cq, cb) -> cb.notEqual(veWoOps.get("resourceID"), resourceID);
    }
    static Specification<VeWoOps> runIsNull() {
        return (veWoOps, cq, cb) -> cb.isNull(veWoOps.get("run"));
    }
    static Specification<VeWoOps> runIsNotNull() {
        return (veWoOps, cq, cb) -> cb.isNotNull(veWoOps.get("run"));
    }
    static Specification<VeWoOps> runEqualTo(Double run) {
        return (veWoOps, cq, cb) -> cb.equal(veWoOps.get("run"), run);
    }
    static Specification<VeWoOps> runNotEqualTo(Double run) {
        return (veWoOps, cq, cb) -> cb.notEqual(veWoOps.get("run"), run);
    }
    static Specification<VeWoOps> runLessThan(Double run) {
        return (veWoOps, cq, cb) -> cb.lessThan(veWoOps.get("run"), run);
    }
    static Specification<VeWoOps> runGreaterThan(Double run) {
        return (veWoOps, cq, cb) -> cb.greaterThan(veWoOps.get("run"), run);
    }
    static Specification<VeWoOps> runHoursIsNull() {
        return (veWoOps, cq, cb) -> cb.isNull(veWoOps.get("runHours"));
    }
    static Specification<VeWoOps> runHoursIsNotNull() {
        return (veWoOps, cq, cb) -> cb.isNotNull(veWoOps.get("runHours"));
    }
    static Specification<VeWoOps> runHoursEqualTo(Double runHours) {
        return (veWoOps, cq, cb) -> cb.equal(veWoOps.get("runHours"), runHours);
    }
    static Specification<VeWoOps> runHoursNotEqualTo(Double runHours) {
        return (veWoOps, cq, cb) -> cb.notEqual(veWoOps.get("runHours"), runHours);
    }
    static Specification<VeWoOps> runHoursLessThan(Double runHours) {
        return (veWoOps, cq, cb) -> cb.lessThan(veWoOps.get("runHours"), runHours);
    }
    static Specification<VeWoOps> runHoursGreaterThan(Double runHours) {
        return (veWoOps, cq, cb) -> cb.greaterThan(veWoOps.get("runHours"), runHours);
    }
    static Specification<VeWoOps> runTypeIsNull() {
        return (veWoOps, cq, cb) -> cb.isNull(veWoOps.get("runType"));
    }
    static Specification<VeWoOps> runTypeIsNotNull() {
        return (veWoOps, cq, cb) -> cb.isNotNull(veWoOps.get("runType"));
    }
    static Specification<VeWoOps> runTypeEqualTo(String runType) {
        return (veWoOps, cq, cb) -> cb.equal(veWoOps.get("runType"), runType);
    }
    static Specification<VeWoOps> runTypeNotEqualTo(String runType) {
        return (veWoOps, cq, cb) -> cb.notEqual(veWoOps.get("runType"), runType);
    }
    static Specification<VeWoOps> sequenceNumberIsNull() {
        return (veWoOps, cq, cb) -> cb.isNull(veWoOps.get("sequenceNumber"));
    }
    static Specification<VeWoOps> sequenceNumberIsNotNull() {
        return (veWoOps, cq, cb) -> cb.isNotNull(veWoOps.get("sequenceNumber"));
    }
    static Specification<VeWoOps> sequenceNumberEqualTo(Double sequenceNumber) {
        return (veWoOps, cq, cb) -> cb.equal(veWoOps.get("sequenceNumber"), sequenceNumber);
    }
    static Specification<VeWoOps> sequenceNumberNotEqualTo(Double sequenceNumber) {
        return (veWoOps, cq, cb) -> cb.notEqual(veWoOps.get("sequenceNumber"), sequenceNumber);
    }
    static Specification<VeWoOps> sequenceNumberLessThan(Double sequenceNumber) {
        return (veWoOps, cq, cb) -> cb.lessThan(veWoOps.get("sequenceNumber"), sequenceNumber);
    }
    static Specification<VeWoOps> sequenceNumberGreaterThan(Double sequenceNumber) {
        return (veWoOps, cq, cb) -> cb.greaterThan(veWoOps.get("sequenceNumber"), sequenceNumber);
    }
    static Specification<VeWoOps> setupCompleteIsNull() {
        return (veWoOps, cq, cb) -> cb.isNull(veWoOps.get("setupComplete"));
    }
    static Specification<VeWoOps> setupCompleteIsNotNull() {
        return (veWoOps, cq, cb) -> cb.isNotNull(veWoOps.get("setupComplete"));
    }
    static Specification<VeWoOps> setupCompleteEqualTo(String setupComplete) {
        return (veWoOps, cq, cb) -> cb.equal(veWoOps.get("setupComplete"), setupComplete);
    }
    static Specification<VeWoOps> setupCompleteNotEqualTo(String setupComplete) {
        return (veWoOps, cq, cb) -> cb.notEqual(veWoOps.get("setupComplete"), setupComplete);
    }
    static Specification<VeWoOps> setupHoursIsNull() {
        return (veWoOps, cq, cb) -> cb.isNull(veWoOps.get("setupHours"));
    }
    static Specification<VeWoOps> setupHoursIsNotNull() {
        return (veWoOps, cq, cb) -> cb.isNotNull(veWoOps.get("setupHours"));
    }
    static Specification<VeWoOps> setupHoursEqualTo(Double setupHours) {
        return (veWoOps, cq, cb) -> cb.equal(veWoOps.get("setupHours"), setupHours);
    }
    static Specification<VeWoOps> setupHoursNotEqualTo(Double setupHours) {
        return (veWoOps, cq, cb) -> cb.notEqual(veWoOps.get("setupHours"), setupHours);
    }
    static Specification<VeWoOps> setupHoursLessThan(Double setupHours) {
        return (veWoOps, cq, cb) -> cb.lessThan(veWoOps.get("setupHours"), setupHours);
    }
    static Specification<VeWoOps> setupHoursGreaterThan(Double setupHours) {
        return (veWoOps, cq, cb) -> cb.greaterThan(veWoOps.get("setupHours"), setupHours);
    }
    static Specification<VeWoOps> statusIsNull() {
        return (veWoOps, cq, cb) -> cb.isNull(veWoOps.get("status"));
    }
    static Specification<VeWoOps> statusIsNotNull() {
        return (veWoOps, cq, cb) -> cb.isNotNull(veWoOps.get("status"));
    }
    static Specification<VeWoOps> statusEqualTo(String status) {
        return (veWoOps, cq, cb) -> cb.equal(veWoOps.get("status"), status);
    }
    static Specification<VeWoOps> statusNotEqualTo(String status) {
        return (veWoOps, cq, cb) -> cb.notEqual(veWoOps.get("status"), status);
    }
    static Specification<VeWoOps> userDefinedField10IsNull() {
        return (veWoOps, cq, cb) -> cb.isNull(veWoOps.get("userDefinedField10"));
    }
    static Specification<VeWoOps> userDefinedField10IsNotNull() {
        return (veWoOps, cq, cb) -> cb.isNotNull(veWoOps.get("userDefinedField10"));
    }
    static Specification<VeWoOps> userDefinedField10EqualTo(String userDefinedField10) {
        return (veWoOps, cq, cb) -> cb.equal(veWoOps.get("userDefinedField10"), userDefinedField10);
    }
    static Specification<VeWoOps> userDefinedField10NotEqualTo(String userDefinedField10) {
        return (veWoOps, cq, cb) -> cb.notEqual(veWoOps.get("userDefinedField10"), userDefinedField10);
    }
    static Specification<VeWoOps> workOrderNumberIsNull() {
        return (veWoOps, cq, cb) -> cb.isNull(veWoOps.get("workOrderNumber"));
    }
    static Specification<VeWoOps> workOrderNumberIsNotNull() {
        return (veWoOps, cq, cb) -> cb.isNotNull(veWoOps.get("workOrderNumber"));
    }
    static Specification<VeWoOps> workOrderNumberEqualTo(String workOrderNumber) {
        return (veWoOps, cq, cb) -> cb.equal(veWoOps.get("workOrderNumber"), workOrderNumber);
    }
    static Specification<VeWoOps> workOrderNumberNotEqualTo(String workOrderNumber) {
        return (veWoOps, cq, cb) -> cb.notEqual(veWoOps.get("workOrderNumber"), workOrderNumber);
    }
    static Specification<VeWoOps> workOrderBaseIDIsNull() {
        return (veWoOps, cq, cb) -> cb.isNull(veWoOps.get("workOrderBaseID"));
    }
    static Specification<VeWoOps> workOrderBaseIDIsNotNull() {
        return (veWoOps, cq, cb) -> cb.isNotNull(veWoOps.get("workOrderBaseID"));
    }
    static Specification<VeWoOps> workOrderBaseIDEqualTo(String workOrderBaseID) {
        return (veWoOps, cq, cb) -> cb.equal(veWoOps.get("workOrderBaseID"), workOrderBaseID);
    }
    static Specification<VeWoOps> workOrderBaseIDNotEqualTo(String workOrderBaseID) {
        return (veWoOps, cq, cb) -> cb.notEqual(veWoOps.get("workOrderBaseID"), workOrderBaseID);
    }
    static Specification<VeWoOps> workOrderLotIDIsNull() {
        return (veWoOps, cq, cb) -> cb.isNull(veWoOps.get("workOrderLotID"));
    }
    static Specification<VeWoOps> workOrderLotIDIsNotNull() {
        return (veWoOps, cq, cb) -> cb.isNotNull(veWoOps.get("workOrderLotID"));
    }
    static Specification<VeWoOps> workOrderLotIDEqualTo(String workOrderLotID) {
        return (veWoOps, cq, cb) -> cb.equal(veWoOps.get("workOrderLotID"), workOrderLotID);
    }
    static Specification<VeWoOps> workOrderLotIDNotEqualTo(String workOrderLotID) {
        return (veWoOps, cq, cb) -> cb.notEqual(veWoOps.get("workOrderLotID"), workOrderLotID);
    }
    static Specification<VeWoOps> workOrderSplitIDIsNull() {
        return (veWoOps, cq, cb) -> cb.isNull(veWoOps.get("workOrderSplitID"));
    }
    static Specification<VeWoOps> workOrderSplitIDIsNotNull() {
        return (veWoOps, cq, cb) -> cb.isNotNull(veWoOps.get("workOrderSplitID"));
    }
    static Specification<VeWoOps> workOrderSplitIDEqualTo(String workOrderSplitID) {
        return (veWoOps, cq, cb) -> cb.equal(veWoOps.get("workOrderSplitID"), workOrderSplitID);
    }
    static Specification<VeWoOps> workOrderSplitIDNotEqualTo(String workOrderSplitID) {
        return (veWoOps, cq, cb) -> cb.notEqual(veWoOps.get("workOrderSplitID"), workOrderSplitID);
    }
    static Specification<VeWoOps> workOrderSubIDIsNull() {
        return (veWoOps, cq, cb) -> cb.isNull(veWoOps.get("workOrderSubID"));
    }
    static Specification<VeWoOps> workOrderSubIDIsNotNull() {
        return (veWoOps, cq, cb) -> cb.isNotNull(veWoOps.get("workOrderSubID"));
    }
    static Specification<VeWoOps> workOrderSubIDEqualTo(String workOrderSubID) {
        return (veWoOps, cq, cb) -> cb.equal(veWoOps.get("workOrderSubID"), workOrderSubID);
    }
    static Specification<VeWoOps> workOrderSubIDNotEqualTo(String workOrderSubID) {
        return (veWoOps, cq, cb) -> cb.notEqual(veWoOps.get("workOrderSubID"), workOrderSubID);
    }
    static Specification<VeWoOps> modifiedDateIsNull() {
        return (veWoOps, cq, cb) -> cb.isNull(veWoOps.get("modifiedDate"));
    }
    static Specification<VeWoOps> modifiedDateIsNotNull() {
        return (veWoOps, cq, cb) -> cb.isNotNull(veWoOps.get("modifiedDate"));
    }
    static Specification<VeWoOps> modifiedDateEqualTo(Date modifiedDate) {
        return (veWoOps, cq, cb) -> cb.equal(veWoOps.get("modifiedDate"), modifiedDate);
    }
    static Specification<VeWoOps> modifiedDateNotEqualTo(Date modifiedDate) {
        return (veWoOps, cq, cb) -> cb.notEqual(veWoOps.get("modifiedDate"), modifiedDate);
    }
    static Specification<VeWoOps> modifiedDateBefore(Date modifiedDate) {
        return (veWoOps, cq, cb) -> cb.lessThan(veWoOps.get("modifiedDate"), modifiedDate);
    }
    static Specification<VeWoOps> modifiedDateAfter(Date modifiedDate) {
        return (veWoOps, cq, cb) -> cb.greaterThan(veWoOps.get("modifiedDate"), modifiedDate);
    }
}
