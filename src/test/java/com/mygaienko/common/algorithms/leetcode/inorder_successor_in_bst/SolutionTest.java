package com.mygaienko.common.algorithms.leetcode.inorder_successor_in_bst;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    public void test0() {
        TreeNode toFind = new TreeNode(1);
        TreeNode root = new TreeNode(2, toFind, new TreeNode(3));
        TreeNode actual = solution.inorderSuccessor(root, toFind);
        assertThat(actual).isEqualTo(root);
    }

    @Test
    public void test_17() {
        TreeNode root = new TreeNode(2, new TreeNode(1), null);
        TreeNode actual = solution.inorderSuccessor(root, root);
        assertThat(actual).isNull();
    }

    @Test
    public void test_20() {
        TreeNode toFind = new TreeNode(
                2,
                new TreeNode(0),
                new TreeNode(4,
                        new TreeNode(3),
                        new TreeNode(5)));
        TreeNode root = new TreeNode(6, toFind, new TreeNode(8, new TreeNode(3), new TreeNode(9)));
        TreeNode actual = solution.inorderSuccessor(root, toFind);
        assertThat(actual.val).isEqualTo(3);
    }

}