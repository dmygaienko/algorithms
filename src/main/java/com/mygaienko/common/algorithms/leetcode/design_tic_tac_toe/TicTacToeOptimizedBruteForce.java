package com.mygaienko.common.algorithms.leetcode.design_tic_tac_toe;

class TicTacToeOptimizedBruteForce {

    private int NO_WIN = 0;

    private int[] UP = {-1, 0};
    private int[] DOWN = {1, 0};
    private int[] LEFT = {0, -1};
    private int[] RIGHT = {0, 1};

    private int[] UP_LEFT = {-1, -1};
    private int[] UP_RIGHT = {-1, 1};
    private int[] DOWN_LEFT = {1, -1};
    private int[] DOWN_RIGHT = {1, 1};

    private final int[][] matrix;

    public TicTacToeOptimizedBruteForce(int n) {
        matrix = new int[n][n];
    }

    public int move(int row, int col, int player) {
        matrix[row][col] = player;

        if (isRow(row, col, player, UP, DOWN)) return player;
        if (isRow(row, col, player, LEFT, RIGHT)) return player;
        if (isRow(row, col, player, UP_LEFT, DOWN_RIGHT)) return player;
        if (isRow(row, col, player, UP_RIGHT, DOWN_LEFT)) return player;

        return NO_WIN;
    }

    private boolean isRow(int row, int col, int player, int[] firstMove, int[] nextMove) {
        int first = getRowSize(row, col, firstMove, player, 0);
        int second = getRowSize(row, col, nextMove, player, 0);
        if (first + second == matrix.length - 1) {
            return true;
        }
        return false;
    }

    private int getRowSize(int row, int col, int[] move, int player, int rowSize) {
        int nextRow = row + move[0];
        int nextCol = col + move[1];
        if (nextRow < 0 || nextRow >= matrix.length || nextCol < 0 || nextCol >= matrix[0].length) {
            return rowSize;
        } else if (matrix[nextRow][nextCol] == player) {
            return getRowSize(nextRow, nextCol, move, player, rowSize + 1);
        } else {
            return rowSize;
        }
    }
}