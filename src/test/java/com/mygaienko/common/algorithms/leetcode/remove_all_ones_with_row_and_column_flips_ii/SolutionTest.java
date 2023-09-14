package com.mygaienko.common.algorithms.leetcode.remove_all_ones_with_row_and_column_flips_ii;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        int actual = solution.removeOnes(new int[][]{
                {1, 1, 1},
                {1, 1, 1},
                {0, 1, 0}
        });
        assertThat(actual).isEqualTo(2);
    }

    @Test
    public void test2() {
        int actual = solution.removeOnes(new int[][]{
                {0, 1, 0},
                {1, 0, 1},
                {0, 1, 0}
        });
        assertThat(actual).isEqualTo(2);
    }

    /**
     * {3, 1}
     * {4, 2}
     */
    @Test
    public void test61_1() {
        int actual = solution.removeOnes(new int[][]{
                {0,0,1},
                {0,1,0},
                {0,1,1},
                {1,1,0},
                {1,0,1}});
        assertThat(actual).isEqualTo(2);
    }

    /**
     * [Point{i=1, j=1, weight=2},
     * Point{i=0, j=3, weight=3}, Point{i=2, j=4, weight=3},
     * Point{i=0, j=4, weight=4}, Point{i=1, j=0, weight=4}, Point{i=2, j=0, weight=4},
     * Point{i=0, j=0, weight=5}]
     * <p>
     * after removing {0. 0} weight for {1, 1} is not updated (from 2 -> 1) which leads to bug while rollbacking {1,1} (it become 3)
     */
    @Test
    public void test61() {
        int actual = solution.removeOnes(new int[][]{
                {1, 0, 0, 1, 1},
                {1, 1, 0, 0, 0},
                {1, 0, 0, 0, 1}
        });
        assertThat(actual).isEqualTo(2);
    }

    /**
     * 3,0
     * 4,1
     */
    @Test
    public void test64() {
        int actual = solution.removeOnes(new int[][]{
                {0, 1, 0},
                {0, 0, 0},
                {1, 0, 0},
                {1, 1, 1},
                {0, 1, 1}
        });
        assertThat(actual).isEqualTo(2);
    }
}