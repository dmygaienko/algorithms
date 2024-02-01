package com.mygaienko.common.algorithms.leetcode.clone_binary_tree_with_random_pointer;

import org.junit.Test;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        solution.copyRandomBinaryTree(new Node(1, null, new Node(2, new Node(3), null, null), null));
    }
}