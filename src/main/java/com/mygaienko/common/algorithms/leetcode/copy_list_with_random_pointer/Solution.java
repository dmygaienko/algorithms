package com.mygaienko.common.algorithms.leetcode.copy_list_with_random_pointer;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public Node copyRandomList(Node head) {
        return getOrDeepCopy(head, head, 0, new HashMap<>());
    }

    private Node getOrDeepCopy(Node head, Node origin, int i, Map<Integer, Node> register) {
        if (origin == null) return null;

        Node copy = register.computeIfAbsent(i, v -> new Node(origin.val));

        if (origin.next != null && copy.next == null) {
            copy.next = getOrDeepCopy(head, origin.next, i+1, register);
        }

        if (origin.random != null && copy.random == null) {
            copy.random = findIndex(head, origin.random, register);
        }

        return copy;
    }

    private Node findIndex(Node head, Node random, Map<Integer, Node> register) {
        int i = 0;
        while (head != random) {
            head = head.next;
            i++;
        }
        return register.computeIfAbsent(i, v -> new Node(random.val));
    }

}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
