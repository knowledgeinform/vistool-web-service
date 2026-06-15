package edu.jhuapl.sd.sig.vistool.vistoolwebservice.security;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.VistoolUser;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.VistoolUserAccountType;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.VistoolUtilities;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.ldap.core.DirContextAdapter;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.ldap.userdetails.UserDetailsContextMapper;

import java.util.Collection;
import java.util.Collections;

import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.constants.ldap.LdapConstants.*;

@Log4j2
@Data
public class VistoolUserDetailsContextMapper implements UserDetailsContextMapper {
    private VistoolUser vistoolUser;

    public VistoolUserDetailsContextMapper() {
        super();
    }

    @Override
    public UserDetails mapUserFromContext(DirContextOperations ctx, String username, Collection<? extends GrantedAuthority> authorities) {
        vistoolUser = new VistoolUser(username, "", Collections.emptyList());
        String destinationIndicator = ctx.getStringAttribute(DESTINATION_INDICATOR);
        if (!VistoolUtilities.isStringNullOrEmpty(destinationIndicator) && destinationIndicator.contains("/")) {
            String[] destinationIndicatorValues = destinationIndicator.split("/");
            vistoolUser.setDepartment(destinationIndicatorValues[0]);
            vistoolUser.setEmployeeGroup(destinationIndicatorValues[1]);
        }
        vistoolUser.setDisplayName(ctx.getStringAttribute(DISPLAY_NAME));
        vistoolUser.setEmail(ctx.getStringAttribute(MAIL));

        String employeeId = ctx.getStringAttribute(EMPLOYEE_NUMBER);
        if (ctx.getStringAttribute("distinguishedname").toLowerCase().contains("ou=service accounts") && (employeeId == null || employeeId.trim().length() == 0)) {
            employeeId = username;
            vistoolUser.setAccountType(VistoolUserAccountType.SERVICE);
        }

        vistoolUser.setEmployeeId(employeeId);
        vistoolUser.setOfficeBuildingNumber(ctx.getStringAttribute(PHYSICAL_DELIVERY_OFFICE_NAME));
        vistoolUser.setPhoneNumber(ctx.getStringAttribute(TELEPHONE_NUMBER));

        return vistoolUser;
    }

    @Override
    public void mapUserToContext(UserDetails userDetails, DirContextAdapter dirContextAdapter) {
    }
}
