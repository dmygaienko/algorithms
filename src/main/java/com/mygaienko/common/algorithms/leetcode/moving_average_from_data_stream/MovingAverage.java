package com.mygaienko.common.algorithms.leetcode.moving_average_from_data_stream;

import java.util.LinkedList;

class MovingAverage {

    LinkedList<Integer> list;

    int size;

    int sum;

    public MovingAverage(int size) {
        list = new LinkedList();
        this.size = size;
    }

    public double next(int val) {
        if (list.size() == size) {
            sum -= list.removeFirst();
        }
        list.addLast(val);
        sum += val;
        return ((double) sum) / list.size();
    }
}