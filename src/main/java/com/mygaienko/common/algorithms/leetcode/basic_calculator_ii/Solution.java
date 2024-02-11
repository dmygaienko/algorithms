package com.mygaienko.common.algorithms.leetcode.basic_calculator_ii;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Set;

class Solution {

    Set<Character> operators = Set.of('-', '+', '*', '/');

    public int calculate(String s) {
        var queue = new ArrayDeque<Character>();
        for (char c : s.toCharArray()) {
            queue.offer(c);
        }
        return calculate(queue);
    }

    private int calculate(Queue<Character> queue) {
        var stack = new ArrayDeque<Integer>();
        var prevOperation = '+';
        var number = 0;
        while (!queue.isEmpty()) {
            var nextChar = queue.poll();
            if (Character.isDigit(nextChar)) {
                number = number * 10 + Character.getNumericValue(nextChar);
            } else if (operators.contains(nextChar)) {
                apply(stack, prevOperation, number);
                prevOperation = nextChar;
                number = 0;
            }
        }
        apply(stack, prevOperation, number);
        return stack.stream().mapToInt(a -> a).sum();
    }

    private void apply(ArrayDeque<Integer> stack, char operation, int number) {
        if (operation == '-') {
            stack.push(-number);
        } else if (operation == '+') {
            stack.push(number);
        } else if (operation == '*') {
            stack.push(stack.pop() * number);
        } else if (operation == '/') {
            stack.push(stack.pop() / number);
        }
    }

}