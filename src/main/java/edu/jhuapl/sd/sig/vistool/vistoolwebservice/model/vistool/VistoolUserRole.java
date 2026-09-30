/**
 * Defines the built-in Vistool role names.
 *
 * Roles are represented throughout the application as string values.
 * This class provides constants for the default system roles to avoid the use
 * of hard-coded string literals.
 *
 * Additional user-defined roles may be created and stored in the database.
 * Because authorization now operates on role names rather than an enum, custom
 * roles do not need to be added to this class.
 */

package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool;

public final class VistoolUserRole {
    public static final String VIEWER = "VIEWER";
    public static final String COMMENTER = "COMMENTER";
    public static final String EDITOR = "EDITOR";
    public static final String ADMIN = "ADMIN";

    private VistoolUserRole() {}
}