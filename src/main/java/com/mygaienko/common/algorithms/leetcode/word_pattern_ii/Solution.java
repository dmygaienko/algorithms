package com.mygaienko.common.algorithms.leetcode.word_pattern_ii;

import java.util.HashSet;
import java.util.Set;

class Solution {

    String pattern;
    String s;

    public boolean wordPatternMatch(String pattern, String s) {
        this.pattern = pattern;
        this.s = s;
        return wordPatternMatch(new String[26], new HashSet<>(), 0, 0);
    }

    private boolean wordPatternMatch(String[] patterns, Set<String> existing, int pIndex, int sIndex) {
        if (sIndex == s.length() && pIndex == pattern.length()) {
            return true;
        } else if (sIndex >= s.length() || pIndex >= pattern.length()) {
            return false;
        }

        var nextPattern = pattern.charAt(pIndex);
        var nextPatternIndex = nextPattern - 'a';
        var nextPatterStr = patterns[nextPatternIndex];

        if (nextPatterStr != null) {
            if (s.startsWith(nextPatterStr, sIndex)) {
                return wordPatternMatch(patterns, existing, pIndex + 1, sIndex + nextPatterStr.length());
            } else {
                return false;
            }
        }

        for (int i = sIndex; i < s.length(); i++) {
            var currPattern = s.substring(sIndex, i + 1);
            if (existing.contains(currPattern)) continue;

            existing.add(currPattern);
            patterns[nextPatternIndex] = currPattern;

            if (wordPatternMatch(patterns, existing, pIndex + 1, i + 1)) {
                return true;
            }

            existing.remove(currPattern);
            patterns[nextPatternIndex] = null;
        }
        return false;
    }

}
