package ir.ac.kntu.tool;

import ir.ac.kntu.Hospital;
import ir.ac.kntu.logic.person.Patient;
import ir.ac.kntu.logic.room.Room;
import ir.ac.kntu.logic.room.Section;
import ir.ac.kntu.logic.room.Type;
import ir.ac.kntu.logic.room.VIPRoom;

import java.util.ArrayList;

public class HospitalHelper {
    public void viewUnavailableRooms(Hospital hospital) {
        ArrayList<Room> rooms = hospital.getAllRooms();
        int counter = 0;
        System.out.println("Unavailable rooms: ");
        System.out.println("-------------------------------------------");
        for (int i = 0; i < rooms.size(); i++) {
            if (!rooms.get(i).isState()) {
                System.out.println(rooms.get(i));
                counter++;
            }

            if (counter % 2 == 1) {
                ScannerWrapper.getIntField("any key:");
            }
        }
        System.out.println("-------------------------------------------");
    }

    public void searchByFacility(Hospital hospital, Type type) {
        ArrayList<Room> rooms = hospital.getAllRooms();
        switch (type) {
            case COOLER:
                System.out.println("Getting all closets: ");
                break;
            case FRIDGE:
                System.out.println("Getting all fridges: ");
                break;
            case BED:
                System.out.println("Getting all beds: ");
                break;
            case TV:
                System.out.println("Getting all TVs: ");
                break;
            case PHONE:
                System.out.println("Getting all phones: ");
                break;
            default:
                break;
        }
        for (int i = 0; i < rooms.size(); i++) {
            Room store = rooms.get(i);
            switch (type) {
                case BED:
                    for (int j = 0; j < store.getAllBeds().size(); j++) {
                        System.out.println(store.getAllBeds().get(j));
                    }
                    break;
                case PHONE:
                    if (store instanceof VIPRoom) {
                        System.out.println(((VIPRoom) store).getPhone());
                    }
                    break;
                case TV:
                    System.out.println(store.getTv());
                    break;
                case COOLER:
                    System.out.println(store.getCooler());
                    break;
                case FRIDGE:
                    System.out.println(store.getFridge());
                    break;
                default:
                    break;
            }
        }
    }

    public void viewEmptyRoom(Hospital hospital, int capacity) {
        ArrayList<Room> rooms = hospital.getAllRooms();
        if (capacity < 0) {
            System.out.println("Rooms with capacity:");
            for (int i = 0; i < rooms.size(); i++) {
                Room store = rooms.get(i);
                int a = 2;
                if (store.getAllPatients().size() < 4) {
                    System.out.println(store);
                }
            }
        } else {
            System.out.println("Rooms that have " + capacity + " spaces:");
            for (int i = 0; i < rooms.size(); i++) {
                Room store = rooms.get(i);
                if (store.getAllPatients().size() < 4 - capacity) {
                    System.out.println(store);
                }
            }
        }
    }

    public void viewFacilityOfHospital(Hospital hospital) {
        System.out.println("Facility of Hospital");
        for (Section a :
                Section.values()) {
            facilityOfSectionLog(hospital, a);
        }
    }

    public void facilityOfSectionLog(Hospital hospital, Section section) {
        ArrayList<Room> rooms = hospital.getAllRooms();
        System.out.println("--------------------------------------------------------");
        System.out.println("Facilities of " + section.toString() + " Section" + " : ");
        int counterScreen = 0;
        for (int i = 0; i < rooms.size(); i++) {
            Room store = rooms.get(i);
            if (store.getSection() == section) {
                System.out.println("Room: " + store.getNumber());
                if (store.isVip()) {
                    VIPRoom room = (VIPRoom) store;
                    System.out.println(room.getBed());
                    System.out.println(room.getPhone());
                }
                for (int j = 0; j < store.getAllBeds().size(); j++) {
                    System.out.println(store.getAllBeds().get(j));
                }

                System.out.println(store.getCooler());
                System.out.println(store.getFridge());
                counterScreen++;
            }
            if (counterScreen % 2 == 1) {
                System.out.println("Please press enter key to see other items: ");
                ScannerWrapper.getString();
            }
        }
        System.out.println("--------------------------------------------------------\n");
    }

    public void patientOfSectionLog(Hospital hospital, Section section) {
        ArrayList<Patient> patients = hospital.getAllPatients();
        System.out.println("Patients of " + section + " Section" + " : ");
        int counterScreen = 0;
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getSection() == section) {
                System.out.println(patients.get(i));
                counterScreen++;
            }
            if (counterScreen % 2 == 0) {
                System.out.println("Please press enter key to see other items: ");
                ScannerWrapper.getString();
            }
        }
    }

}
