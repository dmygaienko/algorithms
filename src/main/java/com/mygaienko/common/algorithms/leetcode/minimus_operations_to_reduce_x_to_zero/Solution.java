package com.mygaienko.common.algorithms.leetcode.minimus_operations_to_reduce_x_to_zero;

import java.util.HashMap;

class Solution {

    // start from both ends dfs and calculate length till reach x
    // return min

    // put to queue (currentStart, currentEnd, operation, left)
    // with priority operation , left
    // read from queue and offer neighbours to queue till find the minimal

    public int minOperations(int[] nums, int x) {
        var sumMap = new HashMap<Integer, Integer>();
        var sum = 0;

        sumMap.put(0, 0);
        for (int i = 0; i < nums.length; i++) {
            var num = nums[i];
            sum += num;
            sumMap.put(sum, i + 1);
        }

        if (x > sum) return -1;

        var endSum = 0;
        var rightOperations = 0;
        var minOperations = Integer.MAX_VALUE;
        while (rightOperations < nums.length && endSum <= x && rightOperations < minOperations) {
            var nextOperations = sumMap.get(x - endSum);
            if (nextOperations != null) {
                minOperations = Math.min(minOperations, nextOperations + rightOperations);
            }

            endSum += nums[nums.length - 1 - rightOperations];
            rightOperations++;
        }

        return minOperations == Integer.MAX_VALUE ? -1 : minOperations;
    }

    /*
    // TWO POINTERS
    public int minOperations(int[] nums, int x) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int n = nums.length;
        int maxi = -1;
        int left = 0;
        int current = 0;

        for (int right = 0; right < n; right++) {
            // sum([left ,..., right]) = total - x
            current += nums[right];
            // if larger, move `left` to left
            while (current > total - x && left <= right) {
                current -= nums[left];
                left += 1;
            }
            // check if equal
            if (current == total - x) {
                maxi = Math.max(maxi, right - left + 1);
            }
        }
        return maxi != -1 ? n - maxi : -1;
    }*/
}
