package com.mygaienko.common.algorithms.leetcode.task_scheduler;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test1() {
        int actual = solution.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2);
        assertThat(actual).isEqualTo(8);
    }

    @Test
    public void test2() {
        int actual = solution.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 0);
        assertThat(actual).isEqualTo(6);
    }

    /**
     * 'A' 'B' IDLE 'A' 'C'IDLE 'A' 'D' IDLE'A' 'E',IDLE 'A''F'IDLE 'A''G'
     */
    @Test
    public void test3() {
        int actual = solution.leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'}, 2);
        assertThat(actual).isEqualTo(16);
    }
}