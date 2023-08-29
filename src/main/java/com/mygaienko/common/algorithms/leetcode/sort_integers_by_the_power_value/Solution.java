package com.mygaienko.common.algorithms.leetcode.sort_integers_by_the_power_value;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Function;

class Solution {

    public int getKth(int lo, int hi, int k) {
        Map<Integer, Integer> memo = new HashMap<>();
        Comparator<Integer> comparing = Comparator
                .<Integer, Integer>comparing(x -> getPower(x, memo))
                .thenComparing(Function.identity())
                .reversed();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(comparing);

        for (int i = lo; i <= hi; i++) {

            if (minHeap.size() < k) {
                minHeap.offer(i);
            } else if (getPower(minHeap.peek(), memo) > getPower(i, memo)) {
                minHeap.poll();
                minHeap.offer(i);
            }

        }

        return minHeap.isEmpty() ? 0 : minHeap.peek();
    }

    /**
     * if x is even then x = x / 2
     * if x is odd then x = 3 * x + 1
     */

    private int getPower(Integer x, Map<Integer, Integer> memo) {
        Integer cached = memo.get(x);
        if (cached != null) return cached;
        int power = getPower(x, 0);
        memo.put(x, power);
        return power;
    }

    private int getPower(Integer x, Integer step) {
        if (x == 1) return step;

        return x % 2 == 0 ? getPower(x / 2, step + 1) : getPower(3 * x + 1, step + 1);
    }

}