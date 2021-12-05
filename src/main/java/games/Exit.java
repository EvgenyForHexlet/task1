package games;


import games.common.SharedMemory;
import io.IOManager;

public class Exit implements Game {

    private IOManager ioManager;
    private SharedMemory sharedMemory;

    public Exit() {
        sharedMemory = SharedMemory.getSharedMemory();
        ioManager = IOManager.getIOManager();
    }

    @Override
    public int getGameNumber() {
        return 0;
    }

    @Override
    public String getName() {
        return "Exit";
    }

    @Override
    public void play() {
        ioManager.printLine("Good bye, " + sharedMemory.getUser());
    }
}
