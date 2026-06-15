package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Data
@Entity
@Table(name = "work_item")
@IdClass(PrimaryKey.class)
@AllArgsConstructor
public class WorkItem extends AbstractWorkItem implements Serializable {
	
	public WorkItem(Long id, Long version, String userId, Date modifiedDate, LineItem parentLineItem,
			String linkedWorkOrder, String serialNumber, Integer quantity, Integer quantityComplete, Integer balance,
			Boolean expedite, String subsystem, PickAndPlace pickAndPlace, ProductionPlanning productionPlanning,
			Status status, String statusComments, String manufacturingEngineer, String currentTechnician,
			Integer programPriority, Integer technicianPriority, Integer polymericsPriority, Integer inspectionPriority,
			Date dateComplete, Date kitPartDueDate, Date estimateToComplete, Date estimateToTest,
			Date estimateReturnToAssembly, Kit eeeKit, Kit mechKit, String comments, WorkOrderExists workOrderExists) {
		this.setId(id);
		this.setVersion(version);
		this.setUserId(userId);
		this.setModifiedDate(modifiedDate);
		this.setParentLineItem(parentLineItem);
		this.setLinkedWorkOrder(linkedWorkOrder);
		this.setSerialNumber(serialNumber);
		this.setQuantity(quantity);
		this.setQuantityComplete(quantityComplete);
		this.setBalance(balance);
		this.setExpedite(expedite);
		this.setSubsystem(subsystem);
		this.setPickAndPlace(pickAndPlace);
		this.setProductionPlanning(productionPlanning);
		this.setStatus(status);
		this.setStatusComments(statusComments);
		this.setManufacturingEngineer(manufacturingEngineer);
		this.setCurrentTechnician(currentTechnician);
		this.setProgramPriority(programPriority);
		this.setTechnicianPriority(technicianPriority);
		this.setInspectionPriority(inspectionPriority);
		this.setPolymericsPriority(polymericsPriority);
		this.setDateComplete(dateComplete);
		this.setKitPartDueDate(kitPartDueDate);
		this.setEstimateToComplete(estimateToComplete);
		this.setEstimateToTest(estimateToTest);
		this.setEstimateReturnToAssembly(estimateReturnToAssembly);
		this.setEeeKit(eeeKit);
		this.setMechKit(mechKit);
		this.setComments(comments);
		this.setWorkOrderExists(workOrderExists);
	}

	public WorkItem(WorkItem source) {
		this(source.getId(),
				source.getVersion(),
				source.getUserId(),
				source.getModifiedDate() == null ? null : new Date(source.getModifiedDate().getTime()),
				source.getParentLineItem(),
				source.getLinkedWorkOrder(),
				source.getSerialNumber(),
				source.getQuantity(),
				source.getQuantityComplete(),
				source.getBalance(),
				source.getExpedite(),
				source.getSubsystem(),
				source.getPickAndPlace() == null ? null : new PickAndPlace(source.getPickAndPlace()),
				source.getProductionPlanning() == null ? null : new ProductionPlanning(source.getProductionPlanning()),
				source.getStatus(),
				source.getStatusComments(),
				source.getManufacturingEngineer(),
				source.getCurrentTechnician(),
				source.getProgramPriority(),
				source.getTechnicianPriority(),
				source.getPolymericsPriority(),
				source.getInspectionPriority(),
				source.getDateComplete() == null ? null : new Date(source.getDateComplete().getTime()),
				source.getKitPartDueDate() == null ? null : new Date(source.getKitPartDueDate().getTime()),
				source.getEstimateToComplete() == null ? null : new Date(source.getEstimateToComplete().getTime()),
				source.getEstimateToTest() == null ? null : new Date(source.getEstimateToTest().getTime()),
				source.getEstimateReturnToAssembly() == null ? null : new Date(source.getEstimateReturnToAssembly().getTime()),
				source.getEeeKit(),
				source.getMechKit(),
				source.getComments(),
				source.getWorkOrderExists()
		);
	}
}
