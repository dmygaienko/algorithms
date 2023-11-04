package com.mygaienko.common.algorithms.leetcode.maximize_the_confusion_of_an_exam;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.maxConsecutiveAnswers("TTFTTFTT", 1);
        assertThat(actual).isEqualTo(5);
    }

    @Test
    public void test2() {
        var actual = solution.maxConsecutiveAnswers("TFFT", 1);
        assertThat(actual).isEqualTo(3);
    }

    @Test
    public void test3() {
        var actual = solution.maxConsecutiveAnswers("F", 1);
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void test61() {
        var actual = solution.maxConsecutiveAnswers("FFFTTFTTFT", 3);
        assertThat(actual).isEqualTo(8);
    }

    @Test
    public void test90() {
        var actual = solution.maxConsecutiveAnswers("TTFFTTTTFTTTTTFFFFFTFTFFFFTFTFFFTTFFTTFFTFTFFTTFTFTTTTFFTFFFFFFTFTFTFFFTFTTFFFTTFFFTTFFTFFTTFFTTTTTF", 51);
        assertThat(actual).isEqualTo(100);
    }

    @Test
    public void test91() {
        var actual = solution.maxConsecutiveAnswers("FFTFFFTTFTTTFFFFTTTTFFFTTTTFFTTFTTFTTTFTFTTFFFTTFTTFTTFFFTFFFTFFFTFTFTTTFTFTFFFTTTFFFFTTTTFFFTTTFTFF", 1);
        assertThat(actual).isEqualTo(7);
    }

    @Test
    public void test92() {
        var actual = solution.maxConsecutiveAnswers("TTTFFFFT", 2);
        assertThat(actual).isEqualTo(6);
    }
}