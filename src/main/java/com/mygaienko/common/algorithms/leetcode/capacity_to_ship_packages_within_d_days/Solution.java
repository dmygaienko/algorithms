package com.mygaienko.common.algorithms.leetcode.capacity_to_ship_packages_within_d_days;

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        var sum = 0;
        for (var w : weights) {
            sum += w;
        }

        int minCapacity = Integer.MAX_VALUE;

        int left = 1;
        int right = sum;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canFinish(weights, days, mid)) {
                minCapacity = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return minCapacity;
    }

    private boolean canFinish(int[] weights, int days, int capacity) {

        int currentCapacity = 0;
        int currentDays = 1;

        for(int i = 0; i < weights.length; i++) {
            var w = weights[i];
            if (currentCapacity + w <= capacity) {
                currentCapacity += w;
            } else if (currentDays < days){
                currentDays++;
                currentCapacity = 0;
                i--;
            } else {
                return false;
            }
        }

        return true;
    }
}