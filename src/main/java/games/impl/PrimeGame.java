package games.impl;

import static games.common.MyMath.getRandomNumber;
import static games.common.MyMath.isPrime;

public class PrimeGame extends AbstractGame<Boolean> {
    
    public int getGameNumber() {
        return 6;
    }
    
    public String getName() {
        return "Prime";
    }
    
    public void play() {
        int counter = 0;
        ioManager.printLine("Answer 'yes' if given number is prime. Otherwise answer 'no'");
        while (counter < sharedMemory.getTries()) {
            // to avoid value 1
            int number = getRandomNumber() + 1;
            ioManager.printLine("Question: " + number);
            Boolean answer = askYesOrNo();
            Boolean rightAnswer = isPrime(number);

            if (!assertAnswer(rightAnswer, answer)) break;

            counter++;
        }
        if (counter == sharedMemory.getTries()) {
            ioManager.printLine(sharedMemory.sayCongrats());
        }
    }

}
