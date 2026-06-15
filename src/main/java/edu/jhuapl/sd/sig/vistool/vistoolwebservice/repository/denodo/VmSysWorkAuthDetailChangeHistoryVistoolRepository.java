package edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.denodo;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.VmSysWorkAuthDetailChangeHistoryVistool;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Set;

import javax.persistence.criteria.Path;

@Repository
public interface VmSysWorkAuthDetailChangeHistoryVistoolRepository
        extends JpaRepository<VmSysWorkAuthDetailChangeHistoryVistool, Long>,
        JpaSpecificationExecutor<VmSysWorkAuthDetailChangeHistoryVistool> {
    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> headerCreateDateIsNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNull(vmSysWorkAuthChangeHistoryVistool.get("headerCreateDate"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> headerCreateDateIsNotNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNotNull(vmSysWorkAuthChangeHistoryVistool.get("headerCreateDate"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> headerCreateDateEqualTo(Date createDate) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .equal(vmSysWorkAuthChangeHistoryVistool.get("headerCreateDate"), createDate);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> headerCreateDateNotEqualTo(Date createDate) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .notEqual(vmSysWorkAuthChangeHistoryVistool.get("headerCreateDate"), createDate);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> headerCreateDateBeforeOrOn(Date createDate) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .lessThanOrEqualTo(vmSysWorkAuthChangeHistoryVistool.get("headerCreateDate"), createDate);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> headerCreateDateAfterOrOn(Date createDate) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .greaterThanOrEqualTo(vmSysWorkAuthChangeHistoryVistool.get("headerCreateDate"), createDate);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> customerIsNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNull(vmSysWorkAuthChangeHistoryVistool.get("customer"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> customerIsNotNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNotNull(vmSysWorkAuthChangeHistoryVistool.get("customer"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> customerEqualTo(String customer) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .equal(vmSysWorkAuthChangeHistoryVistool.get("customer"), customer);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> customerNotEqualTo(String customer) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .notEqual(vmSysWorkAuthChangeHistoryVistool.get("customer"), customer);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> departmentIdIsNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNull(vmSysWorkAuthChangeHistoryVistool.get("departmentId"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> departmentIdIsNotNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNotNull(vmSysWorkAuthChangeHistoryVistool.get("departmentId"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> departmentIdEqualTo(String departmentId) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .equal(vmSysWorkAuthChangeHistoryVistool.get("departmentId"), departmentId);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> departmentIdNotEqualTo(String departmentId) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .notEqual(vmSysWorkAuthChangeHistoryVistool.get("departmentId"), departmentId);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> headerIdIsNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNull(vmSysWorkAuthChangeHistoryVistool.get("headerId"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> headerIdIsNotNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNotNull(vmSysWorkAuthChangeHistoryVistool.get("headerId"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> headerIdEqualTo(String id) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .equal(vmSysWorkAuthChangeHistoryVistool.get("headerId"), id);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> headerIdNotEqualTo(String id) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb.notEqual(
                vmSysWorkAuthChangeHistoryVistool.get("headerId"),
                id);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> headerLastModifiedIsNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNull(vmSysWorkAuthChangeHistoryVistool.get("headerLastModified"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> headerLastModifiedIsNotNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNotNull(vmSysWorkAuthChangeHistoryVistool.get("headerLastModified"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> headerLastModifiedEqualTo(Date lastModified) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .equal(vmSysWorkAuthChangeHistoryVistool.get("headerLastModified"), lastModified);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> headerLastModifiedNotEqualTo(Date lastModified) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .notEqual(vmSysWorkAuthChangeHistoryVistool.get("headerLastModified"), lastModified);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> headerLastModifiedBefore(Date lastModified) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .lessThan(vmSysWorkAuthChangeHistoryVistool.get("headerLastModified"), lastModified);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> headerLastModifiedAfter(Date lastModified) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .greaterThan(vmSysWorkAuthChangeHistoryVistool.get("headerLastModified"), lastModified);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> originatorIsNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNull(vmSysWorkAuthChangeHistoryVistool.get("originator"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> originatorIsNotNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNotNull(vmSysWorkAuthChangeHistoryVistool.get("originator"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> originatorEqualTo(String originator) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .equal(vmSysWorkAuthChangeHistoryVistool.get("originator"), originator);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> originatorNotEqualTo(String originator) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .notEqual(vmSysWorkAuthChangeHistoryVistool.get("originator"), originator);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> statusIsNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNull(vmSysWorkAuthChangeHistoryVistool.get("status"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> statusIsNotNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNotNull(vmSysWorkAuthChangeHistoryVistool.get("status"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> statusEqualTo(String status) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb.equal(vmSysWorkAuthChangeHistoryVistool.get("status"),
                status);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> statusNotEqualTo(String status) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .notEqual(vmSysWorkAuthChangeHistoryVistool.get("status"), status);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> submitDateIsNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNull(vmSysWorkAuthChangeHistoryVistool.get("submitDate"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> submitDateIsNotNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNotNull(vmSysWorkAuthChangeHistoryVistool.get("submitDate"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> submitDateEqualTo(Date submitDate) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .equal(vmSysWorkAuthChangeHistoryVistool.get("submitDate"), submitDate);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> submitDateNotEqualTo(Date submitDate) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .notEqual(vmSysWorkAuthChangeHistoryVistool.get("submitDate"), submitDate);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> submitDateOnOrBefore(Date submitDate) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .lessThanOrEqualTo(vmSysWorkAuthChangeHistoryVistool.get("submitDate"), submitDate);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> submitDateOnOrAfter(Date submitDate) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .greaterThanOrEqualTo(vmSysWorkAuthChangeHistoryVistool.get("submitDate"), submitDate);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> headerTaIsNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNull(vmSysWorkAuthChangeHistoryVistool.get("headerTa"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> headerTaIsNotNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNotNull(vmSysWorkAuthChangeHistoryVistool.get("headerTa"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> headerTaEqualTo(String ta) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .equal(vmSysWorkAuthChangeHistoryVistool.get("headerTa"), ta);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> headerTaNotEqualTo(String ta) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb.notEqual(
                vmSysWorkAuthChangeHistoryVistool.get("headerTa"),
                ta);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> workAreaIdIsNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNull(vmSysWorkAuthChangeHistoryVistool.get("workAreaId"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> workAreaIdIsNotNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNotNull(vmSysWorkAuthChangeHistoryVistool.get("workAreaId"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> workAreaIdEqualTo(String workAreaId) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .equal(vmSysWorkAuthChangeHistoryVistool.get("workAreaId"), workAreaId);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> workAreaIdNotEqualTo(String workAreaId) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .notEqual(vmSysWorkAuthChangeHistoryVistool.get("workAreaId"), workAreaId);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> aplGroupsIdIsNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNull(vmSysWorkAuthChangeHistoryVistool.get("aplGroupsId"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> aplGroupsIdIsNotNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNotNull(vmSysWorkAuthChangeHistoryVistool.get("aplGroupsId"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> aplGroupsIdEqualTo(String aplGroupsId) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .equal(vmSysWorkAuthChangeHistoryVistool.get("aplGroupsId"), aplGroupsId);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> aplGroupsIdNotEqualTo(String aplGroupsId) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .notEqual(vmSysWorkAuthChangeHistoryVistool.get("aplGroupsId"), aplGroupsId);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> commentsIsNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNull(vmSysWorkAuthChangeHistoryVistool.get("comments"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> commentsIsNotNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNotNull(vmSysWorkAuthChangeHistoryVistool.get("comments"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> commentsEqualTo(String comments) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .equal(vmSysWorkAuthChangeHistoryVistool.get("comments"), comments);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> commentsNotEqualTo(String comments) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .notEqual(vmSysWorkAuthChangeHistoryVistool.get("comments"), comments);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> detailCreateDateIsNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNull(vmSysWorkAuthChangeHistoryVistool.get("detailCreateDate"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> detailCreateDateIsNotNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNotNull(vmSysWorkAuthChangeHistoryVistool.get("detailCreateDate"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> detailCreateDateEqualTo(Date createDate) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .equal(vmSysWorkAuthChangeHistoryVistool.get("detailCreateDate"), createDate);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> detailCreateDateNotEqualTo(Date createDate) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .notEqual(vmSysWorkAuthChangeHistoryVistool.get("detailCreateDate"), createDate);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> detailCreateDateBeforeOrOn(Date createDate) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .lessThanOrEqualTo(vmSysWorkAuthChangeHistoryVistool.get("detailCreateDate"), createDate);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> detailCreateDateAfterOrOn(Date createDate) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .greaterThanOrEqualTo(vmSysWorkAuthChangeHistoryVistool.get("detailCreateDate"), createDate);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> descriptionIsNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNull(vmSysWorkAuthChangeHistoryVistool.get("description"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> descriptionIsNotNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNotNull(vmSysWorkAuthChangeHistoryVistool.get("description"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> descriptionEqualTo(String description) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .equal(vmSysWorkAuthChangeHistoryVistool.get("description"), description);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> descriptionNotEqualTo(String description) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .notEqual(vmSysWorkAuthChangeHistoryVistool.get("description"), description);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> flowIsNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb.isNull(vmSysWorkAuthChangeHistoryVistool.get("flow"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> flowIsNotNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNotNull(vmSysWorkAuthChangeHistoryVistool.get("flow"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> flowEqualTo(String flow) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb.equal(vmSysWorkAuthChangeHistoryVistool.get("flow"),
                flow);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> flowNotEqualTo(String flow) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb.notEqual(vmSysWorkAuthChangeHistoryVistool.get("flow"),
                flow);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> inPLMIsNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb.isNull(vmSysWorkAuthChangeHistoryVistool.get("inPLM"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> inPLMIsNotNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNotNull(vmSysWorkAuthChangeHistoryVistool.get("inPLM"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> inPLMEqualTo(String inPLM) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb.equal(vmSysWorkAuthChangeHistoryVistool.get("inPLM"),
                inPLM);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> inPLMNotEqualTo(String inPLM) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .notEqual(vmSysWorkAuthChangeHistoryVistool.get("inPLM"), inPLM);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> detailLastModifiedIsNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNull(vmSysWorkAuthChangeHistoryVistool.get("detailLastModified"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> detailLastModifiedIsNotNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNotNull(vmSysWorkAuthChangeHistoryVistool.get("detailLastModified"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> detailLastModifiedEqualTo(Date lastModified) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .equal(vmSysWorkAuthChangeHistoryVistool.get("detailLastModified"), lastModified);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> detailLastModifiedNotEqualTo(Date lastModified) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .notEqual(vmSysWorkAuthChangeHistoryVistool.get("detailLastModified"), lastModified);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> detailLastModifiedBefore(Date lastModified) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .lessThan(vmSysWorkAuthChangeHistoryVistool.get("detailLastModified"), lastModified);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> detailLastModifiedAfter(Date lastModified) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .greaterThan(vmSysWorkAuthChangeHistoryVistool.get("detailLastModified"), lastModified);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> lineItemIsNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNull(vmSysWorkAuthChangeHistoryVistool.get("lineItem"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> lineItemIsNotNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNotNull(vmSysWorkAuthChangeHistoryVistool.get("lineItem"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> lineItemEqualTo(String lineItem) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .equal(vmSysWorkAuthChangeHistoryVistool.get("lineItem"), lineItem);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> lineItemNotEqualTo(String lineItem) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .notEqual(vmSysWorkAuthChangeHistoryVistool.get("lineItem"), lineItem);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> originalWorkOrderIsNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNull(vmSysWorkAuthChangeHistoryVistool.get("originalWorkOrder"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> originalWorkOrderIsNotNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNotNull(vmSysWorkAuthChangeHistoryVistool.get("originalWorkOrder"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> originalWorkOrderEqualTo(String originalWorkOrder) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .equal(vmSysWorkAuthChangeHistoryVistool.get("originalWorkOrder"), originalWorkOrder);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> originalWorkOrderNotEqualTo(
            String originalWorkOrder) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .notEqual(vmSysWorkAuthChangeHistoryVistool.get("originalWorkOrder"), originalWorkOrder);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> parentLotIsNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNull(vmSysWorkAuthChangeHistoryVistool.get("parentLot"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> parentLotIsNotNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNotNull(vmSysWorkAuthChangeHistoryVistool.get("parentLot"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> parentLotEqualTo(String parentLot) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .equal(vmSysWorkAuthChangeHistoryVistool.get("parentLot"), parentLot);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> parentLotNotEqualTo(String parentLot) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .notEqual(vmSysWorkAuthChangeHistoryVistool.get("parentLot"), parentLot);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> parentOperationIsNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNull(vmSysWorkAuthChangeHistoryVistool.get("parentOperation"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> parentOperationIsNotNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNotNull(vmSysWorkAuthChangeHistoryVistool.get("parentOperation"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> parentOperationEqualTo(String parentOperation) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .equal(vmSysWorkAuthChangeHistoryVistool.get("parentOperation"), parentOperation);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> parentOperationNotEqualTo(String parentOperation) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .notEqual(vmSysWorkAuthChangeHistoryVistool.get("parentOperation"), parentOperation);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> parentSplitIdIsNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNull(vmSysWorkAuthChangeHistoryVistool.get("parentSplitId"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> parentSplitIdIsNotNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNotNull(vmSysWorkAuthChangeHistoryVistool.get("parentSplitId"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> parentSplitIdEqualTo(String parentSplitId) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .equal(vmSysWorkAuthChangeHistoryVistool.get("parentSplitId"), parentSplitId);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> parentSplitIdNotEqualTo(String parentSplitId) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .notEqual(vmSysWorkAuthChangeHistoryVistool.get("parentSplitId"), parentSplitId);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> parentWorkOrderIsNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNull(vmSysWorkAuthChangeHistoryVistool.get("parentWorkOrder"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> parentWorkOrderIsNotNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNotNull(vmSysWorkAuthChangeHistoryVistool.get("parentWorkOrder"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> parentWorkOrderEqualTo(String parentWorkOrder) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .equal(vmSysWorkAuthChangeHistoryVistool.get("parentWorkOrder"), parentWorkOrder);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> parentWorkOrderNotEqualTo(String parentWorkOrder) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .notEqual(vmSysWorkAuthChangeHistoryVistool.get("parentWorkOrder"), parentWorkOrder);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> partIdIsNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNull(vmSysWorkAuthChangeHistoryVistool.get("partId"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> partIdIsNotNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNotNull(vmSysWorkAuthChangeHistoryVistool.get("partId"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> partIdEqualTo(String partId) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb.equal(vmSysWorkAuthChangeHistoryVistool.get("partId"),
                partId);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> partIdNotEqualTo(String partId) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .notEqual(vmSysWorkAuthChangeHistoryVistool.get("partId"), partId);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> quantityIsNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNull(vmSysWorkAuthChangeHistoryVistool.get("quantity"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> quantityIsNotNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNotNull(vmSysWorkAuthChangeHistoryVistool.get("quantity"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> quantityEqualTo(Integer quantity) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .equal(vmSysWorkAuthChangeHistoryVistool.get("quantity"), quantity);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> quantityNotEqualTo(Integer quantity) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .notEqual(vmSysWorkAuthChangeHistoryVistool.get("quantity"), quantity);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> reddFlowIdIsNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNull(vmSysWorkAuthChangeHistoryVistool.get("reddFlowId"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> reddFlowIdIsNotNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNotNull(vmSysWorkAuthChangeHistoryVistool.get("reddFlowId"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> reddFlowIdEqualTo(String reddFlowId) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .equal(vmSysWorkAuthChangeHistoryVistool.get("reddFlowId"), reddFlowId);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> reddFlowIdNotEqualTo(String reddFlowId) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .notEqual(vmSysWorkAuthChangeHistoryVistool.get("reddFlowId"), reddFlowId);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> revisionIsNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNull(vmSysWorkAuthChangeHistoryVistool.get("revision"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> revisionIsNotNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNotNull(vmSysWorkAuthChangeHistoryVistool.get("revision"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> revisionEqualTo(String revision) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .equal(vmSysWorkAuthChangeHistoryVistool.get("revision"), revision);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> revisionNotEqualTo(String revision) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .notEqual(vmSysWorkAuthChangeHistoryVistool.get("revision"), revision);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> splitIdIsNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNull(vmSysWorkAuthChangeHistoryVistool.get("splitId"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> splitIdIsNotNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNotNull(vmSysWorkAuthChangeHistoryVistool.get("splitId"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> splitIdEqualTo(String splitId) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb.equal(vmSysWorkAuthChangeHistoryVistool.get("splitId"),
                splitId);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> splitIdNotEqualTo(String splitId) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .notEqual(vmSysWorkAuthChangeHistoryVistool.get("splitId"), splitId);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> detailTaIsNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNull(vmSysWorkAuthChangeHistoryVistool.get("detailTa"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> detailTaIsNotNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNotNull(vmSysWorkAuthChangeHistoryVistool.get("detailTa"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> detailTaEqualTo(String ta) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .equal(vmSysWorkAuthChangeHistoryVistool.get("detailTa"), ta);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> detailTaNotEqualTo(String ta) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .notEqual(vmSysWorkAuthChangeHistoryVistool.get("detailTa"), ta);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> usingSNIsNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNull(vmSysWorkAuthChangeHistoryVistool.get("usingSN"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> usingSNIsNotNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNotNull(vmSysWorkAuthChangeHistoryVistool.get("usingSN"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> usingSNEqualTo(String usingSN) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb.equal(vmSysWorkAuthChangeHistoryVistool.get("usingSN"),
                usingSN);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> usingSNNotEqualTo(String usingSN) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .notEqual(vmSysWorkAuthChangeHistoryVistool.get("usingSN"), usingSN);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> workAuthorizationFlowIdIsNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNull(vmSysWorkAuthChangeHistoryVistool.get("workAuthorizationFlowId"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> workAuthorizationFlowIdIsNotNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNotNull(vmSysWorkAuthChangeHistoryVistool.get("workAuthorizationFlowId"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> workAuthorizationFlowIdEqualTo(
            String workAuthorizationFlowId) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .equal(vmSysWorkAuthChangeHistoryVistool.get("workAuthorizationFlowId"), workAuthorizationFlowId);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> workAuthorizationFlowIdNotEqualTo(
            String workAuthorizationFlowId) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .notEqual(vmSysWorkAuthChangeHistoryVistool.get("workAuthorizationFlowId"), workAuthorizationFlowId);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> wantDateIsNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNull(vmSysWorkAuthChangeHistoryVistool.get("wantDate"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> wantDateIsNotNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNotNull(vmSysWorkAuthChangeHistoryVistool.get("wantDate"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> wantDateEqualTo(Date wantDate) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .equal(vmSysWorkAuthChangeHistoryVistool.get("wantDate"), wantDate);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> wantDateNotEqualTo(Date wantDate) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .notEqual(vmSysWorkAuthChangeHistoryVistool.get("wantDate"), wantDate);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> wantDateBefore(Date wantDate) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .lessThan(vmSysWorkAuthChangeHistoryVistool.get("wantDate"), wantDate);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> wantDateAfter(Date wantDate) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .greaterThan(vmSysWorkAuthChangeHistoryVistool.get("wantDate"), wantDate);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> workAuthorizationIdIsNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNull(vmSysWorkAuthChangeHistoryVistool.get("workAuthorizationId"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> workAuthorizationIdIsNotNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNotNull(vmSysWorkAuthChangeHistoryVistool.get("workAuthorizationId"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> workAuthorizationIdEqualTo(
            String workAuthorizationId) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .equal(vmSysWorkAuthChangeHistoryVistool.get("workAuthorizationId"), workAuthorizationId);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> workAuthorizationIdNotEqualTo(
            String workAuthorizationId) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .notEqual(vmSysWorkAuthChangeHistoryVistool.get("workAuthorizationId"), workAuthorizationId);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> workAuthorizationIdInSet(
            Set<String> workAuthorizationIdList) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> {
            Path<VmSysWorkAuthDetailChangeHistoryVistool> workAuthPath = vmSysWorkAuthChangeHistoryVistool
                    .get("workAuthorizationId");
            return workAuthPath.in(workAuthorizationIdList);
        };
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeCommentIsNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNull(vmSysWorkAuthChangeHistoryVistool.get("changeComment"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeCommentIsNotNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNotNull(vmSysWorkAuthChangeHistoryVistool.get("changeComment"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeCommentEqualTo(String changeComment) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .equal(vmSysWorkAuthChangeHistoryVistool.get("changeComment"), changeComment);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeCommentNotEqualTo(String changeComment) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .notEqual(vmSysWorkAuthChangeHistoryVistool.get("changeComment"), changeComment);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeLineHeaderIdIsNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNull(vmSysWorkAuthChangeHistoryVistool.get("changeLineHeaderId"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeLineHeaderIdIsNotNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNotNull(vmSysWorkAuthChangeHistoryVistool.get("changeLineHeaderId"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeLineHeaderIdEqualTo(
            Integer changeLineHeaderId) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .equal(vmSysWorkAuthChangeHistoryVistool.get("changeLineHeaderId"), changeLineHeaderId);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeLineHeaderIdNotEqualTo(
            Integer changeLineHeaderId) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .notEqual(vmSysWorkAuthChangeHistoryVistool.get("changeLineHeaderId"), changeLineHeaderId);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeLineHeaderIdLessThan(
            Integer changeLineHeaderId) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .lessThan(vmSysWorkAuthChangeHistoryVistool.get("changeLineHeaderId"), changeLineHeaderId);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeLineHeaderIdGreaterThan(
            Integer changeLineHeaderId) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .greaterThan(vmSysWorkAuthChangeHistoryVistool.get("changeLineHeaderId"), changeLineHeaderId);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeHeaderIdIsNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNull(vmSysWorkAuthChangeHistoryVistool.get("changeHeaderId"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeHeaderIdIsNotNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNotNull(vmSysWorkAuthChangeHistoryVistool.get("changeHeaderId"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeHheaderIdEqualTo(Integer headerId) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .equal(vmSysWorkAuthChangeHistoryVistool.get("changeHeaderId"), headerId);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeHeaderIdNotEqualTo(Integer headerId) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .notEqual(vmSysWorkAuthChangeHistoryVistool.get("changeHeaderId"), headerId);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeHeaderIdLessThan(Integer headerId) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .lessThan(vmSysWorkAuthChangeHistoryVistool.get("changeHeaderId"), headerId);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeHeaderIdGreaterThan(Integer headerId) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .greaterThan(vmSysWorkAuthChangeHistoryVistool.get("changeHeaderId"), headerId);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeHeaderStopOrderIsNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNull(vmSysWorkAuthChangeHistoryVistool.get("changeHeaderStopOrder"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeHeaderStopOrderIsNotNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNotNull(vmSysWorkAuthChangeHistoryVistool.get("changeHeaderStopOrder"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeHeaderStopOrderEqualTo(
            Boolean changeHeaderStopOrder) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .equal(vmSysWorkAuthChangeHistoryVistool.get("changeHeaderStopOrder"), changeHeaderStopOrder);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeHeaderStopOrderNotEqualTo(
            Boolean changeHeaderStopOrder) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .notEqual(vmSysWorkAuthChangeHistoryVistool.get("changeHeaderStopOrder"), changeHeaderStopOrder);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeHeaderStopOrderIsTrue() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isTrue(vmSysWorkAuthChangeHistoryVistool.get("changeHeaderStopOrder"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeHeaderStopOrderIsFalse() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isFalse(vmSysWorkAuthChangeHistoryVistool.get("changeHeaderStopOrder"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeLineItemNumberIsNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNull(vmSysWorkAuthChangeHistoryVistool.get("changeLineItemNumber"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeLineItemNumberIsNotNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNotNull(vmSysWorkAuthChangeHistoryVistool.get("changeLineItemNumber"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeLineItemNumberEqualTo(
            String changeLineItemNumber) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .equal(vmSysWorkAuthChangeHistoryVistool.get("changeLineItemNumber"), changeLineItemNumber);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeLineItemNumberNotEqualTo(
            String changeLineItemNumber) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .notEqual(vmSysWorkAuthChangeHistoryVistool.get("changeLineItemNumber"), changeLineItemNumber);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeLineIdIsNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNull(vmSysWorkAuthChangeHistoryVistool.get("changeLineId"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeLineIdIsNotNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNotNull(vmSysWorkAuthChangeHistoryVistool.get("changeLineId"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeLineIdEqualTo(Integer changeLineId) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .equal(vmSysWorkAuthChangeHistoryVistool.get("changeLineId"), changeLineId);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeLineIdNotEqualTo(Integer changeLineId) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .notEqual(vmSysWorkAuthChangeHistoryVistool.get("lineId"), changeLineId);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeLineIdLessThan(Integer changeLineId) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .lessThan(vmSysWorkAuthChangeHistoryVistool.get("changeLineId"), changeLineId);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeLineIdGreaterThan(Integer changeLineId) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .greaterThan(vmSysWorkAuthChangeHistoryVistool.get("changeLineId"), changeLineId);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeLineStopOrderIsNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNull(vmSysWorkAuthChangeHistoryVistool.get("changeLineStopOrder"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeLineStopOrderIsNotNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNotNull(vmSysWorkAuthChangeHistoryVistool.get("changeLineStopOrder"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeLineStopOrderEqualTo(
            Boolean changeLineStopOrder) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .equal(vmSysWorkAuthChangeHistoryVistool.get("changeLineStopOrder"), changeLineStopOrder);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeLineStopOrderNotEqualTo(
            Boolean changeLineStopOrder) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .notEqual(vmSysWorkAuthChangeHistoryVistool.get("changeLineStopOrder"), changeLineStopOrder);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeLineStopOrderIsTrue() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isTrue(vmSysWorkAuthChangeHistoryVistool.get("changeLineStopOrder"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeLineStopOrderIsFalse() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isFalse(vmSysWorkAuthChangeHistoryVistool.get("changeLineStopOrder"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeLineQuantityIsNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNull(vmSysWorkAuthChangeHistoryVistool.get("changeLineQuantity"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeLineQuantityIsNotNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNotNull(vmSysWorkAuthChangeHistoryVistool.get("changeLineQuantity"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeLineQuantityEqualTo(
            Integer changeLineQuantity) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .equal(vmSysWorkAuthChangeHistoryVistool.get("changeLineQuantity"), changeLineQuantity);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeLineQuantityNotEqualTo(
            Integer changeLineQuantity) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .notEqual(vmSysWorkAuthChangeHistoryVistool.get("changeLineQuantity"), changeLineQuantity);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeLineQuantityLessThan(
            Integer changeLineQuantity) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .lessThan(vmSysWorkAuthChangeHistoryVistool.get("changeLineQuantity"), changeLineQuantity);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeLineQuantityGreaterThan(
            Integer changeLineQuantity) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .greaterThan(vmSysWorkAuthChangeHistoryVistool.get("changeLineQuantity"), changeLineQuantity);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> requestorIsNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNull(vmSysWorkAuthChangeHistoryVistool.get("requestor"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> requestorIsNotNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNotNull(vmSysWorkAuthChangeHistoryVistool.get("requestor"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> requestorEqualTo(String requestor) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .equal(vmSysWorkAuthChangeHistoryVistool.get("requestor"), requestor);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> requestorNotEqualTo(String requestor) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .notEqual(vmSysWorkAuthChangeHistoryVistool.get("requestor"), requestor);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeLineSplitIdIsNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNull(vmSysWorkAuthChangeHistoryVistool.get("changeLineSplitId"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeLineSplitIdIsNotNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNotNull(vmSysWorkAuthChangeHistoryVistool.get("changeLineSplitId"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeLineSplitIdEqualTo(String changeLineSplitId) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb.equal(
                vmSysWorkAuthChangeHistoryVistool.get("changeLineSplitId"),
                changeLineSplitId);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeLineSplitIdNotEqualTo(
            String changeLineSplitId) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .notEqual(vmSysWorkAuthChangeHistoryVistool.get("changeLineSplitId"), changeLineSplitId);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeSubmitDateIsNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNull(vmSysWorkAuthChangeHistoryVistool.get("changeSubmitDate"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeSubmitDateIsNotNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNotNull(vmSysWorkAuthChangeHistoryVistool.get("changeSubmitDate"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeSubmitDateEqualTo(Date changeSubmitDate) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .equal(vmSysWorkAuthChangeHistoryVistool.get("changeSubmitDate"), changeSubmitDate);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeSubmitDateNotEqualTo(Date changeSubmitDate) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .notEqual(vmSysWorkAuthChangeHistoryVistool.get("changeSubmitDate"), changeSubmitDate);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeSubmitDateBefore(Date changeSubmitDate) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .lessThan(vmSysWorkAuthChangeHistoryVistool.get("changeSubmitDate"), changeSubmitDate);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeSubmitDateAfter(Date changeSubmitDate) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .greaterThan(vmSysWorkAuthChangeHistoryVistool.get("changeSubmitDate"), changeSubmitDate);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeSubmitDateOnOrAfter(Date changeSubmitDate) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .greaterThanOrEqualTo(vmSysWorkAuthChangeHistoryVistool.get("changeSubmitDate"), changeSubmitDate);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> subIdIsNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb.isNull(vmSysWorkAuthChangeHistoryVistool.get("subId"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> subIdIsNotNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNotNull(vmSysWorkAuthChangeHistoryVistool.get("subId"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> subIdEqualTo(String subId) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb.equal(vmSysWorkAuthChangeHistoryVistool.get("subId"),
                subId);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> subIdNotEqualTo(String subId) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .notEqual(vmSysWorkAuthChangeHistoryVistool.get("subId"), subId);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeTaIsNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNull(vmSysWorkAuthChangeHistoryVistool.get("changeTa"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeTaIsNotNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNotNull(vmSysWorkAuthChangeHistoryVistool.get("changeTa"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeTaEqualTo(String changeTa) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .equal(vmSysWorkAuthChangeHistoryVistool.get("changeTa"), changeTa);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeTaNotEqualTo(String changeTa) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .notEqual(vmSysWorkAuthChangeHistoryVistool.get("changeTa"), changeTa);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeWorkAuthorizationIdIsNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNull(vmSysWorkAuthChangeHistoryVistool.get("changeWorkAuthorizationId"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeWorkAuthorizationIdIsNotNull() {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .isNotNull(vmSysWorkAuthChangeHistoryVistool.get("changeWorkAuthorizationId"));
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeWorkAuthorizationIdEqualTo(
            String changeWorkAuthorizationId) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .equal(vmSysWorkAuthChangeHistoryVistool.get("changeWorkAuthorizationId"), changeWorkAuthorizationId);
    }

    static Specification<VmSysWorkAuthDetailChangeHistoryVistool> changeWorkAuthorizationIdNotEqualTo(
            String changeWorkAuthorizationId) {
        return (vmSysWorkAuthChangeHistoryVistool, cq, cb) -> cb
                .notEqual(vmSysWorkAuthChangeHistoryVistool.get("changeWorkAuthorizationId"),
                        changeWorkAuthorizationId);
    }
}
