package com.mygaienko.common.algorithms.leetcode.two_sum_less_than_k;

import java.util.Arrays;

class SolutionV2 {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);

        var left = 0;
        var right = nums.length - 1;

        var sum = -1;
        while (left < right) {
            var currentSum = nums[left] + nums[right];

            if (currentSum < k) {
                sum = Math.max(sum, currentSum);
                left++;
            } else {
                right--;
            }
        }

        return sum;
    }


}
