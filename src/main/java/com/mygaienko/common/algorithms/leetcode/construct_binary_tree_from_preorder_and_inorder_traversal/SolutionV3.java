package com.mygaienko.common.algorithms.leetcode.construct_binary_tree_from_preorder_and_inorder_traversal;

/**
 * https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
 */
class SolutionV3 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, inorder, 0);
    }

    private TreeNode buildTree(int[] preorder, int p, int[] inorder, int i) {
        int mostLeft = inorder[i];

        // declare parent
        TreeNode parent = null;
        TreeNode left = null;

        // go preorder till the most left
        for (; p < preorder.length; p++) {
            int next = preorder[p];
            TreeNode nextNode = new TreeNode(next);
            if (parent == null) {
                parent = nextNode;
            }

            if (left == null) {
                left = nextNode;
            } else {
                left.left = nextNode;
            }

            if (next == mostLeft) {
                break;
            }
        }

        // go inorder till the parent

        return parent;
    }

}
