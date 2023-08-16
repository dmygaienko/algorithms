package com.mygaienko.common.algorithms.leetcode.my_calendar_i;

import java.util.Comparator;
import java.util.TreeSet;

class MyCalendar {

    TreeSet<int[]> tree;

    public MyCalendar() {
        tree = new TreeSet<>(Comparator.comparingInt(arr -> arr[0]));
    }

    public boolean book(int start, int end) {
        int[] event = new int[] {start, end};
        int[] previous = tree.floor(event);
        int[] next = tree.ceiling(event);
        if (previous != null && previous[1] > start) return false;
        if (next != null && next[0] < end) return false;

        return tree.add(event);
    }
}
