package com.mygaienko.common.algorithms.leetcode.search_suggestions_system;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.suggestedProducts(new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad" }, "mouse");
        assertThat(actual).isEqualTo(List.of(
                List.of("mobile", "moneypot", "monitor"),
                List.of("mobile", "moneypot", "monitor"),
                List.of("mouse", "mousepad"),
                List.of("mouse", "mousepad"),
                List.of("mouse", "mousepad")
        ));
    }

    @Test
    public void test1() {
        var actual = solution.suggestedProducts(new String[]{"mobile", "mouse", "moneypot", "mon", "mousepad" }, "mouse");
        assertThat(actual).isEqualTo(List.of(
                List.of("mobile", "mon", "moneypot"),
                List.of("mobile", "mon", "moneypot"),
                List.of("mouse", "mousepad"),
                List.of("mouse", "mousepad"),
                List.of("mouse", "mousepad")
        ));
    }
}