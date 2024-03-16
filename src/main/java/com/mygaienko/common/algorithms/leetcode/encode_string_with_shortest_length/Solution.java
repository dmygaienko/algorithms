package com.mygaienko.common.algorithms.leetcode.encode_string_with_shortest_length;

class Solution {
    public String encode(String s) {
        if (s.length() <= 3) {
            return s;
        }

        var dp = new String[s.length() + 1][s.length() + 1];
        for (int step = 1; step <= s.length(); step++) {
            for (int i = 0; i + step <= s.length(); i++) {
                dp[i][i] = "";
                var j = i + step;
                var subStr = s.substring(i, j);
                dp[i][j] = subStr;

                if (subStr.length() <= 4) {
                    continue;
                }

                var pos = (subStr + subStr).indexOf(subStr, 1);
                if (pos < subStr.length()) {
                    var sb = new StringBuilder();
                    sb.append(subStr.length() / pos);
                    sb.append('[');
                    sb.append(dp[i][i + pos]);
                    sb.append(']');
                    if (sb.length() < dp[i][j].length()) {
                        dp[i][j] = sb.toString();
                    }
                    continue;
                }

                for (int k = i; k < j; k++) {
                    var left = dp[i][k];
                    var right = dp[k][j];

                    if (left.length() + right.length() < dp[i][j].length()) {
                        dp[i][j] = left + right;
                    }
                }
            }
        }

        return dp[0][s.length()];
    }
}