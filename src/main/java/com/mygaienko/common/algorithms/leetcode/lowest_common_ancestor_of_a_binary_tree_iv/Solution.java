package com.mygaienko.common.algorithms.leetcode.lowest_common_ancestor_of_a_binary_tree_iv;

import java.util.HashSet;
import java.util.Set;

class Solution {

    TreeNode ancestor = null;
    int targetsCount;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        targetsCount = nodes.length;

        var targets = new HashSet<Integer>();
        for (var node : nodes) {
            targets.add(node.val);
        }

        lowestCommonAncestor(root, targets);
        return ancestor;
    }

    private int lowestCommonAncestor(TreeNode next, Set<Integer> targets) {
        if (ancestor != null && targets.isEmpty()) return 0; // no need to traverse if

        var count = 0;
        if (targets.contains(next.val)) {
            count = 1;
            targets.remove(next.val);
            if (count == targetsCount && ancestor == null) {
                ancestor = next;
                return count;
            } else if (targets.isEmpty()) {
                return count;
            }
        }

        if (next.left != null) {
            count += lowestCommonAncestor(next.left, targets);
            if (targets.isEmpty()) {
                if (count == targetsCount && ancestor == null) {
                    ancestor = next;
                }
                return count;
            }
        }

        if (next.right != null) {
            count += lowestCommonAncestor(next.right, targets);
            if (count == targetsCount && ancestor == null) {
                ancestor = next;
            }
        }

        return count;
    }

}

/*

      public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        if(root==null){
            return null;
        }
        for(TreeNode node: nodes){
		   // if there's a match return the node directly.
		   // if there are multiple nodes on the list  within same direction of lookup, this could also return the first one with a match.
            if(root == node){
                return root;
            }
        }

        TreeNode left = lowestCommonAncestor(root.left, nodes);
        TreeNode right = lowestCommonAncestor(root.right, nodes);
        // if both left and right nodes turn out to be not null, then it means root is the LCA
        if(left != null && right != null){
            return root;
        } else if(left == null && right == null){ // both null indicates that no elements present.
            return null;
        }else if(left == null){ //if one of them is null, return the other one.
            return right;
        } else{
            return left;
        }

    }

*/