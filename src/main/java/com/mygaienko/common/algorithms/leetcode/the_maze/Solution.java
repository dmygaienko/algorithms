package com.mygaienko.common.algorithms.leetcode.the_maze;

import java.util.ArrayDeque;

class Solution {

    int[][] DIRS = new int[][]{
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };

    // 0,3  1,3  1,0  2,0  2,2  4,2   4,4
    // use bread first appoarch
    // add initial point to the queue
    // from current point check all available direction 
    // and reach the wall and put back to the queue
    // until point is already visited
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        var queue = new ArrayDeque<int[]>();
        queue.add(start);

        while (!queue.isEmpty()) {
            var curr = queue.poll();
            var x = curr[0];
            var y = curr[1];

            if (x == destination[0] && y == destination[1]) {
                return true;
            }

            if (maze[x][y] == -1) continue;
            maze[x][y] = -1;

            for (var dir : DIRS) {
                var nextX = x + dir[0];
                var nextY = y + dir[1];

                while (nextX >= 0 && nextX < maze.length
                        && nextY >= 0 && nextY < maze[0].length) {

                    if (maze[nextX][nextY] == 0 || maze[nextX][nextY] == -1) {
                        nextX = nextX + dir[0];
                        nextY = nextY + dir[1];
                    }

                    if (nextX < 0 || nextX >= maze.length ||
                            nextY < 0 || nextY >= maze[0].length ||
                            maze[nextX][nextY] == 1) {

                        nextX = nextX - dir[0];
                        nextY = nextY - dir[1];

                        if (maze[nextX][nextY] != -1) {
                            queue.offer(new int[]{nextX, nextY});
                        }
                        break;
                    }
                }
            }
        }

        return false;
    }

}