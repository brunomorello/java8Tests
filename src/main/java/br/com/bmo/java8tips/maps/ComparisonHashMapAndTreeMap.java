package br.com.bmo.java8tips.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ComparisonHashMapAndTreeMap {
    public static void main(String[] args) {

        final int qntItems = 500000;

        // O(logN)
        Map<Integer, Integer> treeMap = new TreeMap<>();
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < qntItems; i++)
            treeMap.put(i, i);

        for (int i = 0; i < qntItems; i++)
            treeMap.get(i);

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken with TreeMap: " + (endTime - startTime));

        // O(1) - in this case no h(x) hash-functions collisions
        Map<Integer, Integer> hashMap = new HashMap<>();
        startTime = System.currentTimeMillis();

        for (int i = 0; i < qntItems; i++)
            hashMap.put(i, i);

        for (int i = 0; i < qntItems; i++)
            hashMap.get(i);

        endTime = System.currentTimeMillis();
        System.out.println("Time taken with HashMap: " + (endTime - startTime));

    }
}
