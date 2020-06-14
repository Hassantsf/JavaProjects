package ir.ac.kntu.logic.room;

import ir.ac.kntu.Hospital;
import ir.ac.kntu.tool.DateTools;
import ir.ac.kntu.tool.ScannerWrapper;

import java.util.Date;

public class Facility {
    private Type type;
    private String number;
    private boolean state;
    private Date lastCheckUp;

    public Facility(Type type) {
        this.type = type;
        String number;
        number = getPrefix(type) + ScannerWrapper.getStringField("facility Number");
        this.number = number;
        state = true;
        lastCheckUp = new Date();
        System.out.println("State and last checkup by default set to available and current time!");
    }

    public Facility(Type type, String number, boolean state, Date lastCheckUp) {
        this.type = type;
        this.number = number;
        this.state = state;
        this.lastCheckUp = lastCheckUp;
    }

    // Getters
    public Type getType() {
        return type;
    }

    // Setters
    public void setType(Type type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Date getLastCheckUp() {
        return lastCheckUp;
    }

    public void setLastCheckUp(Date lastCheckUp) {
        this.lastCheckUp = lastCheckUp;
    }

    // View & New & Edit Section
    @Override
    public String toString() {
        return "Facility:\n" +
                "type = '" + type + '\'' +
                " number = " + number +
                " state = " + (state ? "'Available'" : "Unavailable") +
                " lastCheckUp = " + lastCheckUp;
    }

    public Facility changeFacility(Hospital hospital) {
        System.out.println("Changing Facility!");
        System.out.println("Which Part Do You Want to Change: (Once You're Done Press 0)");
        int choice = 1;
        while (choice != 0) {
            System.out.println("1) Number | 2) Accessibility | 3) Last CheckUp");
            choice = ScannerWrapper.getInt();
            System.out.println("New Changing:");
            switch (choice) {
                case 0:
                    break;

                case 1:
                    number = ScannerWrapper.getStringField("New Number: ");
                    System.out.println("Your Change Was Successful!");
                    break;

                case 2:
                    state = ScannerWrapper.getBoolField("Availability", "Available", "Unavailable");
                    System.out.println("Your Change Was Successful!");
                    break;

                case 3:
                    DateTools help = new DateTools();
                    help.changeDate(lastCheckUp);
                    break;

                default:
                    System.out.println("Wrong Input!");
                    System.out.println("Structures");
                    break;
            }
        }
        return this;
    }

    public String getPrefix(Type type) {
        switch (type) {
            case FRIDGE:
                return "001";
            case TV:
                return "002";
            case COOLER:
                return "003";
            default:
                return "000";
        }
    }
}
