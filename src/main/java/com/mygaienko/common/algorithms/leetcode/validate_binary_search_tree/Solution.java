package com.mygaienko.common.algorithms.leetcode.validate_binary_search_tree;

public class Solution {

    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long from, long to) {
        if (node == null) {
            return true;
        }

        if (node.val <= from || node.val >= to) {
            return false;
        }

        return validate(node.left, from, node.val) && validate(node.right, node.val, to);
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
