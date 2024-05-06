package br.com.bmo.java8tips.threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsSyncList {

    public static void main(String[] args) {
        // Defining the array beforehand solves the concurrence (no need to java resize)
//        List<Integer> nums = new ArrayList<>(1000);
        List<Integer> nums = Collections.synchronizedList(new ArrayList<>());

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                nums.add(i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                nums.add(i);
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(nums);
    }
}
