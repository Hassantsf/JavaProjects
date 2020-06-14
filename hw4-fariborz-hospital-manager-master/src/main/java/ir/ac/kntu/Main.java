package ir.ac.kntu;

import ir.ac.kntu.logic.user.Admin;
import ir.ac.kntu.logic.user.UserHelper;
import ir.ac.kntu.logic.user.User;
import ir.ac.kntu.tool.Menu;
import ir.ac.kntu.tool.ScannerWrapper;

public class Main {

    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        Menu menu = new Menu();
        String userPassRaw = new UserHelper().create();
        String[] userPass = userPassRaw.split(" ");
        User admin = new Admin(userPass[0], userPass[1]);
        hospital.addUser(admin);
        admin.panel(hospital);
        ScannerWrapper.closeScanner();
    }
}