package com.mygaienko.common.algorithms.leetcode.min_stack;

import java.util.LinkedList;
import java.util.PriorityQueue;

class MinStack {

    PriorityQueue<Integer> tree = new PriorityQueue<>((a, b) -> a < b ? -1 : (a > b ? 1 : 0));
    LinkedList<Integer> linked = new LinkedList<>();

    public MinStack() {

    }

    public void push(int val) {
        tree.add(val);
        linked.add(val);
    }

    public void pop() {
        if (!linked.isEmpty()) {
            int val = linked.removeLast();
            tree.remove(val);
        }

    }

    public int top() {
        return linked.peekLast();
    }

    public int getMin() {
        return tree.peek();
    }
}
