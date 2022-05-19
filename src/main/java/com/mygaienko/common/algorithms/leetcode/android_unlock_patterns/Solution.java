package com.mygaienko.common.algorithms.leetcode.android_unlock_patterns;

/**
 * dfs, backtracking, memo
 */
class Solution {

    private static final int[][] dirs = new int[][]{
            {-1, 0}, {-1, 1},
            {0, 1}, {1, 1},
            {1, 0}, {1, -1},
            {0, -1}, {-1, -1},
    };

    private static final int[][] gDirs = new int[][]{
            {-2, -1}, {-2, 1},   //      UP-left     UP-right
            {-1, 2}, {1, 2},    //      up-RIGHT    down-RIGHT
            {2, -1}, {2, 1},    //      DOWN-left   DOWN-right
            {-1, -2}, {1, -2}   //      up-LEFT     down-LEFT
    };

    private static final int VISITED = -1;
    private static final int START = 1;

    public int numberOfPatterns(int m, int n) {
        int result = 0;
        int[][] grid = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][][] dp = new int[n + 1][3][3];

        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                result += findPatterns(grid, dp, START, x, y, m, n);
            }
        }
//        for (int x = grid.length - 1; x >= 0; x--) {
//            for (int y = grid[0].length - 1; y >= 0; y--) {
//                result += findPatterns(grid, dp, START, x, y, m, n);
//            }
//        }

        return result;
    }

    private int findPatterns(int[][] grid, int[][][] dp, int i, int x, int y, int from, int to) {
        int result = 0;

        if (!isValid(grid, x, y)) return result;
        if (grid[x][y] == VISITED) return result;
        if (from <= i && i <= to) {
            result = result + 1;
        } else if (i > to){
            return result;
        } else if (dp[i][x][y] != 0) {
            return dp[i][x][y];
        }

        int num = grid[x][y];
        grid[x][y] = VISITED;

        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];

            if (isValid(grid, nextX, nextY) && grid[nextX][nextY] == VISITED) {
                nextX += dir[0];
                nextY += dir[1];
            }
            result += findPatterns(grid, dp, i + 1, nextX, nextY, from, to);
        }

        for (int[] dir : gDirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            result += findPatterns(grid, dp, i + 1, nextX, nextY, from, to);
        }

        grid[x][y] = num; // rollback
        dp[i][x][y] = Math.max(dp[i][x][y], result);
        return result;
    }

    private boolean isValid(int[][] grid, int x, int y) {
        return x >= 0 && x < grid.length &&
                y >= 0 && y < grid[0].length;
    }

}
