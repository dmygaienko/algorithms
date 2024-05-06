package com.mygaienko.common.algorithms.leetcode.all_nodes_distance_k_in_binary_tree;

import com.mygaienko.common.algorithms.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (root == null) return List.of();

        var parents = new HashMap<TreeNode, TreeNode>();

        var queue = new ArrayDeque<TreeNode>();
        queue.offer(root);

        TreeNode found = null;
        while (!queue.isEmpty()) {
            var curr = queue.poll();
            if (curr.val == target.val) {
                found = curr;
                break;
            }

            if (curr.left != null) {
                parents.put(curr.left, curr);
                queue.offer(curr.left);
            }
            if (curr.right != null) {
                parents.put(curr.right, curr);
                queue.offer(curr.right);
            }
        }

        var distQueue = new ArrayDeque<Step>();
        distQueue.offer(new Step(found, 0));

        var result = new ArrayList<Integer>();
        var seen = new HashSet<Integer>();
        while (!distQueue.isEmpty()) {
            var step = distQueue.poll();
            var next = step.node;
            var dist = step.distance;

            if (!seen.add(next.val)) {
                continue;
            }

            if (dist == k) {
                result.add(next.val);
                continue;
            }

            TreeNode parent = parents.get(next);
            if (parent != null && !seen.contains(parent.val)) {
                distQueue.add(new Step(parent, dist + 1));
            }

            if (next.left != null && !seen.contains(next.left.val)) {
                distQueue.add(new Step(next.left, dist + 1));
            }

            if (next.right != null && !seen.contains(next.right.val)) {
                distQueue.add(new Step(next.right, dist + 1));
            }
        }

        return result;
    }


}

class Step {
    TreeNode node;
    int distance;

    Step(TreeNode node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}