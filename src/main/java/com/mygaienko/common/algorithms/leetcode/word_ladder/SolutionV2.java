package com.mygaienko.common.algorithms.leetcode.word_ladder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * breadth first with pre-processing
 */
class SolutionV2 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList = new ArrayList<>(wordList);
        wordList.add(beginWord);

        int beginIndex = findIndex(beginWord, wordList);
        int endIndex = findIndex(endWord, wordList);
        if (endIndex == -1) return 0;
        if (beginIndex == endIndex) return 0;

        Map<String, Integer> ladderLength = new HashMap<>();
        ladderLength.put(beginWord, 1);

        Map<String, List<String>> adj = new HashMap<>();
        for (String s : wordList) {
            List<String> strings = adj.computeIfAbsent(s, v -> new ArrayList<>());
            for (String s1 : wordList) {
                int diff = compare(s, s1);
                if (diff == 1) strings.add(s1);
            }
        }

        PriorityQueue<Result> queue = new PriorityQueue<>(Comparator.comparingInt(Result::getLength));
        queue.offer(new Result(beginWord, 1));

        while (!queue.isEmpty()) {
            Result result = queue.poll();
            String word = result.word;
            int length = Math.min(result.length, ladderLength.getOrDefault(word, Integer.MAX_VALUE));

            List<String> strings = adj.getOrDefault(word, new ArrayList<>());

            for (String next : strings) {
                if (ladderLength.getOrDefault(next, Integer.MAX_VALUE) > length + 1) {
                    int nextLength = length + 1;
                    queue.add(new Result(next, nextLength));
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
        final int length;

        public Result(String val, int length) {
            this.word = val;
            this.length = length;
        }

        public String getWord() {
            return word;
        }

        public int getLength() {
            return length;
        }
    }
}
