package com.mygaienko.common.algorithms.leetcode.daily_temperatures;

import java.util.ArrayDeque;

class Solution {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        ArrayDeque<Integer> monoStack = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++) {
            int val = temperatures[i];

            while(!monoStack.isEmpty() && temperatures[monoStack.peek()] < val) {
                int poped = monoStack.pop();
                result[poped] = i - poped;
            }

            monoStack.push(i);
        }
        return result;
    }


}
