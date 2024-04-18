package com.mygaienko.common.algorithms.leetcode.valid_word_square;

import java.util.List;

class Solution {
    public boolean validWordSquare(List<String> words) {
        int n = words.size();

        if (n != words.get(0).length()) return false;

        for (int i = 0; i < n; i++) { // diagonal
            if (words.get(i).length() > n) return false;

            for (int j = 0; j < i; j++) {
                char horizontal = ' ';
                if (i < words.size() && j < words.get(i).length()) {
                    horizontal = words.get(i).charAt(j);
                }

                char vertical = ' ';
                if (j < words.size() && i < words.get(j).length()) {
                    vertical = words.get(j).charAt(i);
                }

                if (horizontal != vertical) return false;
            }
        }

        return true;
    }
}