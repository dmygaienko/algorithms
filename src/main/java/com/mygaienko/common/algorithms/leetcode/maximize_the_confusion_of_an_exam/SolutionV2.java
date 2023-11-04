package com.mygaienko.common.algorithms.leetcode.maximize_the_confusion_of_an_exam;

import java.util.BitSet;

class SolutionV2 {

    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(
                maxConsecutiveAnswers(answerKey, k, 'T'),
                maxConsecutiveAnswers(answerKey, k, 'F')
        );
    }

    // increment right till k > 0 OR consequence is growing
    // or increment left
    public int maxConsecutiveAnswers(String answerKey, int k, char modeChar) {
        if (answerKey.length() == 1) return 1;
        var max = 0; var left = 0; var right = 0; var currK = 0;
        var transformed = new BitSet(answerKey.length());
        var sb = new StringBuilder(answerKey);
        while (right < sb.length() && left <= right) {
            var curr = sb.charAt(right);
            if (right + 1 < sb.length()) {
                var next = sb.charAt(right + 1);
                if (curr != next || curr != modeChar) {
                    if (currK < k) {
                        var indexToReplace = curr != modeChar ? right : right + 1;
                        replace(sb, indexToReplace, modeChar);
                        transformed.set(indexToReplace);
                        currK++; right++;
                    } else {
                        if (transformed.get(left)) {
                            transformed.set(left, false);
                            replace(sb, left, modeChar == 'F' ? 'T' : 'F');
                            currK--;
                            left++;
                            if (left > right) right++;
                        } else {
                            left++;
                            if (left > right) right++;
                        }
                    }
                } else if (curr == next && curr == modeChar){
                    right++;
                } else if (sb.charAt(left) != modeChar){
                    left++; right++;
                }
            } else {
                break;
            }
            max = Math.max(max, right - left + 1);
        }

        return max;
    }

    private void replace(StringBuilder sb, int i, char replaceChar) {
        sb.setCharAt(i, replaceChar);
    }
}