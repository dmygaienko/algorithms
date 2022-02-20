package com.mygaienko.common.algorithms.leetcode.n_ary_tree_level_order_traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        int level = queue.size();
        while(!queue.isEmpty()) {

            List<Integer> levelNodes = new ArrayList<>();
            for (; level > 0; level--) {
                Node next = queue.poll();
                levelNodes.add(next.val);
                if (next.children != null) {
                    for (Node child : next.children) {
                        queue.offer(child);
                    }
                }
            }
            result.add(levelNodes);

            if (level == 0) {
                level = queue.size();
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
