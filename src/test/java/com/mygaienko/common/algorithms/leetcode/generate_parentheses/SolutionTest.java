package com.mygaienko.common.algorithms.leetcode.generate_parentheses;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        List<String> strings = solution.generateParenthesis(1);
        assertThat(strings).containsExactlyInAnyOrder("()");
    }

    @Test
    public void test2() {
        List<String> strings = solution.generateParenthesis(2);
        assertThat(strings).containsExactlyInAnyOrder("(())","()()");
    }

    /**
     * but could not find the following elements:
     *   ["(())()"]
     */
    @Test
    public void test3() {
        List<String> strings = solution.generateParenthesis(3);
        System.out.println(strings);
        assertThat(strings).containsExactlyInAnyOrder("((()))","(()())","(())()","()(())","()()()");
    }

    @Test
    public void test4() {
        List<String> strings = solution.generateParenthesis(4);
        System.out.println(strings);
        assertThat(strings).containsExactlyInAnyOrder(
                "(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()",
                "(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()");
    }
}