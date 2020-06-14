package ir.ac.kntu.logic.user;

import ir.ac.kntu.Hospital;
import ir.ac.kntu.logic.room.Section;
import ir.ac.kntu.tool.Menu;
import ir.ac.kntu.tool.ScannerWrapper;
import ir.ac.kntu.tool.SelectionList;

public class Security extends User{
    public Security(String name, String password) {
        super(name, password);
    }

    public void panel(Hospital hospital) {
        Menu menu = new Menu();
        System.out.println("Security Panel");
        System.out.println("You can just see information");
        System.out.println("1) Doctor");
        System.out.println("2) Patient");
        System.out.println("3) Nurse");
        System.out.println("4) Room");
        System.out.println("5) Login");
        System.out.println("6) Exit");
        int id;
        while (true) {
            int choice = ScannerWrapper.getMenuItem(5);
            switch (choice) {
                case 1:
                    id = ScannerWrapper.getIntField("doctor ID: ");
                    System.out.println(Menu.nullAction(hospital.getDoctor(id)));
                    break;
                case 2:
                    id = ScannerWrapper.getIntField("patient ID: ");
                    System.out.println(Menu.nullAction(hospital.getPatient(id)));
                    break;
                case 3:
                    id = ScannerWrapper.getIntField("nurse ID: ");
                    System.out.println(Menu.nullAction(hospital.getPatient(id)));
                    break;
                case 4:
                    int numberOfRoom = ScannerWrapper.getIntField("room number: ");
                    SelectionList list = new SelectionList();
                    Section sectionOfRoom = list.chooseSection();
                    System.out.println(Menu.nullAction(hospital.getRoom(numberOfRoom, sectionOfRoom)));
                    break;
                case 5:
                    User user = new UserHelper().login(hospital);
                    user.panel(hospital);
                    break;
                case 6:
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}
