package br.com.bmo.java8tips.generics;

import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        assertEquals(2, GenericAndBoundedTypes.countGreaterItems(3, intList));

        Double[] doubleList = {1.4, 2.1, 3.9, 4.3, 5.1};
        assertEquals(4, GenericAndBoundedTypes.countGreaterItems(2.0, doubleList));

        String[] strList = {"a", "b", "c", "d", "e", "f", "g"};
        assertEquals(0, GenericAndBoundedTypes.countGreaterItems("g", strList));
    }

    @Test
    void copyLowerAndUpperBounded() {
        List<Double> doubleList = Arrays.asList(1.5, 2.2, 4.12);
        List<Double> destinationList = new ArrayList<>();
        GenericAndBoundedTypes.copy(doubleList, destinationList);

        assertEquals(doubleList, destinationList);
        System.out.println(destinationList);
    }

    @Test
    void copyLowerAndUpperBoundedStr() {
        List<String> stringList = Arrays.asList("abc", "def", "ghi");
        List<String> destinationList = new ArrayList<>();
        GenericAndBoundedTypes.copy(stringList, destinationList);

        assertEquals(stringList, destinationList);
        System.out.println(destinationList);
    }

    @Test
    void testUpperBoundedExample() {
        assertEquals(8, GenericAndBoundedTypes.sumAll(Arrays.asList(2, 2, 3, 1)));
    }

    @Test
    void testLowerBoundedExample() {
        List<? super Number> items = new ArrayList<>();
        items.add(3);
        items.add(231.2);
        items.add(21.232f);
        GenericAndBoundedTypes.showAll(items);
    }
}