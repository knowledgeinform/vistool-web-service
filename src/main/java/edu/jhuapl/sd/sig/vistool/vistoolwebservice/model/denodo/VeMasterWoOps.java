package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.id.VeMasterWoOpsID;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;
import java.util.Date;

import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.constants.denodo.VeMasterWoOpsConstants.*;
import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.VistoolUtilities.YEAR_MONTH_DAY_FORMAT;

@Data
@Entity
@IdClass(VeMasterWoOpsID.class)
public class VeMasterWoOps implements Serializable {
	@SerializedName(ACT_RUN_HRS) private Double actRunHours;
	@SerializedName(ACT_SETUP_HRS) private Double actSetupHours;
	@SerializedName(CLOSE_DATE) private Date closeDate;
	@SerializedName(COMPLETED_QTY) private Double completedQuantity;
	@SerializedName(EVWPMS) private String evwpms;
	@SerializedName(LOAD_SIZE_QTY) private Double loadSizeQuantity;
	@SerializedName(MOVE_HRS) private Double moveHours;
	@SerializedName(OPERATION_ASSIGNEE) private String operationAssignee;
	@SerializedName(OPERATION_TYPE) private String operationType;
	@SerializedName(RESOURCE_ID) private String resourceID;
	@SerializedName(RUN) private Double run;
	@SerializedName(RUN_HRS) private Double runHours;
	@SerializedName(RUN_TYPE) private String runType;
	@Id @SerializedName(SEQUENCE_NO) private Double sequenceNumber;
	@SerializedName(SETUP_COMPLETED) private String setupCompleted;
	@SerializedName(SETUP_HRS) private Double setupHours;
	@SerializedName(STATUS) private String status;
	@SerializedName(TIMESTAMP) private String timestamp;
	@SerializedName(USER_2) private String userDefinedField2;
	@SerializedName(USER_4) private String userDefinedField4;
	@SerializedName(USER_5) private String userDefinedField5;
	@SerializedName(USER_6) private String userDefinedField6;
	@SerializedName(USER_7) private String userDefinedField7;
	@SerializedName(USER_8) private String userDefinedField8;
	@SerializedName(USER_9) private String userDefinedField9;
	@Id @SerializedName(WO_NUM) private String workOrderNumber;
	@SerializedName(WORK_ORDER_BASE_ID) private String workOrderBaseID;
	@SerializedName(WORK_ORDER_LOT_ID) private String workOrderLotID;
	@SerializedName(WORK_ORDER_SPLIT_ID) private String workOrderSplitID;
	@SerializedName(WORK_ORDER_SUB_ID) private String workOrderSubID;

	public final static transient Gson SERIALIZER = new GsonBuilder().serializeNulls().setDateFormat(YEAR_MONTH_DAY_FORMAT).create();
}
