package com.mygaienko.common.algorithms.leetcode.path_with_maximum_minimum_value;

// start from the [0][0] point
// add point to the priority queue with descending order
// which computes minimum cardinality of current path + cardinality of point
// return result of cardinality as reach end point

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

    int[][] DIRS = new int[][]{
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };

    public int maximumMinimumPath(int[][] grid) {
        var visited = new boolean[grid.length][grid[0].length];

        var queue = new PriorityQueue<>(Comparator.
                <int[]>comparingInt(arr -> arr[2])
                .reversed());
        queue.offer(new int[]{0, 0, grid[0][0]});

        while (!queue.isEmpty()) {
            var curr = queue.poll();

            if (curr[0] + 1 == grid.length && curr[1] + 1 == grid[0].length) return curr[2];

            for (var dir : DIRS) {
                var nextX = curr[0] + dir[0];
                var nextY = curr[1] + dir[1];

                if (nextX >= 0 && nextX < grid.length && nextY >= 0 && nextY < grid[0].length && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    var nextCardinality = Math.min(curr[2], grid[nextX][nextY]);
                    queue.offer(new int[]{nextX, nextY, nextCardinality});
                }
            }
        }

        return -1;
    }
}