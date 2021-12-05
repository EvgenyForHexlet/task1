package games.impl;

import static games.common.MyMath.getRandomNumber;
import static games.common.MyMath.randomProgression;

public class ProgressionGame extends AbstractGame<Integer> {
    
    public int getGameNumber() {
        return 3;
    }

    public String getName() {
        return "Progression";
    }

    public void play() {
        int counter = 0;
        ioManager.printLine("What is the result of he expression?");
        while (counter < sharedMemory.getTries()) {
            int[] progression = randomProgression();
            int indexOfMissingNumber = getRandomNumber(progression.length);
            ioManager.printLine("Question: " + progressionAsString(progression, indexOfMissingNumber));
            Integer answer = askForAnswer();
            Integer rightAnswer = progression[indexOfMissingNumber];

            if (!assertAnswer(rightAnswer, answer)) break;

            counter++;
        }
        if (counter == sharedMemory.getTries()) {
            ioManager.printLine(sharedMemory.sayCongrats());
        }
    }

    private String progressionAsString(int[] progression, int indexOfMissingNumber) {
        String result = "";
        for (int i = 0; i < progression.length; i++) {
            if (i == indexOfMissingNumber) {
                result += ".. ";
            } else {
                result += progression[i] + " ";
            }
        }
        return result;
    }
}
