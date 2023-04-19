package com.mygaienko.common.algorithms.leetcode.linked_list_cycle_ii;


public class Solution {

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode intersection = getIntersection(head);
        if (intersection == null) return null;

        ListNode hare = head;
        ListNode tortoise = intersection;
        while (tortoise != hare) {
            tortoise = tortoise.next;
            hare = hare.next;
        }

        return tortoise;
    }

    private ListNode getIntersection(ListNode head) {
        ListNode tortoise = head;
        ListNode hare = head;

        while (tortoise != null && hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;

            if (tortoise == hare) {
                return hare;
            }
        }
        return null;
    }

}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
