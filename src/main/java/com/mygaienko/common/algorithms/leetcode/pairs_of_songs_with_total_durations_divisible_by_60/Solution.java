 package com.mygaienko.common.algorithms.leetcode.pairs_of_songs_with_total_durations_divisible_by_60;

import java.util.HashMap;

class Solution {

    // iterate over array
    // for each element count left after division
    // if left equals zero then find all pairs which also equls zero and multiple
    // if left equals non-zero then find all pairs 60 - left and multiple
    // put element to map/array to optimize search for the next elements
    public int numPairsDivisibleBy60(int[] time) {
        int pairs = 0;

        var leftCounts = new int[60];
        for (int i = 0; i < time.length; i++) {
            var next = time[i];
            var left = next % 60;
            var key = left == 0 ? 0 : 60 - left;
            pairs += leftCounts[key];
            leftCounts[left]++;
        }

        return pairs;
    }
}
