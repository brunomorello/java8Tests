package br.com.bmo.java8tips.lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListsExercise {

    public static void reverse(List<Integer> list) {
        for (int i = 0, mid = list.size() / 2, j = list.size() - 1; i < mid; i++, j--) {
            int num1 = list.get(i);
            int num2 = list.get(j);
            list.set(i, num2);
            list.set(j, num1);
        }
    }

    public static void arrayListAndLinkedListAddFirstComparison() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        long currTime = System.currentTimeMillis();

        for (int i = 0; i < 500000; i++) {
            arrayList.add(i);
        }

        System.out.println("Time taken for ArrayList: " + (System.currentTimeMillis() - currTime));

        currTime = System.currentTimeMillis();

        for (int i = 0; i < 500000; i++) {
            linkedList.addFirst(i);
        }

        System.out.println("Time taken for LinkedList: " + (System.currentTimeMillis() - currTime));
    }
}
