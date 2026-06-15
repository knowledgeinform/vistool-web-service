package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.id;

import lombok.Data;

import java.io.Serializable;

@Data
public class VeMasterWoOpsID implements Serializable {
    private Double sequenceNumber;
    private String workOrderNumber;
}
