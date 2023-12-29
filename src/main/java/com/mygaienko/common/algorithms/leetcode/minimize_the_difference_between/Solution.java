package com.mygaienko.common.algorithms.leetcode.minimize_the_difference_between;

import java.util.Arrays;

class Solution {

    public int minimizeTheDifference(int[][] mat, int target) {
        int N = mat[0].length;
        var prevDp = new int[N];
        var currDp = new int[N];
        Arrays.fill(currDp, Integer.MAX_VALUE);

        //init dp
        for (int j = 0; j < N; j++) {
            prevDp[j] = Math.abs(target - mat[0][j]);
        }

        for (int i = 1; i < mat.length; i++) {
            for (int j = 0; j < N; j++) {
                var val = mat[i][j];

                for (int m = 0; m < N; m++) {
                    var diff = Math.abs(prevDp[m] - val);
                    currDp[j] = Math.min(currDp[j], diff);
                }
            }

            prevDp = currDp;
            currDp = new int[N];
            Arrays.fill(currDp, Integer.MAX_VALUE);
        }

        var min = Integer.MAX_VALUE;
        for (var res : prevDp) {
            min = Math.min(min, res);
        }
        return min;
    }

}
