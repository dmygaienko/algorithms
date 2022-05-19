package com.mygaienko.common.algorithms.leetcode.maximize_distance_to_closest_person;

class Solution {

    public int maxDistToClosest(int[] seats) {
        int leftClosed = Integer.MIN_VALUE;
        int rightClosed = Integer.MIN_VALUE;

        int last = Integer.MIN_VALUE;
        int maxDistance = Integer.MIN_VALUE;

        for (int i = 0; i < seats.length; i++) {
            int seat = seats[i];
            if (seat == 1) {
                if (leftClosed == Integer.MIN_VALUE) {
                    leftClosed = i;
                }

                last = i;
            } else {
                maxDistance = Math.max(maxDistance, i - last);
            }

            if (i == seats.length - 1) {
                rightClosed = last;
            }
        }

        int closedMax = Math.max(leftClosed, seats.length - rightClosed - 1);
        return Math.max((int) Math.round(maxDistance/2d), closedMax);
    }

}
