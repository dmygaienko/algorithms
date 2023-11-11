package com.mygaienko.common.algorithms.leetcode.validate_binary_tree_nodes;

import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution {

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        var seen = new HashSet<Integer>();
        var root = findRoot(n, leftChild, rightChild);
        if (root == -1) return false;
        var result = validateTreeNodes(root, seen, leftChild, rightChild);
        return result && seen.size() == n;
    }

    private boolean validateTreeNodes(int i, Set<Integer> seen, int[] leftChild, int[] rightChild) {
        if (seen.contains(i)) return false;
        seen.add(i);

        var validRight = true;
        if (rightChild[i] != -1) {
            validRight = validateTreeNodes(rightChild[i], seen, leftChild, rightChild);
        }

        if (!validRight) return false;

        var validLeft = true;
        if (leftChild[i] != -1) {
            validLeft = validateTreeNodes(leftChild[i], seen, leftChild, rightChild);
        }

        return validLeft;
    }

    private int findRoot(int n, int[] leftChild, int[] rightChild) {
        var inbountCounts = new HashMap<Integer, Integer>();
        for (int i = 0; i < leftChild.length; i++) {
            var parent = i;
            var child = leftChild[parent];
            if (child != -1) {
                inbountCounts.compute(parent, (k, v) -> v == null ? 0 : v);
                inbountCounts.compute(child, (k, v) -> v == null ? 1 : v + 1);
            }
        }

        for (int i = 0; i < rightChild.length; i++) {
            var parent = i;
            var child = rightChild[parent];
            if (child != -1) {
                inbountCounts.compute(parent, (k, v) -> v == null ? 0 : v);
                inbountCounts.compute(child, (k, v) -> v == null ? 1 : v + 1);
            }
        }

        var root = -1;
        for (var entry : inbountCounts.entrySet()) {
            if (entry.getValue() == 0) {
                if (root == -1) {
                    root = entry.getKey();
                } else {
                    return -1;
                }
            }
        }

        if (root == -1 && !inbountCounts.containsKey(0)) {
            root = 0;
        }

        return root;
    }

}