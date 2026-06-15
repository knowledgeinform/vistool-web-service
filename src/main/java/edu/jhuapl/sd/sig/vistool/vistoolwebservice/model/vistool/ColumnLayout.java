package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.*;

@Data
@Entity
@Table(name = "column_layout")
@AllArgsConstructor
@NoArgsConstructor
public class ColumnLayout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "user_id")
    @Getter
    @Setter
    private String userId;

    @NotNull
    @Column(name = "name")
    @Getter
    @Setter
    private String name;

    @NotNull
    @Column(name = "column_layout_json")
    @Getter
    @Setter
    private String columnLayoutJson;

    @Column(name = "is_visible")
    @Getter
    @Setter
    private boolean isVisible;

    // Date when the entry was created
    @Column(name = "date_created")
    @Getter
    @Setter
    private Date dateCreated;

    public ColumnLayout(String userId, String name, String columnLayoutJson, boolean isVisible) {
        this.userId = userId;
        this.name = name;
        this.columnLayoutJson = columnLayoutJson;
        this.isVisible = isVisible;

        //TODO: set date
    }
    public ColumnLayout(String userId, String name, String columnLayoutJson, boolean isVisible, Date dateCreated) {
        this(userId, name, columnLayoutJson, isVisible);
        this.dateCreated = dateCreated;
    }

}
