package ir.ac.kntu.logic.person;

import java.util.ArrayList;

import ir.ac.kntu.tool.ScannerWrapper;
import ir.ac.kntu.tool.Shift;

public class Nurse extends Personnel {
    // Fields
    private final static int NUMBER_OF_SHIFTS = 3;
    private ArrayList<Doctor> doctors;
    // Constructors
    public Nurse() {
        super();
    }

    public Nurse(String defaultName) {
        super(defaultName, null, 0);
        doctors = null;
    }

    public Nurse(String name, ArrayList<Shift> shifts, int id, ArrayList<Doctor> doctors) {
        super(name, shifts, id);
        this.doctors = doctors;
    }

    public void changeNurse() {
        System.out.println("Changing nurse:");
        System.out.println("Which Part Do You Want to Change: (Once You're Done Press 0)");
        Shift tool = new Shift();
        int choice = 1;
        while (choice != 0) {
            System.out.println("1) Name | 2) ID | 3) Shifts | 4) Personnel ID");
            choice = ScannerWrapper.getMenuItem(4);
            switch (choice) {
                case 1:
                    setName(ScannerWrapper.getStringField("New Name: "));
                    break;
                case 2:
                    int id = ScannerWrapper.getIntField("ID");
                    setId(id);
                    System.out.println("Doctor's ID changed successfully");
                    break;
                case 3:
                    int dayNumber = ScannerWrapper.getNumberItem("number of day", 7);
                    int timeNumber = ScannerWrapper.getNumberItem("number of Time", 3);
                    Shift shift = getShift(dayNumber, timeNumber);
                    changeShift(shift);
                    break;
                default:
                    System.out.println("Wrong Input");
            }
            System.out.println("New Changing: ");
        }
    }
}
