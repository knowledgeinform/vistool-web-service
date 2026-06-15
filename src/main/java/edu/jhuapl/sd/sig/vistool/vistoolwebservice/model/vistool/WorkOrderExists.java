package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool;

import com.google.gson.annotations.SerializedName;

public enum WorkOrderExists {
    @SerializedName("Y") CREATED_AND_APPROVED("Y"),
    @SerializedName("y") CREATED_AWAITING_APPROVAL("y"),
    @SerializedName("N") NOT_CREATED("N"),
    @SerializedName("P") PARTIAL_STEPS("P");

    private String value;

    WorkOrderExists(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }
}
