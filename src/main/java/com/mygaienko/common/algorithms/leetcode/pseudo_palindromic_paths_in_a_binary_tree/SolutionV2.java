package com.mygaienko.common.algorithms.leetcode.pseudo_palindromic_paths_in_a_binary_tree;

import com.mygaienko.common.algorithms.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class SolutionV2 {
    public int pseudoPalindromicPaths(TreeNode root) {
        var result = 0;
        var queue = new ArrayDeque<Node>();
        queue.offer(new Node(root, new HashMap<>()));

        while (!queue.isEmpty()) {
            var next = queue.poll();
            var node = next.node;
            var freq = new HashMap<>(next.freq);
            freq.compute(node.val, (k, v) -> v == null ? 1 : v + 1);

            if (node.left != null) {
                queue.offer(new Node(node.left, freq));
            }

            if (node.right != null) {
                queue.offer(new Node(node.right, freq));
            }

            if (node.right == null && node.left == null) {
                result += isPalindrome(freq);
            }
        }

        return result;
    }

    class Node {
        TreeNode node;
        Map<Integer, Integer> freq;

        Node(TreeNode node, Map<Integer, Integer> freq) {
            this.node = node;
            this.freq = freq;
        }
    }

    int isPalindrome(Map<Integer, Integer> freq) {
        var isPalindrome = true;
        var inCenter = false;
        for (var val : freq.values()) {
            if (val % 2 == 1) {
                if (!inCenter) {
                    inCenter = true;
                } else {
                    return 0;
                }
            }
        }

        return isPalindrome ? 1 : 0;
    }
}