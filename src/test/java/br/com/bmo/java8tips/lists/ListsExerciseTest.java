package br.com.bmo.java8tips.lists;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListsExerciseTest {

    @Test
    void reverse() {
        List<Integer> list = Arrays.asList(1,2,3,4);
        ListsExercise.reverse(list);
        assertEquals(Arrays.asList(4,3,2,1), list);
    }

    @Test
    void arrayListAndLinkedListAddFirstComparison() {
        ListsExercise.arrayListAndLinkedListAddFirstComparison();
    }
}