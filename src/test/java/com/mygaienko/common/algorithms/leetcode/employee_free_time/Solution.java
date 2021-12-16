package com.mygaienko.common.algorithms.leetcode.employee_free_time;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 759. Employee Free Time https://leetcode.com/problems/employee-free-time/
 */
class Solution {

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {

        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;

        List<PriorityQueue<Interval>> priorityQueues = new ArrayList<>();
        for (List<Interval> personalSchedule : schedule) {
            PriorityQueue<Interval> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(i -> i.start));
            for (Interval interval : personalSchedule) {
                start = Math.min(start, interval.start);
                end = Math.max(end, interval.end);
                priorityQueue.add(interval);
            }
            priorityQueues.add(priorityQueue);
        }

        for (int time = start; time < end; time++) {

            for (PriorityQueue<Interval> priorityQueue : priorityQueues) {
                Interval poll = priorityQueue.poll();

//                if (time > poll.)
            }

        }

        return null;
    }
}

class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
