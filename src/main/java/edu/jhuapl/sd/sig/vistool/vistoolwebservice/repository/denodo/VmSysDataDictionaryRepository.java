package edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.denodo;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.VmSysDataDictionary;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VmSysDataDictionaryRepository extends JpaRepository<VmSysDataDictionary, Long>, JpaSpecificationExecutor<VmSysDataDictionary> {
    static Specification<VmSysDataDictionary> columnCommentsIsNull() {
        return (vmSysDataDictionary, cq, cb) -> cb.isNull(vmSysDataDictionary.get("columnComments"));
    }
    static Specification<VmSysDataDictionary> columnCommentsIsNotNull() {
        return (vmSysDataDictionary, cq, cb) -> cb.isNotNull(vmSysDataDictionary.get("columnComments"));
    }
    static Specification<VmSysDataDictionary> columnCommentsEqualTo(String columnComments) {
        return (vmSysDataDictionary, cq, cb) -> cb.equal(vmSysDataDictionary.get("columnComments"), columnComments);
    }
    static Specification<VmSysDataDictionary> columnCommentsNotEqualTo(String columnComments) {
        return (vmSysDataDictionary, cq, cb) -> cb.notEqual(vmSysDataDictionary.get("columnComments"), columnComments);
    }
    static Specification<VmSysDataDictionary> columnNameIsNull() {
        return (vmSysDataDictionary, cq, cb) -> cb.isNull(vmSysDataDictionary.get("columnName"));
    }
    static Specification<VmSysDataDictionary> columnNameIsNotNull() {
        return (vmSysDataDictionary, cq, cb) -> cb.isNotNull(vmSysDataDictionary.get("columnName"));
    }
    static Specification<VmSysDataDictionary> columnNameEqualTo(String columnName) {
        return (vmSysDataDictionary, cq, cb) -> cb.equal(vmSysDataDictionary.get("columnName"), columnName);
    }
    static Specification<VmSysDataDictionary> columnNameNotEqualTo(String columnName) {
        return (vmSysDataDictionary, cq, cb) -> cb.notEqual(vmSysDataDictionary.get("columnName"), columnName);
    }
    static Specification<VmSysDataDictionary> tableCommentsIsNull() {
        return (vmSysDataDictionary, cq, cb) -> cb.isNull(vmSysDataDictionary.get("tableComments"));
    }
    static Specification<VmSysDataDictionary> tableCommentsIsNotNull() {
        return (vmSysDataDictionary, cq, cb) -> cb.isNotNull(vmSysDataDictionary.get("tableComments"));
    }
    static Specification<VmSysDataDictionary> tableCommentsEqualTo(String tableComments) {
        return (vmSysDataDictionary, cq, cb) -> cb.equal(vmSysDataDictionary.get("tableComments"), tableComments);
    }
    static Specification<VmSysDataDictionary> tableCommentsNotEqualTo(String tableComments) {
        return (vmSysDataDictionary, cq, cb) -> cb.notEqual(vmSysDataDictionary.get("tableComments"), tableComments);
    }
    static Specification<VmSysDataDictionary> tableNameIsNull() {
        return (vmSysDataDictionary, cq, cb) -> cb.isNull(vmSysDataDictionary.get("tableName"));
    }
    static Specification<VmSysDataDictionary> tableNameIsNotNull() {
        return (vmSysDataDictionary, cq, cb) -> cb.isNotNull(vmSysDataDictionary.get("tableName"));
    }
    static Specification<VmSysDataDictionary> tableNameEqualTo(String tableName) {
        return (vmSysDataDictionary, cq, cb) -> cb.equal(vmSysDataDictionary.get("tableName"), tableName);
    }
    static Specification<VmSysDataDictionary> tableNameNotEqualTo(String tableName) {
        return (vmSysDataDictionary, cq, cb) -> cb.notEqual(vmSysDataDictionary.get("tableName"), tableName);
    }
}
