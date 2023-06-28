package com.mygaienko.common.algorithms.leetcode.max_stack;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;

class MaxStack {

    int DEFAULT = 0;
    int TO_DELETE = 1;

    int count = 0;

    final ArrayDeque<int[]> stack = new ArrayDeque<>();
    final PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(
            Comparator.<int[]>comparingInt(arr -> arr[0])
                    .thenComparingInt(arr -> arr[2]).reversed()
                    .thenComparingInt(arr -> arr[1]));

    public void push(int x) {
        clear();

        int[] var = new int[]{x, DEFAULT, ++count};
        stack.push(var);
        priorityQueue.offer(var);
    }

    public int pop() {
        clear();

        var poppedVal = stack.pop();
        priorityQueue.remove(poppedVal);
        int popped = poppedVal[0];

        clear();
        return popped;
    }

    public int top() {
        clear();
        return !stack.isEmpty() ? stack.peek()[0] : Integer.MIN_VALUE;
    }

    public int peekMax() {
        clear();
        return !priorityQueue.isEmpty() ? priorityQueue.peek()[0] : Integer.MIN_VALUE;
    }

    public int popMax() {
        clear();
        if (priorityQueue.isEmpty()) return Integer.MIN_VALUE;

        int[] maxVal = priorityQueue.poll();
        int max = maxVal[0];
        maxVal[1] = TO_DELETE;

        clear();
        return max;
    }

    private void clear() {
        while (!stack.isEmpty() && stack.peek()[1] == TO_DELETE) {
            stack.pop();
        }
    }
}
