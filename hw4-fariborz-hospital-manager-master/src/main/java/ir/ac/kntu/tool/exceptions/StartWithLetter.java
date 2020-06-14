package ir.ac.kntu.tool.exceptions;

public class StartWithLetter extends Exception {
    public StartWithLetter() {
        super("Must be started with Alphabetic character!");
    }
}
