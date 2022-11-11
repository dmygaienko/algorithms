package com.mygaienko.common.algorithms.leetcode.minimum_swaps_to_group_all_1s_together;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class Solution {

    public int minSwaps(int[] data) {
        int N = data.length;

        Set<Integer> grouped = new HashSet<>();
        Set<Integer> free = new HashSet<>();

        for (int i = 0; i < N; i++) {
            int next = data[i];
            if (next == 1) {
                free.add(i);
            }
        }

        if (free.size() == 0 || free.size() == 1) return 0;

        Integer next = free.iterator().next();
        return minSwaps(grouped, free, next, next, 0);
    }

    private int minSwaps(Set<Integer> grouped, Set<Integer> free, int from, int to, int currentSwaps) {
        int minSwaps = Integer.MAX_VALUE;

        grouped.add(to);
        free.remove(from);

        if (free.isEmpty()) {
            //post cleaning
            grouped.remove(to);
            free.add(from);
            return currentSwaps;

        } else if (free.contains(to + 1)) {
            minSwaps = Math.min(minSwaps, minSwaps(grouped, free, to + 1, to + 1, currentSwaps));

        } else {
            Iterator<Integer> iterator = new HashSet<>(free).iterator();
            while (iterator.hasNext()) {
                int nextFree = iterator.next();
                minSwaps = Math.min(minSwaps, minSwaps(grouped, free, nextFree, to + 1, currentSwaps + 1));
            }
        }

        //post cleaning
        grouped.remove(to);
        free.add(from);
        return minSwaps;
    }
}
