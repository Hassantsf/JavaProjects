package ir.ac.kntu.logic.person;

import ir.ac.kntu.tool.ScannerWrapper;

public enum Insurance {
    SOCIAL_SUPPLEMENT("Social Supplement", 10),
    ARMY_FORCES("Army Forces", 50),
    MEDICAL_SERVICES("Medical Services", 25);

    private final String insuranceText;
    private final int discount;

    Insurance(String insuranceText, int discount) {
        this.insuranceText = insuranceText;
        this.discount = discount;
    }

    public String printInsurance() {
        return insuranceText;
    }

    public int getDiscount() {
        return discount;
    }
}
