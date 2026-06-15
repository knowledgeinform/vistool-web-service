package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool;

import javax.persistence.*;

import lombok.Data;


@Data
@Entity
@Table(name = "archived_work_item")
@IdClass(PrimaryKey.class)
public class ArchivedWorkItem extends AbstractWorkItem {
}
