package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class VmSysWorkAuthDoc {
	@SerializedName("doc_type") private String documentType;
	@SerializedName("document_name") private String documentName;
	@SerializedName("document_path") private String documentPath;
	@Id @SerializedName("id") private Double documentID;
	@SerializedName("line_item") private String workAuthorizationLineNumber;
	@SerializedName("split_id") private String splitID;
	@SerializedName("workauth_id") private String workAuthorizationID;

	public final static transient Gson SERIALIZER = new GsonBuilder().serializeNulls().create();
}
