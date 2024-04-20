package com.mygaienko.common.algorithms.leetcode.index_pairs_of_a_string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[][] indexPairs(String text, String[] words) {
        var root = new Tree();
        for (var word : words) {
            var curr = root;
            for (var ch : word.toCharArray()) {
                if (!curr.chars.containsKey(ch)) {
                    var next = new Tree();
                    curr.chars.put(ch, next);
                    curr = next;
                } else {
                    curr = curr.chars.get(ch);
                }
            }
            if (curr != root) {
                curr.terminal = true;
            }
        }
        var result = new ArrayList<int[]>();

        for (int i = 0; i < text.length(); i++) {
            var curr = root;
            var left = -1;

            for (int j = i; j < text.length(); j++) {
                var ch = text.charAt(j);
                if (curr.chars.containsKey(ch)) {
                    curr = curr.chars.get(ch);
                    if (left == -1) {
                        left = j;
                    }

                    if (curr.terminal) {
                        result.add(new int[]{left, j});
                    }
                } else {
                    break;
                }
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}

class Tree {
    boolean terminal = false;
    Map<Character, Tree> chars = new HashMap<>();
}