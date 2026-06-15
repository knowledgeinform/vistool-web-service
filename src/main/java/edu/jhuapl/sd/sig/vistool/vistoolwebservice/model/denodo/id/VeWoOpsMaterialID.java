package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.id;

import lombok.Data;

import java.io.Serializable;

@Data
public class VeWoOpsMaterialID implements Serializable {
    private String materialID;
    private double operationSequenceNumber;
    private String workOrderNumber;
}
