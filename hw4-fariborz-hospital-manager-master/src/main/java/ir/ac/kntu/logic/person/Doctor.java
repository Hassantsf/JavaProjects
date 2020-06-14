package ir.ac.kntu.logic.person;

import ir.ac.kntu.Hospital;
import ir.ac.kntu.logic.room.Section;
import ir.ac.kntu.tool.*;

import java.util.ArrayList;

public class Doctor extends Personnel {
    final private static int MAX_NUMBER_OF_SHIFT = 3;
    private ArrayList<Patient> patients;
    private int maxNumberOfPatient = 5;
    private Nurse[] nurses = new Nurse[2];
    private Section section;

    public Doctor() {
    }

    public Doctor(Hospital hospital) {
        super();
        SelectionList list = new SelectionList();
        // Section
        section = list.chooseSection();
        if (section == Section.ICU) {
            maxNumberOfPatient = 3;
        } else if (section == Section.EMERGENCY) {
            patients = null;
        } else {
            if (ScannerWrapper.getBoolField("patient", "Yes", "No")) {
                System.out.println("Note that you can't Declare more than " + maxNumberOfPatient + " patients!");
                int numberOfShift = ScannerWrapper.getNumberItem("patient", maxNumberOfPatient);
                patients.add(new Patient(hospital));
            }
        }

        ArrayList<Shift> shifts = new ArrayList<>();
        if (ScannerWrapper.getBoolField("shift", "Yes", "No")) {
            System.out.println("Note that you can't Declare more than " + MAX_NUMBER_OF_SHIFT + " shift!");
            int numberOfShift = ScannerWrapper.getNumberItem("shift", MAX_NUMBER_OF_SHIFT);
            for (int i = 0; i < numberOfShift; i++) {
                shifts.add(new Shift());
            }
        } else {
            for (int i = 0; i < MAX_NUMBER_OF_SHIFT; i++) {
                shifts.add(new Shift(ShiftTime.MORNING, Week.MONDAY));
            }
        }
        setShifts(shifts);

        if (ScannerWrapper.getBoolField("nurse", "Yes", "No")) {
            for (int i = 0; i < 2; i++) {
                int nurseId = ScannerWrapper.getIntField("nurse ID");
                nurses[i] = hospital.getNurse(nurseId);
                nurses[i].setShifts(shifts);
            }
        } else {
            for (int i = 0; i < 2; i++) {
                nurses[i] = null;
            }
        }

        System.out.println("---------------------------------------------------");
    }

    public Doctor(String name, ArrayList<Patient> patients, ArrayList<Shift> shifts, int id, Nurse[] nurses) {
        super(name, shifts, id);
        this.patients = patients;
        this.nurses = nurses;
    }

    public ArrayList<Patient> getAllPatients() {
        return new ArrayList<Patient>(patients);
    }

    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }

    public void changeDoctor() {
        System.out.println("Changing Doctor Information: ");
        System.out.println("Which Part Do You Want to Change: (Once You're Done Press 0)");
        Shift tool = new Shift();
        int choice = 1;
        while (choice != 0) {
            System.out.println("1) Name | 2) Patients ID | 3) Shifts | 4) Personnel ID");
            choice = ScannerWrapper.getInt();
            switch (choice) {
                case 1:
                    setName(ScannerWrapper.getStringField("New Name: "));
                    break;
                case 2:
                    break;
                case 3:
                    int dayNumber = ScannerWrapper.getNumberItem("number of day", 7);
                    int timeNumber = ScannerWrapper.getNumberItem("number of Time", 3);
                    Shift shift = getShift(dayNumber, timeNumber);
                    changeShift(shift);
                    break;
                case 4:
                    setId(ScannerWrapper.getIntField("Personnel ID: "));
                    System.out.println("Doctor's ID changed successfully");
                    break;
                default:
                    System.out.println("Wrong Input");
            }
            System.out.println("New Changing: ");
        }
    }

    public void deletePatient(Patient patient) {
        patients.remove(patient);
    }
}
