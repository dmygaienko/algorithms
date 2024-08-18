package com.mygaienko.common.algorithms.leetcode.reverse_substrings_between_each_pair_of_parentheses;

import org.apache.commons.lang3.tuple.Pair;

class Solution {

    public String reverseParentheses(String s) {
        return reverse(s, 0).getKey();
    }

    private Pair<String, Integer> reverse(String s, int index) {
        var sb = new StringBuilder();

        for (int i = index; i < s.length(); i++) {
            var next = s.charAt(i);

            if (next == '(') {
                var pair = reverse(s, i + 1);
                sb.append(pair.getKey());
                i = pair.getValue();
            } else if (next == ')') {
                return Pair.of(sb.reverse().toString(), i);
            } else {
                sb.append(next);
            }
        }

        return Pair.of(sb.toString(), s.length() - 1);
    }

}