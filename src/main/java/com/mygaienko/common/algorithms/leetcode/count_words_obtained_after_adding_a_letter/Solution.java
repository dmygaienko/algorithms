package com.mygaienko.common.algorithms.leetcode.count_words_obtained_after_adding_a_letter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public int wordCount(String[] startWords, String[] targetWords) {
        int count = 0;

        Trie trie = new Trie();
        for (String s : startWords) {
            trie.add(s);
        }

        for (String t : targetWords) {
            char[] chars = t.toCharArray();
            Arrays.sort(chars);
            if (trie.contains(chars)) count++;
        }

        return count;
    }

    class Trie {

        Map<Character, Trie> nodes = new HashMap<>();

        boolean terminal = false;

        void add(String s) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            add(chars, 0);
        }

        void add(char[] chars, int i) {
            if (i >= chars.length) return;
            var ch = chars[i];
            var charTrie = nodes.computeIfAbsent(ch, v -> new Trie());
            if (i + 1 < chars.length) {
                charTrie.add(chars, i + 1);
            } else {
                charTrie.setTerminal();
            }

        }

        private void setTerminal() {
            terminal = true;
        }

        public boolean contains(char[] chars) {
            return contains(chars, 0, false);
        }

        public boolean contains(char[] chars, int i, boolean masked) {
            if (i == chars.length && masked && terminal) {
                return true;
            } else if (i + 1 == chars.length && !masked && terminal) {
                return true;
            } else if (i >= chars.length) {
                return false;
            }

            boolean result = false;
            char ch = chars[i];
            var charTrie = nodes.get(ch);
            if (charTrie != null) {
                result = charTrie.contains(chars, i + 1, masked);
            }

            if (!masked && !result && i + 1 < chars.length) { // consider that chars[i] is masked
                ch = chars[i + 1];
                charTrie = nodes.get(ch);
                if (charTrie != null) {
                    result = nodes.get(ch).contains(chars, i + 2, true);
                }
            }
            return result;
        }

    }

}
