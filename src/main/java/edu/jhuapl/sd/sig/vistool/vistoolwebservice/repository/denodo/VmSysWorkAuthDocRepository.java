package edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.denodo;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.VmSysWorkAuthDoc;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VmSysWorkAuthDocRepository extends JpaRepository<VmSysWorkAuthDoc, Long>, JpaSpecificationExecutor<VmSysWorkAuthDoc>{	static Specification<VmSysWorkAuthDoc> documentTypeIsNull() {
    return (vmSysWorkAuthDoc, cq, cb) -> cb.isNull(vmSysWorkAuthDoc.get("documentType"));
}
    static Specification<VmSysWorkAuthDoc> documentTypeIsNotNull() {
        return (vmSysWorkAuthDoc, cq, cb) -> cb.isNotNull(vmSysWorkAuthDoc.get("documentType"));
    }
    static Specification<VmSysWorkAuthDoc> documentTypeEqualTo(String documentType) {
        return (vmSysWorkAuthDoc, cq, cb) -> cb.equal(vmSysWorkAuthDoc.get("documentType"), documentType);
    }
    static Specification<VmSysWorkAuthDoc> documentTypeNotEqualTo(String documentType) {
        return (vmSysWorkAuthDoc, cq, cb) -> cb.notEqual(vmSysWorkAuthDoc.get("documentType"), documentType);
    }
    static Specification<VmSysWorkAuthDoc> documentNameIsNull() {
        return (vmSysWorkAuthDoc, cq, cb) -> cb.isNull(vmSysWorkAuthDoc.get("documentName"));
    }
    static Specification<VmSysWorkAuthDoc> documentNameIsNotNull() {
        return (vmSysWorkAuthDoc, cq, cb) -> cb.isNotNull(vmSysWorkAuthDoc.get("documentName"));
    }
    static Specification<VmSysWorkAuthDoc> documentNameEqualTo(String documentName) {
        return (vmSysWorkAuthDoc, cq, cb) -> cb.equal(vmSysWorkAuthDoc.get("documentName"), documentName);
    }
    static Specification<VmSysWorkAuthDoc> documentNameNotEqualTo(String documentName) {
        return (vmSysWorkAuthDoc, cq, cb) -> cb.notEqual(vmSysWorkAuthDoc.get("documentName"), documentName);
    }
    static Specification<VmSysWorkAuthDoc> documentPathIsNull() {
        return (vmSysWorkAuthDoc, cq, cb) -> cb.isNull(vmSysWorkAuthDoc.get("documentPath"));
    }
    static Specification<VmSysWorkAuthDoc> documentPathIsNotNull() {
        return (vmSysWorkAuthDoc, cq, cb) -> cb.isNotNull(vmSysWorkAuthDoc.get("documentPath"));
    }
    static Specification<VmSysWorkAuthDoc> documentPathEqualTo(String documentPath) {
        return (vmSysWorkAuthDoc, cq, cb) -> cb.equal(vmSysWorkAuthDoc.get("documentPath"), documentPath);
    }
    static Specification<VmSysWorkAuthDoc> documentPathNotEqualTo(String documentPath) {
        return (vmSysWorkAuthDoc, cq, cb) -> cb.notEqual(vmSysWorkAuthDoc.get("documentPath"), documentPath);
    }
    static Specification<VmSysWorkAuthDoc> documentIDIsNull() {
        return (vmSysWorkAuthDoc, cq, cb) -> cb.isNull(vmSysWorkAuthDoc.get("documentID"));
    }
    static Specification<VmSysWorkAuthDoc> documentIDIsNotNull() {
        return (vmSysWorkAuthDoc, cq, cb) -> cb.isNotNull(vmSysWorkAuthDoc.get("documentID"));
    }
    static Specification<VmSysWorkAuthDoc> documentIDEqualTo(Double documentID) {
        return (vmSysWorkAuthDoc, cq, cb) -> cb.equal(vmSysWorkAuthDoc.get("documentID"), documentID);
    }
    static Specification<VmSysWorkAuthDoc> documentIDNotEqualTo(Double documentID) {
        return (vmSysWorkAuthDoc, cq, cb) -> cb.notEqual(vmSysWorkAuthDoc.get("documentID"), documentID);
    }
    static Specification<VmSysWorkAuthDoc> documentIDLessThan(Double documentID) {
        return (vmSysWorkAuthDoc, cq, cb) -> cb.lessThan(vmSysWorkAuthDoc.get("documentID"), documentID);
    }
    static Specification<VmSysWorkAuthDoc> documentIDGreaterThan(Double documentID) {
        return (vmSysWorkAuthDoc, cq, cb) -> cb.greaterThan(vmSysWorkAuthDoc.get("documentID"), documentID);
    }
    static Specification<VmSysWorkAuthDoc> workAuthorizationLineNumberIsNull() {
        return (vmSysWorkAuthDoc, cq, cb) -> cb.isNull(vmSysWorkAuthDoc.get("workAuthorizationLineNumber"));
    }
    static Specification<VmSysWorkAuthDoc> workAuthorizationLineNumberIsNotNull() {
        return (vmSysWorkAuthDoc, cq, cb) -> cb.isNotNull(vmSysWorkAuthDoc.get("workAuthorizationLineNumber"));
    }
    static Specification<VmSysWorkAuthDoc> workAuthorizationLineNumberEqualTo(String workAuthorizationLineNumber) {
        return (vmSysWorkAuthDoc, cq, cb) -> cb.equal(vmSysWorkAuthDoc.get("workAuthorizationLineNumber"), workAuthorizationLineNumber);
    }
    static Specification<VmSysWorkAuthDoc> workAuthorizationLineNumberNotEqualTo(String workAuthorizationLineNumber) {
        return (vmSysWorkAuthDoc, cq, cb) -> cb.notEqual(vmSysWorkAuthDoc.get("workAuthorizationLineNumber"), workAuthorizationLineNumber);
    }
    static Specification<VmSysWorkAuthDoc> splitIDIsNull() {
        return (vmSysWorkAuthDoc, cq, cb) -> cb.isNull(vmSysWorkAuthDoc.get("splitID"));
    }
    static Specification<VmSysWorkAuthDoc> splitIDIsNotNull() {
        return (vmSysWorkAuthDoc, cq, cb) -> cb.isNotNull(vmSysWorkAuthDoc.get("splitID"));
    }
    static Specification<VmSysWorkAuthDoc> splitIDEqualTo(String splitID) {
        return (vmSysWorkAuthDoc, cq, cb) -> cb.equal(vmSysWorkAuthDoc.get("splitID"), splitID);
    }
    static Specification<VmSysWorkAuthDoc> splitIDNotEqualTo(String splitID) {
        return (vmSysWorkAuthDoc, cq, cb) -> cb.notEqual(vmSysWorkAuthDoc.get("splitID"), splitID);
    }
    static Specification<VmSysWorkAuthDoc> workAuthorizationIDIsNull() {
        return (vmSysWorkAuthDoc, cq, cb) -> cb.isNull(vmSysWorkAuthDoc.get("workAuthorizationID"));
    }
    static Specification<VmSysWorkAuthDoc> workAuthorizationIDIsNotNull() {
        return (vmSysWorkAuthDoc, cq, cb) -> cb.isNotNull(vmSysWorkAuthDoc.get("workAuthorizationID"));
    }
    static Specification<VmSysWorkAuthDoc> workAuthorizationIDEqualTo(String workAuthorizationID) {
        return (vmSysWorkAuthDoc, cq, cb) -> cb.equal(vmSysWorkAuthDoc.get("workAuthorizationID"), workAuthorizationID);
    }
    static Specification<VmSysWorkAuthDoc> workAuthorizationIDNotEqualTo(String workAuthorizationID) {
        return (vmSysWorkAuthDoc, cq, cb) -> cb.notEqual(vmSysWorkAuthDoc.get("workAuthorizationID"), workAuthorizationID);
    }
}
