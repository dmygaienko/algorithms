package com.mygaienko.common.algorithms.leetcode.rearrange_string_k_distance_apart;

import java.util.PriorityQueue;

class Solution {

    /**
     * iterate over chars and calculate its count
     * put all count greater than 0 to queue
     * pull latest element from queue, check that previous occurence was on -k index, reduce count and offer back.
     * if not pull another element from queue, and validate one more time, after that push previos element (probably need to store in list of unlucky pairs)
     * if not return empty string
     */
    public String rearrangeString(String s, int k) {
        var charCounts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'a'] += 1;
        }

        var queue = new PriorityQueue<int[]>();
        for (int i = 0; i < charCounts.length; i++) {
            var count = charCounts[i];
            if (count > 0) {
                queue.offer(new int[] {i, count});
            }
        }
    }
}