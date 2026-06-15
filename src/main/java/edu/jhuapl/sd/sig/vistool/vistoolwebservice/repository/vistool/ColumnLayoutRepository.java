package edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.vistool;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.ColumnLayout;
import org.springframework.data.jpa.domain.Specification;
@Repository
public interface ColumnLayoutRepository extends JpaRepository<ColumnLayout, Long>, JpaSpecificationExecutor<ColumnLayout>{
    public static Specification<ColumnLayout> userIdEqualTo(String userId) {
        return (columnLayout, cq, cb) -> cb.equal(columnLayout.get("userId"), userId); 
    }

    public static Specification<ColumnLayout> matchesVisibility(boolean visible) {
        return (columnLayout, cq, cb) -> cb.equal(columnLayout.get("isVisible"), visible);
    }

    public static Specification<ColumnLayout> columnLayoutIdEqualTo(int id) {
        return (columnLayout, cq, cb) -> cb.equal(columnLayout.get("id"), (long) id);
    }
}
