package com.mygaienko.common.algorithms.leetcode.minimum_window_subsequence;

import java.util.Arrays;

/**
 * 727. Minimum Window Subsequence
 * https://leetcode.com/problems/minimum-window-subsequence/
 */
class SolutionV2 {

    public static final int NOT_FOUND = -1;

    @SuppressWarnings("Duplicates")
    public String minWindow(String s1, String s2) {

        int[][] dp = init(s1, s2); // dp[i][j] - min length of substring of s1[0:i] and s2[0:j]

        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                boolean charsSame = s1.charAt(i) == s2.charAt(j);

                if (j == 0) {
                    if (charsSame) {
                        dp[i][j] = 1;
                    } else {
                        if (i == 0) {
                            continue;
                        }
                        int prev = dp[i - 1][0];
                        if (prev != NOT_FOUND) {
                            dp[i][0] = prev + 1;
                        }
                    }


                } else if (i > 0) {
                    int prevCharIndexLength = dp[i - 1][j - 1];

                    if (charsSame && prevCharIndexLength != NOT_FOUND) {
                        dp[i][j] = prevCharIndexLength + 1;
                    } else {
                        int prevIndexLength = dp[i - 1][j];
                        if (prevIndexLength != NOT_FOUND) {
                            dp[i][j] = prevIndexLength + 1;
                        }
                    }
                }
            }
        }

        int minLength = Integer.MAX_VALUE;
        int start = NOT_FOUND;
        for (int i = 0; i < s1.length(); i++) {

            int length = dp[i][s2.length() - 1];
            if (length != NOT_FOUND && length < minLength) {
                minLength = length;
                start = i - length + 1;
            }
        }

        return start == NOT_FOUND ? "" : s1.substring(start, start + minLength);
    }

    public int[][] init(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        for (int[] arr : dp) {
            Arrays.fill(arr, NOT_FOUND);
        }

        return dp;
    }

}
