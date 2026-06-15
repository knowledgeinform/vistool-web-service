package edu.jhuapl.sd.sig.vistool.vistoolwebservice.service;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.WorkItemConflict;

public class WorkItemConflictException extends RuntimeException {
    private final WorkItemConflict workItemConflict;

    public WorkItemConflictException(WorkItemConflict workItemConflict) {
        super(workItemConflict.getMessage());
        this.workItemConflict = workItemConflict;
    }

    public WorkItemConflict getWorkItemConflict() {
        return workItemConflict;
    }
}
