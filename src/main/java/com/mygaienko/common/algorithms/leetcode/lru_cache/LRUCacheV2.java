package com.mygaienko.common.algorithms.leetcode.lru_cache;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.Map;

class LRUCacheV2 {

    private final Map<Integer, int[]> map;
    private final Deque<int[]> queue;
    private final int capacity;
    private int currentAge = 0;

    public LRUCacheV2(int capacity) {
        map = new LinkedHashMap<>(capacity);
        queue = new ArrayDeque<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        int[] agedValue = map.get(key);
        if (agedValue != null) {
            int value = agedValue[0];
            putValue(key, value);
            return value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.size() == capacity && !map.containsKey(key)) {
            clear();
        }
        putValue(key, value);
    }

    private void putValue(int key, int value) {
        int newAge = currentAge + 1;
        map.put(key, new int[]{value, newAge});
        offerAge(key, newAge);
    }

    private void clear() {
        int oldKey = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int[] next = queue.poll();
            oldKey = next[0];
            int age = next[1];
            int[] agedValue = map.get(oldKey);
            if (agedValue != null && age == agedValue[1]) {
                break;
            } else {
                queue.offer(new int[]{oldKey, age});
            }
        }
        map.remove(oldKey);
    }

    private void offerAge(int key, int newAge) {
        queue.offer(new int[]{key, newAge});
        currentAge = newAge;
    }

}
