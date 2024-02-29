package com.mygaienko.common.algorithms.leetcode.erect_the_fence;

import java.util.HashSet;

/**
 * Jarvis Algorithm
 */
public class SolutionV2 {

    public int[][] outerTrees(int[][] points) {
        var hull = new HashSet<int[]>();
        if (points.length < 4) {
            for (var p : points) {
                hull.add(p);
            }
            return hull.toArray(new int[hull.size()][]);
        }

        var leftMost = 0;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] < points[leftMost][0]) {
                leftMost = i;
            }
        }

        int p = leftMost;
        do {
            int q = (p + 1) % points.length;
            for (int i = 0; i < points.length; i++) {
                if (hull.contains(points[i])) {
                    continue;
                }

                if (orientation(points[p], points[i], points[q]) < 0) {
                    q = i;
                }
            }

            for (int i = 0; i < points.length; i++) {
                if (i != p && i != q && orientation(points[p], points[i], points[q]) == 0
                        && inBetween(points[p], points[i], points[q])) {
                    hull.add(points[i]);
                }
            }
            hull.add(points[q]);
            p = q;
        }
        while (p != leftMost);

        return hull.toArray(new int[hull.size()][]);
    }

    private boolean inBetween(int[] p, int[] i, int[] r) {
        boolean x = (p[0] <= i[0] && i[0] <= r[0]) || (p[0] >= i[0] && i[0] >= r[0]);
        boolean y = (p[1] <= i[1] && i[1] <= r[1]) || (p[1] >= i[1] && i[1] >= r[1]);
        return x && y;
    }

    private int orientation(int[] p, int[] q, int[] r) {
        return (q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1]);
    }


}
