package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.id.VeWoOpsMaterialID;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;
import java.util.Date;

import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.constants.denodo.VeWoOpsMaterialConstants.*;
import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.VistoolUtilities.MONTH_DAY_YEAR_FORMAT;

@Data
@Entity
@IdClass(VeWoOpsMaterialID.class)
public class VeWoOpsMaterial implements Serializable {
	@SerializedName(MATERIAL_DATE_USED) private Date materialDateUsed;
	@SerializedName(MATERIAL_DESC) private String materialDescription;
	@Id @SerializedName(MATERIAL_ID) private String materialID;
	@SerializedName(MATERIAL_SERIAL) private String materialSerialNumber;
	@Id @SerializedName(OPERATION_SEQ_NO) private Double operationSequenceNumber;
	@SerializedName(PART_ID) private String partID;
	@SerializedName(PIECE_NO) private Double pieceNumber;
	@SerializedName(QTY_PER) private Double quantityPer;
	@SerializedName(STATUS) private String status;
	@SerializedName(TIMESTAMP) private String timestamp;
	@Id @SerializedName(WO_NUM) private String workOrderNumber;
	@SerializedName(WORK_ORDER_BASE_ID) private String workOrderBaseID;
	@SerializedName(WORK_ORDER_LOT_ID) private String workOrderLotID;
	@SerializedName(WORK_ORDER_SPLIT_ID) private String workOrderSplitID;
	@SerializedName(WORK_ORDER_SUB_ID) private String workOrderSubID;

	public final static transient Gson SERIALIZER = new GsonBuilder().serializeNulls().setDateFormat(MONTH_DAY_YEAR_FORMAT).create();
}
