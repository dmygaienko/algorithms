package com.mygaienko.common.algorithms.leetcode.longest_palindromic_substring;

import java.util.ArrayDeque;

class SolutionWidthSearch {

    public String longestPalindrome(String s) {

        ArrayDeque<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            queue.offer(new int[]{i, 1});
        }

        int start = Integer.MIN_VALUE;
        int maxSize = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {

            int[] next = queue.poll();
            int nextStart = next[0];
            int nextSize = next[1];

            if (nextSize > maxSize) {
                maxSize = nextSize;
                start = nextStart;
            }

            if (nextStart > 0 && nextStart + nextSize < s.length() && s.charAt(nextStart-1) == s.charAt(nextStart + nextSize)) {
                queue.offer(new int[] {nextStart-1, nextSize + 2});
            }

            if (nextSize == 1) {
                if (nextStart > 0 && s.charAt(nextStart-1) == s.charAt(nextStart)) {
                    queue.offer(new int[] {nextStart-1, nextSize + 1});
                } else if (nextStart + 1 < s.length() && s.charAt(nextStart + 1) == s.charAt(nextStart)){
                    queue.offer(new int[] {nextStart, nextSize + 1});
                }
            }

        }

        return s.substring(start, start + maxSize);
    }

}
