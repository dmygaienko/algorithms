package com.mygaienko.common.algorithms.leetcode.n_ary_tree_preorder_traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> preorder(Node root) {
        if (root == null) return List.of();

        List<Integer> result = new ArrayList<>();

        ArrayDeque<Node> stack = new ArrayDeque<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            Node next = stack.pop();
            result.add(next.val);

            if (next.children != null) {
                for (int i = next.children.size() - 1; i >= 0; i--) {
                    Node child = next.children.get(i);
                    stack.push(child);
                }
            }

        }

        return result;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
