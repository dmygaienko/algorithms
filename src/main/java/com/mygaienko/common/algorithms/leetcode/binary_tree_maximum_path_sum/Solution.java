package com.mygaienko.common.algorithms.leetcode.binary_tree_maximum_path_sum;

class Solution {

    public int maxPathSum(TreeNode root) {
        Sum sum = pathSum(root);
        return Math.max(sum.val, sum.cum);
    }

    private Sum pathSum(TreeNode root) {
        if (root == null) return new Sum(Integer.MIN_VALUE, Integer.MIN_VALUE);

        int val = root.val;
        Sum left = null;
        if (root.left != null) {
            left = pathSum(root.left);
        }

        Sum right = null;
        if (root.right != null) {
            right = pathSum(root.right);
        }

        int sum = val;
        if (left != null) {
            sum = Math.max(sum, left.val + val);
        }

        if (right != null) {
            sum = Math.max(sum, right.val + val);
        }

        int cum = val;
        if (left != null) {
            cum = Math.max(cum, left.val);
            cum = Math.max(cum, left.cum);
            if (right != null) {
                cum = Math.max(cum, left.val + right.val + val);
            }
        }

        if (right != null) {
            cum = Math.max(cum, right.val);
            cum = Math.max(cum, right.cum);
        }

        return new Sum(sum, cum);
    }

    private static class Sum {
        int val;
        int cum;

        Sum(int val, int cum) {
            this.val = val;
            this.cum = cum;
        }
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

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}
