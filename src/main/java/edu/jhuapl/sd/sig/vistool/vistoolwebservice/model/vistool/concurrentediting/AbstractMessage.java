package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.concurrentediting;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.VistoolUser;

public abstract class AbstractMessage {
    public VistoolUser vistoolUser;

    public AbstractMessage() {
    }

    public AbstractMessage(VistoolUser vistoolUser) {
        this.vistoolUser = vistoolUser;
    }
}
