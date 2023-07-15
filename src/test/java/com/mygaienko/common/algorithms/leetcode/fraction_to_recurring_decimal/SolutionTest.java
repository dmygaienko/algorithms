package com.mygaienko.common.algorithms.leetcode.fraction_to_recurring_decimal;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

// 4 / 333
// add 0 till  numerator >= denominator, but result will be multiplied on 10 ^ (-1)
// 400 / 333  =>  result to multiple by 10 ^ (-2)
// 400 / 333 = 67
// 400 % 333 = 67
// 670 / 333 = 2
// 670 % 333 = 4 the same as 400
//
public class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    public void test1() {
        String actual = solution.fractionToDecimal(1, 2);
        assertThat(actual).isEqualTo("0.5");
    }

    @Test
    public void test2() {
        String actual = solution.fractionToDecimal(2, 1);
        assertThat(actual).isEqualTo("2");
    }

    @Test
    public void test3() {
        String actual = solution.fractionToDecimal(4, 333);
        assertThat(actual).isEqualTo("0.(012)");
    }

    @Test
    public void test1_3() {
        String actual = solution.fractionToDecimal(1, 3);
        assertThat(actual).isEqualTo("0.(3)");
    }

    @Test
    public void test1_6() {
        String actual = solution.fractionToDecimal(1, 6);
        assertThat(actual).isEqualTo("0.1(6)");
    }

    @Test
    public void test20() {
        String actual = solution.fractionToDecimal(1, 99);
        assertThat(actual).isEqualTo("0.(01)");
    }

    @Test
    public void test22() {
        String actual = solution.fractionToDecimal(22, 7);
        assertThat(actual).isEqualTo("3.(142857)");
    }

    @Test
    public void test28() {
        String actual = solution.fractionToDecimal(-50, 8);
        assertThat(actual).isEqualTo("-6.25");
    }

    @Test
    public void test30() {
        String actual = solution.fractionToDecimal(0, -5);
        assertThat(actual).isEqualTo("0");
    }

    @Test
    public void test31() {
        String actual = solution.fractionToDecimal(-1, -2147483648);
        assertThat(actual).isEqualTo("0.0000000004656612873077392578125");
    }

    @Test
    public void test38() {
        String actual = solution.fractionToDecimal(2147483647, 370000);
        assertThat(actual).isEqualTo("5804.0098(567)");
    }
}