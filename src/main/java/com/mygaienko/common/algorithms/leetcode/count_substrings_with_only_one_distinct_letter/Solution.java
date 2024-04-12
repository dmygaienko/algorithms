package com.mygaienko.common.algorithms.leetcode.count_substrings_with_only_one_distinct_letter;

class Solution {
    public int countLetters(String s) {
        var count = 0;

        Character prev = null;
        int prevI = 0;

        for (int i = 0; i < s.length(); i++) {
            var ch = s.charAt(i);

            if (prev == null) {
                prev = ch;
            } else if (prev != ch) {
                count += countSubArrays(i - prevI);
                prev = ch;
                prevI = i;
            }

            if (i + 1 == s.length()) {
                count += countSubArrays(i - prevI + 1);
            }
        }
        return count;
    }

    int countSubArrays(int n) {
        return n * (n + 1) / 2;
    }
}