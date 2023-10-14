package com.mygaienko.common.algorithms.leetcode.koko_eating_bananas;

class Solution {

    public int minEatingSpeed(int[] piles, int h) {
        var max = Integer.MIN_VALUE;
        for (var pile : piles) {
            max = Math.max(max, pile);
        }

        int minSpeed = Integer.MAX_VALUE;
        int left = 1;
        int right = Math.max(max, (max/h + 1) * piles.length);

        while (left <= right) {
            var mid = left + ( right - left ) / 2;

            if (canFinish(piles, h, mid)) {
                minSpeed = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return minSpeed;
    }

    private boolean canFinish(int[] piles, int h, int speed) {
        int currentHours = 0;
        for (int pile : piles) {
            int deltaHours = pile / speed;
            int left = pile % speed;
            if (left != 0) {
                deltaHours++;
            }
            currentHours += deltaHours;

            if (currentHours > h) {
                return false;
            }
        }

        return true;

    }

}
