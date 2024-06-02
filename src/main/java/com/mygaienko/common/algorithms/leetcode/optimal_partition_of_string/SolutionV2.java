package com.mygaienko.common.algorithms.leetcode.optimal_partition_of_string;

import java.util.HashSet;

public class SolutionV2 {

    public int partitionString(String s) {
        var count = 1;

        var uniqueChars = new HashSet<Character>();
        for (var ch : s.toCharArray()) {
            if (!uniqueChars.add(ch)) {
                uniqueChars = new HashSet<Character>();
                uniqueChars.add(ch);
                count++;
            }
        }

        return count;
    }

}
