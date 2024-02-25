package com.mygaienko.common.algorithms.leetcode.closest_binary_search_tree_value_ii;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.closestKValues(new TreeNode(3,
                        new TreeNode(2, new TreeNode(1), null),
                        new TreeNode(4)),
                2.0, 3);
        assertThat(actual).containsExactlyInAnyOrder(3, 2, 1);
    }
}