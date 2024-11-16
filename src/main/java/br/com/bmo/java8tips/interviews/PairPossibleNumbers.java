package br.com.bmo.java8tips.interviews;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PairPossibleNumbers {
    public static List<List<Integer>> generatePairs() {

        List<Integer> nums1 = Arrays.asList(1, 2, 3);
        List<Integer> nums2 = Arrays.asList(4, 5);

        List<List<Integer>> pairs = nums1.stream()
                .flatMap(n -> nums2.stream()
                        .map(integer -> Arrays.asList(n, integer))
                )
                .collect(Collectors.toList());

        return pairs;
    }
}
