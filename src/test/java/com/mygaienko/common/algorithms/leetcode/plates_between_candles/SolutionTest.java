package com.mygaienko.common.algorithms.leetcode.plates_between_candles;


import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test1() {
        var actual = solution.platesBetweenCandles("||*|*|", new int[][]{{0, 5}});
        assertThat(actual).isEqualTo(new int[]{2});
    }

    @Test
    public void test2() {
        var actual = solution.platesBetweenCandles("**|**|***|", new int[][]{{2, 5}, {5, 9}});
        assertThat(actual).isEqualTo(new int[]{2, 3});
    }

    @Test
    public void test31() {
        var actual = solution.platesBetweenCandles(
                "|||||*|||*" +
                        "|||*||||*|" +
                        "|||**|*|||" +
                        "**|**||**|" +
                        "||*|||*||*" +
                        "**||*|*||",
                new int[][]{{5, 51}});

        assertThat(actual).isEqualTo(new int[]{14});
    }

    @Test
    public void test32() {
        var actual = solution.platesBetweenCandles(
                "|||||*|||*" +
                        "|||*||||*|" +
                        "|||**|*|||" +
                        "**|**||**|" +
                        "||*|||*||*" +
                        "**||*|*||",
                new int[][]{{8, 50}});

        assertThat(actual).isEqualTo(new int[]{14});
    }

    @Test
    public void test33() {
        var actual = solution.platesBetweenCandles(
                "|||||*|||*" +
                        "|||*||||*|" +
                        "|||**|*|||" +
                        "**|**||**|" +
                        "||*|||*||*" +
                        "**||*|*||",
                new int[][]{{30, 49}});

        assertThat(actual).isEqualTo(new int[]{6});
    }

    @Test
    public void test3() {
        var actual = solution.platesBetweenCandles(
                "|||||*|||*|||*||||*||||**|*|||**|**||**|||*|||*||***||*|*||",
                new int[][]{{7, 52}, {1, 55}, {4, 52}, {0, 56}, {28, 34}, {6, 56}, {19, 56}, {1, 29}, {2, 54}, {6, 52}, {1, 58}, {2, 58}, {8, 50}, {5, 51}, {6, 55}, {2, 51}, {18, 39}, {3, 51}, {4, 54}, {5, 58}, {6, 54}, {8, 58}, {16, 55}, {3, 58}, {5, 52}, {0, 53}, {6, 53}, {11, 18}, {0, 51}, {6, 57}, {0, 9}, {8, 53}, {5, 53}, {4, 58}, {2, 53}, {7, 55}, {2, 55}, {6, 58}, {1, 57}, {6, 50}, {5, 50}, {7, 20}, {3, 50}, {3, 52}, {7, 53}, {7, 51}, {5, 39}, {0, 50}, {5, 54}, {1, 52}, {0, 57}, {6, 11}, {2, 50}, {4, 51}, {1, 50}, {30, 49}, {11, 51}, {7, 54}, {8, 51}});
        assertThat(actual).isEqualTo(new int[]{17, 19, 18, 19, 2, 18, 15, 7, 18, 17, 20, 20, 14, 14, 18, 15, 9, 15, 18, 19, 17, 19, 16, 20, 17, 18, 17, 1, 15, 19, 1, 17, 17, 20, 18, 18, 19, 19, 20, 14, 14, 3, 15, 18, 17, 14, 12, 15, 17, 18, 20, 1, 15, 15, 15, 6, 13, 17, 14});
    }

    @Test
    public void test35() {
        var actual = solution.platesBetweenCandles("|*|*", new int[][]{{3, 3}});
        assertThat(actual).isEqualTo(new int[]{0});
    }


}