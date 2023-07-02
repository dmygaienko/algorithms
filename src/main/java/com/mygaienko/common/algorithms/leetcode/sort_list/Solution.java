package com.mygaienko.common.algorithms.leetcode.sort_list;

class Solution {

    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        ListNode[] startEnd = quickSort(head, null);
        if (startEnd == null) return null;
        startEnd[1].next = null;
        return startEnd[0];
    }

    private ListNode[] quickSort(ListNode start, ListNode end) {
        ListNode beforePivotStart = null;
        ListNode beforePivot = null;
        ListNode pivot = null;
        ListNode afterPivot = null;

        ListNode current = start;
        while (current != null) {
            int value = current.val;

            if (pivot == null) {
                pivot = current;
            } else if (value < pivot.val) {
                if (beforePivot == null) {
                    beforePivot = current;
                    beforePivotStart = current;
                } else {
                    beforePivot.next = current;
                    beforePivot = current;
                }
            } else {
                if (afterPivot == null) {
                    afterPivot = current;
                    pivot.next = afterPivot;
                } else {
                    afterPivot.next = current;
                    afterPivot = current;
                }
            }

            if (end != null && end == current) {
                break;
            }

            current = current.next;
        }

        if (beforePivot != null) {
            beforePivot.next = pivot;
        }

        ListNode[] beforeList = null;
        if (beforePivotStart != null && pivot != null && beforePivotStart != pivot) {
            beforeList = quickSort(beforePivotStart, pivot);
        }

        ListNode[] afterList = null;
        if (pivot != null && afterPivot != null && pivot != afterPivot) {
            afterList = quickSort(pivot.next, afterPivot);
        }

        ListNode[] result = null;
        if (beforeList != null) {
            if (afterList != null) {
                beforeList[1].next = afterList[0];
                result = new ListNode[]{beforeList[0], afterList[1]};
            } else {
                result = beforeList;
            }
        } else if (afterList != null) {
            if (pivot != null) {
                pivot.next = afterList[0];
                result = new ListNode[] {pivot, afterList[1]};
            } else {
                result = afterList;
            }
        } else if (beforePivotStart != null) {
            if (afterPivot != null) {
                result = new ListNode[]{beforePivotStart, afterPivot};
            } else {
                result = new ListNode[]{beforePivotStart, pivot};
            }
        } else if (pivot != null) {
            if (afterPivot != null) {
                result = new ListNode[]{pivot, afterPivot};
            } else {
                result = new ListNode[]{pivot, pivot};
            }
        }

        return (result == null || result[0] == null || result[1] == null) ? null : result;
    }

}

