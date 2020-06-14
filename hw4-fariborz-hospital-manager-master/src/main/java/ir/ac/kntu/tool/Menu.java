package ir.ac.kntu.tool;

import ir.ac.kntu.Hospital;
import ir.ac.kntu.logic.person.*;
import ir.ac.kntu.logic.room.*;

public class Menu {
    private HospitalHelper helper = new HospitalHelper();

    public void doctorMenu(Hospital hospital) {
        while (true) {
            System.out.println("Doctor: ");
            System.out.println("1) Create");
            System.out.println("2) Modify");
            System.out.println("3) View");
            System.out.println("4) Delete");
            System.out.println("5) View shifts");
            System.out.println("6) Return");
            int choice = ScannerWrapper.getMenuItem(6);
            int id;
            switch (choice) {
                case 1:
                    Section section = new SelectionList().chooseSection();
                    if (section != Section.ICU) {
                        Doctor newDoctor = new Doctor(hospital);
                        hospital.addDoctor(newDoctor);
                    } else {
                        System.out.println("You must create VIP Room for ICU.");
                    }
                    break;
                case 2:
                    id = ScannerWrapper.getIntField("doctor ID: ");
                    try {
                        hospital.getDoctor(id).changeDoctor();
                    } catch (NullPointerException e) {
                        System.out.println("Item isn't available right now!");
                    }
                    break;

                case 3:
                    id = ScannerWrapper.getIntField("doctor ID: ");
                    System.out.println(nullAction(hospital.getDoctor(id)));
                    break;
                case 4:
                    id = ScannerWrapper.getIntField("doctor ID: ");
                    hospital.deleteDNP(hospital.getDoctor(id));
                    break;
                case 5:
                    id = ScannerWrapper.getIntField(" Doctor ID");
                    System.out.println(nullAction(hospital.getDoctor(id).getAllShifts()));
                    break;
                case 6:
                    return;
                default:
                    break;
            }
        }
    }

    public void patientMenu(Hospital hospital) {
        SelectionList list = new SelectionList();
        while (true) {
            System.out.println("Patient:\n1) Create\n2) Modify");
            System.out.println("3) View\n4) Delete\n5) Relieve");
            System.out.println("6) View patients of section\n7) View doctor of patient");
            System.out.println("8) Return");
            int choice = ScannerWrapper.getMenuItem(8);
            int id, index;
            switch (choice) {
                case 1:
                    Patient newPatient = new Patient(hospital);
                    hospital.addPatient(newPatient);
                    break;
                case 2:
                    id = ScannerWrapper.getIntField("patient ID: ");
                    try {
                        hospital.getPatient(id).changePatient(hospital);
                    } catch (NullPointerException e) {
                        System.out.println("Item isn't available right now!");
                    }
                    break;
                case 3:
                    id = ScannerWrapper.getIntField("patient ID: ");
                    System.out.println(hospital.getPatient(id));
                    break;
                case 4:
                    id = ScannerWrapper.getIntField("patient ID: ");
                    try {
                        hospital.getPatient(id).relievePatient(hospital);
                    } catch (NullPointerException e) {
                        System.out.println("Item isn't available right now!");
                    }
                    break;
                case 5:
                    id = ScannerWrapper.getIntField("patient ID: ");
                    Patient patient = hospital.getPatient(id);
                    patient.relievePatient(hospital);
                    break;
                case 6:
                    Section section = list.chooseSection();
                    helper.patientOfSectionLog(hospital, section);
                    break;
                case 7:
                    id = ScannerWrapper.getIntField(" ID: ");
                    try {
                        System.out.println(hospital.getPatient(id).getDoctor());
                    } catch (NullPointerException e) {
                        System.out.println("Item isn't available right now!");
                    }
                    break;
                case 8:
                    return;
                default:
                    break;
            }
        }
    }

