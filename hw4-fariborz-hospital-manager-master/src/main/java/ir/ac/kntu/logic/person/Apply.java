package ir.ac.kntu.logic.person;

import ir.ac.kntu.tool.ScannerWrapper;

public enum Apply {
    ORDINARY("Ordinary"),
    EMERGENCY("Emergency");

    private final String applyText;

    private Apply(String applyText) {
        this.applyText = applyText;
    }

    public String toString() {
        return applyText;
    }
}
