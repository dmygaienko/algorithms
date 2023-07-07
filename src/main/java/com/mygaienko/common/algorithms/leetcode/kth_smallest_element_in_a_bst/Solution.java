package com.mygaienko.common.algorithms.leetcode.kth_smallest_element_in_a_bst;

import java.util.concurrent.atomic.LongAdder;

class Solution {

    private final int NOT_FOUND = -1;
    private final int INIT = 0;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return NOT_FOUND;
        return kthSmallest(root, k, new LongAdder());
    }

    private int kthSmallest(TreeNode node, int k, LongAdder order) {
        int val;
        boolean incremented = false;
        if (node.left != null) {
            val = kthSmallest(node.left, k, order);
            if (val != NOT_FOUND) return val;
        }

        order.increment();
        incremented = true;
        if (order.intValue() == k) return node.val;

        if (node.right != null) {
            val = kthSmallest(node.right, k, order);
            if (val != NOT_FOUND) return val;
        }

        if (node.left == null && node.right == null && !incremented) order.increment();
        if (order.intValue() == k) return node.val;

        return NOT_FOUND;
    }

}
