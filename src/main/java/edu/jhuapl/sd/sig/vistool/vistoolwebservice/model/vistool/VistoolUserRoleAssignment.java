package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "vistool_user_role_assignment")
@NoArgsConstructor
@AllArgsConstructor
public class VistoolUserRoleAssignment {
    @Id
    @Column(name = "user_id")
    String userId;

    @Column(name = "role")
    String role;
}
