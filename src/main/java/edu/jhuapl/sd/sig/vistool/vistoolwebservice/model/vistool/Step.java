package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Step {
    private String formattedString;
    private String operationType;
    private String resourceID;
    private Double sequenceNumber;
    private String status;
}
