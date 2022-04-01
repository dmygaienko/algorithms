package com.mygaienko.common.algorithms.leetcode.trapping_rain_water;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class SolutionV2 {

    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        Map<Integer, Integer> fromTo = new HashMap<>();
        Deque<Integer> monoStack = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            int current = height[i];
            while (!monoStack.isEmpty() && height[monoStack.peek()] <= current) {
                int popped = monoStack.pop();
                deleteAndPut(fromTo, popped, i);
            }

            monoStack.push(i);
        }

        Integer prev = null;
        while (!monoStack.isEmpty()) {
            Integer popped = monoStack.pop();
            if (prev != null) {
                deleteAndPut(fromTo, popped, prev);
            }
            prev = popped;
        }

        return fromTo.entrySet().stream()
                .map(e -> calculateTrappedWater(height, e.getKey(), e.getValue()))
                .reduce(0, Integer::sum);
    }

    private void deleteAndPut(Map<Integer, Integer> fromTo, int popped, int i) {
        deleteBetween(fromTo, popped, i);
        fromTo.put(popped, i);
    }

    private void deleteBetween(Map<Integer, Integer> fromTo, int popped, int i) {
        for (int j = popped; j < i; j++) {
            fromTo.remove(j);
        }
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
