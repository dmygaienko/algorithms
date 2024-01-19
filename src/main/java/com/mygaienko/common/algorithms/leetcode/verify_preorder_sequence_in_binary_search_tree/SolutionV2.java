package com.mygaienko.common.algorithms.leetcode.verify_preorder_sequence_in_binary_search_tree;

import java.util.ArrayDeque;

class SolutionV2 {

    // preorder
    //   node.val
    //   preorder(node.left)
    //   preorder(node.right)
    public boolean verifyPreorder(int[] preorder) {
        int minLimit = Integer.MIN_VALUE;

        var stack = new ArrayDeque<Integer>();
        for (int num : preorder) {
            while (!stack.isEmpty() && stack.peek() < num) {
                minLimit = stack.pop();
            }

            if (num < minLimit) {
                return false;
            }

            stack.push(num);
        }

        return true;
    }

}
