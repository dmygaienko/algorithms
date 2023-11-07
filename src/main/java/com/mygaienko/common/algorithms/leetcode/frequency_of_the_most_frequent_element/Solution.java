package com.mygaienko.common.algorithms.leetcode.frequency_of_the_most_frequent_element;

import java.util.Arrays;

class Solution {

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        var max = 0;

        var left = 0; var right = 0; long currK = k;
        long sum = 0; var count = 0; var common = 0;
        while (right < nums.length) {
            sum += nums[right];

            while ( (sum + currK) / (count + 1) < nums[right] && left < right) {
                sum -= common;
                currK += common - nums[left];
                left++;
                count--;
            }

            if ((sum + currK) / (count + 1) >= nums[right]) {
                count++;

                var maxSum = sum + currK;
                sum = nums[right] * count;
                currK = maxSum - sum;
                common = nums[right];

                max = Math.max(max, count);
                right++;
            }
        }

        return max;
    }
}
