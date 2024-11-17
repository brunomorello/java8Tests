package br.com.bmo.java8tips.interviews;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ClosestNumberToZero {

    public int findClosestNumber(int[] nums) {
        int indexClosestToZero = 0;

        if (nums.length == 0) {
            return indexClosestToZero;
        }

        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i]) <= Math.abs(nums[indexClosestToZero])) {
                indexClosestToZero = nums[i] >= 0 ? i : indexClosestToZero;
            }
        }

        // Stream version - doesn't work for all scenarios test [-1000,-1000] brokes
//        return IntStream.of(nums)
//                .peek(i -> System.out.println("Handling: " + i))
//                .filter(i -> i > 0)
//                .sorted()
//                .limit(1)
//                .peek(System.out::println)
//                .findFirst()
//                .orElse(0);
        return nums[indexClosestToZero];
    }
}
