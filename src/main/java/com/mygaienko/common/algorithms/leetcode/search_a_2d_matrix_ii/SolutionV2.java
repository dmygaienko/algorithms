package com.mygaienko.common.algorithms.leetcode.search_a_2d_matrix_ii;

import java.util.PriorityQueue;

class SolutionV2 {

    int[] RIGHT = new int[] {0, 1};
    int[] DOWN = new int[] {1, 0};
    int[][] NEIGHBOURS = new int[][] {RIGHT, DOWN};

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix[0][0] == target) return true;

        int LENGTH = matrix[0].length;
        int DEPTH = matrix.length;

        PriorityQueue<int[]> queue = new PriorityQueue<>(DEPTH * LENGTH, (o1, o2) -> {
            int value1 = matrix[o1[0]][o1[1]];
            int value2 = matrix[o2[0]][o2[1]];
            return value2 - value1;
        });

        queue.offer(new int[]{0, 0});

        while(!queue.isEmpty()) {
            int[] next = queue.poll();

            for (int[] neigh : NEIGHBOURS) {
                int[] nextNeigh = new int[] {next[0] + neigh[0], next[1] + neigh[1]};
                if (nextNeigh[0] < DEPTH && nextNeigh[1] < LENGTH) {
                    int value = matrix[nextNeigh[0]][nextNeigh[1]];

                    if (value == target) {
                        return true;
                    } else if (value < target) {
                        queue.offer(nextNeigh);
                    }
                }
            }
        }

        return false;
    }

}