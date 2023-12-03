package com.mygaienko.common.algorithms.leetcode.find_largest_value_in_each_tree_row;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> largestValues(TreeNode root) {
        var largest = new ArrayList<Integer>();
        if (root == null) return largest;

        var queue = new ArrayDeque<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            var max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                var node = queue.poll();
                max = Math.max(max, node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            largest.add(max);
        }

        return largest;
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

