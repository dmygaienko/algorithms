package com.mygaienko.common.algorithms.leetcode.sentence_similarity_ii;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {

    // add similarPairs to map of all the similar words
    // for each pair
    // chech whether word1 -> word2 exist in map
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) return false;

        var similarMap = new HashMap<String, Set<String>>();
        for (var pair : similarPairs) {
            var word1 = pair.get(0);
            var word2 = pair.get(1);
            similarMap.computeIfAbsent(word1, v -> new HashSet<>()).add(word2);
            similarMap.computeIfAbsent(word2, v -> new HashSet<>()).add(word1);
        }

        for (int i = 0; i < sentence1.length; i++) {
            var word1 = sentence1[i];
            var word2 = sentence2[i];

            if (word1.equals(word2)) continue;

            var found = find(similarMap, word1, word2, new HashSet<>());
            if (!found) {
                return false;
            }
        }

        return true;
    }

    boolean find(Map<String, Set<String>> similarMap, String from, String to, Set<String> visited) {
        if (visited.contains(from)) return false;
        visited.add(from);

        var similars = similarMap.getOrDefault(from, Set.of());
        if (similars.contains(to)) {
            return true;
        }

        for (var similar : similars) {
            if (!visited.contains(similar)) {
                var found = find(similarMap, similar, to, visited);
                if (found) {
                    return true;
                }
            }
        }

        return false;
    }
}
