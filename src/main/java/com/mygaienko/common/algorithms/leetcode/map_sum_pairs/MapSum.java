package com.mygaienko.common.algorithms.leetcode.map_sum_pairs;

import java.util.HashMap;
import java.util.Map;

class MapSum {

    private static final int DEFAULT = 0;

    final TrieNode root;

    public MapSum() {
        root = new TrieNode(DEFAULT);
    }

    public void insert(String key, int val) {
        char[] chars = key.toCharArray();
        TrieNode current = root;
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            int currentValue = i == chars.length - 1 ? val : DEFAULT;

            if (!current.contains(ch)) {
                TrieNode node = new TrieNode(currentValue);
                current.put(ch, node);
                current = node;
            } else {
                current = current.get(ch);

                if (currentValue > 0) {
                    current.setValue(currentValue);
                }
            }
        }
    }

    public int sum(String prefix) {
        int result = 0;
        char[] chars = prefix.toCharArray();
        TrieNode current = root;
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (!current.contains(ch)) {
                return DEFAULT;
            } else {
                current = current.get(ch);
            }
        }

        result += computeChildren(current);
        return result;
    }

    private int computeChildren(TrieNode current) {
        int result = current.val;
        for (Map.Entry<Character, TrieNode> entry : current.children.entrySet()) {
            TrieNode node = entry.getValue();
            result += computeChildren(node);
        }
        return result;
    }
}

class TrieNode {

    int val;
    final Map<Character, TrieNode> children = new HashMap<>();

    public TrieNode(int val) {
        this.val = val;
    }

    public boolean contains(char aChar) {
        return children.containsKey(aChar);
    }

    public void put(char ch, TrieNode node) {
        children.put(ch, node);
    }

    public TrieNode get(char ch) {
        return children.get(ch);
    }

    public void setValue(int currentValue) {
        val = currentValue;
    }
}

