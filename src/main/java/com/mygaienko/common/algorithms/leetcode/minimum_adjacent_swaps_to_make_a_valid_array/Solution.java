package com.mygaienko.common.algorithms.leetcode.minimum_adjacent_swaps_to_make_a_valid_array;

class Solution {
    public int minimumSwaps(int[] nums) {
        int minIndex = -1;
        int maxIndex = -1;
        for (int i = 0; i < nums.length; i++) {

            if (minIndex == -1 || nums[i] < nums[minIndex]) {
                minIndex = i;
            }

            if (maxIndex == -1 || nums[i] >= nums[maxIndex]) {
                maxIndex = i;
            }
        }

        int meetSwaps = minIndex > maxIndex ? 1 : 0;
        return minIndex + (nums.length - 1 - maxIndex) - meetSwaps;
    }
}
