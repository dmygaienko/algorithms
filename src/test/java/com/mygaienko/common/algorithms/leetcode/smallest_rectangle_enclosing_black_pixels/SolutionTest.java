package com.mygaienko.common.algorithms.leetcode.smallest_rectangle_enclosing_black_pixels;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.minArea(new char[][]{
                {'0', '0', '1', '0'},
                {'0', '1', '1', '0'},
                {'0', '1', '0', '0'}
        }, 0, 2);
        assertThat(actual).isEqualTo(6);
    }

    @Test
    public void test1() {
        var actual = solution.minArea(new char[][]{
                {'0', '0', '1', '1', '0', '0'},
                {'0', '0', '1', '1', '0', '0'},
                {'0', '0', '1', '1', '0', '0'},
                {'0', '0', '1', '0', '0', '0'},
                {'0', '0', '1', '1', '1', '0'},
                {'0', '0', '1', '0', '1', '1'},
                {'0', '0', '1', '0', '0', '0'},
                {'0', '1', '1', '0', '0', '0'}
        }, 0, 2);
        assertThat(actual).isEqualTo(40);
    }

    @Test
    public void test2() {
        var actual = solution.minArea(new char[][]{
                {'0', '0', '0', '0', '0', '1', '0', '0'},
                {'0', '0', '1', '1', '1', '1', '1', '0'},
                {'0', '0', '1', '1', '1', '1', '0', '0'},
                {'0', '1', '1', '1', '1', '1', '0', '0'},
                {'0', '0', '1', '1', '1', '1', '0', '0'},
                {'0', '0', '1', '1', '1', '1', '0', '0'},
                {'0', '0', '1', '1', '1', '1', '0', '0'},
                {'0', '0', '1', '1', '1', '1', '1', '1'},
                {'0', '0', '1', '1', '1', '1', '0', '0'},
                {'0', '0', '1', '1', '1', '1', '0', '0'},

        }, 4, 4);
        assertThat(actual).isEqualTo(70);
    }
}