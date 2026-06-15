package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool;

import com.google.gson.annotations.SerializedName;

public enum Status {
    @SerializedName("IN_PROCESS") INPROCESS("IN_PROCESS"),
    @SerializedName("TEST") TEST("TEST"),
    @SerializedName("COMPLETED") COMPLETED("COMPLETED"),
    @SerializedName("ON_HOLD") ONHOLD("ON_HOLD"),
    @SerializedName("KIT_AUDIT") KITAUDIT ("KIT_AUDIT"),
    @SerializedName("CHANGED") CHANGED("CHANGED"),
    @SerializedName("STOPPED") STOPPED("STOPPED");

    private String value;

    Status(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }
}
