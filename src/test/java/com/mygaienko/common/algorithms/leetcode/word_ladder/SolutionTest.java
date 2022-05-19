package com.mygaienko.common.algorithms.leetcode.word_ladder;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    /**
     * beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
     */
    @Test
    public void test_0() {
        int actual = solution.ladderLength("hit", "cog", List.of("hot","dot","dog","lot","log","cog"));
        assertThat(actual).isEqualTo(5);
    }

    @Test
    public void test_1() {
        int actual = solution.ladderLength("hit", "cog", List.of("hot","dot","dog","lot","log"));
        assertThat(actual).isEqualTo(0);
    }

    @Test
    public void test_2() {
        int actual = solution.ladderLength("hot", "cog", List.of("hot","dot","dog","lot","log"));
        assertThat(actual).isEqualTo(0);
    }

    @Test
    public void test_3() {
        int actual = solution.ladderLength("hot", "dog", List.of("hot","dog","dot"));
        assertThat(actual).isEqualTo(3);
    }

}