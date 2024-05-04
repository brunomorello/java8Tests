package br.com.bmo.java8tips.sortingcollections;

import java.util.Arrays;

public class SortingArrays {
    public static void main(String[] args) {
        //QuickSort - primitive types
        int[] nums = {1,20,5,2,-5,-12,14,0,13,2};
        Arrays.sort(nums);

        System.out.println("Sort ASC ints");
        for(int i : nums)
            System.out.print(i + " ");

        System.out.println("\nSort DESC ints");
        for (int i = nums.length-1; i >=0 ; i--) {
            System.out.print(nums[i] + " ");
        }

        //MergeSort - reference types
        System.out.println("\n==== Sorting Reference Types (Strings) ====");
        String[] names = {"Kevin", "Daniel", "Ana", "Joe", "Jade", "Luna", "Bruno", "Izzy", "Keira"};
        Arrays.sort(names);

        System.out.println("ASC");
        for (String s : names)
            System.out.print(s + " ");

        System.out.println("\nDESC");

        for (int i = names.length-1; i >= 0; i--) {
            System.out.print(names[i] + " ");
        }


    }
}
