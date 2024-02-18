package com.mygaienko.common.algorithms.leetcode.shortest_distance_from_all_buildings;

import java.util.ArrayDeque;

class Solution {

    int[][] DIRS = new int[][]{
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };

    public int shortestDistance(int[][] grid) {
        var friendsCount = 0;

        var countSum = new int[grid.length][grid[0].length][2];

        var currEmptyCell = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    friendsCount++;

                    var queue = new ArrayDeque<int[]>();
                    queue.add(new int[]{row, col, 0});

                    int step = 1;
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        while (size > 0) {
                            var next = queue.poll();

                            for (var dir : DIRS) {
                                var nextRow = next[0] + dir[0];
                                var nextCol = next[1] + dir[1];

                                if (isValid(nextRow, grid.length) && isValid(nextCol, grid[0].length)
                                        && grid[nextRow][nextCol] == currEmptyCell) {
                                    queue.add(new int[]{nextRow, nextCol});
                                    countSum[nextRow][nextCol][0]++;
                                    countSum[nextRow][nextCol][1] += step;
                                    grid[nextRow][nextCol]--;
                                }
                            }
                            size--;
                        }
                        step++;
                    }

                    currEmptyCell--;
                }
            }
        }

        int minDistance = Integer.MAX_VALUE;
        for (int row = 0; row < countSum.length; row++) {
            for (int col = 0; col < countSum[0].length; col++) {
                var cell = countSum[row][col];
                if (cell[0] == friendsCount) {
                    minDistance = Math.min(minDistance, cell[1]);
                }
            }
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    boolean isValid(int a, int length) {
        return a >= 0 && a < length;
    }

}
