package com.mygaienko.common.algorithms.leetcode.max_stack;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;

class MaxStack {

    ArrayDeque<Integer> stack = new ArrayDeque<>();
    PriorityQueue<Integer> order = new PriorityQueue<>(Comparator.reverseOrder());

    public MaxStack() {

    }

    public void push(int x) {
        stack.push(x);
        order.offer(x);
    }

    public int pop() {
        Integer popped = stack.pop();
        order.remove(popped);
        return popped;
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return !order.isEmpty() ? order.peek() : Integer.MIN_VALUE;
    }

    public int popMax() {
        int max = !order.isEmpty() ? order.poll() : Integer.MIN_VALUE;
        if (max == top()) {
            pop();
        }
        return max;
    }
}
