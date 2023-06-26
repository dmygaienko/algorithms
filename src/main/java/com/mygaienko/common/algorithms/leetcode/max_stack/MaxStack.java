package com.mygaienko.common.algorithms.leetcode.max_stack;

import java.util.*;

class MaxStack {

    ArrayDeque<Integer> stack = new ArrayDeque<>();
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
    Map<Integer, Integer> toDelete = new HashMap<>();

    public void push(int x) {
        clear();

        stack.push(x);
        priorityQueue.offer(x);
    }

    public int pop() {
        clear();

        boolean trunc = false;
        int popped = Integer.MIN_VALUE;
        while (!trunc && !stack.isEmpty()) {
            var poppedVal = stack.pop();
            trunc = priorityQueue.remove(poppedVal);
            if (trunc) {
                popped = poppedVal;
            }
        }

        clear();
        return popped;
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        clear();
        return !priorityQueue.isEmpty() ? priorityQueue.peek() : Integer.MIN_VALUE;
    }

    public int popMax() {
        clear();
        int max = !priorityQueue.isEmpty() ? priorityQueue.poll() : Integer.MIN_VALUE;
        if (max == top()) {
            stack.pop();
        } else {
            toDelete.compute(max, (k, v) ->  v == null ? 1 : v + 1);
        }
        clear();
        return max;
    }

    private void clear() {
        while(!stack.isEmpty() && toDelete.getOrDefault(stack.peek(), 0) > 0) {
            Integer popped = stack.pop();
            toDelete.compute(popped, (k, v) ->  v == 1 ? null : v - 1);
        }
    }
}
