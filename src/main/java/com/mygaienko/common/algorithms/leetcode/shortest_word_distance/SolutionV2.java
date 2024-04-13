package com.mygaienko.common.algorithms.leetcode.shortest_word_distance;

import java.util.ArrayList;

class SolutionV2 {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        var indexesOne = new ArrayList<Integer>();
        var indexesTwo = new ArrayList<Integer>();

        for (int i = 0; i < wordsDict.length; i++) {
            var next = wordsDict[i];

            if (next.equals(word1)) {
                indexesOne.add(i);
            }

            if (next.equals(word2)) {
                indexesTwo.add(i);
            }
        }

        var min = Integer.MAX_VALUE;

        for (var indexOne : indexesOne) {
            for (var indexTwo : indexesTwo) {
                var dist = Math.abs(indexOne - indexTwo);
                min = Math.min(min, dist);
            }
        }

        return min;
    }
}
