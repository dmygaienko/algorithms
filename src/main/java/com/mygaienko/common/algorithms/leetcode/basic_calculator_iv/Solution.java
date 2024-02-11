package com.mygaienko.common.algorithms.leetcode.basic_calculator_iv;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * Shunting Yard algorithm
 */
class Solution {

    public List<String> basicCalculatorIV(String expression, String[] evalvars, int[] evalints) {
        var vars = new HashMap<String, Integer>();
        for (int i = 0; i < evalvars.length; i++) {
            vars.put(evalvars[i], evalints[i]);
        }

        var nums = new ArrayDeque<Poly>();
        var ops = new ArrayDeque<Character>();

        for (int i = 0; i < expression.length(); i++) {
            var ch = expression.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                var next = getNext(expression, i);
                var term = expression.substring(i, next + 1);
                i = next;
                nums.push(new Poly(term, vars));
            } else if (ch == '(') {
                ops.push(ch);
            } else if (ch == ')') {
                while (!ops.isEmpty() && ops.peek() != '(') {
                    nums.push(apply(nums, ops));
                }
                ops.pop();
            } else if (ch == '+' || ch == '-' || ch == '*') {
                while (!ops.isEmpty() && precedence(ops.peek()) >= precedence(ch)) {
                    nums.push(apply(nums, ops));
                }
                ops.push(ch);
            }
        }

        while (!ops.isEmpty()) {
            nums.push(apply(nums, ops));
        }

        return nums.peek().eval();
    }

    private int precedence(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        } else if (ch == '*' || ch == '/') {
            return 2;
        }
        return 0;
    }

    private Poly apply(ArrayDeque<Poly> nums, ArrayDeque<Character> ops) {
        var operator = ops.pop();
        var right = nums.pop();
        var left = nums.pop();
        Poly next;
        if (operator == '*') {
            next = left.multiply(right);
        } else if (operator == '+') {
            next = left.plus(right);
        } else {
            next = left.minus(right);
        }
        return next;
    }

    private int getNext(String expression, int i) {
        while (i < expression.length() && Character.isLetterOrDigit(expression.charAt(i))) {
            i++;
        }
        return i - 1;
    }

    public static class Poly {
        List<Term> terms = new ArrayList<>();

        public Poly(HashMap<Term, Integer> map) {
            for (var entry : map.entrySet()) {
                if (entry.getValue() != 0) {
                    var term = entry.getKey();
                    term.coefficient = entry.getValue();
                    terms.add(term);
                }
            }
        }

        public Poly(String s, HashMap<String, Integer> vars) {
            String val = s;
            if (vars.containsKey(s)) {
                val = String.valueOf(vars.get(s));
            }

            Term term;
            if (val.charAt(0) == '-' || Character.isDigit(val.charAt(0))) {
                term = new Term(Integer.parseInt(val));
            } else {
                term = new Term(val);
            }
            terms.add(term);
        }

        public List<String> eval() {
            terms.sort((Term a, Term b) -> {
                if (a.variables.size() != b.variables.size()) {
                    return b.variables.size() - a.variables.size();
                }
                for (int i = 0; i < a.variables.size(); i++) {
                    if (a.variables.get(i).compareTo(b.variables.get(i)) != 0) {
                        return a.variables.get(i).compareTo(b.variables.get(i));
                    }
                }
                return 0;
            });

            var result = new ArrayList<String>();
            for (var term : terms) {
                var prettyPrint = term.print();
                if (!prettyPrint.equals("")) {
                    result.add(prettyPrint);
                }
            }
            return result;
        }

        public Poly multiply(Poly b) {
            var map = new HashMap<Term, Integer>();
            for (Term term : this.terms) {
                for (Term that : b.terms) {
                    var newTerm = new Term();
                    newTerm.coefficient = term.coefficient * that.coefficient;
                    newTerm.addVariables(term.variables);
                    newTerm.addVariables(that.variables);
                    map.merge(newTerm, newTerm.coefficient, Integer::sum);
                }
            }
            return new Poly(map);
        }

        public Poly plus(Poly that) {
            var map = new HashMap<Term, Integer>();
            for (var term : this.terms) {
                map.put(term, term.coefficient);
            }
            for (var term : that.terms) {
                map.merge(term, term.coefficient, Integer::sum);
            }
            return new Poly(map);
        }

        public Poly minus(Poly b) {
            for (var term : b.terms) {
                term.coefficient *= -1;
            }
            return plus(b);
        }

        @Override
        public String toString() {
            return "Poly{" +
                    "terms=" + terms +
                    '}';
        }
    }

    private static class Term {
        int coefficient = 1;
        List<String> variables = new ArrayList<>();

        public Term() {
        }

        public Term(int coefficient) {
            this.coefficient = coefficient;
        }

        public Term(String var) {
            variables.add(var);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Term term = (Term) o;

            return Objects.equals(variables, term.variables);
        }

        @Override
        public int hashCode() {
            return variables != null ? variables.hashCode() : 0;
        }

        public String getKey() {
            var sb = new StringBuilder();
            for (var var : variables) {
                sb.append(var);
                sb.append('*');
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        }

        public String print() {
            if (coefficient == 0) return "";
            if (variables.isEmpty()) return String.valueOf(coefficient);
            return String.valueOf(coefficient) + '*' + getKey();
        }

        @Override
        public String toString() {
            return "Term{" +
                    ", coefficient=" + coefficient +
                    ", variables=" + variables +
                    '}';
        }

        public void addVariables(List<String> variables) {
            this.variables.addAll(variables);
            this.variables.sort(Comparator.naturalOrder());
        }
    }
}