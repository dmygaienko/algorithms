package com.mygaienko.common.algorithms.leetcode.plus_one_linked_list;


class SolutionV2 {

    public ListNode plusOne(ListNode head) {
        var carry = plus(head);
        if (carry > 0) {
            return new ListNode(carry, head);
        }
        return head;
    }

    public int plus(ListNode node) {
        var carry = 0;
        if (node.next != null) {
            carry = plus(node.next);
        }

        if (node.next == null || carry > 0) {
            var val = node.val + 1;
            node.val = val % 10;
            carry = val / 10;
        }
        return carry;
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
