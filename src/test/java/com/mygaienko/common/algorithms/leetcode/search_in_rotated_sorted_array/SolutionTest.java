package com.mygaienko.common.algorithms.leetcode.search_in_rotated_sorted_array;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test_original_5() {
        int actual = solution.search(new int[]{0, 1, 2, 3, 4, 5, 6, 7}, 5);
        assertThat(actual).isEqualTo(5);
    }

    @Test
    public void test_original_2() {
        int actual = solution.search(new int[]{0, 1, 2, 3, 4, 5, 6, 7}, 2);
        assertThat(actual).isEqualTo(2);
    }

    @Test
    public void test_0() {
        int actual = solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
        assertThat(actual).isEqualTo(4);
    }

    @Test
    public void test_4() {
        int actual = solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 4);
        assertThat(actual).isEqualTo(0);
    }

    @Test
    public void test_513() {
        int actual = solution.search(new int[]{5, 1, 3}, 5);
        assertThat(actual).isEqualTo(0);
    }

    /**
     * [4,5,6,7,0,1,2]
     * 2
     */
    @Test
    public void test_26() {
        int actual = solution.search(new int[]{4,5,6,7,0,1,2}, 2);
        assertThat(actual).isEqualTo(6);
    }
}