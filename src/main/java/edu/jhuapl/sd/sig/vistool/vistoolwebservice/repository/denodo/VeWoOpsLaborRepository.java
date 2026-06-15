package edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.denodo;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.VeWoOpsLabor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VeWoOpsLaborRepository extends JpaRepository<VeWoOpsLabor, Long>, JpaSpecificationExecutor<VeWoOpsLabor> {
    static Specification<VeWoOpsLabor> badQuantityIsNull() {
        return (veWoOpsLabor, cq, cb) -> cb.isNull(veWoOpsLabor.get("badQuantity"));
    }
    static Specification<VeWoOpsLabor> badQuantityIsNotNull() {
        return (veWoOpsLabor, cq, cb) -> cb.isNotNull(veWoOpsLabor.get("badQuantity"));
    }
    static Specification<VeWoOpsLabor> badQuantityEqualTo(Double badQuantity) {
        return (veWoOpsLabor, cq, cb) -> cb.equal(veWoOpsLabor.get("badQuantity"), badQuantity);
    }
    static Specification<VeWoOpsLabor> badQuantityNotEqualTo(Double badQuantity) {
        return (veWoOpsLabor, cq, cb) -> cb.notEqual(veWoOpsLabor.get("badQuantity"), badQuantity);
    }
    static Specification<VeWoOpsLabor> badQuantityLessThan(Double badQuantity) {
        return (veWoOpsLabor, cq, cb) -> cb.lessThan(veWoOpsLabor.get("badQuantity"), badQuantity);
    }
    static Specification<VeWoOpsLabor> badQuantityGreaterThan(Double badQuantity) {
        return (veWoOpsLabor, cq, cb) -> cb.greaterThan(veWoOpsLabor.get("badQuantity"), badQuantity);
    }
    static Specification<VeWoOpsLabor> departmentIDIsNull() {
        return (veWoOpsLabor, cq, cb) -> cb.isNull(veWoOpsLabor.get("departmentID"));
    }
    static Specification<VeWoOpsLabor> departmentIDIsNotNull() {
        return (veWoOpsLabor, cq, cb) -> cb.isNotNull(veWoOpsLabor.get("departmentID"));
    }
    static Specification<VeWoOpsLabor> departmentIDEqualTo(String departmentID) {
        return (veWoOpsLabor, cq, cb) -> cb.equal(veWoOpsLabor.get("departmentID"), departmentID);
    }
    static Specification<VeWoOpsLabor> departmentIDNotEqualTo(String departmentID) {
        return (veWoOpsLabor, cq, cb) -> cb.notEqual(veWoOpsLabor.get("departmentID"), departmentID);
    }
    static Specification<VeWoOpsLabor> descriptionIsNull() {
        return (veWoOpsLabor, cq, cb) -> cb.isNull(veWoOpsLabor.get("description"));
    }
    static Specification<VeWoOpsLabor> descriptionIsNotNull() {
        return (veWoOpsLabor, cq, cb) -> cb.isNotNull(veWoOpsLabor.get("description"));
    }
    static Specification<VeWoOpsLabor> descriptionEqualTo(String description) {
        return (veWoOpsLabor, cq, cb) -> cb.equal(veWoOpsLabor.get("description"), description);
    }
    static Specification<VeWoOpsLabor> descriptionNotEqualTo(String description) {
        return (veWoOpsLabor, cq, cb) -> cb.notEqual(veWoOpsLabor.get("description"), description);
    }
    static Specification<VeWoOpsLabor> employeeIDIsNull() {
        return (veWoOpsLabor, cq, cb) -> cb.isNull(veWoOpsLabor.get("employeeID"));
    }
    static Specification<VeWoOpsLabor> employeeIDIsNotNull() {
        return (veWoOpsLabor, cq, cb) -> cb.isNotNull(veWoOpsLabor.get("employeeID"));
    }
    static Specification<VeWoOpsLabor> employeeIDEqualTo(String employeeID) {
        return (veWoOpsLabor, cq, cb) -> cb.equal(veWoOpsLabor.get("employeeID"), employeeID);
    }
    static Specification<VeWoOpsLabor> employeeIDNotEqualTo(String employeeID) {
        return (veWoOpsLabor, cq, cb) -> cb.notEqual(veWoOpsLabor.get("employeeID"), employeeID);
    }
    static Specification<VeWoOpsLabor> goodQuantityIsNull() {
        return (veWoOpsLabor, cq, cb) -> cb.isNull(veWoOpsLabor.get("goodQuantity"));
    }
    static Specification<VeWoOpsLabor> goodQuantityIsNotNull() {
        return (veWoOpsLabor, cq, cb) -> cb.isNotNull(veWoOpsLabor.get("goodQuantity"));
    }
    static Specification<VeWoOpsLabor> goodQuantityEqualTo(Double goodQuantity) {
        return (veWoOpsLabor, cq, cb) -> cb.equal(veWoOpsLabor.get("goodQuantity"), goodQuantity);
    }
    static Specification<VeWoOpsLabor> goodQuantityNotEqualTo(Double goodQuantity) {
        return (veWoOpsLabor, cq, cb) -> cb.notEqual(veWoOpsLabor.get("goodQuantity"), goodQuantity);
    }
    static Specification<VeWoOpsLabor> goodQuantityLessThan(Double goodQuantity) {
        return (veWoOpsLabor, cq, cb) -> cb.lessThan(veWoOpsLabor.get("goodQuantity"), goodQuantity);
    }
    static Specification<VeWoOpsLabor> goodQuantityGreaterThan(Double goodQuantity) {
        return (veWoOpsLabor, cq, cb) -> cb.greaterThan(veWoOpsLabor.get("goodQuantity"), goodQuantity);
    }
    static Specification<VeWoOpsLabor> hoursWorkedIsNull() {
        return (veWoOpsLabor, cq, cb) -> cb.isNull(veWoOpsLabor.get("hoursWorked"));
    }
    static Specification<VeWoOpsLabor> hoursWorkedIsNotNull() {
        return (veWoOpsLabor, cq, cb) -> cb.isNotNull(veWoOpsLabor.get("hoursWorked"));
    }
    static Specification<VeWoOpsLabor> hoursWorkedEqualTo(Double hoursWorked) {
        return (veWoOpsLabor, cq, cb) -> cb.equal(veWoOpsLabor.get("hoursWorked"), hoursWorked);
    }
    static Specification<VeWoOpsLabor> hoursWorkedNotEqualTo(Double hoursWorked) {
        return (veWoOpsLabor, cq, cb) -> cb.notEqual(veWoOpsLabor.get("hoursWorked"), hoursWorked);
    }
    static Specification<VeWoOpsLabor> hoursWorkedLessThan(Double hoursWorked) {
        return (veWoOpsLabor, cq, cb) -> cb.lessThan(veWoOpsLabor.get("hoursWorked"), hoursWorked);
    }
    static Specification<VeWoOpsLabor> hoursWorkedGreaterThan(Double hoursWorked) {
        return (veWoOpsLabor, cq, cb) -> cb.greaterThan(veWoOpsLabor.get("hoursWorked"), hoursWorked);
    }
    static Specification<VeWoOpsLabor> operationSequenceNumberIsNull() {
        return (veWoOpsLabor, cq, cb) -> cb.isNull(veWoOpsLabor.get("operationSequenceNumber"));
    }
    static Specification<VeWoOpsLabor> operationSequenceNumberIsNotNull() {
        return (veWoOpsLabor, cq, cb) -> cb.isNotNull(veWoOpsLabor.get("operationSequenceNumber"));
    }
    static Specification<VeWoOpsLabor> operationSequenceNumberEqualTo(Double operationSequenceNumber) {
        return (veWoOpsLabor, cq, cb) -> cb.equal(veWoOpsLabor.get("operationSequenceNumber"), operationSequenceNumber);
    }
    static Specification<VeWoOpsLabor> operationSequenceNumberNotEqualTo(Double operationSequenceNumber) {
        return (veWoOpsLabor, cq, cb) -> cb.notEqual(veWoOpsLabor.get("operationSequenceNumber"), operationSequenceNumber);
    }
    static Specification<VeWoOpsLabor> operationSequenceNumberLessThan(Double operationSequenceNumber) {
        return (veWoOpsLabor, cq, cb) -> cb.lessThan(veWoOpsLabor.get("operationSequenceNumber"), operationSequenceNumber);
    }
    static Specification<VeWoOpsLabor> operationSequenceNumberGreaterThan(Double operationSequenceNumber) {
        return (veWoOpsLabor, cq, cb) -> cb.greaterThan(veWoOpsLabor.get("operationSequenceNumber"), operationSequenceNumber);
    }
    static Specification<VeWoOpsLabor> resourceIDIsNull() {
        return (veWoOpsLabor, cq, cb) -> cb.isNull(veWoOpsLabor.get("resourceID"));
    }
    static Specification<VeWoOpsLabor> resourceIDIsNotNull() {
        return (veWoOpsLabor, cq, cb) -> cb.isNotNull(veWoOpsLabor.get("resourceID"));
    }
    static Specification<VeWoOpsLabor> resourceIDEqualTo(String resourceID) {
        return (veWoOpsLabor, cq, cb) -> cb.equal(veWoOpsLabor.get("resourceID"), resourceID);
    }
    static Specification<VeWoOpsLabor> resourceIDNotEqualTo(String resourceID) {
        return (veWoOpsLabor, cq, cb) -> cb.notEqual(veWoOpsLabor.get("resourceID"), resourceID);
    }
    static Specification<VeWoOpsLabor> setupCompletedIsNull() {
        return (veWoOpsLabor, cq, cb) -> cb.isNull(veWoOpsLabor.get("setupCompleted"));
    }
    static Specification<VeWoOpsLabor> setupCompletedIsNotNull() {
        return (veWoOpsLabor, cq, cb) -> cb.isNotNull(veWoOpsLabor.get("setupCompleted"));
    }
    static Specification<VeWoOpsLabor> setupCompletedEqualTo(String setupCompleted) {
        return (veWoOpsLabor, cq, cb) -> cb.equal(veWoOpsLabor.get("setupCompleted"), setupCompleted);
    }
    static Specification<VeWoOpsLabor> setupCompletedNotEqualTo(String setupCompleted) {
        return (veWoOpsLabor, cq, cb) -> cb.notEqual(veWoOpsLabor.get("setupCompleted"), setupCompleted);
    }
    static Specification<VeWoOpsLabor> transactionDateIsNull() {
        return (veWoOpsLabor, cq, cb) -> cb.isNull(veWoOpsLabor.get("transactionDate"));
    }
    static Specification<VeWoOpsLabor> transactionDateIsNotNull() {
        return (veWoOpsLabor, cq, cb) -> cb.isNotNull(veWoOpsLabor.get("transactionDate"));
    }
    static Specification<VeWoOpsLabor> transactionDateEqualTo(String transactionDate) {
        return (veWoOpsLabor, cq, cb) -> cb.equal(veWoOpsLabor.get("transactionDate"), transactionDate);
    }
    static Specification<VeWoOpsLabor> transactionDateNotEqualTo(String transactionDate) {
        return (veWoOpsLabor, cq, cb) -> cb.notEqual(veWoOpsLabor.get("transactionDate"), transactionDate);
    }
    static Specification<VeWoOpsLabor> transactionIDIsNull() {
        return (veWoOpsLabor, cq, cb) -> cb.isNull(veWoOpsLabor.get("transactionID"));
    }
    static Specification<VeWoOpsLabor> transactionIDIsNotNull() {
        return (veWoOpsLabor, cq, cb) -> cb.isNotNull(veWoOpsLabor.get("transactionID"));
    }
    static Specification<VeWoOpsLabor> transactionIDEqualTo(Double transactionID) {
        return (veWoOpsLabor, cq, cb) -> cb.equal(veWoOpsLabor.get("transactionID"), transactionID);
    }
    static Specification<VeWoOpsLabor> transactionIDNotEqualTo(Double transactionID) {
        return (veWoOpsLabor, cq, cb) -> cb.notEqual(veWoOpsLabor.get("transactionID"), transactionID);
    }
    static Specification<VeWoOpsLabor> transactionIDLessThan(Double transactionID) {
        return (veWoOpsLabor, cq, cb) -> cb.lessThan(veWoOpsLabor.get("transactionID"), transactionID);
    }
    static Specification<VeWoOpsLabor> transactionIDGreaterThan(Double transactionID) {
        return (veWoOpsLabor, cq, cb) -> cb.greaterThan(veWoOpsLabor.get("transactionID"), transactionID);
    }
    static Specification<VeWoOpsLabor> typeIsNull() {
        return (veWoOpsLabor, cq, cb) -> cb.isNull(veWoOpsLabor.get("type"));
    }
    static Specification<VeWoOpsLabor> typeIsNotNull() {
        return (veWoOpsLabor, cq, cb) -> cb.isNotNull(veWoOpsLabor.get("type"));
    }
    static Specification<VeWoOpsLabor> typeEqualTo(String type) {
        return (veWoOpsLabor, cq, cb) -> cb.equal(veWoOpsLabor.get("type"), type);
    }
    static Specification<VeWoOpsLabor> typeNotEqualTo(String type) {
        return (veWoOpsLabor, cq, cb) -> cb.notEqual(veWoOpsLabor.get("type"), type);
    }
    static Specification<VeWoOpsLabor> userIDIsNull() {
        return (veWoOpsLabor, cq, cb) -> cb.isNull(veWoOpsLabor.get("userID"));
    }
    static Specification<VeWoOpsLabor> userIDIsNotNull() {
        return (veWoOpsLabor, cq, cb) -> cb.isNotNull(veWoOpsLabor.get("userID"));
    }
    static Specification<VeWoOpsLabor> userIDEqualTo(String userID) {
        return (veWoOpsLabor, cq, cb) -> cb.equal(veWoOpsLabor.get("userID"), userID);
    }
    static Specification<VeWoOpsLabor> userIDNotEqualTo(String userID) {
        return (veWoOpsLabor, cq, cb) -> cb.notEqual(veWoOpsLabor.get("userID"), userID);
    }
    static Specification<VeWoOpsLabor> workOrderNumberIsNull() {
        return (veWoOpsLabor, cq, cb) -> cb.isNull(veWoOpsLabor.get("workOrderNumber"));
    }
    static Specification<VeWoOpsLabor> workOrderNumberIsNotNull() {
        return (veWoOpsLabor, cq, cb) -> cb.isNotNull(veWoOpsLabor.get("workOrderNumber"));
    }
    static Specification<VeWoOpsLabor> workOrderNumberEqualTo(String workOrderNumber) {
        return (veWoOpsLabor, cq, cb) -> cb.equal(veWoOpsLabor.get("workOrderNumber"), workOrderNumber);
    }
    static Specification<VeWoOpsLabor> workOrderNumberNotEqualTo(String workOrderNumber) {
        return (veWoOpsLabor, cq, cb) -> cb.notEqual(veWoOpsLabor.get("workOrderNumber"), workOrderNumber);
    }
    static Specification<VeWoOpsLabor> workOrderBaseIDIsNull() {
        return (veWoOpsLabor, cq, cb) -> cb.isNull(veWoOpsLabor.get("workOrderBaseID"));
    }
    static Specification<VeWoOpsLabor> workOrderBaseIDIsNotNull() {
        return (veWoOpsLabor, cq, cb) -> cb.isNotNull(veWoOpsLabor.get("workOrderBaseID"));
    }
    static Specification<VeWoOpsLabor> workOrderBaseIDEqualTo(String workOrderBaseID) {
        return (veWoOpsLabor, cq, cb) -> cb.equal(veWoOpsLabor.get("workOrderBaseID"), workOrderBaseID);
    }
    static Specification<VeWoOpsLabor> workOrderBaseIDNotEqualTo(String workOrderBaseID) {
        return (veWoOpsLabor, cq, cb) -> cb.notEqual(veWoOpsLabor.get("workOrderBaseID"), workOrderBaseID);
    }
    static Specification<VeWoOpsLabor> workOrderLotIDIsNull() {
        return (veWoOpsLabor, cq, cb) -> cb.isNull(veWoOpsLabor.get("workOrderLotID"));
    }
    static Specification<VeWoOpsLabor> workOrderLotIDIsNotNull() {
        return (veWoOpsLabor, cq, cb) -> cb.isNotNull(veWoOpsLabor.get("workOrderLotID"));
    }
    static Specification<VeWoOpsLabor> workOrderLotIDEqualTo(String workOrderLotID) {
        return (veWoOpsLabor, cq, cb) -> cb.equal(veWoOpsLabor.get("workOrderLotID"), workOrderLotID);
    }
    static Specification<VeWoOpsLabor> workOrderLotIDNotEqualTo(String workOrderLotID) {
        return (veWoOpsLabor, cq, cb) -> cb.notEqual(veWoOpsLabor.get("workOrderLotID"), workOrderLotID);
    }
    static Specification<VeWoOpsLabor> workOrderSplitIDIsNull() {
        return (veWoOpsLabor, cq, cb) -> cb.isNull(veWoOpsLabor.get("workOrderSplitID"));
    }
    static Specification<VeWoOpsLabor> workOrderSplitIDIsNotNull() {
        return (veWoOpsLabor, cq, cb) -> cb.isNotNull(veWoOpsLabor.get("workOrderSplitID"));
    }
    static Specification<VeWoOpsLabor> workOrderSplitIDEqualTo(String workOrderSplitID) {
        return (veWoOpsLabor, cq, cb) -> cb.equal(veWoOpsLabor.get("workOrderSplitID"), workOrderSplitID);
    }
    static Specification<VeWoOpsLabor> workOrderSplitIDNotEqualTo(String workOrderSplitID) {
        return (veWoOpsLabor, cq, cb) -> cb.notEqual(veWoOpsLabor.get("workOrderSplitID"), workOrderSplitID);
    }
    static Specification<VeWoOpsLabor> workOrderSubIDIsNull() {
        return (veWoOpsLabor, cq, cb) -> cb.isNull(veWoOpsLabor.get("workOrderSubID"));
    }
    static Specification<VeWoOpsLabor> workOrderSubIDIsNotNull() {
        return (veWoOpsLabor, cq, cb) -> cb.isNotNull(veWoOpsLabor.get("workOrderSubID"));
    }
    static Specification<VeWoOpsLabor> workOrderSubIDEqualTo(String workOrderSubID) {
        return (veWoOpsLabor, cq, cb) -> cb.equal(veWoOpsLabor.get("workOrderSubID"), workOrderSubID);
    }
    static Specification<VeWoOpsLabor> workOrderSubIDNotEqualTo(String workOrderSubID) {
        return (veWoOpsLabor, cq, cb) -> cb.notEqual(veWoOpsLabor.get("workOrderSubID"), workOrderSubID);
    }
}
