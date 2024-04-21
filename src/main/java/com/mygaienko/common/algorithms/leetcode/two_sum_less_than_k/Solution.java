package com.mygaienko.common.algorithms.leetcode.two_sum_less_than_k;

import java.util.Arrays;

class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);

        int sum = -1;
        for (int i = 0; i < nums.length; i++) {
            var val = nums[i];
            var term = find(nums, i + 1, k - val);
            if (term != Integer.MIN_VALUE) {
                sum = Math.max(sum, val + term);
            }
        }
        return sum;
    }

    private int find(int[] nums, int i, int target) {
        var left = i;
        var right = nums.length - 1;
        var result = Integer.MIN_VALUE;

        while (left <= right) {
            var mid = left + (right - left) / 2;

            var val = nums[mid];
            if (val < target) {
                if (result < val) {
                    result = val;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}
