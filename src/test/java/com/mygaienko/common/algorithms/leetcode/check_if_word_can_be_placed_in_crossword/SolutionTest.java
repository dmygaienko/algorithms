package com.mygaienko.common.algorithms.leetcode.check_if_word_can_be_placed_in_crossword;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class SolutionTest {
    
    Solution solution = new Solution();

    @Test
    public void test() {
        boolean actual = solution.placeWordInCrossword(new char[][]{
                {'#', ' ', '#'},
                {' ', ' ', '#'},
                {'#', 'c', ' '}}, "abc");
        assertThat(actual).isTrue();
    }

    @Test
    public void test2() {
        boolean actual = solution.placeWordInCrossword(new char[][]{
                {' ','#','a'},
                {' ','#', 'c'},
                {' ','#','a'}}, "ac");
        assertThat(actual).isFalse();
    }

    /**
     *     [["#"," ","#"],["#"," ","#"],["#"," ","c"]]
     */
    @Test
    public void test145() {
        boolean actual = solution.placeWordInCrossword(new char[][]{
                {'#',' ','#'},
                {'#',' ','#'},
                {'#',' ','c'}}, "ca");
        assertThat(actual).isTrue();
    }

    /**
     *     [
     *     [" "],
     *     ["#"],
     *     ["o"],
     *     [" "],
     *     ["t"],
     *     ["m"],
     *     ["o"],
     *     [" "],
     *     ["#"],
     *     [" "]]
     */
    @Test
    public void test4() {
        boolean actual = solution.placeWordInCrossword(new char[][]{
                {' ',},
                {'#',},
                {'o',},
                {' ',},
                {'t',},
                {'m',},
                {'o',},
                {' ',},
                {'#',},
                {' ',}}, "octmor");
        assertThat(actual).isTrue();
    }

}