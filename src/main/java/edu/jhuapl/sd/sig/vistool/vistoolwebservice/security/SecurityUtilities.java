package edu.jhuapl.sd.sig.vistool.vistoolwebservice.security;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.VistoolUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SecurityUtilities {
    @Value("${vistool.security.enabled}") private boolean vistoolSecurityEnabled;

    public Optional<VistoolUser> getCurrentUser() {
        if(vistoolSecurityEnabled) {
            try {
                Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                if (principal instanceof VistoolUser) {
                    VistoolUser vistoolUser = (VistoolUser) principal;
                    return Optional.of(vistoolUser);
                }
            } catch(Exception e) {
                return Optional.empty();
            }
        }
        return Optional.empty();
    }
}
