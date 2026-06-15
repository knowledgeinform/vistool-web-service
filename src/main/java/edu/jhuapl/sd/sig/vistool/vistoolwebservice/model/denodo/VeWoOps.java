package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.id.VeWoOpsID;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.GsonDateTypeAdapter;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Index;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Date;

import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.constants.denodo.VeWoOpsConstants.*;

@Data
@Entity
@IdClass(VeWoOpsID.class)
@Table(indexes = @Index(name = "idx_woNum_seqNum", columnList = "workOrderNumber, sequenceNumber"))
public class VeWoOps implements Serializable {
	@SerializedName(ACT_RUN_HRS) private Double actualRunHours;
	@SerializedName(ACT_SETUP_HRS) private Double actualSetupHours;
	@SerializedName(CLOSE_DATE) private Date closeDate;
	@SerializedName(COMPLETED_QTY) private Double completedQuantity;
	@SerializedName(EVWPMS) private String evwpms;
	@SerializedName(LOAD_SIZE_QTY) private Double loadSizeQuantity;
	@SerializedName(MOVE_HRS) private Double moveHours;
	@SerializedName(OPERATION_ASSIGNEE) private String operationAssignee;
	@SerializedName(OPERATION_TYPE) private String operationType;
	@Id @SerializedName(RESOURCE_ID) private String resourceID;
	@SerializedName(RUN) private Double run;
	@SerializedName(RUN_HRS) private Double runHours;
	@Id @SerializedName(RUN_TYPE) private String runType;
	@Id @SerializedName(SEQUENCE_NO) private Double sequenceNumber;
	@SerializedName(SETUP_COMPLETED) private String setupComplete;
	@SerializedName(SETUP_HRS) private Double setupHours;
	@SerializedName(STATUS) private String status;
	@SerializedName(USER_10) private String userDefinedField10;
	@Id @SerializedName(WO_NUM) private String workOrderNumber;
	@SerializedName(WORK_ORDER_BASE_ID) private String workOrderBaseID;
	@SerializedName(WORK_ORDER_LOT_ID) private String workOrderLotID;
	@SerializedName(WORK_ORDER_SPLIT_ID) private String workOrderSplitID;
	@SerializedName(WORK_ORDER_SUB_ID) private String workOrderSubID;
	@SerializedName(PRIMARY_KEY) private String primaryKey;
	@SerializedName(MODIFIED_DATE) private Date modifiedDate;

	public final static transient Gson SERIALIZER = new GsonBuilder().serializeNulls().registerTypeAdapter(Date.class, new GsonDateTypeAdapter()).create();
}
