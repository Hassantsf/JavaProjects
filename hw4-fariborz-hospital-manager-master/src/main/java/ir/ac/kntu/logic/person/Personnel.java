package ir.ac.kntu.logic.person;

import ir.ac.kntu.tool.ScannerWrapper;
import ir.ac.kntu.tool.Shift;

import java.util.ArrayList;

public class Personnel {
    private String name;
    private ArrayList<Shift> shifts;
    private int id;

    public Personnel() {
        ScannerWrapper.getString();
        System.out.println("---------------------------------------------------");
        setName(ScannerWrapper.getStringField("name"));
        setId(ScannerWrapper.getIntField("ID"));
    }

    public Personnel(String name, ArrayList<Shift> shifts, int id) {
        this.setName(name);
        this.setShifts(shifts);
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Shift> getAllShifts() {
        return new ArrayList<Shift>(shifts);
    }

    public void setShifts(ArrayList<Shift> shifts) {
        this.shifts = shifts;
    }

    @Override
    public String toString() {
        return "Personnel: " + '\n' +
                " name = '" + name + '\'' +
                " id = " + id;
    }

    public Shift getShift(int dayNumber, int timeNumber) {
        ArrayList<Shift> shifts = getAllShifts();

        for (int i = 0; i < shifts.size(); i++) {
            Shift store = shifts.get(i);

            if (store.getDayNumber() == dayNumber && store.getTimeNumber() == timeNumber) {
                return store;
            }
        }

        return null;
    }

    public void changeShift(Shift shift) {
        System.out.println("Which part do you want to change: ");
        System.out.println("1) Day | 2) Time");
        int choice = ScannerWrapper.getMenuItem(2);
        switch (choice) {
            case 1:
                int dayNumber = ScannerWrapper.getNumberItem("day (1 - 7)", 7);
                shift.setDayNumber(dayNumber);
                shift.setDay(shift.convertIntToWeek(dayNumber));
                System.out.println("Change was successful!");
                break;
            case 2:
                int timeNumber = ScannerWrapper.getNumberItem("time (1) Morning | 2) Afternoon | 3) Night)", 7);
                shift.setTimeNumber(timeNumber);
                shift.setTime(shift.convertIntToTime(timeNumber));
                System.out.println("Change was successful!");
                break;
            default:
                break;
        }
    }
}
