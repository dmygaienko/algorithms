package com.mygaienko.common.algorithms.leetcode.rearrange_string_k_distance_apart;

import java.util.*;

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

        var comparator = Comparator.<int[]>comparingInt(arr -> arr[1])
                .thenComparingInt(arr -> arr[0]).reversed();
        var queue = new PriorityQueue<>(comparator);
        for (int i = 0; i < charCounts.length; i++) {
            var count = charCounts[i];
            if (count > 0) {
                queue.offer(new int[]{i, count});
            }
        }

        var sb = new StringBuilder();

        var kQueue = new ArrayDeque<int[]>();

        while (!queue.isEmpty()) {
            var next = queue.poll();
            var charIndex = next[0];

            sb.append((char) (charIndex + 'a'));

            charCounts[charIndex] -= 1;
            if (charCounts[charIndex] > 0) {
                kQueue.offer(new int[]{sb.length() - 1, charIndex});
            }
            if (!kQueue.isEmpty() && sb.length() - kQueue.peek()[0] >= k) {
                offerAll(queue, kQueue, charCounts);
            }
        }

        return kQueue.isEmpty() ? sb.toString() : "";
    }

    public void offerAll(Queue<int[]> queue, Queue<int[]> kQueue, int[] charCounts) {
        while (!kQueue.isEmpty()) {
            var next = kQueue.poll();
            var charIndex = next[1];
            var count = charCounts[charIndex];
            if (count > 0) queue.offer(new int[] {charIndex, count});
        }
    }
}