package com.mygaienko.common.algorithms.leetcode.missing_element;

class Solution {

    // number of missing elements:

    // k = nums[i] - nums[0] - i
    // nums[i] = k + nums[0] + i
    public int missingElement(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = right - (right - left) / 2;
            var missing = nums[mid] - nums[0] - mid;
            if (missing < k) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return nums[0] + left + k;
    }

}

