package edu.jhuapl.sd.sig.vistool.vistoolwebservice.exceptions;

public class InvalidFilterException extends Exception {
    public static final String INVALID_EQUALS_POSITION = "Invalid Filter specification! EQUALS constraints are only allowed at the beginning.";
    public static final String NOT_ENOUGH_CONSTRAINTS = "Attempted to create an incomplete Filter! Valid Filters require at least one constraint.";
    public static final String NULL_VALUE_SPECIFIED = "The provided filter value was null! Only IS_NULL and IS_NOT_NULL constraints may omit a value.";
    public static final String UNSUPPORTED_CONSTRAINT = "The Filter does not support the provided Constraint!";
    public static final String BLANK_FILTER = "The provided filter string was blank!";

    public InvalidFilterException () { }

    public InvalidFilterException (String message) {
        super (message);
    }

    public InvalidFilterException (Throwable cause) {
        super (cause);
    }

    public InvalidFilterException (String message, Throwable cause) {
        super (message, cause);
    }
}