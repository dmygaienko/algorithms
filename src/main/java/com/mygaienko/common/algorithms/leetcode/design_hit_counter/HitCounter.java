package com.mygaienko.common.algorithms.leetcode.design_hit_counter;

import java.util.ArrayList;
import java.util.List;

class HitCounter {

    private final List<Integer> hits = new ArrayList<>();

    public HitCounter() {

    }

    public void hit(int timestamp) {
        hits.add(timestamp);
    }

    public int getHits(int timestamp) {
        int sum = 0;
        int from = timestamp - 299;

        int left = 0;
        int right = hits.size() - 1;

        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            int val = hits.get(mid);

            if (from == val && (mid == 0 || hits.get(mid - 1) != from)) {
                break;
            } else if (val < from) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        for (int i = mid; i < hits.size(); i++) {
            int value = hits.get(i);

            if (from <= value && value <= timestamp) {
                sum++;
            } else if (value > timestamp) {
                break;
            }
        }

        return sum;
    }
}
