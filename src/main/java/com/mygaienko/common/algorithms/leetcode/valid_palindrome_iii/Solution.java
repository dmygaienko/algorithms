package com.mygaienko.common.algorithms.leetcode.valid_palindrome_iii;

import java.util.Arrays;

class Solution {
    // iterate over string N ^ K
    // recursively remove character till k > 0
    // on each step verify whether palindrome

    public boolean isValidPalindrome(String s, int k) {
        int size = s.length();

        var dp = new int[size][size]; //[from][to] -> deletions
        for (var arr : dp) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        for (int i = 0; i < size; i++) {
            dp[i][i] = 0;
        }

        for (int right = 0; right < s.length(); right++) {
            for (int left = right - 1; left >= 0; left--) {

                var prevRight = right - 1;
                var prevLeft = left + 1;

                if (prevLeft >= s.length()) {
                    continue;
                }

                var isEqual = s.charAt(left) == s.charAt(right);
                if (isEqual) {
                    if (right - left == 1) {
                        dp[left][right] = 0;
                    }
                    dp[left][right] = Math.min(dp[left][right], dp[prevLeft][prevRight]);

                } else {
                    if (dp[left][prevRight] != Integer.MAX_VALUE) {
                        dp[left][right] = Math.min(dp[left][right], dp[left][prevRight] + 1);
                    }

                    if (dp[prevLeft][right] != Integer.MAX_VALUE) {
                        dp[left][right] = Math.min(dp[left][right], dp[prevLeft][right] + 1);
                    }

                }
            }
        }

        return dp[0][size - 1] <= k;
    }

}