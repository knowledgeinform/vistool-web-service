package edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.denodo;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.VeMasterWoOps;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Date;

public interface VeMasterWoOpsRepository extends JpaRepository<VeMasterWoOps, Long>, JpaSpecificationExecutor<VeMasterWoOps> {
    static Specification<VeMasterWoOps> actRunHoursIsNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNull(veMasterWoOps.get("actRunHours"));
    }
    static Specification<VeMasterWoOps> actRunHoursIsNotNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNotNull(veMasterWoOps.get("actRunHours"));
    }
    static Specification<VeMasterWoOps> actRunHoursEqualTo(Double actRunHours) {
        return (veMasterWoOps, cq, cb) -> cb.equal(veMasterWoOps.get("actRunHours"), actRunHours);
    }
    static Specification<VeMasterWoOps> actRunHoursNotEqualTo(Double actRunHours) {
        return (veMasterWoOps, cq, cb) -> cb.notEqual(veMasterWoOps.get("actRunHours"), actRunHours);
    }
    static Specification<VeMasterWoOps> actRunHoursLessThan(Double actRunHours) {
        return (veMasterWoOps, cq, cb) -> cb.lessThan(veMasterWoOps.get("actRunHours"), actRunHours);
    }
    static Specification<VeMasterWoOps> actRunHoursGreaterThan(Double actRunHours) {
        return (veMasterWoOps, cq, cb) -> cb.greaterThan(veMasterWoOps.get("actRunHours"), actRunHours);
    }
    static Specification<VeMasterWoOps> actSetupHoursIsNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNull(veMasterWoOps.get("actSetupHours"));
    }
    static Specification<VeMasterWoOps> actSetupHoursIsNotNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNotNull(veMasterWoOps.get("actSetupHours"));
    }
    static Specification<VeMasterWoOps> actSetupHoursEqualTo(Double actSetupHours) {
        return (veMasterWoOps, cq, cb) -> cb.equal(veMasterWoOps.get("actSetupHours"), actSetupHours);
    }
    static Specification<VeMasterWoOps> actSetupHoursNotEqualTo(Double actSetupHours) {
        return (veMasterWoOps, cq, cb) -> cb.notEqual(veMasterWoOps.get("actSetupHours"), actSetupHours);
    }
    static Specification<VeMasterWoOps> actSetupHoursLessThan(Double actSetupHours) {
        return (veMasterWoOps, cq, cb) -> cb.lessThan(veMasterWoOps.get("actSetupHours"), actSetupHours);
    }
    static Specification<VeMasterWoOps> actSetupHoursGreaterThan(Double actSetupHours) {
        return (veMasterWoOps, cq, cb) -> cb.greaterThan(veMasterWoOps.get("actSetupHours"), actSetupHours);
    }
    static Specification<VeMasterWoOps> closeDateIsNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNull(veMasterWoOps.get("closeDate"));
    }
    static Specification<VeMasterWoOps> closeDateIsNotNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNotNull(veMasterWoOps.get("closeDate"));
    }
    static Specification<VeMasterWoOps> closeDateEqualTo(Date closeDate) {
        return (veMasterWoOps, cq, cb) -> cb.equal(veMasterWoOps.get("closeDate"), closeDate);
    }
    static Specification<VeMasterWoOps> closeDateNotEqualTo(Date closeDate) {
        return (veMasterWoOps, cq, cb) -> cb.notEqual(veMasterWoOps.get("closeDate"), closeDate);
    }
    static Specification<VeMasterWoOps> closeDateBefore(Date closeDate) {
        return (veMasterWoOps, cq, cb) -> cb.lessThan(veMasterWoOps.get("closeDate"), closeDate);
    }
    static Specification<VeMasterWoOps> closeDateAfter(Date closeDate) {
        return (veMasterWoOps, cq, cb) -> cb.greaterThan(veMasterWoOps.get("closeDate"), closeDate);
    }
    static Specification<VeMasterWoOps> completedQuantityIsNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNull(veMasterWoOps.get("completedQuantity"));
    }
    static Specification<VeMasterWoOps> completedQuantityIsNotNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNotNull(veMasterWoOps.get("completedQuantity"));
    }
    static Specification<VeMasterWoOps> completedQuantityEqualTo(Double completedQuantity) {
        return (veMasterWoOps, cq, cb) -> cb.equal(veMasterWoOps.get("completedQuantity"), completedQuantity);
    }
    static Specification<VeMasterWoOps> completedQuantityNotEqualTo(Double completedQuantity) {
        return (veMasterWoOps, cq, cb) -> cb.notEqual(veMasterWoOps.get("completedQuantity"), completedQuantity);
    }
    static Specification<VeMasterWoOps> completedQuantityLessThan(Double completedQuantity) {
        return (veMasterWoOps, cq, cb) -> cb.lessThan(veMasterWoOps.get("completedQuantity"), completedQuantity);
    }
    static Specification<VeMasterWoOps> completedQuantityGreaterThan(Double completedQuantity) {
        return (veMasterWoOps, cq, cb) -> cb.greaterThan(veMasterWoOps.get("completedQuantity"), completedQuantity);
    }
    static Specification<VeMasterWoOps> evwpmsIsNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNull(veMasterWoOps.get("evwpms"));
    }
    static Specification<VeMasterWoOps> evwpmsIsNotNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNotNull(veMasterWoOps.get("evwpms"));
    }
    static Specification<VeMasterWoOps> evwpmsEqualTo(String evwpms) {
        return (veMasterWoOps, cq, cb) -> cb.equal(veMasterWoOps.get("evwpms"), evwpms);
    }
    static Specification<VeMasterWoOps> evwpmsNotEqualTo(String evwpms) {
        return (veMasterWoOps, cq, cb) -> cb.notEqual(veMasterWoOps.get("evwpms"), evwpms);
    }
    static Specification<VeMasterWoOps> loadSizeQuantityIsNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNull(veMasterWoOps.get("loadSizeQuantity"));
    }
    static Specification<VeMasterWoOps> loadSizeQuantityIsNotNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNotNull(veMasterWoOps.get("loadSizeQuantity"));
    }
    static Specification<VeMasterWoOps> loadSizeQuantityEqualTo(Double loadSizeQuantity) {
        return (veMasterWoOps, cq, cb) -> cb.equal(veMasterWoOps.get("loadSizeQuantity"), loadSizeQuantity);
    }
    static Specification<VeMasterWoOps> loadSizeQuantityNotEqualTo(Double loadSizeQuantity) {
        return (veMasterWoOps, cq, cb) -> cb.notEqual(veMasterWoOps.get("loadSizeQuantity"), loadSizeQuantity);
    }
    static Specification<VeMasterWoOps> loadSizeQuantityLessThan(Double loadSizeQuantity) {
        return (veMasterWoOps, cq, cb) -> cb.lessThan(veMasterWoOps.get("loadSizeQuantity"), loadSizeQuantity);
    }
    static Specification<VeMasterWoOps> loadSizeQuantityGreaterThan(Double loadSizeQuantity) {
        return (veMasterWoOps, cq, cb) -> cb.greaterThan(veMasterWoOps.get("loadSizeQuantity"), loadSizeQuantity);
    }
    static Specification<VeMasterWoOps> moveHoursIsNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNull(veMasterWoOps.get("moveHours"));
    }
    static Specification<VeMasterWoOps> moveHoursIsNotNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNotNull(veMasterWoOps.get("moveHours"));
    }
    static Specification<VeMasterWoOps> moveHoursEqualTo(Double moveHours) {
        return (veMasterWoOps, cq, cb) -> cb.equal(veMasterWoOps.get("moveHours"), moveHours);
    }
    static Specification<VeMasterWoOps> moveHoursNotEqualTo(Double moveHours) {
        return (veMasterWoOps, cq, cb) -> cb.notEqual(veMasterWoOps.get("moveHours"), moveHours);
    }
    static Specification<VeMasterWoOps> moveHoursLessThan(Double moveHours) {
        return (veMasterWoOps, cq, cb) -> cb.lessThan(veMasterWoOps.get("moveHours"), moveHours);
    }
    static Specification<VeMasterWoOps> moveHoursGreaterThan(Double moveHours) {
        return (veMasterWoOps, cq, cb) -> cb.greaterThan(veMasterWoOps.get("moveHours"), moveHours);
    }
    static Specification<VeMasterWoOps> operationAssigneeIsNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNull(veMasterWoOps.get("operationAssignee"));
    }
    static Specification<VeMasterWoOps> operationAssigneeIsNotNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNotNull(veMasterWoOps.get("operationAssignee"));
    }
    static Specification<VeMasterWoOps> operationAssigneeEqualTo(String operationAssignee) {
        return (veMasterWoOps, cq, cb) -> cb.equal(veMasterWoOps.get("operationAssignee"), operationAssignee);
    }
    static Specification<VeMasterWoOps> operationAssigneeNotEqualTo(String operationAssignee) {
        return (veMasterWoOps, cq, cb) -> cb.notEqual(veMasterWoOps.get("operationAssignee"), operationAssignee);
    }
    static Specification<VeMasterWoOps> operationTypeIsNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNull(veMasterWoOps.get("operationType"));
    }
    static Specification<VeMasterWoOps> operationTypeIsNotNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNotNull(veMasterWoOps.get("operationType"));
    }
    static Specification<VeMasterWoOps> operationTypeEqualTo(String operationType) {
        return (veMasterWoOps, cq, cb) -> cb.equal(veMasterWoOps.get("operationType"), operationType);
    }
    static Specification<VeMasterWoOps> operationTypeNotEqualTo(String operationType) {
        return (veMasterWoOps, cq, cb) -> cb.notEqual(veMasterWoOps.get("operationType"), operationType);
    }
    static Specification<VeMasterWoOps> resourceIDIsNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNull(veMasterWoOps.get("resourceID"));
    }
    static Specification<VeMasterWoOps> resourceIDIsNotNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNotNull(veMasterWoOps.get("resourceID"));
    }
    static Specification<VeMasterWoOps> resourceIDEqualTo(String resourceID) {
        return (veMasterWoOps, cq, cb) -> cb.equal(veMasterWoOps.get("resourceID"), resourceID);
    }
    static Specification<VeMasterWoOps> resourceIDNotEqualTo(String resourceID) {
        return (veMasterWoOps, cq, cb) -> cb.notEqual(veMasterWoOps.get("resourceID"), resourceID);
    }
    static Specification<VeMasterWoOps> runIsNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNull(veMasterWoOps.get("run"));
    }
    static Specification<VeMasterWoOps> runIsNotNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNotNull(veMasterWoOps.get("run"));
    }
    static Specification<VeMasterWoOps> runEqualTo(Double run) {
        return (veMasterWoOps, cq, cb) -> cb.equal(veMasterWoOps.get("run"), run);
    }
    static Specification<VeMasterWoOps> runNotEqualTo(Double run) {
        return (veMasterWoOps, cq, cb) -> cb.notEqual(veMasterWoOps.get("run"), run);
    }
    static Specification<VeMasterWoOps> runLessThan(Double run) {
        return (veMasterWoOps, cq, cb) -> cb.lessThan(veMasterWoOps.get("run"), run);
    }
    static Specification<VeMasterWoOps> runGreaterThan(Double run) {
        return (veMasterWoOps, cq, cb) -> cb.greaterThan(veMasterWoOps.get("run"), run);
    }
    static Specification<VeMasterWoOps> runHoursIsNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNull(veMasterWoOps.get("runHours"));
    }
    static Specification<VeMasterWoOps> runHoursIsNotNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNotNull(veMasterWoOps.get("runHours"));
    }
    static Specification<VeMasterWoOps> runHoursEqualTo(Double runHours) {
        return (veMasterWoOps, cq, cb) -> cb.equal(veMasterWoOps.get("runHours"), runHours);
    }
    static Specification<VeMasterWoOps> runHoursNotEqualTo(Double runHours) {
        return (veMasterWoOps, cq, cb) -> cb.notEqual(veMasterWoOps.get("runHours"), runHours);
    }
    static Specification<VeMasterWoOps> runHoursLessThan(Double runHours) {
        return (veMasterWoOps, cq, cb) -> cb.lessThan(veMasterWoOps.get("runHours"), runHours);
    }
    static Specification<VeMasterWoOps> runHoursGreaterThan(Double runHours) {
        return (veMasterWoOps, cq, cb) -> cb.greaterThan(veMasterWoOps.get("runHours"), runHours);
    }
    static Specification<VeMasterWoOps> runTypeIsNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNull(veMasterWoOps.get("runType"));
    }
    static Specification<VeMasterWoOps> runTypeIsNotNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNotNull(veMasterWoOps.get("runType"));
    }
    static Specification<VeMasterWoOps> runTypeEqualTo(String runType) {
        return (veMasterWoOps, cq, cb) -> cb.equal(veMasterWoOps.get("runType"), runType);
    }
    static Specification<VeMasterWoOps> runTypeNotEqualTo(String runType) {
        return (veMasterWoOps, cq, cb) -> cb.notEqual(veMasterWoOps.get("runType"), runType);
    }
    static Specification<VeMasterWoOps> sequenceNumberIsNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNull(veMasterWoOps.get("sequenceNumber"));
    }
    static Specification<VeMasterWoOps> sequenceNumberIsNotNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNotNull(veMasterWoOps.get("sequenceNumber"));
    }
    static Specification<VeMasterWoOps> sequenceNumberEqualTo(Double sequenceNumber) {
        return (veMasterWoOps, cq, cb) -> cb.equal(veMasterWoOps.get("sequenceNumber"), sequenceNumber);
    }
    static Specification<VeMasterWoOps> sequenceNumberNotEqualTo(Double sequenceNumber) {
        return (veMasterWoOps, cq, cb) -> cb.notEqual(veMasterWoOps.get("sequenceNumber"), sequenceNumber);
    }
    static Specification<VeMasterWoOps> sequenceNumberLessThan(Double sequenceNumber) {
        return (veMasterWoOps, cq, cb) -> cb.lessThan(veMasterWoOps.get("sequenceNumber"), sequenceNumber);
    }
    static Specification<VeMasterWoOps> sequenceNumberGreaterThan(Double sequenceNumber) {
        return (veMasterWoOps, cq, cb) -> cb.greaterThan(veMasterWoOps.get("sequenceNumber"), sequenceNumber);
    }
    static Specification<VeMasterWoOps> setupCompletedIsNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNull(veMasterWoOps.get("setupCompleted"));
    }
    static Specification<VeMasterWoOps> setupCompletedIsNotNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNotNull(veMasterWoOps.get("setupCompleted"));
    }
    static Specification<VeMasterWoOps> setupCompletedEqualTo(String setupCompleted) {
        return (veMasterWoOps, cq, cb) -> cb.equal(veMasterWoOps.get("setupCompleted"), setupCompleted);
    }
    static Specification<VeMasterWoOps> setupCompletedNotEqualTo(String setupCompleted) {
        return (veMasterWoOps, cq, cb) -> cb.notEqual(veMasterWoOps.get("setupCompleted"), setupCompleted);
    }
    static Specification<VeMasterWoOps> setupHoursIsNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNull(veMasterWoOps.get("setupHours"));
    }
    static Specification<VeMasterWoOps> setupHoursIsNotNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNotNull(veMasterWoOps.get("setupHours"));
    }
    static Specification<VeMasterWoOps> setupHoursEqualTo(Double setupHours) {
        return (veMasterWoOps, cq, cb) -> cb.equal(veMasterWoOps.get("setupHours"), setupHours);
    }
    static Specification<VeMasterWoOps> setupHoursNotEqualTo(Double setupHours) {
        return (veMasterWoOps, cq, cb) -> cb.notEqual(veMasterWoOps.get("setupHours"), setupHours);
    }
    static Specification<VeMasterWoOps> setupHoursLessThan(Double setupHours) {
        return (veMasterWoOps, cq, cb) -> cb.lessThan(veMasterWoOps.get("setupHours"), setupHours);
    }
    static Specification<VeMasterWoOps> setupHoursGreaterThan(Double setupHours) {
        return (veMasterWoOps, cq, cb) -> cb.greaterThan(veMasterWoOps.get("setupHours"), setupHours);
    }
    static Specification<VeMasterWoOps> statusIsNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNull(veMasterWoOps.get("status"));
    }
    static Specification<VeMasterWoOps> statusIsNotNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNotNull(veMasterWoOps.get("status"));
    }
    static Specification<VeMasterWoOps> statusEqualTo(String status) {
        return (veMasterWoOps, cq, cb) -> cb.equal(veMasterWoOps.get("status"), status);
    }
    static Specification<VeMasterWoOps> statusNotEqualTo(String status) {
        return (veMasterWoOps, cq, cb) -> cb.notEqual(veMasterWoOps.get("status"), status);
    }
    static Specification<VeMasterWoOps> timestampIsNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNull(veMasterWoOps.get("timestamp"));
    }
    static Specification<VeMasterWoOps> timestampIsNotNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNotNull(veMasterWoOps.get("timestamp"));
    }
    static Specification<VeMasterWoOps> timestampEqualTo(String timestamp) {
        return (veMasterWoOps, cq, cb) -> cb.equal(veMasterWoOps.get("timestamp"), timestamp);
    }
    static Specification<VeMasterWoOps> timestampNotEqualTo(String timestamp) {
        return (veMasterWoOps, cq, cb) -> cb.notEqual(veMasterWoOps.get("timestamp"), timestamp);
    }
    static Specification<VeMasterWoOps> userDefinedField2IsNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNull(veMasterWoOps.get("userDefinedField2"));
    }
    static Specification<VeMasterWoOps> userDefinedField2IsNotNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNotNull(veMasterWoOps.get("userDefinedField2"));
    }
    static Specification<VeMasterWoOps> userDefinedField2EqualTo(String userDefinedField2) {
        return (veMasterWoOps, cq, cb) -> cb.equal(veMasterWoOps.get("userDefinedField2"), userDefinedField2);
    }
    static Specification<VeMasterWoOps> userDefinedField2NotEqualTo(String userDefinedField2) {
        return (veMasterWoOps, cq, cb) -> cb.notEqual(veMasterWoOps.get("userDefinedField2"), userDefinedField2);
    }
    static Specification<VeMasterWoOps> userDefinedField4IsNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNull(veMasterWoOps.get("userDefinedField4"));
    }
    static Specification<VeMasterWoOps> userDefinedField4IsNotNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNotNull(veMasterWoOps.get("userDefinedField4"));
    }
    static Specification<VeMasterWoOps> userDefinedField4EqualTo(String userDefinedField4) {
        return (veMasterWoOps, cq, cb) -> cb.equal(veMasterWoOps.get("userDefinedField4"), userDefinedField4);
    }
    static Specification<VeMasterWoOps> userDefinedField4NotEqualTo(String userDefinedField4) {
        return (veMasterWoOps, cq, cb) -> cb.notEqual(veMasterWoOps.get("userDefinedField4"), userDefinedField4);
    }
    static Specification<VeMasterWoOps> userDefinedField5IsNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNull(veMasterWoOps.get("userDefinedField5"));
    }
    static Specification<VeMasterWoOps> userDefinedField5IsNotNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNotNull(veMasterWoOps.get("userDefinedField5"));
    }
    static Specification<VeMasterWoOps> userDefinedField5EqualTo(String userDefinedField5) {
        return (veMasterWoOps, cq, cb) -> cb.equal(veMasterWoOps.get("userDefinedField5"), userDefinedField5);
    }
    static Specification<VeMasterWoOps> userDefinedField5NotEqualTo(String userDefinedField5) {
        return (veMasterWoOps, cq, cb) -> cb.notEqual(veMasterWoOps.get("userDefinedField5"), userDefinedField5);
    }
    static Specification<VeMasterWoOps> userDefinedField6IsNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNull(veMasterWoOps.get("userDefinedField6"));
    }
    static Specification<VeMasterWoOps> userDefinedField6IsNotNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNotNull(veMasterWoOps.get("userDefinedField6"));
    }
    static Specification<VeMasterWoOps> userDefinedField6EqualTo(String userDefinedField6) {
        return (veMasterWoOps, cq, cb) -> cb.equal(veMasterWoOps.get("userDefinedField6"), userDefinedField6);
    }
    static Specification<VeMasterWoOps> userDefinedField6NotEqualTo(String userDefinedField6) {
        return (veMasterWoOps, cq, cb) -> cb.notEqual(veMasterWoOps.get("userDefinedField6"), userDefinedField6);
    }
    static Specification<VeMasterWoOps> userDefinedField7IsNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNull(veMasterWoOps.get("userDefinedField7"));
    }
    static Specification<VeMasterWoOps> userDefinedField7IsNotNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNotNull(veMasterWoOps.get("userDefinedField7"));
    }
    static Specification<VeMasterWoOps> userDefinedField7EqualTo(String userDefinedField7) {
        return (veMasterWoOps, cq, cb) -> cb.equal(veMasterWoOps.get("userDefinedField7"), userDefinedField7);
    }
    static Specification<VeMasterWoOps> userDefinedField7NotEqualTo(String userDefinedField7) {
        return (veMasterWoOps, cq, cb) -> cb.notEqual(veMasterWoOps.get("userDefinedField7"), userDefinedField7);
    }
    static Specification<VeMasterWoOps> userDefinedField8IsNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNull(veMasterWoOps.get("userDefinedField8"));
    }
    static Specification<VeMasterWoOps> userDefinedField8IsNotNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNotNull(veMasterWoOps.get("userDefinedField8"));
    }
    static Specification<VeMasterWoOps> userDefinedField8EqualTo(String userDefinedField8) {
        return (veMasterWoOps, cq, cb) -> cb.equal(veMasterWoOps.get("userDefinedField8"), userDefinedField8);
    }
    static Specification<VeMasterWoOps> userDefinedField8NotEqualTo(String userDefinedField8) {
        return (veMasterWoOps, cq, cb) -> cb.notEqual(veMasterWoOps.get("userDefinedField8"), userDefinedField8);
    }
    static Specification<VeMasterWoOps> userDefinedField9IsNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNull(veMasterWoOps.get("userDefinedField9"));
    }
    static Specification<VeMasterWoOps> userDefinedField9IsNotNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNotNull(veMasterWoOps.get("userDefinedField9"));
    }
    static Specification<VeMasterWoOps> userDefinedField9EqualTo(String userDefinedField9) {
        return (veMasterWoOps, cq, cb) -> cb.equal(veMasterWoOps.get("userDefinedField9"), userDefinedField9);
    }
    static Specification<VeMasterWoOps> userDefinedField9NotEqualTo(String userDefinedField9) {
        return (veMasterWoOps, cq, cb) -> cb.notEqual(veMasterWoOps.get("userDefinedField9"), userDefinedField9);
    }
    static Specification<VeMasterWoOps> workOrderNumberIsNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNull(veMasterWoOps.get("workOrderNumber"));
    }
    static Specification<VeMasterWoOps> workOrderNumberIsNotNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNotNull(veMasterWoOps.get("workOrderNumber"));
    }
    static Specification<VeMasterWoOps> workOrderNumberEqualTo(String workOrderNumber) {
        return (veMasterWoOps, cq, cb) -> cb.equal(veMasterWoOps.get("workOrderNumber"), workOrderNumber);
    }
    static Specification<VeMasterWoOps> workOrderNumberNotEqualTo(String workOrderNumber) {
        return (veMasterWoOps, cq, cb) -> cb.notEqual(veMasterWoOps.get("workOrderNumber"), workOrderNumber);
    }
    static Specification<VeMasterWoOps> workOrderBaseIDIsNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNull(veMasterWoOps.get("workOrderBaseID"));
    }
    static Specification<VeMasterWoOps> workOrderBaseIDIsNotNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNotNull(veMasterWoOps.get("workOrderBaseID"));
    }
    static Specification<VeMasterWoOps> workOrderBaseIDEqualTo(String workOrderBaseID) {
        return (veMasterWoOps, cq, cb) -> cb.equal(veMasterWoOps.get("workOrderBaseID"), workOrderBaseID);
    }
    static Specification<VeMasterWoOps> workOrderBaseIDNotEqualTo(String workOrderBaseID) {
        return (veMasterWoOps, cq, cb) -> cb.notEqual(veMasterWoOps.get("workOrderBaseID"), workOrderBaseID);
    }
    static Specification<VeMasterWoOps> workOrderLotIDIsNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNull(veMasterWoOps.get("workOrderLotID"));
    }
    static Specification<VeMasterWoOps> workOrderLotIDIsNotNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNotNull(veMasterWoOps.get("workOrderLotID"));
    }
    static Specification<VeMasterWoOps> workOrderLotIDEqualTo(String workOrderLotID) {
        return (veMasterWoOps, cq, cb) -> cb.equal(veMasterWoOps.get("workOrderLotID"), workOrderLotID);
    }
    static Specification<VeMasterWoOps> workOrderLotIDNotEqualTo(String workOrderLotID) {
        return (veMasterWoOps, cq, cb) -> cb.notEqual(veMasterWoOps.get("workOrderLotID"), workOrderLotID);
    }
    static Specification<VeMasterWoOps> workOrderSplitIDIsNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNull(veMasterWoOps.get("workOrderSplitID"));
    }
    static Specification<VeMasterWoOps> workOrderSplitIDIsNotNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNotNull(veMasterWoOps.get("workOrderSplitID"));
    }
    static Specification<VeMasterWoOps> workOrderSplitIDEqualTo(String workOrderSplitID) {
        return (veMasterWoOps, cq, cb) -> cb.equal(veMasterWoOps.get("workOrderSplitID"), workOrderSplitID);
    }
    static Specification<VeMasterWoOps> workOrderSplitIDNotEqualTo(String workOrderSplitID) {
        return (veMasterWoOps, cq, cb) -> cb.notEqual(veMasterWoOps.get("workOrderSplitID"), workOrderSplitID);
    }
    static Specification<VeMasterWoOps> workOrderSubIDIsNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNull(veMasterWoOps.get("workOrderSubID"));
    }
    static Specification<VeMasterWoOps> workOrderSubIDIsNotNull() {
        return (veMasterWoOps, cq, cb) -> cb.isNotNull(veMasterWoOps.get("workOrderSubID"));
    }
    static Specification<VeMasterWoOps> workOrderSubIDEqualTo(String workOrderSubID) {
        return (veMasterWoOps, cq, cb) -> cb.equal(veMasterWoOps.get("workOrderSubID"), workOrderSubID);
    }
    static Specification<VeMasterWoOps> workOrderSubIDNotEqualTo(String workOrderSubID) {
        return (veMasterWoOps, cq, cb) -> cb.notEqual(veMasterWoOps.get("workOrderSubID"), workOrderSubID);
    }
}
