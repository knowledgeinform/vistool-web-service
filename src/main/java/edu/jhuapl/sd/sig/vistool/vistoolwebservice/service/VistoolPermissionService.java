package edu.jhuapl.sd.sig.vistool.vistoolwebservice.service;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.VistoolRoleFieldPermission;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.vistool.VistoolRoleFieldPermissionRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VistoolPermissionService {
    private static final String WILDCARD_FIELD_PERMISSION = "*";

    @Autowired
    private VistoolRoleFieldPermissionRepository vistoolRoleFieldPermissionRepository;

    public List<VistoolRoleFieldPermission> findAllPermissionsByRole(@NonNull String vistoolUserRole) {
        return vistoolRoleFieldPermissionRepository.findAll(
            Specification.where(
                VistoolRoleFieldPermissionRepository.hasRole(vistoolUserRole)
            )
        );
    }

    public List<String> findAllEditableFieldBindingsByRole(@NonNull String vistoolUserRole) {
        return findAllPermissionsByRole(vistoolUserRole)
            .stream()
            .map(VistoolRoleFieldPermission::getFieldBinding)
            .collect(Collectors.toList());
    }

    public boolean canEditFields(@NonNull String vistoolUserRole, @NonNull List<String> changedFields) {
        if (changedFields.isEmpty()) {
            return true;
        }

        List<String> editableFieldBindings = findAllEditableFieldBindingsByRole(vistoolUserRole);

        if (editableFieldBindings.contains(WILDCARD_FIELD_PERMISSION)) {
            return true;
        }

        return editableFieldBindings.containsAll(changedFields);
    }
}