package com.mygaienko.common.algorithms.leetcode.zigzag_iterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagIterator {

    Queue<Iterator<Integer>> queue = new LinkedList<>();

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        addNonEmptyIterator(v1);
        addNonEmptyIterator(v2);
    }

    public int next() {
        var next = queue.poll();
        var result = next.next();
        if (next.hasNext()) {
            queue.offer(next);
        }
        return result;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }

    private void addNonEmptyIterator(List<Integer> list) {
        if (!list.isEmpty()) {
            queue.offer(list.iterator());
        }
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */