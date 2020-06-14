package ir.ac.kntu.logic.person;

import ir.ac.kntu.tool.ScannerWrapper;

public enum Disease {
    BURNING("Burning"),
    INJURY("Injury"),
    ACCIDENT("Accident"),
    OTHER_ITEMS("Other Items");

    private final String diseaseText;

    Disease(String diseaseText) {
        this.diseaseText = diseaseText;
    }

    public String toString() {
        return diseaseText;
    }
}
