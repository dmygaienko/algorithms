package com.mygaienko.common.algorithms.leetcode.lowest_common_ancestor_of_a_binary_tree;

import java.util.Stack;

class SolutionV2 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> pPath = findPath(root, p);
        Stack<TreeNode> qPath = findPath(root, q);
        return findLatestCommon(pPath, qPath);
    }

    private TreeNode findLatestCommon(Stack<TreeNode> pPath, Stack<TreeNode> qPath) {
        int N = Math.min(pPath.size(), qPath.size());
        TreeNode common = null;
        for (int i = 0; i < N; i++) {
            TreeNode pNode = pPath.pop();
            TreeNode qNode = qPath.pop();
            if (pNode.val == qNode.val) {
                common = pNode;
            } else {
                return common;
            }
        }
        return common;
    }

    private Stack<TreeNode> findPath(TreeNode root, TreeNode p) {
        if (root.val == p.val) {
            Stack<TreeNode> path = new Stack<>();
            path.push(root);
            return path;
        }

        if (root.left != null) {
            Stack<TreeNode> path = findPath(root.left, p);
            if (path != null) {
                path.push(root);
                return path;
            }
        }

        if (root.right != null) {
            Stack<TreeNode> path = findPath(root.right, p);
            if (path != null) {
                path.push(root);
                return path;
            }
        }

        return null;
    }
}

