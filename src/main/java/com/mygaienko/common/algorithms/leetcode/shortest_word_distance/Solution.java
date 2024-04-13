package com.mygaienko.common.algorithms.leetcode.shortest_word_distance;

import java.util.ArrayList;

class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {

        var indexOne = -1;
        var indexTwo = -1;
        var minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < wordsDict.length; i++) {
            var next = wordsDict[i];

            if (next.equals(word1)) {
                indexOne = i;
            }

            if (next.equals(word2)) {
                indexTwo = i;
            }

            if (indexOne != -1 && indexTwo != -1) {
                minDistance = Math.min(minDistance, Math.abs(indexOne - indexTwo));
            }
        }

        return minDistance;
    }
}
