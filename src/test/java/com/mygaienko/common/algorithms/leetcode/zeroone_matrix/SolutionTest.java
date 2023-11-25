package com.mygaienko.common.algorithms.leetcode.zeroone_matrix;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.updateMatrix(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        });
        assertThat(actual).isEqualTo(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        });
    }

    @Test
    public void test2() {
        var actual = solution.updateMatrix(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        });
        assertThat(actual).isEqualTo(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 2, 1}
        });
    }

    @Test
    public void test3() {
        var actual = solution.updateMatrix(new int[][]{
                {1, 0, 1, 1, 0, 0, 1, 0, 0, 1},
                {0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
                {0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
                {0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
                {0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 0, 1, 1},
                {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
                {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}
        });
        assertThat(actual).isEqualTo(new int[][]{
                {1, 0, 1, 1, 0, 0, 1, 0, 0, 1},
                {0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
                {0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
                {0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
                {0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 0, 1, 1},
                {1, 0, 0, 0, 1, 2, 1, 1, 0, 1},
                {2, 1, 1, 1, 1, 2, 1, 0, 1, 0},
                {3, 2, 2, 1, 0, 1, 0, 0, 1, 1}
        });
    }

    @Test
    public void test4() {
        var actual = solution.updateMatrix(new int[][]{
                {1, 1, 0, 0, 1, 0, 0, 1, 1, 0},
                {1, 0, 0, 1, 0, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 0, 0, 1},
                {1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
                {0, 1, 0, 1, 1, 0, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 0, 1, 1, 1, 1}
        });
        assertThat(actual).isEqualTo(new int[][]{
                {2, 1, 0, 0, 1, 0, 0, 1, 1, 0},
                {1, 0, 0, 1, 0, 1, 1, 2, 2, 1},
                {1, 1, 1, 0, 0, 1, 2, 2, 1, 0},
                {0, 1, 2, 1, 0, 1, 2, 3, 2, 1},
                {0, 0, 1, 2, 1, 2, 1, 2, 1, 0},
                {1, 1, 2, 3, 2, 1, 0, 1, 1, 1},
                {0, 1, 2, 3, 2, 1, 1, 0, 0, 1},
                {1, 2, 1, 2, 1, 0, 0, 1, 1, 2},
                {0, 1, 0, 1, 1, 0, 1, 2, 2, 3},
                {1, 2, 1, 0, 1, 0, 1, 2, 3, 4}
        });
    }
}