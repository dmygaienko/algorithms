package com.mygaienko.common.algorithms.leetcode.check_if_word_can_be_placed_in_crossword;

class Solution {

    char EMPTY = ' ';
    char BLOCKED = '#';

    public boolean placeWordInCrossword(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            char[] row = board[i];
            for (int j = 0; j < row.length; j++) {
                char cell = row[j];
                if (cell == EMPTY || cell == word.charAt(0)) {
                    if (checkHorizontal(board, i, j, word)) return true;
                    if (checkHorizontalLeftToRight(board, i, j, word)) return true;
                    if (checkVertical(board, i, j, word)) return true;
                    if (checkVerticalBottomToUp(board, i, j, word)) return true;
                }
            }
        }

        return false;
    }

    private boolean checkHorizontal(char[][] board, int i, int j, String word) {
        char[] row = board[i];
        if (j > 0 && row[j - 1] != BLOCKED) return false; // not a start
        if (j + word.length() > row.length) return false; // cannot fully inserted

        int w = 1;
        for (; w < word.length() && j + w < row.length; w++) {
            char cell = row[j + w];
            if (cell == EMPTY || cell == word.charAt(w)) continue;
            else return false;
        }

        return j + w >= row.length || row[j + w] == BLOCKED;
    }

    private boolean checkHorizontalLeftToRight(char[][] board, int i, int j, String word) {
        char[] row = board[i];
        if (j + 1 < row.length && row[j + 1] != BLOCKED) return false; // not a start
        if (j + 1 - word.length() < 0) return false; // cannot fully inserted

        int w = 1;
        for (; w < word.length() && j - w >= 0; w++) {
            char cell = row[j - w];
            if (cell == EMPTY || cell == word.charAt(w)) continue;
            else return false;
        }

        return j - w < 0 || row[j - w] == BLOCKED;
    }

    private boolean checkVertical(char[][] board, int i, int j, String word) {
        if (i > 0 && board[i-1][j] != BLOCKED) return false; // not a start
        if (i + word.length() > board.length) return false;

        int w = 1;
        for (; w < word.length() && i + w < board.length; w++) {
            char cell = board[i + w][j];
            if (cell == EMPTY || cell == word.charAt(w)) continue;
            else return false;
        }

        return i + w >= board.length || board[i + w][j] == BLOCKED;
    }

    private boolean checkVerticalBottomToUp(char[][] board, int i, int j, String word) {
        if (i + 1 < board.length && board[i+1][j] != BLOCKED) return false; // not a start
        if (i + 1 - word.length() < 0) return false;

        int w = 1;
        for (; w < word.length() && i - w >= 0; w++) {
            char cell = board[i - w][j];
            if (cell == EMPTY || cell == word.charAt(w)) continue;
            else return false;
        }

        return i - w < 0 || board[i - w][j] == BLOCKED;
    }

}
