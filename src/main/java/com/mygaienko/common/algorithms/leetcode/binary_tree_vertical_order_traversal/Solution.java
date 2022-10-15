package com.mygaienko.common.algorithms.leetcode.binary_tree_vertical_order_traversal;

import java.util.*;

class Solution {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return List.of();

        Map<Integer, List<Integer>> verticals = new TreeMap<>();

        Deque<List<Object>> queue = new LinkedList<>(); // LinkedList faster than ArrayDeque
        queue.offer(List.of(root, 0));

        while (!queue.isEmpty()) {
            List next = queue.poll();
            TreeNode nextNode = (TreeNode) next.get(0);
            int position = (int) next.get(1);

            verticals.putIfAbsent(position, new ArrayList<>());
            verticals.get(position).add(nextNode.val);

            if (nextNode.left != null) {
                queue.offer(List.of(nextNode.left, position - 1));
            }

            if (nextNode.right != null) {
                queue.offer(List.of(nextNode.right, position + 1));
            }
        }

        return new ArrayList<>(verticals.values());
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
