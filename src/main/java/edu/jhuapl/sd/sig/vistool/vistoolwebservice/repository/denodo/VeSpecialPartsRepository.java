package edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.denodo;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.VeSpecialParts;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Date;

public interface VeSpecialPartsRepository extends JpaRepository<VeSpecialParts, Long>, JpaSpecificationExecutor<VeSpecialParts>{
    static Specification<VeSpecialParts> attributesIsNull() {
        return (veSpecialParts, cq, cb) -> cb.isNull(veSpecialParts.get("attributes"));
    }
    static Specification<VeSpecialParts> attributesIsNotNull() {
        return (veSpecialParts, cq, cb) -> cb.isNotNull(veSpecialParts.get("attributes"));
    }
    static Specification<VeSpecialParts> attributesEqualTo(String attributes) {
        return (veSpecialParts, cq, cb) -> cb.equal(veSpecialParts.get("attributes"), attributes);
    }
    static Specification<VeSpecialParts> attributesNotEqualTo(String attributes) {
        return (veSpecialParts, cq, cb) -> cb.notEqual(veSpecialParts.get("attributes"), attributes);
    }
    static Specification<VeSpecialParts> configLevelIsNull() {
        return (veSpecialParts, cq, cb) -> cb.isNull(veSpecialParts.get("configLevel"));
    }
    static Specification<VeSpecialParts> configLevelIsNotNull() {
        return (veSpecialParts, cq, cb) -> cb.isNotNull(veSpecialParts.get("configLevel"));
    }
    static Specification<VeSpecialParts> configLevelEqualTo(String configLevel) {
        return (veSpecialParts, cq, cb) -> cb.equal(veSpecialParts.get("configLevel"), configLevel);
    }
    static Specification<VeSpecialParts> configLevelNotEqualTo(String configLevel) {
        return (veSpecialParts, cq, cb) -> cb.notEqual(veSpecialParts.get("configLevel"), configLevel);
    }
    static Specification<VeSpecialParts> createDateIsNull() {
        return (veSpecialParts, cq, cb) -> cb.isNull(veSpecialParts.get("createDate"));
    }
    static Specification<VeSpecialParts> createDateIsNotNull() {
        return (veSpecialParts, cq, cb) -> cb.isNotNull(veSpecialParts.get("createDate"));
    }
    static Specification<VeSpecialParts> createDateEqualTo(Date createDate) {
        return (veSpecialParts, cq, cb) -> cb.equal(veSpecialParts.get("createDate"), createDate);
    }
    static Specification<VeSpecialParts> createDateNotEqualTo(Date createDate) {
        return (veSpecialParts, cq, cb) -> cb.notEqual(veSpecialParts.get("createDate"), createDate);
    }
    static Specification<VeSpecialParts> createDateBefore(Date createDate) {
        return (veSpecialParts, cq, cb) -> cb.lessThan(veSpecialParts.get("createDate"), createDate);
    }
    static Specification<VeSpecialParts> createDateAfter(Date createDate) {
        return (veSpecialParts, cq, cb) -> cb.greaterThan(veSpecialParts.get("createDate"), createDate);
    }
    static Specification<VeSpecialParts> descriptionIsNull() {
        return (veSpecialParts, cq, cb) -> cb.isNull(veSpecialParts.get("description"));
    }
    static Specification<VeSpecialParts> descriptionIsNotNull() {
        return (veSpecialParts, cq, cb) -> cb.isNotNull(veSpecialParts.get("description"));
    }
    static Specification<VeSpecialParts> descriptionEqualTo(String description) {
        return (veSpecialParts, cq, cb) -> cb.equal(veSpecialParts.get("description"), description);
    }
    static Specification<VeSpecialParts> descriptionNotEqualTo(String description) {
        return (veSpecialParts, cq, cb) -> cb.notEqual(veSpecialParts.get("description"), description);
    }
    static Specification<VeSpecialParts> esdClassIsNull() {
        return (veSpecialParts, cq, cb) -> cb.isNull(veSpecialParts.get("esdClass"));
    }
    static Specification<VeSpecialParts> esdClassIsNotNull() {
        return (veSpecialParts, cq, cb) -> cb.isNotNull(veSpecialParts.get("esdClass"));
    }
    static Specification<VeSpecialParts> esdClassEqualTo(String esdClass) {
        return (veSpecialParts, cq, cb) -> cb.equal(veSpecialParts.get("esdClass"), esdClass);
    }
    static Specification<VeSpecialParts> esdClassNotEqualTo(String esdClass) {
        return (veSpecialParts, cq, cb) -> cb.notEqual(veSpecialParts.get("esdClass"), esdClass);
    }
    static Specification<VeSpecialParts> extendedPartDescriptionIsNull() {
        return (veSpecialParts, cq, cb) -> cb.isNull(veSpecialParts.get("extendedPartDescription"));
    }
    static Specification<VeSpecialParts> extendedPartDescriptionIsNotNull() {
        return (veSpecialParts, cq, cb) -> cb.isNotNull(veSpecialParts.get("extendedPartDescription"));
    }
    static Specification<VeSpecialParts> extendedPartDescriptionEqualTo(String extendedPartDescription) {
        return (veSpecialParts, cq, cb) -> cb.equal(veSpecialParts.get("extendedPartDescription"), extendedPartDescription);
    }
    static Specification<VeSpecialParts> extendedPartDescriptionNotEqualTo(String extendedPartDescription) {
        return (veSpecialParts, cq, cb) -> cb.notEqual(veSpecialParts.get("extendedPartDescription"), extendedPartDescription);
    }
    static Specification<VeSpecialParts> fabricatedIsNull() {
        return (veSpecialParts, cq, cb) -> cb.isNull(veSpecialParts.get("fabricated"));
    }
    static Specification<VeSpecialParts> fabricatedIsNotNull() {
        return (veSpecialParts, cq, cb) -> cb.isNotNull(veSpecialParts.get("fabricated"));
    }
    static Specification<VeSpecialParts> fabricatedEqualTo(String fabricated) {
        return (veSpecialParts, cq, cb) -> cb.equal(veSpecialParts.get("fabricated"), fabricated);
    }
    static Specification<VeSpecialParts> fabricatedNotEqualTo(String fabricated) {
        return (veSpecialParts, cq, cb) -> cb.notEqual(veSpecialParts.get("fabricated"), fabricated);
    }
    static Specification<VeSpecialParts> gpnIsNull() {
        return (veSpecialParts, cq, cb) -> cb.isNull(veSpecialParts.get("gpn"));
    }
    static Specification<VeSpecialParts> gpnIsNotNull() {
        return (veSpecialParts, cq, cb) -> cb.isNotNull(veSpecialParts.get("gpn"));
    }
    static Specification<VeSpecialParts> gpnEqualTo(String gpn) {
        return (veSpecialParts, cq, cb) -> cb.equal(veSpecialParts.get("gpn"), gpn);
    }
    static Specification<VeSpecialParts> gpnNotEqualTo(String gpn) {
        return (veSpecialParts, cq, cb) -> cb.notEqual(veSpecialParts.get("gpn"), gpn);
    }
    static Specification<VeSpecialParts> gradeIsNull() {
        return (veSpecialParts, cq, cb) -> cb.isNull(veSpecialParts.get("grade"));
    }
    static Specification<VeSpecialParts> gradeIsNotNull() {
        return (veSpecialParts, cq, cb) -> cb.isNotNull(veSpecialParts.get("grade"));
    }
    static Specification<VeSpecialParts> gradeEqualTo(String grade) {
        return (veSpecialParts, cq, cb) -> cb.equal(veSpecialParts.get("grade"), grade);
    }
    static Specification<VeSpecialParts> gradeNotEqualTo(String grade) {
        return (veSpecialParts, cq, cb) -> cb.notEqual(veSpecialParts.get("grade"), grade);
    }
    static Specification<VeSpecialParts> idIsNull() {
        return (veSpecialParts, cq, cb) -> cb.isNull(veSpecialParts.get("id"));
    }
    static Specification<VeSpecialParts> idIsNotNull() {
        return (veSpecialParts, cq, cb) -> cb.isNotNull(veSpecialParts.get("id"));
    }
    static Specification<VeSpecialParts> idEqualTo(String id) {
        return (veSpecialParts, cq, cb) -> cb.equal(veSpecialParts.get("id"), id);
    }
    static Specification<VeSpecialParts> idNotEqualTo(String id) {
        return (veSpecialParts, cq, cb) -> cb.notEqual(veSpecialParts.get("id"), id);
    }
    static Specification<VeSpecialParts> leadEngineerIsNull() {
        return (veSpecialParts, cq, cb) -> cb.isNull(veSpecialParts.get("leadEngineer"));
    }
    static Specification<VeSpecialParts> leadEngineerIsNotNull() {
        return (veSpecialParts, cq, cb) -> cb.isNotNull(veSpecialParts.get("leadEngineer"));
    }
    static Specification<VeSpecialParts> leadEngineerEqualTo(String leadEngineer) {
        return (veSpecialParts, cq, cb) -> cb.equal(veSpecialParts.get("leadEngineer"), leadEngineer);
    }
    static Specification<VeSpecialParts> leadEngineerNotEqualTo(String leadEngineer) {
        return (veSpecialParts, cq, cb) -> cb.notEqual(veSpecialParts.get("leadEngineer"), leadEngineer);
    }
    static Specification<VeSpecialParts> modifyDateIsNull() {
        return (veSpecialParts, cq, cb) -> cb.isNull(veSpecialParts.get("modifyDate"));
    }
    static Specification<VeSpecialParts> modifyDateIsNotNull() {
        return (veSpecialParts, cq, cb) -> cb.isNotNull(veSpecialParts.get("modifyDate"));
    }
    static Specification<VeSpecialParts> modifyDateEqualTo(Date modifyDate) {
        return (veSpecialParts, cq, cb) -> cb.equal(veSpecialParts.get("modifyDate"), modifyDate);
    }
    static Specification<VeSpecialParts> modifyDateNotEqualTo(Date modifyDate) {
        return (veSpecialParts, cq, cb) -> cb.notEqual(veSpecialParts.get("modifyDate"), modifyDate);
    }
    static Specification<VeSpecialParts> modifyDateBefore(Date modifyDate) {
        return (veSpecialParts, cq, cb) -> cb.lessThan(veSpecialParts.get("modifyDate"), modifyDate);
    }
    static Specification<VeSpecialParts> modifyDateAfter(Date modifyDate) {
        return (veSpecialParts, cq, cb) -> cb.greaterThan(veSpecialParts.get("modifyDate"), modifyDate);
    }
    static Specification<VeSpecialParts> purchasedIsNull() {
        return (veSpecialParts, cq, cb) -> cb.isNull(veSpecialParts.get("purchased"));
    }
    static Specification<VeSpecialParts> purchasedIsNotNull() {
        return (veSpecialParts, cq, cb) -> cb.isNotNull(veSpecialParts.get("purchased"));
    }
    static Specification<VeSpecialParts> purchasedEqualTo(String purchased) {
        return (veSpecialParts, cq, cb) -> cb.equal(veSpecialParts.get("purchased"), purchased);
    }
    static Specification<VeSpecialParts> purchasedNotEqualTo(String purchased) {
        return (veSpecialParts, cq, cb) -> cb.notEqual(veSpecialParts.get("purchased"), purchased);
    }
    static Specification<VeSpecialParts> stockUMIsNull() {
        return (veSpecialParts, cq, cb) -> cb.isNull(veSpecialParts.get("stockUM"));
    }
    static Specification<VeSpecialParts> stockUMIsNotNull() {
        return (veSpecialParts, cq, cb) -> cb.isNotNull(veSpecialParts.get("stockUM"));
    }
    static Specification<VeSpecialParts> stockUMEqualTo(String stockUM) {
        return (veSpecialParts, cq, cb) -> cb.equal(veSpecialParts.get("stockUM"), stockUM);
    }
    static Specification<VeSpecialParts> stockUMNotEqualTo(String stockUM) {
        return (veSpecialParts, cq, cb) -> cb.notEqual(veSpecialParts.get("stockUM"), stockUM);
    }
    static Specification<VeSpecialParts> tapeWidthIsNull() {
        return (veSpecialParts, cq, cb) -> cb.isNull(veSpecialParts.get("tapeWidth"));
    }
    static Specification<VeSpecialParts> tapeWidthIsNotNull() {
        return (veSpecialParts, cq, cb) -> cb.isNotNull(veSpecialParts.get("tapeWidth"));
    }
    static Specification<VeSpecialParts> tapeWidthEqualTo(String tapeWidth) {
        return (veSpecialParts, cq, cb) -> cb.equal(veSpecialParts.get("tapeWidth"), tapeWidth);
    }
    static Specification<VeSpecialParts> tapeWidthNotEqualTo(String tapeWidth) {
        return (veSpecialParts, cq, cb) -> cb.notEqual(veSpecialParts.get("tapeWidth"), tapeWidth);
    }
    static Specification<VeSpecialParts> timestampIsNull() {
        return (veSpecialParts, cq, cb) -> cb.isNull(veSpecialParts.get("timestamp"));
    }
    static Specification<VeSpecialParts> timestampIsNotNull() {
        return (veSpecialParts, cq, cb) -> cb.isNotNull(veSpecialParts.get("timestamp"));
    }
    static Specification<VeSpecialParts> timestampEqualTo(String timestamp) {
        return (veSpecialParts, cq, cb) -> cb.equal(veSpecialParts.get("timestamp"), timestamp);
    }
    static Specification<VeSpecialParts> timestampNotEqualTo(String timestamp) {
        return (veSpecialParts, cq, cb) -> cb.notEqual(veSpecialParts.get("timestamp"), timestamp);
    }
    static Specification<VeSpecialParts> valueSizeIsNull() {
        return (veSpecialParts, cq, cb) -> cb.isNull(veSpecialParts.get("valueSize"));
    }
    static Specification<VeSpecialParts> valueSizeIsNotNull() {
        return (veSpecialParts, cq, cb) -> cb.isNotNull(veSpecialParts.get("valueSize"));
    }
    static Specification<VeSpecialParts> valueSizeEqualTo(String valueSize) {
        return (veSpecialParts, cq, cb) -> cb.equal(veSpecialParts.get("valueSize"), valueSize);
    }
    static Specification<VeSpecialParts> valueSizeNotEqualTo(String valueSize) {
        return (veSpecialParts, cq, cb) -> cb.notEqual(veSpecialParts.get("valueSize"), valueSize);
    }
}
