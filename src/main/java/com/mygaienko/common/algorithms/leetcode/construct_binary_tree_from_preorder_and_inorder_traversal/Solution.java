package com.mygaienko.common.algorithms.leetcode.construct_binary_tree_from_preorder_and_inorder_traversal;

@SuppressWarnings("Duplicates")
public class Solution {

    int pIndex = 0;
    int iIndex = 0;
    int[] preorder;
    int[] inorder;

    public TreeNode buildTree(int[] p, int[] i) {
        this.inorder = i;
        this.preorder = p;

        if (preorder == null) return null;
        return buildLeft(null, null);
    }

    private TreeNode buildLeft(TreeNode root, TreeNode prev) {
        if (iIndex >= inorder.length || pIndex >= preorder.length) return root;

        int mostLeft = inorder[iIndex];
        int next = preorder[pIndex];

        TreeNode nextNode = new TreeNode(next);
        if (root == null) {
            root = nextNode;
        }

        if (prev == null) {
            prev = nextNode;
        } else {
            prev.left = nextNode;
        }

        pIndex++;
        if (mostLeft == next) {
            iIndex++;
            buildRight(root, prev, nextNode);
        } else {
            buildLeft(root, nextNode);
        }

        return root;
    }

    private void buildRight(TreeNode root, TreeNode prev, TreeNode curr) {
        if (iIndex >= inorder.length || pIndex >= preorder.length) return;

        // handling build right nodes on going down from the root
        if (root == curr) {
            TreeNode nextNode = new TreeNode(preorder[pIndex]);
            curr.right = nextNode;

            if (pIndex >= 0 && iIndex >= 0 && preorder[pIndex] == inorder[iIndex]){
                iIndex++; pIndex++;
                buildRight(curr.right, curr.right, nextNode);
            } else {
                pIndex++;
                buildLeft(curr.right, curr.right);
            }

            return;
        }

        if (iIndex == inorder.length - 1) return;

        int next = inorder[iIndex++];
        int rootVal = root.val;

        // handling build right nodes on going UP till the root
        if (next == rootVal && iIndex < preorder.length) {
            pIndex = iIndex;
            TreeNode nextNode = new TreeNode(preorder[pIndex]);
            pIndex++;
            root.right = nextNode;

            if (pIndex < preorder.length && iIndex+1 < inorder.length && preorder[pIndex] == inorder[iIndex+1]) {
                iIndex++;
                buildRight(nextNode, nextNode, nextNode);
            } else {
                buildLeft(nextNode, nextNode);
            }
        } else if (next != prev.val) {
            curr.right = new TreeNode(next);
            buildRight(root, curr, curr.right);
        } else {
            buildRight(root, prev, curr);
        }
    }

}
