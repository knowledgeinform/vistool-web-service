package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.io.Serializable;
import java.util.Collection;

@Data
public class VistoolUser extends User implements Serializable {
    private String username;
    private String department;
    private String displayName;
    private String email;
    private String employeeId;
    private String employeeGroup;
    private String officeBuildingNumber;
    private String phoneNumber;
    private VistoolUserRole vistoolUserRole;
    private VistoolUserAccountType accountType = VistoolUserAccountType.USER;

    public VistoolUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.username = username;
        vistoolUserRole = VistoolUserRole.VIEWER;
    }

    public VistoolUser(String username, String password, Collection<? extends GrantedAuthority> authorities,
                       VistoolUserRole vistoolUserRole) {
        super(username, password, authorities);
        this.username = username;
        this.vistoolUserRole = vistoolUserRole;
    }

    public VistoolUser(VistoolUser vistoolUser, String password, Collection<? extends GrantedAuthority> authorities,
                       VistoolUserRole vistoolUserRole) {
        super(vistoolUser.getUsername(), password, authorities);
        this.username = vistoolUser.getUsername();
        this.department = vistoolUser.getDepartment();
        this.displayName = vistoolUser.getDisplayName();
        this.email = vistoolUser.getEmail();
        this.employeeId = vistoolUser.getEmployeeId();
        this.employeeGroup = vistoolUser.getEmployeeGroup();
        this.officeBuildingNumber = vistoolUser.getOfficeBuildingNumber();
        this.phoneNumber = vistoolUser.getPhoneNumber();
        this.vistoolUserRole = vistoolUserRole;
    }
}
