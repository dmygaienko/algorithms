package com.mygaienko.common.algorithms.leetcode.construct_binary_tree_from_string;


import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.str2tree("4(2(3)(1))(6(5))");
        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(
                        new TreeNode(4,
                                new TreeNode(2, new TreeNode(3), new TreeNode(1)),
                                new TreeNode(6, new TreeNode(5), null)
                        )
                );
    }
}