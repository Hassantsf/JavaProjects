package ir.ac.kntu.logic;

import ir.ac.kntu.util.ScannerWrapper;

import java.util.ArrayList;

public class DirectorHelper {
    static int getNumberOfSolider() {
        System.out.println("Please enter number of soldiers:");
        int number = ScannerWrapper.getInt();
        while (number <= 0) {
            System.out.println("Wrong Input!");
            number = ScannerWrapper.getInt();
        }
        return number;
    }

    static boolean isAllDead(ArrayList<Soldier> groupA, ArrayList<Soldier> groupB) {
        return groupA.size() == 0 || groupB.size() == 0;
    }
}
