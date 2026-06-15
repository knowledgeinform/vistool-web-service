package edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.vistool;

import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.ArchivedLineItem;

@Repository
public interface ArchivedLineItemRepository extends JpaRepository<ArchivedLineItem, Long>, JpaSpecificationExecutor<ArchivedLineItem> {
    static Specification<ArchivedLineItem> idEqualTo(Long id) {
        return (lineItem, cq, cb) -> cb.equal(lineItem.get("id"), id);
    }
    static Specification<ArchivedLineItem> idMaximum() {
        return (lineItem, cq, cb) -> {
            Subquery<Long> sq = cq.subquery(Long.class);
            Root<ArchivedLineItem> subRoot = sq.from(ArchivedLineItem.class);
            sq.select(cb.greatest(subRoot.<Long>get("id")));
            return cb.equal(lineItem.<Long>get("id"), sq);
        };
    }
    static Specification<ArchivedLineItem> versionEqualTo(Long version) {
        return (lineItem, cq, cb) -> cb.equal(lineItem.get("version"), version);
    }
    static Specification<ArchivedLineItem> versionMaximum() {
        return (lineItem, cq, cb) ->
        {
            Subquery<Long> sq = cq.subquery(Long.class);
            Root<ArchivedLineItem> subRoot = sq.from(ArchivedLineItem.class);
            sq.select(cb.greatest(subRoot.<Long>get("version")));
            sq.where(cb.equal(lineItem.get("id"), subRoot.get("id")));
            return cb.equal(lineItem.<Long>get("version"), sq);
        };
    }
    static Specification<ArchivedLineItem> workAuthorizationNumberEqualTo(String workAuthorizationNumber) {
        return (lineItem, cq, cb) -> cb.equal(lineItem.get("workAuthorizationNumber"), workAuthorizationNumber);
    }
    static Specification<ArchivedLineItem> lineItemNumberEqualTo(String lineItemNumber) {
        return (lineItem, cq, cb) -> cb.equal(lineItem.get("lineItemNumber"), lineItemNumber);
    }
}
