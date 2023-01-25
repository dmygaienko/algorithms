package com.mygaienko.common.algorithms.leetcode.lru_cache;

import java.util.HashMap;
import java.util.Map;

/**
 * map 1:1 2:2 3:3
 * age 1:1 2:1 3:1
 * <p>
 * get 1 return 1
 * map 1:1 2:2 3:3
 * age 1:2 2:1 3:1
 * <p>
 * 1:2
 */
class LRUCache {

    private final int capacity;
    private final DoubleLinkedNode head;
    private final DoubleLinkedNode tail;
    private final Map<Integer, DoubleLinkedNode> cache;

    private int size = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new DoubleLinkedNode();
        tail = new DoubleLinkedNode();

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DoubleLinkedNode node = cache.get(key);

        if (node != null) {
            moveToHead(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        DoubleLinkedNode node = cache.get(key);

        if (node == null) {
            node = new DoubleLinkedNode(key, value);

            cache.put(key, node);
            addNode(node);

            ++size;

            if (size > capacity) {
                DoubleLinkedNode toRemove = popTail();
                cache.remove(toRemove.key);
                --size;
            }

        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    static class DoubleLinkedNode {
        int key = 0;
        int value = 0;
        DoubleLinkedNode prev;
        DoubleLinkedNode next;

        public DoubleLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public DoubleLinkedNode() {
        }
    }

    private void addNode(DoubleLinkedNode node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DoubleLinkedNode node) {
        DoubleLinkedNode prev = node.prev;
        DoubleLinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(DoubleLinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    private DoubleLinkedNode popTail() {
        DoubleLinkedNode node = tail.prev;
        removeNode(node);
        return node;
    }

}
