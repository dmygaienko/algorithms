package com.mygaienko.common.algorithms.leetcode.kth_smallest_element_in_a_bst;


import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class SolutionTest {

    Solution solution = new Solution();

    /**
     * [3,1,4,null,2]
     */
    @Test
    public void test_1() {
        int actual = solution.kthSmallest(new TreeNode(3,
                new TreeNode(1, null, new TreeNode(2)),

                new TreeNode(4)
        ), 1);
        assertThat(actual).isEqualTo(1);
    }

    /**
     * [5,3,6,2,4,null,null,1]
     */
    @Test
    public void test_2() {
        int actual = solution.kthSmallest(new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(2, new TreeNode(1), null),
                        new TreeNode(4)),

                new TreeNode(6)
        ), 3);
        assertThat(actual).isEqualTo(3);
    }

    @Test
    public void test_18() {
        int actual = solution.kthSmallest(new TreeNode(1), 1);
        assertThat(actual).isEqualTo(1);
    }
}