package com.mygaienko.common.algorithms.leetcode.binary_tree_longest_consecutive_sequence_ii;

class Solution {

    int longest = 0;

// if root is null than return 0

    // if left node exists and differs by one delegate to left node
// if right node exists and differs by one delegate to right node
// if both nodes not null than return sum of all childen + 1
// otherwise only one of them + 1
    public int longestConsecutive(TreeNode root) {
        findLongest(root, null);
        return longest;
    }

    private int findLongest(TreeNode root, Integer parentDiff) {
        var result = 1;

        var leftCount = 0;
        var leftDiff = root.left != null ? root.val - root.left.val : Integer.MAX_VALUE;
        if (root.left != null) {
            leftCount = findLongest(root.left, root.val - root.left.val);
        }

        var rightCount = 0;
        var rightDiff = root.right != null ? root.val - root.right.val : Integer.MAX_VALUE;
        if (root.right != null) {
            rightCount = findLongest(root.right, root.val - root.right.val);
        }

        if (Math.abs(leftDiff) == 1) {
            if ((parentDiff == null || parentDiff == leftDiff) && Math.abs(leftDiff) == 1) {
                result = Math.max(result, 1 + leftCount);
            } else {
                longest = Math.max(longest, 1 + leftCount);
            }
        }

        if (Math.abs(rightDiff) == 1) {
            if ((parentDiff == null || parentDiff == rightDiff) && Math.abs(rightDiff) == 1) {
                result = Math.max(result, 1 + rightCount);
            } else {
                longest = Math.max(longest, 1 + rightCount);
            }
        }

        if (root.left != null && root.right != null && leftDiff == (rightDiff * -1) && Math.abs(rightDiff) == 1) {
            longest = Math.max(longest, 1 + leftCount + rightCount);
        }

        longest = Math.max(longest, result);

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
