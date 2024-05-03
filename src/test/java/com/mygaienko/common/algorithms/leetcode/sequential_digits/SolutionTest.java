package com.mygaienko.common.algorithms.leetcode.sequential_digits;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.sequentialDigits(100, 300);
        assertThat(actual).isEqualTo(List.of(123, 234));
    }

    @Test
    public void test2() {
        var actual = solution.sequentialDigits(1000, 13000);
        assertThat(actual).isEqualTo(List.of(1234, 2345, 3456, 4567, 5678, 6789, 12345));
    }

    @Test
    public void test3() {
        var actual = solution.sequentialDigits(58, 155);
        assertThat(actual).isEqualTo(List.of(67, 78, 89, 123));
    }
}