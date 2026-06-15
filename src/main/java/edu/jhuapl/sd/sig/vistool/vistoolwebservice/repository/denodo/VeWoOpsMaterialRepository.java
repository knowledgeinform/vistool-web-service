package edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.denodo;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.VeWoOpsMaterial;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Date;

public interface VeWoOpsMaterialRepository extends JpaRepository<VeWoOpsMaterial, Long>, JpaSpecificationExecutor<VeWoOpsMaterial> {
    static Specification<VeWoOpsMaterial> materialDateUsedIsNull() {
        return (veWoOpsMaterial, cq, cb) -> cb.isNull(veWoOpsMaterial.get("materialDateUsed"));
    }
    static Specification<VeWoOpsMaterial> materialDateUsedIsNotNull() {
        return (veWoOpsMaterial, cq, cb) -> cb.isNotNull(veWoOpsMaterial.get("materialDateUsed"));
    }
    static Specification<VeWoOpsMaterial> materialDateUsedEqualTo(Date materialDateUsed) {
        return (veWoOpsMaterial, cq, cb) -> cb.equal(veWoOpsMaterial.get("materialDateUsed"), materialDateUsed);
    }
    static Specification<VeWoOpsMaterial> materialDateUsedNotEqualTo(Date materialDateUsed) {
        return (veWoOpsMaterial, cq, cb) -> cb.notEqual(veWoOpsMaterial.get("materialDateUsed"), materialDateUsed);
    }
    static Specification<VeWoOpsMaterial> materialDateUsedBefore(Date materialDateUsed) {
        return (veWoOpsMaterial, cq, cb) -> cb.lessThan(veWoOpsMaterial.get("materialDateUsed"), materialDateUsed);
    }
    static Specification<VeWoOpsMaterial> materialDateUsedAfter(Date materialDateUsed) {
        return (veWoOpsMaterial, cq, cb) -> cb.greaterThan(veWoOpsMaterial.get("materialDateUsed"), materialDateUsed);
    }
    static Specification<VeWoOpsMaterial> materialDescriptionIsNull() {
        return (veWoOpsMaterial, cq, cb) -> cb.isNull(veWoOpsMaterial.get("materialDescription"));
    }
    static Specification<VeWoOpsMaterial> materialDescriptionIsNotNull() {
        return (veWoOpsMaterial, cq, cb) -> cb.isNotNull(veWoOpsMaterial.get("materialDescription"));
    }
    static Specification<VeWoOpsMaterial> materialDescriptionEqualTo(String materialDescription) {
        return (veWoOpsMaterial, cq, cb) -> cb.equal(veWoOpsMaterial.get("materialDescription"), materialDescription);
    }
    static Specification<VeWoOpsMaterial> materialDescriptionNotEqualTo(String materialDescription) {
        return (veWoOpsMaterial, cq, cb) -> cb.notEqual(veWoOpsMaterial.get("materialDescription"), materialDescription);
    }
    static Specification<VeWoOpsMaterial> materialIDIsNull() {
        return (veWoOpsMaterial, cq, cb) -> cb.isNull(veWoOpsMaterial.get("materialID"));
    }
    static Specification<VeWoOpsMaterial> materialIDIsNotNull() {
        return (veWoOpsMaterial, cq, cb) -> cb.isNotNull(veWoOpsMaterial.get("materialID"));
    }
    static Specification<VeWoOpsMaterial> materialIDEqualTo(String materialID) {
        return (veWoOpsMaterial, cq, cb) -> cb.equal(veWoOpsMaterial.get("materialID"), materialID);
    }
    static Specification<VeWoOpsMaterial> materialIDNotEqualTo(String materialID) {
        return (veWoOpsMaterial, cq, cb) -> cb.notEqual(veWoOpsMaterial.get("materialID"), materialID);
    }
    static Specification<VeWoOpsMaterial> materialSerialNumberIsNull() {
        return (veWoOpsMaterial, cq, cb) -> cb.isNull(veWoOpsMaterial.get("materialSerialNumber"));
    }
    static Specification<VeWoOpsMaterial> materialSerialNumberIsNotNull() {
        return (veWoOpsMaterial, cq, cb) -> cb.isNotNull(veWoOpsMaterial.get("materialSerialNumber"));
    }
    static Specification<VeWoOpsMaterial> materialSerialNumberEqualTo(String materialSerialNumber) {
        return (veWoOpsMaterial, cq, cb) -> cb.equal(veWoOpsMaterial.get("materialSerialNumber"), materialSerialNumber);
    }
    static Specification<VeWoOpsMaterial> materialSerialNumberNotEqualTo(String materialSerialNumber) {
        return (veWoOpsMaterial, cq, cb) -> cb.notEqual(veWoOpsMaterial.get("materialSerialNumber"), materialSerialNumber);
    }
    static Specification<VeWoOpsMaterial> operationSequenceNumberIsNull() {
        return (veWoOpsMaterial, cq, cb) -> cb.isNull(veWoOpsMaterial.get("operationSequenceNumber"));
    }
    static Specification<VeWoOpsMaterial> operationSequenceNumberIsNotNull() {
        return (veWoOpsMaterial, cq, cb) -> cb.isNotNull(veWoOpsMaterial.get("operationSequenceNumber"));
    }
    static Specification<VeWoOpsMaterial> operationSequenceNumberEqualTo(Double operationSequenceNumber) {
        return (veWoOpsMaterial, cq, cb) -> cb.equal(veWoOpsMaterial.get("operationSequenceNumber"), operationSequenceNumber);
    }
    static Specification<VeWoOpsMaterial> operationSequenceNumberNotEqualTo(Double operationSequenceNumber) {
        return (veWoOpsMaterial, cq, cb) -> cb.notEqual(veWoOpsMaterial.get("operationSequenceNumber"), operationSequenceNumber);
    }
    static Specification<VeWoOpsMaterial> operationSequenceNumberLessThan(Double operationSequenceNumber) {
        return (veWoOpsMaterial, cq, cb) -> cb.lessThan(veWoOpsMaterial.get("operationSequenceNumber"), operationSequenceNumber);
    }
    static Specification<VeWoOpsMaterial> operationSequenceNumberGreaterThan(Double operationSequenceNumber) {
        return (veWoOpsMaterial, cq, cb) -> cb.greaterThan(veWoOpsMaterial.get("operationSequenceNumber"), operationSequenceNumber);
    }
    static Specification<VeWoOpsMaterial> partIDIsNull() {
        return (veWoOpsMaterial, cq, cb) -> cb.isNull(veWoOpsMaterial.get("partID"));
    }
    static Specification<VeWoOpsMaterial> partIDIsNotNull() {
        return (veWoOpsMaterial, cq, cb) -> cb.isNotNull(veWoOpsMaterial.get("partID"));
    }
    static Specification<VeWoOpsMaterial> partIDEqualTo(String partID) {
        return (veWoOpsMaterial, cq, cb) -> cb.equal(veWoOpsMaterial.get("partID"), partID);
    }
    static Specification<VeWoOpsMaterial> partIDNotEqualTo(String partID) {
        return (veWoOpsMaterial, cq, cb) -> cb.notEqual(veWoOpsMaterial.get("partID"), partID);
    }
    static Specification<VeWoOpsMaterial> pieceNumberIsNull() {
        return (veWoOpsMaterial, cq, cb) -> cb.isNull(veWoOpsMaterial.get("pieceNumber"));
    }
    static Specification<VeWoOpsMaterial> pieceNumberIsNotNull() {
        return (veWoOpsMaterial, cq, cb) -> cb.isNotNull(veWoOpsMaterial.get("pieceNumber"));
    }
    static Specification<VeWoOpsMaterial> pieceNumberEqualTo(Double pieceNumber) {
        return (veWoOpsMaterial, cq, cb) -> cb.equal(veWoOpsMaterial.get("pieceNumber"), pieceNumber);
    }
    static Specification<VeWoOpsMaterial> pieceNumberNotEqualTo(Double pieceNumber) {
        return (veWoOpsMaterial, cq, cb) -> cb.notEqual(veWoOpsMaterial.get("pieceNumber"), pieceNumber);
    }
    static Specification<VeWoOpsMaterial> pieceNumberLessThan(Double pieceNumber) {
        return (veWoOpsMaterial, cq, cb) -> cb.lessThan(veWoOpsMaterial.get("pieceNumber"), pieceNumber);
    }
    static Specification<VeWoOpsMaterial> pieceNumberGreaterThan(Double pieceNumber) {
        return (veWoOpsMaterial, cq, cb) -> cb.greaterThan(veWoOpsMaterial.get("pieceNumber"), pieceNumber);
    }
    static Specification<VeWoOpsMaterial> quantityPerIsNull() {
        return (veWoOpsMaterial, cq, cb) -> cb.isNull(veWoOpsMaterial.get("quantityPer"));
    }
    static Specification<VeWoOpsMaterial> quantityPerIsNotNull() {
        return (veWoOpsMaterial, cq, cb) -> cb.isNotNull(veWoOpsMaterial.get("quantityPer"));
    }
    static Specification<VeWoOpsMaterial> quantityPerEqualTo(Double quantityPer) {
        return (veWoOpsMaterial, cq, cb) -> cb.equal(veWoOpsMaterial.get("quantityPer"), quantityPer);
    }
    static Specification<VeWoOpsMaterial> quantityPerNotEqualTo(Double quantityPer) {
        return (veWoOpsMaterial, cq, cb) -> cb.notEqual(veWoOpsMaterial.get("quantityPer"), quantityPer);
    }
    static Specification<VeWoOpsMaterial> quantityPerLessThan(Double quantityPer) {
        return (veWoOpsMaterial, cq, cb) -> cb.lessThan(veWoOpsMaterial.get("quantityPer"), quantityPer);
    }
    static Specification<VeWoOpsMaterial> quantityPerGreaterThan(Double quantityPer) {
        return (veWoOpsMaterial, cq, cb) -> cb.greaterThan(veWoOpsMaterial.get("quantityPer"), quantityPer);
    }
    static Specification<VeWoOpsMaterial> statusIsNull() {
        return (veWoOpsMaterial, cq, cb) -> cb.isNull(veWoOpsMaterial.get("status"));
    }
    static Specification<VeWoOpsMaterial> statusIsNotNull() {
        return (veWoOpsMaterial, cq, cb) -> cb.isNotNull(veWoOpsMaterial.get("status"));
    }
    static Specification<VeWoOpsMaterial> statusEqualTo(String status) {
        return (veWoOpsMaterial, cq, cb) -> cb.equal(veWoOpsMaterial.get("status"), status);
    }
    static Specification<VeWoOpsMaterial> statusNotEqualTo(String status) {
        return (veWoOpsMaterial, cq, cb) -> cb.notEqual(veWoOpsMaterial.get("status"), status);
    }
    static Specification<VeWoOpsMaterial> timestampIsNull() {
        return (veWoOpsMaterial, cq, cb) -> cb.isNull(veWoOpsMaterial.get("timestamp"));
    }
    static Specification<VeWoOpsMaterial> timestampIsNotNull() {
        return (veWoOpsMaterial, cq, cb) -> cb.isNotNull(veWoOpsMaterial.get("timestamp"));
    }
    static Specification<VeWoOpsMaterial> timestampEqualTo(String timestamp) {
        return (veWoOpsMaterial, cq, cb) -> cb.equal(veWoOpsMaterial.get("timestamp"), timestamp);
    }
    static Specification<VeWoOpsMaterial> timestampNotEqualTo(String timestamp) {
        return (veWoOpsMaterial, cq, cb) -> cb.notEqual(veWoOpsMaterial.get("timestamp"), timestamp);
    }
    static Specification<VeWoOpsMaterial> workOrderNumberIsNull() {
        return (veWoOpsMaterial, cq, cb) -> cb.isNull(veWoOpsMaterial.get("workOrderNumber"));
    }
    static Specification<VeWoOpsMaterial> workOrderNumberIsNotNull() {
        return (veWoOpsMaterial, cq, cb) -> cb.isNotNull(veWoOpsMaterial.get("workOrderNumber"));
    }
    static Specification<VeWoOpsMaterial> workOrderNumberEqualTo(String workOrderNumber) {
        return (veWoOpsMaterial, cq, cb) -> cb.equal(veWoOpsMaterial.get("workOrderNumber"), workOrderNumber);
    }
    static Specification<VeWoOpsMaterial> workOrderNumberNotEqualTo(String workOrderNumber) {
        return (veWoOpsMaterial, cq, cb) -> cb.notEqual(veWoOpsMaterial.get("workOrderNumber"), workOrderNumber);
    }
    static Specification<VeWoOpsMaterial> workOrderBaseIDIsNull() {
        return (veWoOpsMaterial, cq, cb) -> cb.isNull(veWoOpsMaterial.get("workOrderBaseID"));
    }
    static Specification<VeWoOpsMaterial> workOrderBaseIDIsNotNull() {
        return (veWoOpsMaterial, cq, cb) -> cb.isNotNull(veWoOpsMaterial.get("workOrderBaseID"));
    }
    static Specification<VeWoOpsMaterial> workOrderBaseIDEqualTo(String workOrderBaseID) {
        return (veWoOpsMaterial, cq, cb) -> cb.equal(veWoOpsMaterial.get("workOrderBaseID"), workOrderBaseID);
    }
    static Specification<VeWoOpsMaterial> workOrderBaseIDNotEqualTo(String workOrderBaseID) {
        return (veWoOpsMaterial, cq, cb) -> cb.notEqual(veWoOpsMaterial.get("workOrderBaseID"), workOrderBaseID);
    }
    static Specification<VeWoOpsMaterial> workOrderLotIDIsNull() {
        return (veWoOpsMaterial, cq, cb) -> cb.isNull(veWoOpsMaterial.get("workOrderLotID"));
    }
    static Specification<VeWoOpsMaterial> workOrderLotIDIsNotNull() {
        return (veWoOpsMaterial, cq, cb) -> cb.isNotNull(veWoOpsMaterial.get("workOrderLotID"));
    }
    static Specification<VeWoOpsMaterial> workOrderLotIDEqualTo(String workOrderLotID) {
        return (veWoOpsMaterial, cq, cb) -> cb.equal(veWoOpsMaterial.get("workOrderLotID"), workOrderLotID);
    }
    static Specification<VeWoOpsMaterial> workOrderLotIDNotEqualTo(String workOrderLotID) {
        return (veWoOpsMaterial, cq, cb) -> cb.notEqual(veWoOpsMaterial.get("workOrderLotID"), workOrderLotID);
    }
    static Specification<VeWoOpsMaterial> workOrderSplitIDIsNull() {
        return (veWoOpsMaterial, cq, cb) -> cb.isNull(veWoOpsMaterial.get("workOrderSplitID"));
    }
    static Specification<VeWoOpsMaterial> workOrderSplitIDIsNotNull() {
        return (veWoOpsMaterial, cq, cb) -> cb.isNotNull(veWoOpsMaterial.get("workOrderSplitID"));
    }
    static Specification<VeWoOpsMaterial> workOrderSplitIDEqualTo(String workOrderSplitID) {
        return (veWoOpsMaterial, cq, cb) -> cb.equal(veWoOpsMaterial.get("workOrderSplitID"), workOrderSplitID);
    }
    static Specification<VeWoOpsMaterial> workOrderSplitIDNotEqualTo(String workOrderSplitID) {
        return (veWoOpsMaterial, cq, cb) -> cb.notEqual(veWoOpsMaterial.get("workOrderSplitID"), workOrderSplitID);
    }
    static Specification<VeWoOpsMaterial> workOrderSubIDIsNull() {
        return (veWoOpsMaterial, cq, cb) -> cb.isNull(veWoOpsMaterial.get("workOrderSubID"));
    }
    static Specification<VeWoOpsMaterial> workOrderSubIDIsNotNull() {
        return (veWoOpsMaterial, cq, cb) -> cb.isNotNull(veWoOpsMaterial.get("workOrderSubID"));
    }
    static Specification<VeWoOpsMaterial> workOrderSubIDEqualTo(String workOrderSubID) {
        return (veWoOpsMaterial, cq, cb) -> cb.equal(veWoOpsMaterial.get("workOrderSubID"), workOrderSubID);
    }
    static Specification<VeWoOpsMaterial> workOrderSubIDNotEqualTo(String workOrderSubID) {
        return (veWoOpsMaterial, cq, cb) -> cb.notEqual(veWoOpsMaterial.get("workOrderSubID"), workOrderSubID);
    }
}
