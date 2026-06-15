package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.id.VmSysWorkAuthDetailChangeHistoryVistoolID;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.GsonBooleanTypeAdapter;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.GsonDateTypeAdapter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Index;
import javax.persistence.Lob;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Date;

import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.constants.denodo.VmSysWorkAuthDetailChangeHistoryVistoolConstants.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@IdClass(VmSysWorkAuthDetailChangeHistoryVistoolID.class)
@Table(indexes = @Index(name = "idx_waID_lineItem", columnList = "workAuthorizationId, lineItem"))
public class VmSysWorkAuthDetailChangeHistoryVistool implements Serializable {
    @SerializedName(WORKAUTH_HEADER_CREATE_DATE)
    private Date headerCreateDate;
    @SerializedName(WORKAUTH_HEADER_CUSTOMER)
    private String customer;
    @SerializedName(WORKAUTH_HEADER_DEPARTMENT_ID)
    private String departmentId;
    @Id
    @SerializedName(WORKAUTH_HEADER_ID)
    private String headerId;
    @SerializedName(WORKAUTH_HEADER_LAST_MODIFIED)
    private Date headerLastModified;
    @SerializedName(WORKAUTH_HEADER_ORIGINATOR)
    private String originator;
    @SerializedName(WORKAUTH_HEADER_STATUS)
    private String status;
    @SerializedName(WORKAUTH_HEADER_SUBMIT_DATE)
    private Date submitDate;
    @SerializedName(WORKAUTH_HEADER_TA)
    private String headerTa;
    @SerializedName(WORKAUTH_HEADER_WORK_AREA_ID)
    private String workAreaId;
    @SerializedName(WORKAUTH_HEADER_WORK_AREA_ID_NEW)
    private String workAreaIdNew;
    @SerializedName(WORKAUTH_DETAIL_APL_GROUPS_ID)
    private String aplGroupsId;
    @Lob
    @SerializedName(WORKAUTH_DETAIL_COMMENTS)
    private String comments;
    @SerializedName(WORKAUTH_DETAIL_CREATE_DATE)
    private Date detailCreateDate;
    @SerializedName(WORKAUTH_DETAIL_DESCRIPTION)
    private String description;
    @SerializedName(WORKAUTH_DETAIL_FLOW)
    private String flow;
    @SerializedName(WORKAUTH_DETAIL_IN_PLM)
    private String inPLM;
    @SerializedName(WORKAUTH_DETAIL_LAST_MODIFIED)
    private Date detailLastModified;
    @Id
    @SerializedName(WORKAUTH_DETAIL_LINE_ITEM)
    private String lineItem;
    @SerializedName(WORKAUTH_DETAIL_ORIGINAL_WORK_ORDER)
    private String originalWorkOrder;
    @SerializedName(WORKAUTH_DETAIL_PARENT_LOT)
    private String parentLot;
    @SerializedName(WORKAUTH_DETAIL_PARENT_OPERATION)
    private String parentOperation;
    @SerializedName(WORKAUTH_DETAIL_PARENT_SPLIT_ID)
    private String parentSplitId;
    @SerializedName(WORKAUTH_DETAIL_PARENT_WORK_ORDER)
    private String parentWorkOrder;
    @SerializedName(WORKAUTH_DETAIL_PART_ID)
    private String partId;
    @SerializedName(WORKAUTH_DETAIL_QUANTITY)
    private Integer quantity;
    @SerializedName(WORKAUTH_DETAIL_REDD_FLOW_ID)
    private String reddFlowId;
    @SerializedName(WORKAUTH_DETAIL_REVISION)
    private String revision;
    @Id
    @SerializedName(WORKAUTH_DETAIL_SPLIT_ID)
    private String splitId;
    @SerializedName(WORKAUTH_DETAIL_TA)
    private String detailTa;
    @SerializedName(WORKAUTH_DETAIL_USING_SERIAL_NUMBER)
    private String usingSN;
    @SerializedName(WORKAUTH_DETAIL_WORK_AUTHORIZATION_FLOW_ID)
    private String workAuthorizationFlowId;
    @SerializedName(WORKAUTH_DETAIL_WANT_DATE)
    private Date wantDate;
    @Id
    @SerializedName(WORKAUTH_DETAIL_WORK_AUTHORIZATION_ID)
    private String workAuthorizationId;
    @Lob
    @SerializedName(CHANGE_LINE_COMMENT)
    private String changeComment;
    @SerializedName(CHANGE_LINE_HEADER_ID)
    private Integer changeLineHeaderId;
    @SerializedName(CHANGE_HEADER_ID)
    private Integer changeHeaderId;
    @SerializedName(CHANGE_HEADER_STOP_ORDER)
    private Boolean changeHeaderStopOrder;
    @SerializedName(CHANGE_LINE_LINE_ITEM_NUMBER)
    private String changeLineItemNumber;
    @SerializedName(CHANGE_LINE_ID)
    private Integer changeLineId;
    @SerializedName(CHANGE_LINE_STOP_ORDER)
    private Boolean changeLineStopOrder;
    @SerializedName(CHANGE_LINE_PART_ID)
    private String changeLinePartId;
    @SerializedName(CHANGE_LINE_PART_REVISION)
    private String changeLinePartRevision;
    @SerializedName(CHANGE_LINE_FLOW)
    private String changeLineFlow;
    @SerializedName(CHANGE_LINE_NEED_DATE)
    private Date changeLineNeedDate;
    @SerializedName(CHANGE_LINE_QUANTITY)
    private Integer changeLineQuantity;
    @SerializedName(CHANGE_REQUESTOR)
    private String requestor;
    @SerializedName(CHANGE_LINE_SPLIT_ID)
    private String changeLineSplitId;
    @SerializedName(CHANGE_SUBMIT_DATE)
    private Date changeSubmitDate;
    @SerializedName(CHANGE_LINE_SUB_ID)
    private String subId;
    @SerializedName(CHANGE_LINE_TASK_AUTHORIZATION)
    private String changeTa;
    @SerializedName(CHANGE_LINE_WORK_AREA_NAME)
    private String changeWorkAreaName;
    @SerializedName(CHANGE_WORK_AUTHORIZATION_ID)
    private String changeWorkAuthorizationId;

    public final static transient Gson SERIALIZER = new GsonBuilder()
            .serializeNulls()
            .registerTypeAdapter(Date.class, new GsonDateTypeAdapter())
            .registerTypeAdapter(Boolean.class, new GsonBooleanTypeAdapter())
            .create();

    public boolean stopOrderIssued() {
        return (changeHeaderStopOrder != null && changeHeaderStopOrder)
                || (changeLineStopOrder != null && changeLineStopOrder);
    }
}
