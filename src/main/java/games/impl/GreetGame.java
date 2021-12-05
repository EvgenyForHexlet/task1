package games.impl;

public class GreetGame extends AbstractGame<String> {

    public int getGameNumber() {
        return 1;
    }
    
    public String getName() {
        return "Greet";
    }
    
    public void play() {
        ioManager.printLine("Welcome to the Brain Games!");
        sharedMemory.setUser(ioManager.askForString("May I have your name? "));
        ioManager.printLine("Hello, " + sharedMemory.getUser() + "!");

    }
}
