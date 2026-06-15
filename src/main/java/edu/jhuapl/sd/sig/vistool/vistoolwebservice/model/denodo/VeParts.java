package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.constants.denodo.VePartsConstants.*;
import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.VistoolUtilities.YEAR_MONTH_DAY_FORMAT;

@Data
@Entity
public class VeParts implements Serializable {
	@SerializedName(ATTRIBUTES) private String attributes;
	@SerializedName(BUYER_USER_ID) private String buyerUserID;
	@SerializedName(COMMODITY_CODE) private String commodityCode;
	@SerializedName(CONFIG_LVL) private String configLevel;
	@SerializedName(CREATE_DATE) private Date createDate;
	@SerializedName(DESCRIPTION) private String description;
	@SerializedName(DRAWING_ID) private String drawingID;
	@SerializedName(ESD_CLASS) private String esdClass;
	@SerializedName(EXTENDED_DESC) private String extendedDescription;
	@SerializedName(FABRICATED) private String fabricated;
	@SerializedName(GPN) private String gpn;
	@SerializedName(GRADE) private String grade;
	@Id @SerializedName(ID) private String id;
	@SerializedName(LEAD_ENG) private String leadEngineer;
	@SerializedName(MAXIMUM_ORDER_QTY) private Double maximumOrderQuantity;
	@SerializedName(MANUFACTURER_NAME) private String manufacturerName;
	@SerializedName(MANUFACTURER_PART_ID) private String manufacturerPartID;
	@SerializedName(MINIMUM_ORDER_QTY) private Double minimumOrderQuantity;
	@SerializedName(MODIFY_DATE) private Date modifyDate;
	@SerializedName(MRP_EXCEPTIONS) private String mrpExceptions;
	@SerializedName(MRP_REQUIRED) private String mrpRequired;
	@SerializedName(NMFC_CODE_ID) private String nmfcCodeId;
	@SerializedName(PACKAGE_TYPE) private String packageType;
	@SerializedName(PLANNER_USER_ID) private String plannerUserID;
	@SerializedName(PLANNING_LEAD_TIME) private Double planningLeadTime;
	@SerializedName(PRODUCT_CODE) private String productCode;
	@SerializedName(PURCHASED) private String purchased;
	@SerializedName(QTY_AVAILABLE_ISS) private Double quantityAvaliableISS;
	@SerializedName(QTY_AVAILABLE_MRP) private Double quantityAvaliableMRP;
	@SerializedName(QTY_IN_DEMAND) private Double quantityInDemand;
	@SerializedName(QTY_ON_HAND) private Double quantityOnHand;
	@SerializedName(QTY_ON_ORDER) private Double quantityOnOrder;
	@SerializedName(SAFETY_STOCK_QTY) private Double safetyStockQty;
	@SerializedName(STATUS) private String status;
	@SerializedName(STOCK_UM) private String stockUM;
	@SerializedName(TAPE_WIDTH) private String tapeWidth;
	@SerializedName(TIMESTAMP) private String timestamp;
	@SerializedName(VALUE_SIZE) private String valueSize;
	@SerializedName(WEIGHT) private Double weight;
	@SerializedName(WEIGHT_UM) private String weightUM;

	public final static transient Gson SERIALIZER = new GsonBuilder().serializeNulls().setDateFormat(YEAR_MONTH_DAY_FORMAT).create();
}
