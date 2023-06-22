package com.mygaienko.common.algorithms.leetcode.flatten_nested_list_iterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {

    final LinkedList<NestedInteger> linkedList;

    public NestedIterator(List<NestedInteger> nestedList) {
        linkedList = new LinkedList<>(nestedList == null ? List.of() : nestedList);
    }

    @Override
    public Integer next() {
        if (linkedList.isEmpty()) {
            return -1;
        }

        NestedInteger next = linkedList.pop();
        while (!next.isInteger()) {
            linkedList.addAll(0, next.getList());
            next = linkedList.pop();
        }

        return next.getInteger();
    }

    @Override
    public boolean hasNext() {
        NestedInteger next = linkedList.peek();

        while (next != null && !next.isInteger()) {
            next = linkedList.pop();
            linkedList.addAll(0, next.getList());
            next = linkedList.peek();
        }

        return next != null && next.isInteger();
    }
}

class NestedInteger {

    Integer val = null;

    List<NestedInteger> list = null;

    public NestedInteger(List<NestedInteger> list) {
        this.list = list;
    }

    public NestedInteger(Integer val) {
        this.val = val;
    }

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    boolean isInteger() {
        return val != null;
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    Integer getInteger() {
        return val;
    }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    List<NestedInteger> getList() {
        return list;
    }

}
