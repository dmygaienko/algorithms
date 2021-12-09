package com.mygaienko.common.algorithms.leetcode.split_array_largest_sum;

/**
 *  410. Split Array Largest Sum https://leetcode.com/problems/split-array-largest-sum/
 */
class Solution {

    public int splitArray(int[] nums, int m) {

        int maxValue = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            maxValue = Math.max(maxValue, nums[i]);
            sum += nums[i];
        }

        if (m == 1) return sum;

        int left = maxValue;
        int right = sum;

        while (left <= right) {
            int posValue = left + (right-left)/2;
            boolean canSplit = canSplit(nums, m, posValue);

            if (canSplit) {
                right = posValue - 1;
            } else {
                left = posValue + 1;
            }
        }

        return left;
    }

    private boolean canSplit(int[] nums, int m, int posValue) {
        int sum = 0;
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            int nextValue = nums[i];
            int nextSum = sum + nextValue;
            if (nextSum <= posValue) {
                sum = nextSum;
            } else {
                ++count;
                sum = nextValue;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }

}
