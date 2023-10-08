package com.mygaienko.common.algorithms.leetcode.minimum_deletions_to_make_character_frequencies_unique;

import java.util.ArrayDeque;
import java.util.HashMap;

class Solution {

    // aaabbbcc

    // 1) count chars frequency (N)
    // a = 3
    // b = 3
    // c = 2

    // 2) find with the same frequency (N)
    // 3 = a, b
    // 2 = c

    // 3) find minimal free frequency next less then existing N * N
    // add to queue

    // alt
    // add to tree
    // charsCount DECR -> freq DECR
    // 2 : 3
    // 1 : 2
    // 0 : 1

    // alt
    // build from 0 to maxFreq: tree of freq with zero count
    public int minDeletions(String s) {
        var charFrequences = new int[26];

        for (int i = 0; i < s.length(); i++) {
            var ch = s.charAt(i);
            charFrequences[ch-'a'] += 1;
        }

        var frequenciesCount = new HashMap<Integer, Integer>();
        for (var frequency : charFrequences) {
            if (frequency > 0) {
                frequenciesCount.compute(frequency, (k, v) -> v == null ? 1 : v + 1);
            }
        }

        var queue = new ArrayDeque<Integer>();
        for (var entry : frequenciesCount.entrySet()) {
            if (entry.getValue() > 1) {
                queue.offer(entry.getKey());
            }
        }

        var count = 0;
        while (!queue.isEmpty()) {
            var frequency = queue.poll();

            var frequencyCount = frequenciesCount.get(frequency);
            while (frequencyCount > 1) {
                var prevFrequency = frequency - 1;
                while (prevFrequency >= 0 && frequenciesCount.getOrDefault(prevFrequency, 0) > 0) {
                    prevFrequency = prevFrequency - 1;
                }

                if (prevFrequency > 0) {
                    count += frequency - prevFrequency;
                    frequenciesCount.put(prevFrequency, 1);
                } else {
                    count += frequency;
                }
                frequencyCount--;
            }
            frequenciesCount.put(frequency, 1);
        }

        return count;
    }

}
