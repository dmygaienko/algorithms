package com.mygaienko.common.algorithms.leetcode.count_complete_tree_nodes;

/**
 * binary search in tree
 */
class Solution {

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int height = countHeight(root);
        if (height == 0) return 1;
        int lastLevelSize = (int) Math.pow(2, height);

        int left = 0;
        int right = lastLevelSize - 1;
        int midIndex = 0;

        while (left <= right) {
            midIndex = left + (right - left) / 2;
            if (isExist(root, midIndex, height, 0, lastLevelSize - 1)) {
                left = midIndex + 1;
            } else {
                right = midIndex - 1;

                if (left > right) {
                    midIndex--; // rollback
                }
            }
        }

        return countComplete(0, height) + midIndex + 1;
    }

    public int countComplete(int currentHeight, int i) {
        if (currentHeight < i) {
            return (int) Math.pow(2, currentHeight) + countComplete(currentHeight + 1, i);
        } else {
            return 0;
        }
    }

    public boolean isExist(TreeNode node, int toFind, int height, int left, int right) {
        int currentHeight = 0;
        while (currentHeight <= height && node != null) {
            int mid =  left + (right - left) / 2;

            if (mid == toFind && currentHeight == height) {
                return true;
            } else if (mid < toFind) {
                node = node.right;
                left = mid + 1;
            } else { // mid > toFind
                node = node.left;
                right = mid - 1;
            }
            currentHeight++;
        }
        return false;
    }

    public int countHeight(TreeNode node) {
        int height = 0;
        while (node.left != null) {
            node = node.left;
            height++;
        }
        return height;
    }

}

