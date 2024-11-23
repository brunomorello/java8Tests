package br.com.bmo.java8tips.interviews;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WaysToBuyPensAndPencilTest {

    private WaysToBuyPensAndPencil waysToBuyPensAndPencil = new WaysToBuyPensAndPencil();

    @Test
    void whenTotalAmountIs20AndPenCosts10AndPencil5_Then9WaysOfBuyIt() {
        assertEquals(9, waysToBuyPensAndPencil.findWays(20, 10, 5));
    }

    @Test
    void whenTotalAmountIs5AndPenCosts10AndPencil10_Then1WaysOfBuyIt() {
        assertEquals(1, waysToBuyPensAndPencil.findWays(5, 10, 10));
    }

    @Test
    void whenTotalAmountIs5AndPenCosts3AndPencil2_Then5WaysOfBuyIt() {
        assertEquals(5, waysToBuyPensAndPencil.findWays(5, 3, 2));
    }

    @Test
    void whenTotalAmountIs100AndPenCosts1AndPencil1_Then5151WaysOfBuyIt() {
        assertEquals(5151, waysToBuyPensAndPencil.findWays(100, 1, 1));
    }
}