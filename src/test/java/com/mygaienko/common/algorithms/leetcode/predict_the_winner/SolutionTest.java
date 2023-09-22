package com.mygaienko.common.algorithms.leetcode.predict_the_winner;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        assertFalse(solution.predictTheWinner(new int[]{1, 5, 2}));
    }

    @Test
    public void test10() {
        assertTrue(solution.predictTheWinner(new int[]{2,4,55,1}));
    }

    @Test
    public void test62() {
        assertFalse(solution.predictTheWinner(new int[]{0,0,7,6,5,6,1}));
    }

    /**
     * 3606449 6   7 1
     *
     *
     * 7 6  1 3606449
     */
    @Test
    public void test59() {
        assertFalse(solution.predictTheWinner(new int[]{3606449,6,5,9,452429,7,9580316,9857582,8514433,9,6,6614512,753594,5474165,4,2697293,8,7,1}));
    }

    /**
     * v1
     *
     * 1000   400
     * 999    999
     * 1000   555
     *
     * v2
     *
     * 1000   999
     * 999    1000
     * 555    400
     *
     */
    @Test
    public void test55() {
        assertTrue(solution.predictTheWinner(new int[]{1000,999,999,1000,555,400}));
    }

    @Test
    public void test52() {
        assertTrue(solution.predictTheWinner(new int[]{1,567,1,1}));
    }

    @Test
    public void test61() {
        assertTrue(solution.predictTheWinner(new int[]{1,5,2,4,6}));
    }

}