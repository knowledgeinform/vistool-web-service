package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractWorkItem {
    @Id
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Id
	@Column(name = "version")
	private Long version;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "modified_date", nullable = false)
	private Date modifiedDate;

	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "parent_line_item_id", referencedColumnName = "id"),
			@JoinColumn(name = "parent_line_item_version", referencedColumnName = "version")
	})
	private LineItem parentLineItem;

	@Column(name = "linked_work_order")
	private String linkedWorkOrder;

	@Column(name = "serial_number")
	private String serialNumber;

	@Column(name = "quantity")
	@NotNull private Integer quantity;

	@Column(name = "quantity_complete")
	private Integer quantityComplete;

	@Column(name = "balance")
	private Integer balance;

	@Column(name = "expedite")
	private Boolean expedite;

	@Column(name = "subsystem")
	private String subsystem;

	@Embedded
	@AttributeOverrides(value = {
			@AttributeOverride(name = "pickAndPlaceBool", column = @Column(name = "p_and_p")),
			@AttributeOverride(name = "loadingPriorities", column = @Column(name = "loading_priorities")),
			@AttributeOverride(name = "sizeAndMagazines", column = @Column(name = "size_and_magazines")),
			@AttributeOverride(name = "pickAndPlaceNotes", column = @Column(name = "pick_and_place_notes")),
			@AttributeOverride(name = "targetStartDate", column = @Column(name = "target_start_date"))
	})
	private PickAndPlace pickAndPlace;

	@Embedded
	@AttributeOverrides(value = {
			@AttributeOverride(name = "productionPlanning", column = @Column(name = "production_planning")),
			@AttributeOverride(name = "productionPlanningNotes", column = @Column(name = "production_planning_notes")),
			@AttributeOverride(name = "actionItems", column = @Column(name = "action_items"))
	})
	private ProductionPlanning productionPlanning;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Status status;

	@Column(name = "status_comments")
	private String statusComments;

	@Column(name = "manufacturing_engineer")
	private String manufacturingEngineer;

	@Column(name = "current_technician")
	private String currentTechnician;

	@Column(name = "program_priority")
	private Integer programPriority;

	@Column(name = "technician_priority")
	private Integer technicianPriority;

	@Column(name = "polymerics_priority")
	private Integer polymericsPriority;

	@Column(name = "inspection_priority")
	private Integer inspectionPriority;

	@Column(name = "date_complete")
	private Date dateComplete;

	@Column(name = "kit_part_due_date")
	private Date kitPartDueDate;

	@Column(name = "estimate_to_complete")
	private Date estimateToComplete;

	@Column(name = "estimate_to_test")
	private Date estimateToTest;

	@Column(name = "estimate_return_to_assembly")
	private Date estimateReturnToAssembly;

	@Enumerated(EnumType.STRING)
	@Column(name = "eee_kit")
	private Kit eeeKit;

	@Enumerated(EnumType.STRING)
	@Column(name = "mech_kit")
	private Kit mechKit;

	@Column(name = "comments")
	private String comments;

	@Enumerated(EnumType.STRING)
	@Column(name = "work_order_exists")
	private WorkOrderExists workOrderExists;
}
