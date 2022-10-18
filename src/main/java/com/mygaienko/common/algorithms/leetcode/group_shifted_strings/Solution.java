package com.mygaienko.common.algorithms.leetcode.group_shifted_strings;

import java.util.*;


class Solution {

    public List<List<String>> groupStrings(String[] strings) {
        Map<Long, List<String>> groupedStrings = group(strings);
        return new ArrayList<>(groupedStrings.values());
    }

    private Map<Long, List<String>> group(String[] strings) {
        Map<Long, List<String>> grouped = new HashMap<>();
        for (String s : strings) {
            long hash = 17;

            for (int i = 1; i < s.length(); i++) {
                char prevCh = s.charAt(i-1);
                char ch = s.charAt(i);
                int diff = ch - prevCh;
                if (diff < 0) {
                    diff += 26;
                } else if (diff == 0) {
                    diff = 10000;
                }
                hash = 31 * hash + diff;
            }
            grouped.putIfAbsent(hash, new ArrayList<>());
            grouped.get(hash).add(s);
        }
        return grouped;
    }
}