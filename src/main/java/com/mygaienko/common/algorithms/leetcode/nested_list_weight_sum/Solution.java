package com.mygaienko.common.algorithms.leetcode.nested_list_weight_sum;

import java.util.List;

/**
 * 339. Nested List Weight Sum https://leetcode.com/problems/nested-list-weight-sum/
 */
public class Solution {

    public int depthSum(List<NestedInteger> nestedList) {
        return depthSum(1, nestedList);
    }

    private int depthSum(int level, List<NestedInteger> nestedList) {
        int sum = 0;
        for (NestedInteger nestedInteger : nestedList) {
            int value;
            if (nestedInteger.isInteger()) {
                value = nestedInteger.getInteger() + level;
            } else {
                value = depthSum(level + 1, nestedInteger.getList());
            }
            sum += value;
        }

        return sum;
    }
}

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
abstract class NestedInteger {
    // Constructor initializes an empty nested list.
    public NestedInteger() {
    }

    // Constructor initializes a single integer.
    public NestedInteger(int value) {
    }

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public abstract boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public abstract Integer getInteger();

    // Set this NestedInteger to hold a single integer.
    public abstract void setInteger(int value);

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public abstract void add(NestedInteger ni);

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public abstract List<NestedInteger> getList();
}
