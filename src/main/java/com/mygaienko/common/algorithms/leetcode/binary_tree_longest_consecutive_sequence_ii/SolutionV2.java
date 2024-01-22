package com.mygaienko.common.algorithms.leetcode.binary_tree_longest_consecutive_sequence_ii;

public class SolutionV2 {
    int maxval = 0;

    public int longestConsecutive(TreeNode root) {
        longestPath(root);
        return maxval;
    }

    public int[] longestPath(TreeNode root) {
        if (root == null) return new int[]{0, 0};

        var increment = 1;
        var decrement = 1;

        if (root.left != null) {
            var result = longestPath(root.left);
            if (root.val + 1 == root.left.val) {
                increment = 1 + result[0];
            } else if (root.val == root.left.val + 1) {
                decrement = 1 + result[1];
            }
        }

        if (root.right != null) {
            var result = longestPath(root.right);
            if (root.val + 1 == root.right.val) {
                increment = Math.max(increment, 1 + result[0]);
            } else if (root.val == root.right.val + 1) {
                decrement = Math.max(decrement, 1 + result[1]);
            }
        }

        maxval = Math.max(maxval, increment + decrement - 1);

        return new int[]{increment, decrement};
    }
}
