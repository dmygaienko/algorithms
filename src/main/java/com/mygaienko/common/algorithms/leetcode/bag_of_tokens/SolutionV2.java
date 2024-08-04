package com.mygaienko.common.algorithms.leetcode.bag_of_tokens;

import java.util.Arrays;
import java.util.LinkedList;

class SolutionV2 {
    public int bagOfTokensScore(int[] tokens, int initPower) {
        Arrays.sort(tokens);

        var queue = new LinkedList<Integer>();
        for (var token : tokens) {
            queue.offer(token);
        }

        var score = 0;
        var power = initPower;

        while (!queue.isEmpty()) {
            var less = queue.pollFirst();

            if (less <= power) {
                score++;
                power -= less;
            } else if (!queue.isEmpty() && score > 0) {
                var toSell = queue.pollLast();
                score--;
                power += toSell;

                score++;
                power -= less;
            }

        }

        return score;
    }
}