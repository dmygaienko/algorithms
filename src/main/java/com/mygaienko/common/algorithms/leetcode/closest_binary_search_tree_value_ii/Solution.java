package com.mygaienko.common.algorithms.leetcode.closest_binary_search_tree_value_ii;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        var deque = new LinkedList<Integer>();
        inorder(root, target, deque, k);
        return deque;
    }

    private void inorder(TreeNode root, double target, LinkedList<Integer> deque, int k) {
        if (root == null) return;

        inorder(root.left, target, deque, k);
        deque.addLast(root.val);

        if (deque.size() > k) {
            if (Math.abs(deque.peekFirst() - target) < Math.abs(deque.peekLast() - target)) {
                deque.removeLast();
                return;
            } else {
                deque.removeFirst();
            }
        }

        inorder(root.right, target, deque, k);
    }
}
