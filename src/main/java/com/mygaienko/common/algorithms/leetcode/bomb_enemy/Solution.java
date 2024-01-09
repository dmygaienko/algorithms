package com.mygaienko.common.algorithms.leetcode.bomb_enemy;

/**
 * dynamic programming
 * colHits
 * rowHits
 */
class Solution {

    public int maxKilledEnemies(char[][] grid) {
        var max = 0;

        int rows = grid.length;
        int cols = grid[0].length;

        var colHits = new int[cols];
        var rowHits = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                // reset the hits if new row ( col == 0 ) or right after WALL
                if (col == 0 || grid[row][col - 1] == 'W') {
                    rowHits = 0;

                    for (int k = col; k < cols; k++) {
                        if (grid[row][k] == 'W') {
                            break;
                        } else if (grid[row][k] == 'E') {
                            rowHits++;
                        }
                    }
                }

                // reset the hits if new column ( row == 0 ) or right after WALL
                if (row == 0 || grid[row - 1][col] == 'W') {
                    colHits[col] = 0;

                    for (int r = row; r < rows; r++) {
                        if (grid[r][col] == 'W') {
                            break;
                        } else if (grid[r][col] == 'E') {
                            colHits[col]++;
                        }
                    }
                }

                if (grid[row][col] == '0') {
                    max = Math.max(max, rowHits + colHits[col]);
                }
            }
        }
        return max;
    }

}