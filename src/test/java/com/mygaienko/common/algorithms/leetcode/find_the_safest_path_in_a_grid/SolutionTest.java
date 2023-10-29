package com.mygaienko.common.algorithms.leetcode.find_the_safest_path_in_a_grid;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.maximumSafenessFactor(List.of(
                new ArrayList<>(List.of(0, 0, 1)),
                new ArrayList<>(List.of(0, 0, 0)),
                new ArrayList<>(List.of(0, 0, 0))
        ));
        assertThat(actual).isEqualTo(2);
    }

    /**
     * [[0,1,1],[0,1,1],[0,0,0]]
     */
    @Test
    public void test1() {
        var actual = solution.maximumSafenessFactor(List.of(
                new ArrayList<>(List.of(0, 1, 1)),
                new ArrayList<>(List.of(0, 1, 1)),
                new ArrayList<>(List.of(0, 0, 0))
        ));
        assertThat(actual).isEqualTo(1);
    }
}