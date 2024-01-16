package com.mygaienko.common.algorithms.leetcode.shortest_word_distance_iii;

class Solution {

    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        var min = Integer.MAX_VALUE;
        var prevIndex = -1;
        for (int i = 0; i < wordsDict.length; i++) {
            var next = wordsDict[i];

            if (word1.equals(next)) {
                if (prevIndex != -1 && wordsDict[prevIndex].equals(word2)) {
                    min = Math.min(min, i - prevIndex);
                }
                prevIndex = i;
            } else if (word2.equals(next)) {
                if (prevIndex != -1 && wordsDict[prevIndex].equals(word1)) {
                    min = Math.min(min, i - prevIndex);
                }
                prevIndex = i;
            }
        }
        return min;
    }

}
