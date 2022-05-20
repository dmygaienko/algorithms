package com.mygaienko.common.algorithms.leetcode.letter_combinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DFS + cloning path
 */
@SuppressWarnings("Duplicates")
class SolutionV2 {

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return List.of();

        Map<Integer, List<Character>> adj = new HashMap<>();
        adj.put(2, List.of('a','b','c'));
        adj.put(3, List.of('d','e','f'));
        adj.put(4, List.of('g','h','i'));
        adj.put(5, List.of('j','k','l'));
        adj.put(6, List.of('m','n','o'));
        adj.put(7, List.of('p','q','r','s'));
        adj.put(8, List.of('t','u','v'));
        adj.put(9, List.of('w','x','y', 'z'));


        List<List<Character>> lists = letterCombinations(adj, digits, 0, List.of());
        List<String> result = new ArrayList<>();
        for (List<Character> chars : lists) {
            StringBuilder sb = new StringBuilder();
            chars.forEach(sb::append);
            result.add(sb.toString());
        }
        return result;
    }

    private List<List<Character>> letterCombinations(Map<Integer, List<Character>> adj, String digits, int i, List<Character> combination) {
        if (i >= digits.length()) return List.of(combination);
        int digit = digits.charAt(i) - '0';

        List<List<Character>> result = new ArrayList<>();
        for (Character c : adj.get(digit)) {
            List<Character> cloned = new ArrayList<>(combination);
            cloned.add(c);
            List<List<Character>> results = letterCombinations(adj, digits, i + 1, cloned);
            result.addAll(results);
        }

        return result;
    }

}
