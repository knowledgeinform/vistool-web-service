package edu.jhuapl.sd.sig.vistool.vistoolwebservice.repository.vistool;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.WaChanges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WaChangesRepository extends JpaRepository<WaChanges, String> {
    Optional<WaChanges> findOneByWorkAuthorizationIdAndPartId(String workAuthorizationId, String partId);
}
