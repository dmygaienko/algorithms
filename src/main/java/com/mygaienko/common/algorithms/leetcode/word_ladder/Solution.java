package com.mygaienko.common.algorithms.leetcode.word_ladder;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int beginIndex = findIndex(beginWord, wordList);
        int endIndex = findIndex(endWord, wordList);
        if (endIndex == -1) return 0;
        if (beginIndex == endIndex) return 0;

        Map<String, Integer> ladderLength = new HashMap<>();
        ladderLength.put(beginWord, 1);

        PriorityQueue<Result> queue = new PriorityQueue<>(Comparator.comparingInt(Result::getLength)
                .thenComparing(Comparator.comparingInt(Result::getIndex).reversed()));
        queue.offer(new Result(beginWord, beginIndex, 1));

        while (!queue.isEmpty()) {
            Result result = queue.poll();
            String word = result.word;
            int length = Math.min(result.length, ladderLength.getOrDefault(word, Integer.MAX_VALUE));

            for (int i = 0; i < wordList.size(); i++) {
                String next = wordList.get(i);
                int diff = compare(word, next);
                if (diff == 1 && ladderLength.getOrDefault(next, Integer.MAX_VALUE) > length + 1) {
                    int nextLength = length + 1;
                    queue.add(new Result(next, i, nextLength));
                    ladderLength.put(next, nextLength);
                }
            }
        }

        return ladderLength.getOrDefault(endWord, -1);
    }

    private int compare(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            char aCh = a.charAt(i);
            char bCh = b.charAt(i);
            if (aCh != bCh) {
                diff++;
                if (diff > 1) return diff;
            }
        }
        return diff;
    }

    private int findIndex(String endWord, List<String> wordList) {
        for (int i = 0; i < wordList.size(); i++) {
            String s = wordList.get(i);
            if (s.equals(endWord)) return i;
        }
        return -1;
    }

    static class Result {
        final String word;
        final int index;
        final int length;

        public Result(String val, int index, int length) {
            this.word = val;
            this.index = index;
            this.length = length;
        }

        public String getWord() {
            return word;
        }

        public int getIndex() {
            return index;
        }

        public int getLength() {
            return length;
        }
    }
}
