package com.mygaienko.common.algorithms.leetcode.validate_binary_search_tree;

import java.util.ArrayDeque;

public class SolutionV2 {

    private ArrayDeque<NodeMinMax> stack = new ArrayDeque<>();

    public boolean isValidBST(TreeNode root) {
        stack.push(new NodeMinMax(root, Long.MIN_VALUE, Long.MAX_VALUE));

        while (!stack.isEmpty()) {
            var next = stack.pop();
            var node = next.node;
            var min = next.min;
            var max = next.max;

            if (node == null) continue;

            if (node.val <= min || node.val >= max) {
                return false;
            }

            stack.push(new NodeMinMax(node.left, min, node.val));
            stack.push(new NodeMinMax(node.right, node.val, max));
        }

        return true;
    }

    class NodeMinMax {
        TreeNode node;
        long min;
        long max;

        public NodeMinMax(TreeNode node, long min, long max) {
            this.node = node;
            this.min = min;
            this.max = max;
        }
    }
}
