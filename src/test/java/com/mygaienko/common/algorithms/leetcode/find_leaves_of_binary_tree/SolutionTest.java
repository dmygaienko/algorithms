package com.mygaienko.common.algorithms.leetcode.find_leaves_of_binary_tree;

import com.mygaienko.common.algorithms.leetcode.find_leaves_of_binary_tree.Solution.TreeNode;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {

        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode two = new TreeNode(2, four, five);
        TreeNode three = new TreeNode(3);
        TreeNode root = new TreeNode(1, two, three);
        List<List<Integer>> actual = solution.findLeaves(root);

        System.out.println(actual);
    }
}