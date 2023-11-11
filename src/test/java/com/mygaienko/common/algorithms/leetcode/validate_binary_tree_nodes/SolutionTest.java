package com.mygaienko.common.algorithms.leetcode.validate_binary_tree_nodes;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void name() {
        var actual = solution.validateBinaryTreeNodes(1, new int[] {-1}, new int[] {-1});
        assertThat(actual).isTrue();
    }

    @Test
    public void test44() {
        var actual = solution.validateBinaryTreeNodes( 4, new int[] {1,0,3,-1}, new int[] {-1,-1,-1,-1});
        assertThat(actual).isFalse();
    }
}