package com.mygaienko.common.algorithms.leetcode.count_complete_tree_nodes;

import java.util.ArrayList;
import java.util.List;

class SolutionV2 {

    private static final int NOT_FOUND = -1;

    public int countNodes(TreeNode root) {
        int count = 0;
        List<TreeNode> queue = new ArrayList<>();
        if (root == null) return count;
        queue.add(root);
        count++;

        int midIndex = NOT_FOUND;
        while (!queue.isEmpty() && midIndex == NOT_FOUND) {

            if (queue.get(0).left != null && queue.get(queue.size()-1).right != null) {
                count += queue.size() * 2;
                List<TreeNode> nextQueue = new ArrayList<>();
                for (TreeNode node : queue) {
                    nextQueue.add(node.left);
                    nextQueue.add(node.right);
                }
                queue = nextQueue;

            } else {

                int left = 0;
                int right = queue.size() - 1;

                while (left <= right) {
                    midIndex = left + (right - left) / 2;
                    TreeNode mid = queue.get(midIndex);

                    if (mid.left != null) {
                        if (mid.right == null) {
                            return count + midIndex * 2 + 1;
                        } else { // mid.right != null
                            if (left == right) {
                                return count + midIndex * 2 + 2;
                            }
                            left = midIndex + 1;
                        }
                    } else { // mid.left == null
                        if (left == right) {
                            return count + midIndex * 2;
                        }
                        right = midIndex - 1;
                    }
                }
            }
        }

        return midIndex == NOT_FOUND ? count : count + midIndex * 2;
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
