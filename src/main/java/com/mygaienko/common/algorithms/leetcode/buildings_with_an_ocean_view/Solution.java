package com.mygaienko.common.algorithms.leetcode.buildings_with_an_ocean_view;

import java.util.ArrayDeque;

class Solution {

    public int[] findBuildings(int[] heights) {
        var monoStack = new ArrayDeque<Integer>();

        for (int i = 0; i < heights.length; i++) {
            var next = heights[i];

            while (!monoStack.isEmpty() && heights[monoStack.peek()] <= next) {
                monoStack.pop();
            }

            monoStack.push(i);
        }

        var oceanView = new int[monoStack.size()];
        for (int i = monoStack.size() - 1; i >= 0; i--) {
            oceanView[i] = monoStack.pop();
        }

        return oceanView;
    }

}