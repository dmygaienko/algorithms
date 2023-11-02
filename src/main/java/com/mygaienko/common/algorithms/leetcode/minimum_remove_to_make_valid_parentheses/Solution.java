package com.mygaienko.common.algorithms.leetcode.minimum_remove_to_make_valid_parentheses;

import java.util.LinkedList;

class Solution {
    char OPEN = '(';
    char CLOSE = ')';

    public String minRemoveToMakeValid(String s) {
        var stack = new LinkedList<Integer>();
        var sb = new StringBuilder();
        var offset = 0;
        for (int i = 0; i < s.length(); i++) {
            var next = s.charAt(i);

            if (next == OPEN) {
                sb.append(next);
                stack.push(i);
            } else if (next == CLOSE && !stack.isEmpty()) {
                stack.pop();
                sb.append(next);
            } else if (next != CLOSE) {
                sb.append(next);
            } else {
                offset++;
            }
        }

        while (!stack.isEmpty()) {
            var lastOpenIndex = stack.pop();
            sb.deleteCharAt(lastOpenIndex - offset);
        }

        return sb.toString();
    }
}
