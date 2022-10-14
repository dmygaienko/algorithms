package com.mygaienko.common.algorithms.leetcode.nested_list_weight_sum_ii;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;


class Solution {

    public int depthSumInverse(List<NestedInteger> nestedList) {

        Deque<NestedInteger> queue = new ArrayDeque<>();
        nestedList.forEach(queue::offer);

        int[] levelSum = new int[50];

        int size = nestedList.size();
        int nextSize = 0;

        int currentDepth = 0;
        int sum = 0;

        while (!queue.isEmpty()) {
            --size;

            NestedInteger next = queue.poll();
            if (next.isInteger()) {
                sum += next.getInteger();
            } else {
                next.getList().forEach(queue::offer);
                nextSize += next.getList().size();
            }

            if (size == 0) {
                size = nextSize;
                nextSize = 0;

                levelSum[currentDepth] = sum;
                sum = 0;

                currentDepth++;
            }
        }

        return calculateSum(levelSum, currentDepth);
    }

    private int calculateSum(int[] levelSums, int depth) {
        int sum = 0;
        for (int i = 0; i < depth; i++) {
            int levelSum = levelSums[i];
            sum = sum + levelSum * (depth - i);
        }
        return sum;
    }

}

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
 interface NestedInteger {
    // Constructor initializes an empty nested list.


    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    Integer getInteger();

    // Set this NestedInteger to hold a single integer.
    void setInteger(int value);

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    void add(NestedInteger ni);

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    List<NestedInteger> getList();

}