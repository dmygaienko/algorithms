package com.mygaienko.common.algorithms.leetcode.the_most_similar_path_in_a_graph;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        var actual = solution.mostSimilar(5,
                new int[][]{{0, 2}, {0, 3}, {1, 2}, {1, 3}, {1, 4}, {2, 4}},
                new String[]{"ATL", "PEK", "LAX", "DXB", "HND"},
                new String[]{"ATL", "DXB", "HND", "LAX"});

//        assertThat(actual).isEqualTo(new int[]{0, 2, 4, 2});
    }

    @Test
    public void test11() {
        var actual = solution.mostSimilar(3,
                new int[][]{{0, 1}, {1, 2}},
                new String[]{"BJS", "BJS", "BJS"},
                new String[]{
                        "BJS", "BJS", "BJS", "BJS", "BJS", "BJS", "BJS", "BJS", "BJS", "BJS", "BJS", "BJS", "BJS", "BJS", "BJS", "BJS",
                        "BJS", "BJS", "BJS", "BJS", "BJS", "BJS", "BJS", "BJS", "BJS", "BJS", "BJS", "BJS", "BJS", "BJS", "BJS", "BJS",
                        "BJS", "BJS", "BJS", "BJS", "BJS", "BJS", "BJS", "BJS", "BJS", "BJS", "BJS", "BJS", "BJS", "BJS"});

//        assertThat(actual).isEqualTo(new int[]{
//                0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0,
//                1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1});
    }

}