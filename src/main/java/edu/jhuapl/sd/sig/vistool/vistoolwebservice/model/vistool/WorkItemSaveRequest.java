package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool;

import lombok.Data;

@Data
public class WorkItemSaveRequest {
    private WorkItem workItem;
    private WorkItem originalWorkItem;
}
