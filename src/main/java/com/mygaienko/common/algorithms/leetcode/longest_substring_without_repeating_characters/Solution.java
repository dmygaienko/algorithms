package com.mygaienko.common.algorithms.leetcode.longest_substring_without_repeating_characters;

import java.util.*;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int maxLength = 0;

        Map<Character, LinkedList<Integer>> charOccurences = new HashMap<>();
        int currentLength = 0;
        for (int i = 0; i < chars.length; i++) {
            char nextChar = chars[i];

            LinkedList<Integer> occurences = charOccurences.computeIfAbsent(nextChar, v -> new LinkedList<>());
            occurences.add(i);

            if (occurences.size() > 1) {
                maxLength = Math.max(maxLength, currentLength);
                int firstOccurence = occurences.removeFirst();
                currentLength = Math.min(currentLength + 1, i - firstOccurence);
            } else {
                currentLength++;
            }
        }

        return Math.max(currentLength, maxLength);
    }

}
