package com.mygaienko.common.algorithms.leetcode.generate_parentheses;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private static final char OPEN = '(';
    private static final char CLOSE = ')';
    private static final List<Character> adj = List.of(OPEN, CLOSE);

    private List<String> combinations;

    public List<String> generateParenthesis(int n) {
        combinations = new ArrayList<>();

        generateParenthesis(new StringBuilder(), n, n, n);
        return combinations;
    }

    private void generateParenthesis(StringBuilder path,
                                     int n,
                                     int currentOpenQueue,
                                     int currentClosedQueue) {
        if (currentOpenQueue == 0) {
            int times =  n * 2 - path.length();
            for (int i = 0; i < times; i++) {
                path.append(CLOSE);
            }
            combinations.add(path.toString());
            for (int i = 0; i < times; i++) {
                deleteLast(path);
            }
            return;
        } else if (currentClosedQueue == 0) {
            return;
        }

        for (Character character : adj) {
            if (character == CLOSE && (path.length() == 0 || currentOpenQueue == currentClosedQueue)) continue;

            path.append(character);

            if (character == OPEN) {
                currentOpenQueue--;
            } else {
                currentClosedQueue--;
            }

            generateParenthesis(path, n, currentOpenQueue, currentClosedQueue);

            if (character == OPEN) {
                currentOpenQueue++;
            } else {
                currentClosedQueue++;
            }

            deleteLast(path);
        }

    }

    private void deleteLast(StringBuilder path) {
        path.deleteCharAt(path.length() - 1);
    }

}
