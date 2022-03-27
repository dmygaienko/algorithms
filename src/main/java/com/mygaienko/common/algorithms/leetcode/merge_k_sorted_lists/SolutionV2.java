package com.mygaienko.common.algorithms.leetcode.merge_k_sorted_lists;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

class SolutionV2 {

    public ListNode mergeKLists(ListNode[] lists) {
        MergeResult mergeResult = mergeLists(Arrays.asList(lists), 0, lists.length - 1);

        MergeResult next = mergeResult;
        while (!next.getNotSorted().isEmpty()) {
            next = mergeLists(next.getNotSorted(), 0, next.notSorted.size() - 1);
            mergeResult.link(next);
        }

        return mergeResult.getFirst();
    }

    private MergeResult mergeLists(List<ListNode> lists, int start, int end) {
        MergeResult mergeResult = new MergeResult();
        int size = end - start + 1;
        if (size > 2) {
            int half = start + (end - start)/2;

            // TODO sort on merge
            mergeResult = mergeLists(lists, start, start + half);
            MergeResult right = mergeLists(lists, start + half + 1, end);
            mergeResult.merge(right);

        } if (size == 2) {
            ListNode left = lists.get(start);
            ListNode right = lists.get(end);

            if (left.val < right.val) {
                build(mergeResult, left, right);
            } else {
                build(mergeResult, right, left);
            }

        } if (size == 1) {
            build(mergeResult,  lists.get(start), null);
        }

        return mergeResult;
    }

    private void build(MergeResult mergeResult, ListNode left, ListNode right) {
        mergeResult.setFirst(left);
        left = findLastEqNode(left);
        mergeResult.addNotSorted(left.next);

        if (right != null) {
            left.next = right;
            right = findLastEqNode(right);
            mergeResult.setLast(right);
            mergeResult.addNotSorted(right.next);
            right.next = null;
        } else {
            mergeResult.setLast(left);
        }
    }

    private ListNode findLastEqNode(ListNode left) {
        while (left.next != null && left.next.val == left.val) {
            left = left.next;
        }

        return left;
    }

}

class MergeResult {

    ListNode first;
    ListNode last;

    List<ListNode> notSorted = new ArrayList<>();

    public ListNode getFirst() {
        return first;
    }

    public ListNode getLast() {
        return last;
    }

    public List<ListNode> getNotSorted() {
        return notSorted;
    }

    public void setFirst(ListNode first) {
        this.first = first;
    }

    public void setLast(ListNode last) {
        this.last = last;
    }

    public void addNotSorted(ListNode node) {
        if (node != null) {
            notSorted.add(node);
        }
    }

    public void addNotSorted(Collection<ListNode> nodes) {
        notSorted.addAll(nodes);
    }

    public void merge(MergeResult right) {
        ListNode nextLeft = first;
        ListNode nextRight = right.getFirst();

        first = null;
        ListNode next = null;
        while (nextLeft != null || nextRight != null) {
            if (nextRight == null || ( nextLeft != null && nextLeft.val < nextRight.val)) {
                if (first == null) {
                    first = nextLeft;
                }
                if (next != null) {
                    next.next = nextLeft;
                }
                next = nextLeft;

                nextLeft = nextLeft.next;
            } else {
                if (first == null) {
                    first = nextRight;
                }
                if (next != null) {
                    next.next = nextRight;
                }
                next = nextRight;

                nextRight = nextRight.next;
            }
        }
        last = next;
//        link(right);
        this.addNotSorted(right.getNotSorted());
    }

    public void link(MergeResult right) {
        this.getLast().next = right.getFirst();
        this.setLast(right.getLast());
    }
}
