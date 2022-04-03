package com.mygaienko.common.algorithms.leetcode.find_minimum_in_rotated_sorted_array;

class Solution {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        int min = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            int midValue = nums[mid];
            int leftValue = nums[left];
            int rightValue = nums[right];

            min = Math.min(midValue, min);

            if (leftValue < midValue && leftValue < rightValue || midValue < leftValue) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return min;
    }

}
