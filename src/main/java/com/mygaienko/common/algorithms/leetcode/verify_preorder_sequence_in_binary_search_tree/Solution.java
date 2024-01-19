package com.mygaienko.common.algorithms.leetcode.verify_preorder_sequence_in_binary_search_tree;

class Solution {

    // preorder
    //   node.val
    //   preorder(node.left)
    //   preorder(node.right)
    public boolean verifyPreorder(int[] preorder) {
        var validIndex = nextValidIndex(preorder, 0, 0, 10001);
        return validIndex + 1 == preorder.length;
    }

    private int nextValidIndex(int[] preorder, int i, int from, int to) {
        if (i == preorder.length) {
            return i - 1;
        }

        var curr = preorder[i];
        if (curr <= from || curr >= to) {
            return -1;
        }

        var leftIndex = nextValidIndex(preorder, i + 1, from, curr);
        var rightIndex = nextValidIndex(preorder, leftIndex != -1 ? leftIndex + 1 : i + 1, curr, to);

        return rightIndex != -1 ? rightIndex : (leftIndex != -1 ? leftIndex : i);
    }

}
