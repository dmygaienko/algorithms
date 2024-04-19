package com.mygaienko.common.algorithms.leetcode.find_anagram_mappings;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

class Solution {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        var indexes = new HashMap<Integer, Queue<Integer>>();
        for (int i = 0; i < nums2.length; i++) {
            var num = nums2[i];
            indexes.computeIfAbsent(num, v -> new ArrayDeque<>()).offer(i);
        }

        var result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            var num = nums1[i];
            result[i] = indexes.get(num).poll();
        }

        return result;
    }
}
