package br.com.bmo.java8tips.maps;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapsExamples {
    public static void main(String[] args) {
        // O(1) < O(logN)
        Map<Integer, String> map = new TreeMap<>();
        map.put(10, "ten");
        map.put(3, "three");
        map.put(5, "five");
        map.put(1, "one");
        map.put(8, "eight");

        for (Map.Entry<Integer, String> entryKey : map.entrySet()) {
            System.out.println(entryKey.getKey() + "-" + entryKey.getValue());
        }

        System.out.println("Sorting Tree Descending");

        TreeMap<Integer, String> treeMap = new TreeMap<>(Comparator.reverseOrder());

        treeMap.put(10, "ten");
        treeMap.put(3, "three");
        treeMap.put(5, "five");
        treeMap.put(1, "one");
        treeMap.put(8, "eight");

        System.out.println("Smallest Value: " + treeMap.lastKey());
        System.out.println("Largest Key: " + treeMap.firstKey());

        for (Map.Entry<Integer, String> entryKey : treeMap.entrySet()) {
            System.out.println(entryKey.getKey() + "-" + entryKey.getValue());
        }
    }
}
