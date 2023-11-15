package com.mygaienko.common.algorithms.leetcode.minimum_speed_to_arrive_on_time;

class Solution {

    public int minSpeedOnTime(int[] dist, double hour) {
        int left = 1;
        int right = (int) Math.pow(10, 7);

        var minSpeed = -1;
        while (left <= right) {
            var mid = left + (right - left) / 2;

            if (isOnTime(dist, hour, mid)) {
                minSpeed = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return minSpeed;
    }

    private boolean isOnTime(int[] dist, double hour, long speed) {

        double currTime = 0;
        for (int i = 0; i < dist.length; i++) {
            if (currTime > hour) return false;
            double time = (double) dist[i] / (double) speed;
            currTime += (i != dist.length - 1 ? Math.ceil(time) : time);
        }

        return currTime <= hour;
    }

}
