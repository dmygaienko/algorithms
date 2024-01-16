package com.mygaienko.common.algorithms.leetcode.campus_bikes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    public int[] assignBikes(int[][] workers, int[][] bikes) {
        var workersToBikes = new ArrayList<List<int[]>>();
        var workersToBikesIndex = new int[workers.length];
        var queue = new PriorityQueue<>(Comparator
                .<int[]>comparingInt(arr -> arr[0])
                .thenComparing(arr -> arr[1])
                .thenComparing(arr -> arr[2]));
        for (int i = 0; i < workers.length; i++) {
            var worker = workers[i];
            var workerBikes = new ArrayList<int[]>();
            workersToBikes.add(workerBikes);
            for (int j = 0; j < bikes.length; j++) {
                var bike = bikes[j];
                var distance = getDistance(worker, bike);
                workerBikes.add(new int[]{distance, j});
            }
            workerBikes.sort(Comparator.comparingInt(arr -> arr[0]));
            var closestBike = workerBikes.get(0);
            queue.add(new int[]{closestBike[0], i, closestBike[1]});
        }

        var assignedWorkers = new int[workers.length];
        var assignedBikes = new int[bikes.length];
        Arrays.fill(assignedWorkers, -1);
        Arrays.fill(assignedBikes, -1);
        while (!queue.isEmpty()) {
            var next = queue.poll();
            var workerIndex = next[1];
            var bikeIndex = next[2];

            if (assignedWorkers[workerIndex] == -1 && assignedBikes[bikeIndex] == -1) {
                assignedWorkers[workerIndex] = bikeIndex;
                assignedBikes[bikeIndex] = workerIndex;
            } else {
                workersToBikesIndex[workerIndex]++;
                var closestBike = workersToBikes.get(workerIndex).get(workersToBikesIndex[workerIndex]);
                queue.add(new int[]{closestBike[0], workerIndex, closestBike[1]});
            }
        }
        return assignedWorkers;
    }

    int getDistance(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
}
