package com.mygaienko.common.algorithms.leetcode.remove_nth_node_from_end_of_list;

class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 1 && head.next == null) return null;
        int i = removeNth(head, n);
        if (i == n) return head.next;
        return head;
    }

    private int removeNth(ListNode current, int n) {
        if (current.next == null) {
            return 1;
        } else {
            int i = removeNth(current.next, n);
            if (i == n) {
                current.next = current.next.next;
            }
            return i+1;
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListNode listNode = (ListNode) o;

        if (val != listNode.val) return false;
        return next != null ? next.equals(listNode.next) : listNode.next == null;
    }

    @Override
    public int hashCode() {
        int result = val;
        result = 31 * result + (next != null ? next.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
