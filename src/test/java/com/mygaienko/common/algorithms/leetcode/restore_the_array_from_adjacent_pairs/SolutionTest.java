package com.mygaienko.common.algorithms.leetcode.restore_the_array_from_adjacent_pairs;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.restoreArray(new int[][]{
                {2, 1}, {3, 4}, {3, 2}
        });

        assertThat(actual).isEqualTo(new int[]{1, 2, 3, 4});
    }
}