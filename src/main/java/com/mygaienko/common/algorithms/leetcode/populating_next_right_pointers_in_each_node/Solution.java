package com.mygaienko.common.algorithms.leetcode.populating_next_right_pointers_in_each_node;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {

    public Node connect(Node root) {
        if (root == null) return null;

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        int currentLevel = queue.size();

        Node prev = null;
        while (!queue.isEmpty()) {
            currentLevel--;

            Node curr = queue.poll();

            if (curr.left != null) {
                queue.offer(curr.left);
            }
            if (curr.right != null) {
                queue.offer(curr.right);
            }

            if (prev != null && currentLevel >= 0) {
                prev.next = curr;
            }

            if (currentLevel == 0) {
                prev = null;
                currentLevel = queue.size();
            } else {
                prev = curr;
            }

        }

        return root;
    }

}


class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
