package com.mygaienko.common.algorithms.leetcode.sort_colors;

/**
 * quick sort
 */
class Solution {

    public void sortColors(int[] nums) {
        sortColors(nums, 0, nums.length);
    }

    private void sortColors(int[] nums, int from, int to) {
        int pivot = from;

        for (int i = from + 1; i < to; i++) {
            int pivotValue = nums[pivot];
            int nextValue = nums[i];

            if (pivotValue > nextValue) { // replace
                nums[i] = pivotValue;
                nums[pivot] = nextValue;
                pivot = i;
            }
        }

        if (to - from > 1) {
            pivot = pivot - 1 >= from ? pivot : pivot + 1;
            sortColors(nums, from, pivot);
            sortColors(nums, pivot, nums.length);
        }
    }

}