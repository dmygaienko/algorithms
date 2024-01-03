package com.mygaienko.common.algorithms.leetcode.three_sum_closest;

import java.util.Arrays;

class Solution {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        var closest = Integer.MAX_VALUE;
        var closestDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            var localClosest = threeSumClosest(nums, i, target);
            var localDiff = Math.abs(localClosest - target);
            if (localDiff < closestDiff) {
                closest = localClosest;
                closestDiff = localDiff;
            }
        }
        return closest;
    }

    private int threeSumClosest(int[] nums, int i, int target) {
        var first = nums[i];

        var low = i + 1;
        var high = nums.length - 1;

        var closest = Integer.MAX_VALUE;
        var closestDiff = Integer.MAX_VALUE;
        while (low < high) {
            int sum = first + nums[low] + nums[high];

            if (sum == target) {
                return sum;
            } else if (sum < target) {
                low++;
            } else {
                high--;
            }

            int localDiff = Math.abs(target - sum);
            if (localDiff < closestDiff) {
                closest = sum;
                closestDiff = localDiff;
            }
        }

        return closest;
    }

}