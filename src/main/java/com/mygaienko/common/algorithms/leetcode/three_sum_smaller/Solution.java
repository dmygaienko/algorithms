package com.mygaienko.common.algorithms.leetcode.three_sum_smaller;

import java.util.Arrays;

class Solution {

    // sort nums
    // use two pointers from both sides
    // each step calculare current sum of left plus right
    // and try to find all numbers which less than target - sum
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);

        var count = 0;
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            count += findLessThan(nums, left, right, target);

            var leftCount = findLessThan(nums, left + 1, right, target);
            count += leftCount;

            var rightCount = findLessThan(nums, left, right - 1, target);
            count += rightCount;

            if (leftCount == 0 || rightCount == 0) {
                right--;
                continue;
            }

            left++;
        }

        return count;
    }

    private int findLessThan(int[] nums, int left, int right, int globalTarget) {
        if (left < 0 || left >= nums.length || right < 0 || right >= nums.length) return 0;

        var first = nums[left];
        var third = nums[right];
        var target = globalTarget - (first + third);
        var initLeft = left + 1;
        var to = initLeft - 1;
        left++;
        right--;

        while (left <= right) {
            var mid = left + (right - left) / 2;
            var val = nums[mid];
            if (val < target) {
                left = mid + 1;
                to = mid;
            } else {
                right = mid - 1;
            }
        }

        return Math.max(0, to - initLeft + 1);
    }

}