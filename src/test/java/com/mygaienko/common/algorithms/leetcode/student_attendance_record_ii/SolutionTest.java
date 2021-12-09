package com.mygaienko.common.algorithms.leetcode.student_attendance_record_ii;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 *  X           3
 *
 *  XX          8
 *
 *  XXX         19
 *
 *  * 3 -
 *
 *  XXXX        43
 *  XXXXX       94
 *  XXXXXX      200
 *  XXXXXXX     418
 *  XXXXXXXX    861
 *  XXXXXXXXX   1753
 */
public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test() {
        int actual = solution.checkRecord(2);
        assertEquals(8, actual);
    }

    @Test
    public void test2() {
        int actual = solution.checkRecord(3);
        assertEquals(19, actual);
    }

    @Test
    public void test3() {
        int actual = solution.checkRecord(4);
        assertEquals(43, actual);
    }

    @Test
    public void test4() {
        int actual = solution.checkRecord(5);
        assertEquals(94, actual);
    }

    @Test
    public void test5() {
        int actual = solution.checkRecord(10101);
        assertEquals(183236316, actual);
    }
}