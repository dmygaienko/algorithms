package com.mygaienko.common.algorithms.leetcode.longest_palindromic_substring;

import java.util.Arrays;

class Solution {

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";

        int N = s.length();

        boolean[][] dp = new boolean[N+1][N];
        Arrays.fill(dp[1], true);

        int maxSize = 1;
        int maxIndex = 0;

        for (int i = 2; i < dp.length; i++) {       // length growth
            for (int j = 0; j < dp[0].length; j++) {   // over each char

                if (i==2) {
                    if (j + 1 < dp[0].length && s.charAt(j) == s.charAt(j+1)) {
                        dp[i][j] = true;

                        if (i > maxSize) {
                            maxSize = i;
                            maxIndex = j;
                        }
                    }
                }

                if (i-2 > 0 && j + i - 1< dp[0].length && dp[i-2][j+1] && s.charAt(j) == s.charAt(j + i - 1)) {
                    dp[i][j] = true;

                    if (i > maxSize) {
                        maxSize = i;
                        maxIndex = j;
                    }
                }

            }
        }

        return s.substring(maxIndex, maxIndex + maxSize);
    }

}
