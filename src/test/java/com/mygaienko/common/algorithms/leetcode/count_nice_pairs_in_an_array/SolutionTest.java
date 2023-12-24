package com.mygaienko.common.algorithms.leetcode.count_nice_pairs_in_an_array;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.countNicePairs(new int[]{42, 11, 1, 97});
        assertThat(actual).isEqualTo(2);
    }

    @Test
    public void test1() {
        var actual = solution.countNicePairs(new int[]{13, 10, 35, 24, 76});
        assertThat(actual).isEqualTo(4);
    }

    @Test
    public void testReverse120() {
        var actual = solution.reverse(1200);
        assertThat(actual).isEqualTo(21);
    }

    @Test
    public void testReverse1542() {
        var actual = solution.reverse(1542);
        assertThat(actual).isEqualTo(2451);
    }

}