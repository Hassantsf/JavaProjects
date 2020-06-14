package ir.ac.kntu.logic.user;

import ir.ac.kntu.Hospital;
import ir.ac.kntu.tool.Menu;
import ir.ac.kntu.tool.ScannerWrapper;

public class Admin extends User {
    public Admin(String name, String password) {
        super(name, password);
    }

    public void panel(Hospital hospital) {
        Menu menu = new Menu();
        while (true) {
            System.out.println("Admin Panel: ");
            System.out.println("1) Doctor: ");
            System.out.println("2) Patient");
            System.out.println("3) Room");
            System.out.println("4) Nurse");
            System.out.println("5) Facility");
            System.out.println("6) Create User");
            System.out.println("7) Login");
            System.out.println("8) Exit");
            int choice = ScannerWrapper.getMenuItem(7);
            switch (choice) {
                case 1:
                    menu.doctorMenu(hospital);
                    break;
                case 2:
                    menu.patientMenu(hospital);
                    break;
                case 3:
                    menu.roomMenu(hospital);
                    break;
                case 4:
                    menu.nurseMenu(hospital);
                    break;
                case 5:
                    menu.facilityMenu(hospital);
                    break;
                case 6:
                    newUser(hospital);
                    break;
                case 7:
                    User user = new UserHelper().login(hospital);
                    user.panel(hospital);
                    break;
                case 8:
                    System.out.println("Good Bye");
                    System.exit(0);
                    return;
                default:
                    break;
            }
        }
    }

    public void newUser(Hospital hospital) {
        System.out.println("Which user want to create: [1) Security | 2) Ordinary User]");
        int choice = ScannerWrapper.getMenuItem(2);
        String userPassRaw = new UserHelper().create();
        String[] userPass = userPassRaw.split(" ");
        User user;
        switch (choice) {
            case 1:
                user = new Security(userPass[0], userPass[1]);
                hospital.addUser(user);
                user.panel(hospital);
                break;
            case 2:
                user = new Normal(userPass[0], userPass[1]);
                hospital.addUser(user);
                user.panel(hospital);
                break;
            default:
                break;
        }
    }
}
