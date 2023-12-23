package com.mygaienko.common.algorithms.leetcode.minimum_window_substring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class SolutionV3 {

    public String minWindow(String s, String t) {
        char[] chars = s.toCharArray();

        Map<Character, Integer> wantedChars = new HashMap<>();
        for (char ch : t.toCharArray()) {
            wantedChars.compute(ch, (k, v) -> v == null ? 1 : v + 1);
        }

        Map<Character, List<Integer>> charIndexes = new HashMap<>();
        List<CharIndex> wantedCharsQueue = new ArrayList<>(chars.length);

        int initialCapacity = chars.length / (wantedChars.size() != 0 ? wantedChars.size() : 1);
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];

            List<Integer> indexes = charIndexes.computeIfAbsent(ch, (v) -> new ArrayList<>(initialCapacity));
            indexes.add(i);

            if (wantedChars.containsKey(ch)) {
                wantedCharsQueue.add(new CharIndex(ch, i));
            }
        }

        int minLengthStartI = 0;
        int minLengthEndI = Integer.MAX_VALUE;

        int start = 0;
        int end = 0;

        while (start < wantedCharsQueue.size() && end < wantedCharsQueue.size()) {
            int startI = wantedCharsQueue.get(start).i;
            int endI = wantedCharsQueue.get(end).i;

            if (end - start + 1 >= t.length() && containsAll(startI, endI, charIndexes, wantedChars)) {

                if (endI - startI < minLengthEndI - minLengthStartI) {
                    minLengthStartI = startI;
                    minLengthEndI = endI;
                }

                start++;
            } else {
                end++;
            }
        }

        return minLengthEndI == Integer.MAX_VALUE ? "" : s.substring(minLengthStartI, minLengthEndI + 1);
    }

    private boolean containsAll(int start, int end,
                                Map<Character, List<Integer>> charIndexes,
                                Map<Character, Integer> wantedChars) {

        for (Entry<Character, Integer> entry : wantedChars.entrySet()) {
            Character ch = entry.getKey();
            Integer amount = entry.getValue();

            List<Integer> indexes = charIndexes.get(ch);

            if (indexes == null) {
                if (amount > 0) {
                    return false;
                } else {
                    continue;
                }
            }

            int startI = findBinary(start, indexes, true);
            int endI = findBinary(end, indexes, false);

            if (startI == Integer.MIN_VALUE || endI == Integer.MIN_VALUE) {
                return false;
            }

            int found = endI - startI + 1;

            amount = amount - found;

            if (amount > 0) {
                return false;
            }
        }

        return true;
    }

    private int findBinary(int border, List<Integer> indexes, boolean isStart) {

        int left = 0;
        int right = indexes.size() - 1;

        int half = Integer.MIN_VALUE;
        while (left <= right) {
            int currentHalf = left + (right + 1 - left) / 2;

            Integer i = indexes.get(currentHalf);

            if (half == currentHalf) {
                if (right == left &&
                        (i > border && !isStart) ||
                        (i < border && isStart)) return Integer.MIN_VALUE;
                return isStart ? right : left;
            }

            half = currentHalf;

            if (i == border) {
                return half;
            } else if (i > border) {
                int nextRight = half > 0 ? half - 1 : half;
                if (right == nextRight && !isStart) {  // i is greater than border, but border is end
                    return Integer.MIN_VALUE;
                }
                right = nextRight;
            } else {// i < border
                int nextLeft = half < indexes.size() - 1 ? half + 1 : half;
                if (left == nextLeft && isStart) { // i is less than border, but border is start
                    return Integer.MIN_VALUE;
                }
                left = nextLeft;
            }
        }

        return isStart ? Math.max(left, right) : Math.min(left, right);
    }

    static class CharIndex {
        final char ch;
        final int i;

        public CharIndex(char ch, int i) {
            this.ch = ch;
            this.i = i;
        }
    }

}
