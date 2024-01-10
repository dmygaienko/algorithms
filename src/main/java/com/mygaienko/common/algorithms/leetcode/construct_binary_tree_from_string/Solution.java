package com.mygaienko.common.algorithms.leetcode.construct_binary_tree_from_string;

import java.util.ArrayDeque;

class Solution {

    public TreeNode str2tree(String s) {
        var root = new TreeNode();
        var stack = new ArrayDeque<TreeNode>();
        stack.push(root);

        for (int i = 0; i < s.length(); i++) {
            var node = stack.peek();
            char ch = s.charAt(i);

            if (Character.isDigit(ch) || ch == '-') {
                var res = getDigit(s, i);
                node.val = res[0];
                i = res[1];
            } else if (ch == '(') {
                if (node.left == null) {
                    node.left = new TreeNode();
                    stack.push(node.left);
                } else {
                    node.right = new TreeNode();
                    stack.push(node.right);
                }
            } else { // if (s.charAt(i) == ')')
                stack.pop();
            }

        }

        return s.length() == 0 ? null : root;
    }

    private int[] getDigit(String s, int i) {
        var sign = 1;
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        }

        var startIndex = i;
        var endIndex = i;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            endIndex = i;
            i++;
        }
        var result = Integer.parseInt(s.substring(startIndex, endIndex + 1)) * sign;
        return new int[]{result, i - 1};
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
