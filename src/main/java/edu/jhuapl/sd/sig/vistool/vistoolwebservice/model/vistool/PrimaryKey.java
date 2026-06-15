package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool;

import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@RequiredArgsConstructor
public class PrimaryKey implements Serializable {
    private Long id;
    private Long version;
}
