package com.mygaienko.common.algorithms.leetcode.candy_crush;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    private static final int BOOMED = -1;

    public int[][] candyCrush(int[][] board) {
        boolean stable = findCrushes(board);
        while (!stable) {
            boom(board);
            stable = findCrushes(board);
        }
        return board;
    }

    private void boom(int[][] board) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                int next = board[j][i];
                if (next > 0) {
                    stack.push(next);
                }
            }

            for (int j = board.length - 1; j >= 0 ; j--) {
                int next;
                if (!stack.isEmpty()) {
                    next = stack.pop();
                } else {
                    next = 0;
                }

                board[j][i] = next;
            }
        }
    }

    private boolean findCrushes(int[][] board) {
        boolean stable = true;
        for (int i = 0; i < board.length; i++) {
            int prev = Integer.MIN_VALUE;
            int same = 0;

            for (int j = 0; j < board[0].length; j++) {
                int current = board[i][j];
                int revCurrent = current * BOOMED;

                if (prev == current || prev == revCurrent) {
                    same++;

                    if (same >= 2) {
                        if (j + 1 >= board[i].length || (board[i][j + 1] != current && board[i][j + 1] != revCurrent)) {
                            for (int b = j; b >= j - same; b--) {
                                if (board[i][b] > 0) {
                                    board[i][b] *= BOOMED;
                                    stable = false;
                                }

                            }
                            same = 0;
                        }
                    }
                } else {
                    same = 0;
                }

                int lowerSame = 0;
                for (int i1 = i + 1; i1 < board.length && (current == board[i1][j] || revCurrent == board[i1][j]); i1++) {
                    lowerSame++;

                    if (lowerSame >= 2) {
                        if (i1 + 1 >= board.length || (board[i1 + 1][j] != current && board[i1 + 1][j] != revCurrent)) {
                            for (int b1 = i1; b1 >= i1 - lowerSame; b1--) {
                                if (board[b1][j] > 0) {
                                    board[b1][j] *= BOOMED;
                                    stable = false;
                                }

                            }
                        }
                    }
                }

                prev = current;
            }
        }

        return stable;
    }

}
