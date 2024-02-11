package com.mygaienko.common.algorithms.leetcode.basic_calculator_iii;

import java.util.ArrayDeque;
import java.util.Set;
import java.util.Stack;


class Solution {

    Set<Character> operators = Set.of('*', '/', '+', '-');

    public int calculate(String s) {
        var queue = new ArrayDeque<Character>();
        for (char c : s.toCharArray()) {
            queue.offer(c);
        }
        return calculate(queue);
    }

    private int calculate(ArrayDeque<Character> queue) {
        var stack = new Stack<Integer>();
        var prevOperator = '+';
        var number = 0;
        while (!queue.isEmpty()) {
            var nextChar = queue.poll();

            if (Character.isDigit(nextChar)) {
                number = number * 10 + Character.getNumericValue(nextChar);
            } else if (nextChar == '(') {
                number = calculate(queue);
            } else if (nextChar == ')') {
                break;
            } else if (operators.contains(nextChar)) {
                eval(stack, prevOperator, number);
                prevOperator = nextChar;
                number = 0;
            }
        }
        eval(stack, prevOperator, number);
        return stack.stream().reduce(Integer::sum).orElse(0);
    }

    private void eval(Stack<Integer> stack, char prevOperator, int number) {
        if (prevOperator == '-') {
            stack.push(-number);
        } else if (prevOperator == '+') {
            stack.push(number);
        } else if (prevOperator == '*') {
            stack.push(stack.pop() * number);
        } else if (prevOperator == '/') {
            stack.push(stack.pop() / number);
        }
    }
}
