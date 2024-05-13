package com.mygaienko.common.algorithms.leetcode.find_triangular_sum_of_an_array;

class Solution {
    public int triangularSum(int[] nums) {
        var length = nums.length;

        while (length > 1) {
            for (int i = 0; i + 1 < length; i++) {
                var left = nums[i];
                var right = nums[i + 1];
                nums[i] = (left + right) % 10;
            }

            length--;
        }

        return nums[0];
    }
}