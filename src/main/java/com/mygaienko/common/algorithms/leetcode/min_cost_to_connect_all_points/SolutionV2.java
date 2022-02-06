package com.mygaienko.common.algorithms.leetcode.min_cost_to_connect_all_points;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Prim's Algorithm
 */
class SolutionV2 {

    public int minCostConnectPoints(int[][] points) {
        int N = points.length;

        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        for (int i = 0; i < N; i++) {
            int[] next = points[i];
            int dist = calcDistance(points[0], next);
            queue.offer(new int[] {0, i, dist});
        }

        boolean[] seen = new boolean[N];
        seen[0] = true;
        int minCost = 0;
        int count = N-1;

        while (!queue.isEmpty() && count > 0) {
            int[] next = queue.poll();

            int curr = next[1];
            if (!seen[curr]) {
                seen[curr] = true;
                minCost += next[2];
                count--;

                for (int i = 0; i < N; i++) {
                    if (!seen[i]) {
                        int dist = calcDistance(points[curr], points[i]);
                        queue.offer(new int[]{curr, i, dist});
                    }
                }
            }
        }

        return minCost;
    }

    private int calcDistance(int[] a, int[] b) {
        return Math.abs(b[0] - a[0]) + Math.abs(b[1]-a[1]);
    }

}
