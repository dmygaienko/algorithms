package com.mygaienko.common.algorithms.leetcode.interleaving_string;

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        boolean result = true;
        if (s1.length() + s2.length() != s3.length()) return false;

        int s1Index = 0;
        int s2Index = 0;

        for (int i = 0; i < s3.length(); i++) {
            char next = s3.charAt(i);

            if (s1Index < s1.length() && next == s1.charAt(s1Index)) {
                s1Index++;
            } else if (s2Index < s2.length() && next == s2.charAt(s2Index)) {
                s2Index++;
            } else {
                return false;
            }
        }

        return result;
    }
}
