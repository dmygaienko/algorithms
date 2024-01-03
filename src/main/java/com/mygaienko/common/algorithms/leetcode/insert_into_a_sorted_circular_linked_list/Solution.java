package com.mygaienko.common.algorithms.leetcode.insert_into_a_sorted_circular_linked_list;


// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};

public class Solution {

    // keep given node
    // iterate over list and find node greater than value
    // insert new node between prev and next node
    // so that prev.next will reference new node
    // new node will reference next node
    public Node insert(Node head, int insertVal) {
        var node = new Node(insertVal);
        if (head == null) {
            node.next = node;
            return node;
        }

        Node prev = head;
        Node next = head.next;

        while (prev != next && next != head) {

            // insert between common nodes (not lowest or highest)
            if (prev.val <= insertVal && insertVal <= next.val) {
                break;
            }

            //insert new higher node between highest and lowest nodes
            if (prev.val > next.val && prev.val <= insertVal) {
                break;
            }

            //insert new lower node between highest and lowest nodes
            if (prev.val > next.val && insertVal <= next.val) {
                break;
            }

            prev = next;
            next = next.next;
        }

        prev.next = node;
        node.next = next;

        return head;
    }
}