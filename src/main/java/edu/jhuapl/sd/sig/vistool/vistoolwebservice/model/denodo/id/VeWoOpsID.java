package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.id;

import lombok.Data;

import java.io.Serializable;

@Data
public class VeWoOpsID implements Serializable {
    private String resourceID;
    private String runType;
    private Double sequenceNumber;
    private String workOrderNumber;
}
