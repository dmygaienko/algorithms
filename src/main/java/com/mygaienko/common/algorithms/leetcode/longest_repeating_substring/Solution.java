package com.mygaienko.common.algorithms.leetcode.longest_repeating_substring;

import java.util.HashMap;

class Solution {

    long MOD = (long) Math.pow(10, 13) + 1;

    // iterate over string chars

    // TOP DOWN DP
    // for each char calculate longest repeating substring
    // for s.substring from i till the end
    // Formula: memo[i] = memo[i+1];
    //  + substring(i, i+1);
    //  ...
    //  + substring(i, end-1);
    // for each substring calculate hash and put into the map

    // BOTTOM UP DP
    // for each char calculate longest repeating substring
    // for s.substring 0 to i
    // Formula: memo[i] = memo[i - 1];
    //  + substring(0, i);
    //  ...
    //  + substring(i-1, i);
    // for each substring calculate hash and put into the map

    public int longestRepeatingSubstring(String s) {
        var hashToFreq = new HashMap<Long, Integer>();
        var dp = new long[s.length()][s.length()];
        var maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                var hash = hash(dp, s, j, i);
                var length = i - j + 1;
                var freq = hashToFreq.compute(hash, (k, v) -> v == null
                        ? 1
                        : v + 1);

                if (freq > 1) {
                    maxLength = Math.max(maxLength, i - j + 1);
                }
            }
        }

        return maxLength;
    }

    long hash(long[][] dp, String s, int from, int to) {
        var result = from == to ? 0 : dp[from][to - 1];
        result = (result * 23 + (int) s.charAt(to)) % MOD;
        dp[from][to] = result;
        return result;
    }

    // public int longestRepeatingSubstring(String s) {
    //     int n = s.length();
    //     int count = 0;
    //     int[][] dp = new int[n][n];
    //     for(int i = 0;i < n;i++){
    //         for(int j = i + 1;j < n;j++){
    //             if(s.charAt(i) == s.charAt(j)){
    //                 dp[i][j] = i > 0 ? dp[i - 1][j - 1] + 1 : 1;
    //             }
    //             count = Math.max(count,dp[i][j]);
    //         }
    //     }
    //     return count;
    // }

}