package ir.ac.kntu;

import ir.ac.kntu.logic.ConsoleGraphicsEngine;
import ir.ac.kntu.logic.Director;
import ir.ac.kntu.logic.GraphicsEngine;
import ir.ac.kntu.util.ScannerWrapper;

public class Main {
    public static void main(String[] args) {
        GraphicsEngine engine = new ConsoleGraphicsEngine();
        start();
        int choice = ScannerWrapper.getInt();
        if (choice == 1) {
            System.out.println("Enter number of soldiers");
            int number = ScannerWrapper.getInt();
            Director director = new Director(engine, number);
            director.startGameLoop();
        } else {
            System.exit(0);
        }
        ScannerWrapper.closeScanner();
    }

    public static void start() {
        System.out.println("Death Arena!");
        System.out.println("Choose:");
        System.out.println("1) Play");
        System.out.println("2) Exit");
    }
}
