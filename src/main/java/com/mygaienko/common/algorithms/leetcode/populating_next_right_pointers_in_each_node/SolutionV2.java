package com.mygaienko.common.algorithms.leetcode.populating_next_right_pointers_in_each_node;

import java.util.ArrayDeque;
import java.util.Queue;

class SolutionV2 {

    public Node connect(Node root) {
        if (root == null) return null;

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();

                if (i < size - 1) {
                    current.next = queue.peek();
                }

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

        }

        return root;
    }

}
