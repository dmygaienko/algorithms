package com.mygaienko.common.algorithms.leetcode.trapping_rain_water;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        Map<Integer, Integer> trappedRegions = new HashMap<>();

        for (int i = 1; i < height.length; i++) {
            int left = findNearestHighestLeft(height, i);
            int right = findNearestHighestRight(height, i);

            int amount = calculateTrappedWater(height, left, right);
            if (amount > 0) {
                int centre = left + (right - left) / 2;
                trappedRegions.put(centre, amount);
            }
        }

        return trappedRegions.values().stream()
                .reduce(0, Integer::sum);
    }

    private int findNearestHighestRight(int[] height, int i) {
        int current = height[i];
        while (i + 1 < height.length && current <= height[i + 1]) {
            current = height[i + 1];
            i++;
        }
        return i;
    }

    private int findNearestHighestLeft(int[] height, int i) {
        int current = height[i];
        while (i - 1 > 0 && current <= height[i - 1]) {
            current = height[i - 1];
            i--;
        }
        return i;
    }

    private int calculateTrappedWater(int[] height, int left, int right) {
        int amount = 0;
        if (right - left > 1) {
            int trappedHeight = Math.min(height[left], height[right]);
            for (int i = left + 1; i <= right - 1; i++) {
                int current = height[i];
                int trapped = trappedHeight - current;
                amount += trapped;
            }
        }
        return amount;
    }

}
