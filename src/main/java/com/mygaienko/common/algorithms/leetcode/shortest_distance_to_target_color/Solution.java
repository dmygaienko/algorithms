package com.mygaienko.common.algorithms.leetcode.shortest_distance_to_target_color;

import java.util.ArrayList;
import java.util.List;

class Solution {
    // iterate over colors array and collect them to list of specific colours list N
    // for each query try to find closest distance by binary search M * logN
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        var grouped = new ArrayList<List<Integer>>();
        for (int i = 0; i < 4; i++) {
            grouped.add(new ArrayList<>());
        }
        for (int i = 0; i < colors.length; i++) {
            var colour = colors[i];
            grouped.get(colour).add(i);
        }

        var result = new ArrayList<Integer>();
        for (var query : queries) {
            var index = query[0];
            var colour = query[1];
            result.add(search(grouped.get(colour), index));
        }
        return result;
    }

    private int search(List<Integer> list, int target) {
        if (list.isEmpty()) return -1;

        var distance = Integer.MAX_VALUE;
        var left = 0;
        var right = list.size() - 1;

        while (left <= right) {
            var mid = left + (right - left) / 2;
            var val = list.get(mid);
            distance = Math.min(distance, Math.abs(val - target));

            if (val > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return distance;
    }
}
