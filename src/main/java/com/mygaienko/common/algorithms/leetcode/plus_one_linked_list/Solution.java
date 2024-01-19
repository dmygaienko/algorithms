package com.mygaienko.common.algorithms.leetcode.plus_one_linked_list;

class Solution {

    public ListNode plusOne(ListNode head) {
        var sentinel = new ListNode(0, head);

        var curr = head;
        var nonNine = sentinel;

        //find rightmost non-nine node
        while (curr != null) {
            if (curr.val != 9) {
                nonNine = curr;
            }
            curr = curr.next;
        }

        //increase rightmost non-nine node by one
        nonNine.val++;

        //after rightmost non-nine replace all nine nodes  with zero (if exist)
        var nines = nonNine.next;
        while (nines != null) {
            nines.val = 0;
            nines = nines.next;
        }

        return sentinel.val != 0 ? sentinel : sentinel.next;
    }

}

