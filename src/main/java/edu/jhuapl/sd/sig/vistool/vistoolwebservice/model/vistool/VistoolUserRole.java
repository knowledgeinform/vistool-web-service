package edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool;

public enum VistoolUserRole {
    VIEWER("VIEWER"),
    COMMENTER("COMMENTER"),
    EDITOR("EDITOR"),
    ADMIN("ADMIN");

    private String value;

    VistoolUserRole(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }
}
