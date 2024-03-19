package br.com.bmo.java8tips.interviews;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomTests {

    @Test
    void remove_spaces() {
        String expectedString = "Hi,helloworld!";
        StringBuilder result = new StringBuilder();

        char[] charArray = "Hi, hello world ! ".toCharArray();

        for (char c : charArray) {
            if (!Character.isWhitespace(c)) {
                result.append(c);
            }
        }

        assertEquals(expectedString, result.toString());
    }

    @Test
    void sort_array() {
        int [] arr = {3, 2, 10, -5, 0, -2, 5};
        Arrays.sort(arr);
        assertEquals("[-5, -2, 0, 2, 3, 5, 10]", Arrays.toString(arr));
    }
}
