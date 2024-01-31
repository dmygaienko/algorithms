package com.mygaienko.common.algorithms.leetcode.two_sum_bsts;

import com.mygaienko.common.algorithms.leetcode.common.TreeNode;

class Solution {

    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if (root1 == null) return false;

        if (find(root2, target - root1.val)) return true;

        return twoSumBSTs(root1.left, root2, target) || twoSumBSTs(root1.right, root2, target);
    }

    private boolean find(TreeNode root, int target) {
        if (root == null) return false;

        if (root.val == target) return true;

        if (target < root.val) {
            return find(root.left, target);
        } else {
            return find(root.right, target);
        }
    }

}