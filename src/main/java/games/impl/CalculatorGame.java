package games.impl;

import static games.common.MyMath.getRandomNumber;
import static games.common.MyMath.processArithmeticOperation;
import static games.common.MyMath.randomArithmeticOperation;


public class CalculatorGame extends AbstractGame<Integer> {
    
    public int getGameNumber() {
        return 2;
    }
    
    public String getName() {
        return "Calc";
    }

    public void play() {
        int counter = 0;
        ioManager.printLine("What is the result of he expression?");
        while (counter < sharedMemory.getTries()) {
            int number1 = getRandomNumber();
            int number2 = getRandomNumber();
            String op = randomArithmeticOperation();
            ioManager.printLine("Question: " + number1 + " " + op + " " + number2);
            Integer answer = askForAnswer();
            Integer rightAnswer = processArithmeticOperation(number1, number2, op);

            if (!assertAnswer(rightAnswer, answer)) break;

            counter++;
        }
        if (counter == sharedMemory.getTries()) {
            ioManager.printLine(sharedMemory.sayCongrats());
        }
    }


}
