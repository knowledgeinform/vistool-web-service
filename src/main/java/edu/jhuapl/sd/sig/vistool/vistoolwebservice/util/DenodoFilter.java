package edu.jhuapl.sd.sig.vistool.vistoolwebservice.util;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.exceptions.InvalidFilterException;
import lombok.NonNull;
import org.h2.util.StringUtils;

import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.exceptions.InvalidFilterException.NOT_ENOUGH_CONSTRAINTS;
import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.DenodoFilter.Constraints.*;

public final class DenodoFilter {

    private String filter;
    private int constraints;

    private final String DENODO_API_AND = " AND ";
    private final String DENODO_API_OR = " OR ";
    private final String DENODO_API_EQUALS = " = ";
    private final String DENODO_API_NOT_EQUALS = " <> ";
    private final String DENODO_API_LESS_THAN = " < ";
    private final String DENODO_API_GREATER_THAN = " > ";
    private final String DENODO_API_LESS_THAN_OR_EQUAL_TO = " <= ";
    private final String DENODO_API_GREATER_THAN_OR_EQUAL_TO = " >= ";
    private final String DENODO_API_LIKE = " LIKE ";
    private final String DENODO_API_NOT_LIKE = " NOTLIKE ";
    private final String DENODO_API_IS_NULL = " IS NULL";
    private final String DENODO_API_IS_NOT_NULL = " IS NOT NULL";
    private final String APOSTROPHE = "'";
    private final String QUOTATION = "\"";

    private DenodoFilter() {
        filter = "";
        constraints = 0;
    }

    public enum Constraints {
        EQUALS,
        NOT_EQUALS,
        LESS_THAN,
        GREATER_THAN,
        LESS_THAN_OR_EQUAL_TO,
        GREATER_THAN_OR_EQUAL_TO,
        LIKE,
        NOT_LIKE,
        IS_NULL,
        IS_NOT_NULL
    }

    public static DenodoFilter builder() {
        return new DenodoFilter();
    }

    public DenodoFilter addOrConstraint(@NonNull String field, @NonNull Constraints constraint, String value)
            throws Exception {
        return (DenodoFilter) addConstraint(field, constraint, value, DENODO_API_OR);
    }

    public DenodoFilter addAndConstraint(@NonNull String field, @NonNull Constraints constraint, String value)
            throws Exception {
        return (DenodoFilter) addConstraint(field, constraint, value, DENODO_API_AND);
    }

    /**
     * Adds a constraint to the filter.
     * 
     * @param field      The property the constraint applies to. May not be null.
     * @param constraint The type of {@link Constraint} to compare the field and
     *                   value with. May not be null.
     * @param value      The value to compare to using the provided field and
     *                   constraint.
     *                   May only be null for {@link Constraint#IS_NULL} and
     *                   {@link Constraint#IS_NOT_NULL} constraints.
     * @return A reference to the object itself for method chaining.
     * @throws Exception If an error occurs while adding the constraint.
     */
    public DenodoFilter addConstraint(String field, Constraints constraint, String value, String denodoAPIConstant)
            throws InvalidFilterException {
        if (constraints >= 1) {
            filter += denodoAPIConstant;
        }
        filter += QUOTATION + field + QUOTATION;
        switch (constraint) {
            case EQUALS:
                filter += DENODO_API_EQUALS;
                break;
            case NOT_EQUALS:
                filter += DENODO_API_NOT_EQUALS;
                break;
            case LESS_THAN:
                filter += DENODO_API_LESS_THAN;
                break;
            case GREATER_THAN:
                filter += DENODO_API_GREATER_THAN;
                break;
            case LESS_THAN_OR_EQUAL_TO:
                filter += DENODO_API_LESS_THAN_OR_EQUAL_TO;
                break;
            case GREATER_THAN_OR_EQUAL_TO:
                filter += DENODO_API_GREATER_THAN_OR_EQUAL_TO;
                break;
            case LIKE:
                filter += DENODO_API_LIKE;
                break;
            case NOT_LIKE:
                filter += DENODO_API_NOT_LIKE;
                break;
            case IS_NULL:
                filter += DENODO_API_IS_NULL;
                break;
            case IS_NOT_NULL:
                filter += DENODO_API_IS_NOT_NULL;
                break;
        }
        if(constraint != IS_NULL && constraint != IS_NOT_NULL) {
            // The Denodo API requires DATE and TIMESTAMP values to be wrapped in single-quotes.
            if(field.toUpperCase().contains("DATE")) {
                // The Denodo API requires TIMESTAMP values to be prefixed and have the 'T' delimiter removed.
                if(value.toUpperCase().contains("T")) {
                    value = value.replace('T', ' ');
                    value = "TIMESTAMP '" + value + "'";
                }
                // The Denodo API requires DATE values to be prefixed.
                else {
                    value = "DATE '" + value + "'";
                }
            } else {
                value = APOSTROPHE + value + APOSTROPHE;
            }
            filter += StringUtils.urlEncode(value);
        }
        constraints++;
        return this;
    }

    public DenodoFilter addAndFilter(String filter1, String filter2) {
        return addFilter(filter1, filter2, DENODO_API_AND);
    }

    public DenodoFilter addOrFilter(String filter1, String filter2) {
        return addFilter(filter1, filter2, DENODO_API_OR);
    }

    public DenodoFilter addFilter(String additionalFilter1, String additionalFilter2, String denodoAPIConstant) {
        filter += "(" + additionalFilter1.replace("&$filter=", "") + ")";
        filter += denodoAPIConstant;
        filter += "(" + additionalFilter2.replace("&$filter=", "") + ")";
        constraints++;
        return this;
    }

    public String create() throws InvalidFilterException {
        if (constraints == 0) {
            throw new InvalidFilterException(NOT_ENOUGH_CONSTRAINTS);
        }

        filter = "&$filter=" + filter;

        return filter;
    }

    public DenodoFilter addConstraint(@NonNull String field, @NonNull Constraints constraint, String value)
            throws Exception {
        return addAndConstraint(field, constraint, value);
    }
}
