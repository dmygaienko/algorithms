package com.mygaienko.common.algorithms.leetcode.moving_average_from_data_stream;

class MovingAverageV2 {

    int[] arr;

    int length;

    int maxSize;

    int index = 0;

    int sum;

    public MovingAverageV2(int size) {
        arr = new int[size];
        this.maxSize = size;
    }

    public double next(int val) {
        sum -= arr[index];
        arr[index] = val;
        sum += val;

        if (index + 1 >= arr.length) {
            index = 0;
        } else {
            index++;
        }

        length = Math.min(length + 1, maxSize);

        return ((double) sum) / length;
    }
}