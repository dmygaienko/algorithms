package com.mygaienko.common.algorithms.leetcode.preorder_traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;


class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        var result = new ArrayList<Integer>();
        if (root == null) return result;
        var stack = new ArrayDeque<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            var next = stack.pop();
            result.add(next.val);
            if (next.right != null) {
                stack.push(next.right);
            }

            if (next.left != null) {
                stack.push(next.left);
            }
        }
        return result;
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