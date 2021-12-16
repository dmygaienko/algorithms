package com.mygaienko.common.algorithms.leetcode.employee_free_time;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * 759. Employee Free Time https://leetcode.com/problems/employee-free-time/
 */
class Solution {

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        int emlpoyees = schedule.size();

        PriorityQueue<Integer> minutes = new PriorityQueue<>(Comparator.comparingInt(i -> i));

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (List<Interval> intervals : schedule) {
            int start = intervals.get(0).start;
            int end = intervals.get(intervals.size()-1).end;

            min = Math.min(min, start);
            max = Math.max(max, end);
        }

        for (List<Interval> intervals : schedule) {
            for (int t = min+1, i = 0; t <= max && i < intervals.size(); t++) {
                Interval currentInterval = intervals.get(i);

                if (t < currentInterval.start) {
                    minutes.add(t);
                } else if (t >= currentInterval.end) {

                    if (intervals.size() > i + 1) {
                        if (intervals.get(i+1).start > t) {
                            minutes.add(t);
                        }
                        i++;
                    } else {
                        minutes.add(t);
                    }
                }
            }
        }

        int currentTime = -1;
        int counter = 0;

        List<Integer> commonMinutes = new ArrayList<>();

        while (!minutes.isEmpty()) {
            Integer next = minutes.poll();
            if (currentTime == -1) {
                currentTime = next;
                counter++;
                continue;
            }

            if (next == currentTime) {
                counter++;
            } else {
                if (counter == emlpoyees) {
                    commonMinutes.add(currentTime);
                }

                currentTime = next;
                counter = 1;
            }
        }

        return toCommonIntervals(commonMinutes);
    }

    private List<Interval> toCommonIntervals(List<Integer> commonMinutes) {
        List<Interval> intervals = new ArrayList<>();

        Interval currentInterval = new Interval(-1, -1);
        for (int i = 0; i < commonMinutes.size(); i++) {
            int current = commonMinutes.get(i);

            if (i + 1 == commonMinutes.size()) {
                intervals.add(new Interval(current, current + 1));
                break;
            }

            int next = commonMinutes.get(i + 1);

            if (currentInterval.start == -1) {
                currentInterval.start = current;
            }

            if (current + 1 != next) {
                currentInterval.end = current + 1;
                intervals.add(currentInterval);
                currentInterval = new Interval(next, -1);
            } else if (i + 2 == commonMinutes.size()) {
                currentInterval.end = next + 1;
                intervals.add(currentInterval);
                break;
            }
        }

        return intervals;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interval interval = (Interval) o;
        return start == interval.start &&
                end == interval.end;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
};
