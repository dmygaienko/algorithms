package com.mygaienko.common.algorithms.leetcode.lru_cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * map 1:1 2:2 3:3
 * age 1:1 2:1 3:1
 *
 * get 1 return 1
 * map 1:1 2:2 3:3
 * age 1:2 2:1 3:1
 *
 * 1:2
 */
class LRUCacheV4 extends LinkedHashMap<Integer, Integer>{
    private int capacity;

    public LRUCacheV4(int capacity) {
        super(capacity, 0.75F, false);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
