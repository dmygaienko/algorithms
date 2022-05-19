package com.mygaienko.common.algorithms.leetcode.valid_parentheses;

import java.util.ArrayDeque;

class Solution {

    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (ch == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (ch == '}'){
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }

}
