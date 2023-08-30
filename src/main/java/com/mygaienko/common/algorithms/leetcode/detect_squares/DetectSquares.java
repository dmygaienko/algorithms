package com.mygaienko.common.algorithms.leetcode.detect_squares;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class DetectSquares {

    Map<Integer, TreeMap<Integer, Integer>> xToY = new HashMap<>();
    Map<Integer, TreeMap<Integer, Integer>> yToX = new HashMap<>();

    public void add(int[] point) {
        int x = point[0];
        int y = point[1];
        xToY.putIfAbsent(x, new TreeMap<>());
        xToY.get(x).compute(y, (k, v) -> v == null ? 1 : v + 1);
        yToX.putIfAbsent(y, new TreeMap<>());
        yToX.get(y).compute(x, (k, v) -> v == null ? 1 : v + 1);
    }

    public int count(int[] point) {
        int count = 0;

        TreeMap<Integer, Integer> yS = xToY.get(point[0]); // y -> count
        if (yS == null || yS.isEmpty()) return 0;

        //find verticals
        for (Map.Entry<Integer, Integer> e : yS.entrySet()) {
            int y = e.getKey();
            int length = Math.abs(y - point[1]);
            if (length == 0) continue;

            //find first horizontal
            TreeMap<Integer, Integer> xS = yToX.get(y); // x -> count
            if (xS == null || xS.isEmpty()) continue;

            //find next vertical (plus)
            Integer countOppositeX = xS.get(point[0] + length);
            if (countOppositeX != null) {
                TreeMap<Integer, Integer> ySS = xToY.get(point[0] + length); // y -> count
                if (ySS != null && ySS.containsKey(point[1])) {
                    int toAdd = e.getValue() * countOppositeX * ySS.getOrDefault(point[1], 1);
                    count+= toAdd;
                }
            }

            //find next vertical (minus)
            countOppositeX = xS.get(point[0] - length);
            if (countOppositeX != null) {
                TreeMap<Integer, Integer> ySS = xToY.get(point[0] - length); // y -> count
                if (ySS != null && ySS.containsKey(point[1])) {
                    int toAdd = e.getValue() * countOppositeX * ySS.getOrDefault(point[1], 1);
                    count+= toAdd;
                }
            }

        }
        return count;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */
