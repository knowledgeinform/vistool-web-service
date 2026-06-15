package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.constants.denodo.VeSpecialPartsConstants.*;
import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.VistoolUtilities.YEAR_MONTH_DAY_FORMAT;

@Data
@Entity
public class VeSpecialParts implements Serializable {
	@SerializedName(ATTRIBUTES) private String attributes;
	@SerializedName(CONFIG_LEVEL) private String configLevel;
	@SerializedName(CREATE_DATE) private Date createDate;
	@SerializedName(DESCRIPTION) private String description;
	@SerializedName(ESD_CLASS) private String esdClass;
	@SerializedName(EXTENDED_PART_DESC) private String extendedPartDescription;
	@SerializedName(FABRICATED) private String fabricated;
	@SerializedName(GPN) private String gpn;
	@SerializedName(GRADE) private String grade;
	@Id @SerializedName(ID) private String id;
	@SerializedName(LEAD_ENG) private String leadEngineer;
	@SerializedName(MODIFY_DATE) private Date modifyDate;
	@SerializedName(PURCHASED) private String purchased;
	@SerializedName(STOCK_UM) private String stockUM;
	@SerializedName(TAPE_WIDTH) private String tapeWidth;
	@SerializedName(TIMESTAMP) private String timestamp;
	@SerializedName(VALUE_SIZE) private String valueSize;

	public final static transient Gson SERIALIZER = new GsonBuilder().serializeNulls().setDateFormat(YEAR_MONTH_DAY_FORMAT).create();
}
