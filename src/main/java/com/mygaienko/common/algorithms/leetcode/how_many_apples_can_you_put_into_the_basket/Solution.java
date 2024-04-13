package com.mygaienko.common.algorithms.leetcode.how_many_apples_can_you_put_into_the_basket;

import java.util.Arrays;

class Solution {
    public int maxNumberOfApples(int[] weights) {
        Arrays.sort(weights);

        var count = 0;
        var totalWeight = 0;

        for (var weight : weights) {
            if (totalWeight + weight <= 5000) {
                totalWeight += weight;
                count++;
            } else {
                break;
            }
        }

        return count;
    }
}
