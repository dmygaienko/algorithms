package com.mygaienko.common.algorithms.leetcode.boundary_of_binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        List<Integer> leftBoundary = new ArrayList<>();
        LinkedList<Integer> rightBoundary = new LinkedList<>();
        List<Integer> leaves = new ArrayList<>();

        if (root.left != null) {
            findLeftBoundary(root.left, leftBoundary);
            findLeaves(root.left, leaves);
        }

        if (root.right != null) {
            findRightBoundary(root.right, rightBoundary);
            findLeaves(root.right, leaves);
        }

        result.add(root.val);
        result.addAll(leftBoundary);
        result.addAll(leaves);
        result.addAll(rightBoundary);
        return result;
    }

    private void findLeaves(TreeNode node, List<Integer> leaves) {
        if (node.left == null) {
            if (node.right == null) {
                leaves.add(node.val);
            }
        } else {
            findLeaves(node.left, leaves);
        }

        if (node.right != null) {
            findLeaves(node.right, leaves);
        }
    }

    private void findLeftBoundary(TreeNode node, List<Integer> leftBoundary) {
        if (node.left == null) {
            if (node.right == null) {
                return; // this is leaf
            } else {
                leftBoundary.add(node.val);
                findLeftBoundary(node.right, leftBoundary);
            }
        } else {
            leftBoundary.add(node.val);
            findLeftBoundary(node.left, leftBoundary);
        }
    }

    private void findRightBoundary(TreeNode node, LinkedList<Integer> rightBoundary) {
        if (node.right == null) {
            if (node.left == null) {
                return; // this is leaf
            } else {
                rightBoundary.addFirst(node.val);
                findRightBoundary(node.left, rightBoundary);
            }
        } else {
            rightBoundary.addFirst(node.val);
            findRightBoundary(node.right, rightBoundary);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
