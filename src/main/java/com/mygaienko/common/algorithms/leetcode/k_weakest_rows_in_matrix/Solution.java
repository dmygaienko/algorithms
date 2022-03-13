package com.mygaienko.common.algorithms.leetcode.k_weakest_rows_in_matrix;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

    public int[] kWeakestRows(int[][] mat, int k) {
        Comparator<Row> rowComparator = Comparator
                 .comparingInt(Row::getPower)
                 .thenComparing(Row::getI)
                 .reversed();
        PriorityQueue<Row> maxHeap = new PriorityQueue<>(k, rowComparator);

        for (int i = 0; i < mat[0].length; i++) {
            int[] row = mat[i];

            if (maxHeap.size() < k) {
                maxHeap.offer(new Row(i, calculateRow(row)));
            } else {
                int maxRowPower = maxHeap.peek().power;
                int rowPower = calculateRow(row);

                if (maxRowPower > rowPower) {
                    maxHeap.poll();
                    maxHeap.offer(new Row(i, rowPower));
                }
            }
        }

        int[] result = new int[k];
        int i = maxHeap.size() - 1;
        while (!maxHeap.isEmpty()) {
            result[i] = maxHeap.poll().getI();
            i--;
        }

        return result;
    }

    private int calculateRow(int[] row) {
        int sum = 0;
        for (Integer soldier : row) {
            sum = sum + soldier;
        }
        return sum;
    }

    static class Row {
        final int i;
        final int power;

        public Row(int i, int power) {
            this.i = i;
            this.power = power;
        }

        public int getI() {
            return i;
        }

        public int getPower() {
            return power;
        }

        @Override
        public String toString() {
            return "Row{" +
                    "i=" + i +
                    ", power=" + power +
                    '}';
        }
    }

}
