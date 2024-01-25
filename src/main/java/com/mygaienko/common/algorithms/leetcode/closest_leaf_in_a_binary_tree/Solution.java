package com.mygaienko.common.algorithms.leetcode.closest_leaf_in_a_binary_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

class Solution {

    public int findClosestLeaf(TreeNode root, int k) {
        var graph = toGraph(new HashMap<>(), root, null);

        var seen = new HashSet<Integer>();
        var queue = new ArrayDeque<TreeNode>();
        for (var entry : graph.entrySet()) {
            if (entry.getKey() != null && entry.getKey().val == k) {
                queue.add(entry.getKey());
                seen.add(entry.getKey().val);
            }
        }

        while (!queue.isEmpty()) {
            var next = queue.poll();
            if (next == null) continue;

            var adjacent = graph.get(next);
            if (adjacent == null || adjacent.size() < 2) {
                return next.val;
            }

            for (var neigh : adjacent) {
                if (neigh == null) continue;
                if (!seen.contains(neigh.val)) {
                    queue.add(neigh);
                    seen.add(neigh.val);
                }
            }
        }

        return -1;
    }

    private Map<TreeNode, List<TreeNode>> toGraph(Map<TreeNode, List<TreeNode>> graph, TreeNode node, TreeNode parent) {
        if (node != null) {
            graph.computeIfAbsent(node, v -> new ArrayList<>()).add(parent);
            graph.computeIfAbsent(parent, v -> new ArrayList<>()).add(node);

            toGraph(graph, node.left, node);
            toGraph(graph, node.right, node);
        }

        return graph;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
