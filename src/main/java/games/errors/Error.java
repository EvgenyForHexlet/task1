package games.errors;

import games.Game;
import io.IOManager;

public class Error implements Game {

    private IOManager ioManager;

    public Error() {
        ioManager = IOManager.getIOManager();
    }
    @Override
    public int getGameNumber() {
        return -1;
    }

    @Override
    public String getName() {
        return "Error";
    }

    @Override
    public void play() {
        ioManager.printError("The input was wrong. Please start the game again.");

    }
}
