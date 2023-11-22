package com.mygaienko.common.algorithms.leetcode.maximum_length_of_pair_chain;

import java.util.Arrays;
import java.util.Comparator;

class Solution {

    /**
     * occupy by id of pair
     * if current pair is narrow then occupied, then replace
     * <p>
     * dynamically iterate of dp array and count all the pairs
     * if prev end < next start then current = prev + 1
     * if not then look at pair before (then current = (prev - 1) + 1 OR current = prev)
     */
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.<int[]>comparingInt(arr -> arr[1]).thenComparingInt(arr -> arr[1] - arr[0]));

        var min = Integer.MAX_VALUE;
        var max = Integer.MIN_VALUE;
        for (var pair : pairs) {
            min = Math.min(min, pair[0]);
            max = Math.max(max, pair[1]);
        }

        var dpLength = max - min;

        var dp = new int[dpLength + 1];
        var count = 0;
        for (int i = 0; i < pairs.length; i++) {
            var pair = pairs[i];
            var start = pair[0] - min;
            var end = pair[1] - min;

            boolean clear = true;
            for (int j = start; j <= end; j++) {
                if (dp[j] != 0) {
                    clear = false;
                    break;
                }
            }

            if (clear) {
                for (int j = start; j <= end; j++) {
                    dp[j] = 1;
                }
                count++;
            }
        }

        return count;
    }
}
