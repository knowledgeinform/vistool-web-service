package edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.vistool;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.VistoolUserRoleAssignment;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VistoolUserRoleAssignmentRepository extends JpaRepository<VistoolUserRoleAssignment, Long>, JpaSpecificationExecutor<VistoolUserRoleAssignment> {
    public static Specification<VistoolUserRoleAssignment> userIdEqualTo(String userId) {
        return (vistoolUserRoleAssignment, cq, cb) -> cb.equal(vistoolUserRoleAssignment.get("userId"), userId);
    }
    public static Specification<VistoolUserRoleAssignment> hasRole(String role) {
        return (vistoolUserRoleAssignment, cq, cb) -> cb.equal(vistoolUserRoleAssignment.get("role"), role);
    }
}
