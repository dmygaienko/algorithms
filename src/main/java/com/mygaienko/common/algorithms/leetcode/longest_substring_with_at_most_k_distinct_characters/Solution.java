package com.mygaienko.common.algorithms.leetcode.longest_substring_with_at_most_k_distinct_characters;

import java.util.HashMap;
import java.util.Map;

/**
 * sliding window
 */
class Solution {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int longestLength = 0;

        Map<Character, Integer> charCounts = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            for (int j = i + longestLength; j < s.length(); j++) {
                char ch = s.charAt(j);
                charCounts.compute(ch, (key, v) -> v == null ? 1 : v + 1);

                if (charCounts.size() <= k) {
                    longestLength = Math.max(longestLength, j - i + 1);
                } else {
                    break;
                }
            }

            char firstChar = s.charAt(i);
            int iCount = charCounts.compute(firstChar, (key, v) -> v - 1);
            if (iCount <= 0) {
                charCounts.remove(firstChar);
            }

        }

        return longestLength;
    }

}
