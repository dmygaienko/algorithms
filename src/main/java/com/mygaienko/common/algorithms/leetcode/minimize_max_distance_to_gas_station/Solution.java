package com.mygaienko.common.algorithms.leetcode.minimize_max_distance_to_gas_station;

class Solution {

    public double minmaxGasDist(int[] stations, int k) {
        double min = Integer.MAX_VALUE;
        double max = Integer.MIN_VALUE;

        for (int i = 1; i < stations.length; i++) {
            var diff = stations[i] - stations[i - 1];
            min = Math.min(min, (double) diff / k);
            max = Math.max(max, diff);
        }

        double left = min;
        double right = max;
        double minMax = Integer.MAX_VALUE;
        while (right - left > 1e-6) {
            var mid = (left + right) / 2;

            if (isPossible(stations, k, mid)) {
                minMax = mid;
                right = mid;
            } else {
                left = mid;
            }
        }

        return minMax;
    }

    private boolean isPossible(int[] stations, int k, double mid) {
        double prev = stations[0];
        int i = 1;
        while (i < stations.length) {
            double curr = stations[i];
            var diff = curr - prev;
            if (diff > mid) {
                if (k == 0) {
                    return false;
                } else {
                    prev += mid;
                    k--;
                    continue;
                }
            }
            i++;
            prev = curr;
        }
        return true;
    }

}
