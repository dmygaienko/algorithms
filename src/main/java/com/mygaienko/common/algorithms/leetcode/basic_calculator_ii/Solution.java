package com.mygaienko.common.algorithms.leetcode.basic_calculator_ii;

import java.util.LinkedList;

class Solution {

    private static String PLUS = "+";
    private static String MINUS = "-";
    private static String MULTIPLY = "*";
    private static String DIVIDE = "/";
    private static String EMPTY = "";

    public int calculate(String s) {
        LinkedList<String> queue = parse(s);
        return calculate(queue);
    }

    private int calculate(LinkedList<String> queue) {
        if (queue.size() == 1) return Integer.parseInt(queue.peek());

        String operandA = EMPTY;
        String operator = EMPTY;
        String operandB = EMPTY;
        while (!queue.isEmpty()) {
            String next = queue.poll();

            if (operandA.equals(EMPTY)) {
                operandA = next;
            } else if (operator.equals(EMPTY)) {
                operator = next;
            } else if (operandB.equals(EMPTY)) {
                operandB = next;

                if (queue.isEmpty()) {
                    return operate(operandA, operator, operandB);
                }

            } else if ((operator.equals(MINUS) || operator.equals(PLUS)) && (next.equals(MULTIPLY) || next.equals(DIVIDE))) {
                if (operator.equals(MINUS)) {
                    operandB = MINUS + operandB;

                }

                queue.push(next);
                queue.push(operandB);

                queue.offer(PLUS);
                queue.offer(operandA);

                operandA = EMPTY;
                operator = EMPTY;
                operandB = EMPTY;
            } else {
                int value = operate(operandA, operator, operandB);
                queue.push(next);
                queue.push(String.valueOf(value));
                operandA = EMPTY;
                operator = EMPTY;
                operandB = EMPTY;
            }
        }

        return 0;
    }

    private int operate(String operandA, String operator, String operandB) {
        int a = Integer.parseInt(operandA);
        int b = Integer.parseInt(operandB);
        int result;
        if (operator.equals(PLUS)) {
            result = a + b;
        } else if (operator.equals(MINUS)) {
            result = a - b;
        } else if (operator.equals(MULTIPLY)) {
            result = a * b;
        } else {
            result = a / b;
        }
        return result;
    }

    private static LinkedList<String> parse(String s) {
        char[] chars = s.toCharArray();

        LinkedList<String> queue = new LinkedList<>();

        String number = "";
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];

            if (Character.isDigit(ch)) {
                number = number + ch;
            } else if (!number.equals(EMPTY) && ch != ' ') {
                queue.add(number);
                number = EMPTY;

                queue.add(String.valueOf(ch));
            }

        }

        if (!number.equals(EMPTY)) {
            queue.add(number);
        }
        return queue;
    }


}