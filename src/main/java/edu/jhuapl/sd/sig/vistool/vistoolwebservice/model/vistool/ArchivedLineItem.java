package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "archived_line_item")
@IdClass(PrimaryKey.class)
public class ArchivedLineItem extends AbstractLineItem {
}
