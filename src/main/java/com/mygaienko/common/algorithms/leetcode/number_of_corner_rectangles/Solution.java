package com.mygaienko.common.algorithms.leetcode.number_of_corner_rectangles;

import java.util.ArrayList;
import java.util.List;

class Solution {
    // use dynamic approach
    // for each point dp[i][j] = dp[i-1][j] + dp[i][j-1] + dp[i-1][j-1] + (current
    // with new point)
    // to calculate current we need traverse by i and j and found any 1, if exist
    // than find other points.
    public int countCornerRectangles(int[][] grid) {
        var dp = new int[grid.length][grid[0].length];

        var columnOnes = new ArrayList<List<Integer>>();
        for (int j = 0; j < grid[0].length; j++) {
            var list = new ArrayList<Integer>();
            columnOnes.add(list);
            if (grid[0][j] == 1) {
                list.add(0);
            }
        }

        for (int i = 1; i < grid.length; i++) {
            List<Integer> rowOnes = new ArrayList<>();
            if (grid[i][0] == 1) {
                rowOnes.add(0);
                columnOnes.get(0).add(i);
            }
            for (int j = 1; j < grid[0].length; j++) {
                var curr = 0;
                if (grid[i][j] == 1) {
                    if (!rowOnes.isEmpty() && !columnOnes.get(j).isEmpty()) {
                        for (var c : rowOnes) {
                            for (var r : columnOnes.get(c)) {
                                if (r != i && grid[r][c] == 1 && grid[r][j] == 1) {
                                    curr++;
                                }
                            }
                        }
                    }
                    rowOnes.add(j);
                    columnOnes.get(j).add(i);
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + curr;
            }
        }

        return dp[grid.length - 1][grid[0].length - 1];
    }
}
