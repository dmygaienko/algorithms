package com.mygaienko.common.algorithms.leetcode.design_an_expression_tree_with_evaluate_function;

import java.util.ArrayDeque;
import java.util.Set;

/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */

abstract class Node {
    public abstract int evaluate();
    // define your fields here
};

class NumericNode extends Node {
    Integer number;

    NumericNode(String token) {
        number = Integer.parseInt(token);
    }

    public int evaluate() {
        return number;
    }
}

class OperatorNode extends Node {

    String operator;
    Node left;
    Node right;

    OperatorNode(String token, Node left, Node right) {
        operator = token;
        this.left = left;
        this.right = right;
    }

    public int evaluate() {
        var leftNumber = left.evaluate();
        var rightNumber = right.evaluate();

        if (operator.equals("+")) {
            return leftNumber + rightNumber;
        } else if (operator.equals("-")) {
            return leftNumber - rightNumber;
        } else if (operator.equals("*")) {
            return leftNumber * rightNumber;
        } else {
            return leftNumber / rightNumber;
        }
    }
}


/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input
 * and returns the expression tree representing it as a Node.
 */

class TreeBuilder {

    Node buildTree(String[] postfix) {
        var plusMinus = Set.of("+", "-");
        var multiplyDivide = Set.of("*", "/");

        var stack = new ArrayDeque<Node>();
        for (var token : postfix) {
            if (plusMinus.contains(token) || multiplyDivide.contains(token)) {
                var right = stack.pop();
                var left = stack.pop();
                stack.push(new OperatorNode(token, left, right));
            } else {
                stack.push(new NumericNode(token));
            }
        }

        return stack.peek();
    }
};


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */