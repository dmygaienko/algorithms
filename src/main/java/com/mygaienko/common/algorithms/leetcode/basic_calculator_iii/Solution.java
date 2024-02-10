package com.mygaienko.common.algorithms.leetcode.basic_calculator_iii;

import java.util.ArrayDeque;
import java.util.Set;

class Solution {

    Set<Character> higherPriority = Set.of('*', '/');
    Set<Character> lowerPriority = Set.of('-', '+');

    public int calculate(String s) {
        var numbers = new ArrayDeque<Integer>();
        var operators = new ArrayDeque<Character>();

        int prevIndex = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            var nextChar = s.charAt(i);
            if (!Character.isDigit(nextChar) || i + 1 == s.length()) { //isSymbol
                if (numbers.size() > 1 && !operators.isEmpty() && lowerPriority.contains(nextChar) && lowerPriority.contains(operators.peek())) { // this and prev operator are lower priority
                    numbers.push(calculate(numbers.pop(), operators.pop(), numbers.pop()));
                }

                if (prevIndex < i || i + 1 == s.length()) { // if number exist before current symbol
                    var number = parseInt(s, prevIndex, i);
                    if (!numbers.isEmpty() && !operators.isEmpty() && higherPriority.contains(operators.peek())) {
                        numbers.push(calculate(number, operators.pop(), numbers.pop()));
                    } else if (!operators.isEmpty() && operators.peek() == '-') {
                        addOppositeNumber(numbers, operators, number);
                    } else {
                        numbers.push(number);
                    }
                    prevIndex = Integer.MAX_VALUE;
                }

                if (nextChar == ')') { // if close operator then we can calculate formula till previous open operator
                    while (!operators.isEmpty() && operators.peek() != '(') {
                        numbers.push(calculate(numbers.pop(), operators.pop(), numbers.pop()));
                    }
                    operators.pop(); // close '('
                    while (numbers.size() > 1 && higherPriority.contains(operators.peek())) {
                        numbers.push(calculate(numbers.pop(), operators.pop(), numbers.pop()));
                    }
                } else if (!Character.isDigit(nextChar)) {
                    operators.push(nextChar);
                }
            } else if (prevIndex == Integer.MAX_VALUE) { // isDigit
                prevIndex = i;
            }
        }

        while (numbers.size() > 1) {
            numbers.push(calculate(numbers.pop(), operators.pop(), numbers.pop()));
        }
        return numbers.pop();
    }

    private void addOppositeNumber(ArrayDeque<Integer> numbers, ArrayDeque<Character> operators, int number) {
        number *= -1;
        numbers.push(number);
        operators.pop();
        operators.push('+');
    }

    private int parseInt(String s, int prevIndex, int i) {
        String substr;
        if (Character.isDigit(s.charAt(i))) {
            if (prevIndex == Integer.MAX_VALUE) {
                substr = s.substring(i, i + 1);
            } else {
                substr = s.substring(prevIndex, i + 1);
            }
        } else {
            substr = s.substring(prevIndex, i);
        }
        return Integer.parseInt(substr);
    }

    private int calculate(int b, char operator, int a) {
        var result = 0;
        if (operator == '*') {
            result = a * b;
        } else if (operator == '/') {
            result = a / b;
        } else if (operator == '+') {
            result = a + b;
        } else {
            result = a - b;
        }
        System.out.println(a + " " + operator + " " + b + " = " + result);
        return result;
    }

}
