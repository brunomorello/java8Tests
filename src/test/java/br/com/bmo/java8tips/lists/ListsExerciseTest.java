package br.com.bmo.java8tips.lists;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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

    @Test
    void testArrayAndLinkedList() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);

        System.out.println(linkedList.peek());

        System.out.println(arrayList);
        System.out.println(linkedList);
    }
}