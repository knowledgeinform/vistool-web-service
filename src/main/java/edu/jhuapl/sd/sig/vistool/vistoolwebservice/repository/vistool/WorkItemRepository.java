package edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.vistool;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.AbstractLineItem;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.WorkItem;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

@Repository
public interface WorkItemRepository extends JpaRepository<WorkItem, Long>, JpaSpecificationExecutor<WorkItem> {
    static Specification<WorkItem> idEqualTo(Long id) {
        return (workItem, cq, cb) -> cb.equal(workItem.get("id"), id);
    }
    static Specification<WorkItem> idMaximum() {
        return (workItem, cq, cb) -> {
            Subquery<Long> sq = cq.subquery(Long.class);
            Root<WorkItem> subRoot = sq.from(WorkItem.class);
            sq.select(cb.greatest(subRoot.<Long>get("id")));
            return cb.equal(workItem.<Long>get("id"), sq);
        };
    }
    static Specification<WorkItem> versionEqualTo(Long version) {
        return (workItem, cq, cb) -> cb.equal(workItem.get("version"), version);
    }
    // static Specification<WorkItem> versionMaximum() {
    //     return (workItem, cq, cb) ->
    //     {
    //         Subquery<Long> sq = cq.subquery(Long.class);
    //         Root<WorkItem> subRoot = sq.from(WorkItem.class);
    //         sq.select(cb.greatest(subRoot.<Long>get("version")));
    //         sq.where(cb.equal(workItem.get("id"), subRoot.get("id")));
    //         return cb.equal(workItem.<Long>get("version"), sq);
    //     };
    // }
    static Specification<WorkItem> parentLineItemEqualTo(AbstractLineItem parentLineItem) {
        return (workItem, cq, cb) -> cb.equal(workItem.get("parentLineItem"), parentLineItem);
    }
}
