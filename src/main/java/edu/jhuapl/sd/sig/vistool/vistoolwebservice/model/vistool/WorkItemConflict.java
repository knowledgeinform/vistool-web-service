package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkItemConflict {
    private Long workItemId;
    private List<String> conflictingFields;
    private HydratedWorkItem latestHydratedWorkItem;
    private String message;
}
