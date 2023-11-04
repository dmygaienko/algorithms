package com.mygaienko.common.algorithms.leetcode.maximize_the_confusion_of_an_exam;

import java.util.HashMap;

class Solution {

    private static final char TRUE = 'T';
    private static final char FALSE = 'F';

    public int maxConsecutiveAnswers(String answerKey, int k) {
        var left = k;
        var right = answerKey.length();

        var max = 0;
        while (left <= right) {
            var mid = left + (right - left) / 2;

            if (isValid(answerKey, mid, k)) {
                left = mid + 1;
                max = mid;
            } else {
                right = mid - 1;
            }
        }
        return max;
    }

    private boolean isValid(String answerKey, int size, int k) {
        var charCounts = new HashMap<Character, Integer>();
        for (int i = 0; i < size; i++) {
            var ch = answerKey.charAt(i);
            charCounts.compute(ch, (key, v) -> v == null ? 1 : v + 1);
        }

        if (Math.min(charCounts.getOrDefault(TRUE, 0), charCounts.getOrDefault(FALSE, 0)) <= k) {
            return true;
        }

        for (int i = size; i < answerKey.length(); i++) {
            var rightCh = answerKey.charAt(i);
            charCounts.compute(rightCh, (key, v) -> v == null ? 1 : v + 1);
            var leftCh = answerKey.charAt(i - size);
            charCounts.compute(leftCh, (key, v) -> v == null ? 0 : v - 1);

            if (Math.min(charCounts.getOrDefault(TRUE, 0), charCounts.getOrDefault(FALSE, 0)) <= k) {
                return true;
            }
        }

        return false;
    }

}