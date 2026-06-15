package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool;

import com.google.gson.annotations.SerializedName;

public enum LoadingPriorities {
    @SerializedName("TBD") TBD("TBD"),
    @SerializedName("label") LABEL("label"),
    @SerializedName("label and load") LABEL_AND_LOAD("label and load"),
    @SerializedName("labeled") LABELED("labeled"),
    @SerializedName("labeled and load") LABELED_AND_LOAD("labeled and load"),
    @SerializedName("loaded") LOADED("loaded"),
    @SerializedName("unload") UNLOAD("unload"),
    @SerializedName("unloaded") UNLOADED("unloaded"),
    @SerializedName("pop up") POP_UP("pop up"),
    @SerializedName("popped up") POPPED_UP("popped up");

    private String value;

    LoadingPriorities(String value) { this.value = value; }

    public String toString() { return value; }
}
