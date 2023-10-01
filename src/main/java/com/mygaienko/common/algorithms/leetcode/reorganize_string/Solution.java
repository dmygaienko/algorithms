package com.mygaienko.common.algorithms.leetcode.reorganize_string;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {

    /**
     * iterate over string and count char occurence in map
     * put char with occurence more than 2 to the priority queue
     */
    public String reorganizeString(String s) {

        var charCounts = new int[26];
        for (char c : s.toCharArray()) {
            charCounts[c - 'a']++;
        }

        var queue = new PriorityQueue<>(Comparator.<Pair<Character, Integer>>comparingInt(Pair::getValue).reversed());

        for (int i = 0; i < charCounts.length; i++) {
            var count = charCounts[i];
            if (count == 0) continue;
            char ch = (char) (i + 'a');
            queue.offer(Pair.of(ch, count));
        }

        var sb = new StringBuilder();
        while (queue.size() > 1) {
            var curr = queue.poll();
            var next = queue.poll();

            sb.append(curr.getKey());
            sb.append(next.getKey());

            offerPositive(queue, curr);
            offerPositive(queue, next);
        }

        if (queue.size() == 1 && queue.peek().getValue() == 1) {
            sb.append(queue.poll().getKey());
        }

        return queue.isEmpty() ? sb.toString() : "";
    }

    public void offerPositive(PriorityQueue<Pair<Character, Integer>> queue, Pair<Character, Integer> pair) {
        if (pair.getValue() - 1 != 0) {
            queue.offer(Pair.of(pair.getKey(), pair.getValue() - 1));
        }
    }

}