package com.mygaienko.common.algorithms.leetcode.binary_tree_longest_consecutive_sequence_ii;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.longestConsecutive(new TreeNode(1, new TreeNode(1), new TreeNode(1)));
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void test2() {
        var actual = solution.longestConsecutive(new TreeNode(2, null, new TreeNode(3, new TreeNode(4, new TreeNode(1), null), null)));
        assertThat(actual).isEqualTo(3);
    }

    @Test
    public void test3() {
        var actual = solution.longestConsecutive(new TreeNode(3,
                new TreeNode(1,
                        null, new TreeNode(2)), null));
        assertThat(actual).isEqualTo(3);
    }

}