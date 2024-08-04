package com.mygaienko.common.algorithms.leetcode.bag_of_tokens;

import java.util.Arrays;

class Solution {
    public int bagOfTokensScore(int[] tokens, int initPower) {
        Arrays.sort(tokens);

        var score = 0;
        var power = initPower;

        var left = 0;
        var right = tokens.length - 1;

        while (left <= right) {
            if (power >= tokens[left]) {
                score++;
                power -= tokens[left];
                left++;
            } else if (left < right && score > 0) {
                score--;
                power += tokens[right];
                right--;
            } else {
                return score;
            }
        }

        return score;
    }
}