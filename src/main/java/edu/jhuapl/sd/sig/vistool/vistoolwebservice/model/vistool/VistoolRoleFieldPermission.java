package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "vistool_role_field_permission")
public class VistoolRoleFieldPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role")
    private String role;

    @Column(name = "field_binding")
    private String fieldBinding;
}