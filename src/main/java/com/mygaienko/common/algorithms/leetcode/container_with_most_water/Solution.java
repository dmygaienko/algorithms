package com.mygaienko.common.algorithms.leetcode.container_with_most_water;

/**
 * Two Pointers, Greedy
 */
class Solution {

    public int maxArea(int[] height) {
        int area = 0;

        int leftIndex = 0;
        int rightIndex = height.length - 1;

        while (leftIndex < rightIndex) {

            int left = height[leftIndex];
            int right = height[rightIndex];

            int currentArea = Math.min(left, right) * (rightIndex - leftIndex);
            area = Math.max(area, currentArea);

            if (left < right) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }

        return area;
    }

}
