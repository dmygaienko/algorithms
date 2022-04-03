package com.mygaienko.common.algorithms.leetcode.search_in_rotated_sorted_array;

/**
 * binary search
 */
class Solution {

    public static final int NOT_FOUND = -1;

    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    public int search(int[] nums, int from, int to, int target) {
        int result = NOT_FOUND;

        if (from <= to) {
            int mid = from + (to - from) / 2;
            int number = nums[mid];

            if (number == target) {
                return mid;
            } else {
                result = search(nums, mid + 1, to, target);
                if (result == NOT_FOUND) {
                    result = search(nums, from, mid - 1, target);
                }
            }
        }

        return result;
    }

}
