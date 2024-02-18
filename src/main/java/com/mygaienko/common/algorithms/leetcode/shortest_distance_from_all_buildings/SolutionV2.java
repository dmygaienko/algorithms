package com.mygaienko.common.algorithms.leetcode.shortest_distance_from_all_buildings;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class SolutionV2 {

    int[][] DIRS = new int[][]{
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };

    //iterate over grid and find all friends

    //for each zero cell M*N
    //for each friend M*N
    //find shortest distance with BFS + seen M*N
    //M*N ^ 3

    // [0,0,0,0,0],
    // [1,0,0,0,0],
    // [0,0,0,0,1]
    //
    //
    public int shortestDistance(int[][] grid) {
        var friends = new ArrayList<int[]>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    friends.add(new int[]{i, j});
                }
            }
        }

        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    var currDistance = find(grid, friends, i, j);
                    minDistance = Math.min(minDistance, currDistance);
                }
            }
        }

        return minDistance != Integer.MAX_VALUE ? minDistance : -1;
    }

    int find(int[][] grid, List<int[]> friends, int i, int j) {
        var sum = 0;
        var count = 0;

        var seen = new boolean[grid.length][grid[0].length];
        var queue = new ArrayDeque<int[]>();
        queue.add(new int[]{i, j, 0});

        while (!queue.isEmpty()) {
            var next = queue.poll();

            for (var dir : DIRS) {
                var nextI = next[0] + dir[0];
                var nextJ = next[1] + dir[1];

                if (isValid(nextI, grid.length) && isValid(nextJ, grid[0].length) && !seen[nextI][nextJ]) {
                    seen[nextI][nextJ] = true;

                    if (grid[nextI][nextJ] == 1) {
                        sum += next[2] + 1;
                        count++;
                        if (count == friends.size()) {
                            break;
                        }
                    } else if (grid[nextI][nextJ] == 0) {
                        queue.offer(new int[]{nextI, nextJ, next[2] + 1});
                    }
                }
            }
        }

        return count == friends.size() ? sum : Integer.MAX_VALUE;
    }

    boolean isValid(int a, int length) {
        return a >= 0 && a < length;
    }

}
