package com.mygaienko.common.algorithms.leetcode.minimum_window_substring;

import java.util.HashMap;
import java.util.HashSet;

class Solution {

    /**
     * count char counts of target string
     * iterate with two pointers, subtract char from char counts, if char is zero remove from map,
     * if map is empty save length of window
     * return minimum of all found lengths
     */
    public String minWindow(String s, String t) {
        //t to char count
        var targetCharCount = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            var ch = t.charAt(i);
            targetCharCount.compute(ch, (k, v) -> v == null ? 1 : v + 1);
        }

        var left = 0;
        var right = 0;

        var minLength = Integer.MAX_VALUE;
        var start = -1;
        var end = -1;

        var wanted = new HashSet<>(targetCharCount.keySet());
        var currCharCount = new HashMap<Character, Integer>();
        while (right < s.length()) {
            var rightCh = s.charAt(right);
            var currRightChCount = currCharCount.compute(rightCh, (k, v) -> v == null ? 1 : v + 1);

            if (currRightChCount >= targetCharCount.getOrDefault(rightCh, 0)) {
                wanted.remove(rightCh);
                if (wanted.isEmpty() && right - left + 1 < minLength) {
                    start = left;
                    end = right;
                    minLength = Math.min(minLength, right - left + 1);
                }
            }

            while (wanted.isEmpty()) {
                var leftCh = s.charAt(left);
                var currLeftChCount = currCharCount.compute(leftCh, (k, v) -> v - 1);
                left++;

                if (currLeftChCount < targetCharCount.getOrDefault(leftCh, 0)) {
                    wanted.add(leftCh);
                } else if (right - left + 1 < minLength) {
                    start = left;
                    end = right;
                    minLength = Math.min(minLength, right - left + 1);
                }
            }

            right++;
        }


        return start != -1 ? s.substring(start, end + 1) : "";
    }

}
