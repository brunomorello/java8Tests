package br.com.bmo.java8tips.interviews;

import java.util.Arrays;
import java.util.Comparator;

public class MinNumOfOperationsToMakeArrayContinuous {
    public static int minOperations(int[] nums) {
        Arrays.sort(nums);
//        int uniqueLen = 1;
//        for (int i = 1; i < nums.length; ++i) {
//            if (nums[i] != nums[i - 1]) {
//                nums[uniqueLen++] = nums[i];
//            }
//        }
//
//        int ans = nums.length;
//        for (int i = 0, j = 0; i < uniqueLen; ++i) {
//            while (j < uniqueLen && nums[j] - nums[i] <= nums.length - 1) {
//                ++j;
//            }
//            ans = Math.min(ans, nums.length - (j - i));
//        }
//
//        return ans;
        int operations = 0;

        Arrays.sort(nums);
        int firstInt = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (firstInt == nums[i])
                firstInt = nums[i];
            if ((firstInt + 1) != nums[i] && (i-1 + operations) <= nums.length) {
                operations++;
                firstInt = nums[i];
            } else {
                firstInt++;
            }
        }

        return operations;
    }
}
