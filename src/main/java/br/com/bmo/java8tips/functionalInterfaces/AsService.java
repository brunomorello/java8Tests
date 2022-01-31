package br.com.bmo.java8tips.functionalInterfaces;

public class AsService {

    @FunctionalInterface
    // annotation helps using IDE compiler to complain when another abstract method was added
    interface Calculator {
        // should have only one abstract method
        int calc(int x, int y);
    }

    public int calculatorService(int x, int y, Calculator calculator) {
        return calculator.calc(x, y);
    }

    public static void main(String[] args) {
        AsService client = new AsService();

        int sumResult = client.calculatorService(1, 1, (p, q) -> p + q);
        System.out.println("Sum result: " + sumResult);

        int subtractionResult = client.calculatorService(10, 5, (p, q) -> p - q);
        System.out.println("Subtraction Result: " + subtractionResult);

        int multiplicationResult = client.calculatorService(5, 5, (p, q) -> p * q);
        System.out.println("Multiplication Result: " + multiplicationResult);

        int divisionResult = client.calculatorService(10, 5, (p, q) -> p / q);
        System.out.println("Division Result: " + divisionResult);
    }
}
