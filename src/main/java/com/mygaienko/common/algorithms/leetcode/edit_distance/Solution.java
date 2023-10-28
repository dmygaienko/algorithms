package com.mygaienko.common.algorithms.leetcode.edit_distance;

import java.util.Arrays;

class Solution {

    public int minDistance(String word1, String word2) {
        if (word1.equals("")) return word2.length();
        else if (word2.equals("")) return word1.length();

        if (word1.length() < word2.length()) {
            var temp = word1;
            word1 = word2;
            word2 = temp;
        }

        int N = word1.length() + 1;
        int M = word2.length() + 1;
        var dp = new int[N][M];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < N; i++) {
            var char1 = word1.charAt(i - 1);
            for (int j = 1; j < M; j++) {
                var char2 = word2.charAt(j - 1);

                var prevValue = dp[i - 1][j - 1] ;
                var prevRowValue = dp[i][j - 1] ;
                var prevColumnValue = dp[i - 1][j] ;

                if (char1 == char2) {
                    dp[i][j] = prevValue;
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(prevValue, prevRowValue), prevColumnValue); // delete or insert
                }

            }
        }

        return dp[N-1][M-1];
    }

}
