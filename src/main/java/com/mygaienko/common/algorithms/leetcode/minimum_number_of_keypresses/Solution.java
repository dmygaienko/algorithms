package com.mygaienko.common.algorithms.leetcode.minimum_number_of_keypresses;

import java.util.Arrays;

class Solution {
    public int minimumKeypresses(String s) {
        var counts = new int[26][2];
        Arrays.fill(counts, new int[]{-1, -1});
        for (var ch : s.toCharArray()) {
            var charIndex = ch - 'a';
            if (counts[charIndex][0] == -1) {
                counts[charIndex] = new int[]{charIndex, 0};
            }
            counts[charIndex][1]++;
        }

        Arrays.sort(counts, (a, b) -> b[1] - a[1]);

        var keyPresses = 0;

        var order = 1;
        for (int i = 0; i < counts.length; i++) {
            var currOrder = order + i / 9;
            var charCount = counts[i][1];

            if (charCount > 0) {
                keyPresses += currOrder * charCount;
            }
        }

        return keyPresses;
    }
}