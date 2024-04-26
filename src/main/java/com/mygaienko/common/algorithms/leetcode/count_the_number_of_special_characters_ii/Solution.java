package com.mygaienko.common.algorithms.leetcode.count_the_number_of_special_characters_ii;


import java.util.Arrays;

class Solution {
    public int numberOfSpecialChars(String word) {
        var lowerMaxCounts = new int[26];
        var upperMinIndex = new int[26];

        Arrays.fill(lowerMaxCounts, Integer.MIN_VALUE);
        Arrays.fill(upperMinIndex, Integer.MAX_VALUE);

        for (int i = 0; i < word.length(); i++) {
            var ch = word.charAt(i);
            var index = ch - 'A';
            if (index >= 26) {
                var lowerIndex = ch - 'a';
                lowerMaxCounts[lowerIndex] = Math.max(lowerMaxCounts[lowerIndex], i);
            } else {
                upperMinIndex[index] = Math.min(upperMinIndex[index], i);
            }
        }

        var specCount = 0;
        for (int i = 0; i < lowerMaxCounts.length; i++) {
            if (lowerMaxCounts[i] != Integer.MIN_VALUE && upperMinIndex[i] != Integer.MAX_VALUE
                    && lowerMaxCounts[i] < upperMinIndex[i]) {
                specCount++;
            }
        }

        return specCount;
    }
}
