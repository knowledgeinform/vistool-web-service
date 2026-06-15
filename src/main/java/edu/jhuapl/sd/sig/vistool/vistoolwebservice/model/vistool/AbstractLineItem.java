package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractLineItem {
    @Id
    @Column(name = "id")
    private Long id;

    @Id
    @Column(name = "version")
    private Long version;

    @NotNull
    @Column(name = "work_authorization_number")
    private String workAuthorizationNumber;

    @NotNull
    @Column(name = "line_item_number")
    private String lineItemNumber;

    @NotNull
    @Column(name = "quantity")
    private Integer quantity;

    // Date of the latest Work Authorization Change with a Stop Request for this
    // LineItem.
    //DEPRECEATED - TO BE REMOVED
    @Column(name = "work_authorization_change_stop_date")
    private Date workAuthorizationChangeStopDate;

    // Date of the latest Work Authorization Change with a new TA for this LineItem.
    //DEPRECEATED - TO BE REMOVED
    @Column(name = "work_authorization_change_ta_date")
    private Date workAuthorizationChangeTADate;

	@Column(name = "modified_date")
	private Date modifiedDate;
}
