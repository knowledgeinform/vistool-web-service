package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.concurrentediting;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.VistoolUser;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.WorkItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConcurrentEditingMessage extends AbstractMessage {
    private Long workItemId;
    private WorkItem workItem;
    private String columnBinding;
    private Object value;

    public ConcurrentEditingMessage(VistoolUser vistoolUser) {
        super(vistoolUser);
    }
}
