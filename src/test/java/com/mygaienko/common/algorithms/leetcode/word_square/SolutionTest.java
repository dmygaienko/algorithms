package com.mygaienko.common.algorithms.leetcode.word_square;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

//    @Test
//    public void test_getSquare0() {
//        List<String> square = solution.getSquare(new String[]{"ball", "area", "lead", "lady"}, List.of(0, 1, 2, 3));
//        assertThat(square).containsExactly("ball", "area", "lead", "lady");
//    }

    @Test
    public void test_wordSquares0() {
        List<List<String>> square = solution.wordSquares(new String[]{"area","lead","wall","lady","ball"});
        assertThat(square).containsExactlyInAnyOrder(
                List.of("ball", "area", "lead", "lady"),
                List.of("wall","area","lead","lady")
        );
    }

    @Test
    public void test_wordSquares1() {
        List<List<String>> square = solution.wordSquares(new String[]{"abat","baba","atan","atal"});
        assertThat(square).containsExactlyInAnyOrder(
                List.of("baba","abat","baba","atal"),
                List.of("baba","abat","baba","atan")
        );
    }

}