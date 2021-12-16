package com.mygaienko.common.algorithms.leetcode.employee_free_time;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test1() {
        List<Interval> actual = solution.employeeFreeTime(List.of(
                List.of(new Interval(1, 2), new Interval(5, 6)),
                List.of(new Interval(1, 3)),
                List.of(new Interval(4, 10))
        ));

        List<Interval> expected = List.of(new Interval(3, 4));
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        List<Interval> actual = solution.employeeFreeTime(List.of(
                List.of(new Interval(1, 3), new Interval(6, 7)),
                List.of(new Interval(2, 4)),
                List.of(new Interval(2, 5), new Interval(9, 12))
        ));

        List<Interval> expected = List.of(new Interval(5, 6), new Interval(7, 9));
        assertEquals(expected, actual);
    }

/*            [[[6,17],[22,26],[35,54],[56,67],[78,84]],
            [[8,17],[23,34],[47,56],[60,69],[70,71]],
            [[8,23],[34,38],[40,52],[67,68],[78,94]],
            [[13,17],[19,32],[40,42],[58,63],[72,78]],
            [[0,1],[7,13],[23,44],[48,62],[86,100]]]*/
    @Test
    public void test3() {
        List<Interval> actual = solution.employeeFreeTime(List.of(
                List.of(new Interval(6, 17), new Interval(22, 26), new Interval(35, 54), new Interval(56, 67), new Interval(78, 84)),
                List.of(new Interval(8, 17), new Interval(23, 34), new Interval(47, 56), new Interval(60, 69), new Interval(70, 71)),
                List.of(new Interval(8, 23), new Interval(34, 38), new Interval(40, 52), new Interval(67, 68), new Interval(78, 94)),
                List.of(new Interval(13, 17), new Interval(19, 32), new Interval(40, 42), new Interval(58, 63), new Interval(72, 78)),
                List.of(new Interval(0, 1), new Interval(7, 13), new Interval(23, 44), new Interval(48, 62), new Interval(86, 100))
        ));

        List<Interval> expected = List.of(new Interval(5, 6), new Interval(7, 9));
        assertEquals(expected, actual);
    }
}