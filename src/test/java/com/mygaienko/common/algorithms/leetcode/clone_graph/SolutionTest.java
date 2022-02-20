package com.mygaienko.common.algorithms.leetcode.clone_graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test0() {
        Node two = new Node(2);
        Node four = new Node(4);
        Node three = new Node(3, List.of(two, four));
        Node one = new Node(1, List.of(two, four));

        two.neighbors = new ArrayList<>(List.of(one, three));
        four.neighbors = new ArrayList<>(List.of(one, three));

        Node cloned = solution.cloneGraph(one);
        assertEquals(cloned, one);
    }
}