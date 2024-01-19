package com.mygaienko.common.algorithms.leetcode.verify_preorder_sequence_in_binary_search_tree;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        boolean actual = solution.verifyPreorder(new int[]{5, 2, 1, 3, 6});
        assertThat(actual).isTrue();
    }

    @Test
    public void test2() {
        boolean actual = solution.verifyPreorder(new int[]{5, 2, 6, 1, 3});
        assertThat(actual).isFalse();
    }

    @Test
    public void test3() {
        boolean actual = solution.verifyPreorder(new int[]{5, 2, 3, 6});
        assertThat(actual).isTrue();
    }

    @Test
    public void test4() {
        boolean actual = solution.verifyPreorder(new int[]{2, 3, 1});
        assertThat(actual).isFalse();
    }

    @Test
    public void test5() {
        boolean actual = solution.verifyPreorder(new int[]{1, 3, 4, 2});
        assertThat(actual).isFalse();
    }

    @Test
    public void test6() {
        boolean actual = solution.verifyPreorder(new int[]{5, 2, 1, 3, 6, 7, 8});
        assertThat(actual).isTrue();
    }

    @Test
    public void test7() {
        boolean actual = solution.verifyPreorder(new int[]{9, 4, 2, 1, 3, 6, 5, 7, 13, 11, 10, 12, 15, 14, 16});
        assertThat(actual).isTrue();
    }

}