package com.mygaienko.common.algorithms.leetcode.delete_nodes_and_return_forest;

import com.mygaienko.common.algorithms.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        var toDelete = new HashSet<Integer>();
        for (var val : to_delete) {
            toDelete.add(val);
        }

        var queue = new ArrayDeque<TreeNode>();
        queue.add(root);

        var results = new ArrayList<TreeNode>();
        if (!toDelete.contains(root.val)) {
            results.add(root);
        }

        while (!queue.isEmpty()) {
            var next = queue.poll();

            if (toDelete.contains(next.val)) {
                if (next.left != null) {
                    if (!toDelete.contains(next.left.val)) {
                        results.add(next.left);
                    }
                }

                if (next.right != null) {
                    if (!toDelete.contains(next.right.val)) {
                        results.add(next.right);
                    }
                }
            }

            if (next.left != null) {
                queue.offer(next.left);
                if (toDelete.contains(next.left.val)) {
                    next.left = null;
                }
            }

            if (next.right != null) {
                queue.offer(next.right);
                if (toDelete.contains(next.right.val)) {
                    next.right = null;
                }
            }
        }

        return results;
    }

}
