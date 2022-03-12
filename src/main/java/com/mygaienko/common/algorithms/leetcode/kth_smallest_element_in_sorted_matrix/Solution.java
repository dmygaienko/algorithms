package com.mygaienko.common.algorithms.leetcode.kth_smallest_element_in_sorted_matrix;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * maxHeap
 */
class Solution {

    public int kthSmallest(int[][] matrix, int k) {
        int M = matrix.length;
        int N = matrix[0].length;

        int i = 0;
        while (i + 1 < M && matrix[i][N - 1] < matrix[i+1][0] && (i+1) * M < k) {
            i++;
        }

        int heapSize = k - i * M;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(heapSize, Comparator.reverseOrder());
        for (int j = i; j < M; j++) {
            for (int l = 0; l < N; l++) {
                int current = matrix[j][l];

                if (maxHeap.size() < heapSize) {
                    maxHeap.add(current);
                } else {
                    Integer peek = maxHeap.peek();
                    if (peek > current) {
                        maxHeap.poll();
                        maxHeap.add(current);
                    }

                    if (l==0 && peek < current) {
                        return maxHeap.peek();
                    }
                }
            }
        }

        return maxHeap.peek();
    }
}
