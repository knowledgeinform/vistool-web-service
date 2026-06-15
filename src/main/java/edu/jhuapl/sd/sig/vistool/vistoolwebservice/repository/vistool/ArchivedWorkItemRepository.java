package edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.vistool;

import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.ArchivedWorkItem;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.LineItem;

@Repository
public interface ArchivedWorkItemRepository extends JpaRepository<ArchivedWorkItem, Long>, JpaSpecificationExecutor<ArchivedWorkItem> {
    static Specification<ArchivedWorkItem> idEqualTo(Long id) {
        return (workItem, cq, cb) -> cb.equal(workItem.get("id"), id);
    }
    static Specification<ArchivedWorkItem> idMaximum() {
        return (workItem, cq, cb) -> {
            Subquery<Long> sq = cq.subquery(Long.class);
            Root<ArchivedWorkItem> subRoot = sq.from(ArchivedWorkItem.class);
            sq.select(cb.greatest(subRoot.<Long>get("id")));
            return cb.equal(workItem.<Long>get("id"), sq);
        };
    }
    static Specification<ArchivedWorkItem> versionEqualTo(Long version) {
        return (workItem, cq, cb) -> cb.equal(workItem.get("version"), version);
    }
    static Specification<ArchivedWorkItem> versionMaximum() {
        return (workItem, cq, cb) ->
        {
            Subquery<Long> sq = cq.subquery(Long.class);
            Root<ArchivedWorkItem> subRoot = sq.from(ArchivedWorkItem.class);
            sq.select(cb.greatest(subRoot.<Long>get("version")));
            sq.where(cb.equal(workItem.get("id"), subRoot.get("id")));
            return cb.equal(workItem.<Long>get("version"), sq);
        };
    }
    static Specification<ArchivedWorkItem> parentLineItemEqualTo(LineItem parentLineItem) {
        return (workItem, cq, cb) -> cb.equal(workItem.get("parentLineItem"), parentLineItem);
    }
    
}
