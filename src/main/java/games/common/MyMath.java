package games.common;

import java.util.Random;

public class MyMath {

    private static final String[] operations = {"+", "-", "*"};

    public static int getRandomNumber() {
        return new Random().nextInt(100);
    }

    public static int getRandomNumber(int bound) {
        return new Random().nextInt(bound);
    }

    public static String randomArithmeticOperation() {
        return operations[new Random().nextInt(operations.length)];
    }


    public static Integer processArithmeticOperation(int number1, int number2, String op) {
        switch (op) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            default:
                throw new ArithmeticException("Operation not supported");
        }
    }

    public static int[] randomProgression() {
        int[] result = new int[8];
        int step = new Random().nextInt(5);
        result[0] = new Random().nextInt(10);

        for (int i = 1; i < result.length; i++) {
            result[i] = result[i - 1] + step;
        }
        return result;
    }

    public static boolean isPrime(int number) {
        if (number < 1) throw new ArithmeticException("Wrong number");
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static int gcdByEuclidsAlgorithm(int number1, int number2) {
        if (number2 == 0) {
            return number1;
        }
        return gcdByEuclidsAlgorithm(number2, number1 % number2);
    }
}
