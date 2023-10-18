package com.mygaienko.common.algorithms.leetcode.decoded_string_at_index;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.decodeAtIndex("leet2code3", 10);
        assertThat(actual).isEqualTo("o");
    }

    @Test
    public void test1() {
        var actual = solution.decodeAtIndex("ha22", 5);
        assertThat(actual).isEqualTo("h");
    }

    @Test
    public void test2() {
        var actual = solution.decodeAtIndex("a2345678999999999999999", 1);
        assertThat(actual).isEqualTo("a");
    }

    @Test
    public void test23() {
        var actual = solution.decodeAtIndex("a23", 6);
        assertThat(actual).isEqualTo("a");
    }
}