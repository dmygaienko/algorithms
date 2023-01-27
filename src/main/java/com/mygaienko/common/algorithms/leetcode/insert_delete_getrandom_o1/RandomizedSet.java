package com.mygaienko.common.algorithms.leetcode.insert_delete_getrandom_o1;

import java.util.*;

class RandomizedSet {

    private Map<Integer, Integer> valueToIndex = new HashMap<>();
    private Map<Integer, Integer> indexToValue = new HashMap<>();
    private Deque<Integer> freeIndexes = new ArrayDeque<>();
    private int maxIndex = 0;

    public RandomizedSet() {

    }

    public boolean insert(int val) {
        boolean present = valueToIndex.containsKey(val);
        if (present) return false;

        Integer newIndex;
        if (freeIndexes.isEmpty()) {
            ++maxIndex;
            newIndex = maxIndex;
        } else {
            newIndex = freeIndexes.poll();
        }

        valueToIndex.put(val, newIndex);
        indexToValue.put(newIndex, val);

        return true;
    }

    public boolean remove(int val) {
        Integer index = valueToIndex.remove(val);
        boolean result = index != null;
        if (result) {
            indexToValue.remove(index);
            freeIndexes.offer(index);
        }
        return result;
    }

    public int getRandom() {
        int i = new Random().nextInt(maxIndex + 1);
        Integer value = indexToValue.get(i);
        while (value == null) {
            if (i < maxIndex) {
                i = i + 1;
            } else {
                i = 0;
            }
            value = indexToValue.get(i);
        }
        return value;
    }
}