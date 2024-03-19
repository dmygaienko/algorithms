package com.mygaienko.common.algorithms.leetcode.coin_path;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {

    public List<Integer> cheapestJump(int[] coins, int maxJump) {
        int n = coins.length + 1;
        var prev = new int[n];
        var dp = new int[n];

        dp[1] = coins[0];
        Arrays.fill(prev, -1);

        for (int i = 2; i < n; i++) {
            int currCost = coins[i - 1];
            if (currCost == -1) continue;

            int prevCost = Integer.MAX_VALUE;
            int prevIndex = Integer.MAX_VALUE;
            for (int j = Math.max(1, i - maxJump); j < i; j++) {
                if (coins[j - 1] == -1) continue;

                int jCost = dp[j];
                if (prevCost >= jCost) {
                    prevCost = jCost;
                    prevIndex = j;
                }
            }

            if (prevCost != Integer.MAX_VALUE) {
                dp[i] = prevCost + currCost;
                prev[i] = prevIndex;
            }
        }

        var list = new LinkedList<Integer>();
        if (coins.length == 0 || coins[coins.length - 1] == -1) {
            return list;
        }

        int prevIndex = n - 1;
        while (prevIndex > 1 && prev[prevIndex] != -1) {
            list.addFirst(prevIndex);
            prevIndex = prev[prevIndex];
        }

        if (prevIndex == 1 && coins[0] != -1) {
            list.addFirst(1);
            return list;
        }

        return List.of();
    }

}