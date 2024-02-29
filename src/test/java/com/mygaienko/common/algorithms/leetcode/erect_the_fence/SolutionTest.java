package com.mygaienko.common.algorithms.leetcode.erect_the_fence;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    /**
     * [[2, 0], [1, 1], [2, 2], [2, 4], [3, 3], [4, 2]]
     * <p>
     * [[2, 0], [4, 2], [3, 3], [2, 2], [2, 4], [1, 1]]
     */
    @Test
    public void test() {
        int[][] trees = new int[][]{{1, 1}, {2, 2}, {2, 0}, {2, 4}, {3, 3}, {4, 2}};
        int[][] result = solution.outerTrees(trees);
        assertThat(result).isEqualTo(new int[][]{{1, 1}, {2, 0}, {4, 2}, {3, 3}, {2, 4}});
    }

}