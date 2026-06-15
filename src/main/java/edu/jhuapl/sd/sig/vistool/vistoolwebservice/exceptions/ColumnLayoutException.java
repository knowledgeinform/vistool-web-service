package edu.jhuapl.sd.sig.vistool.vistoolwebservice.exceptions;

public class ColumnLayoutException extends Exception {
    String message;

    public ColumnLayoutException(String message) {
        this.message = message;
    }

}
