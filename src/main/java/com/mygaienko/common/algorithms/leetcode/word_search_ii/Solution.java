package com.mygaienko.common.algorithms.leetcode.word_search_ii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * dfs, trie, backtrack, pruning, optimization
 */
class Solution {

    int[][] dirs = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    char VISITED = '#';

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();

        Trie root = new Trie();
        for (String word : words) {
            root.addWord(word);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char next = board[i][j];
                if (root.contains(next)) {
                    List<String> foundStrings = findWords(board, root, i, j);
                    if (!foundStrings.isEmpty()) {
                        result.addAll(foundStrings);
                    }
                }
            }
        }
        return result;
    }

    private List<String> findWords(char[][] board, Trie parent, int x, int y) {
        List<String> result = new ArrayList<>();

        char currentChar = board[x][y];
        board[x][y] = VISITED;

        Trie trie = parent.getChild(currentChar);
        if (trie.s != null) {
            result.add(trie.s);
            trie.s = null;
        }

        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if (nextX >= 0 && nextX < board.length && nextY >= 0 && nextY < board[0].length) {
                char nextChar = board[nextX][nextY];
                if (trie.contains(nextChar) && board[nextX][nextY] != VISITED) {
                    List<String> foundWords = findWords(board, trie, nextX, nextY);
                    if (!foundWords.isEmpty()) {
                        result.addAll(foundWords);
                    }
                }
            }
        }

        //rollback
        board[x][y] = currentChar;

        //optimization: pruning
        if (trie.children.isEmpty()) {
            parent.remove(currentChar);
        }

        return result;
    }

}

class Trie {

    String s = null;

    Map<Character, Trie> children = new HashMap<>();

    void addWord(String word) {
        Trie trie = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            trie = trie.children.computeIfAbsent(c, v -> new Trie());
        }
        trie.s = word;
    }

    boolean contains(char next) {
        return children.containsKey(next);
    }

    Trie getChild(char next) {
        return children.get(next);
    }

    public void remove(char currentChar) {
        children.remove(currentChar);
    }

}