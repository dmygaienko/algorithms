package com.mygaienko.common.algorithms.leetcode.maximum_number_of_eaten_apples;

import java.util.PriorityQueue;

public class Solution {

    public int eatenApples(int[] apples, int[] days) {
        var queue = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        var eaten = 0;

        for (int i = 0; i < 40001; i++) {
            if (i < apples.length && apples[i] > 0) {
                queue.offer(new int[]{i - 1 + days[i], apples[i]});
            }

            while (!queue.isEmpty()) {
                if (queue.peek()[0] < i) {
                    queue.poll();
                } else {
                    break;
                }
            }
            if (!queue.isEmpty()) {
                var curr = queue.poll();
                eaten++;
                curr[1]--;
                if (curr[1] > 0) {
                    queue.offer(curr);
                }
            }
        }

        return eaten;
    }
}
