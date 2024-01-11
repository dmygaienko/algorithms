package com.mygaienko.common.algorithms.leetcode.inorder_successor_in_bst_ii;

// Inorder traversal
// visit left subtree
// visit root
// visit right subtree
class Solution {

    public Node inorderSuccessor(Node node) {
        if (node.right != null) {
            return inorder(node.right);
        } else if (node.parent != null) {

            while (node.parent != null && node.parent.right == node) {
                node = node.parent;
            }

            if (node.parent != null && node.parent.left == node) {
                return node.parent;
            }
        }
        return null;
    }

    private Node inorder(Node node) {
        if (node.left != null) {
            return inorder(node.left);
        }

        if (node.val != 0) {
            return node;
        }

        if (node.right != null) {
            return inorder(node.right);
        }

        return null;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};