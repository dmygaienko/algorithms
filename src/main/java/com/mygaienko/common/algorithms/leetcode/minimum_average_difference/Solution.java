package com.mygaienko.common.algorithms.leetcode.minimum_average_difference;

class Solution {
    public int minimumAverageDifference(int[] nums) {
        var suffixSum = new long[nums.length + 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + nums[i];
        }

        var minAvg = Long.MAX_VALUE;
        var minAvgIndex = 0;
        var sum = 0L;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            var firstAvg = sum / (i + 1);
            var lastAvg = i + 1 < nums.length ? suffixSum[i + 1] / (nums.length - i - 1) : 0;
            var avg = Math.abs(firstAvg - lastAvg);
            if (minAvg > avg) {
                minAvg = avg;
                minAvgIndex = i;
            }
        }

        return minAvgIndex;
    }
}
