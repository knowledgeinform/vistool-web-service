package edu.jhuapl.sd.sig.vistool.vistoolwebservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.VistoolUserRole;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.service.VistoolUserRoleAssignmentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

@Log4j2
@Component
public class VistoolApplicationInitializer {
    @Autowired private ObjectMapper objectMapper;
    @Autowired private VistoolUserRoleAssignmentService vistoolUserRoleAssignmentService;
    @Value("${vistool.security.enabled}") private boolean vistoolSecurityEnabled;
    @Value("classpath:initial-admins.json") private Resource initialAdministratorsResource;

    public void loadDefaultVistoolUserRoleAssignments() {
        if(vistoolSecurityEnabled) {
            try {
                List<String> initialAdministrators = objectMapper.readValue(initialAdministratorsResource.getFile(),
                        objectMapper.getTypeFactory().constructCollectionType(List.class, String.class));
                for(String userId : initialAdministrators) {
                    vistoolUserRoleAssignmentService.changeUserRole(userId, VistoolUserRole.ADMIN);
                }
            } catch (Exception e) {
                log.error("Failed to load default administrators file!", e);
            }
        }
    }
}
