package br.com.bmo.java8tips.interviews;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateDigitSumOfStringTest {

    private CalculateDigitSumOfString underTest = new CalculateDigitSumOfString();

    @Test
    void when_inputString_is_11111222223_and_k_equals_3_then_result_is_135() {
        assertEquals("135", underTest.digitSum("11111222223", 3));
    }

    @Test
    void when_inputString_is_00000000_and_k_equals_3_then_result_is_000() {
        assertEquals("000", underTest.digitSum("00000000", 3));
    }

    @Test
    void when_inputString_is_1234_and_k_equals_2_then_result_is_37() {
        assertEquals("37", underTest.digitSum("1234", 2));
    }

    @Test
    void when_inputString_is_01234567890_and_k_equals_2_then_result_is_27() {
        assertEquals("27", underTest.digitSum("01234567890", 2));
    }
}