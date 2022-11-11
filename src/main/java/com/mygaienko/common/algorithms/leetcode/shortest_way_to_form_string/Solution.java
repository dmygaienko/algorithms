package com.mygaienko.common.algorithms.leetcode.shortest_way_to_form_string;

import java.util.Arrays;

class Solution {

    public int shortestWay(String source, String target) {
        int[][] memo = new int[source.length()][target.length()];
        for (int[] ints : memo) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        return shortestWay(source, target, 0, 0, 0, memo);
    }

    private int shortestWay(String source, String target, int i, int j, int current, int[][] memo) {
        boolean cycle = false;
        int cacheJ = j;

        for (; i < source.length() && j < target.length() ; i++) {
            char nextCh = source.charAt(i);
            char targetCh = target.charAt(j);

            if (nextCh == targetCh) {
                int nextI = i + 1;
                int nextJ = j + 1;
                if (nextJ == target.length()) {
                    return current + 1;
                }

                int nextShortest = Integer.MAX_VALUE;
                if (memo[i][j] != Integer.MAX_VALUE) {
                    nextShortest = memo[i][j];
                } else if (nextI < source.length() && nextJ < target.length()){
                    nextShortest = shortestWay(source, target, nextI, nextJ, current, memo);
                }

                memo[i][j] = Math.min(nextShortest, memo[i][j]);
                j++;
            }

            if (i == source.length() - 1) {
                if (cycle && cacheJ == j) return -1;

                i = -1;
                current++;
                cycle = true;
                cacheJ = j;
            }
        }

        return memo[i][j];
    }

}