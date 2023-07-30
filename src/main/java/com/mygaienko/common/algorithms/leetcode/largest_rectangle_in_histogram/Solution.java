package com.mygaienko.common.algorithms.leetcode.largest_rectangle_in_histogram;

import java.util.ArrayDeque;

/**
 * Increasing monotonic stack
 */
class Solution {

    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;

        ArrayDeque<Integer> monoStack = new ArrayDeque<>();

        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            maxArea = Math.max(maxArea, height);

            while (!monoStack.isEmpty() && heights[monoStack.peek()] > height) {
                int largerIndex = monoStack.pop();

                if (!monoStack.isEmpty()) {
                    int prevLargerIndex = monoStack.peek();
                    int prevLargerHeight = heights[prevLargerIndex];
                    int area = (largerIndex - prevLargerIndex + 1) * prevLargerHeight;
                    maxArea = Math.max(maxArea, area);
                }
            }

            monoStack.push(i);
        }

        Integer maxIndex = null;
        Integer maxValue = null;
        while (!monoStack.isEmpty()) {
            int index = monoStack.pop();
            int height = heights[index];

            if (maxIndex == null) {
                maxIndex = index;
                maxValue = height;
            } else {
                int area = (maxIndex - index + 1) * height;
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }

}