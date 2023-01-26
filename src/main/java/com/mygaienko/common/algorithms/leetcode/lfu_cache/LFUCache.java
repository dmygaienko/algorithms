package com.mygaienko.common.algorithms.leetcode.lfu_cache;

import java.util.*;

class LFUCache {

    private final Map<Integer, Integer> map;
    private final Map<Integer, Integer> keyToAge;
    private final Map<Integer, Deque<Integer>> ageToKeys;
    private final int capacity;

    public LFUCache(int capacity) {
        map = new HashMap<>(capacity);
        keyToAge = new HashMap<>(capacity);
        ageToKeys = new TreeMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer value = map.get(key);
        if (value != null) {
            use(key);
            return value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (capacity <= 0) return;
        if (map.size() == capacity && !map.containsKey(key)) {
            clear();
        }
        map.put(key, value);
        use(key);
    }

    private void clear() {
        int oldKey = Integer.MIN_VALUE;
        Iterator<Map.Entry<Integer, Deque<Integer>>> iterator = ageToKeys.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Deque<Integer>> entry = iterator.next();
            Deque<Integer> keys = entry.getValue();

            if (!keys.isEmpty()) {
                oldKey = keys.poll();
                if (keys.isEmpty()) {
                    iterator.remove();
                }
                break;
            }
        }
        map.remove(oldKey);
        keyToAge.remove(oldKey);
    }

    private void use(int key) {
        keyToAge.compute(key, (k, age) -> age == null ? initAge(key) : recalculate(key, age));
    }

    private Integer initAge(int key) {
        return putAge(key, 1);
    }

    private int recalculate(Integer key, Integer age) {
        Deque<Integer> keys = ageToKeys.get(age);
        if (keys != null) {
            keys.remove(key);
        }
        return putAge(key, age + 1);
    }

    private int putAge(Integer key, Integer newAge) {
        ageToKeys.putIfAbsent(newAge, new ArrayDeque<>());
        Deque<Integer> keys = ageToKeys.computeIfAbsent(newAge, k -> new ArrayDeque<>());
        keys.add(key);
        return newAge;
    }

}

