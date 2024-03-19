package br.com.bmo.java8tips.interviews;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FibonacciTest {

    @Test
    void when_fibonacci_with_10length() {
        List<Integer> expectedResult = Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34);

        for (int i = 0; i < expectedResult.size(); i++) {
            System.out.println("Fibonacci sequence: " + Fibonacci.calcFibonacci(i));
            assertEquals(expectedResult.get(i), Fibonacci.calcFibonacci(i));
        }
    }

}