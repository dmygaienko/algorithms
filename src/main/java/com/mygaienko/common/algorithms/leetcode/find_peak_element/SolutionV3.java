package com.mygaienko.common.algorithms.leetcode.find_peak_element;

/**
 * binary search: third template
 */
class SolutionV3 {

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return 0;

        int left = 0, right = nums.length - 1;
        int peak = Integer.MIN_VALUE;

        while(left + 1 < right){
            int mid = left + (right - left) / 2;

            if(mid + 1 < nums.length && nums[mid] < nums[mid + 1]) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return peak == Integer.MIN_VALUE ? (nums[left] > nums[right] ? left : right) : peak;
    }

}
