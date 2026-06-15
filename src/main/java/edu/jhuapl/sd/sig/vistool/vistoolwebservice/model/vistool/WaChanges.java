package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.VmSysWorkAuthDetailChangeHistoryVistool;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.util.Date;

/**
 * Keep track of line item changes.
 *
 * <p>
 *     For every line item that is currently in the database, create WaChanges entry as a base for future changes.
 *     For every new WA/line item, create WaChanges entry in the database.
 *     Each line item should have only one entry in the table. Each item is tracked with primary key composed of {@link WaChangesId}
 *     For every incoming WA change, compare what's in the table and if change is detected then update table row with new changes.
 *     See {@link WaChanges#compareTo(VmSysWorkAuthDetailChangeHistoryVistool)} for all fields that are being compared for change.
 * </p>
 */
@Data
@Entity
@Table(name = "wa_changes")
@IdClass(WaChangesId.class)
@NoArgsConstructor
@AllArgsConstructor
public class WaChanges {
    @Id
    @Column(name = "work_authorization_id")
    private String workAuthorizationId;

    @Id
    @Column(name = "part_id")
    private String partId;

    @Column(name = "line_item")
    private String lineItem;

    @Column(name = "change_line_part_id")
    private String changeLinePartId;

    @Column(name = "change_line_flow")
    private String changeLineFlow;

    @Column(name = "change_comment")
    private String changeComment;

    @Column(name = "change_line_item_number")
    private String changeLineItemNumber;

    @Column(name = "change_line_part_revision")
    private String changeLinePartRevision;

    @Column(name = "change_line_needed_date")
    private Date changeLineNeedDate;

    @Column(name = "change_line_quantity")
    private Integer changeLineQuantity;

    @Column(name = "change_ta")
    private String changeTa;

    @Column(name = "change_work_area_name")
    private String changeWorkAreaName;

    @Column(name = "customer")
    private String customer;

    @Column(name = "department_id")
    private String departmentId;

    @Column(name = "originator")
    private String originator;

    @Column(name = "status")
    private String status;

    @Column(name = "apl_groups_id")
    private String aplGroupsId;

    @Column(name = "description")
    private String description;

    @Column(name = "flow")
    private String flow;

    @Column(name = "in_plm")
    private String inPLM;

    @Column(name = "parent_lot")
    private String parentLot;

    @Column(name = "original_work_order")
    private String originalWorkOrder;

    @Column(name = "parent_operation")
    private String parentOperation;

    @Column(name = "parent_split_id")
    private String parentSplitId;

    @Column(name = "parent_work_order")
    private String parentWorkOrder;

    @Column(name = "redd_flow_id")
    private String reddFlowId;

    @Column(name = "sub_id")
    private String subId;

    public WaChanges(VmSysWorkAuthDetailChangeHistoryVistool vmSysWorkAuthDetailChangeHistoryVistool) {
        this.partId = vmSysWorkAuthDetailChangeHistoryVistool.getPartId();
        this.lineItem = vmSysWorkAuthDetailChangeHistoryVistool.getLineItem();
        this.workAuthorizationId = vmSysWorkAuthDetailChangeHistoryVistool.getWorkAuthorizationId();
        this.changeLinePartId = vmSysWorkAuthDetailChangeHistoryVistool.getChangeLinePartId();
        this.changeLineFlow = vmSysWorkAuthDetailChangeHistoryVistool.getChangeLineFlow();
        this.changeComment = vmSysWorkAuthDetailChangeHistoryVistool.getChangeComment();
        this.changeLineItemNumber = vmSysWorkAuthDetailChangeHistoryVistool.getChangeLineItemNumber();
        this.changeLinePartRevision = vmSysWorkAuthDetailChangeHistoryVistool.getChangeLinePartRevision();
        this.changeLineNeedDate = vmSysWorkAuthDetailChangeHistoryVistool.getChangeLineNeedDate();
        this.changeLineQuantity = vmSysWorkAuthDetailChangeHistoryVistool.getChangeLineQuantity();
        this.changeTa = vmSysWorkAuthDetailChangeHistoryVistool.getChangeTa();
        this.changeWorkAreaName = vmSysWorkAuthDetailChangeHistoryVistool.getChangeWorkAreaName();
        this.customer = vmSysWorkAuthDetailChangeHistoryVistool.getCustomer();
        this.departmentId = vmSysWorkAuthDetailChangeHistoryVistool.getDepartmentId();
        this.originator = vmSysWorkAuthDetailChangeHistoryVistool.getOriginator();
        this.status = vmSysWorkAuthDetailChangeHistoryVistool.getStatus();
        this.aplGroupsId = vmSysWorkAuthDetailChangeHistoryVistool.getAplGroupsId();
        this.description = vmSysWorkAuthDetailChangeHistoryVistool.getDescription();
        this.flow = vmSysWorkAuthDetailChangeHistoryVistool.getFlow();
        this.inPLM = vmSysWorkAuthDetailChangeHistoryVistool.getInPLM();
        this.parentLot = vmSysWorkAuthDetailChangeHistoryVistool.getParentLot();
        this.originalWorkOrder = vmSysWorkAuthDetailChangeHistoryVistool.getOriginalWorkOrder();
        this.parentOperation = vmSysWorkAuthDetailChangeHistoryVistool.getParentOperation();
        this.parentSplitId = vmSysWorkAuthDetailChangeHistoryVistool.getParentSplitId();
        this.parentWorkOrder = vmSysWorkAuthDetailChangeHistoryVistool.getParentWorkOrder();
        this.reddFlowId = vmSysWorkAuthDetailChangeHistoryVistool.getReddFlowId();
        this.subId = vmSysWorkAuthDetailChangeHistoryVistool.getSubId();
    }

