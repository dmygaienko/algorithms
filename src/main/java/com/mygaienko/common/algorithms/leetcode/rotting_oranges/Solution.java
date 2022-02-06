package com.mygaienko.common.algorithms.leetcode.rotting_oranges;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    static final int EMPTY = 0;
    static final int FRESH = 1;
    static final int ROTTEN = 2;

    public int orangesRotting(int[][] grid) {
        int freshOranges = 0;
        int M = grid.length;
        int N = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int cell = grid[i][j];
                if (cell == FRESH) freshOranges++;
                if (cell == ROTTEN) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int minutes = 1;
        int round = queue.size();

        if (freshOranges == 0) return 0;

        while (!queue.isEmpty() && round > 0 && freshOranges != 0) {
            int[] next = queue.poll();
            int i = next[0];
            int j = next[1];

            int adjCell;
            if (i > 0) {
                adjCell = grid[i-1][j];
                if (adjCell == FRESH) {
                    grid[i-1][j] = ROTTEN;
                    freshOranges--;
                    queue.offer(new int[]{i-1, j});
                }
            }

            if (i + 1 < M) {
                adjCell = grid[i+1][j];
                if (adjCell == FRESH) {
                    grid[i+1][j] = ROTTEN;
                    freshOranges--;
                    queue.offer(new int[]{i+1, j});
                }
            }

            if (j > 0) {
                adjCell = grid[i][j-1];
                if (adjCell == FRESH) {
                    grid[i][j-1] = ROTTEN;
                    freshOranges--;
                    queue.offer(new int[]{i, j-1});
                }
            }

            if (j + 1 < N) {
                adjCell = grid[i][j+1];
                if (adjCell == FRESH) {
                    grid[i][j+1] = ROTTEN;
                    freshOranges--;
                    queue.offer(new int[]{i, j+1});
                }
            }

            round--;
            if (round == 0 && freshOranges !=0) {
                round = queue.size();
                minutes++;
            }
        }

        return freshOranges == 0 ? minutes : -1;
    }
}