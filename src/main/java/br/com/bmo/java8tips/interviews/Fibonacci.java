package br.com.bmo.java8tips.interviews;

public class Fibonacci {

    public static int calcFibonacci(int length) {
        if (length <= 1) {
            return length;
        }

        return calcFibonacci(length -1) + calcFibonacci(length - 2);
    }
}
