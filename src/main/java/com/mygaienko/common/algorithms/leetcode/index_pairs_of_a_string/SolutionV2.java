package com.mygaienko.common.algorithms.leetcode.index_pairs_of_a_string;

import java.util.ArrayList;
import java.util.HashSet;

class SolutionV2 {
    public int[][] indexPairs(String text, String[] words) {
        var unique = new HashSet<String>();
        for (var word : words) {
            unique.add(word);
        }

        var result = new ArrayList<int[]>();
        for (int i = 0; i < text.length(); i++) {
            for (int j = i; j < text.length(); j++) {
                var subStr = text.substring(i, j + 1);
                if (unique.contains(subStr)) {
                    result.add(new int[]{i, j});
                }
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}