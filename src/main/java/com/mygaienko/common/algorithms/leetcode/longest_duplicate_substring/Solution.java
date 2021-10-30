package com.mygaienko.common.algorithms.leetcode.longest_duplicate_substring;


import java.util.*;

/**
 * https://leetcode.com/problems/longest-duplicate-substring/
 */
public class Solution {

    public String longestDupSubstring(String s) {

        Map<String, Integer> sortedSubstrings = new TreeMap<>(Comparator
                .comparingInt(String::length).reversed()
                .thenComparing(String::hashCode));

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String substring = s.substring(i, j);
                sortedSubstrings.compute(substring, (k, occur) -> occur == null ? 1 : occur + 1);
            }
        }

        return sortedSubstrings.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse("");
    }

}
