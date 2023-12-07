package com.mygaienko.common.algorithms.leetcode.all_possible_full_binary_trees;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) return new ArrayList<TreeNode>();
        return allPossibleFBT(n, new List[n + 1]);
    }

    public List<TreeNode> allPossibleFBT(int n, List<TreeNode>[] memo) {
        if (memo[n] != null) return memo[n];
        if (n == 1) return List.of(new TreeNode());

        var result = new ArrayList<TreeNode>();
        for (int i = 1; i < n - 1; i = i + 2) {
            var leftSubTrees = allPossibleFBT(i, memo);
            var rightSubTrees = allPossibleFBT(n - 1 - i, memo);

            for (var leftSubTree : leftSubTrees) {
                for (var rightSubTree : rightSubTrees) {
                    var parent = new TreeNode();
                    parent.left = leftSubTree;
                    parent.right = rightSubTree;
                    result.add(parent);
                }
            }
        }
        memo[n] = result;
        return result;
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