package br.com.bmo.java8tips.interviews;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PalindromeTest {

    @Test
    void isPalindrome() {
        assertFalse(Palindrome.isPalindrome("hello"));
        assertTrue(Palindrome.isPalindrome("rotator"));

        "test".trim();
    }
}