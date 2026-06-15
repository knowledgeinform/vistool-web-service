package edu.jhuapl.sd.sig.vistool.vistoolwebservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.authentication.event.LogoutSuccessEvent;
import org.springframework.security.core.session.SessionDestroyedEvent;
import org.springframework.security.web.session.HttpSessionCreatedEvent;
import org.springframework.stereotype.Component;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.VistoolUser;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.VistoolUserAccountType;
import lombok.extern.log4j.Log4j2;

import javax.servlet.http.HttpSession;

@Log4j2
@Component
public class SessionListener implements ApplicationListener<ApplicationEvent> {

    @Autowired
    HttpSession httpSession;

    @Autowired
    SecurityUtilities securityUtilities;

    @Override    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if(applicationEvent instanceof HttpSessionCreatedEvent) {
            log.info("Session created!");
        } else if( applicationEvent instanceof SessionDestroyedEvent) {
            VistoolUser user = (VistoolUser)securityUtilities.getCurrentUser().get();
            if (user.getAccountType() == VistoolUserAccountType.SERVICE) {
                return;
            }
            log.info("[Session expired]: " + user.getUsername());
        } else if(applicationEvent instanceof AuthenticationSuccessEvent) {
            VistoolUserAccountType accountType = (VistoolUserAccountType)((VistoolUser)((AuthenticationSuccessEvent) applicationEvent).getAuthentication().getPrincipal()).getAccountType();
            if (accountType == VistoolUserAccountType.SERVICE) {
                return;
            }
            log.info("[Login]: " + ((VistoolUser)((AuthenticationSuccessEvent) applicationEvent).getAuthentication().getPrincipal()).getUsername());
        } else if(applicationEvent instanceof LogoutSuccessEvent) {
            VistoolUserAccountType accountType = (VistoolUserAccountType)((VistoolUser)((LogoutSuccessEvent) applicationEvent).getAuthentication().getPrincipal()).getAccountType();
            if (accountType == VistoolUserAccountType.SERVICE) {
                return;
            }
            log.info("[Logout]: "  + ((VistoolUser)((LogoutSuccessEvent) applicationEvent).getAuthentication().getPrincipal()).getUsername());
        }
    }
}
