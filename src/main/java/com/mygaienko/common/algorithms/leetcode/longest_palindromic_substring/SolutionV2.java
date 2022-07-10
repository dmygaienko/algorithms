package com.mygaienko.common.algorithms.leetcode.longest_palindromic_substring;


public class SolutionV2 {

    public String longestPalindrome(String s) {

        int size = s.length();

        int startIndex = -1;
        int endIndex = -1;

        boolean[][] dp = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= i; j++) {

                char firstChar = s.charAt(j);
                char secondChar = s.charAt(i);
                boolean isSameChars = firstChar == secondChar;
                int prevStart = j + 1;
                int prevEnd = i - 1;

                boolean isPal = ((prevStart <= prevEnd) && (prevEnd >= 0))
                        ? (isSameChars && dp[prevStart][prevEnd])
                        : isSameChars;

                dp[j][i] = isPal;
                if (isPal && (i - j) >= (endIndex-startIndex)) {
                    startIndex = j;
                    endIndex = i;
                }
            }
        }

        return (startIndex != -1 && endIndex != -1) ? s.substring(startIndex, endIndex + 1) : "";
    }

}
