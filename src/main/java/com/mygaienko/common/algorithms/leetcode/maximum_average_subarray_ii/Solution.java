package com.mygaienko.common.algorithms.leetcode.maximum_average_subarray_ii;

class Solution {

    public double findMaxAverage(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            var val = nums[i];
            min = Math.min(min, val);
            max = Math.max(max, val);
        }

        double left = min;
        double right = max;
        while (right - left > 1e-5) {
            double mid = (right + left) / 2;

            if (existAverage(nums, mid, k)) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return left;
    }

    /**
     * sliding window with maximum and minimum sum
     */
    boolean existAverage(int[] nums, double val, int k) {
        var sums = new double[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i] - val;
        }

        double minSum = 0;
        double maxSum = 0;
        for (int i = k; i < sums.length; i++) {
            maxSum = Math.max(maxSum, sums[i] - minSum);

            if (maxSum > 0) return true;

            minSum = Math.min(minSum, sums[i - k + 1]);
        }

        return false;
    }
}
