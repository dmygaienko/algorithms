package com.mygaienko.common.algorithms.leetcode.minimum_adjacent_swaps_to_make_a_valid_array;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test1() {
        var actual = solution.minimumSwaps(new int[]{3, 4, 5, 5, 3, 1});
        assertThat(actual).isEqualTo(6);
    }

    @Test
    public void test2() {
        var actual = solution.minimumSwaps(new int[]{9});
        assertThat(actual).isEqualTo(0);
    }

    @Test
    public void test3() {
        var actual = solution.minimumSwaps(new int[]{2, 1});
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void test36() {
        var actual = solution.minimumSwaps(new int[]{21, 37, 20, 36, 20, 30, 36, 20, 2, 29, 35, 26, 34, 36, 20, 36, 17, 35});
        assertThat(actual).isEqualTo(23);
    }
}