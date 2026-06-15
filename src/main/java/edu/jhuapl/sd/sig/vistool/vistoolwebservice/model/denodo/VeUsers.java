package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.constants.denodo.VeUsersConstants.*;
import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.VistoolUtilities.YEAR_MONTH_DAY_FORMAT;

@Data
@Entity
public class VeUsers implements Serializable {
	@SerializedName(DEPT_ID) private String deptID;
	@SerializedName(EMAIL_ADDRESS) private String emailAddress;
	@SerializedName(FIRST_NAME) private String firstName;
	@SerializedName(GROUP_ID) private String groupID;
	@SerializedName(LAB_PHONE_1_EXT) private String labPhone1Extension;
	@SerializedName(LAST_NAME) private String lastName;
	@SerializedName(LAST_UPDATE_DATE) private Date lastUpdateDate;
	@SerializedName(MIDDLE_NAME) private String middleName;
	@SerializedName(OFFICE) private String office;
	@Id @SerializedName(PERSON_ID) private String personID;
	@SerializedName(PERSON_STATUS_CODE) private String personStatusCode;
	@SerializedName(PERSON_SUBSTATUS_CODE) private String personSubstatusCode;
	@SerializedName(PREFERRED_NAME) private String preferredName;
	@SerializedName(PREFIX_NAME) private String prefixName;
	@SerializedName(USERNAME) private String username;

	public final static transient Gson SERIALIZER = new GsonBuilder().serializeNulls().setDateFormat(YEAR_MONTH_DAY_FORMAT).create();
}
