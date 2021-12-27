package com.mygaienko.common.algorithms.leetcode.interleaving_string;

class SolutionV2 {

    public boolean isInterleave(String s1, String s2, String s3) {
        int S1 = s1.length();
        int S2 = s2.length();
        int S3 = s3.length();
        if (S1 + S2 != S3) return false;

        boolean[][][] dp = new boolean[S3+1][S1+1][S2+1];
        dp[0][0][0] = true;
        dp[0][0][1] = true;
        dp[0][1][0] = true;

        for (int i = 1; i < S3+1; i++) {
            char nextChar = s3.charAt(i-1);

            for (int s1Index = 1; s1Index <= i && s1Index <= s1.length(); s1Index++) {
                int s2Index = i - s1Index + 1;
                boolean prev = dp[i - 1][s1Index-1][s2Index-1];

                char nextS1Char = s1.charAt(s1Index-1);
                boolean s1CharMatch = nextS1Char == nextChar;

                char nextS2Char = s2Index-1 < s2.length() ? s2.charAt(s2Index-1) : '-';
                boolean s2CharMatch = nextS2Char == nextChar;

                if (prev && s1CharMatch) {
                    dp[i][s1Index][s2Index-1] = true;
                } else if (prev && s2CharMatch) {
                    dp[i][s1Index-1][s2Index] = true;
                }
            }
        }

        return dp[S3][S1][S2];
    }
}
