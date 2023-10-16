package com.mygaienko.common.algorithms.leetcode.longest_arithmetic_subsequence_of_given_difference;

import java.util.HashMap;
import java.util.TreeSet;

class SolutionV2 {

    int maxLength = 1;
    // iterate over array (N)
    // for each index find next element with required difference (N) and compare max

    // iterate over array N
    // put to map value -> to tree (1)
    // iterate over map key to find next occurence with difference N * M
    public int longestSubsequence(int[] arr, int difference) {
        var occurrences = new HashMap<Integer, TreeSet<Integer>>();
        for (int i = 0; i < arr.length; i++) {
            var val = arr[i];
            occurrences.computeIfAbsent(val, v -> new TreeSet<>()).add(i);
        }

        for (var entry : occurrences.entrySet()) {
            int currentLength = 1;

            for (Integer valueIndex : entry.getValue()) {
                findOccurrences(occurrences, difference, entry.getKey(), valueIndex, currentLength);
            }
        }

        return maxLength;
    }

    private void findOccurrences(HashMap<Integer, TreeSet<Integer>> occurrences, int difference,
                                 Integer prevValue, Integer prevValueIndex, int currentLength) {
        maxLength = Math.max(maxLength, currentLength);

        var nextValue = prevValue + difference;
        var nextValueIndexes = occurrences.get(nextValue);

        Integer tailValueIndex = nextValueIndexes != null ? nextValueIndexes.higher(prevValueIndex) : null;
        if (tailValueIndex == null) return;

        findOccurrences(occurrences, difference, nextValue, tailValueIndex, currentLength + 1);
    }
}
