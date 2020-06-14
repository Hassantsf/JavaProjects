package ir.ac.kntu.logic.room;

import ir.ac.kntu.tool.ScannerWrapper;

public enum Section {
    ICU("ICU"),
    EMERGENCY("Emergency"),
    INTERNAL("Internal"),
    BURNING("Burning");

    private final String sectionText;

    Section(String sectionText) {
        this.sectionText = sectionText;
    }

    public String toString() {
        return sectionText;
    }
}