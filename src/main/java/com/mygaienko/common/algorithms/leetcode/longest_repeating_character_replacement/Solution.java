package com.mygaienko.common.algorithms.leetcode.longest_repeating_character_replacement;

class Solution {

    public int characterReplacement(String s, int k) {
        var left = 0;
        var right = 0;

        var maxLength = 0;
        var charCounts = new int[26];

        var maxCount = 0;

        while (right < s.length()) {
            var next = s.charAt(right);

            var key = next - 'A';
            charCounts[key]++;
            maxCount = Math.max(maxCount, charCounts[key]);

            var curLength = right - left + 1;
            if (maxCount + k >= curLength) {
                maxLength = Math.max(maxLength, curLength);
            } else if (left < right) {
                charCounts[s.charAt(left) - 'A']--;
                left++;
            }

            right++;
        }

        return maxLength;
    }

}
