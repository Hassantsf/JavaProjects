package ir.ac.kntu.logic.user;

import ir.ac.kntu.Hospital;
import ir.ac.kntu.logic.person.Patient;
import ir.ac.kntu.tool.ScannerWrapper;

public class Normal extends User {
    public Normal(String name, String password) {
        super(name, password);
    }

    public void panel(Hospital hospital) {
        System.out.println("First enter your Id");
        Patient user = null;
        boolean isValid = false;
        while (!isValid) {
            int id = ScannerWrapper.getInt();
            user = hospital.getPatient(id);
            isValid = true;
            try {
                user.toString();
            } catch (NullPointerException e) {
                System.out.println("Wrong ID");
            }
        }

        System.out.println("Ordinary panel: ");
        System.out.println("1) View information");
        System.out.println("2) View doctor shifts");
        System.out.println("3) View Factor");
        System.out.println("4) Return");
        while (true) {
            int choice = ScannerWrapper.getMenuItem(4);
            switch (choice) {
                case 1:
                    System.out.println(user);
                    break;
                case 2:
                    try {
                        System.out.println(user.getDoctor().getAllShifts());
                    } catch (NullPointerException e) {
                        System.out.println("Item isn't available right now!");
                    }
                    break;
                case 3:
                    user.factorOfRelieve(hospital.getBasePriceOfRoom());
                    break;
                default:
                    break;
            }
        }
    }
}
