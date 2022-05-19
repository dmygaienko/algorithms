package com.mygaienko.common.algorithms.leetcode.longest_substring_with_at_most_two_distinct_characters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        char[] chars = s.toCharArray();
        int maxLength = 0;

        Set<Character> distincts = new HashSet<>();
        Map<Character, Integer> maxIndex = new HashMap<>();

        int currentLength = 0;
        for (int i = 0; i < chars.length; i++) {
            char nextChar = chars[i];

            maxIndex.put(nextChar, i);
            distincts.add(nextChar);

            if (distincts.size() > 2) {
                int minIndex = Integer.MAX_VALUE;
                Character minCh = null;
                for (Character ch : distincts) {
                    int chIndex = maxIndex.get(ch);
                    if (minIndex > chIndex) {
                        minCh = ch;
                        minIndex = chIndex;
                    }
                }
                distincts.remove(minCh);

                maxLength = Math.max(maxLength, currentLength);
                currentLength = i - minIndex;
            } else {
                currentLength++;
            }
        }

        return Math.max(currentLength, maxLength);
    }

}
