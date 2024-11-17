package br.com.bmo.java8tips.interviews;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClosestNumberToZeroTest {

    private ClosestNumberToZero closestNumberToZero = new ClosestNumberToZero();

    @Test
    void shouldFindOneAsClosestNumberToZero() {
        assertEquals(1, closestNumberToZero.findClosestNumber(new int[] {8,-4,-32,-2,102,29,22,1,4,8}));
    }

    @Test
    void shouldReturnOneWhenArrayHasMinusOneAndOnePositive() {
        assertEquals(1, closestNumberToZero.findClosestNumber(new int[] {2, -1, 1}));
    }

    @Test
    void shouldReturnZeroWhenArrayIsEmpty() {
        assertEquals(0, closestNumberToZero.findClosestNumber(new int[] {}));
    }

    @Test
    @DisplayName("When Array contains 2 values of -1000, it should return one of them")
    void shouldReturnMinusOneThousand() {
        assertEquals(-1000, closestNumberToZero.findClosestNumber(new int[] {-1000, -1000}));
    }

    @Test
    void shouldReturnZeroWhenArrayContainsZero() {
        assertEquals(0, closestNumberToZero.findClosestNumber(new int[] {-2, 1, 0, 0}));
    }
}