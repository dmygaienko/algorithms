package com.mygaienko.common.algorithms.leetcode.find_duplicate_subtrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Solution {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<Integer, List<TreeNode>> nodes = new HashMap<>();
        calculateNodes(nodes, root);
        List<TreeNode> duplicates = new ArrayList<>();
        for (Entry<Integer, List<TreeNode>> entry : nodes.entrySet()) {
            List<TreeNode> sameNodes = entry.getValue();
            if (sameNodes.size() > 1) {
                duplicates.add(sameNodes.get(0));
            }
        }
        return duplicates;
    }

    private int calculateNodes(Map<Integer, List<TreeNode>> nodes, TreeNode root) {
        int result = 1333;
        if (root.left != null) {
            result = result * 31111 + calculateNodes(nodes, root.left);
        }

        if (root.right != null) {
            result = result * 1777 + calculateNodes(nodes, root.right);
        }

        result = result * 13333 + root.val;
        nodes.computeIfAbsent(result, v -> new ArrayList<>()).add(root);
        return result;
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
