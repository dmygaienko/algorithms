package com.mygaienko.common.algorithms.leetcode.find_root_of_n_ary_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public Node findRoot(List<Node> tree) {
        if (tree == null || tree.isEmpty()) return null;

        Map<Node, Integer> inDegree = new HashMap<Node, Integer>();
        for (var node : tree) {
            inDegree.computeIfAbsent(node, v -> 0);
            for (var child : node.children) {
                inDegree.compute(child, (k, v) -> v == null ? 1 : v + 1);
            }
        }

        Node root = null;
        for (var entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                return entry.getKey();
            }
        }
        return root;
    }

    public Node findRoot2(List<Node> tree) {
        if (tree == null || tree.isEmpty()) return null;

        int sum = 0;
        for (var node : tree) {
            sum += node.val;
            for (var child : node.children) {
                sum -= child.val;
            }
        }

        Node root = null;
        for (var node : tree) {
            if (node.val == sum) {
                root = node;
                break;
            }
        }

        return root;
    }
}

class Node {
    public int val;
    public List<Node> children;


    public Node() {
        children = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
}