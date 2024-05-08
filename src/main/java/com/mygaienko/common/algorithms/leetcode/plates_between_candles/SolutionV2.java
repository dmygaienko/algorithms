package com.mygaienko.common.algorithms.leetcode.plates_between_candles;

import java.util.ArrayList;
import java.util.List;

class SolutionV2 {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        var prefixSum = new int[s.length()];
        var candles = new ArrayList<Integer>();

        for (int i = 0; i < s.length(); i++) {
            var ch = s.charAt(i);
            var currPlates = ch == '*' ? 1 : 0;
            var prevPlates = i > 0 ? prefixSum[i - 1] : 0;
            prefixSum[i] = prevPlates + currPlates;

            if (ch == '|') {
                candles.add(i);
            }
        }

        var result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            var query = queries[i];
            var from = rightCandle(candles, query[0]);
            var to = leftCandle(candles, query[1]);
            if (from != Integer.MAX_VALUE && to != Integer.MIN_VALUE) {
                result[i] = Math.max(0, prefixSum[to] - prefixSum[from]);
            }
        }

        return result;
    }

    private int rightCandle(List<Integer> candles, int from) {
        var left = 0;
        var right = candles.size() - 1;

        var rightCandle = Integer.MAX_VALUE;
        while (left <= right) {
            var mid = left + (right - left) / 2;

            if (candles.get(mid) >= from) {
                rightCandle = Math.min(rightCandle, candles.get(mid));
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return rightCandle;
    }

    private int leftCandle(List<Integer> candles, int to) {
        var left = 0;
        var right = candles.size() - 1;

        var leftCandle = Integer.MIN_VALUE;
        while (left <= right) {
            var mid = left + (right - left) / 2;

            if (candles.get(mid) <= to) {
                leftCandle = Math.max(leftCandle, candles.get(mid));
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return leftCandle;
    }
}
