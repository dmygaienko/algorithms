package com.mygaienko.common.algorithms.leetcode.binary_tree_maximum_path_sum;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        int actual = solution.maxPathSum(new TreeNode(1,
                new TreeNode(-2),
                new TreeNode(3)
        ));

        assertThat(actual).isEqualTo(4);
    }

    /**
     * [       1,
     *    -2,    -3,
     *   1, 3, -2, null,
     *   -1]
     */
    @Test
    public void test_1() {
        int actual = solution.maxPathSum(
                new TreeNode(1,
                        new TreeNode(-2,
                                new TreeNode(1, new TreeNode(-1), null), new TreeNode(3)),
                        new TreeNode(-3, new TreeNode(-2), null)
                ));

        assertThat(actual).isEqualTo(3);
    }
}