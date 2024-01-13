package com.mygaienko.common.algorithms.leetcode.campus_bikes_ii;

import java.util.Arrays;

/**
 * bottom-up dp
 */
class Solution {

    public int assignBikes(int[][] workers, int[][] bikes) {
        var dp = new int[1024];
        Arrays.fill(dp, Integer.MAX_VALUE);

        //init dp: assign all bikes to first worker
        for (int bikeIndex = 0; bikeIndex < bikes.length; bikeIndex++) {
            var mask = 1 << bikeIndex;
            dp[mask] = getDistance(bikes[bikeIndex], workers[0]);
        }

        var minDistance = Integer.MAX_VALUE;
        for (int mask = 0; mask < dp.length; mask++) {
            var distance = dp[mask];
            if (distance == Integer.MAX_VALUE) continue;

            var nextWorker = getCount(mask);

            if (nextWorker >= bikes.length || nextWorker >= workers.length) {
                minDistance = Math.min(minDistance, distance);
                continue;
            }

            for (int bikeIndex = 0; bikeIndex < bikes.length; bikeIndex++) {
                var assigned = (mask >> bikeIndex) & 1;
                if (assigned == 0) {
                    var nextDistance = getDistance(bikes[bikeIndex], workers[nextWorker]);
                    var nextMask = mask | (1 << bikeIndex);
                    dp[nextMask] = Math.min(dp[nextMask], distance + nextDistance);
                }
            }
        }

        return minDistance;
    }

    private int getCount(int mask) {
        var count = 0;
        while (mask != 0) {
            mask = mask & (mask - 1);
            count++;
        }
        return count;
    }

    private static int getDistance(int[] bike, int[] worker) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }

}