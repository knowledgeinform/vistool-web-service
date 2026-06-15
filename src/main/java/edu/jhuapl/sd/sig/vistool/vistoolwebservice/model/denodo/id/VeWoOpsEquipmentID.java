package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.id;

import lombok.Data;

import java.io.Serializable;

@Data
public class VeWoOpsEquipmentID implements Serializable {
    private String equipmentID;
    private double operationSequenceNumber;
    private double pieceNumber;
    private String workOrderNumber;
}
