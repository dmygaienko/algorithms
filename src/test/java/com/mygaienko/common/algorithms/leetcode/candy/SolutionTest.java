package com.mygaienko.common.algorithms.leetcode.candy;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test1() {
        int actual = solution.candy(new int[]{1, 0, 2});
        assertThat(actual).isEqualTo(5);
    }

    @Test
    public void test2() {
        int actual = solution.candy(new int[]{1, 2, 2});
        assertThat(actual).isEqualTo(4);
    }

    @Test
    public void test3() {
        int actual = solution.candy(new int[]{0, 1, 2});
        assertThat(actual).isEqualTo(6);
    }

    @Test
    public void test4() {
        int actual = solution.candy(new int[]{2, 1, 0});
        assertThat(actual).isEqualTo(6);
    }

    @Test
    public void test12() {                //  1  2  3  1  2  1
        int actual = solution.candy(new int[]{1, 2, 4, 4, 4, 3});
        assertThat(actual).isEqualTo(10);
    }

    @Test
    public void test18() {                //  1  2  3  5  4  3  2  1
        int actual = solution.candy(new int[]{1, 2, 3, 5, 4, 3, 2, 1});
        assertThat(actual).isEqualTo(21);
    }

    @Test
    public void test19() {
        int actual = solution.candy(new int[]{1, 3, 2, 2, 1});
        assertThat(actual).isEqualTo(7);
    }

    @Test
    public void test20_1() {             //   1  3  2  1  1  2  3  4
        int actual = solution.candy(new int[]{1, 3, 2, 1, 1, 2, 3, 4});
        assertThat(actual).isEqualTo(17);
    }

    @Test
    public void test20() {               //   1  2  3  5  4  3  2  1  4  3  2  1  3  2  1  1  2  3  4
        int actual = solution.candy(new int[]{1, 2, 3, 5, 4, 3, 2, 1, 4, 3, 2, 1, 3, 2, 1, 1, 2, 3, 4});
        assertThat(actual).isEqualTo(47);
    }

    @Test
    public void test22() {
        int actual = solution.candy(new int[]{0});
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void test29() {
        int actual = solution.candy(new int[]{1, 6, 10, 8, 7, 3, 2});
        assertThat(actual).isEqualTo(18);
    }

    @Test
    public void test30() {
        int actual = solution.candy(new int[]{5, 3, 7, 3});
        assertThat(actual).isEqualTo(6);
    }

    @Test
    public void test46() {
        int actual = solution.candy(new int[]{
                58, 21, 72, 77, 48, 9, 38, 71, 68, 77,
                82, 47, 25, 94, 89, 54, 26, 54, 54, 99,
                64, 71, 76, 63, 81, 82, 60, 64, 29, 51,
                87, 87, 72, 12, 16, 20, 21, 54, 43, 41,
                83, 77, 41, 61, 72, 82, 15, 50, 36, 69,
                49, 53, 92, 77, 16, 73, 12, 28, 37, 41,
                79, 25, 80, 3, 37, 48, 23, 10, 55, 19,
                51, 38, 96, 92, 99, 68, 75, 14, 18, 63,
                35, 19, 68, 28, 49, 36, 53, 61, 64, 91,
                2, 43, 68, 34, 46, 57, 82, 22, 67, 89});
        assertThat(actual).isEqualTo(208);
    }

}