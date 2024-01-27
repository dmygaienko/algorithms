package com.mygaienko.common.algorithms.leetcode.maximum_average_subtree;

class Solution {
    public double maximumAverageSubtree(TreeNode root) {
        return maximumAverage(root)[2];
    }

    private double[] maximumAverage(TreeNode root) {
        if (root == null) return new double[]{0.0d, 0.0d, 0.0d}; // currSum, currCount, maxAvg

        var left = maximumAverage(root.left);
        var right = maximumAverage(root.right);

        var currSum = root.val + left[0] + right[0];
        var currCount = 1 + left[1] + right[1];
        var currAvg = currSum / currCount;
        var maxAvg = Math.max(currAvg, left[2]);
        maxAvg = Math.max(maxAvg, right[2]);

        return new double[]{currSum, currCount, maxAvg};
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
