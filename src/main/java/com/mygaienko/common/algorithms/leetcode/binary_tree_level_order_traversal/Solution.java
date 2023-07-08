package com.mygaienko.common.algorithms.leetcode.binary_tree_level_order_traversal;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        traverseLevel(result, root, 0);
        return result;
    }

    private void traverseLevel(List<List<Integer>> result, TreeNode node, int level) {
        if (result.size() == level) { // there is no list for next level
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);

        traverseNonNullChild(result, node.left, level);
        traverseNonNullChild(result, node.right, level);
    }

    private void traverseNonNullChild(List<List<Integer>> result, TreeNode node, int level) {
        if (node != null) {
            traverseLevel(result, node, level + 1);
        }
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
