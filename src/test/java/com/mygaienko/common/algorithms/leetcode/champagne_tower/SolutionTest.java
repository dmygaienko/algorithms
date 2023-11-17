package com.mygaienko.common.algorithms.leetcode.champagne_tower;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.champagneTower(1, 1, 1);
        assertThat(actual).isEqualTo(0);
    }

    @Test
    public void test2() {
        var actual = solution.champagneTower(2, 1, 1);
        assertThat(actual).isEqualTo(0.5);
    }

    @Test
    public void test3() {
        var actual = solution.champagneTower(100000009, 33, 17);
        assertThat(actual).isEqualTo(1.0);
    }

    @Test
    public void test4() {
        var actual = solution.champagneTower(1000000000, 99, 99);
        assertThat(actual).isEqualTo(1.0);
    }
}