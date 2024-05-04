package br.com.bmo.java8tips.set;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SetsExample {
    public static void main(String[] args) {
        // initial capacity 16
        // h(x) transforms input into an array index
        // O(1) but in case of collision, then O(logN) - in the past it was O(N)
        Set<String> set1 = new HashSet<>();

        set1.add("Adam");
        set1.add("Mary");
        set1.add("Katy");
        set1.add("Ana");

        for (String s : set1)
            System.out.println(s);

        System.out.println("=========");

        Set<String> set2 = new HashSet<>();

        set2.add("Adam");
        set2.add("Ana");

        set1.retainAll(set2);

        System.out.println("removes values with no intersection with set2");

        for (String s : set1)
            System.out.println(s);

        System.out.println("========== LinkedHashSet ==========");

        // LinkedHashSet preserves the insertion order
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Adam");
        linkedHashSet.add("Mary");
        linkedHashSet.add("Katy");
        linkedHashSet.add("Ana");

        for(String s:linkedHashSet)
            System.out.println(s);

        System.out.println("========== TreeSet ==========");

        SortedSet<Integer> set = new TreeSet<>();
        set.add(12);
        set.add(1);
        set.add(9);
        set.add(5);
        set.add(120);
        set.add(87);
        set.add(55);

        Set<Integer> subSet = set.subSet(1, 10);

        System.out.println("subset:");
        for(Integer i : subSet)
            System.out.println(i);

        System.out.println("tailSet:");
        Set<Integer> treeSet2 = set.tailSet(100);

        for(Integer i : treeSet2)
            System.out.println(i);

        System.out.println("headSet:");
        Set<Integer> treeSet3 = set.headSet(20);

        System.out.println("firstItem: " + set.first());
        for(Integer i : treeSet3)
            System.out.println(i);


        System.out.println("========== TreeSet with Comparator ==========");

        // O(logN)
        SortedSet<Integer> treeSetComparator = new TreeSet<>(Comparator.reverseOrder());

        treeSetComparator.add(12);
        treeSetComparator.add(1);
        treeSetComparator.add(9);
        treeSetComparator.add(5);
        treeSetComparator.add(120);
        treeSetComparator.add(87);
        treeSetComparator.add(55);

        for(Integer i : treeSetComparator)
            System.out.println(i);
    }
}
