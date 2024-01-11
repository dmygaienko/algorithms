package com.mygaienko.common.algorithms.leetcode.print_linked_list_in_reverse;

import java.util.ArrayDeque;

public class Solution {

    public void printLinkedListInReverse(ImmutableListNode node) {
        int size = getSize(node);
        int blockSize = (int) Math.ceil(Math.sqrt(size));
        var stack = new ArrayDeque<ImmutableListNode>();
        for (int i = 0; i < size; i++) {
            if (i % blockSize == 0) {
                stack.push(node);
            }
            node = node.getNext();
        }

        while (!stack.isEmpty()) {
            print(stack.pop(), blockSize);
        }
    }

    private void print(ImmutableListNode node, int length) {
        if (node != null && length > 0) {
            print(node.getNext(), length - 1);
            node.printValue();
        }
    }

    private int getSize(ImmutableListNode node) {
        int size = 0;
        while (node != null) {
            size++;
            node = node.getNext();
        }
        return size;
    }
}

interface ImmutableListNode {
    public void printValue(); // print the value of this node.

    public ImmutableListNode getNext(); // return the next node.
};
