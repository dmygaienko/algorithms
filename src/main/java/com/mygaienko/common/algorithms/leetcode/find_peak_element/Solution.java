package com.mygaienko.common.algorithms.leetcode.find_peak_element;

/**
 * binary search: second template
 */
class Solution {

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return 0;

        int left = 0, right = nums.length;
        int peak = Integer.MIN_VALUE;

        while(left < right){
            int mid = left + (right - left) / 2;

            if (mid + 1 < nums.length && nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
                peak = mid;
            }
        }

        return peak;
    }

}
