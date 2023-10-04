package com.mygaienko.common.algorithms.leetcode.task_scheduler;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

class Solution {

    public int leastInterval(char[] tasks, int n) {
        var taskCounts = new int[26];
        for (char task : tasks) {
            taskCounts[task - 'A'] += 1;
        }

        var queue = new PriorityQueue<Integer>((a, b) -> taskCounts[b] - taskCounts[a]);
        for (int i = 0; i < taskCounts.length; i++) {
            var count = taskCounts[i];
            if (count > 0) {
                queue.offer(i);
            }
        }

        var time = 0;
        var coldQueue = new ArrayDeque<int[]>();
        while (!queue.isEmpty() || !coldQueue.isEmpty()) {
            time++;

            if (!queue.isEmpty()) {
                var i = queue.poll();
                taskCounts[i] -= 1;
                if (taskCounts[i] > 0) {
                    coldQueue.offer(new int[]{i, time + n});
                }
            }

            if (!coldQueue.isEmpty() && time == coldQueue.peek()[1]) {
                while (!coldQueue.isEmpty()) {
                    var nextCold = coldQueue.poll();
                    var coldI = nextCold[0];
                    queue.offer(coldI);
                }
            }

        }

        return time;
    }

}