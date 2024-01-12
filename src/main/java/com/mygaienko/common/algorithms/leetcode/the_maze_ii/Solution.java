package com.mygaienko.common.algorithms.leetcode.the_maze_ii;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

    int[][] DIRS = new int[][]{
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        var queue = new PriorityQueue<int[]>(Comparator.comparingInt(arr -> arr[2]));
        queue.offer(new int[]{start[0], start[1], 0});

        var visited = new boolean[maze.length][maze[0].length];

        var minDistance = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            var next = queue.poll();

            if (next[2] >= minDistance) continue;
            if (visited[next[0]][next[1]]) continue;
            visited[next[0]][next[1]] = true;

            if (next[0] == destination[0] && next[1] == destination[1]) {
                return next[2];
            }

            for (var dir : DIRS) {
                var nextX = next[0];
                var nextY = next[1];
                var step = next[2];

                while (nextX + dir[0] >= 0 && nextX + dir[0] < maze.length
                        && nextY + dir[1] >= 0 && nextY + dir[1] < maze[0].length) {
                    if (maze[nextX + dir[0]][nextY + dir[1]] == 0) {
                        nextX = nextX + dir[0];
                        nextY = nextY + dir[1];
                        step++;
                    } else {
                        break;
                    }
                }

                if (step - next[2] > 0) {
                    if (!visited[nextX][nextY]) {
                        queue.offer(new int[]{nextX, nextY, step});
                    }
                }
            }
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

}