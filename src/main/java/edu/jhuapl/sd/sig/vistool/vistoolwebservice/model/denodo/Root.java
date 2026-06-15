package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Root<T> {
    @SerializedName("name") private String name;
    @SerializedName("description") private String description;
    @SerializedName("elements") private T[] elements;
}
