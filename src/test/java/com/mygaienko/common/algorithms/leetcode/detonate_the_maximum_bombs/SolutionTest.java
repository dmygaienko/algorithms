package com.mygaienko.common.algorithms.leetcode.detonate_the_maximum_bombs;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        int actual = solution.maximumDetonation(new int[][]{{2, 1, 3}, {6, 1, 4}});
        assertThat(actual).isEqualTo(2);
    }

    @Test
    public void test1() {
        int actual = solution.maximumDetonation(new int[][]{{1,1,5}, {10,10,5}});
        assertThat(actual).isEqualTo(1);
    }    
    
    @Test
    public void test2() {
        int actual = solution.maximumDetonation(new int[][] {{1,2,3},{2,3,1},{3,4,2},{4,5,3},{5,6,4}});
        assertThat(actual).isEqualTo(5);
    }

}