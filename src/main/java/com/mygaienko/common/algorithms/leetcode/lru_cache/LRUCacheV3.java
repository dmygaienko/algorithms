package com.mygaienko.common.algorithms.leetcode.lru_cache;

import java.util.*;

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
class LRUCacheV3 {

    private final Map<Integer, Integer> map;
    private final Map<Integer, Integer> keyToAge;
    private final Map<Integer, Integer> ageToKey;
    private final int capacity;
    private int currentAge = 0;

    public LRUCacheV3(int capacity) {
        map = new LinkedHashMap<>(capacity);
        keyToAge = new HashMap<>(capacity);
        ageToKey = new TreeMap<>();
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
        if (map.size() == capacity && !map.containsKey(key)) {
            clear();
        }
        map.put(key, value);
        use(key);
    }

    private void clear() {
        int oldKey = Integer.MIN_VALUE;
        Iterator<Map.Entry<Integer, Integer>> it = ageToKey.entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = it.next();
            oldKey = entry.getValue();
            it.remove();
        }
        map.remove(oldKey);
        keyToAge.remove(oldKey);
    }

    private void use(int key) {
        keyToAge.compute(key, (k, age) -> age == null ?  putAge(key) : recalculate(key, age));
    }


    private int recalculate(Integer key, Integer age) {
        ageToKey.remove(age);
        return putAge(key);
    }

    private int putAge(Integer key) {
        int newAge = currentAge + 1;
        ageToKey.put(newAge, key);
        currentAge = newAge;
        return currentAge;
    }

}
