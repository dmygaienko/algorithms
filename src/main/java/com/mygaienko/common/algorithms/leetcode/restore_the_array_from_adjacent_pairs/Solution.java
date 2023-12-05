package com.mygaienko.common.algorithms.leetcode.restore_the_array_from_adjacent_pairs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

class Solution {

    public int[] restoreArray(int[][] adjacentPairs) {
        var adjMap = new HashMap<Integer, Collection<Integer>>();

        for (int i = 0; i < adjacentPairs.length; i++) {
            var pair = adjacentPairs[i];
            adjMap.computeIfAbsent(pair[0], v -> new ArrayList<>()).add(pair[1]);
            adjMap.computeIfAbsent(pair[1], v -> new ArrayList<>()).add(pair[0]);
        }

        var iterator = adjMap.entrySet().iterator();
        var minLength = Integer.MAX_VALUE;
        var minLengthKey = 0;
        while (iterator.hasNext()) {
            var next = iterator.next();
            if (next.getValue().size() < minLength) {
                minLength = next.getValue().size();
                minLengthKey = next.getKey();
            }
        }

        var visited = new HashSet<>();
        var arr = new int[adjacentPairs.length + 1];
        arr[0] = minLengthKey;
        visited.add(minLengthKey);

        for (int i = 1; i < arr.length; i++) {
            var prevKey = arr[i - 1];
            var neighs = adjMap.get(prevKey);
            for (var nextKey : neighs) {
                if (!visited.contains(nextKey)) {
                    arr[i] = nextKey;
                    visited.add(nextKey);
                    break;
                }
            }
        }

        return arr;
    }
}
