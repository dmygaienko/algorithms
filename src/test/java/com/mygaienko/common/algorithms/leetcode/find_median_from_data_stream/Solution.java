package com.mygaienko.common.algorithms.leetcode.find_median_from_data_stream;

import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder {

    private final PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private final PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    public void addNum(int num) {
        if (!minHeap.isEmpty() && minHeap.peek() <= num) {
            minHeap.offer(num);
        } else if (!maxHeap.isEmpty() && maxHeap.peek() >= num) {
            maxHeap.offer(num);
        } else if (minHeap.isEmpty()) {
            minHeap.offer(num);
        } else {
            maxHeap.offer(num);
        }

        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (maxHeap.size() + 1 < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (minHeap.size() == maxHeap.size() && !minHeap.isEmpty()) {
            return (minHeap.peek() + maxHeap.peek())/2d;
        } else if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        } else if (minHeap.size() < maxHeap.size()) {
            return maxHeap.peek();
        } else {
            return Double.NEGATIVE_INFINITY;
        }
    }
}
