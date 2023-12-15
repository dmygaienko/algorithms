package com.mygaienko.common.algorithms.leetcode.add_bold_tag_in_string;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

class Solution {

    String OPEN = "<b>";
    String CLOSE = "</b>";

    // 1. put all words into map with first character and set of strings
    // 2. iterate over chars of string
    // 2.a if current char exist in map of "words" then we need to find any
    // 2.b if we don't find any, start from next char (close </b> if opened)
    // 2.c if we find any (put start <b>), try to find overlapped pair with next char

    public String addBoldTag(String s, String[] arr) {
        var root = initTrie(arr);
        var bitSet = new BitSet(s.length());

        var lastSetIndex = -1;
        for (int i = 0; i < s.length(); i++) {

            var node = root;
            for (int j = i; j < s.length(); j++) {
                node = node.get(s.charAt(j));
                if (node == null) {
                    break;
                } else if (node.terminal && lastSetIndex < j) {
                    var from = Math.max(lastSetIndex, i);
                    bitSet.set(from, j + 1);
                    lastSetIndex = j;
                }
            }
        }

        var sb = new StringBuilder();
        var opened = false;
        for (int i = 0; i < s.length(); i++) {
            boolean isBold = bitSet.get(i);
            if (isBold && !opened) {
                sb.append(OPEN);
                opened = true;
            } else if (!isBold && opened) {
                sb.append(CLOSE);
                opened = false;
            }
            sb.append(s.charAt(i));
        }

        if (opened) {
            sb.append(CLOSE);
        }

        return sb.toString();
    }

    private Trie initTrie(String[] arr) {
        var root = new Trie();
        for (var w : arr) {
            root.add(w);
        }
        return root;
    }

    class Trie {

        Trie[] chars = new Trie[75];
        boolean terminal = false;

        public void add(String w) {
            add(w, 0);
        }

        private void add(String w, int i) {
            var nextChar = w.charAt(i);
            if (chars[nextChar - '0'] == null) {
                chars[nextChar - '0'] = new Trie();
            }
            var nextTrie = chars[nextChar - '0'];

            if (i + 1 < w.length()) {
                nextTrie.add(w, i + 1);
            } else {
                nextTrie.setTerminal();
            }
        }

        private void setTerminal() {
            terminal = true;
        }

        public Trie get(char nextChar) {
            return chars[nextChar - '0'];
        }

    }

}