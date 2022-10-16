package com.mygaienko.common.algorithms.leetcode.shortest_word_distance_ii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class WordDistance {

    private final Map<String, List<Integer>> positions;

    public WordDistance(String[] wordsDict) {
        positions = new HashMap<>();
        for (int i = 0; i < wordsDict.length; i++) {
            String next = wordsDict[i];
            positions.putIfAbsent(next, new ArrayList<>());
            positions.get(next).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> positions1 = positions.get(word1);
        List<Integer> positions2 = positions.get(word2);

        int shortest = Integer.MAX_VALUE;
        for (Integer position1 : positions1) {
            for (Integer position2 : positions1) {
                int localShortest = Math.max(position1, position2) - Math.min(position1, position2);
                shortest = Math.min(shortest, localShortest);
            }
        }
        return shortest;
    }

}
