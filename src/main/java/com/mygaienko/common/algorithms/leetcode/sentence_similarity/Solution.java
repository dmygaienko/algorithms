package com.mygaienko.common.algorithms.leetcode.sentence_similarity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) return false;

        var pairs = new HashMap<String, Set<String>>();
        for (var similarPair : similarPairs) {
            var from = similarPair.get(0);
            var to = similarPair.get(1);
            pairs.computeIfAbsent(from, v -> new HashSet<>()).add(to);
            pairs.computeIfAbsent(to, v -> new HashSet<>()).add(from);
        }

        for (int i = 0; i < sentence1.length; i++) {
            var string1 = sentence1[i];
            var string2 = sentence2[i];

            if (string1.equals(string2)) {
                continue;
            } else if (pairs.containsKey(string1) && pairs.get(string1).contains(string2)) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }
}
