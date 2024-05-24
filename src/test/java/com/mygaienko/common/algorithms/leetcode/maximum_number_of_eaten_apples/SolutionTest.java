package com.mygaienko.common.algorithms.leetcode.maximum_number_of_eaten_apples;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test0() {
        var actual = solution.eatenApples(new int[]{1, 2, 3, 5, 2}, new int[]{3, 2, 1, 4, 2});
        assertThat(actual).isEqualTo(7);
    }

    @Test
    public void test() {
        var actual = solution.eatenApples(new int[]{3, 0, 0, 0, 0, 2}, new int[]{3, 0, 0, 0, 0, 2});
        assertThat(actual).isEqualTo(5);
    }

    @Test
    public void test51() {
        var actual = solution.eatenApples(new int[]{2, 1, 1, 4, 5}, new int[]{10, 10, 6, 4, 2});
        assertThat(actual).isEqualTo(8);
    }

    // 1   1   1   1   1
    // 1   1   1   1   0
    // 0   0   0   0   0


    // 8 1
    // 8 2
    // 3 1
    // 6 1
    //

    @Test
    public void test73() {
        var actual = solution.eatenApples(new int[]{8, 8, 3, 6, 8, 1, 1, 1, 1, 5}, new int[]{1, 2, 1, 1, 5, 10, 9, 8, 7, 2});
        assertThat(actual).isEqualTo(15);
    }

}