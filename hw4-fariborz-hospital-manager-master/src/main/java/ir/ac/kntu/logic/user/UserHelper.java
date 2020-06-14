package ir.ac.kntu.logic.user;

import ir.ac.kntu.Hospital;
import ir.ac.kntu.tool.ScannerWrapper;
import ir.ac.kntu.tool.exceptions.EmptyField;
import ir.ac.kntu.tool.exceptions.ShortValue;
import ir.ac.kntu.tool.exceptions.StartWithLetter;

public class UserHelper {
    public String create() {
        ScannerWrapper.getString();
        String name = userNameInput();
        String password = passwordInput();
        return name + " " + password;
    }

    public User login(Hospital hospital) {
        ScannerWrapper.getString();
        User user = null;
        while (user == null) {
            String name = userNameInput();
            String password = passwordInput();
            user = hospital.getUser(name, password);
            if (user == null) {
                System.out.println("Wrong password(User name)");
            } else {
                System.out.println("Access Granted");
            }
        }
        return user;
    }

    public User login(Hospital hospital, String name, String password) {
        User user = null;
        user = hospital.getUser(name, password);
        return user;
    }

    private void validateUserName(String name) throws Exception {
        if (name == null || name.isEmpty()) {
            throw new EmptyField();
        }

        if (name.length() < 3) {
            throw new ShortValue();
        }
        if (!Character.isAlphabetic(name.charAt(0))) {
            throw new StartWithLetter();
        }
    }

    public void validatePassword(String password) throws Exception {
        if (password == null || password.isEmpty()) {
            throw new EmptyField();
        }

        if (password.length() < 5) {
            throw new ShortValue();
        }
    }

    private String userNameInput() {
        String name = null;
        boolean isPassed = false;
        while (!isPassed) {
            name = ScannerWrapper.getStringField("user name");
            try {
                validateUserName(name);
                isPassed = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return name;
    }

    private String passwordInput() {
        boolean isPassed = false;
        String password = null;
        while (!isPassed) {
            password = ScannerWrapper.getStringField("password");
            try {
                validatePassword(password);
                isPassed = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return password;
    }
}
