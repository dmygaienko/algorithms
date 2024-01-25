package com.mygaienko.common.algorithms.leetcode.closest_leaf_in_a_binary_tree;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.findClosestLeaf(new TreeNode(1,
                        new TreeNode(2, new TreeNode(4, new TreeNode(5, new TreeNode(6), null), null), null),
                        new TreeNode(3)
                ),
                2
        );
        assertThat(actual).isEqualTo(3);
    }

    @Test
    public void test2() {
        var actual = solution.findClosestLeaf(new TreeNode(1,
                        new TreeNode(2, null, null),
                        null
                ),
                1
        );
        assertThat(actual).isEqualTo(2);
    }
}