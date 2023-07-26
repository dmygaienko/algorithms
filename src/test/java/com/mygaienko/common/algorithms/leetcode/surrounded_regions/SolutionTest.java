package com.mygaienko.common.algorithms.leetcode.surrounded_regions;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class SolutionTest {

    char SURR = 'X';
    
    Solution solution = new Solution();

    @Test
    public void test() {
        char[][] actual = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        solution.solve(actual);
        assertThat(actual).isEqualTo(new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'}});
    }
}