    public boolean compareTo(VmSysWorkAuthDetailChangeHistoryVistool changes) {
        return (

                (changes.getChangeLinePartId() != null && !StringUtils.equals(this.getChangeLinePartId(), changes.getChangeLinePartId())) ||
                        (changes.getChangeLineFlow() != null && !StringUtils.equals(this.getChangeLineFlow(), changes.getChangeLineFlow())) ||
                        (changes.getChangeComment() != null && !StringUtils.equals(this.getChangeComment(), changes.getChangeComment())) ||
                        (changes.getChangeLineItemNumber() != null && !StringUtils.equals(this.getChangeLineItemNumber(), changes.getChangeLineItemNumber())) ||
                        (changes.getChangeLinePartRevision() != null && !StringUtils.equals(this.getChangeLinePartRevision(), changes.getChangeLinePartRevision())) ||
                        (changes.getChangeLineNeedDate() != null && this.getChangeLineNeedDate().getTime() != changes.getChangeLineNeedDate().getTime()) ||
                        (changes.getChangeLineQuantity() != null && this.getChangeLineQuantity().intValue() != changes.getChangeLineQuantity().intValue()) ||
                        (changes.getChangeTa() != null && !StringUtils.equals(this.getChangeTa(), changes.getChangeTa())) ||
                        (changes.getChangeWorkAreaName() != null && !StringUtils.equals(this.getChangeWorkAreaName(), changes.getChangeWorkAreaName())) ||
                        (changes.getCustomer() != null && !StringUtils.equals(this.getCustomer(), changes.getCustomer())) ||
                        (changes.getDepartmentId() != null && !StringUtils.equals(this.getDepartmentId(), changes.getDepartmentId())) ||
                        (changes.getStatus() != null && !StringUtils.equals(this.getStatus(), changes.getStatus())) ||
                        (changes.getOriginator() != null && !StringUtils.equals(this.getOriginator(), changes.getOriginator())) ||
                        (changes.getAplGroupsId() != null && !StringUtils.equals(this.getAplGroupsId(), changes.getAplGroupsId())) ||
                        (changes.getDescription() != null && !StringUtils.equals(this.getDescription(), changes.getDescription())) ||
                        (changes.getFlow() != null && !StringUtils.equals(this.getFlow(), changes.getFlow())) ||
                        (changes.getParentLot() != null && !StringUtils.equals(this.getParentLot(), changes.getParentLot())) ||
                        (changes.getOriginalWorkOrder() != null && !StringUtils.equals(this.getOriginalWorkOrder(), changes.getOriginalWorkOrder())) ||
                        (changes.getParentOperation() != null && !StringUtils.equals(this.getParentOperation(), changes.getParentOperation())) ||
                        (changes.getParentSplitId() != null && !StringUtils.equals(this.getParentSplitId(), changes.getParentSplitId())) ||
                        (changes.getParentWorkOrder() != null && !StringUtils.equals(this.getParentWorkOrder(), changes.getParentWorkOrder())) ||
                        (changes.getReddFlowId() != null && !StringUtils.equals(this.getReddFlowId(), changes.getReddFlowId())) ||
                        (changes.getSubId() != null && !StringUtils.equals(this.getSubId(), changes.getSubId()))
        );
    }

    @Override
    public String toString() {
        return "WaChanges{" +
                "workAuthorizationId='" + workAuthorizationId + '\'' +
                ", partId='" + partId + '\'' +
                ", lineItem='" + lineItem + '\'' +
                ", changeLinePartId='" + changeLinePartId + '\'' +
                ", changeLineFlow='" + changeLineFlow + '\'' +
                ", changeComment='" + changeComment + '\'' +
                ", changeLineItemNumber='" + changeLineItemNumber + '\'' +
                ", changeLinePartRevision='" + changeLinePartRevision + '\'' +
                ", changeLineNeedDate=" + changeLineNeedDate +
                ", changeLineQuantity=" + changeLineQuantity +
                ", changeTa='" + changeTa + '\'' +
                ", changeWorkAreaName='" + changeWorkAreaName + '\'' +
                ", customer='" + customer + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", originator='" + originator + '\'' +
                ", status='" + status + '\'' +
                ", aplGroupsId='" + aplGroupsId + '\'' +
                ", description='" + description + '\'' +
                ", flow='" + flow + '\'' +
                ", inPLM='" + inPLM + '\'' +
                ", parentLot='" + parentLot + '\'' +
                ", originalWorkOrder='" + originalWorkOrder + '\'' +
                ", parentOperation='" + parentOperation + '\'' +
                ", parentSplitId='" + parentSplitId + '\'' +
                ", parentWorkOrder='" + parentWorkOrder + '\'' +
                ", reddFlowId='" + reddFlowId + '\'' +
                ", subId='" + subId + '\'' +
                '}';
    }
}
