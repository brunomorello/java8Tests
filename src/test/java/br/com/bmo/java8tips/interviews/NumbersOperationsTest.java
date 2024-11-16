package br.com.bmo.java8tips.interviews;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumbersOperationsTest {

    @Test
    void test_real_prime_numbers() {
        List<Integer> numbers = Arrays.asList(2, 3, 5, 7, 11, 13);
        numbers.forEach(n -> assertTrue(NumbersOperations.isPrime(n)));
    }

    @Test
    void test_non_prime_numbers() {
        List<Integer> numbers = Arrays.asList(1, 4, 6, 9, 10, 12);
        numbers.forEach(n -> assertFalse(NumbersOperations.isPrime(n)));
    }
}