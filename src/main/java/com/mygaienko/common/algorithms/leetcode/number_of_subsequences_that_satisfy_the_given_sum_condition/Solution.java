package com.mygaienko.common.algorithms.leetcode.number_of_subsequences_that_satisfy_the_given_sum_condition;

import java.util.Arrays;

class Solution {

    int modulo = (int) Math.pow(10, 9) + 7;

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);

        int[] power = new int[nums.length];
        power[0] = 1;
        for (int i = 1; i < nums.length; ++i) {
            power[i] = (power[i - 1] * 2) % modulo;
        }

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            var next = nums[i];
            var targetIndex = search(nums, target - next, i);

            if (targetIndex < 0 || targetIndex >= nums.length) continue;

            int subsequences = power[targetIndex - i];
            count = (count + subsequences) % modulo;
        }

        return count;
    }

    private int search(int[] nums, int target, int index) {
        int left = index;
        int right = nums.length - 1;

        var result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] <= target) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

}
