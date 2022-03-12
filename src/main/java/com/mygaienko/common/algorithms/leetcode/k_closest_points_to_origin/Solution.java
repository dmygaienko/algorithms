package com.mygaienko.common.algorithms.leetcode.k_closest_points_to_origin;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

    public int[][] kClosest(int[][] points, int k) {

        Queue<int[]> maxHeap = new PriorityQueue<>(k,
                Comparator.comparingDouble(this::calculateDistance).reversed());

        for (int[] point : points) {
            if (maxHeap.size() < k) {
                maxHeap.add(point);
            } else {
                int[] max = maxHeap.peek();

                double maxDistance = calculateDistance(max);
                double currentDistance = calculateDistance(point);

                if (maxDistance > currentDistance) {
                    maxHeap.poll();
                    maxHeap.offer(point);
                }
            }
        }

        return maxHeap.toArray(new int[][]{});
    }

    private double calculateDistance(int[] point) {
        return Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));
    }

}
