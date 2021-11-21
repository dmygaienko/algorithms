package com.mygaienko.common.algorithms.leetcode.split_a_string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1525. Number of Good Ways to Split a String
 * https://leetcode.com/problems/number-of-good-ways-to-split-a-string/
 */
class Solution {

    public int numSplits(String s) {
        char[] chars = s.toCharArray();


        Map<Integer, Integer> indToUniqR = new HashMap<>();
        Set<Character> uChars = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            char nextChar = chars[i];
            uChars.add(nextChar);
            indToUniqR.put(i, uChars.size());
        }

        Map<Integer, Integer> indToUniqL = new HashMap<>();
        Set<Character> uCharsL = new HashSet<>();
        for (int i = chars.length - 1; i >= 0; i--) {
            char nextChar = chars[i];
            uCharsL.add(nextChar);
            indToUniqL.put(i, uCharsL.size());
        }

        int result = 0;
        for (int j = 0; j < chars.length-1; j++) {
            Integer uniqR = indToUniqR.get(j);
            Integer uniqL = indToUniqL.get(j+1);
            if (uniqR.equals(uniqL)) {
                ++result;
            }
        }

        return result;
    }

}
