package com.mygaienko.common.algorithms.leetcode.find_and_replace_in_string;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 833. Find And Replace in String
 * https://leetcode.com/problems/find-and-replace-in-string/
 */
class Solution {

    /**
     * Input:
     * s = "abcd",
     * indices = [0, 2],
     * sources = ["a", "cd"],
     * targets = ["eee", "ffff"]
     *
     * Output: "eeebffff"
     * Explanation:
     * "a" occurs at index 0 in s, so we replace it with "eee".
     * "cd" occurs at index 2 in s, so we replace it with "ffff".
     */
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        StringBuilder result = new StringBuilder();
        char[] chars = s.toCharArray();

        PriorityQueue<SourceTarget> sourceTargets = initQueue(indices, sources, targets);

        for (int i = 0; i < chars.length; i++) {

            if (!sourceTargets.isEmpty() && sourceTargets.peek().getIndex() == i) {
                SourceTarget sourceTarget = sourceTargets.poll();

                String replaceSubstring = sourceTarget.getSource();

                boolean replace = true;
                int k = 0;
                for (int i1 = i; k < replaceSubstring.length() && i1 < chars.length; k++, i1++) {
                    char replaceChar = replaceSubstring.charAt(k);
                    char initChar = s.charAt(i1);
                    if (replaceChar != initChar) {
                        replace = false;
                    }
                }

                if (replace && k == replaceSubstring.length()) {
                    result.append(sourceTarget.getTarget());
                    i = i + replaceSubstring.length() - 1;
                } else {
                    result.append(chars[i]);
                }
            } else {
                result.append(chars[i]);// if replaceIndex > i then ignore and increase i
            }

        }

        return result.toString();
    }

    private PriorityQueue<SourceTarget> initQueue(int[] indices, String[] sources, String[] targets) {
        PriorityQueue<SourceTarget> q = new PriorityQueue<>(indices.length, Comparator.comparingInt(SourceTarget::getIndex));
        for (int i = 0; i < indices.length; i++) {
            q.offer(new SourceTarget(
                    indices[i],
                    sources[i],
                    targets[i]
            ));
        }
        return q;
    }

    static class SourceTarget {
        int index;
        String source;
        String target;

        public SourceTarget(int index, String source, String target) {
            this.index = index;
            this.source = source;
            this.target = target;
        }

        public int getIndex() {
            return index;
        }

        public String getSource() {
            return source;
        }

        public String getTarget() {
            return target;
        }
    }

}
