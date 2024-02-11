package com.mygaienko.common.algorithms.leetcode.basic_calculator_iv;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        List<String> actual = solution.basicCalculatorIV("e + 8 - a + 5", new String[]{"e"}, new int[]{1});
        assertThat(actual).containsExactly("-1*a", "14");
    }

    @Test
    public void test2() {
        List<String> actual = solution.basicCalculatorIV("e - 8 + temperature - pressure",
                new String[]{"e", "temperature"},
                new int[]{1, 12});
        assertThat(actual).containsExactly("-1*pressure", "5");
    }

    @Test
    public void test31() {
        List<String> actual = solution.basicCalculatorIV("8 * (e - 8)",
                new String[]{},
                new int[]{});
        assertThat(actual).containsExactly("8*e", "-64");
    }

    @Test
    public void test32() {
        List<String> actual = solution.basicCalculatorIV("2 + 8 * (e - 8)",
                new String[]{},
                new int[]{});
        assertThat(actual).containsExactly("8*e", "-62");
    }

    @Test
    public void test33() {
        List<String> actual = solution.basicCalculatorIV("(2 + 8) - (e - 8)",
                new String[]{},
                new int[]{});
        assertThat(actual).containsExactly("-1*e", "18");
    }

    @Test
    public void test331() {
        List<String> actual = solution.basicCalculatorIV("(2 + 8) + (e - 8)",
                new String[]{},
                new int[]{});
        assertThat(actual).containsExactly("1*e", "2");
    }

    @Test
    public void test3() {
        List<String> actual = solution.basicCalculatorIV("(e + 8) * (e - 8)",
                new String[]{},
                new int[]{});
        assertThat(actual).containsExactly("1*e*e", "-64");
    }

    @Test
    public void test63() {
        List<String> actual = solution.basicCalculatorIV("a * b * c + b * a * c * 4",
                new String[]{},
                new int[]{});
        assertThat(actual).containsExactly("5*a*b*c");
    }

    @Test
    public void test6411() {
        List<String> actual = solution.basicCalculatorIV("((a - b) * (b - c))",
                new String[]{},
                new int[]{});
        assertThat(actual).containsExactly(
                "1*a*b", "-1*a*c", "-1*b*b", "1*b*c");
    }

    @Test
    public void test641() {
        List<String> actual = solution.basicCalculatorIV("((a - b) * (b - c) + (c - a))",
                new String[]{},
                new int[]{});
        assertThat(actual).containsExactly(
                "1*a*b", "-1*a*c", "-1*b*b", "1*b*c", "-1*a", "1*c");
    }

    @Test
    public void test64() {
        List<String> actual = solution.basicCalculatorIV("((a - b) * (b - c) + (c - a)) * ((a - b) + (b - c) * (c - a))",
                new String[]{},
                new int[]{});
        assertThat(actual).containsExactly(
                "-1*a*a*b*b", "2*a*a*b*c", "-1*a*a*c*c", "1*a*b*b*b", "-1*a*b*b*c", "-1*a*b*c*c", "1*a*c*c*c", "-1*b*b*b*c", "2*b*b*c*c",
                "-1*b*c*c*c", "2*a*a*b", "-2*a*a*c", "-2*a*b*b", "2*a*c*c", "1*b*b*b", "-1*b*b*c", "1*b*c*c", "-1*c*c*c", "-1*a*a", "1*a*b", "1*a*c", "-1*b*c");
    }

    @Test
    public void test50() {
        List<String> actual = solution.basicCalculatorIV("a * b * b",
                new String[]{"a"},
                new int[]{0});
        assertThat(actual).isEmpty();
    }

    @Test
    public void test1() {
        List<String> actual = solution.basicCalculatorIV("11 - 1 - bx * 0 - 10",
                new String[]{"bx"},
                new int[]{10});
        assertThat(actual).isEmpty();
    }

    @Test
    public void test122() {
        List<String> actual = solution.basicCalculatorIV("(w + 9) * ak",
                new String[]{},
                new int[]{});
        assertThat(actual).containsExactly("1*ak*w", "9*ak");
    }

    @Test
    public void test123() {
        List<String> actual = solution.basicCalculatorIV("(w + 9) * (ak)",
                new String[]{},
                new int[]{});
        assertThat(actual).containsExactly("1*ak*w", "9*ak");
    }

    @Test
    public void test124() {
        List<String> actual = solution.basicCalculatorIV("(w + 9 * 12 + 9) * ak - (ab * 8 - 9 * bk) - 0",
                new String[]{},
                new int[]{});
        assertThat(actual).containsExactly("1*ak*w", "-8*ab", "117*ak", "9*bk");
    }

    @Test
    public void test125() {
        List<String> actual = solution.basicCalculatorIV("(12 + 9) * ak - (9 * bk) - 0",
                new String[]{},
                new int[]{});
        assertThat(actual).containsExactly("21*ak", "-9*bk");
    }

    @Test
    public void test126() {
        List<String> actual = solution.basicCalculatorIV("(12 + 9) * ak - (9 * bk) - 0",
                new String[]{},
                new int[]{});
        assertThat(actual).containsExactly("21*ak", "-9*bk");
    }

    @Test
    public void test127() {
        List<String> actual = solution.basicCalculatorIV("(5 * ca) * 7 * (7 + bw)",
                new String[]{},
                new int[]{});
        assertThat(actual).containsExactly("35*bw*ca", "245*ca");
    }

    @Test
    public void test128() {
        List<String> actual = solution.basicCalculatorIV("(cd + 6) * ((5 - f) * q) - (f - 1)",
                new String[]{},
                new int[]{});
        assertThat(actual).containsExactly("-1*cd*f*q", "5*cd*q", "-6*f*q", "-1*f", "30*q", "1");
    }

    @Test
    public void test1281() {
        List<String> actual = solution.basicCalculatorIV("(cd + 6) * ((5 - f) * q) - 1",
                new String[]{},
                new int[]{});
        assertThat(actual).containsExactly("-1*cd*f*q", "5*cd*q", "-6*f*q", "30*q", "-1");
    }

    @Test
    public void test1282() {
        List<String> actual = solution.basicCalculatorIV("6 * ((5 - f) * q) - 1",
                new String[]{},
                new int[]{});
        assertThat(actual).containsExactly("-6*f*q", "30*q", "-1");
    }

}