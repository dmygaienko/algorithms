package com.mygaienko.common.algorithms.leetcode.wiggle_sort;

class Solution {

    // 1 2 3 4 5 6 7
    // 1 3 2 5 4 7 6
    public void wiggleSort(int[] nums) {
        for (int i = 0; i + 1 < nums.length; i++) {
            var curr = nums[i];
            var next = nums[i + 1];
            if (i % 2 == 0 && curr > next) {
                swap(nums, i, i + 1);
            } else if (i % 2 == 1 && curr < next) {
                swap(nums, i, i + 1);
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        var temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}
