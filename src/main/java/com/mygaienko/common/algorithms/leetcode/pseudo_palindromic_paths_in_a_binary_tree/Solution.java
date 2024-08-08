package com.mygaienko.common.algorithms.leetcode.pseudo_palindromic_paths_in_a_binary_tree;

import com.mygaienko.common.algorithms.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
// TODO add solution with binary logic
// path ^ (1 << node.val);
// (path & (path - 1)) == 0
class Solution {
    public int pseudoPalindromicPaths(TreeNode root) {
        return pseudoPalindromicPaths(root, new HashMap<>());
    }

    private int pseudoPalindromicPaths(TreeNode root, Map<Integer, Integer> freq) {
        var result = 0;
        if (root == null) return result;

        freq.compute(root.val, (k, v) -> v == null ? 1 : v + 1);

        if (root.left != null) {
            result += pseudoPalindromicPaths(root.left, freq);
        }

        if (root.right != null) {
            result += pseudoPalindromicPaths(root.right, freq);
        }

        if (root.left == null && root.right == null) {
            result += isPalindrome(freq);
        }

        freq.compute(root.val, (k, v) -> v == null ? 0 : v - 1);
        return result;
    }

    int isPalindrome(Map<Integer, Integer> freq) {
        var isPalindrome = true;
        var inCenter = false;
        for (var val : freq.values()) {
            if (val % 2 == 1) {
                if (!inCenter) {
                    inCenter = true;
                } else {
                    return 0;
                }
            }
        }

        return isPalindrome ? 1 : 0;
    }
}