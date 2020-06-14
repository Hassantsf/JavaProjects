package ir.ac.kntu.tool;

import ir.ac.kntu.logic.person.Apply;
import ir.ac.kntu.logic.person.Disease;
import ir.ac.kntu.logic.person.Insurance;
import ir.ac.kntu.logic.room.Section;
import ir.ac.kntu.logic.room.Type;

public class SelectionList {
    public Type chooseType() {
        System.out.println("1) Bed | 2)Cooler | 3) Fridge | 4) Tv | 5) Phone(VIP)");
        int number = ScannerWrapper.getInt();
        Type type = Type.BED;
        switch (number) {
            case 1:
                type = Type.BED;
                break;
            case 2:
                type = Type.COOLER;
                break;
            case 3:
                type = Type.FRIDGE;
                break;
            case 4:
                type = Type.TV;
                break;
            case 5:
                type = Type.PHONE;
                break;
            default:
                break;
        }
        return type;
    }

    public Section chooseSection() {
        System.out.println("Choose section:");
        System.out.println("1) ICU 2) Emergency 3) Internal 4) Burning");
        int choice = ScannerWrapper.getInt();
        switch (choice) {
            case 1:
                return Section.ICU;
            case 2:
                return Section.EMERGENCY;
            case 3:
                return Section.INTERNAL;
            case 4:
                return Section.BURNING;
            default:
                return null;
        }
    }

    public Apply chooseApply() {
        System.out.println("Which Apply:");
        System.out.println("1) Ordinary | 2) Emergency");
        int choice = ScannerWrapper.getInt();
        switch (choice) {
            case 1:
                return Apply.ORDINARY;
            case 2:
                return Apply.EMERGENCY;
            default:
                return null;
        }
    }

    public Insurance chooseInsurance() {
        System.out.println("Which insurance:");
        System.out.println("1) Social Supplement | 2) Army Forces | 3) Medical Services");
        int choice = ScannerWrapper.getInt();
        switch (choice) {
            case 1:
                return Insurance.SOCIAL_SUPPLEMENT;
            case 2:
                return Insurance.ARMY_FORCES;
            case 3:
                return Insurance.MEDICAL_SERVICES;
            default:
                return null;
        }
    }

    public Disease chooseDisease() {
        System.out.println("Which Disease:");
        System.out.println("1) Burning | 2) Injury | 3) Accident | 4) Other Items");
        int choice = ScannerWrapper.getInt();
        switch (choice) {
            case 1:
                return Disease.BURNING;
            case 2:
                return Disease.INJURY;
            case 3:
                return Disease.ACCIDENT;
            default:
                return Disease.OTHER_ITEMS;
        }
    }
}
