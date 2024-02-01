package com.mygaienko.common.algorithms.leetcode.clone_binary_tree_with_random_pointer;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public NodeCopy copyRandomBinaryTree(Node root) {
        return copy(root, new HashMap<>());
    }

    private NodeCopy copy(Node root, Map<Node, NodeCopy> memo) {
        if (root == null) return null;

        var rootCopy = memo.get(root);
        if (rootCopy != null) {
            return rootCopy; //seen
        } else {
            rootCopy = memo.compute(root, (k, v) -> new NodeCopy(root.val));
        }

        rootCopy.left = copy(root.left, memo);
        rootCopy.right = copy(root.right, memo);
        rootCopy.random = copy(root.random, memo);

        return rootCopy;
    }
}

class Node {
    int val;
    Node left;
    Node right;
    Node random;

    Node() {
    }

    Node(int val) {
        this.val = val;
    }

    Node(int val, Node left, Node right, Node random) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.random = random;
    }
}

class NodeCopy {
    int val;
    NodeCopy left;
    NodeCopy right;
    NodeCopy random;

    NodeCopy() {
    }

    NodeCopy(int val) {
        this.val = val;
    }

    NodeCopy(int val, NodeCopy left, NodeCopy right, NodeCopy random) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.random = random;
    }
}
