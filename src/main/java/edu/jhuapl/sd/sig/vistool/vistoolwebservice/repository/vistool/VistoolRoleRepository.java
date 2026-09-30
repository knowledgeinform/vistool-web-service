package edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.vistool;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.VistoolRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VistoolRoleRepository extends JpaRepository<VistoolRole, String> {
}