package edu.jhuapl.sd.sig.vistool.vistoolwebservice.service;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.VistoolUserRoleAssignment;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.vistool.VistoolUserRoleAssignmentRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VistoolUserRoleAssignmentService {
    @Autowired
    private VistoolUserRoleAssignmentRepository vistoolUserRoleAssignmentRepository;

    public VistoolUserRoleAssignment changeUserRole(String userId, String vistoolUserRole) {
        return vistoolUserRoleAssignmentRepository.save(
            new VistoolUserRoleAssignment(userId, vistoolUserRole)
        );
    }

    public Optional<VistoolUserRoleAssignment> findOneVistoolUserRoleAssignmentByUserId(@NonNull String userId) {
        return vistoolUserRoleAssignmentRepository.findOne(
            Specification.where(
                VistoolUserRoleAssignmentRepository.userIdEqualTo(userId)
            )
        );
    }

    public List<VistoolUserRoleAssignment> findAllVistoolUserRoleAssignmentsByRole(@NonNull String vistoolUserRole) {
        return vistoolUserRoleAssignmentRepository.findAll(
            Specification.where(
                VistoolUserRoleAssignmentRepository.hasRole(vistoolUserRole)
            )
        );
    }
}