package com.mygaienko.common.algorithms.leetcode.most_stones_removed_with_same_row_or_column;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test_0_2h() {
        int actual = solution.removeStones(new int[][]{
                {0, 0}, {0, 1},

        });
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void test_0_2v() {
        int actual = solution.removeStones(new int[][]{
                {0, 1},
                {1, 1},
        });
        assertThat(actual).isEqualTo(1);
    }

    /**
     *  1 0 1 0
     *  0 1 0 1
     */
    @Test
    public void test_0() {
        int actual = solution.removeStones(new int[][]{
                {0, 0}, {0, 2},
                {1, 1}, {1, 3}
        });
        assertThat(actual).isEqualTo(2);
    }

    @Test
    public void test_0_3() {
        int actual = solution.removeStones(new int[][]{
                {0, 0}, {0, 2},
                {1, 1}, {1, 3},  {1, 4}
        });
        assertThat(actual).isEqualTo(3);
    }

    /**
     *  1 1 0 0 0
     *  1 0 1 0 0
     *  0 1 1 0 0
     *  0 0 0 0 0
     *  0 0 0 0 0
     *
     */
    @Test
    public void test() {
        int actual = solution.removeStones(new int[][]{
                {0, 0}, {0, 1},
                {1, 0}, {1, 2},
                {2, 1}, {2, 2}
        });
        assertThat(actual).isEqualTo(5);
    }

    /**
     * [[3,2],[3,1],[4,4],[1,1],[0,2],[4,0]]
     *
     *
     * 0 0 1 0 0
     * 0 1 0 0 0
     * 0 0 0 0 0
     * 0 1 1 0 0
     * 1 0 0 0 1
     *
     *
     */
    @Test
    public void test1() {
        int actual = solution.removeStones(new int[][]{{3, 2}, {3, 1}, {4, 4}, {1, 1}, {0, 2}, {4, 0}});
        assertThat(actual).isEqualTo(4);
    }


    /**
     * [[3,2],[3,1],[4,4],[1,1],[0,2],[4,0],[2,3],[5,3]]
     *
     *
     * 0 0 1 0 0
     * 0 1 0 0 0
     * 0 0 0 1 0
     * 0 1 1 0 0
     * 1 0 0 0 1
     * 0 0 0 1 0
     *
     *
     */

    @Test
    public void test5() {
        int actual = solution.removeStones(new int[][]{{3, 2}, {3, 1}, {4, 4}, {1, 1}, {0, 2}, {4, 0}, {2, 3}, {5, 3}});
        assertThat(actual).isEqualTo(5);
    }


    /**
     * [[0,1],[1,2],[0,0],[6,7],[7,1],[6,6],[2,1],[3,7],[0,2]]
     *
     *      1 1 1 0 0 0 0 0
     *      0 0 1 0 0 0 0 0
     *      0 1 0 0 0 0 0 0
     *      0 0 0 0 0 0 0 1
     *      0 0 0 0 0 0 0 0
     *      0 0 0 0 0 0 0 0
     *      0 0 0 0 0 0 1 1
     *      0 1 0 0 0 0 0 0
     */
    @Test
    public void test7() {
        int actual = solution.removeStones(new int[][]{{0,1}, {1,2}, {0,0}, {6,7}, {7,1}, {6,6}, {2,1}, {3,7}, {0,2}});
        assertThat(actual).isEqualTo(7);
    }

    /**
     * [[0,0],[0,1],[1,0],[1,1],[2,1],[2,2],[3,2],[3,3],[3,4],[4,3],[4,4]]
     * [[0,0],[0,1],[1,0],[1,1],[2,1],[2,2],[3,2],[3,3],[3,4],[4,3],[4,4]]
     *
     *      1 1 0 0 0
     *      1 1 0 0 0
     *      0 1 1 0 0
     *      0 0 1 1 1
     *      0 0 0 1 1
     */
    @Test
    public void test10() {
        int actual = new Solution().removeStones(
                new int[][]{
                        {0,0}, {0,1}, {1,0}, {1,1}, {2,1}, {2,2},
                        {3,2}, {3,3}, {3,4}, {4,3}, {4,4}
                });
        assertThat(actual).isEqualTo(10);
    }

}