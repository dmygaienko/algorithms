package com.mygaienko.common.algorithms.leetcode.minimize_the_maximum_difference_of_pairs;

import java.util.Arrays;

/**
 * Binary Search
 */
class Solution {

    public int minimizeMax(int[] nums, int p) {
        if (p == 0) return 0;
        Arrays.sort(nums);

        var left = 0;
        var right = nums[nums.length - 1];

        var minMax = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isEnoughPairs(nums, p, mid)) {
                right = mid - 1;
                minMax = mid;
            } else {
                left = mid + 1;
            }
        }

        return minMax;
    }

    private boolean isEnoughPairs(int[] nums, int p, int midDiff) {
        var pairs = 0;
        for (int i = 1; i < nums.length; i++) {
            var diff = nums[i] - nums[i - 1];
            if (midDiff >= diff) {
                i++;
                pairs++;
                if (pairs == p) return true;
            }
        }
        return false;
    }

}
