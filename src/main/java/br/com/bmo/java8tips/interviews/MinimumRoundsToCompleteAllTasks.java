package br.com.bmo.java8tips.interviews;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MinimumRoundsToCompleteAllTasks {
    public int minimumRounds(int[] tasks) {
        int countRounds = 0;
//        You are given a 0-indexed integer array tasks, where tasks[i] represents the difficulty level of a task. In each round, you can complete either 2 or 3 tasks of the same difficulty level.
//        Return the minimum rounds required to complete all the tasks, or -1 if it is not possible to complete all the tasks.

        Map<Integer, Long> temp = Arrays.stream(tasks)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (Map.Entry<Integer, Long> currEntry : temp.entrySet()) {
            if (currEntry.getValue() < 2) {
                countRounds = -1;
                break;
            }

            countRounds += currEntry.getValue() / 3;
            if (currEntry.getValue() % 3 != 0) {
                countRounds++;
            }
        }
        // another solution instead of arrays.stream (faster)
//        Map<Integer, Integer> temp = new HashMap<>();
//
//        for (int i : tasks) {
//            temp.put(i, temp.getOrDefault(i, 0) +1);
//        }
//
//        for (Integer currValue : temp.values()) {
//            if (currValue < 2) {
//                return -1;
//            }
//
//            countRounds += currValue / 3;
//            if (currValue % 3 != 0) {
//                countRounds++;
//            }
//        }

        return countRounds;
    }
}
