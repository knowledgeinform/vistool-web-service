package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.id.VeWoOpsLaborID;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.constants.denodo.VeWoOpsLaborConstants.*;
import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.VistoolUtilities.YEAR_MONTH_DAY_FORMAT;

@Data
@Entity
@IdClass(VeWoOpsLaborID.class)
public class VeWoOpsLabor implements Serializable {
	@SerializedName(BAD_QTY) private Double badQuantity;
	@SerializedName(DEPARTMENT_ID) private String departmentID;
	@SerializedName(DESCRIPTION) private String description;
	@SerializedName(EMPLOYEE_ID) private String employeeID;
	@SerializedName(GOOD_QTY) private Double goodQuantity;
	@SerializedName(HOURS_WORKED) private Double hoursWorked;
	@Id @SerializedName(OPERATION_SEQ_NO) private Double operationSequenceNumber;
	@SerializedName(RESOURCE_ID) private String resourceID;
	@SerializedName(SETUP_COMPLETED) private String setupCompleted;
	@SerializedName(TRANSACTION_DATE) private String transactionDate;
	@Id @SerializedName(TRANSACTION_ID) private Double transactionID;
	@SerializedName(TYPE) private String type;
	@SerializedName(USER_ID) private String userID;
	@Id @SerializedName(WO_NUM) private String workOrderNumber;
	@SerializedName(WORK_ORDER_BASE_ID) private String workOrderBaseID;
	@SerializedName(WORK_ORDER_LOT_ID) private String workOrderLotID;
	@SerializedName(WORK_ORDER_SPLIT_ID) private String workOrderSplitID;
	@SerializedName(WORK_ORDER_SUB_ID) private String workOrderSubID;

	public final static transient Gson SERIALIZER = new GsonBuilder().serializeNulls().setDateFormat(YEAR_MONTH_DAY_FORMAT).create();
}
