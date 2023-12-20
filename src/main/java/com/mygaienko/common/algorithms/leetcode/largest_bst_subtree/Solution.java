package com.mygaienko.common.algorithms.leetcode.largest_bst_subtree;

class Solution {

    public int largestBSTSubtree(TreeNode root) {
        return largestSubtree(root)[2];
    }

    public int[] largestSubtree(TreeNode root) {
        if (root == null) { // if root null then tree is valid but with zero size
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        var leftResult = largestSubtree(root.left);
        var rightResult = largestSubtree(root.right);


        //if both subtrees are valid then the largest subtree will be the sum of them plus current node
        if (leftResult[1] < root.val && root.val < rightResult[0]) {
            return new int[]{
                    Math.min(leftResult[0], root.val),
                    Math.max(rightResult[1], root.val),
                    1 + leftResult[2] + rightResult[2]
            };
        }

        //or return not valid tree and propagate the biggest size from children
        return new int[]{
                Integer.MIN_VALUE,
                Integer.MAX_VALUE,
                Math.max(leftResult[2], rightResult[2])};
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