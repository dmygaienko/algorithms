package com.mygaienko.common.algorithms.leetcode.find_leaves_of_binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

class SolutionV2 {

    public List<List<Integer>> findLeaves(TreeNode root) {
        TreeMap<Integer, List<Integer>> levels = new TreeMap<>();
        findLevel(root, levels);
        return new ArrayList<>(levels.values());
    }

    private int findLevel(TreeNode root, TreeMap<Integer, List<Integer>> levels) {
        int value = root.val;
        int leftLevel = 0;
        int rightLevel = 0;

        if (root.left != null) {
            leftLevel = findLevel(root.left, levels) + 1;
        }

        if(root.right != null) {
            rightLevel = findLevel(root.right, levels) + 1;
        }

        int level = Math.max(leftLevel, rightLevel);
        levels.compute(level, (k, l) -> l != null ? putValue(l, value) : newList(value));
        return level;
    }

    private List<Integer> newList(int value) {
        List<Integer> list = new ArrayList<>();
        list.add(value);
        return list;
    }

    private List<Integer> putValue(List<Integer> list, Integer value) {
        list.add(value);
        return list;
    }

    static class TreeNode {
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
}
