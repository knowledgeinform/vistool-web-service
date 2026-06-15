package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.id;

import lombok.Data;

import java.io.Serializable;

@Data
public class VmSysWorkAuthDetailChangeHistoryVistoolID implements Serializable {
    private String headerId;
    private String lineItem;
    private String splitId;
    private String workAuthorizationId;
}
