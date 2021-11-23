package com.mygaienko.common.algorithms.leetcode.prefix_and_suffix_search;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * 745. Prefix and Suffix Search
 * https://leetcode.com/problems/prefix-and-suffix-search/
 */
class WordFilter {

    public static final String DELIMITER = "#";
    private final Trie trie;

    public WordFilter(String[] words) {
        trie = initTrie(words);
    }

    public int f(String prefix, String suffix) {
        return trie.find(suffix + DELIMITER + prefix);
    }

    static class Trie {

        private TrieNode root = new TrieNode(this, "root");
        private final String[] words;

        public Trie(String[] words) {
            this.words = words;
        }

        public void insert(String word, int globalInd) {
            root.insert(word, 0, globalInd);
        }

        public int find(String word) {
            return root.find(word, 0);
        }

        public String[] getWords() {
            return words;
        }
    }

    static class TrieNode {

        private final Trie trie;
        private final String k;

        private Map<Character, TrieNode> children = new HashMap<>();

        private static final int NOT_FOUND = -1;
        private int index = NOT_FOUND;

        TrieNode(Trie trie, String k) {
            this.trie = trie;
            this.k = k;
        }

        private TrieNode insert(String word, int ind, int globalInd) {
            if (ind > word.length()) {
                return this;
            } else if (ind == word.length()) {
                index = globalInd;
                return this;
            }

            char c = word.charAt(ind);

            int nextIndex = ind + 1;

            children.compute(c,
                    (k, v) -> v == null
                            ? new TrieNode(trie, String.valueOf(k)).insert(word, nextIndex, globalInd)
                            : v.insert(word, nextIndex, globalInd));

            return this;
        }

        private int find(String word, int i) {
            if (i >= word.length()) {
                return findLargestIndex();
            }

            char nextChar = word.charAt(i);

            return Optional.ofNullable(children.get(nextChar))
                    .map(node -> node.find(word, i + 1))
                    .orElse(NOT_FOUND);
        }

        private int findLargestIndex() {
            return findLargestIndex(NOT_FOUND);
        }

        private int findLargestIndex(int longestWordIndex) {
            if (isWord()) {
                if (longestWordIndex < index) {
                    longestWordIndex = index;
                }
            }

            Set<Map.Entry<Character, TrieNode>> entries = children.entrySet();

            for (Map.Entry<Character, TrieNode> entry : entries) {
                TrieNode value = entry.getValue();

                if (value.isWord()) {
                    int wordIndex = value.index;
                    if (wordIndex > longestWordIndex) {
                        longestWordIndex = wordIndex;
                    }
                }

                longestWordIndex = value.findLargestIndex(longestWordIndex);
            }

            return longestWordIndex;
        }

        private boolean isWord() {
            return index != NOT_FOUND;
        }

    }

    private Trie initTrie(String[] words) {
        Trie t = new Trie(words);
        for (int i = 0; i < words.length; i++) {
            String word  = words[i];
            String suffix = "";
            for (int j = word.length() -1; j >= 0; j--) {
                suffix = word.charAt(j) + suffix;
                t.insert(suffix + DELIMITER + word, i);
            }
        }
        return t;
    }

}