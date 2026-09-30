package edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.vistool;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.VistoolRoleFieldPermission;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VistoolRoleFieldPermissionRepository
        extends JpaRepository<VistoolRoleFieldPermission, Long>, JpaSpecificationExecutor<VistoolRoleFieldPermission> {

    public static Specification<VistoolRoleFieldPermission> hasRole(String role) {
        return (permission, cq, cb) -> cb.equal(permission.get("role"), role);
    }

    public static Specification<VistoolRoleFieldPermission> fieldBindingEqualTo(String fieldBinding) {
        return (permission, cq, cb) -> cb.equal(permission.get("fieldBinding"), fieldBinding);
    }
}