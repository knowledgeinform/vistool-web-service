package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.constants.denodo.VeMasterWoConstants.*;
import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.VistoolUtilities.YEAR_MONTH_DAY_FORMAT;

@Data
@Entity
public class VeMasterWo implements Serializable {
	@SerializedName(BASE_ID) private String baseID;
	@SerializedName(CHARGE_GROUP) private String chargeGroup;
	@SerializedName(CREATE_DATE) private Date createDate;
	@SerializedName(CUSTOMER) private String customer;
	@SerializedName(DESCRIPTION) private String description;
	@SerializedName(HARDWARE_LEVEL) private String hardwareLevel;
	@SerializedName(LOT_ID) private String lotID;
	@SerializedName(ORIGINAL_WO) private String originalWorkOrder;
	@SerializedName(PART_ID) private String partID;
	@SerializedName(PLANNER) private String planner;
	@SerializedName(SERIAL_NUM) private String serialNum;
	@SerializedName(SPLIT_ID) private String splitID;
	@SerializedName(STATUS) private String status;
	@SerializedName(SUB_ID) private String subID;
	@SerializedName(TIMESTAMP) private String timestamp;
	@SerializedName(WA) private String workAuthorization;
	@SerializedName(WBS_CODE) private String wbsCode;
	@SerializedName(WBS_PROJECT) private String wbsProject;
	@SerializedName(WO_ASSIGNEE) private String workOrderAssignee;
	@Id @SerializedName(WO_NUM) private String workOrderNumber;

	public final static transient Gson SERIALIZER = new GsonBuilder().serializeNulls().setDateFormat(YEAR_MONTH_DAY_FORMAT).create();
}
