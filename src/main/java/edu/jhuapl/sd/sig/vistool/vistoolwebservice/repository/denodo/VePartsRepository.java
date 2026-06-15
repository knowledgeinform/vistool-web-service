package edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.denodo;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.VeParts;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Date;

public interface VePartsRepository extends JpaRepository<VeParts, Long>, JpaSpecificationExecutor<VeParts> {
    static Specification<VeParts> attributesIsNull() {
        return (veParts, cq, cb) -> cb.isNull(veParts.get("attributes"));
    }
    static Specification<VeParts> attributesIsNotNull() {
        return (veParts, cq, cb) -> cb.isNotNull(veParts.get("attributes"));
    }
    static Specification<VeParts> attributesEqualTo(String attributes) {
        return (veParts, cq, cb) -> cb.equal(veParts.get("attributes"), attributes);
    }
    static Specification<VeParts> attributesNotEqualTo(String attributes) {
        return (veParts, cq, cb) -> cb.notEqual(veParts.get("attributes"), attributes);
    }
    static Specification<VeParts> buyerUserIDIsNull() {
        return (veParts, cq, cb) -> cb.isNull(veParts.get("buyerUserID"));
    }
    static Specification<VeParts> buyerUserIDIsNotNull() {
        return (veParts, cq, cb) -> cb.isNotNull(veParts.get("buyerUserID"));
    }
    static Specification<VeParts> buyerUserIDEqualTo(String buyerUserID) {
        return (veParts, cq, cb) -> cb.equal(veParts.get("buyerUserID"), buyerUserID);
    }
    static Specification<VeParts> buyerUserIDNotEqualTo(String buyerUserID) {
        return (veParts, cq, cb) -> cb.notEqual(veParts.get("buyerUserID"), buyerUserID);
    }
    static Specification<VeParts> commodityCodeIsNull() {
        return (veParts, cq, cb) -> cb.isNull(veParts.get("commodityCode"));
    }
    static Specification<VeParts> commodityCodeIsNotNull() {
        return (veParts, cq, cb) -> cb.isNotNull(veParts.get("commodityCode"));
    }
    static Specification<VeParts> commodityCodeEqualTo(String commodityCode) {
        return (veParts, cq, cb) -> cb.equal(veParts.get("commodityCode"), commodityCode);
    }
    static Specification<VeParts> commodityCodeNotEqualTo(String commodityCode) {
        return (veParts, cq, cb) -> cb.notEqual(veParts.get("commodityCode"), commodityCode);
    }
    static Specification<VeParts> configLevelIsNull() {
        return (veParts, cq, cb) -> cb.isNull(veParts.get("configLevel"));
    }
    static Specification<VeParts> configLevelIsNotNull() {
        return (veParts, cq, cb) -> cb.isNotNull(veParts.get("configLevel"));
    }
    static Specification<VeParts> configLevelEqualTo(String configLevel) {
        return (veParts, cq, cb) -> cb.equal(veParts.get("configLevel"), configLevel);
    }
    static Specification<VeParts> configLevelNotEqualTo(String configLevel) {
        return (veParts, cq, cb) -> cb.notEqual(veParts.get("configLevel"), configLevel);
    }
    static Specification<VeParts> createDateIsNull() {
        return (veParts, cq, cb) -> cb.isNull(veParts.get("createDate"));
    }
    static Specification<VeParts> createDateIsNotNull() {
        return (veParts, cq, cb) -> cb.isNotNull(veParts.get("createDate"));
    }
    static Specification<VeParts> createDateEqualTo(Date createDate) {
        return (veParts, cq, cb) -> cb.equal(veParts.get("createDate"), createDate);
    }
    static Specification<VeParts> createDateNotEqualTo(Date createDate) {
        return (veParts, cq, cb) -> cb.notEqual(veParts.get("createDate"), createDate);
    }
    static Specification<VeParts> createDateBefore(Date createDate) {
        return (veParts, cq, cb) -> cb.lessThan(veParts.get("createDate"), createDate);
    }
    static Specification<VeParts> createDateAfter(Date createDate) {
        return (veParts, cq, cb) -> cb.greaterThan(veParts.get("createDate"), createDate);
    }
    static Specification<VeParts> descriptionIsNull() {
        return (veParts, cq, cb) -> cb.isNull(veParts.get("description"));
    }
    static Specification<VeParts> descriptionIsNotNull() {
        return (veParts, cq, cb) -> cb.isNotNull(veParts.get("description"));
    }
    static Specification<VeParts> descriptionEqualTo(String description) {
        return (veParts, cq, cb) -> cb.equal(veParts.get("description"), description);
    }
    static Specification<VeParts> descriptionNotEqualTo(String description) {
        return (veParts, cq, cb) -> cb.notEqual(veParts.get("description"), description);
    }
    static Specification<VeParts> drawingIDIsNull() {
        return (veParts, cq, cb) -> cb.isNull(veParts.get("drawingID"));
    }
    static Specification<VeParts> drawingIDIsNotNull() {
        return (veParts, cq, cb) -> cb.isNotNull(veParts.get("drawingID"));
    }
    static Specification<VeParts> drawingIDEqualTo(String drawingID) {
        return (veParts, cq, cb) -> cb.equal(veParts.get("drawingID"), drawingID);
    }
    static Specification<VeParts> drawingIDNotEqualTo(String drawingID) {
        return (veParts, cq, cb) -> cb.notEqual(veParts.get("drawingID"), drawingID);
    }
    static Specification<VeParts> esdClassIsNull() {
        return (veParts, cq, cb) -> cb.isNull(veParts.get("esdClass"));
    }
    static Specification<VeParts> esdClassIsNotNull() {
        return (veParts, cq, cb) -> cb.isNotNull(veParts.get("esdClass"));
    }
    static Specification<VeParts> esdClassEqualTo(String esdClass) {
        return (veParts, cq, cb) -> cb.equal(veParts.get("esdClass"), esdClass);
    }
    static Specification<VeParts> esdClassNotEqualTo(String esdClass) {
        return (veParts, cq, cb) -> cb.notEqual(veParts.get("esdClass"), esdClass);
    }
    static Specification<VeParts> extendedDescriptionIsNull() {
        return (veParts, cq, cb) -> cb.isNull(veParts.get("extendedDescription"));
    }
    static Specification<VeParts> extendedDescriptionIsNotNull() {
        return (veParts, cq, cb) -> cb.isNotNull(veParts.get("extendedDescription"));
    }
    static Specification<VeParts> extendedDescriptionEqualTo(String extendedDescription) {
        return (veParts, cq, cb) -> cb.equal(veParts.get("extendedDescription"), extendedDescription);
    }
    static Specification<VeParts> extendedDescriptionNotEqualTo(String extendedDescription) {
        return (veParts, cq, cb) -> cb.notEqual(veParts.get("extendedDescription"), extendedDescription);
    }
    static Specification<VeParts> fabricatedIsNull() {
        return (veParts, cq, cb) -> cb.isNull(veParts.get("fabricated"));
    }
    static Specification<VeParts> fabricatedIsNotNull() {
        return (veParts, cq, cb) -> cb.isNotNull(veParts.get("fabricated"));
    }
    static Specification<VeParts> fabricatedEqualTo(String fabricated) {
        return (veParts, cq, cb) -> cb.equal(veParts.get("fabricated"), fabricated);
    }
    static Specification<VeParts> fabricatedNotEqualTo(String fabricated) {
        return (veParts, cq, cb) -> cb.notEqual(veParts.get("fabricated"), fabricated);
    }
    static Specification<VeParts> gpnIsNull() {
        return (veParts, cq, cb) -> cb.isNull(veParts.get("gpn"));
    }
    static Specification<VeParts> gpnIsNotNull() {
        return (veParts, cq, cb) -> cb.isNotNull(veParts.get("gpn"));
    }
    static Specification<VeParts> gpnEqualTo(String gpn) {
        return (veParts, cq, cb) -> cb.equal(veParts.get("gpn"), gpn);
    }
    static Specification<VeParts> gpnNotEqualTo(String gpn) {
        return (veParts, cq, cb) -> cb.notEqual(veParts.get("gpn"), gpn);
    }
    static Specification<VeParts> gradeIsNull() {
        return (veParts, cq, cb) -> cb.isNull(veParts.get("grade"));
    }
    static Specification<VeParts> gradeIsNotNull() {
        return (veParts, cq, cb) -> cb.isNotNull(veParts.get("grade"));
    }
    static Specification<VeParts> gradeEqualTo(String grade) {
        return (veParts, cq, cb) -> cb.equal(veParts.get("grade"), grade);
    }
    static Specification<VeParts> gradeNotEqualTo(String grade) {
        return (veParts, cq, cb) -> cb.notEqual(veParts.get("grade"), grade);
    }
    static Specification<VeParts> idIsNull() {
        return (veParts, cq, cb) -> cb.isNull(veParts.get("id"));
    }
    static Specification<VeParts> idIsNotNull() {
        return (veParts, cq, cb) -> cb.isNotNull(veParts.get("id"));
    }
    static Specification<VeParts> idEqualTo(String id) {
        return (veParts, cq, cb) -> cb.equal(veParts.get("id"), id);
    }
    static Specification<VeParts> idNotEqualTo(String id) {
        return (veParts, cq, cb) -> cb.notEqual(veParts.get("id"), id);
    }
    static Specification<VeParts> leadEngineerIsNull() {
        return (veParts, cq, cb) -> cb.isNull(veParts.get("leadEngineer"));
    }
    static Specification<VeParts> leadEngineerIsNotNull() {
        return (veParts, cq, cb) -> cb.isNotNull(veParts.get("leadEngineer"));
    }
    static Specification<VeParts> leadEngineerEqualTo(String leadEngineer) {
        return (veParts, cq, cb) -> cb.equal(veParts.get("leadEngineer"), leadEngineer);
    }
    static Specification<VeParts> leadEngineerNotEqualTo(String leadEngineer) {
        return (veParts, cq, cb) -> cb.notEqual(veParts.get("leadEngineer"), leadEngineer);
    }
    static Specification<VeParts> maximumOrderQuantityIsNull() {
        return (veParts, cq, cb) -> cb.isNull(veParts.get("maximumOrderQuantity"));
    }
    static Specification<VeParts> maximumOrderQuantityIsNotNull() {
        return (veParts, cq, cb) -> cb.isNotNull(veParts.get("maximumOrderQuantity"));
    }
    static Specification<VeParts> maximumOrderQuantityEqualTo(Double maximumOrderQuantity) {
        return (veParts, cq, cb) -> cb.equal(veParts.get("maximumOrderQuantity"), maximumOrderQuantity);
    }
    static Specification<VeParts> maximumOrderQuantityNotEqualTo(Double maximumOrderQuantity) {
        return (veParts, cq, cb) -> cb.notEqual(veParts.get("maximumOrderQuantity"), maximumOrderQuantity);
    }
    static Specification<VeParts> maximumOrderQuantityLessThan(Double maximumOrderQuantity) {
        return (veParts, cq, cb) -> cb.lessThan(veParts.get("maximumOrderQuantity"), maximumOrderQuantity);
    }
    static Specification<VeParts> maximumOrderQuantityGreaterThan(Double maximumOrderQuantity) {
        return (veParts, cq, cb) -> cb.greaterThan(veParts.get("maximumOrderQuantity"), maximumOrderQuantity);
    }
    static Specification<VeParts> manufacturerNameIsNull() {
        return (veParts, cq, cb) -> cb.isNull(veParts.get("manufacturerName"));
    }
    static Specification<VeParts> manufacturerNameIsNotNull() {
        return (veParts, cq, cb) -> cb.isNotNull(veParts.get("manufacturerName"));
    }
    static Specification<VeParts> manufacturerNameEqualTo(String manufacturerName) {
        return (veParts, cq, cb) -> cb.equal(veParts.get("manufacturerName"), manufacturerName);
    }
    static Specification<VeParts> manufacturerNameNotEqualTo(String manufacturerName) {
        return (veParts, cq, cb) -> cb.notEqual(veParts.get("manufacturerName"), manufacturerName);
    }
    static Specification<VeParts> manufacturerPartIDIsNull() {
        return (veParts, cq, cb) -> cb.isNull(veParts.get("manufacturerPartID"));
    }
    static Specification<VeParts> manufacturerPartIDIsNotNull() {
        return (veParts, cq, cb) -> cb.isNotNull(veParts.get("manufacturerPartID"));
    }
    static Specification<VeParts> manufacturerPartIDEqualTo(String manufacturerPartID) {
        return (veParts, cq, cb) -> cb.equal(veParts.get("manufacturerPartID"), manufacturerPartID);
    }
    static Specification<VeParts> manufacturerPartIDNotEqualTo(String manufacturerPartID) {
        return (veParts, cq, cb) -> cb.notEqual(veParts.get("manufacturerPartID"), manufacturerPartID);
    }
    static Specification<VeParts> minimumOrderQuantityIsNull() {
        return (veParts, cq, cb) -> cb.isNull(veParts.get("minimumOrderQuantity"));
    }
    static Specification<VeParts> minimumOrderQuantityIsNotNull() {
        return (veParts, cq, cb) -> cb.isNotNull(veParts.get("minimumOrderQuantity"));
    }
    static Specification<VeParts> minimumOrderQuantityEqualTo(Double minimumOrderQuantity) {
        return (veParts, cq, cb) -> cb.equal(veParts.get("minimumOrderQuantity"), minimumOrderQuantity);
    }
    static Specification<VeParts> minimumOrderQuantityNotEqualTo(Double minimumOrderQuantity) {
        return (veParts, cq, cb) -> cb.notEqual(veParts.get("minimumOrderQuantity"), minimumOrderQuantity);
    }
    static Specification<VeParts> minimumOrderQuantityLessThan(Double minimumOrderQuantity) {
        return (veParts, cq, cb) -> cb.lessThan(veParts.get("minimumOrderQuantity"), minimumOrderQuantity);
    }
    static Specification<VeParts> minimumOrderQuantityGreaterThan(Double minimumOrderQuantity) {
        return (veParts, cq, cb) -> cb.greaterThan(veParts.get("minimumOrderQuantity"), minimumOrderQuantity);
    }
    static Specification<VeParts> modifyDateIsNull() {
        return (veParts, cq, cb) -> cb.isNull(veParts.get("modifyDate"));
    }
    static Specification<VeParts> modifyDateIsNotNull() {
        return (veParts, cq, cb) -> cb.isNotNull(veParts.get("modifyDate"));
    }
    static Specification<VeParts> modifyDateEqualTo(Date modifyDate) {
        return (veParts, cq, cb) -> cb.equal(veParts.get("modifyDate"), modifyDate);
    }
    static Specification<VeParts> modifyDateNotEqualTo(Date modifyDate) {
        return (veParts, cq, cb) -> cb.notEqual(veParts.get("modifyDate"), modifyDate);
    }
    static Specification<VeParts> modifyDateBefore(Date modifyDate) {
        return (veParts, cq, cb) -> cb.lessThan(veParts.get("modifyDate"), modifyDate);
    }
    static Specification<VeParts> modifyDateAfter(Date modifyDate) {
        return (veParts, cq, cb) -> cb.greaterThan(veParts.get("modifyDate"), modifyDate);
    }
    static Specification<VeParts> mrpExceptionsIsNull() {
        return (veParts, cq, cb) -> cb.isNull(veParts.get("mrpExceptions"));
    }
    static Specification<VeParts> mrpExceptionsIsNotNull() {
        return (veParts, cq, cb) -> cb.isNotNull(veParts.get("mrpExceptions"));
    }
    static Specification<VeParts> mrpExceptionsEqualTo(String mrpExceptions) {
        return (veParts, cq, cb) -> cb.equal(veParts.get("mrpExceptions"), mrpExceptions);
    }
    static Specification<VeParts> mrpExceptionsNotEqualTo(String mrpExceptions) {
        return (veParts, cq, cb) -> cb.notEqual(veParts.get("mrpExceptions"), mrpExceptions);
    }
    static Specification<VeParts> mrpRequiredIsNull() {
        return (veParts, cq, cb) -> cb.isNull(veParts.get("mrpRequired"));
    }
    static Specification<VeParts> mrpRequiredIsNotNull() {
        return (veParts, cq, cb) -> cb.isNotNull(veParts.get("mrpRequired"));
    }
    static Specification<VeParts> mrpRequiredEqualTo(String mrpRequired) {
        return (veParts, cq, cb) -> cb.equal(veParts.get("mrpRequired"), mrpRequired);
    }
    static Specification<VeParts> mrpRequiredNotEqualTo(String mrpRequired) {
        return (veParts, cq, cb) -> cb.notEqual(veParts.get("mrpRequired"), mrpRequired);
    }
    static Specification<VeParts> nmfcCodeIdIsNull() {
        return (veParts, cq, cb) -> cb.isNull(veParts.get("nmfcCodeId"));
    }
    static Specification<VeParts> nmfcCodeIdIsNotNull() {
        return (veParts, cq, cb) -> cb.isNotNull(veParts.get("nmfcCodeId"));
    }
    static Specification<VeParts> nmfcCodeIdEqualTo(String nmfcCodeId) {
        return (veParts, cq, cb) -> cb.equal(veParts.get("nmfcCodeId"), nmfcCodeId);
    }
    static Specification<VeParts> nmfcCodeIdNotEqualTo(String nmfcCodeId) {
        return (veParts, cq, cb) -> cb.notEqual(veParts.get("nmfcCodeId"), nmfcCodeId);
    }
    static Specification<VeParts> packageTypeIsNull() {
        return (veParts, cq, cb) -> cb.isNull(veParts.get("packageType"));
    }
    static Specification<VeParts> packageTypeIsNotNull() {
        return (veParts, cq, cb) -> cb.isNotNull(veParts.get("packageType"));
    }
    static Specification<VeParts> packageTypeEqualTo(String packageType) {
        return (veParts, cq, cb) -> cb.equal(veParts.get("packageType"), packageType);
    }
    static Specification<VeParts> packageTypeNotEqualTo(String packageType) {
        return (veParts, cq, cb) -> cb.notEqual(veParts.get("packageType"), packageType);
    }
    static Specification<VeParts> plannerUserIDIsNull() {
        return (veParts, cq, cb) -> cb.isNull(veParts.get("plannerUserID"));
    }
    static Specification<VeParts> plannerUserIDIsNotNull() {
        return (veParts, cq, cb) -> cb.isNotNull(veParts.get("plannerUserID"));
    }
    static Specification<VeParts> plannerUserIDEqualTo(String plannerUserID) {
        return (veParts, cq, cb) -> cb.equal(veParts.get("plannerUserID"), plannerUserID);
    }
    static Specification<VeParts> plannerUserIDNotEqualTo(String plannerUserID) {
        return (veParts, cq, cb) -> cb.notEqual(veParts.get("plannerUserID"), plannerUserID);
    }
    static Specification<VeParts> planningLeadTimeIsNull() {
        return (veParts, cq, cb) -> cb.isNull(veParts.get("planningLeadTime"));
    }
    static Specification<VeParts> planningLeadTimeIsNotNull() {
        return (veParts, cq, cb) -> cb.isNotNull(veParts.get("planningLeadTime"));
    }
    static Specification<VeParts> planningLeadTimeEqualTo(Double planningLeadTime) {
        return (veParts, cq, cb) -> cb.equal(veParts.get("planningLeadTime"), planningLeadTime);
    }
    static Specification<VeParts> planningLeadTimeNotEqualTo(Double planningLeadTime) {
        return (veParts, cq, cb) -> cb.notEqual(veParts.get("planningLeadTime"), planningLeadTime);
    }
    static Specification<VeParts> planningLeadTimeLessThan(Double planningLeadTime) {
        return (veParts, cq, cb) -> cb.lessThan(veParts.get("planningLeadTime"), planningLeadTime);
    }
    static Specification<VeParts> planningLeadTimeGreaterThan(Double planningLeadTime) {
        return (veParts, cq, cb) -> cb.greaterThan(veParts.get("planningLeadTime"), planningLeadTime);
    }
    static Specification<VeParts> productCodeIsNull() {
        return (veParts, cq, cb) -> cb.isNull(veParts.get("productCode"));
    }
    static Specification<VeParts> productCodeIsNotNull() {
        return (veParts, cq, cb) -> cb.isNotNull(veParts.get("productCode"));
    }
    static Specification<VeParts> productCodeEqualTo(String productCode) {
        return (veParts, cq, cb) -> cb.equal(veParts.get("productCode"), productCode);
    }
    static Specification<VeParts> productCodeNotEqualTo(String productCode) {
        return (veParts, cq, cb) -> cb.notEqual(veParts.get("productCode"), productCode);
    }
    static Specification<VeParts> purchasedIsNull() {
        return (veParts, cq, cb) -> cb.isNull(veParts.get("purchased"));
    }
    static Specification<VeParts> purchasedIsNotNull() {
        return (veParts, cq, cb) -> cb.isNotNull(veParts.get("purchased"));
    }
    static Specification<VeParts> purchasedEqualTo(String purchased) {
        return (veParts, cq, cb) -> cb.equal(veParts.get("purchased"), purchased);
    }
    static Specification<VeParts> purchasedNotEqualTo(String purchased) {
        return (veParts, cq, cb) -> cb.notEqual(veParts.get("purchased"), purchased);
    }
    static Specification<VeParts> quantityAvaliableISSIsNull() {
        return (veParts, cq, cb) -> cb.isNull(veParts.get("quantityAvaliableISS"));
    }
    static Specification<VeParts> quantityAvaliableISSIsNotNull() {
        return (veParts, cq, cb) -> cb.isNotNull(veParts.get("quantityAvaliableISS"));
    }
    static Specification<VeParts> quantityAvaliableISSEqualTo(Double quantityAvaliableISS) {
        return (veParts, cq, cb) -> cb.equal(veParts.get("quantityAvaliableISS"), quantityAvaliableISS);
    }
    static Specification<VeParts> quantityAvaliableISSNotEqualTo(Double quantityAvaliableISS) {
        return (veParts, cq, cb) -> cb.notEqual(veParts.get("quantityAvaliableISS"), quantityAvaliableISS);
    }
    static Specification<VeParts> quantityAvaliableISSLessThan(Double quantityAvaliableISS) {
        return (veParts, cq, cb) -> cb.lessThan(veParts.get("quantityAvaliableISS"), quantityAvaliableISS);
    }
    static Specification<VeParts> quantityAvaliableISSGreaterThan(Double quantityAvaliableISS) {
        return (veParts, cq, cb) -> cb.greaterThan(veParts.get("quantityAvaliableISS"), quantityAvaliableISS);
    }
    static Specification<VeParts> quantityAvaliableMRPIsNull() {
        return (veParts, cq, cb) -> cb.isNull(veParts.get("quantityAvaliableMRP"));
    }
    static Specification<VeParts> quantityAvaliableMRPIsNotNull() {
        return (veParts, cq, cb) -> cb.isNotNull(veParts.get("quantityAvaliableMRP"));
    }
    static Specification<VeParts> quantityAvaliableMRPEqualTo(Double quantityAvaliableMRP) {
        return (veParts, cq, cb) -> cb.equal(veParts.get("quantityAvaliableMRP"), quantityAvaliableMRP);
    }
    static Specification<VeParts> quantityAvaliableMRPNotEqualTo(Double quantityAvaliableMRP) {
        return (veParts, cq, cb) -> cb.notEqual(veParts.get("quantityAvaliableMRP"), quantityAvaliableMRP);
    }
    static Specification<VeParts> quantityAvaliableMRPLessThan(Double quantityAvaliableMRP) {
        return (veParts, cq, cb) -> cb.lessThan(veParts.get("quantityAvaliableMRP"), quantityAvaliableMRP);
    }
    static Specification<VeParts> quantityAvaliableMRPGreaterThan(Double quantityAvaliableMRP) {
        return (veParts, cq, cb) -> cb.greaterThan(veParts.get("quantityAvaliableMRP"), quantityAvaliableMRP);
    }
    static Specification<VeParts> quantityInDemandIsNull() {
        return (veParts, cq, cb) -> cb.isNull(veParts.get("quantityInDemand"));
    }
    static Specification<VeParts> quantityInDemandIsNotNull() {
        return (veParts, cq, cb) -> cb.isNotNull(veParts.get("quantityInDemand"));
    }
    static Specification<VeParts> quantityInDemandEqualTo(Double quantityInDemand) {
        return (veParts, cq, cb) -> cb.equal(veParts.get("quantityInDemand"), quantityInDemand);
    }
    static Specification<VeParts> quantityInDemandNotEqualTo(Double quantityInDemand) {
        return (veParts, cq, cb) -> cb.notEqual(veParts.get("quantityInDemand"), quantityInDemand);
    }
    static Specification<VeParts> quantityInDemandLessThan(Double quantityInDemand) {
        return (veParts, cq, cb) -> cb.lessThan(veParts.get("quantityInDemand"), quantityInDemand);
    }
    static Specification<VeParts> quantityInDemandGreaterThan(Double quantityInDemand) {
        return (veParts, cq, cb) -> cb.greaterThan(veParts.get("quantityInDemand"), quantityInDemand);
    }
    static Specification<VeParts> quantityOnHandIsNull() {
        return (veParts, cq, cb) -> cb.isNull(veParts.get("quantityOnHand"));
    }
    static Specification<VeParts> quantityOnHandIsNotNull() {
        return (veParts, cq, cb) -> cb.isNotNull(veParts.get("quantityOnHand"));
    }
    static Specification<VeParts> quantityOnHandEqualTo(Double quantityOnHand) {
        return (veParts, cq, cb) -> cb.equal(veParts.get("quantityOnHand"), quantityOnHand);
    }
    static Specification<VeParts> quantityOnHandNotEqualTo(Double quantityOnHand) {
        return (veParts, cq, cb) -> cb.notEqual(veParts.get("quantityOnHand"), quantityOnHand);
    }
    static Specification<VeParts> quantityOnHandLessThan(Double quantityOnHand) {
        return (veParts, cq, cb) -> cb.lessThan(veParts.get("quantityOnHand"), quantityOnHand);
    }
    static Specification<VeParts> quantityOnHandGreaterThan(Double quantityOnHand) {
        return (veParts, cq, cb) -> cb.greaterThan(veParts.get("quantityOnHand"), quantityOnHand);
    }
    static Specification<VeParts> quantityOnOrderIsNull() {
        return (veParts, cq, cb) -> cb.isNull(veParts.get("quantityOnOrder"));
    }
    static Specification<VeParts> quantityOnOrderIsNotNull() {
        return (veParts, cq, cb) -> cb.isNotNull(veParts.get("quantityOnOrder"));
    }
    static Specification<VeParts> quantityOnOrderEqualTo(Double quantityOnOrder) {
        return (veParts, cq, cb) -> cb.equal(veParts.get("quantityOnOrder"), quantityOnOrder);
    }
    static Specification<VeParts> quantityOnOrderNotEqualTo(Double quantityOnOrder) {
        return (veParts, cq, cb) -> cb.notEqual(veParts.get("quantityOnOrder"), quantityOnOrder);
    }
    static Specification<VeParts> quantityOnOrderLessThan(Double quantityOnOrder) {
        return (veParts, cq, cb) -> cb.lessThan(veParts.get("quantityOnOrder"), quantityOnOrder);
    }
    static Specification<VeParts> quantityOnOrderGreaterThan(Double quantityOnOrder) {
        return (veParts, cq, cb) -> cb.greaterThan(veParts.get("quantityOnOrder"), quantityOnOrder);
    }
    static Specification<VeParts> safetyStockQtyIsNull() {
        return (veParts, cq, cb) -> cb.isNull(veParts.get("safetyStockQty"));
    }
    static Specification<VeParts> safetyStockQtyIsNotNull() {
        return (veParts, cq, cb) -> cb.isNotNull(veParts.get("safetyStockQty"));
    }
    static Specification<VeParts> safetyStockQtyEqualTo(Double safetyStockQty) {
        return (veParts, cq, cb) -> cb.equal(veParts.get("safetyStockQty"), safetyStockQty);
    }
    static Specification<VeParts> safetyStockQtyNotEqualTo(Double safetyStockQty) {
        return (veParts, cq, cb) -> cb.notEqual(veParts.get("safetyStockQty"), safetyStockQty);
    }
    static Specification<VeParts> safetyStockQtyLessThan(Double safetyStockQty) {
        return (veParts, cq, cb) -> cb.lessThan(veParts.get("safetyStockQty"), safetyStockQty);
    }
    static Specification<VeParts> safetyStockQtyGreaterThan(Double safetyStockQty) {
        return (veParts, cq, cb) -> cb.greaterThan(veParts.get("safetyStockQty"), safetyStockQty);
    }
    static Specification<VeParts> statusIsNull() {
        return (veParts, cq, cb) -> cb.isNull(veParts.get("status"));
    }
    static Specification<VeParts> statusIsNotNull() {
        return (veParts, cq, cb) -> cb.isNotNull(veParts.get("status"));
    }
    static Specification<VeParts> statusEqualTo(String status) {
        return (veParts, cq, cb) -> cb.equal(veParts.get("status"), status);
    }
    static Specification<VeParts> statusNotEqualTo(String status) {
        return (veParts, cq, cb) -> cb.notEqual(veParts.get("status"), status);
    }
    static Specification<VeParts> stockUMIsNull() {
        return (veParts, cq, cb) -> cb.isNull(veParts.get("stockUM"));
    }
    static Specification<VeParts> stockUMIsNotNull() {
        return (veParts, cq, cb) -> cb.isNotNull(veParts.get("stockUM"));
    }
    static Specification<VeParts> stockUMEqualTo(String stockUM) {
        return (veParts, cq, cb) -> cb.equal(veParts.get("stockUM"), stockUM);
    }
    static Specification<VeParts> stockUMNotEqualTo(String stockUM) {
        return (veParts, cq, cb) -> cb.notEqual(veParts.get("stockUM"), stockUM);
    }
    static Specification<VeParts> tapeWidthIsNull() {
        return (veParts, cq, cb) -> cb.isNull(veParts.get("tapeWidth"));
    }
    static Specification<VeParts> tapeWidthIsNotNull() {
        return (veParts, cq, cb) -> cb.isNotNull(veParts.get("tapeWidth"));
    }
    static Specification<VeParts> tapeWidthEqualTo(String tapeWidth) {
        return (veParts, cq, cb) -> cb.equal(veParts.get("tapeWidth"), tapeWidth);
    }
    static Specification<VeParts> tapeWidthNotEqualTo(String tapeWidth) {
        return (veParts, cq, cb) -> cb.notEqual(veParts.get("tapeWidth"), tapeWidth);
    }
    static Specification<VeParts> timestampIsNull() {
        return (veParts, cq, cb) -> cb.isNull(veParts.get("timestamp"));
    }
    static Specification<VeParts> timestampIsNotNull() {
        return (veParts, cq, cb) -> cb.isNotNull(veParts.get("timestamp"));
    }
    static Specification<VeParts> timestampEqualTo(String timestamp) {
        return (veParts, cq, cb) -> cb.equal(veParts.get("timestamp"), timestamp);
    }
    static Specification<VeParts> timestampNotEqualTo(String timestamp) {
        return (veParts, cq, cb) -> cb.notEqual(veParts.get("timestamp"), timestamp);
    }
    static Specification<VeParts> valueSizeIsNull() {
        return (veParts, cq, cb) -> cb.isNull(veParts.get("valueSize"));
    }
    static Specification<VeParts> valueSizeIsNotNull() {
        return (veParts, cq, cb) -> cb.isNotNull(veParts.get("valueSize"));
    }
    static Specification<VeParts> valueSizeEqualTo(String valueSize) {
        return (veParts, cq, cb) -> cb.equal(veParts.get("valueSize"), valueSize);
    }
    static Specification<VeParts> valueSizeNotEqualTo(String valueSize) {
        return (veParts, cq, cb) -> cb.notEqual(veParts.get("valueSize"), valueSize);
    }
    static Specification<VeParts> weightIsNull() {
        return (veParts, cq, cb) -> cb.isNull(veParts.get("weight"));
    }
    static Specification<VeParts> weightIsNotNull() {
        return (veParts, cq, cb) -> cb.isNotNull(veParts.get("weight"));
    }
    static Specification<VeParts> weightEqualTo(Double weight) {
        return (veParts, cq, cb) -> cb.equal(veParts.get("weight"), weight);
    }
    static Specification<VeParts> weightNotEqualTo(Double weight) {
        return (veParts, cq, cb) -> cb.notEqual(veParts.get("weight"), weight);
    }
    static Specification<VeParts> weightLessThan(Double weight) {
        return (veParts, cq, cb) -> cb.lessThan(veParts.get("weight"), weight);
    }
    static Specification<VeParts> weightGreaterThan(Double weight) {
        return (veParts, cq, cb) -> cb.greaterThan(veParts.get("weight"), weight);
    }
    static Specification<VeParts> weightUMIsNull() {
        return (veParts, cq, cb) -> cb.isNull(veParts.get("weightUM"));
    }
    static Specification<VeParts> weightUMIsNotNull() {
        return (veParts, cq, cb) -> cb.isNotNull(veParts.get("weightUM"));
    }
    static Specification<VeParts> weightUMEqualTo(String weightUM) {
        return (veParts, cq, cb) -> cb.equal(veParts.get("weightUM"), weightUM);
    }
    static Specification<VeParts> weightUMNotEqualTo(String weightUM) {
        return (veParts, cq, cb) -> cb.notEqual(veParts.get("weightUM"), weightUM);
    }
}
