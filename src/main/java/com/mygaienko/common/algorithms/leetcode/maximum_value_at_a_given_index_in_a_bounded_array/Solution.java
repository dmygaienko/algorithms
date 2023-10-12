package com.mygaienko.common.algorithms.leetcode.maximum_value_at_a_given_index_in_a_bounded_array;

class Solution {

    // nums[index] == target
    // nums[index] to target, nums[index-i] to target-i, and nums[index+i] to target-i
    // 1 + 2 + ... + n = n * (n+1) / 2
    // Binary search for the target. If it is possible, then move the lower bound up. Otherwise, move the upper bound down.
    //
    public int maxValue(int n, int index, int maxSum) {
        int maxValue = 0;

        var left = 0;
        var right = maxSum;

        var deltaBefore = index;
        var deltaAfter = n - index - 1;

        while (left <= right) {
            var mid = left + (right - left) / 2;

            var nextAfterMid = mid - 1 > 0 ? mid - 1 : 1;

            var leftSum = Math.max(deltaBefore, calcSum(Math.max(0, mid - deltaBefore), nextAfterMid));
            var rightSum = Math.max(deltaAfter, calcSum(Math.max(0, mid - deltaAfter), nextAfterMid));
            int currentSum = leftSum + mid + rightSum;

            if (currentSum <= maxSum) {
                maxValue = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return maxValue;

    }

    private int calcSum(int from, int to) {
        return sum(to) - sum(from);
    }

    private int sum(int n) {
        return n * (n + 1) / 2;
    }

}
