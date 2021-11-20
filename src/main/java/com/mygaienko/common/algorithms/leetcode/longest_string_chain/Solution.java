package com.mygaienko.common.algorithms.leetcode.longest_string_chain;

import java.util.*;

class Solution {

    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparing(String::length));

        Map<String, Integer> maxPreds = new LinkedHashMap<>();

        for (int i = words.length -1 ; i >= 0; i--) {
            String next = words[i];

            maxPreds.putIfAbsent(next, 1);
            Integer nextChain = maxPreds.get(next);

            List<String> preds = new ArrayList<>();
            for (int j = i - 1; j >= 0; j--) {
                String pred = words[j];
                if (pred.length() < next.length() - 1) {
                    break;
                }

                if (isPredecessor(pred, next)) {
                    preds.add(pred);
                }
            }

            int predsChain = nextChain + 1;
            for (String pred : preds) {
                maxPreds.compute(pred, (k, v) -> v == null ? predsChain : Math.max(v, predsChain));

            }
        }

        return getLongest(maxPreds);
    }

    private int getLongest(Map<String, Integer> maxPreds) {
        int longest = 0;
        for (Map.Entry<String, Integer> entry : maxPreds.entrySet()) {
            longest = Math.max(longest, entry.getValue());
        }
        return longest;
    }

    public boolean isPredecessor(String pred, String desc) {
        int left = 0;
        int right = desc.length() - 1;

        if (desc.length() - pred.length() != 1) {
            return false;
        }

        while (left < right) {

            if (pred.charAt(left) == desc.charAt(left)) {
                ++left;
            } else if (pred.charAt(right-1) == desc.charAt(right)) {
                --right;
            } else {
                return false;
            }
        }

        return true;
    }

}
