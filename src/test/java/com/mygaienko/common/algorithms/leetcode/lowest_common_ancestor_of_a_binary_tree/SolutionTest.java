package com.mygaienko.common.algorithms.leetcode.lowest_common_ancestor_of_a_binary_tree;

import org.junit.Test;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test0() {
        TreeNode three = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        TreeNode one = new TreeNode(1);

        three.right = one;
        three.left = five;

        TreeNode treeNode = solution.lowestCommonAncestor(three, five, one);
        System.out.println(treeNode.val);
    }

    @Test
    public void test1() {
        TreeNode three = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        TreeNode one = new TreeNode(1);

        three.right = one;
        three.left = five;

        TreeNode treeNode = solution.lowestCommonAncestor(three, five, one);
        System.out.println(treeNode.val);
    }
}