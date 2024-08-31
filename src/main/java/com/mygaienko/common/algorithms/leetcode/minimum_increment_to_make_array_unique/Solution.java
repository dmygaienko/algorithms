package com.mygaienko.common.algorithms.leetcode.minimum_increment_to_make_array_unique;

import java.util.Arrays;

class Solution {

    public int minIncrementForUnique(int[] nums) {
        var result = 0;

        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            var prev = nums[i - 1];
            var curr = nums[i];

            if (prev >= curr) {
                nums[i] = prev + 1;
            }

            result += nums[i] - curr;
        }

        return result;
    }

}
