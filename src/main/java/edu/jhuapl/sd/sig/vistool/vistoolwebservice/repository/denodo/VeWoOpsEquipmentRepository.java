package edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.denodo;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.VeWoOpsEquipment;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Date;

public interface VeWoOpsEquipmentRepository extends JpaRepository<VeWoOpsEquipment, Long>, JpaSpecificationExecutor<VeWoOpsEquipment> {
    static Specification<VeWoOpsEquipment> equipmentDateCalibratedIsNull() {
        return (veWoOpsEquipment, cq, cb) -> cb.isNull(veWoOpsEquipment.get("equipmentDateCalibrated"));
    }
    static Specification<VeWoOpsEquipment> equipmentDateCalibratedIsNotNull() {
        return (veWoOpsEquipment, cq, cb) -> cb.isNotNull(veWoOpsEquipment.get("equipmentDateCalibrated"));
    }
    static Specification<VeWoOpsEquipment> equipmentDateCalibratedEqualTo(Date equipmentDateCalibrated) {
        return (veWoOpsEquipment, cq, cb) -> cb.equal(veWoOpsEquipment.get("equipmentDateCalibrated"), equipmentDateCalibrated);
    }
    static Specification<VeWoOpsEquipment> equipmentDateCalibratedNotEqualTo(Date equipmentDateCalibrated) {
        return (veWoOpsEquipment, cq, cb) -> cb.notEqual(veWoOpsEquipment.get("equipmentDateCalibrated"), equipmentDateCalibrated);
    }
    static Specification<VeWoOpsEquipment> equipmentDateCalibratedBefore(Date equipmentDateCalibrated) {
        return (veWoOpsEquipment, cq, cb) -> cb.lessThan(veWoOpsEquipment.get("equipmentDateCalibrated"), equipmentDateCalibrated);
    }
    static Specification<VeWoOpsEquipment> equipmentDateCalibratedAfter(Date equipmentDateCalibrated) {
        return (veWoOpsEquipment, cq, cb) -> cb.greaterThan(veWoOpsEquipment.get("equipmentDateCalibrated"), equipmentDateCalibrated);
    }
    static Specification<VeWoOpsEquipment> equipmentDateUsedIsNull() {
        return (veWoOpsEquipment, cq, cb) -> cb.isNull(veWoOpsEquipment.get("equipmentDateUsed"));
    }
    static Specification<VeWoOpsEquipment> equipmentDateUsedIsNotNull() {
        return (veWoOpsEquipment, cq, cb) -> cb.isNotNull(veWoOpsEquipment.get("equipmentDateUsed"));
    }
    static Specification<VeWoOpsEquipment> equipmentDateUsedEqualTo(Date equipmentDateUsed) {
        return (veWoOpsEquipment, cq, cb) -> cb.equal(veWoOpsEquipment.get("equipmentDateUsed"), equipmentDateUsed);
    }
    static Specification<VeWoOpsEquipment> equipmentDateUsedNotEqualTo(Date equipmentDateUsed) {
        return (veWoOpsEquipment, cq, cb) -> cb.notEqual(veWoOpsEquipment.get("equipmentDateUsed"), equipmentDateUsed);
    }
    static Specification<VeWoOpsEquipment> equipmentDateUsedBefore(Date equipmentDateUsed) {
        return (veWoOpsEquipment, cq, cb) -> cb.lessThan(veWoOpsEquipment.get("equipmentDateUsed"), equipmentDateUsed);
    }
    static Specification<VeWoOpsEquipment> equipmentDateUsedAfter(Date equipmentDateUsed) {
        return (veWoOpsEquipment, cq, cb) -> cb.greaterThan(veWoOpsEquipment.get("equipmentDateUsed"), equipmentDateUsed);
    }
    static Specification<VeWoOpsEquipment> equipmentDescriptionIsNull() {
        return (veWoOpsEquipment, cq, cb) -> cb.isNull(veWoOpsEquipment.get("equipmentDescription"));
    }
    static Specification<VeWoOpsEquipment> equipmentDescriptionIsNotNull() {
        return (veWoOpsEquipment, cq, cb) -> cb.isNotNull(veWoOpsEquipment.get("equipmentDescription"));
    }
    static Specification<VeWoOpsEquipment> equipmentDescriptionEqualTo(String equipmentDescription) {
        return (veWoOpsEquipment, cq, cb) -> cb.equal(veWoOpsEquipment.get("equipmentDescription"), equipmentDescription);
    }
    static Specification<VeWoOpsEquipment> equipmentDescriptionNotEqualTo(String equipmentDescription) {
        return (veWoOpsEquipment, cq, cb) -> cb.notEqual(veWoOpsEquipment.get("equipmentDescription"), equipmentDescription);
    }
    static Specification<VeWoOpsEquipment> equipmentIDIsNull() {
        return (veWoOpsEquipment, cq, cb) -> cb.isNull(veWoOpsEquipment.get("equipmentID"));
    }
    static Specification<VeWoOpsEquipment> equipmentIDIsNotNull() {
        return (veWoOpsEquipment, cq, cb) -> cb.isNotNull(veWoOpsEquipment.get("equipmentID"));
    }
    static Specification<VeWoOpsEquipment> equipmentIDEqualTo(String equipmentID) {
        return (veWoOpsEquipment, cq, cb) -> cb.equal(veWoOpsEquipment.get("equipmentID"), equipmentID);
    }
    static Specification<VeWoOpsEquipment> equipmentIDNotEqualTo(String equipmentID) {
        return (veWoOpsEquipment, cq, cb) -> cb.notEqual(veWoOpsEquipment.get("equipmentID"), equipmentID);
    }
    static Specification<VeWoOpsEquipment> operationSequenceNumberIsNull() {
        return (veWoOpsEquipment, cq, cb) -> cb.isNull(veWoOpsEquipment.get("operationSequenceNumber"));
    }
    static Specification<VeWoOpsEquipment> operationSequenceNumberIsNotNull() {
        return (veWoOpsEquipment, cq, cb) -> cb.isNotNull(veWoOpsEquipment.get("operationSequenceNumber"));
    }
    static Specification<VeWoOpsEquipment> operationSequenceNumberEqualTo(Double operationSequenceNumber) {
        return (veWoOpsEquipment, cq, cb) -> cb.equal(veWoOpsEquipment.get("operationSequenceNumber"), operationSequenceNumber);
    }
    static Specification<VeWoOpsEquipment> operationSequenceNumberNotEqualTo(Double operationSequenceNumber) {
        return (veWoOpsEquipment, cq, cb) -> cb.notEqual(veWoOpsEquipment.get("operationSequenceNumber"), operationSequenceNumber);
    }
    static Specification<VeWoOpsEquipment> operationSequenceNumberLessThan(Double operationSequenceNumber) {
        return (veWoOpsEquipment, cq, cb) -> cb.lessThan(veWoOpsEquipment.get("operationSequenceNumber"), operationSequenceNumber);
    }
    static Specification<VeWoOpsEquipment> operationSequenceNumberGreaterThan(Double operationSequenceNumber) {
        return (veWoOpsEquipment, cq, cb) -> cb.greaterThan(veWoOpsEquipment.get("operationSequenceNumber"), operationSequenceNumber);
    }
    static Specification<VeWoOpsEquipment> partIDIsNull() {
        return (veWoOpsEquipment, cq, cb) -> cb.isNull(veWoOpsEquipment.get("partID"));
    }
    static Specification<VeWoOpsEquipment> partIDIsNotNull() {
        return (veWoOpsEquipment, cq, cb) -> cb.isNotNull(veWoOpsEquipment.get("partID"));
    }
    static Specification<VeWoOpsEquipment> partIDEqualTo(String partID) {
        return (veWoOpsEquipment, cq, cb) -> cb.equal(veWoOpsEquipment.get("partID"), partID);
    }
    static Specification<VeWoOpsEquipment> partIDNotEqualTo(String partID) {
        return (veWoOpsEquipment, cq, cb) -> cb.notEqual(veWoOpsEquipment.get("partID"), partID);
    }
    static Specification<VeWoOpsEquipment> pieceNumberIsNull() {
        return (veWoOpsEquipment, cq, cb) -> cb.isNull(veWoOpsEquipment.get("pieceNumber"));
    }
    static Specification<VeWoOpsEquipment> pieceNumberIsNotNull() {
        return (veWoOpsEquipment, cq, cb) -> cb.isNotNull(veWoOpsEquipment.get("pieceNumber"));
    }
    static Specification<VeWoOpsEquipment> pieceNumberEqualTo(Double pieceNumber) {
        return (veWoOpsEquipment, cq, cb) -> cb.equal(veWoOpsEquipment.get("pieceNumber"), pieceNumber);
    }
    static Specification<VeWoOpsEquipment> pieceNumberNotEqualTo(Double pieceNumber) {
        return (veWoOpsEquipment, cq, cb) -> cb.notEqual(veWoOpsEquipment.get("pieceNumber"), pieceNumber);
    }
    static Specification<VeWoOpsEquipment> pieceNumberLessThan(Double pieceNumber) {
        return (veWoOpsEquipment, cq, cb) -> cb.lessThan(veWoOpsEquipment.get("pieceNumber"), pieceNumber);
    }
    static Specification<VeWoOpsEquipment> pieceNumberGreaterThan(Double pieceNumber) {
        return (veWoOpsEquipment, cq, cb) -> cb.greaterThan(veWoOpsEquipment.get("pieceNumber"), pieceNumber);
    }
    static Specification<VeWoOpsEquipment> quantityPerIsNull() {
        return (veWoOpsEquipment, cq, cb) -> cb.isNull(veWoOpsEquipment.get("quantityPer"));
    }
    static Specification<VeWoOpsEquipment> quantityPerIsNotNull() {
        return (veWoOpsEquipment, cq, cb) -> cb.isNotNull(veWoOpsEquipment.get("quantityPer"));
    }
    static Specification<VeWoOpsEquipment> quantityPerEqualTo(Double quantityPer) {
        return (veWoOpsEquipment, cq, cb) -> cb.equal(veWoOpsEquipment.get("quantityPer"), quantityPer);
    }
    static Specification<VeWoOpsEquipment> quantityPerNotEqualTo(Double quantityPer) {
        return (veWoOpsEquipment, cq, cb) -> cb.notEqual(veWoOpsEquipment.get("quantityPer"), quantityPer);
    }
    static Specification<VeWoOpsEquipment> quantityPerLessThan(Double quantityPer) {
        return (veWoOpsEquipment, cq, cb) -> cb.lessThan(veWoOpsEquipment.get("quantityPer"), quantityPer);
    }
    static Specification<VeWoOpsEquipment> quantityPerGreaterThan(Double quantityPer) {
        return (veWoOpsEquipment, cq, cb) -> cb.greaterThan(veWoOpsEquipment.get("quantityPer"), quantityPer);
    }
    static Specification<VeWoOpsEquipment> statusIsNull() {
        return (veWoOpsEquipment, cq, cb) -> cb.isNull(veWoOpsEquipment.get("status"));
    }
    static Specification<VeWoOpsEquipment> statusIsNotNull() {
        return (veWoOpsEquipment, cq, cb) -> cb.isNotNull(veWoOpsEquipment.get("status"));
    }
    static Specification<VeWoOpsEquipment> statusEqualTo(String status) {
        return (veWoOpsEquipment, cq, cb) -> cb.equal(veWoOpsEquipment.get("status"), status);
    }
    static Specification<VeWoOpsEquipment> statusNotEqualTo(String status) {
        return (veWoOpsEquipment, cq, cb) -> cb.notEqual(veWoOpsEquipment.get("status"), status);
    }
    static Specification<VeWoOpsEquipment> timestampIsNull() {
        return (veWoOpsEquipment, cq, cb) -> cb.isNull(veWoOpsEquipment.get("timestamp"));
    }
    static Specification<VeWoOpsEquipment> timestampIsNotNull() {
        return (veWoOpsEquipment, cq, cb) -> cb.isNotNull(veWoOpsEquipment.get("timestamp"));
    }
    static Specification<VeWoOpsEquipment> timestampEqualTo(String timestamp) {
        return (veWoOpsEquipment, cq, cb) -> cb.equal(veWoOpsEquipment.get("timestamp"), timestamp);
    }
    static Specification<VeWoOpsEquipment> timestampNotEqualTo(String timestamp) {
        return (veWoOpsEquipment, cq, cb) -> cb.notEqual(veWoOpsEquipment.get("timestamp"), timestamp);
    }
    static Specification<VeWoOpsEquipment> userDefinedField5IsNull() {
        return (veWoOpsEquipment, cq, cb) -> cb.isNull(veWoOpsEquipment.get("userDefinedField5"));
    }
    static Specification<VeWoOpsEquipment> userDefinedField5IsNotNull() {
        return (veWoOpsEquipment, cq, cb) -> cb.isNotNull(veWoOpsEquipment.get("userDefinedField5"));
    }
    static Specification<VeWoOpsEquipment> userDefinedField5EqualTo(String userDefinedField5) {
        return (veWoOpsEquipment, cq, cb) -> cb.equal(veWoOpsEquipment.get("userDefinedField5"), userDefinedField5);
    }
    static Specification<VeWoOpsEquipment> userDefinedField5NotEqualTo(String userDefinedField5) {
        return (veWoOpsEquipment, cq, cb) -> cb.notEqual(veWoOpsEquipment.get("userDefinedField5"), userDefinedField5);
    }
    static Specification<VeWoOpsEquipment> workOrderNumberIsNull() {
        return (veWoOpsEquipment, cq, cb) -> cb.isNull(veWoOpsEquipment.get("workOrderNumber"));
    }
    static Specification<VeWoOpsEquipment> workOrderNumberIsNotNull() {
        return (veWoOpsEquipment, cq, cb) -> cb.isNotNull(veWoOpsEquipment.get("workOrderNumber"));
    }
    static Specification<VeWoOpsEquipment> workOrderNumberEqualTo(String workOrderNumber) {
        return (veWoOpsEquipment, cq, cb) -> cb.equal(veWoOpsEquipment.get("workOrderNumber"), workOrderNumber);
    }
    static Specification<VeWoOpsEquipment> workOrderNumberNotEqualTo(String workOrderNumber) {
        return (veWoOpsEquipment, cq, cb) -> cb.notEqual(veWoOpsEquipment.get("workOrderNumber"), workOrderNumber);
    }
    static Specification<VeWoOpsEquipment> workOrderBaseIDIsNull() {
        return (veWoOpsEquipment, cq, cb) -> cb.isNull(veWoOpsEquipment.get("workOrderBaseID"));
    }
    static Specification<VeWoOpsEquipment> workOrderBaseIDIsNotNull() {
        return (veWoOpsEquipment, cq, cb) -> cb.isNotNull(veWoOpsEquipment.get("workOrderBaseID"));
    }
    static Specification<VeWoOpsEquipment> workOrderBaseIDEqualTo(String workOrderBaseID) {
        return (veWoOpsEquipment, cq, cb) -> cb.equal(veWoOpsEquipment.get("workOrderBaseID"), workOrderBaseID);
    }
    static Specification<VeWoOpsEquipment> workOrderBaseIDNotEqualTo(String workOrderBaseID) {
        return (veWoOpsEquipment, cq, cb) -> cb.notEqual(veWoOpsEquipment.get("workOrderBaseID"), workOrderBaseID);
    }
    static Specification<VeWoOpsEquipment> workOrderLotIDIsNull() {
        return (veWoOpsEquipment, cq, cb) -> cb.isNull(veWoOpsEquipment.get("workOrderLotID"));
    }
    static Specification<VeWoOpsEquipment> workOrderLotIDIsNotNull() {
        return (veWoOpsEquipment, cq, cb) -> cb.isNotNull(veWoOpsEquipment.get("workOrderLotID"));
    }
    static Specification<VeWoOpsEquipment> workOrderLotIDEqualTo(String workOrderLotID) {
        return (veWoOpsEquipment, cq, cb) -> cb.equal(veWoOpsEquipment.get("workOrderLotID"), workOrderLotID);
    }
    static Specification<VeWoOpsEquipment> workOrderLotIDNotEqualTo(String workOrderLotID) {
        return (veWoOpsEquipment, cq, cb) -> cb.notEqual(veWoOpsEquipment.get("workOrderLotID"), workOrderLotID);
    }
    static Specification<VeWoOpsEquipment> workOrderSplitIDIsNull() {
        return (veWoOpsEquipment, cq, cb) -> cb.isNull(veWoOpsEquipment.get("workOrderSplitID"));
    }
    static Specification<VeWoOpsEquipment> workOrderSplitIDIsNotNull() {
        return (veWoOpsEquipment, cq, cb) -> cb.isNotNull(veWoOpsEquipment.get("workOrderSplitID"));
    }
    static Specification<VeWoOpsEquipment> workOrderSplitIDEqualTo(String workOrderSplitID) {
        return (veWoOpsEquipment, cq, cb) -> cb.equal(veWoOpsEquipment.get("workOrderSplitID"), workOrderSplitID);
    }
    static Specification<VeWoOpsEquipment> workOrderSplitIDNotEqualTo(String workOrderSplitID) {
        return (veWoOpsEquipment, cq, cb) -> cb.notEqual(veWoOpsEquipment.get("workOrderSplitID"), workOrderSplitID);
    }
    static Specification<VeWoOpsEquipment> workOrderSubIDIsNull() {
        return (veWoOpsEquipment, cq, cb) -> cb.isNull(veWoOpsEquipment.get("workOrderSubID"));
    }
    static Specification<VeWoOpsEquipment> workOrderSubIDIsNotNull() {
        return (veWoOpsEquipment, cq, cb) -> cb.isNotNull(veWoOpsEquipment.get("workOrderSubID"));
    }
    static Specification<VeWoOpsEquipment> workOrderSubIDEqualTo(String workOrderSubID) {
        return (veWoOpsEquipment, cq, cb) -> cb.equal(veWoOpsEquipment.get("workOrderSubID"), workOrderSubID);
    }
    static Specification<VeWoOpsEquipment> workOrderSubIDNotEqualTo(String workOrderSubID) {
        return (veWoOpsEquipment, cq, cb) -> cb.notEqual(veWoOpsEquipment.get("workOrderSubID"), workOrderSubID);
    }
}
