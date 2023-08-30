package com.mygaienko.common.algorithms.leetcode.detect_squares;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class DetectSquaresTest {

    DetectSquares detectSquares = new DetectSquares();

    /**
     * ["DetectSquares","add",  "add",      "add",  "count",    "count",    "add",  "count"]
     *
     * [[],             [[3,10]],[[11,2]],  [[3,2]],[[11,10]],  [[14,8]],   [[11,2]],[[11,10]]]
     */
    @Test
    public void test() {
        detectSquares.add(new int[] {3, 10});
        detectSquares.add(new int[] {11, 2});
        detectSquares.add(new int[] {3, 2});

        assertThat(detectSquares.count(new int[]{11, 10})).isEqualTo(1);
        assertThat(detectSquares.count(new int[]{14, 8})).isEqualTo(0);

        detectSquares.add(new int[] {11, 2});
        assertThat(detectSquares.count(new int[]{11, 10})).isEqualTo(2);
    }
}