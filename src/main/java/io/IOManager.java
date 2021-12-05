package io;

import java.util.Scanner;

public class IOManager {

    private static IOManager ioManager;
    private Scanner scanner = new Scanner(System.in);

    private IOManager() {}

    public static IOManager getIOManager() {
        if(ioManager == null) {
            ioManager = new IOManager();
        }
        return ioManager;
    }

    public void printLines(String[] textLines) {
        for(int i = 0; i<textLines.length; i++) {
            printLine(textLines[i]);
        }
    }

    public void printLine(String line) {
        System.out.println(line);
    }

    public void printError(String error) {
        System.err.println(error);
    }

    public String askForString(String question) {
        System.out.print(question);
        return scanner.next();
    }

    public Integer askForInt(String question) {
        System.out.print(question);

        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        }
        scanner.next();
        return null;
    }

}
