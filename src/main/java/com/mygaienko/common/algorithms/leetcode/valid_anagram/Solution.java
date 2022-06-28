package com.mygaienko.common.algorithms.leetcode.valid_anagram;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public boolean isAnagram(String s, String t) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> occurs = new HashMap<>();
        for(Character ch : chars) {
            occurs.compute(ch, (k, v) -> v == null ? 1 : v + 1);
        }

        char[] other = t.toCharArray();
        for(Character ch : other) {
            occurs.compute(ch, (k, v) -> v == null ? 1 : v - 1);
        }

        return occurs.values().stream()
                .map(sum -> sum == 0)
                .reduce(true, (a, b) -> a && b);
    }

}
