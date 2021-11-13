package com.mygaienko.common.algorithms.leetcode.longest_substring_without_repeating_characters;

import java.util.*;

public class Solution {

    public int lengthOfLongestSubstring(String s) {

        int longest = 0;

        Map<Character, LinkedList<Integer>> chars = new HashMap<>();

        int currentLongest = 0;
        for (int i = 0; i < s.length(); i++) {
            int finalI = i;
            char ch = s.charAt(i);
            LinkedList<Integer> duplicateIndexes = chars.compute(ch, (k, v) -> v == null ? newWithValue(finalI) : addValue(v, finalI));

            if (duplicateIndexes.size() > 1) {
                longest = Math.max(currentLongest, longest);
                currentLongest = Math.min(currentLongest + 1, i - duplicateIndexes.removeFirst());
            } else {
                currentLongest++;
            }
        }

        return Math.max(currentLongest, longest);
    }

    private LinkedList<Integer> newWithValue(Integer v) {
        return addValue(new LinkedList<>(), v);
    }

    private LinkedList<Integer> addValue(LinkedList<Integer> list, Integer v) {
        list.add(v);
        return list;
    }

}
