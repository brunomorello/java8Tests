package br.com.bmo.java8tips.interviews;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckOpenClosedParenthesisTest {

    private CheckOpenClosedParenthesis underTest = new CheckOpenClosedParenthesis();

    @Test
    void shouldBeTrue() {
        assertTrue(underTest.isValidV2("()"));
    }

    @Test
    void shouldBeFalse() {
        assertFalse(underTest.isValidV2("()(("));
    }

    @Test
    void shouldBeTrue1() {
        assertTrue(underTest.isValidV2(")(())(()"));
    }

    @Test
    void shouldBeTrue2() {
        assertTrue(underTest.isValidV2("()(())"));
    }

    @Test
    void shouldBeFalse1() {
        assertFalse(underTest.isValidV2(")(()()("));
    }

    @Test
    void shouldBeFalse2() {
        assertFalse(underTest.isValidV2("(()()()"));
    }

}