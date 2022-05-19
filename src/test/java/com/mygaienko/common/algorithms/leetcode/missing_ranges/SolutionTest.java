package com.mygaienko.common.algorithms.leetcode.missing_ranges;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test0() {
        List<String> missingRanges = solution.findMissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 99);
        assertThat(missingRanges).isEqualTo(List.of(
                "2",
                "4->49",
                "51->74",
                "76->99"
        ));
    }

    @Test
    public void test1() {
        List<String> missingRanges = solution.findMissingRanges(new int[]{}, 1, 1);
        assertThat(missingRanges).isEqualTo(List.of(
                "1"
        ));
    }

    /**
     * [-1000000000,1000000000]
     * -1000000000
     * 1000000000
     */
    @Test
    public void test2() {
        List<String> missingRanges = solution.findMissingRanges(new int[]{-1000000000, 1000000000}, -1000000000, 1000000000);
        assertThat(missingRanges).isEqualTo(List.of(
                "-999999999->999999999"
        ));
    }
}