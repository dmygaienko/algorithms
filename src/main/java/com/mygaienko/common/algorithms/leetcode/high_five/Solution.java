package com.mygaienko.common.algorithms.leetcode.high_five;

import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {

    public int[][] highFive(int[][] items) {
        var studentScores = new PriorityQueue[1000];

        for (var item : items) {
            var id = item[0];
            var score = item[1];

            if (studentScores[id] == null) {
                studentScores[id] = new PriorityQueue<Integer>();
            }
            studentScores[id].offer(score);

            if (studentScores[id].size() > 5) {
                studentScores[id].poll();
            }
        }

        var topAverage = new ArrayList<int[]>();
        for (int i = 0; i < studentScores.length; i++) {
            if (studentScores[i] == null) continue;

            var sum = 0;
            for (var val : studentScores[i]) {
                sum += (Integer) val;
            }
            var avg = sum / 5;
            topAverage.add(new int[]{i, avg});
        }

        return topAverage.toArray(new int[topAverage.size()][]);
    }


}