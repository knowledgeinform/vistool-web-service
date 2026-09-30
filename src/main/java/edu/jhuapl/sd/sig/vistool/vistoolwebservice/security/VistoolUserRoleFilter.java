package edu.jhuapl.sd.sig.vistool.vistoolwebservice.security;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.VistoolUser;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.VistoolUserRole;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.VistoolUserRoleAssignment;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.service.VistoolUserRoleAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class VistoolUserRoleFilter implements Filter {
    @Value("${vistool.security.enabled}")
    private boolean vistoolSecurityEnabled;

    @Autowired
    private SecurityUtilities securityUtilities;

    @Autowired
    private VistoolUserRoleAssignmentService vistoolUserRoleAssignmentService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        if (vistoolSecurityEnabled) {
            Optional<VistoolUser> optionalVistoolUser = securityUtilities.getCurrentUser();
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

            if (optionalVistoolUser.isPresent()) {
                Optional<VistoolUserRoleAssignment> optionalVistoolUserRoleAssignment =
                    vistoolUserRoleAssignmentService.findOneVistoolUserRoleAssignmentByUserId(
                        optionalVistoolUser.get().getEmployeeId()
                    );

                String vistoolUserRole;

                if (optionalVistoolUserRoleAssignment.isPresent()) {
                    vistoolUserRole = optionalVistoolUserRoleAssignment.get().getRole();
                } else {
                    vistoolUserRole = VistoolUserRole.VIEWER;
                    vistoolUserRoleAssignmentService.changeUserRole(
                        optionalVistoolUser.get().getEmployeeId(),
                        vistoolUserRole
                    );
                }

                grantedAuthorities.add(new SimpleGrantedAuthority(vistoolUserRole));

                Authentication authentication = new UsernamePasswordAuthenticationToken(
                    new VistoolUser(
                        optionalVistoolUser.get(),
                        "",
                        grantedAuthorities,
                        vistoolUserRole
                    ),
                    SecurityContextHolder.getContext().getAuthentication().getCredentials(),
                    grantedAuthorities
                );

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        chain.doFilter(request, response);
    }
}