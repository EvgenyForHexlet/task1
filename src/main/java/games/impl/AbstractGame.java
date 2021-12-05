package games.impl;

import games.Game;
import games.common.SharedMemory;
import io.IOManager;

public abstract class AbstractGame<T> implements Game {

    protected final SharedMemory sharedMemory = SharedMemory.getSharedMemory();
    protected final IOManager ioManager = IOManager.getIOManager();

    protected Integer askForAnswer() {
        Integer result = null;
        while (result==null) {
            result = ioManager.askForInt("Your answer: ");
        }
        return result;
    }

    protected boolean assertAnswer(T rightAnswer, T userAnswer) {

        if(rightAnswer.equals(userAnswer)) {
            ioManager.printLine("Correct!");
            return true;
        }
        ioManager.printLine(userAnswer + " is wrong answer ;(. Correct answer was " + rightAnswer);
        return false;

    }
    /**
     * This helper method asks user for 'yes' or 'now' answer. Due the answer doesn't match the question will be asked again.
     *
     * @return true if 'yes', false if 'no'
     */
    protected boolean askYesOrNo() {
        String result = "";
        while (!(result.toLowerCase().equals("yes") || result.toLowerCase().equals("no"))) {
            result = ioManager.askForString("Your answer: ");
        }
        return result.toLowerCase().equals("yes");

    }


}
