package br.com.bmo.java8tips.interviews;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class NonOverlappingEventsTest {

    @Test
    void example1() {
        int[] x1 = {1,3,2};
        int[] x2 = {4,5,2};
        int[] x3 = {2,4,3};
        int[][] input = new int[3][3];
        input[0] = x1;
        input[1] = x2;
        input[2] = x3;

        int result = NonOverlappingEvents.maxTwoEvents(input);

        assertEquals(4, result);
    }

    @Test
    void example2() {
        int[] x1 = {1,3,2};
        int[] x2 = {4,5,2};
        int[] x3 = {1,5,5};
        int[][] input = new int[3][3];
        input[0] = x1;
        input[1] = x2;
        input[2] = x3;

        int result = NonOverlappingEvents.maxTwoEvents(input);

        assertEquals(5, result);
    }

    @Test
    void example3() {
        int[] x1 = {1,5,3};
        int[] x2 = {1,5,1};
        int[] x3 = {6,6,5};
        int[][] input = new int[3][3];
        input[0] = x1;
        input[1] = x2;
        input[2] = x3;

        int result = NonOverlappingEvents.maxTwoEvents(input);

        assertEquals(8, result);
    }
}