package com.mygaienko.common.algorithms.leetcode.campus_bikes_ii;

import java.util.Arrays;

/**
 * top-down dp
 */
class SolutionV2 {

    int[][] workers;
    int[][] bikes;

    public int assignBikes(int[][] workers, int[][] bikes) {
        this.workers = workers;
        this.bikes = bikes;
        int[] memo = new int[(int) Math.pow(2, 10)];
        Arrays.fill(memo, -1);
        return dp(0, 0, memo);
    }

    private int dp(int workerIndex, int mask, int[] memo) {
        if (workerIndex >= workers.length) return 0;

        if (memo[mask] != -1) return memo[mask];

        var worker = workers[workerIndex];
        var minDistance = Integer.MAX_VALUE;
        for (int bikeIndex = 0; bikeIndex < bikes.length; bikeIndex++) {
            var assigned = (mask >> bikeIndex) & 1;
            if (assigned == 0) {
                var bike = bikes[bikeIndex];
                var distance = getDistance(bike, worker);
                var nextMask = mask | (1 << bikeIndex);
                minDistance = Math.min(minDistance, distance + dp(workerIndex + 1, nextMask, memo));
            }
        }

        memo[mask] = minDistance;

        return minDistance;
    }

    private static int getDistance(int[] bike, int[] worker) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }

}