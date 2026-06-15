package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkItemBatchSaveResponse {
    private List<HydratedWorkItem> savedWorkItems = new ArrayList<>();
    private List<WorkItemConflict> conflicts = new ArrayList<>();
}
