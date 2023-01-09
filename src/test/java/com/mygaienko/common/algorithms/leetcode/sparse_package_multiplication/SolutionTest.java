package com.mygaienko.common.algorithms.leetcode.sparse_package_multiplication;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    public void test() {
        int[][] actual = solution.multiply(new int[][]{{1, 0, 0}, {-1, 0, 3}}, new int[][]{{7, 0, 0}, {0, 0, 0}, {0, 0, 1}});
        assertThat(actual).isEqualTo(new int[][] {{7,0,0}, {-7,0,3}});
    }

    @Test
    public void test1() {
        int[][] actual = solution.multiply(new int[][]{{1, -5}}, new int[][]{{12}, {-1}});
        assertThat(actual).isEqualTo(new int[][] {{17}});
    }

}