package com.mygaienko.common.algorithms.leetcode.trapping_rain_water;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        int result = 0;
        Deque<Integer> monoStack = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            int current = height[i];
            while (!monoStack.isEmpty() && height[monoStack.peek()] <= current) {
                int lower = height[monoStack.pop()];

                if (!monoStack.isEmpty()) {
                    int largerLeft = height[monoStack.peek()];
                    int largerRight = current;

                    int currentWater = (Math.min(largerLeft, largerRight) - lower) * (i - monoStack.peek() - 1);
                    result += currentWater;
                }
            }

            monoStack.push(i);
        }

        return result;
    }

}
