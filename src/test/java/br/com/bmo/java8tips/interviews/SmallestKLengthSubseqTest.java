package br.com.bmo.java8tips.interviews;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmallestKLengthSubseqTest {

    @Test
    void example1() {
        String result = SmallestKLengthSubseq.smallestSubsequence("leet", 3, 'e', 1);
        assertEquals("eet", result);
    }

    @Test
    void example2() {
        String result = SmallestKLengthSubseq.smallestSubsequence("leetcode", 4, 'e', 2);
        assertEquals("ecde", result);
    }

    @Test
    void example3() {
        String result = SmallestKLengthSubseq.smallestSubsequence("bb", 2, 'b', 2);
        assertEquals("bb", result);
    }
}