package com.mygaienko.common.algorithms.leetcode.letter_combinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DFS + backtrack path
 */
@SuppressWarnings("Duplicates")
class Solution {

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return List.of();

        Map<Integer, List<Character>> adj = new HashMap<>();
        adj.put(2, List.of('a', 'b', 'c'));
        adj.put(3, List.of('d', 'e', 'f'));
        adj.put(4, List.of('g', 'h', 'i'));
        adj.put(5, List.of('j', 'k', 'l'));
        adj.put(6, List.of('m', 'n', 'o'));
        adj.put(7, List.of('p', 'q', 'r', 's'));
        adj.put(8, List.of('t', 'u', 'v'));
        adj.put(9, List.of('w', 'x', 'y', 'z'));


        List<String> combinations = new ArrayList<>();
        letterCombinations(adj, digits, 0, new StringBuilder(), combinations);
        return combinations;
    }

    private void letterCombinations(Map<Integer, List<Character>> adj, String digits, int i, StringBuilder path, List<String> combination) {
        if (i >= digits.length()) {
            combination.add(path.toString());
            return;
        }

        int digit = digits.charAt(i) - '0';

        for (Character c : adj.get(digit)) {
            path.append(c);
            letterCombinations(adj, digits, i + 1, path, combination);
            path.deleteCharAt(path.length()-1);
        }
    }

}
