package com.mygaienko.common.algorithms.leetcode.optimal_partition_of_string;

import java.util.Arrays;

public class Solution {

    public int partitionString(String s) {
        var lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);
        var count = 1;
        var substringStart = 0;

        for (int i = 0; i < s.length(); i++) {
            var ch = s.charAt(i);

            if (lastSeen[ch - 'a'] >= substringStart) {
                substringStart = i;
                count++;
            }

            lastSeen[ch - 'a'] = i;
        }

        return count;
    }

}
