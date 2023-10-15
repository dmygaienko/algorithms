package com.mygaienko.common.algorithms.leetcode.shortest_bridge;

import java.util.ArrayDeque;

// iterate over grid
// find island
// mark island cell and all neighbours
// start to find next island with DFS and increment length
class Solution {

    int WATER = 0;
    int ISLAND = 1;
    int MARKED = 2;

    int[][] DIRS = new int[][] {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };

    public int shortestBridge(int[][] grid) {
        int shortest = Integer.MAX_VALUE;
        var queue = new ArrayDeque<int[]>();

        for (int i = 0; i < grid.length; i++) {
            boolean marked = false;
            for (int j = 0; j < grid[i].length; j++) {
                var cell = grid[i][j];
                if (cell == ISLAND) {
                    markIsland(grid, i, j, queue);
                    marked = true;
                    break;
                }
            }
            if (marked) break;
        }

        while (!queue.isEmpty()) {
            var next = queue.poll();
            if (next[2] > shortest) continue;

            int i = next[0];
            int j = next[1];

            grid[i][j] = Math.max(grid[i][j], -next[2]);

            for (var dir : DIRS) {
                var nextI = i + dir[0];
                var nextJ = j + dir[1];
                if (0 <= nextI && nextI < grid.length && 0 <= nextJ && nextJ < grid[0].length) {
                    var cell = grid[nextI][nextJ];
                    var length = next[2] + 1;
                    if (cell == ISLAND) {
                        shortest = Math.min(shortest, next[2]);
                    } else if (cell <= WATER && length < shortest && (cell == WATER || Math.abs(cell) > length)) {
                        grid[nextI][nextJ] = -length;
                        queue.offer(new int[] {nextI, nextJ, length});
                    }
                }
            }
        }
        return shortest;
    }

    private void markIsland(int[][] grid, int i, int j, ArrayDeque<int[]> queue) {
        grid[i][j] = MARKED;

        var found = 0;
        for (var dir : DIRS) {
            var nextI = i + dir[0];
            var nextJ = j + dir[1];
            if (0 <= nextI && nextI < grid.length && 0 <= nextJ && nextJ < grid[0].length) {
                var cell = grid[nextI][nextJ];
                if (cell == ISLAND) {
                    found++;
                    markIsland(grid, nextI, nextJ, queue);
                }
            }
        }

        if (found < 4) {
            queue.add(new int[] {i, j, 0});
        }
    }

}
