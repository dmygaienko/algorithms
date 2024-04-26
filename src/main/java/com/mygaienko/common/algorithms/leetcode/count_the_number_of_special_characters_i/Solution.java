package com.mygaienko.common.algorithms.leetcode.count_the_number_of_special_characters_i;

class Solution {
    public int numberOfSpecialChars(String word) {
        var upperCounts = new int[26];
        var lowerCounts = new int[26];

        for (var ch : word.toCharArray()) {
            var index = ch - 'A';
            if (index >= 26) {
                lowerCounts[ch - 'a']++;
            } else {
                upperCounts[index]++;
            }
        }

        var specCount = 0;
        for (int i = 0; i < lowerCounts.length; i++) {
            if (lowerCounts[i] > 0 && upperCounts[i] > 0) {
                specCount += Math.min(lowerCounts[i], upperCounts[i]);
            }
        }
        return specCount;
    }
}