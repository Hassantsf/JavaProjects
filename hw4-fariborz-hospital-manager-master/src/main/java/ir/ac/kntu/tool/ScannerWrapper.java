package ir.ac.kntu.tool;

import java.util.Scanner;

/**
 * Class for wrap Scanner class to ensure that there is only one
 * Scanner in code and prevent pmd issue
 * It's not quite singleton
 */
public class ScannerWrapper {
    private static Scanner scanner = new Scanner(System.in);

    private ScannerWrapper() {
    }

    public static void closeScanner() {
        scanner.close();
    }

    public static int getInt() {
        return scanner.nextInt();
    }

    public static String getString() {
        return scanner.nextLine();
    }

    public static int getIntField(String field) {
        System.out.println("Enter " + field + " :");
        return scanner.nextInt();
    }

    public static String getStringField(String field) {
        System.out.println("Enter " + field + ":");
        return scanner.nextLine();
    }

    /**
     * Getting Input from User for Selective Options like Gender, ...
     *
     * @param field       the name of the field that user want to select
     * @param trueOption  name of first option
     * @param falseOption name of first option
     * @return boolean result
     */
    public static boolean getBoolField(String field, String trueOption, String falseOption) {
        System.out.println("Declare " + field + " :");
        System.out.println("1) " + trueOption + " | 2) " + falseOption);
        int choice = getMenuItem(2);
        if (choice == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Menu Utility
     * Method for get input using ScannerWrapper with ability of error handling
     * for menus
     *
     * @param roof Number of menu item
     * @return User input
     */

    public static int getNumberItem(String field, int roof) {
        System.out.println("How Many " + field + " :");
        int choice;
        choice = ScannerWrapper.getInt();
        while (choice < 0 || choice > roof) {
            System.out.println("Wrong input!");
            System.out.println("Try again");
            choice = ScannerWrapper.getInt();
        }
        return choice;
    }

    public static int getMenuItem(int roof) {
        int choice;
        choice = ScannerWrapper.getInt();
        while (choice < 1 || choice > roof) {
            System.out.println("Wrong input!");
            System.out.println("Try again");
            choice = ScannerWrapper.getInt();
        }
        return choice;
    }
}
