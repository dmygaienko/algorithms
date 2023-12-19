package com.mygaienko.common.algorithms.leetcode.diagonal_traverse_ii;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        var list = new ArrayList<int[]>();

        for (int i = 0; i < nums.size(); i++) {
            var row = nums.get(i);
            for (int j = 0; j < row.size(); j++) {
                var cell = row.get(j);
                list.add(new int[]{i, j, cell});
            }
        }

        list.sort((a, b) -> sum(a) == sum(b)
                ? b[0] - a[0]
                : sum(a) - sum(b)
        );

        return list.stream().mapToInt(i -> i[2]).toArray();
    }

    private static int sum(int[] arr) {
        return arr[0] + arr[1];
    }

}
