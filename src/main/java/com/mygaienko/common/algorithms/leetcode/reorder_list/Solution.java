package com.mygaienko.common.algorithms.leetcode.reorder_list;

import java.util.ArrayDeque;

class Solution {
    public void reorderList(ListNode head) {
        var stack = iterate(head);

        var node = head;
        var next = node.next;
        while (!stack.isEmpty() && !node.equals(stack.peek()) && !next.equals(stack.peek())) {
            var popped = stack.pop();
            node.next = popped;
            node.next.next = next;

            node = next;
            next = next.next;
        }

        if (!stack.isEmpty() && next.equals(stack.peek())) {
            var popped = stack.pop();
            node.next = popped;
            node.next.next = next;

            node = next;
            next = next.next;
        }

        node.next = null;

    }

    private static ArrayDeque<ListNode> iterate(ListNode head) {
        var stack = new ArrayDeque<ListNode>();

        var nextNode = head;
        while (nextNode.next != null) {
            stack.push(nextNode.next);
            nextNode = nextNode.next;
        }
        return stack;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
