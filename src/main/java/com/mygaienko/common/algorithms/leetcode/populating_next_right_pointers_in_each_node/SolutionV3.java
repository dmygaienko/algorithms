package com.mygaienko.common.algorithms.leetcode.populating_next_right_pointers_in_each_node;

import java.util.ArrayDeque;
import java.util.Queue;

class SolutionV3 {

    public Node connect(Node root) {
        if (root == null) return null;

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            Node prev = null;

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }

                if (prev != null) {
                    prev.next = current;
                }

                prev = current;
            }
        }

        return root;
    }
}
