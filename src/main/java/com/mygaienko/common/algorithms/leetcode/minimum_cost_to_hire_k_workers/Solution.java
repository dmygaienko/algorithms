package com.mygaienko.common.algorithms.leetcode.minimum_cost_to_hire_k_workers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        if (k == 1) return Arrays.stream(wage).mapToDouble(i -> (double) i).min().getAsDouble();

        double multiplier = calculateMultiplier(quality, wage, k);

        PriorityQueue<Double> finalWages = new PriorityQueue<>(k, Comparator.reverseOrder());
        for (int i = 0; i < quality.length; i++) {
            int nextQ = quality[i];
            double finalWage = nextQ * multiplier;
            if (finalWage < wage[i]) continue;

            if (finalWages.isEmpty() || finalWages.size() < k) {
                finalWages.add(finalWage);
            } else {
                Double top = finalWages.peek();
                if (top > finalWage) {
                    finalWages.poll();
                    finalWages.offer(finalWage);
                }
            }
        }

        return finalWages.stream().reduce(Double::sum).orElse(0d);
    }

    private double calculateMultiplier(int[] quality, int[] wage, int k) {
        double averageWagePerQuality = averageWagePerQuality(quality, wage);

        PriorityQueue<IndexMultiplier> maxHeap = new PriorityQueue<>(k,
                Comparator.comparingDouble(IndexMultiplier::getMultiplier).reversed());

        for (int i = 0; i < quality.length; i++) {
            int currentWage = wage[i];
            int currentQuality = quality[i];

            double wagePerQuality = ((double) currentWage)/currentQuality;
            double v = wagePerQuality / averageWagePerQuality;
            if (v < 0.6 || v > 1.7) {
                continue;
            }

            IndexMultiplier indexMultiplier = new IndexMultiplier(i, wagePerQuality);
            if (maxHeap.isEmpty() || maxHeap.size() < k) {
                maxHeap.add(indexMultiplier);
            } else {
                double top = maxHeap.peek().getMultiplier();
                if (top > wagePerQuality) {
                    maxHeap.poll();
                    maxHeap.offer(indexMultiplier);
                }
            }
        }

        return maxHeap.isEmpty() ? Double.NEGATIVE_INFINITY : maxHeap.peek().multiplier;
    }

    private double averageWagePerQuality(int[] quality, int[] wage) {
        int totalWage  = 0;
        int totalQuality = 0;
        for (int i = 0; i < quality.length; i++) {
            totalWage += wage[i];
            totalQuality += quality[i];
        }
        return totalQuality == 0 ? 0.d : (double) totalWage/totalQuality;
    }

    static class IndexMultiplier {
        final int index;
        final double multiplier;

        IndexMultiplier(int index, double multiplier) {
            this.index = index;
            this.multiplier = multiplier;
        }

        public int getIndex() {
            return index;
        }

        public double getMultiplier() {
            return multiplier;
        }

        @Override
        public String toString() {
            return "IndexMultiplier{" +
                    "index=" + index +
                    ", multiplier=" + multiplier +
                    '}';
        }
    }

}
