package com.mygaienko.common.algorithms.leetcode.erect_the_fence;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * Graham's scan algorithm
 */
class Solution {

    public int[][] outerTrees(int[][] points) {
        if (points.length <= 1)
            return points;
        var p0 = bottomLeft(points);
        //sort points based on polar angle with respect to the first point
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] p, int[] q) {
                double diff = orientation(p0, p, q) - orientation(p0, q, p);
                if (diff == 0)
                    return distance(p0, p) - distance(p0, q);
                else
                    return diff > 0 ? 1 : -1;
            }
        });

        int j = points.length - 1;
        while (j >= 0 && orientation(p0, points[points.length - 1], points[j]) == 0) {
            j--;
        }
        for (int l = j + 1, h = points.length - 1; l < h; l++, h--) {
            var temp = points[l];
            points[l] = points[h];
            points[h] = temp;
        }

        //create an empty stack and push first three point
        var stack = new Stack<int[]>();
        stack.push(points[0]);
        stack.push(points[1]);

        //process remaining n - 3 points
        for (int i = 2; i < points.length; i++) {
            // Keep removing top while the angle formed by
            // points next-to-top, top, and points[i] makes
            // a non-left turn
            while (orientation(nextToTop(stack), stack.peek(), points[i]) > 0) {
                stack.pop();
            }
            stack.push(points[i]);
        }

        return stack.toArray(new int[stack.size()][]);
    }

    private int[] nextToTop(Stack<int[]> stack) {
        var top = stack.pop();
        var next = stack.peek();
        stack.push(top);
        return next;
    }

    public int orientation(int[] p, int[] q, int[] r) {
        return (q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1]);
    }

    public int distance(int[] p, int[] q) {
        return (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
    }

    private void swap(int[][] trees, int a, int b) {
        var temp = trees[a];
        trees[a] = trees[b];
        trees[b] = temp;
    }

    private static int[] bottomLeft(int[][] points) {
        int[] bottomLeft = points[0];
        for (int[] p : points)
            if (p[1] < bottomLeft[1])
                bottomLeft = p;
        return bottomLeft;
    }

}