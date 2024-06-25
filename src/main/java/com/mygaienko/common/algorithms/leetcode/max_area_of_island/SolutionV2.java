package com.mygaienko.common.algorithms.leetcode.max_area_of_island;

import java.util.ArrayDeque;

public class SolutionV2 {
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int maxAreaOfIsland(int[][] grid) {
        var maxArea = 0;
        var seen = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1 && !seen[i][j]) {
                    seen[i][j] = true;
                    var area = 1;
                    var stack = new ArrayDeque<int[]>();
                    stack.push(new int[]{i, j});

                    while (!stack.isEmpty()) {
                        var next = stack.pop();

                        for (var dir : dirs) {
                            var nextI = next[0] + dir[0];
                            var nextJ = next[1] + dir[1];

                            if (nextI >= 0 && nextI < grid.length &&
                                    nextJ >= 0 && nextJ < grid[0].length &&
                                    grid[nextI][nextJ] == 1 && !seen[nextI][nextJ]) {
                                stack.push(new int[]{nextI, nextJ});
                                area++;
                                seen[nextI][nextJ] = true;
                            }
                        }
                    }

                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }
}
