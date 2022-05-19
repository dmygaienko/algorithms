package com.mygaienko.common.algorithms.leetcode.find_duplicate_subtrees;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;


public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        TreeNode root = new TreeNode(2);
        TreeNode one = new TreeNode(1);
        TreeNode one1 = new TreeNode(1);
        root.right = one;
        root.left = one1;

        assertEquals(Set.of(one), new HashSet<>(solution.findDuplicateSubtrees(root)));
    }


    @Test
    public void test2() {
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode four = new TreeNode(4);
        TreeNode three = new TreeNode(3);
        TreeNode two1 = new TreeNode(2);
        TreeNode four1 = new TreeNode(4);
        TreeNode four2 = new TreeNode(4);

        root.left = two;
        two.left = four;

        root.right = three;
        three.left = two1;
        two1.left = four1;

        three.right = four2;

        assertEquals(Set.of(root), new HashSet<>(solution.findDuplicateSubtrees(root)));
    }
}