package games.impl;


public class Exit extends AbstractGame<String> {

    public int getGameNumber() {
        return 0;
    }

    public String getName() {
        return "Exit";
    }

    public void play() {
        String sayGoodbye = "Good bye";
        sayGoodbye += sharedMemory.getUser().equals("") ? "" : ", " + sharedMemory.getUser();
        ioManager.printLine(sayGoodbye);
    }
}
