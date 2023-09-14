package com.mygaienko.common.algorithms.leetcode.remove_all_ones_with_row_and_column_flips_ii;

/**
 * nice solution
 * DFS + backtracking
 */
class SolutionV2 {

    public int removeOnes(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int minFlips = Integer.MAX_VALUE;

        int[] rowValues = new int[cols];
        int[] colValues = new int[rows];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 0) {
                    continue;
                }
                // Remove & Preserve the column values
                for (int r = 0; r < rows; r++) {
                    colValues[r] = grid[r][col];
                    grid[r][col] = 0;
                }
                // Remove & Preserve the row values
                for (int c = 0; c < cols; c++) {
                    rowValues[c] = grid[row][c];
                    grid[row][c] = 0;
                }
                // Recurse
                minFlips = Math.min(minFlips, (1 + removeOnes(grid)));

                // Backtrack
                // Since we preserved the row values later, so we but them back first
                for (int c = 0; c < cols; c++) {
                    grid[row][c] = rowValues[c];
                }
                // Since we preserved the col values first, so we put them back later
                for (int r = 0; r < rows; r++) {
                    grid[r][col] = colValues[r];
                }
            }
        }
        return ((minFlips == Integer.MAX_VALUE) ? 0 : minFlips);
    }
}
