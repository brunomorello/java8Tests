package br.com.bmo.java8tips.generics;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GenericExamplesTest {

    @Test
    void printKeyValue() {
        GenericExamples<Double> genericExamples = new GenericExamples<>();
        genericExamples.printKeyValue("KeyStr", 12.5);
    }

    @Test
    void showItem() {
        GenericExamples<Integer> genericExamples = new GenericExamples<>();
        genericExamples.showItem(1250);
    }

    @Test
    void showItems() {
        GenericExamples<Object> genericExamples = new GenericExamples<>();

        Integer[] numbers = {1,2,3,123,554};
        genericExamples.showItems(numbers);

        String[] names = {"Jade", "Bruno", "Luna", "Izzy", "Keira"};
        genericExamples.showItems(names);
    }

    @Test
    void checkEquality() {
        GenericExamples<Object> genericExamples = new GenericExamples<>();

        assertTrue(genericExamples.checkEquality(10.5, 10.5));
        assertFalse(genericExamples.checkEquality(10.5, "10.5"));
        assertTrue(genericExamples.checkEquality("10.51", "10.51"));

    }

    @Test
    void greaterItem() {
        GenericExamples<Object> genericExamples = new GenericExamples<>();

        assertEquals(12, genericExamples.greaterItem(Arrays.asList(2, 3, 12, 5, 8, 9 , 11)));
    }
}