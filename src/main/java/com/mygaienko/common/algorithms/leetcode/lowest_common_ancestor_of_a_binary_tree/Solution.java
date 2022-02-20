package com.mygaienko.common.algorithms.leetcode.lowest_common_ancestor_of_a_binary_tree;

class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findLowestCommonAncestor(root, p, q).common;
    }

    private Result findLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Result result = new Result();
        if (root == null) return result;
        if (root.val == p.val) {
            result.findP = true;
        }
        if (root.val == q.val) {
            result.findQ = true;
        }
        if (result.findP && result.findQ) {
            result.common = root;
            return result;
        }

        Result leftResult = findLowestCommonAncestor(root.left, p, q);
        applyResult(result, leftResult, root);

        Result rightResult = findLowestCommonAncestor(root.right, p, q);
        applyResult(result, rightResult, root);

        return result;
    }

    private void applyResult(Result root, Result from, TreeNode node) {
        if (from.findP) {
            root.findP = true;
        }

        if (from.findQ) {
            root.findQ = true;
        }

        if (from.common != null) {
            root.common = from.common;
        }

        if (root.findP && root.findQ && root.common == null) {
            root.common = node;
        }
    }
}

class Result {
    boolean findP;
    boolean findQ;
    TreeNode common;
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
