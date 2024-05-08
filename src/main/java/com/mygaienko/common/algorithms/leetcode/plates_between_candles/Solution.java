package com.mygaienko.common.algorithms.leetcode.plates_between_candles;

import java.util.Arrays;

class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        var prefixSum = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            var ch = s.charAt(i);
            var currPlates = ch == '*' ? 1 : 0;
            var prevPlates = i > 0 ? prefixSum[i - 1] : 0;
            prefixSum[i] = prevPlates + currPlates;
        }

        var prevCandle = new int[s.length()];
        Arrays.fill(prevCandle, Integer.MIN_VALUE);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|') {
                prevCandle[i] = i;
            } else if (i > 0) {
                prevCandle[i] = prevCandle[i - 1];
            }
        }

        var nextCandle = new int[s.length()];
        Arrays.fill(nextCandle, Integer.MAX_VALUE);
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                nextCandle[i] = i;
            } else if (i + 1 < s.length()) {
                nextCandle[i] = nextCandle[i + 1];
            }
        }

        var result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            var query = queries[i];
            var from = nextCandle[query[0]];
            var to = prevCandle[query[1]];
            if (from < to) {
                result[i] = Math.max(0, prefixSum[to] - prefixSum[from]);
            }
        }

        return result;
    }

}
