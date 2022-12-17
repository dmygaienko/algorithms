package com.mygaienko.common.algorithms.leetcode.number_of_distinct_islands;

import java.util.HashSet;
import java.util.Set;

class Solution {

    private static final int ISLAND = 1;
    private static final int PROCESSED = 2;

    public int numDistinctIslands(int[][] grid) {
        Set<Long> islandsHashes = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == ISLAND) {
                    long hash = process(1, i, j, grid);
                    islandsHashes.add(hash);
                }
            }
        }

        return islandsHashes.size();
    }

    private long process(int sum, int i, int j, int[][] grid) {
        int N = grid.length;
        int M = grid[0].length;

        grid[i][j] = PROCESSED;

        if (j+1 < M && grid[i][j+1] == ISLAND) {
            sum += process(11*sum, i, j+1, grid);
        }

        if (j > 0 && grid[i][j-1] == ISLAND) {
            sum += process(13*sum, i, j-1, grid);
        }

        if (i + 1 < N && grid[i+1][j] == ISLAND) {
            sum += process(17*sum, i+1, j, grid);
        }

        if (i > 0 && grid[i-1][j] == ISLAND) {
            sum += process(19*sum, i - 1, j, grid);
        }

        return sum;
    }

}