package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.id.VmSysDataDictionaryID;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.constants.denodo.VmSysDataDictionaryConstants.*;

@Data
@Entity
@IdClass(VmSysDataDictionaryID.class)
public class VmSysDataDictionary implements Serializable {
	@SerializedName(COLUMN_COMMENTS) private String columnComments;
	@Id @SerializedName(COLUMN_NAME) private String columnName;
	@SerializedName(TABLE_COMMENTS) private String tableComments;
	@Id @SerializedName(TABLE_NAME) private String tableName;

	public final static transient Gson SERIALIZER = new GsonBuilder().serializeNulls().create();
}
