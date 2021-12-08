package com.mygaienko.common.algorithms.leetcode.find_leaves_of_binary_tree;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        while (root.left != null || root.right != null) {
            List<Integer> leaves = new ArrayList<>();
            visitNode(root, leaves);
            result.add(leaves);
        }

        result.add(List.of(root.val));

        return result;
    }

    private boolean visitNode(TreeNode node, List<Integer> leaves) {
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
            return true;
        }

        if (node.left != null) {
            if (visitNode(node.left, leaves)) node.left = null;
        }

        if (node.right != null){
            if (visitNode(node.right, leaves)) node.right = null;

        }

        return false;

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
