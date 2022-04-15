package com.mygaienko.common.algorithms.leetcode.merge_two_sorted_lists;

class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode start = null;
        ListNode node = null;
        while (list1 != null || list2 != null) {
            int val;
            if (list1 != null && list2 != null && list1.val < list2.val || list2 == null) {
                val = list1.val;
                list1 = list1.next;
            } else {
                val = list2.val;
                list2 = list2.next;
            }

            ListNode nextNode = new ListNode(val);
            if (node == null) {
                start = nextNode;
            } else {
                node.next = nextNode;
            }
            node = nextNode;
        }

        return start;
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