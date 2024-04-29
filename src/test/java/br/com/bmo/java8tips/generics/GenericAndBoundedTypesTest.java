package br.com.bmo.java8tips.generics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericAndBoundedTypesTest {

    @Test
    void add() {
        assertEquals(5, GenericAndBoundedTypes.add(2.5, 2.5));
        assertEquals(24.3, GenericAndBoundedTypes.add(12, 12.3));
    }

    @Test
    void countGreaterItems() {
        Integer[] intList = {1,2,3,4,5};
        assertEquals(2, GenericAndBoundedTypes.countGreaterItems(intList, 3));

        Double[] doubleList = {1.4, 2.1, 3.9, 4.3, 5.1};
        assertEquals(4, GenericAndBoundedTypes.countGreaterItems(doubleList, 2.0));

        String[] strList = {"a", "b", "c", "d", "e", "f", "g"};
        assertEquals(0, GenericAndBoundedTypes.countGreaterItems(strList, "g"));
    }
}