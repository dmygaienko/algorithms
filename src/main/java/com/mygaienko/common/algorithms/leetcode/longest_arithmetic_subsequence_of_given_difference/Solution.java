package com.mygaienko.common.algorithms.leetcode.longest_arithmetic_subsequence_of_given_difference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("Duplicates")
class Solution {

    int maxLength = 1;
    // iterate over array (N)
    // for each index find next element with required difference (N) and compare max

    // iterate over array N
    // put to map value -> to tree (1)
    // iterate over map key to find next occurence with difference N * M
    public int longestSubsequence(int[] arr, int difference) {
        var occurrences = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < arr.length; i++) {
            var val = arr[i];
            occurrences.computeIfAbsent(val, v -> new ArrayList<>()).add(i);
        }

        var memo = new int[arr.length];
        for (var entry : occurrences.entrySet()) {
            int currentLength = 1;

            var values = entry.getValue();
            if (values != null && !values.isEmpty()) {
                Integer prevValueIndex = values.get(0);
                var result = findOccurrences(occurrences, difference, memo, entry.getKey(), prevValueIndex, currentLength);
                if (result > 0) {
                    maxLength = Math.max(maxLength, result);
                    memo[prevValueIndex] = Math.max(memo[prevValueIndex], result);
                }

            }
        }

        return maxLength;
    }

    private int findOccurrences(HashMap<Integer, ArrayList<Integer>> occurrences, int difference, int[] memo,
                                Integer prevValue, Integer prevValueIndex, int currentLength) {
        var memoed = memo[prevValueIndex];
        if (memoed > 0) return currentLength + memoed - 1;

        var nextValue = prevValue + difference;
        var nextValueIndexes = occurrences.get(nextValue);

        Integer tailValueIndex = nextValueIndexes != null ? findHigher(nextValueIndexes, prevValueIndex) : null;
        if (tailValueIndex == null) return currentLength;

        int length = findOccurrences(occurrences, difference, memo, nextValue, tailValueIndex, currentLength + 1);

        if (length > 0) {
            maxLength = Math.max(maxLength, length);
            var diffLength = length - currentLength;
            memo[tailValueIndex] = Math.max(memo[tailValueIndex], diffLength);
        }
        return length;
    }

    private Integer findHigher(ArrayList<Integer> nextValueIndexes, Integer prevValueIndex) {
        Integer higher = null;

        int left = 0;
        int right = nextValueIndexes.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int val = nextValueIndexes.get(mid);
            if (nextValueIndexes.get(mid) > prevValueIndex) {
                higher = val;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return higher;
    }
}
