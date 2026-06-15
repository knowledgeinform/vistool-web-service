package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.constants.denodo.VeShopResourceConstants.*;

@Data
@Entity
public class VeShopResource implements Serializable {
	@SerializedName(COST_CATEGORY_ID) private String costCategoryID;
	@SerializedName(DEPARTMENT_ID) private String departmentID;
	@SerializedName(DESCRIPTION) private String description;
	@Id @SerializedName(ID) private String id;
	@SerializedName(SCHEDULE_NORMALLY) private String scheduleNormally;
	@SerializedName(SHIFT_1_CAPACITY) private Double shift1Capacity;
	@SerializedName(STATUS) private String status;
	@SerializedName(STATUS_RANK) private Double statusRank;
	@SerializedName(TYPE) private String type;
	@SerializedName(UDF_LAYOUT_ID) private String udfLayoutID;
	@SerializedName(USER_1) private String userDefinedField1;
	@SerializedName(USER_10) private String userDefinedField10;
	@SerializedName(USER_2) private String userDefinedField2;
	@SerializedName(USER_3) private String userDefinedField3;
	@SerializedName(USER_4) private String userDefinedField4;
	@SerializedName(USER_5) private String userDefinedField5;
	@SerializedName(USER_6) private String userDefinedField6;
	@SerializedName(USER_7) private String userDefinedField7;
	@SerializedName(USER_8) private String userDefinedField8;
	@SerializedName(USER_9) private String userDefinedField9;
	@SerializedName(WBS_RESOURCE_TYPE) private String wbsResourceType;

	public final static transient Gson SERIALIZER = new GsonBuilder().serializeNulls().create();
}
