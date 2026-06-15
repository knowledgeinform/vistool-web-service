package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.id;

import lombok.Data;

import java.io.Serializable;

@Data
public class VeWoOpsLaborID implements Serializable {
    private Double operationSequenceNumber;
    private Double transactionID;
    private String workOrderNumber;
}
