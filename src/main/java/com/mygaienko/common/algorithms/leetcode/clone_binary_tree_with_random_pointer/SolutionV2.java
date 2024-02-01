package com.mygaienko.common.algorithms.leetcode.clone_binary_tree_with_random_pointer;

import java.util.ArrayDeque;
import java.util.HashMap;

class SolutionV2 {
    public NodeCopy copyRandomBinaryTree(Node root) {
        if (root == null) return null;

        var seen = new HashMap<Node, NodeCopy>();
        var queue = new ArrayDeque<Node>();

        var rootCopy = new NodeCopy(root.val);
        seen.put(root, rootCopy);
        queue.add(root);

        while (!queue.isEmpty()) {
            var next = queue.poll();
            var copy = seen.get(next);

            copy.left = getOrCreate(seen, queue, next.left);
            copy.right = getOrCreate(seen, queue, next.right);
            copy.random = getOrCreate(seen, queue, next.random);
        }

        return rootCopy;
    }

    private NodeCopy getOrCreate(HashMap<Node, NodeCopy> seen, ArrayDeque<Node> queue, Node node) {
        if (node == null) return null;

        var nextCopy = seen.get(node);
        if (nextCopy == null) {
            nextCopy = new NodeCopy(node.val);
            seen.put(node, nextCopy);
            queue.add(node);
        }

        return nextCopy;
    }

}
