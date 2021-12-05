package games.impl;

import static games.common.MyMath.gcdByEuclidsAlgorithm;
import static games.common.MyMath.getRandomNumber;

public class GCDGame extends AbstractGame<Integer> {
    
    public int getGameNumber() {
        return 5;
    }
    
    public String getName() {
        return "GCD";
    }

    public void play() {
        int counter = 0;
        ioManager.printLine("What is the greatest common divisor of two integers?");
        while (counter < sharedMemory.getTries()) {
            int number1 = getRandomNumber();
            int number2 = getRandomNumber();

            ioManager.printLine("Question: " + number1 + " and " + number2);
            Integer answer = askForAnswer();
            Integer rightAnswer = gcdByEuclidsAlgorithm(number1, number2);

            if (!assertAnswer(rightAnswer, answer)) break;

            counter++;
        }
        if (counter == sharedMemory.getTries()) {
            ioManager.printLine(sharedMemory.sayCongrats());
        }
    }
}
