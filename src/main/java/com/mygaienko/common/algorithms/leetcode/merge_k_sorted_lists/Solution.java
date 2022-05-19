package com.mygaienko.common.algorithms.leetcode.merge_k_sorted_lists;


import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        if (lists != null) {
            for (ListNode node : lists) {
                if (node != null) queue.offer(node);
            }
        }

        ListNode start = null;
        ListNode current = null;
        while (!queue.isEmpty()) {

            ListNode polled = queue.poll();

            if (polled.next != null) {
                queue.offer(polled.next);
            }

            if (start == null) {
                start = polled;
            }

            if (current != null) {
                current.next = polled;
            }
            current = polled;
        }

        return start;
    }

}
