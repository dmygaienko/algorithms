package com.mygaienko.common.algorithms.leetcode.find_smallest_common_element_in_all_rows;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionV2Test {

    SolutionV2 solutionV2 = new SolutionV2();

    @Test
    public void test() {
        assertThat(solutionV2.smallestCommonElement(new int[][]{{5, 6}, {5, 6}, {5, 6}, {4, 6}})).isEqualTo(6);
    }
}