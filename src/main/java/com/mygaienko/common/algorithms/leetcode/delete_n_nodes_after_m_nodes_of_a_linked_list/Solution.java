package com.mygaienko.common.algorithms.leetcode.delete_n_nodes_after_m_nodes_of_a_linked_list;

class Solution {
    public ListNode deleteNodes(ListNode head, int m, int n) {
        if (head == null) return null;

        var lastKeep = head;
        var curr = head;
        while (curr != null) {

            var keepCount = m;
            while (keepCount > 0 && curr != null) {
                lastKeep = curr;
                curr = curr.next;
                keepCount--;
            }

            var deleteCount = n;
            while (deleteCount > 0 && curr != null) {
                curr = curr.next;
                deleteCount--;
            }

            lastKeep.next = curr;
        }

        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}