package com.mygaienko.common.algorithms.leetcode.maximum_vacation_days;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.maxVacationDays(
                new int[][]{
                        {0, 1, 1},
                        {1, 0, 1},
                        {1, 1, 0}
                },
                new int[][]{
                        {1, 3, 1},
                        {6, 0, 3},
                        {3, 3, 3}
                }
        );
        assertThat(actual).isEqualTo(12);
    }

    @Test
    public void test12() {
        var actual = solution.maxVacationDays(
                new int[][]{
                        {0, 1, 0},
                        {0, 0, 0},
                        {0, 0, 0}
                },
                new int[][]{
                        {0, 0, 7},
                        {2, 0, 0},
                        {7, 7, 7}
                }
        );
        assertThat(actual).isEqualTo(7);
    }

    /**
     * [[0,1,0],[1,0,0],[1,1,0]]
     * [[3,4,6],[6,5,5],[6,0,2]]
     */
    @Test
    public void test13() {
        var actual = solution.maxVacationDays(
                new int[][]{
                        {0, 1, 0},
                        {1, 0, 0},
                        {1, 1, 0}
                },
                new int[][]{
                        {3, 4, 6},
                        {6, 5, 5},
                        {6, 0, 2}
                }
        );
        assertThat(actual).isEqualTo(17);
    }
}