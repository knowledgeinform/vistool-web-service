package edu.jhuapl.sd.sig.vistool.vistoolwebservice.security;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.VistoolUserAccountType;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.VistoolUserRole;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.VistoolUserRoleAssignment;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.service.VistoolUserRoleAssignmentService;
import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.DefaultDirObjectFactory;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.ldap.query.LdapQuery;
import org.springframework.ldap.query.SearchScope;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

import java.util.ArrayList;
import java.util.Optional;


@Log4j2
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private VistoolUserRoleAssignmentService vistoolUserRoleAssignmentService;

    @Value("${ldap.svcaccount.username}")
    private String ldapServiceAccountUsername;
    @Value("${ldap.svcaccount.password}")
    private String ldapServiceAccountPassword;
    @Value("${ldap.url}")
    private String ldapUrl;
    @Value("${ldap.query.base}")
    private String ldapQueryBase;
    @Value("${ldap.query.userAccountAttribute}")
    private String ldapQueryUserAccountAttribute;


    public CustomAuthenticationProvider() {
    }

    private LdapTemplate ldapTemplate;

    private void initLdapTemplate() {
        if (ldapTemplate == null) {
            LdapContextSource lcs = new LdapContextSource();

            lcs.setUrl(ldapUrl);
            lcs.setUserDn(ldapServiceAccountUsername);
            lcs.setPassword(ldapServiceAccountPassword);
            lcs.setDirObjectFactory(DefaultDirObjectFactory.class);
            lcs.setBase(ldapQueryBase);
            lcs.afterPropertiesSet();
            ldapTemplate = new LdapTemplate(lcs);
        }
    }

    @Override
    public Authentication authenticate(Authentication authentication) {
        initLdapTemplate();

        try {
            LdapQuery query = query()
                    .searchScope(SearchScope.SUBTREE)
                    // .base(ldapQueryBase)
                    .where(ldapQueryUserAccountAttribute)
                    .is(authentication.getPrincipal().toString());

            ldapTemplate.authenticate(query, authentication.getCredentials().toString());
            VistoolUserDetailsContextMapper vistoolUserDetailsContextMapper = new VistoolUserDetailsContextMapper();
            UserDetails userDetails = vistoolUserDetailsContextMapper.mapUserFromContext(
                    ldapTemplate.searchForContext(query), authentication.getName(), new ArrayList<>());
            Authentication auth = new UsernamePasswordAuthenticationToken(userDetails,
                    authentication.getCredentials().toString(), new ArrayList<>());

            if (vistoolUserDetailsContextMapper.getVistoolUser().getAccountType() == VistoolUserAccountType.SERVICE) {
                Optional<VistoolUserRoleAssignment> optionalVistoolUserRoleAssignment = vistoolUserRoleAssignmentService
                        .findOneVistoolUserRoleAssignmentByUserId(userDetails.getUsername());

                if (!optionalVistoolUserRoleAssignment.isPresent()) {
                    vistoolUserRoleAssignmentService.changeUserRole(userDetails.getUsername(), VistoolUserRole.VIEWER);
                }
            }
            return auth;
        } catch (Exception e) {
            log.error("Failed to authenticate user {}", authentication.getPrincipal().toString(), e);
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
