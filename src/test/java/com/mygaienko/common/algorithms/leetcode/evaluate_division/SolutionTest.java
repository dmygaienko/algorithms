package com.mygaienko.common.algorithms.leetcode.evaluate_division;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test0() {
        double[] actual = solution.calcEquation(List.of(
                        List.of("a", "b"),
                        List.of("b", "c")
                ),
                new double[]{2.0d, 3.0d},
                List.of(
                        List.of("a", "c"),
                        List.of("b", "a"),
                        List.of("a", "e"),
                        List.of("a", "a"),
                        List.of("e", "e")
                ));
        assertArrayEquals(new double[]{6.0d, 0.5d, -1.0d, 1.0d, -1.0d}, actual, 0.1d);
    }

    @Test
    public void test1() {
        double[] actual = solution.calcEquation(List.of(
                        List.of("a", "e"),
                        List.of("b", "e")
                ),
                new double[]{4.0d, 3.0d},
                List.of(
                        List.of("a", "b"),
                        List.of("e", "e"),
                        List.of("x", "x")
                ));
        assertArrayEquals(new double[]{1.33333d, 1.0d, -1.0d}, actual, 0.1d);
    }

    @Test
    public void test2() {
        double[] actual = solution.calcEquation(List.of(
                        List.of("b", "e"),
                        List.of("a", "e")
                ),
                new double[]{3.0d, 4.0d},
                List.of(
                        List.of("a", "b"),
                        List.of("e", "e"),
                        List.of("x", "x")
                ));
        assertArrayEquals(new double[]{1.33333d, 1.0d, -1.0d}, actual, 0.1d);
    }

    @Test
    public void test3() {
        double[] actual = solution.calcEquation(List.of(
                        List.of("x1", "x2"),
                        List.of("x2", "x3"),
                        List.of("x3", "x4"),
                        List.of("x4", "x5")
                ),
                new double[]{3.0d, 4.0d, 5.0d, 6.0d},
                List.of(
                        List.of("x1", "x5"),
                        List.of("x5", "x2"),
                        List.of("x2", "x4"),
                        List.of("x2", "x2"),
                        List.of("x2", "x9"),
                        List.of("x9", "x9")
                ));
        assertArrayEquals(new double[]{360.00000,0.00833,20.00000,1.00000,-1.00000,-1.00000}, actual, 0.1d);
    }

    @Test
    public void test4() {
        double[] actual = solution.calcEquation(List.of(
                        List.of("a", "b"),
                        List.of("e", "f"),
                        List.of("b", "e")
                ),
                new double[]{3.4d, 1.4d, 2.3d},
                List.of(
                        List.of("b", "a"),
                        List.of("a", "f"),
                        List.of("f", "f"),
                        List.of("e", "e"),
                        List.of("c", "c"),
                        List.of("a", "c"),
                        List.of("f", "e")
                ));
        assertArrayEquals(new double[]{0.29412,10.94800,1.00000,1.00000,-1.00000,-1.00000,0.71429}, actual, 0.1d);
    }

    @Test
    public void test5() {
        double[] actual = solution.calcEquation(List.of(
                        List.of("a", "b"),
                        List.of("c", "d")
                ),
                new double[]{1.0d, 1.0d},
                List.of(
                        List.of("a", "c"),
                        List.of("b", "d"),
                        List.of("b", "a"),
                        List.of("d", "c")
                ));
        assertArrayEquals(new double[]{-1.00000,-1.00000,1.00000,1.00000}, actual, 0.1d);
    }

    @Test
    public void test6() {
        double[] actual = solution.calcEquation(List.of(
                        List.of("a", "b"),
                        List.of("b", "c"),
                        List.of("a", "c")
                ),
                new double[]{2.0d, 3.0d, 6.0d},
                List.of(
                        List.of("a", "c"),
                        List.of("b", "a"),
                        List.of("a", "e"),
                        List.of("a", "a"),
                        List.of("x", "x")
                ));
        assertArrayEquals(new double[]{6.00000,0.50000,-1.00000,1.00000,-1.00000}, actual, 0.1d);
    }

    @Test
    public void test7() {
        double[] actual = solution.calcEquation(List.of(
                        List.of("a", "b"),
                        List.of("c", "b"),
                        List.of("d", "b"),
                        List.of("w", "x"),
                        List.of("y", "x"),
                        List.of("z", "x"),
                        List.of("w", "d")
                ),
                new double[]{2.0d, 3.0d, 4.0d, 5.0d, 6.0d, 7.0d, 8.0d},
                List.of(
                        List.of("a", "c"),
                        List.of("b", "c"),
                        List.of("a", "e"),
                        List.of("a", "a"),
                        List.of("x", "x"),
                        List.of("a", "z")
                ));
        assertArrayEquals(new double[]{0.66667,0.33333,-1.00000,1.00000,1.00000,0.04464}, actual, 0.00001d);
    }

    @Test
    public void test8() {
        double[] actual = solution.calcEquation(List.of(
                        List.of("a", "b"),
                        List.of("c", "d"),
                        List.of("a", "c")
                ),
                new double[]{4.0d, 6.0d, 8.0d},
                List.of(
                        List.of("a", "d")
                ));
        assertArrayEquals(new double[]{48.0}, actual, 0.00001d);
    }

    @Test
    public void test9() {
        double[] actual = solution.calcEquation(List.of(
                        List.of("a", "b"),
                        List.of("e", "f"),
                        List.of("a", "e")
                ),
                new double[]{3.4d, 1.4d, 2.3d},
                List.of(
                        List.of("b", "a"),
                        List.of("a", "f"),
                        List.of("f", "f"),
                        List.of("e", "e"),
                        List.of("c", "c"),
                        List.of("a", "c"),
                        List.of("f", "e")
                ));
        assertArrayEquals(new double[]{0.29412,3.22000,1.00000,1.00000,-1.00000,-1.00000,0.71429}, actual, 0.00001d);
    }

    @Test
    public void test10() {
        double[] actual = solution.calcEquation(List.of(
                        List.of("a", "b"),
                        List.of("c", "d"),
                        List.of("e", "f"),
                        List.of("a", "c"),
                        List.of("c", "f")
                ),
                new double[]{2.0,3.0,4.0,5.0,6.0},
                List.of(
                        List.of("c", "e")
                ));
        assertArrayEquals(new double[]{1.5}, actual, 0.00001d);
    }

}