package com.mygaienko.common.algorithms.leetcode.meeting_rooms_ii;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    SolutionV3 solution = new SolutionV3();

    @Test
    public void test1() {
        int actual = solution.minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}});
        assertEquals(2, actual);
    }

    @Test
    public void test2() {
        int actual = solution.minMeetingRooms(new int[][]{{7, 10}, {2, 4}});
        assertEquals(1, actual);
    }

    @Test
    public void test3() {
        int actual = solution.minMeetingRooms(new int[][]{{5, 8}, {6, 8}});
        assertEquals(2, actual);
    }

    @Test
    public void test4() {
        int actual = solution.minMeetingRooms(new int[][]{{13, 15}, {1, 13}});
        assertEquals(1, actual);
    }

    @Test
    public void test5() {
        int actual = solution.minMeetingRooms(new int[][]{{1,5},{8,9},{8,9}});
        assertEquals(2, actual);
    }

}