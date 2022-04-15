package com.mygaienko.common.algorithms.leetcode.backspace_string_compare;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        assertThat(solution.backspaceCompare("ab#c", "ad#c")).isTrue();
    }

    @Test
    public void test_0() {
        assertThat(solution.backspaceCompare("ab##", "c#d#")).isTrue();
    }

    /**
     * "xywrrmp"
     * "xywrrm#p"
     */
    @Test
    public void test0() {
        assertThat(solution.backspaceCompare("xywrrmp", "xywrrm#p")).isFalse();
    }

    @Test
    public void test2() {
        assertThat(solution.backspaceCompare("bxj##tw", "bxj###tw")).isFalse();
    }
}