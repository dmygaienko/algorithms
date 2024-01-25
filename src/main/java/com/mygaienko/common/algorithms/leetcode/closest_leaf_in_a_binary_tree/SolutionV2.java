package com.mygaienko.common.algorithms.leetcode.closest_leaf_in_a_binary_tree;

class SolutionV2 {

    int closest = Integer.MAX_VALUE;
    int closestNode = Integer.MAX_VALUE;

    public int findClosestLeaf(TreeNode root, int k) {
        findClosest(root, k);
        return closestNode;
    }

    private int[] findClosest(TreeNode root, int k) {
        if (root == null) return new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};

        // found leaf
        if (root.left == null && root.right == null) {
            if (root.val == k) {
                closestNode = root.val;
            }
            return new int[]{Integer.MAX_VALUE, 1, root.val};
        }

        var left = findClosest(root.left, k);
        var right = findClosest(root.right, k);

        var minDistanceToK = root.val == k ? 0 : Math.min(left[0], right[0]);
        int minDistanceToLeaf;
        int leafNode;
        if (left[1] < right[1]) {
            minDistanceToLeaf = left[1];
            leafNode = left[2];
        } else {
            minDistanceToLeaf = right[1];
            leafNode = right[2];
        }

        if (minDistanceToK != Integer.MAX_VALUE && minDistanceToLeaf != Integer.MAX_VALUE && minDistanceToK + minDistanceToLeaf < closest) {
            closest = minDistanceToK + minDistanceToLeaf;
            closestNode = leafNode;
        }

        return new int[]{
                minDistanceToK != Integer.MAX_VALUE ? minDistanceToK + 1 : minDistanceToK,
                minDistanceToLeaf != Integer.MAX_VALUE ? minDistanceToLeaf + 1 : minDistanceToLeaf,
                leafNode};
    }
}
