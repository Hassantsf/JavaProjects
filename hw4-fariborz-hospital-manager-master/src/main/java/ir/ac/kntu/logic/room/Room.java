package ir.ac.kntu.logic.room;

import ir.ac.kntu.Hospital;
import ir.ac.kntu.logic.person.Patient;
import ir.ac.kntu.tool.ScannerWrapper;
import ir.ac.kntu.tool.SelectionList;

import java.util.ArrayList;

public class Room {
    private int number;
    private ArrayList<Facility> beds;
    private Facility cooler;
    private Facility fridge;
    private Facility tv;
    private boolean state;
    private Section section;
    private ArrayList<Patient> patients = new ArrayList<>();
    private boolean vip;

    public Room(boolean isVip, Hospital hospital) {
        SelectionList list = new SelectionList();
        section = list.chooseSection();
        if (section == Section.ICU && !isVip) {
            System.out.println("All Room in ICU section are VIP!");
            System.err.println("Operation failed!");
            return;
        }
        System.out.println("Creating new room: ");
        System.out.println("-------------------------------------------------");
        this.number = ScannerWrapper.getIntField(" room number");

        beds = new ArrayList<>();

        if (!isVip) {
            if (ScannerWrapper.getBoolField("more than one bed", "Yes", "No")) {
                int number = ScannerWrapper.getNumberItem("bed", 6);
                for (int i = 0; i < number; i++) {
                    beds.add(new Facility(Type.BED));
                }
            } else {
                beds.add(new Facility(Type.BED));
            }
        }
        setTv(new Facility(Type.TV));
        fridge = new Facility(Type.FRIDGE);
        cooler = new Facility(Type.COOLER);
        state = true;

        setPatients(new ArrayList<>());
        if (ScannerWrapper.getBoolField("patient", "Yes", "No")) {
            int number = ScannerWrapper.getNumberItem("patient", 6);
            for (int i = 0; i < number; i++) {
                patients.add(hospital.getPatient(ScannerWrapper.getIntField("patient ID")));
            }
        }

        this.setVip(isVip);
        System.out.println("-------------------------------------------------");
    }

    public Room() {

    }

    // Getters
    public int getNumber() {
        return number;
    }

    // Setters
    public void setNumber(int number) {
        this.number = number;
    }

    public ArrayList<Facility> getAllBeds() {
        return new ArrayList<Facility>(beds);
    }

    public Facility getFridge() {
        return fridge;
    }

    public void setFridge(Facility fridge) {
        this.fridge = fridge;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Facility getCooler() {
        return cooler;
    }

    public void setCooler(Facility cooler) {
        this.cooler = cooler;
    }

    public void changeRoom(Hospital hospital) {
        SelectionList list = new SelectionList();
        System.out.println("Changing Room: ");
        System.out.println("Enter Number: ");
        int number = ScannerWrapper.getInt();
        Section section = list.chooseSection();
        int index = hospital.indexOfRoom(number, section);
        if (index >= 0) {
            int choice = 1;
            while (choice != 0) {
                System.out.println("Which do you want to change: (Once you're done press 0)");
                System.out.println("1) Number of room | 2) Beds\n3) Closet 4)" +
                        " Fridge | 5) Availability\n6) Section name | 7) VIP");
                choice = ScannerWrapper.getInt();
                switch (choice) {
                    case 1:
                        this.number = ScannerWrapper.getIntField("number of room");
                        System.out.println("Number of room changed successfully!");
                        break;
                    case 2:
                        System.out.println("Enter facility number: ");
                        int indexOfBed = indexOfBed(ScannerWrapper.getStringField("number of bed"));
                        if (indexOfBed >= 0) {
                            beds.get(indexOfBed).changeFacility(hospital);
                        } else {
                            System.out.println("We can't find your item.");
                        }
                        break;

                    case 3:
                        cooler = cooler.changeFacility(hospital);
                        break;

                    case 4:
                        fridge = fridge.changeFacility(hospital);
                        break;

                    case 5:
                        state = ScannerWrapper.getBoolField("Availability", "Available", "Unavailable");
                        System.out.println("Your Change Was Successful!");
                        break;
                    case 6:
                        section = list.chooseSection();
                        System.out.println("Section name of room changed successfully!");
                        break;
                    default:
                        break;
                }
            }

        } else {
            System.out.println("Your Room isn't in our record.");
        }

        hospital.registerRoom(this, index);
    }

    @Override
    public String toString() {
        return "Room\n" +
                "number = " + number +
                "  state = " + (state ? "Available" : "Unavailable") +
                "  section = '" + getSection() + "'\n" + "Beds: ";
    }

    public int indexOfBed(String numberOfBed) {
        for (int i = 0; i < beds.size(); i++) {
            if (beds.get(i).getNumber().equals("000" + numberOfBed)) {
                return i;
            }
        }
        return -1;
    }

    public ArrayList<Patient> getAllPatients() {
        return new ArrayList<>(patients);
    }

    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }

    public int getPriceOfRoom(int basePrice) {
        int percentOfIncrement = (beds.size() - 1) * -10;
        if (fridge != null) {
            percentOfIncrement += 10;
        }
        if (getTv() != null) {
            percentOfIncrement += 15;
        }
        if (cooler != null) {
            percentOfIncrement += 5;
        }

        return basePrice * percentOfIncrement / 100;
    }

    public Facility getTv() {
        return tv;
    }

    public void setTv(Facility tv) {
        this.tv = tv;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        vip = vip;
    }
}