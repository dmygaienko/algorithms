package com.mygaienko.common.algorithms.leetcode.remove_all_ones_with_row_and_column_flips;

class Solution {

    //  Solution 1
    //  iterate over grid
    //  if find 1 then discover if entire row is 1
    //  or entire column (prefer flip entire ones, or entire and bigger by cells)
    //  if exist any island of 1 which occupies not entire row, then answer - no.

    //
    //  Solution 2
    //  put first cell to the queue
    //  discover whether 1 if yes then analyze optimal (same as in S.1)
    //  put neighbour cell to the queue. mark reached cell with special integer.
    public boolean removeOnes(int[][] grid) {
        int V = grid.length;
        int H = grid[0].length;

        int oneCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    oneCount++;
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int h = horizontals(grid, i, j);
                    int v = verticals(grid, i, j);

                    if (h == H) {
                        oneCount += flipHorizontals(grid, i);
                    } else if (v == V) {
                        oneCount += flipVerticals(grid, j);
                    } else if (h > v) {
                        oneCount += flipHorizontals(grid, i);
                    } else {
                        oneCount += flipVerticals(grid, j);
                    }

                    if (oneCount == 0) return true;
                }
            }
        }

        return oneCount == 0;
    }

    private int horizontals(int[][] grid, int i, int jj) {
        int horizontals = 0;
        for (int j = 0; j < grid[i].length; j++) {
            if (grid[i][j] == 1) horizontals++;
        }
        return horizontals;
    }

    private int verticals(int[][] grid, int ii, int j) {
        int verticals = 0;
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][j] == 1) verticals++;
        }
        return verticals;
    }

    private int flipHorizontals(int[][] grid, int i) {
        int oneCount = 0;
        for (int j = 0; j < grid[i].length; j++) {
            if (grid[i][j] == 1) {
                grid[i][j] = 0;
                oneCount--;
            } else {
                grid[i][j] = 1;
                oneCount++;
            }
        }
        return oneCount;
    }

    private int flipVerticals(int[][] grid, int j) {
        int oneCount = 0;
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][j] == 1) {
                grid[i][j] = 0;
                oneCount--;
            } else {
                grid[i][j] = 1;
                oneCount++;
            }
        }
        return oneCount;
    }
}
