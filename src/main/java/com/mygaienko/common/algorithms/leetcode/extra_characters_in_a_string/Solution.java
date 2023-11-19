package com.mygaienko.common.algorithms.leetcode.extra_characters_in_a_string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Top Down Dynamic Programming with Trie
 */
class Solution {

    public static final int NOT_FOUND = Integer.MAX_VALUE - 1000;
    private String s;
    private Trie root;

    public int minExtraChar(String s, String[] dictionary) {
        this.s = s;
        root = new Trie(0);
        for (var d : dictionary) {
            root.add(d);
        }

        var memo = new int[s.length()];
        Arrays.fill(memo, NOT_FOUND);

        return iterate(0, 0, false, memo, root);
    }

    public int iterate(int index, int current, boolean crawl, int[] memo, Trie trie) {
        if (index >= s.length()) {
            return current;
        }

        if (memo[index] <= current) {
            return memo[index];
        }

        var result = Integer.MAX_VALUE;
        var nextChar = s.charAt(index);

        if (trie.contains(nextChar)) {
            var nextTrie = trie.get(nextChar);
            if (index + 1 < s.length()) {
                result = Math.min(result, iterate(index + 1, current, true, memo, nextTrie));
            }

            if (nextTrie.terminal) {
                result = Math.min(result, iterate(index + 1, current, false, memo, root));
            }
        }

        if (!crawl) {
            result = Math.min(result, iterate(index + 1, current + 1, false, memo, root));
        }

        put(index, memo, result);

        return result;
    }

    private static void put(int index, int[] memo, int res) {
        Integer stored = memo[index];
        if (stored >= res) {
            memo[index] = res;
        }
    }

    class Trie {
        int level = 0;
        boolean terminal;
        Map<Character, Trie> nodes = new HashMap<>();

        public Trie(int level) {
            this.level = level;
        }

        public boolean contains(Character ch) {
            return nodes.containsKey(ch);
        }

        public Trie get(Character ch) {
            return nodes.get(ch);
        }

        public void add(String s) {
            add(s, 0, 0);
        }

        public boolean isEmpty() {
            return nodes.isEmpty();
        }

        private void add(String s, int index, int level) {
            if (index >= s.length()) return;
            var ch = s.charAt(index);
            if (!nodes.containsKey(ch)) {
                nodes.put(ch, new Trie(level));
            }
            var node = nodes.get(ch);
            if (index + 1 == s.length()) {
                node.terminal = true;
            } else {
                node.add(s, index + 1, level + 1);
            }
        }
    }

}