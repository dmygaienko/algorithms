package com.mygaienko.common.algorithms.leetcode.surrounded_regions;

import java.util.Deque;
import java.util.LinkedList;

class Solution {

    char ban = 'B';
    char region = 'O';
    char border = 'X';

    int[][] dirs = new int[][] {
            {0, 1}, {1, 0},
            {0, -1},{-1, 0}
    };

    public void solve(char[][] board) {
        Deque<int[]> queue = new LinkedList<>();

        // find all points on the edges and add to the queue
        // first row
        for (int j = 0; j < board[0].length; j++) {
            char next = board[0][j];
            if (next == region) {
                offerAndBan(board, queue, 0, j);
            }
        }

        // last row
        if (board.length > 1) {
            int lastRow = board.length - 1;
            for (int j = 0; j < board[lastRow].length; j++) {
                char next = board[lastRow][j];
                if (next == region) {
                    offerAndBan(board, queue, lastRow, j);
                }
            }
        }

        // first column
        for (int i = 0; i < board.length; i++) {
            char next = board[i][0];
            if (next == region) {
                offerAndBan(board, queue, i, 0);
            }
        }

        // last column
        if (board[0].length > 1) {
            int lastColumn = board[0].length - 1;
            for (int i = 0; i < board.length; i++) {
                char next = board[i][lastColumn];
                if (next == region) {
                    offerAndBan(board, queue, i, lastColumn);
                }
            }
        }

        // ban all nearest nodes
        while (!queue.isEmpty()) {
            int[] next = queue.poll();
            int x = next[0];
            int y = next[1];

            for (int[] dir : dirs) {
                int neighX = x + dir[0];
                int neighY = y + dir[1];

                if (neighX >= 0 && neighX < board.length && neighY >= 0 && neighY < board[0].length) {
                    if (board[neighX][neighY] == region) {
                        board[neighX][neighY] = ban;
                        queue.push(new int[]{neighX, neighY});
                    }
                }
            }
        }

        // full scan -> change left (not banned) O to X
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int next = board[i][j];
                if (next == region) {
                    board[i][j] = border;
                } else if (next == ban) {
                    board[i][j] = region;
                }
            }
        }
    }

    private void offerAndBan(char[][] board, Deque<int[]> stack, int i, int j) {
        stack.offer(new int[]{i, j});
        board[i][j] = ban;
    }

}
