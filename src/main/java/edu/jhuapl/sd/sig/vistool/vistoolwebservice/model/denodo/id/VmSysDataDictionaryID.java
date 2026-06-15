package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.denodo.id;

import lombok.Data;

import java.io.Serializable;

@Data
public class VmSysDataDictionaryID implements Serializable {
    private String columnName;
    private String tableName;
}
