package com.mygaienko.common.algorithms.leetcode.missing_element;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test1() {
        int actual = solution.missingElement(new int[]{4, 7, 9, 10}, 1);
        assertThat(actual).isEqualTo(5);
    }

    @Test
    public void test2() {
        int actual = solution.missingElement(new int[]{4, 7, 9, 10}, 3);
        assertThat(actual).isEqualTo(8);
    }

    @Test
    public void test3() {
        int actual = solution.missingElement(new int[]{1, 2, 4}, 3);
        assertThat(actual).isEqualTo(6);
    }
}