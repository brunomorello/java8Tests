package br.com.bmo.java8tips.sortingcollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingCollections {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(5);
        list.add(19);
        list.add(7);

        Collections.sort(list);

        System.out.println("ASC");
        System.out.println(list);

        Collections.sort(list, Collections.reverseOrder());

        System.out.println("\nDESC");
        System.out.println(list);
    }
}
