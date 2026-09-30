package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "vistool_role")
public class VistoolRole {
    @Id
    @Column(name = "role")
    private String role;
}