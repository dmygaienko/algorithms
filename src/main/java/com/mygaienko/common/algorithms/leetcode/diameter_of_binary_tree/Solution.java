package com.mygaienko.common.algorithms.leetcode.diameter_of_binary_tree;

class Solution {

    private final int[] defResult = new int[]{0, 0};

    public int diameterOfBinaryTree(TreeNode root) {
        return diameterOfTree(root)[1];
    }

    public int[] diameterOfTree(TreeNode root) {
        if (root == null) return defResult;

        int maxPath = 0;
        int maxDiameter = 0;

        int def = 1;

        int[] resultLeft = defResult;
        if (root.left != null) {
            resultLeft = diameterOfTree(root.left);
        }

        int[] resultRight = defResult;
        if (root.right != null) {
            resultRight = diameterOfTree(root.right);
        }

        maxPath = Math.max(def + resultLeft[0], def + resultRight[0]);
        maxDiameter = Math.max(resultLeft[1], resultRight[1]);
        maxDiameter = Math.max(maxDiameter, resultLeft[0] + resultRight[0]);

        return new int[]{maxPath, maxDiameter};
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
