package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.DimHRPerson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VistoolUserDTO {
    private String username;
    private String department;
    private String displayName;
    private String email;
    private String employeeId;
    private String employeeGroup;
    private String officeBuildingNumber;
    private String phoneNumber;
    private VistoolUserRole vistoolUserRole;

    public VistoolUserDTO(VistoolUser vistoolUser) {
        this.username = vistoolUser.getUsername();
        this.department = vistoolUser.getDepartment();
        this.displayName = vistoolUser.getDisplayName();
        this.email = vistoolUser.getEmail();
        this.employeeId = vistoolUser.getEmployeeId();
        this.employeeGroup = vistoolUser.getEmployeeGroup();
        this.officeBuildingNumber = vistoolUser.getOfficeBuildingNumber();
        this.phoneNumber = vistoolUser.getPhoneNumber();
        this.vistoolUserRole = vistoolUser.getVistoolUserRole();
    }

    public VistoolUserDTO(DimHRPerson dimHrPerson, VistoolUserRole vistoolUserRole) {
        this.username = dimHrPerson.getUserId();
        this.department = dimHrPerson.getDeptID();
        this.displayName = dimHrPerson.getPreferredFullName();
        this.email = dimHrPerson.getEmailId();
        this.employeeId = dimHrPerson.getPersonNumber();
        this.employeeGroup = dimHrPerson.getGroupCode();
        this.officeBuildingNumber = dimHrPerson.getOfficeBuildingNumber();
        this.phoneNumber = dimHrPerson.getFullLabPhone1Num();
        this.vistoolUserRole = vistoolUserRole;
    }

    public VistoolUser dtoToVistoolUser() {
        VistoolUser vistoolUser = new VistoolUser(this.getUsername(), "", Collections.emptyList());
        vistoolUser.setUsername(this.getUsername());
        vistoolUser.setDepartment(this.getDepartment());
        vistoolUser.setDisplayName(this.getDisplayName());
        vistoolUser.setEmail(this.getEmail());
        vistoolUser.setEmployeeId(this.getEmployeeId());
        vistoolUser.setEmployeeGroup(this.getEmployeeGroup());
        vistoolUser.setOfficeBuildingNumber(this.getOfficeBuildingNumber());
        vistoolUser.setPhoneNumber(this.getPhoneNumber());
        vistoolUser.setVistoolUserRole(this.getVistoolUserRole());
        return vistoolUser;

    }
}
