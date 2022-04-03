package com.mygaienko.common.algorithms.leetcode.minimum_cost_to_hire_k_workers;

import org.assertj.core.data.Offset;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test0() {
        double actual = solution.mincostToHireWorkers(new int[]{10, 20, 5}, new int[]{70, 50, 30}, 2);
        assertThat(actual).isEqualTo(105.0d);
    }

    /**
     * 0 = 4
     * 2 = 13.333
     * 3 = 13.333
     *
     * q    3,   1,  10,  10,   1
     * w    4,   8,  2,   2,    7
     *
     *      1.33 8  0.5  0.5   7
     *      12   8   20  20    7
     */
    @Test
    public void test1() {
        double actual = solution.mincostToHireWorkers(new int[]{3, 1, 10, 10, 1}, new int[]{4, 8, 2, 2, 7}, 3);
        assertThat(actual).isEqualTo(30.66667d, Offset.offset(0.001d));
    }

    @Test
    public void test2() {
        double actual = solution.mincostToHireWorkers(new int[]{1, 2}, new int[]{14, 16}, 1);
        assertThat(actual).isEqualTo(14d, Offset.offset(0.001d));
    }

    @Test
    public void test3() {
        double actual = solution.mincostToHireWorkers(new int[]{2, 1, 5}, new int[]{17, 6, 4}, 2);
        assertThat(actual).isEqualTo(25.5d, Offset.offset(0.001d));
    }

}