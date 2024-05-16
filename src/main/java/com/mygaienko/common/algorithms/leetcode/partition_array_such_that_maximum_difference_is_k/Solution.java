package com.mygaienko.common.algorithms.leetcode.partition_array_such_that_maximum_difference_is_k;

import java.util.Arrays;

class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);

        var count = 1;
        var min = Integer.MAX_VALUE;
        var max = Integer.MIN_VALUE;

        for (var num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);

            if (max - min > k) {
                count++;
                min = num;
                max = num;
            }
        }

        return count++;
    }
}