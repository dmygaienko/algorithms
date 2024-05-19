package com.mygaienko.common.algorithms.leetcode.minimum_rounds_to_complete_all_tasks;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test0() {
        var actual = solution.minimumRounds(new int[]{2, 2, 3, 3, 2, 4, 4, 4, 4, 4});
        assertThat(actual).isEqualTo(4);
    }

    @Test
    public void test2() {
        var actual = solution.minimumRounds(new int[]{5, 5, 5, 5});
        assertThat(actual).isEqualTo(2);
    }

    @Test
    public void test() {
        var actual = solution.minimumRounds(new int[]{9, 9, 11, 9, 22, 22, 11, 552, 22, 22, 55});
        assertThat(actual).isEqualTo(-1);
    }

    @Test
    public void test61() {
        var actual = solution.minimumRounds(new int[]{9, 9, 9, 11, 11, 22, 22, 22, 22, 55, 55});
        assertThat(actual).isEqualTo(5);
    }
}