    public void roomMenu(Hospital hospital) {
        SelectionList list = new SelectionList();
        while (true) {
            System.out.println("Room: ");
            System.out.println("1) Create\n2) Create VIP\n3) Modify");
            System.out.println("4) View\n5) Delete\n6) Search with capacity");
            System.out.println("7) Search with n capacity\n8) Search unavailable rooms\n9) Return\"");
            int choice = ScannerWrapper.getMenuItem(8);
            Section section;
            int number;
            switch (choice) {
                case 1:
                    Room newRoom = new Room(false, hospital);
                    hospital.addRoom(newRoom);
                    break;
                case 2:
                    Room newVipRoom = new VIPRoom(hospital);
                    hospital.addRoom(newVipRoom);
                    break;
                case 3:
                    number = ScannerWrapper.getIntField("room Number: ");
                    section = list.chooseSection();
                    try {
                        hospital.getRoom(number, section).changeRoom(hospital);
                    } catch (NullPointerException e) {
                        System.out.println("Item isn't available right now!");
                    }
                    break;
                case 4:
                    number = ScannerWrapper.getIntField("room Number: ");
                    section = list.chooseSection();
                    System.out.println(nullAction(hospital.getRoom(number, section)));
                    break;
                case 5:
                    number = ScannerWrapper.getIntField("room Number: ");
                    section = list.chooseSection();
                    try {
                        hospital.deleteRoom(hospital.getRoom(number, section));
                    } catch (NullPointerException e) {
                        System.out.println("Item isn't available right now!");
                    }
                case 6:
                    helper.viewEmptyRoom(hospital, -1);
                    break;
                case 7:
                    int space = ScannerWrapper.getIntField("room spaces: ");
                    helper.viewEmptyRoom(hospital, space);
                    break;
                case 8:
                    helper.viewUnavailableRooms(hospital);
                    break;
                case 9:
                    return;
                default:
                    break;
            }
        }
    }

    public void nurseMenu(Hospital hospital) {
        while (true) {
            System.out.println("Nurse: ");
            System.out.println("1) Create");
            System.out.println("2) Modify");
            System.out.println("3) View");
            System.out.println("4) Delete");
            System.out.println("5) View Shift");
            System.out.println("6) Return");
            int choice = ScannerWrapper.getMenuItem(6);
            int id, index;
            switch (choice) {
                case 1:
                    Nurse newNurse = new Nurse();
                    hospital.addNurse(newNurse);
                    break;
                case 2:
                    id = ScannerWrapper.getIntField("nurse ID: ");

                    try {
                        hospital.getNurse(id).changeNurse();
                    } catch (NullPointerException e) {
                        System.out.println("Item isn't available right now!");
                    }
                    break;

                case 3:
                    id = ScannerWrapper.getIntField("nurse ID: ");
                    System.out.println(nullAction(hospital.getNurse(id)));
                    break;
                case 4:
                    id = ScannerWrapper.getIntField("nurse ID: ");
                    try {
                        hospital.deleteDNP(hospital.getNurse(id));
                    } catch (NullPointerException e) {
                        System.out.println("Item isn't available right now!");
                    }
                case 5:
                    id = ScannerWrapper.getIntField("nurse ID");
                    try {
                        System.out.println(hospital.getNurse(id).getAllShifts());
                    } catch (NullPointerException e) {
                        System.out.println("Item isn't available right now!");
                    }

                    break;
                case 6:
                    return;
                default:
                    break;
            }
        }
    }

    public void facilityMenu(Hospital hospital) {
        SelectionList list = new SelectionList();
        while (true) {
            System.out.println("1) View facilities of section");
            System.out.println("2) View facilities of hospital");
            System.out.println("3) Report Broken");
            System.out.println("4) Search with facility");
            System.out.println("5) Return");
            int choice = ScannerWrapper.getMenuItem(5);
            switch (choice) {
                case 1:
                    Section section2 = list.chooseSection();
                    helper.facilityOfSectionLog(hospital, section2);
                    break;
                case 2:
                    helper.viewFacilityOfHospital(hospital);
                    break;
                case 3:
                    int id = ScannerWrapper.getIntField("worker ID");
                    Worker worker = hospital.getWorker(id);
                    Shift shift = new Shift();
                    break;
                case 4:
                    Type type = list.chooseType();
                    helper.searchByFacility(hospital, type);

                    Section sectionOfFacility = list.chooseSection();
                    int numberOfRoom = ScannerWrapper.getIntField("number of facility's room: ");
//                    Facility facility = hospital.getFahtt

                    break;
                case 5:
                    return;
                default:
                    break;
            }
        }
    }

    public static void result(boolean status) {
        if (status) {
            System.out.println("Operation was successful!");
        } else {
            System.out.println("Operation failed!");
        }
    }

    public static String nullAction(Object item) {
        if (item == null) {
            return "This item hasn't registered yet!";
        } else {
            return item.toString();
        }
    }
}