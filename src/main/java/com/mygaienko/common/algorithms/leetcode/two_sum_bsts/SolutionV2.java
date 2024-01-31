package com.mygaienko.common.algorithms.leetcode.two_sum_bsts;

import com.mygaienko.common.algorithms.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

class SolutionV2 {

    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        var list1 = dfs(root1, new ArrayList<Integer>());
        var list2 = dfs(root2, new ArrayList<Integer>());

        var left = 0;
        var right = list2.size() - 1;

        while (left < list1.size() && right >= 0) {
            var leftVal = list1.get(left);
            var rightVal = list2.get(right);
            var sum = leftVal + rightVal;

            if (sum == target) return true;

            if (sum < target) {
                left++;
            }

            if (sum > target) {
                right--;
            }
        }

        return false;
    }

    private List<Integer> dfs(TreeNode root1, List<Integer> integers) {
        if (root1 == null) return integers;

        dfs(root1.left, integers);
        integers.add(root1.val);
        dfs(root1.right, integers);

        return integers;
    }

}