package br.com.bmo.java8tips.interviews;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinNumOfOperationsToMakeArrayContinuousTest {

    @Test
    void example1() {
        int operations = MinNumOfOperationsToMakeArrayContinuous.minOperations(new int[]{4,2,5,3});
        assertEquals(0, operations);
    }

    @Test
    void example2() {
        int operations = MinNumOfOperationsToMakeArrayContinuous.minOperations(new int[]{1,2,3,5,6});
        assertEquals(1, operations);
    }

    @Test
    void example3() {
        int operations = MinNumOfOperationsToMakeArrayContinuous.minOperations(new int[]{1,10,100,1000});
        assertEquals(3, operations);
    }

    @Test
    void example4() {
        int operations = MinNumOfOperationsToMakeArrayContinuous.minOperations(new int[]{41,33,29,33,35,26,47,24,18,28});
        assertEquals(5, operations);
    }

    @Test
    void example5() {
        int operations = MinNumOfOperationsToMakeArrayContinuous.minOperations(new int[]{8,5,9,9,8,4});
        assertEquals(2, operations);
    }



}