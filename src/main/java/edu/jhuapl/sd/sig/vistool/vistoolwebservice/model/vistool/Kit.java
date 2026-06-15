package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool;

import com.google.gson.annotations.SerializedName;

public enum Kit {
    @SerializedName("S") SHORT_PARTS("S"),
    @SerializedName("P") PARTIAL("P"),
    @SerializedName("Y") YES("Y"),
    @SerializedName("N") NO("N");

    private String value;

    Kit(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }
}
