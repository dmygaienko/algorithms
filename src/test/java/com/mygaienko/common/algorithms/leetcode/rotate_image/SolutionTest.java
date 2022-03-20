package com.mygaienko.common.algorithms.leetcode.rotate_image;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test_1_1() {
        int[][] matrix = {
                {1}
        };
        solution.rotate(matrix);

        assertThat(matrix).isEqualTo(new int[][] {
                {1}
        });
    }

    @Test
    public void test_2_2() {
        int[][] matrix = {
                {0, 1},
                {2, 3}
        };
        solution.rotate(matrix);

        assertThat(matrix).isEqualTo(new int[][] {
                {2, 0},
                {3, 1}
        });
    }

    @Test
    public void test_3_3() {
        int[][] matrix = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8}
        };
        solution.rotate(matrix);

        assertThat(matrix).isEqualTo(new int[][] {
                {6, 3, 0},
                {7, 4, 1},
                {8, 5, 2}
        });
    }

    @Test
    public void test_4_4() {
        int[][] matrix = {
                {0, 1, 2, 3},
                {4, 5, 6, 7},
                {8, 9, 10, 11},
                {12, 13, 14, 15},

        };
        solution.rotate(matrix);

        assertThat(matrix).isEqualTo(new int[][]{
                {12, 8, 4, 0},
                {13, 9, 5, 1},
                {14, 10, 6, 2},
                {15, 11, 7, 3}
        });
    }

    @Test
    public void test_5_5() {
        int[][] matrix = {
                {0,  1,  2,  3,  4},
                {5,  6,  7,  8,  9},
                {10, 11, 12, 13, 14},
                {15, 16, 17, 18, 19},
                {20, 21, 22, 23, 24}
        };
        solution.rotate(matrix);

        assertThat(matrix).isEqualTo(new int[][]{
                {20, 15, 10, 5, 0},
                {21, 16, 11, 6, 1},
                {22, 17, 12, 7, 2},
                {23, 18, 13, 8, 3},
                {24, 19, 14, 9, 4}
        });
    }
}