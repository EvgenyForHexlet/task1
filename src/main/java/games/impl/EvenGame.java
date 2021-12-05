package games.impl;

import static games.common.MyMath.getRandomNumber;
import static games.common.MyMath.isEven;


public class EvenGame extends AbstractGame<Boolean> {

    public int getGameNumber() {
        return 4;
    }
    
    public String getName() {
        return "Even";
    }
    
    public void play() {
        int counter = 0;
        ioManager.printLine("Answer 'yes' if number even otherwise answer 'no'");
        while (counter < sharedMemory.getTries()) {
            int number = getRandomNumber();
            ioManager.printLine("Question: " + number);
            Boolean answer = askYesOrNo();
            Boolean rightAnswer = isEven(number);

            if (!assertAnswer(rightAnswer, answer)) break;

            counter++;
        }
        if (counter == sharedMemory.getTries()) {
            ioManager.printLine(sharedMemory.sayCongrats());
        }
    }


}
