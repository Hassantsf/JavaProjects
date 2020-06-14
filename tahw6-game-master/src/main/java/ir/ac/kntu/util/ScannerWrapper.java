package ir.ac.kntu.util;

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

    public static void hold() {
        System.out.println("Press any key:");
        scanner.next();
    }
}
