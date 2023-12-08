package com.mygaienko.common.algorithms.leetcode.search_suggestions_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Solution {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        var root = new Trie(false);
        for (var product : products) {
            root.add(product, 0);
        }

        var result = new ArrayList<List<String>>();
        for (int i = 0; i < searchWord.length(); i++) {
            var matched = root.find(searchWord, 0, i, new StringBuilder());
            result.add(matched);
        }

        return result;
    }

}

class Trie {
    Map<Character, Trie> chars = new TreeMap<>();
    boolean terminal = false;

    Trie(boolean terminal) {
        this.terminal = terminal;
    }

    public void add(String s, int index) {
        var ch = s.charAt(index);
        var terminal = index == s.length() - 1;
        var child = chars.computeIfAbsent(ch, v -> new Trie(terminal));
        if (!terminal) {
            child.add(s, index + 1);
        } else {
            child.terminal = terminal;
        }
    }

    public List<String> find(String s, int currIndex, int endIndex, StringBuilder sb) {
        var result = new ArrayList<String>();

        var ch = s.charAt(currIndex);
        var childTrie = chars.get(ch);
        if (childTrie != null) {
            sb.append(ch);

            if (currIndex < endIndex) {
                return childTrie.find(s, currIndex + 1, endIndex, sb);
            } else {
                return findTerminal(childTrie, new ArrayList<>(), sb);
            }
        }
        return result;
    }

    public List<String> findTerminal(Trie trie, List<String> list, StringBuilder sb) {
        if (trie.terminal) {
            list.add(sb.toString());
        }

        if (list.size() == 3) return list;

        for (var entry : trie.chars.entrySet()) {
            var ch = entry.getKey();
            var childTrie = entry.getValue();
            sb.append(ch);

            findTerminal(childTrie, list, sb);
            if (list.size() == 3) return list;

            sb.deleteCharAt(sb.length() - 1);
        }

        return list;
    }


}
