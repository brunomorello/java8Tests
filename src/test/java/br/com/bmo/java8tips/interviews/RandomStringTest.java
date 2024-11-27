package br.com.bmo.java8tips.interviews;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RandomStringTest {

    private RandomString randomString = new RandomString();

    @Test
    void generateWithSize() {
        String str = randomString.generateWithSize(10);
        assertEquals(10, str.length());
    }

    @Test
    void testRandomness() {
        int iterator = 1000;
        Set<String> valuesGot = new HashSet<>();

        for (int i = 0; i < iterator; i++) {
            assertTrue(valuesGot.add(randomString.generateWithSize(15)));
        }

        assertEquals(iterator, valuesGot.size());
    }
}