package com.mygaienko.common.algorithms.leetcode.inorder_successor_in_bst;

import java.util.concurrent.atomic.AtomicBoolean;

class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return inorder(root, p, new AtomicBoolean(false));
    }

    private TreeNode inorder(TreeNode current, TreeNode target, AtomicBoolean found) {
        TreeNode successor = null;
        if (current.left != null) {
            successor = inorder(current.left, target, found);
            if (successor == null && found.get()) {
                successor = current;
            }
        }

        if (current == target) {
            found.set(true);
        } else if (successor == null && found.get()) {
            return current;
        }

        if (successor == null && current.right != null) {
            successor = inorder(current.right, target, found);
        }

        return successor;
    }

}
