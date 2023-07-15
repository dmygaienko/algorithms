package com.mygaienko.common.algorithms.leetcode.construct_binary_tree_from_preorder_and_inorder_traversal;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
 */
class SolutionV2 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null) return null;
        return buildNode(null, null, preorder, new AtomicInteger(0), inorder, new AtomicInteger(0), inorder[0]);
    }

    private TreeNode buildNode(TreeNode root, TreeNode prev, int[] preorder, AtomicInteger p, int[] inorder,
                               AtomicInteger i, int mostLeft) {
        if (prev != null && prev.val == mostLeft) {
            i.incrementAndGet();
            return root;
        }

        if (p.get() == preorder.length || i.get() == inorder.length) return root;

        int current = preorder[p.get()];
        TreeNode node = new TreeNode(current);
        if (root == null) {
            root = node;
            prev = node;
        } else if (i.get() == p.get() && inorder[i.get()] == preorder[p.get()]) {
            prev.right = node;
        } else {
            prev.left = node;
        }

        p.incrementAndGet();
        buildNode(root, node, preorder, p, inorder, i, mostLeft);

        int inorderIndex = i.getAndIncrement();
        if (inorderIndex >= inorder.length || p.get() >= preorder.length) {
            return root;
        } else if (inorder[inorderIndex] == preorder[p.get()] && inorder[inorderIndex-1] == preorder[p.get()-1]) {
            node.right = new TreeNode(preorder[p.get()]);
            p.incrementAndGet();
            buildNode(root, node.right, preorder, p, inorder, i, -1);
        } else if (i.get() < preorder.length && root.val == inorder[inorderIndex]) {
            root.right = new TreeNode(preorder[i.get()]);
            int nextMostLeftIndex = i.get();
            p.set(i.incrementAndGet());
            buildNode(root, root.right, preorder, p, inorder, i, inorder[nextMostLeftIndex]);

            if (i.get() < inorder.length) {
                root.right.right = new TreeNode(inorder[i.getAndIncrement()]);
            }
        } else if (root.val != inorder[inorderIndex] && inorder[inorderIndex] != prev.val) {
            TreeNode rightNode = new TreeNode(inorder[inorderIndex]);
            if (inorderIndex < inorder.length - 1) {
                node.right = rightNode;
            }  else {
                prev.right = rightNode;
            }
        }

        return root;
    }

}
