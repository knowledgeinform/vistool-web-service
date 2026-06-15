package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * WA changes table composite key
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WaChangesId implements Serializable {
    private String workAuthorizationId;
    private String partId;
}
