package com.mygaienko.common.algorithms.leetcode.pattern_132;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        boolean actual = solution.find132pattern(new int[]{3, 1, 4, 2});
        assertThat(actual).isEqualTo(true);
    }

    @Test
    public void test1() {
        boolean actual = solution.find132pattern(new int[]{1,0,1,-4,-3});
        assertThat(actual).isEqualTo(false);
    }

    @Test
    public void test2() {
        boolean actual = solution.find132pattern(new int[]{3,5,0,3,4});
        assertThat(actual).isEqualTo(true);
    }
}