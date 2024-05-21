package br.com.bmo.java8tips.interviews;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PairPossibleNumbersTest {

    @Test
    void testGeneratePairs() {
        List<List<Integer>> pairs = PairPossibleNumbers.generatePairs();
        List<List<Integer>> result = Arrays.asList(
                Arrays.asList(1, 4),
                Arrays.asList(1, 5),
                Arrays.asList(2, 4),
                Arrays.asList(2, 5),
                Arrays.asList(3, 4),
                Arrays.asList(3, 5)
        );
        assertEquals(result, pairs);
    }
}