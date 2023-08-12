package com.mygaienko.common.algorithms.leetcode.swap_adjacent_in_lr_string;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test0() {
        boolean actual = solution.canTransform(
                "RXXLRXRXL",
                "XRLXXRRLX");
        assertThat(actual).isTrue();
    }

    @Test
    public void test60() {
        boolean actual = solution.canTransform("XXXRXXXLXRXXR", "XXXRXXXLXXXXR");
        assertThat(actual).isFalse();
    }

    @Test
    public void test62() {
        boolean actual = solution.canTransform("XXXXXLXXXX", "LXXXXXXXXX");
        assertThat(actual).isTrue();
    }

    @Test
    public void test68() {
        boolean actual = solution.canTransform(
                "XLXRRXXRXX",
                "LXXXXXXRRR");
        assertThat(actual).isTrue();
    }

    @Test
    public void test71() {
        boolean actual = solution.canTransform(
                "XXXLXXLXXLXXRXXXRXLXRXRXXXXXLX",
                "LLLXXXXXXXXXXXXXRRLXXXXXXXRRLX");
        assertThat(actual).isTrue();
    }

    @Test
    public void test77() {
        boolean actual = solution.canTransform(
                "XXRXXXXRXXXXXXRXXXXLXXXXLXLXXXXXXRXXXXLX",
                "XXXXXXXXXXXXRRRLLLXXXXXXXXXXXXXXXXXXRLXX");
        assertThat(actual).isTrue();
    }

}