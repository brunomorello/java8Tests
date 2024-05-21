package br.com.bmo.java8tips.interviews;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QntStringAsSubstringInWordTest {

    @Test
    void example1() {
        int total = QntStringAsSubstringInWord.numOfStrings(new String[]{"a","abc","bc","d"}, "abc");
        assertEquals(3, total);
    }

    @Test
    void example2() {
        int total = QntStringAsSubstringInWord.numOfStrings(new String[]{"a","b","c"}, "aaaaabbbbb");
        assertEquals(2, total);
    }

    @Test
    void example3() {
        int total = QntStringAsSubstringInWord.numOfStrings(new String[]{"a","a","a"}, "ab");
        assertEquals(3, total);
    }

}