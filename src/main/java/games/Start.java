package games;

import games.common.SharedMemory;
import games.errors.Error;
import games.impl.CalculatorGame;
import games.impl.EvenGame;
import games.impl.Exit;
import games.impl.GCDGame;
import games.impl.GreetGame;
import games.impl.PrimeGame;
import games.impl.ProgressionGame;
import io.IOManager;


public class Start {

    private final IOManager ioManager;
    private static Game[] games;
    private final Game GREET = new GreetGame();
    private final Game EXIT = new Exit();
    private final Game ERROR = new Error();

    public Start() {
        ioManager = IOManager.getIOManager();
        SharedMemory.getSharedMemory().setTries(3);
        games = new Game[7];
        games[0] = GREET;
        games[1] = new CalculatorGame();
        games[2] = new ProgressionGame();
        games[3] = new EvenGame();
        games[4] = new GCDGame();
        games[5] = new PrimeGame();
        games[6] = EXIT;
    }

    public void play() {
        ioManager.printLine("Please enter the game number and press Enter.");
        ioManager.printLines(generateGameLines());
        Integer number = ioManager.askForInt("Your choice: ");

        Game game = findGameByNumber(number);
        if(game.equals(GREET)||game.equals(EXIT)||game.equals(ERROR)) {
            game.play();
        }
        else {
            GREET.play();
            game.play();
        }

    }

    private String[] generateGameLines() {

        String[] lines = new String[games.length];
        for (int i = 0; i < games.length; i++) {
            String line = games[i].getGameNumber() + " - " + games[i].getName();
            lines[i] = line;
        }
        return lines;
    }

    private Game findGameByNumber(Integer number) {

        if(number != null) {
            for (Game game : games) {
                if (game.getGameNumber() == number) return game;
            }
        }
        return ERROR;

    }
}
