package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.constants.denodo.VeWoLaborTotalsConstants.*;

@Data
@Entity
public class VeWoLaborTotals implements Serializable {
	@SerializedName(LABOR_TOTAL) private Double laborTotals;
	@SerializedName(TYPE) private String type;
	@Id @SerializedName(WO_NUM) private String workOrderNumber;

	public final static transient Gson SERIALIZER = new GsonBuilder().serializeNulls().create();
}
