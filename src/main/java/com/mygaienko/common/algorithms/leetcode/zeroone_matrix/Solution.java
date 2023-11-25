package com.mygaienko.common.algorithms.leetcode.zeroone_matrix;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class Solution {

    int[][] DIRS = new int[][]{
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };

    // iterate over matrix
    // if value equals zero put zero to new matrix in corespondent cell
    // else visit BFS every cell and find nearest zero
    public int[][] updateMatrix(int[][] mat) {
        var lengthMat = new int[mat.length][mat[0].length];
        Arrays.stream(lengthMat).forEach(arr -> Arrays.fill(arr, Integer.MAX_VALUE));
        var dependenciesCount = new HashMap<Pair<Integer, Integer>, Integer>();
        var dependencyMap = new HashMap<Pair<Integer, Integer>, Set<Pair<Integer, Integer>>>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                var cell = mat[i][j];
                if (cell == 0) {
                    lengthMat[i][j] = 0;
                } else {
                    var key = Pair.of(i, j);
                    dependenciesCount.put(key, 0);
                    for (var dir : DIRS) {
                        int nextI = i + dir[0];
                        int nextJ = j + dir[1];
                        if (nextI >= 0 && nextI < mat.length && nextJ >= 0 && nextJ < mat[0].length) {
                            if (mat[nextI][nextJ] == 1) {
                                var neighKey = Pair.of(nextI, nextJ);
                                dependenciesCount.compute(key, (k, v) -> v == null ? 1 : v + 1);
                                dependencyMap.computeIfAbsent(neighKey, v -> new HashSet<>()).add(key);
                            }
                        } else {
//                            dependenciesCount.compute(key, (k, v) -> v == null ? 1 : v + 1);
                        }
                    }
                }
            }
        }

        var queue = new PriorityQueue<Pair<Integer, Integer>>(Comparator.comparingInt(dependenciesCount::get));
        var retryList = new ArrayList<Pair<Integer, Integer>>();
        for (var entry : dependenciesCount.entrySet()) {
            queue.offer(entry.getKey());
        }

        while (!queue.isEmpty()) {
            var nextPair = queue.poll();
            var i = nextPair.getKey();
            var j = nextPair.getValue();

            var min = Integer.MAX_VALUE;
            for (var dir : DIRS) {
                int nextI = i + dir[0];
                int nextJ = j + dir[1];

                if (nextI >= 0 && nextI < mat.length && nextJ >= 0 && nextJ < mat[0].length && lengthMat[nextI][nextJ] != Integer.MAX_VALUE) {
                    min = Math.min(min, lengthMat[nextI][nextJ] + 1);
                }
            }

            for (var dir : DIRS) {
                int nextI = i + dir[0];
                int nextJ = j + dir[1];

                if (nextI >= 0 && nextI < mat.length && nextJ >= 0 && nextJ < mat[0].length && lengthMat[nextI][nextJ] != Integer.MAX_VALUE) {
                    if (lengthMat[nextI][nextJ] > min + 1) {
                        queue.offer(Pair.of(nextI, nextJ));
                    }
                }
            }

            if (min != Integer.MAX_VALUE) {
                lengthMat[i][j] = min;
                var dependents = dependencyMap.getOrDefault(nextPair, Set.of());
                for (var dep : dependents) {
                    dependenciesCount.compute(dep, (k, v) -> v - 1);
                }
            } else {
                retryList.add(nextPair);
            }

            if (queue.isEmpty() && !retryList.isEmpty()) {
                retryList.forEach(queue::offer);
                retryList.clear();
            }

        }

        return lengthMat;
    }

}
