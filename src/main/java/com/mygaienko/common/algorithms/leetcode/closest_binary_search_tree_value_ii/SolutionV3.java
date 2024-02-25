package com.mygaienko.common.algorithms.leetcode.closest_binary_search_tree_value_ii;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SolutionV3 {

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        var heap = new PriorityQueue<Integer>(Comparator.comparing(a -> Math.abs(a - target), Comparator.reverseOrder()));
        closestKValues(root, k, heap);
        return new ArrayList<>(heap);
    }

    private void closestKValues(TreeNode root, int k, PriorityQueue<Integer> heap) {
        if (root == null) return;

        heap.offer(root.val);

        if (heap.size() > k) {
            heap.poll();
        }

        closestKValues(root.left, k, heap);
        closestKValues(root.right, k, heap);
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
