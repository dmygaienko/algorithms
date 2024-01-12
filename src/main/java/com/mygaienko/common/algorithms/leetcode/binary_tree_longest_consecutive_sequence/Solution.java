package com.mygaienko.common.algorithms.leetcode.binary_tree_longest_consecutive_sequence;


class Solution {

    int max = 0;

    public int longestConsecutive(TreeNode root) {
        longest(root);
        return max;
    }

    private int longest(TreeNode root) {
        int current = 1;

        if (root.left != null) {
            var leftResult = 0;
            if (root.val + 1 == root.left.val) {
                leftResult = 1 + longest(root.left);
            } else {
                longest(root.left);
            }
            current = Math.max(current, leftResult);
        }

        if (root.right != null) {
            var rightResult = 0;
            if (root.val + 1 == root.right.val) {
                rightResult = 1 + longest(root.right);
            } else {
                longest(root.right);
            }
            current = Math.max(current, rightResult);
        }

        max = Math.max(max, current);

        return current;
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
