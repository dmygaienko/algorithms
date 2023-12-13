package com.mygaienko.common.algorithms.leetcode.knight_dialer;

import java.util.Arrays;

class Solution {

    int MOD = (int) Math.pow(10, 9) + 7;

    int[][] predecessors = new int[][]{
            {4, 6}, // to 0
            {8, 6}, // to 1
            {7, 9}, // to 2
            {4, 8}, // to 3
            {0, 3, 9}, // to 4

            {}, // to 5
            {0, 1, 7}, // to 6
            {2, 6}, // to 7
            {1, 3}, // to 8
            {2, 4} // to 9
    };

    // init dp
    // for each step look back at previos valid step and add its result
    // sum of all the results on the last step
    public int knightDialer(int n) {
        var prevDp = new long[10];
        var currDp = new long[10];
        Arrays.fill(prevDp, 1);

        for (int i = 1; i < n; i++) {
            currDp = new long[10];
            for (int j = 0; j < 10; j++) {
                var currPredecessors = predecessors[j];

                for (var predecessor : currPredecessors) {
                    var prevResult = prevDp[predecessor];
                    currDp[j] = (currDp[j] + prevResult) % MOD;
                }
            }

            if (i + 1 < n) {
                prevDp = currDp;
            }

        }

        currDp = n > 1 ? currDp : prevDp;
        var result = 0L;
        for (int j = 0; j < 10; j++) {
            var combinations = currDp[j];
            result = (result + combinations) % MOD;
        }

        return (int) result;
    }

}
