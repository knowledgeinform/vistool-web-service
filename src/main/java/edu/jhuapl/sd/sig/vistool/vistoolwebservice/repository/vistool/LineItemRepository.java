package edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.vistool;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.LineItem;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

@Repository
public interface LineItemRepository extends JpaRepository<LineItem, Long>, JpaSpecificationExecutor<LineItem> {
    static Specification<LineItem> idEqualTo(Long id) {
        return (lineItem, cq, cb) -> cb.equal(lineItem.get("id"), id);
    }
    static Specification<LineItem> idMaximum() {
        return (lineItem, cq, cb) -> {
            Subquery<Long> sq = cq.subquery(Long.class);
            Root<LineItem> subRoot = sq.from(LineItem.class);
            sq.select(cb.greatest(subRoot.<Long>get("id")));
            return cb.equal(lineItem.<Long>get("id"), sq);
        };
    }
    static Specification<LineItem> versionEqualTo(Long version) {
        return (lineItem, cq, cb) -> cb.equal(lineItem.get("version"), version);
    }
    static Specification<LineItem> workAuthorizationNumberEqualTo(String workAuthorizationNumber) {
        return (lineItem, cq, cb) -> cb.equal(lineItem.<String>get("workAuthorizationNumber"), workAuthorizationNumber);
    }
    static Specification<LineItem> lineItemNumberEqualTo(String lineItemNumber) {
        return (lineItem, cq, cb) -> cb.equal(lineItem.<String>get("lineItemNumber"), lineItemNumber);
    }
}
