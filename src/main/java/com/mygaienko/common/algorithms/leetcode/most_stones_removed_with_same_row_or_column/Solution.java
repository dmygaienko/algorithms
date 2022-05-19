package com.mygaienko.common.algorithms.leetcode.most_stones_removed_with_same_row_or_column;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

class Solution {

    public int removeStones(int[][] stones) {

        Map<Integer, Set<Integer>> rows = new HashMap<>();
        Map<Integer, Set<Integer>> columns = new HashMap<>();
        Map<Integer, Set<Integer>> removed = new HashMap<>();

        for (int[] stone : stones) {
            int x = stone[0];
            int y = stone[1];

            Set<Integer> row = rows.computeIfAbsent(x, v -> new TreeSet<>());
            row.add(y);

            Set<Integer> column = columns.computeIfAbsent(y, v -> new TreeSet<>());
            column.add(x);
        }

        int qTy = 0;
        for (int[] stone : stones) {
            int x = stone[0];
            int y = stone[1];

            qTy += removeStone(removed, rows, columns, 0, x, y);
        }

        return qTy;
    }

    private int removeStone(Map<Integer, Set<Integer>> removed, Map<Integer, Set<Integer>> rows, Map<Integer, Set<Integer>> columns, int qty, int x, int y) {
        if (removed.getOrDefault(x, Collections.emptySet()).contains(y)) return 0;
        removed.computeIfAbsent(x, v -> new HashSet<>()).add(y);

        Set<Integer> row = rows.get(x);
        boolean rowFound = row != null && row.contains(y);

        Set<Integer> column = columns.get(y);
        boolean columnFound = column != null && column.contains(x);

        if (rowFound) {
            for (Integer nextY : row) {
                if (containsAny(rows, columns, x, nextY) && !removed.getOrDefault(x, Collections.emptySet()).contains(nextY)) {
                    qty += removeStone(removed, rows, columns, 1, x, nextY);
                }
            }
        }

        if (columnFound) {
            for (Integer nextX : column) {
                if (containsAny(rows, columns, nextX, y) && !removed.getOrDefault(nextX, Collections.emptySet()).contains(y)) {
                    qty += removeStone(removed, rows, columns, 1, nextX, y);
                }
            }
        }

        if (!rowFound && !columnFound) {
            qty = 0;
        }

        return qty;
    }

    private boolean containsAny(Map<Integer, Set<Integer>> rows, Map<Integer, Set<Integer>> columns, Integer x, int y) {
        Set<Integer> row = rows.get(x);
        if (row != null && row.contains(y)) return true;

        Set<Integer> column = columns.get(y);
        return column != null && column.contains(x);
    }

}
