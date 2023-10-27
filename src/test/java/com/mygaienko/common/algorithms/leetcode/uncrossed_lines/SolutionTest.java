package com.mygaienko.common.algorithms.leetcode.uncrossed_lines;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        int actual = solution.maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4});
        assertThat(actual).isEqualTo(2);
    }

    /**
     *
     */
    @Test
    public void test2() {
        int actual = solution.maxUncrossedLines(
                new int[]{2, 5, 1, 2, 5},
                new int[]{10, 5, 2, 1, 5, 2});
        assertThat(actual).isEqualTo(3);
    }

    /**
     *      1   3   7   1   7   5
     *   1 -1   1   1  -1   1   1
     *   9  1   1   1   1   1   1
     *   2  1   1   1   1   1   1
     *   5  1   1   1   1   1  -2
     *   1  1   1   1   2   2   2
     */
    @Test
    public void test3() {
        int actual = solution.maxUncrossedLines(new int[]{1, 3, 7, 1, 7, 5}, new int[]{1, 9, 2, 5, 1});
        assertThat(actual).isEqualTo(2);
    }

    /**
     *       1   2   1   3   3   2
     *    2  0  -1   1   1   1  -1
     *    1  0   1   2   2   2   2
     *
     *
     *      2   1
     *    1 0  -1
     *    2 1   1
     *    1 1
     *    3
     *    3
     *    2
     */
    @Test
    public void test38() {
        int actual = solution.maxUncrossedLines(new int[]{2, 1}, new int[]{1, 2, 1, 3, 3, 2});
        assertThat(actual).isEqualTo(2);
    }

    /**
     *      3   2
     *    2 0  -1
     *    2 0   1
     *    2 0   1
     *    3 1   1
     */
    @Test
    public void test37() {
        int actual = solution.maxUncrossedLines(new int[]{3,2}, new int[]{2,2,2,3});
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void test71() {
        int actual = solution.maxUncrossedLines(
                new int[]{1,5,3,5,3,5,5,4,4,3,2,3,5,4,5,4,5,2,5,3,3,1,4,4,3,1,1,1,4,4},
                new int[]{1,3,2,2,5,2,3,1,1,3,5,4,5,5,3,5,4,1,2,5});
        assertThat(actual).isEqualTo(12);
    }

    @Test
    public void test57() {
        int actual = solution.maxUncrossedLines(
                new int[]{                3,1,4,1,    1,  3,  5,  1,2,  2},

                new int[]{4,1,5,2,1,1,1,5,3,1,1,1,2,3,1,4,3,5,5,3,1,2,3,2,4,1,1,1,5,3});
        assertThat(actual).isEqualTo(9);
    }
}