package com.mygaienko.common.algorithms.leetcode.find_first_and_last_position_of_element_in_sorted_array;

/**
 * binary search
 */
class Solution {

    private int[] NOT_FOUND = new int[] {-1, -1};

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return NOT_FOUND;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int value = nums[mid];

            if (value == target) {
                return findRange(nums, mid, target);
            } else if (value < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return NOT_FOUND;
    }

    private int[] findRange(int[] nums, int index, int target) {
        int i = index, j = index;

        while (i > 0 && nums[i-1] == target) {
            i--;
        }

        while (j + 1 < nums.length && nums[j+1] == target) {
            j++;
        }

        return new int[] {i, j};
    }

}
