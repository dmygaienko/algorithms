package com.mygaienko.common.algorithms.leetcode.evaluate_reverse_polish_notation;

import java.util.ArrayDeque;

class Solution {

    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLY = '*';
    private static final char DIVIDE = '/';

    public int evalRPN(String[] tokens) {
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (String token : tokens) {
            char ch = token.charAt(0);
            if (Character.isDigit(ch) || token.length() > 1) {
                stack.push(token);
            } else {
                String val2 = stack.pop();
                String val1 = stack.pop();
                int result = applyOperand(val1, val2, ch);
                stack.push(String.valueOf(result));
            }
        }

        return stack.isEmpty() ? 0 : Integer.valueOf(stack.peek());
    }

    private int applyOperand(String stringVal1, String stringVal2, char operand) {
        int val1 = Integer.valueOf(stringVal1);
        int val2 = Integer.valueOf(stringVal2);
        int result;

        if (operand == PLUS) {
            result = val1 + val2;
        } else if (operand == MINUS) {
            result = val1 - val2;
        } else if (operand == MULTIPLY) {
            result = val1 * val2;
        } else {
            result = val1 / val2;
        }

        return result;
    }

}
