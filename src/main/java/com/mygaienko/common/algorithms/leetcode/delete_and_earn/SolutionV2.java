package com.mygaienko.common.algorithms.leetcode.delete_and_earn;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class SolutionV2 {
    public int deleteAndEarn(int[] nums) {
        var numSum = new HashMap<Integer, Integer>();
        for (var num : nums) {
            numSum.compute(num, (k, v) -> v == null ? num : v + num);
        }

        var comparator = Comparator.<Integer>comparingInt(v ->
                {
                    if (!numSum.containsKey(v + 1)) {
                        return numSum.getOrDefault(v - 1, 0) - numSum.getOrDefault(v, 0);
                    } else if (numSum.containsKey(v-1) && numSum.containsKey(v-2) && numSum.get(v-1) < (numSum.get(v-2) + numSum.getOrDefault(v, 0))) {
                        return numSum.getOrDefault(v-2, 0) - numSum.getOrDefault(v, 0);
                    } else if (numSum.containsKey(v+1) && numSum.containsKey(v+2) && numSum.get(v+1) < (numSum.get(v) + numSum.get(v + 2))) {
                        return numSum.getOrDefault(v+2, 0) - numSum.getOrDefault(v, 0);
                    } else {
                        return (numSum.getOrDefault(v-1, 0) + numSum.getOrDefault(v+1, 0)) - numSum.getOrDefault(v, 0);
                    }
                }
        );

        var queue = new PriorityQueue<>(comparator);
        for (var key : numSum.keySet()) {
            queue.offer(key);
        }

        var earn = 0;
        var prevNext = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            var next = queue.poll();
            if (prevNext != next) {
                prevNext = next;
                queue.offer(next);
            }
            var sum = numSum.getOrDefault(next, 0);
            if (sum <= 0) continue;

            earn += sum;
            remove(queue, numSum, next);
            remove(queue, numSum, next - 1);
            remove(queue, numSum, next + 1);

            renew(queue, next - 2);
            renew(queue, next + 2);
        }

        return earn;
    }

    private void renew(PriorityQueue<Integer> queue, int key) {
        var removed = queue.remove(key);
        if (removed) {
            queue.offer(key);
        }
    }

    private void remove(PriorityQueue<Integer> queue, HashMap<Integer, Integer> numSum, int key) {
        queue.remove(key);
        numSum.remove(key);
    }
}
