package edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.denodo;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.VeWoLaborTotals;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VeWoLaborTotalsRepository extends JpaRepository<VeWoLaborTotals, Long>, JpaSpecificationExecutor<VeWoLaborTotals> {
    static Specification<VeWoLaborTotals> laborTotalsIsNull() {
        return (veWoLaborTotals, cq, cb) -> cb.isNull(veWoLaborTotals.get("laborTotals"));
    }
    static Specification<VeWoLaborTotals> laborTotalsIsNotNull() {
        return (veWoLaborTotals, cq, cb) -> cb.isNotNull(veWoLaborTotals.get("laborTotals"));
    }
    static Specification<VeWoLaborTotals> laborTotalsEqualTo(Double laborTotals) {
        return (veWoLaborTotals, cq, cb) -> cb.equal(veWoLaborTotals.get("laborTotals"), laborTotals);
    }
    static Specification<VeWoLaborTotals> laborTotalsNotEqualTo(Double laborTotals) {
        return (veWoLaborTotals, cq, cb) -> cb.notEqual(veWoLaborTotals.get("laborTotals"), laborTotals);
    }
    static Specification<VeWoLaborTotals> laborTotalsLessThan(Double laborTotals) {
        return (veWoLaborTotals, cq, cb) -> cb.lessThan(veWoLaborTotals.get("laborTotals"), laborTotals);
    }
    static Specification<VeWoLaborTotals> laborTotalsGreaterThan(Double laborTotals) {
        return (veWoLaborTotals, cq, cb) -> cb.greaterThan(veWoLaborTotals.get("laborTotals"), laborTotals);
    }
    static Specification<VeWoLaborTotals> typeIsNull() {
        return (veWoLaborTotals, cq, cb) -> cb.isNull(veWoLaborTotals.get("type"));
    }
    static Specification<VeWoLaborTotals> typeIsNotNull() {
        return (veWoLaborTotals, cq, cb) -> cb.isNotNull(veWoLaborTotals.get("type"));
    }
    static Specification<VeWoLaborTotals> typeEqualTo(String type) {
        return (veWoLaborTotals, cq, cb) -> cb.equal(veWoLaborTotals.get("type"), type);
    }
    static Specification<VeWoLaborTotals> typeNotEqualTo(String type) {
        return (veWoLaborTotals, cq, cb) -> cb.notEqual(veWoLaborTotals.get("type"), type);
    }
    static Specification<VeWoLaborTotals> workOrderNumberIsNull() {
        return (veWoLaborTotals, cq, cb) -> cb.isNull(veWoLaborTotals.get("workOrderNumber"));
    }
    static Specification<VeWoLaborTotals> workOrderNumberIsNotNull() {
        return (veWoLaborTotals, cq, cb) -> cb.isNotNull(veWoLaborTotals.get("workOrderNumber"));
    }
    static Specification<VeWoLaborTotals> workOrderNumberEqualTo(String workOrderNumber) {
        return (veWoLaborTotals, cq, cb) -> cb.equal(veWoLaborTotals.get("workOrderNumber"), workOrderNumber);
    }
    static Specification<VeWoLaborTotals> workOrderNumberNotEqualTo(String workOrderNumber) {
        return (veWoLaborTotals, cq, cb) -> cb.notEqual(veWoLaborTotals.get("workOrderNumber"), workOrderNumber);
    }
}
