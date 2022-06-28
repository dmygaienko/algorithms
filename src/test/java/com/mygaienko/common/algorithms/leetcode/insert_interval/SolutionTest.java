package com.mygaienko.common.algorithms.leetcode.insert_interval;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class SolutionTest {

    Solution solution = new Solution();


    @Test
    public void test0() {
        int[][] actual = solution.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5});
        assertThat(actual).isEqualTo(new int[][]{{1,5}, {6,9}});
    }

    @Test
    public void test1() {
        int[][] actual = solution.insert(new int[][]{{1, 2}, {3, 5}, {6,7}, {8, 10}, {12, 16}}, new int[]{4, 8});
        assertThat(actual).isEqualTo(new int[][]{{1,2}, {3,10}, {12,16}});
    }

    @Test
    public void test2() {
        int[][] actual = solution.insert(new int[][]{{1, 5}}, new int[]{6, 8});
        assertThat(actual).isEqualTo(new int[][]{{1, 5}, {6, 8}});
    }

    @Test
    public void test3() {
        int[][] actual = solution.insert(new int[][]{{6, 8}}, new int[]{1, 5});
        assertThat(actual).isEqualTo(new int[][]{{1, 5}, {6, 8}});
    }

    @Test
    public void test4() {
        int[][] actual = solution.insert(new int[][]{{3, 5}, {12, 15}}, new int[]{6, 6});
        assertThat(actual).isEqualTo(new int[][]{{3, 5}, {6, 6}, {12, 15}});
    }

}