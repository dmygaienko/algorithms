package com.mygaienko.common.algorithms.leetcode.first_unique_number;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

//keep track of nums count
//keep ordering in linked hash set
//on add increment count of number
//if previous value was 1 remove from set
class FirstUnique {

    Set<Integer> order = new LinkedHashSet<>();
    Map<Integer, Integer> numCounts = new HashMap<>();

    public FirstUnique(int[] nums) {
        for (var num : nums) {
            add(num);
        }
    }

    public int showFirstUnique() {
        var iterator = order.iterator();
        return iterator.hasNext() ? iterator.next() : -1;
    }

    public void add(int value) {
        var count = numCounts.compute(value, (k, v) -> v == null ? 1 : v + 1);
        if (count == 1) {
            order.add(value);
        } else if (count == 2) {
            order.remove(value);
        }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
