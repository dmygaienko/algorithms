package com.mygaienko.common.algorithms.leetcode.the_maze_ii;

import java.util.Arrays;

class SolutionV2 {

    int[][] DIRS = new int[][]{
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        var distances = new int[maze.length][maze[0].length];
        for (var row : distances) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        distances[start[0]][start[1]] = 0;

        dfs(maze, distances, start[0], start[1]);

        return distances[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distances[destination[0]][destination[1]];
    }

    private void dfs(int[][] maze, int[][] distances, int currX, int currY) {
        for (var dir : DIRS) {
            var nextX = currX;
            var nextY = currY;

            var count = 0;
            while (nextX + dir[0] >= 0 && nextX + dir[0] < maze.length &&
                    nextY + dir[1] >= 0 && nextY + dir[1] < maze[0].length) {
                if (maze[nextX + dir[0]][nextY + dir[1]] == 0) {
                    count++;
                    nextX += dir[0];
                    nextY += dir[1];
                } else {
                    break;
                }
            }

            if (count > 0 && distances[currX][currY] + count < distances[nextX][nextY]) {
                distances[nextX][nextY] = distances[currX][currY] + count;
                dfs(maze, distances, nextX, nextY);
            }
        }
    }

}