package com.mygaienko.common.algorithms.leetcode.shortest_path_to_get_food;

import java.util.ArrayDeque;

class Solution {

    private int[][] dirs = new int[][]{
            {-1, 0}, {0, 1}, {1, 0}, {0, -1}
    };

    public int getFood(char[][] grid) {
        var location = getLocation(grid);
        var visited = new boolean[grid.length][grid[0].length];

        var queue = new ArrayDeque<int[]>();
        queue.offer(new int[]{location[0], location[1]});
        visited[location[0]][location[1]] = true;

        var steps = 0;
        while (!queue.isEmpty()) {
            var queueSize = queue.size();

            while (queueSize > 0) {
                queueSize--;
                var next = queue.poll();

                var cell = grid[next[0]][next[1]];
                if (cell == '#') {
                    return steps;
                } else if (cell == 'X') {
                    continue;
                }

                for (var dir : dirs) {
                    var nextX = next[0] + dir[0];
                    var nextY = next[1] + dir[1];

                    if (nextX >= 0 && nextX < grid.length &&
                            nextY >= 0 && nextY < grid[0].length &&
                            grid[nextX][nextY] != 'X' && !visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        queue.offer(new int[]{nextX, nextY});
                    }
                }
            }

            steps++;
        }

        return -1;
    }

    private int[] getLocation(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                var cell = grid[i][j];

                if (cell == '*') {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

}