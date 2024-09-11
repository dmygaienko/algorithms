package com.mygaienko.common.algorithms.leetcode.find_the_winner_of_the_circular_game;

import java.util.ArrayDeque;

class Solution {

    public int findTheWinner(int n, int k) {

        var queue = new ArrayDeque<Integer>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        while (queue.size() > 1) {

            for (int i = 0; i < k - 1; i++) {
                var next = queue.poll();
                queue.offer(next);
            }

            queue.poll();
        }

        return queue.peek();
    }

}