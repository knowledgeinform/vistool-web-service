package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.id.VeWoOpsEquipmentID;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;
import java.util.Date;

import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.constants.denodo.VeWoOpsEquipmentConstants.*;
import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.VistoolUtilities.MONTH_DAY_YEAR_FORMAT;

@Data
@Entity
@IdClass(VeWoOpsEquipmentID.class)
public class VeWoOpsEquipment implements Serializable {
	@SerializedName(EQUIP_DATE_CALIBRATED) private Date equipmentDateCalibrated;
	@SerializedName(EQUIP_DATE_USED) private Date equipmentDateUsed;
	@SerializedName(EQUIP_DESC) private String equipmentDescription;
	@Id @SerializedName(EQUIP_ID) private String equipmentID;
	@Id @SerializedName(OPERATION_SEQ_NO) private Double operationSequenceNumber;
	@SerializedName(PART_ID) private String partID;
	@Id @SerializedName(PIECE_NO) private Double pieceNumber;
	@SerializedName(QTY_PER) private Double quantityPer;
	@SerializedName(STATUS) private String status;
	@SerializedName(TIMESTAMP) private String timestamp;
	@SerializedName(USER_5) private String userDefinedField5;
	@Id @SerializedName(WO_NUM) private String workOrderNumber;
	@SerializedName(WORK_ORDER_BASE_ID) private String workOrderBaseID;
	@SerializedName(WORK_ORDER_LOT_ID) private String workOrderLotID;
	@SerializedName(WORK_ORDER_SPLIT_ID) private String workOrderSplitID;
	@SerializedName(WORK_ORDER_SUB_ID) private String workOrderSubID;

	public final static transient Gson SERIALIZER = new GsonBuilder().serializeNulls().setDateFormat(MONTH_DAY_YEAR_FORMAT).create();
}
