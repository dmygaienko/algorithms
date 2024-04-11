package com.mygaienko.common.algorithms.leetcode.closest_binary_search_tree_value;

import com.mygaienko.common.algorithms.leetcode.common.TreeNode;

class Solution {

    public int closestValue(TreeNode root, double target) {
        if (root == null) return Integer.MAX_VALUE;
        return (int) closestValue(root, target, root.val);
    }

    private double closestValue(TreeNode root, double target, double current) {
        if (root == null) return current;

        var closest = current;
        if (Math.abs(target - current) > Math.abs(target - root.val)) {
            closest = root.val;
        }

        if (Math.abs(target - current) == Math.abs(target - root.val)) {
            closest = Math.min(closest, root.val);
        }

        closest = closestValue(root.left, target, closest);
        closest = closestValue(root.right, target, closest);

        return closest;
    }

}
