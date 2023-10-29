package com.mygaienko.common.algorithms.leetcode.find_the_safest_path_in_a_grid;

import java.util.*;

class Solution {

    int[][] DIRS = new int[][]{
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };

    int THIEF = 1;
    int VISITED_THIEF = -1;
    int VISITED = -2;

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int N = grid.size();
        int M = grid.get(0).size();

        if (grid.get(N-1).get(M-1) == THIEF) return 0;

        var thieves = new ArrayList<int[]>();
        var thievesQueue = new ArrayDeque<int[]>();
        for (int i = 0; i < grid.size(); i++) {
            var row = grid.get(i);
            for (int j = 0; j < row.size(); j++) {
                var next = row.get(j);
                if (next == THIEF) {
                    grid.get(i).set(j, VISITED_THIEF);
                    thieves.add(new int[]{i, j});
                    thievesQueue.offer(new int[]{i, j, 0});
                }
            }
        }

        while (!thievesQueue.isEmpty()) {
            var next = thievesQueue.poll();
            var cell = grid.get(next[0]).get(next[1]);
            var safeFactor = cell == VISITED_THIEF ? 0 : next[2];

            for (var dir : DIRS) {
                var nextI = next[0] + dir[0];
                var nextJ = next[1] + dir[1];

                if (nextI >= 0 && nextI < N && nextJ >= 0 && nextJ < M) {
                    var neighbour = grid.get(nextI).get(nextJ);
                    if (neighbour == 0) {
                        grid.get(nextI).set(nextJ, safeFactor + 1);
                        thievesQueue.offer(new int[]{nextI, nextJ, safeFactor + 1});
                    }
                }
            }
        }

        var maxSafeFactor = -1;
        var queue = new PriorityQueue<>(Comparator.<int[]>comparingInt(arr -> arr[2]).reversed());
        queue.offer(new int[] {0, 0, grid.get(0).get(0)});

        while (!queue.isEmpty()) {
            var next = queue.poll();
            var i = next[0];
            var j = next[1];
            var factor = next[2];

            if (grid.get(i).get(j) == VISITED) continue;
            if (i == N - 1 && j == M - 1) {
                maxSafeFactor = Math.max(maxSafeFactor, factor);
                break;
            }

            grid.get(i).set(j, VISITED);

            for (var dir : DIRS) {
                var nextI = i + dir[0];
                var nextJ = j + dir[1];

                if (nextI >= 0 && nextI < N && nextJ >= 0 && nextJ < M) {
                    var cell = grid.get(nextI).get(nextJ);
                    if (cell == VISITED || cell == VISITED_THIEF) continue;
                    var minFactor = Math.min(factor, cell);
                    queue.offer(new int[]{nextI, nextJ, minFactor});
                }
            }
        }

        return Math.max(0, maxSafeFactor);
    }

}
