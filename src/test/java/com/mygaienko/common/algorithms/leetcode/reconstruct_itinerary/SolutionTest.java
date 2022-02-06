package com.mygaienko.common.algorithms.leetcode.reconstruct_itinerary;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution solution = new Solution();

    /**
     * [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
     * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
     */
    @Test
    public void test0() {
        List<String> actual = solution.findItinerary(List.of(
                List.of("JFK", "SFO"),
                List.of("JFK", "ATL"),
                List.of("SFO", "ATL"),
                List.of("ATL", "JFK"),
                List.of("ATL", "SFO")
        ));
        assertEquals(List.of("JFK","ATL","JFK","SFO","ATL","SFO"), actual);
    }

    @Test
    public void test1() {
        List<String> actual = solution.findItinerary(List.of(
                List.of("JFK", "KUL"),
                List.of("JFK", "NRT"),
                List.of("NRT", "JFK")
        ));
        assertEquals(List.of("JFK","NRT","JFK","KUL"), actual);
    }

    /**
     * [["JFK","AAA"],["AAA","JFK"],["JFK","BBB"],["JFK","CCC"],["CCC","JFK"]]
     */
    @Test
    public void test2() {
        List<String> actual = solution.findItinerary(List.of(
                List.of("JFK", "AAA"),
                List.of("AAA", "JFK"),
                List.of("JFK", "BBB"),
                List.of("JFK", "CCC"),
                List.of("CCC", "JFK")
        ));
        assertEquals(List.of("JFK","AAA","JFK","CCC","JFK","BBB"), actual);
    }
}