package com.mygaienko.common.algorithms.leetcode.the_number_of_weak_characters_in_the_game;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class SolutionTest {

    @Test
    public void test2() {
        Solution solution = new Solution();
        int actual = solution.numberOfWeakCharacters(new int[][]{
                {1, 5}, {10, 4}, {4, 3}
        });
        assertThat(actual).isEqualTo(1);
    }

    /**
     *  {10,7} {7,10} {7,9} {6,9}, {10,4} {7,5}
     *
     *  {10,7} {10,4} {7,10} {7,9} {7,5} {6,9},
     */
    @Test
    public void test15() {
        Solution solution = new Solution();
        int actual = solution.numberOfWeakCharacters(new int[][]{
                {7,9},{10,7},{6,9},{10,4},{7,5},{7,10}
        });
        assertThat(actual).isEqualTo(2);
    }
}