package com.mygaienko.common.algorithms.leetcode.minimum_height_trees;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.mygaienko.common.util.FileUtils;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test0_real() {
        List<Integer> minHeightTrees = solution.findMinHeightTrees(4, new int[][]{
                {1, 0},
                {1, 2},
                {1, 3}
        });

        System.out.println(minHeightTrees);
        assertEquals(new HashSet<>(minHeightTrees), Set.of(1));
    }

    @Test
    public void test0() {
        List<Integer> minHeightTrees = solution.findMinHeightTrees(4, new int[][]{
                {0, 1},
                {1, 2},
                {1, 3}
        });

        System.out.println(minHeightTrees);
        assertEquals(new HashSet<>(minHeightTrees), Set.of(1));
    }

    @Test
    public void test1() {
        List<Integer> minHeightTrees = solution.findMinHeightTrees(6, new int[][]{
                {3, 0},
                {3, 1},
                {3, 2},
                {3, 4},
                {4, 5}
        });

        System.out.println(minHeightTrees);
        assertEquals(new HashSet<>(minHeightTrees), Set.of(3,4));
    }

    @Test
    public void test20000() throws JsonProcessingException {
        String text = FileUtils.readString(getClass(), "20000.txt");
        int[][] edges = new JsonMapper().readValue(text, int[][].class);
        long start = System.nanoTime();
        System.out.println(start/1000000);
        List<Integer> minHeightTrees = solution.findMinHeightTrees(20000, edges);
        long end = System.nanoTime();
        System.out.println(end/1000000);
        System.out.println((end - start)/1000000);
        System.out.println(minHeightTrees);
        assertEquals(new HashSet<>(minHeightTrees), Set.of(3425));
    }
}