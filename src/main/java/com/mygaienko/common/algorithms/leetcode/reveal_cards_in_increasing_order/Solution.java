package com.mygaienko.common.algorithms.leetcode.reveal_cards_in_increasing_order;

import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {

    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);

        var result = new int[deck.length];

        var queue = new ArrayDeque<Integer>();

        for (int i = 0; i < deck.length; i++) {
            queue.offer(i);
        }

        for (int i = 0; i < deck.length; i++) {
            var nextCard = deck[i];

            var nextPosition = queue.poll();

            result[nextPosition] = nextCard;

            // put next card at the bottom
            if (!queue.isEmpty()) {
                queue.offer(queue.poll());
            }

        }

        return result;
    }
}