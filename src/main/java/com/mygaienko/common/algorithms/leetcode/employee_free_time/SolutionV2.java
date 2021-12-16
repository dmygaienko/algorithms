package com.mygaienko.common.algorithms.leetcode.employee_free_time;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class SolutionV2 {

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {

        PriorityQueue<Interval> queue = new PriorityQueue<>((a, b) -> a.start != b.start
                ? a.start - b.start
                : a.end - b.end);

        schedule.forEach(queue::addAll);

        List<Interval> commonFree = new ArrayList<>();

        Interval commonWork = queue.poll();
        if (commonWork == null) {
            return commonFree;
        }

        while (!queue.isEmpty()) {
            Interval next = queue.poll();
            if (commonWork.end >= next.start) {
                commonWork.end = Math.max(commonWork.end, next.end);
            } else {
                commonFree.add(new Interval(commonWork.end, next.start));
                commonWork = next;
            }
        }

        return commonFree;
    }

}
