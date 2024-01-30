package com.mygaienko.common.algorithms.leetcode.find_smallest_common_element_in_all_rows;

class SolutionV2 {

    public int smallestCommonElement(int[][] mat) {
        var n = mat.length;
        var m = mat[0].length;
        var pos = new int[n];
        var cur_max = 0;
        var count = 0;

        while (true) {

            for (int i = 0; i < n; i++) {
                while (pos[i] < m && mat[i][pos[i]] < cur_max) {
                    pos[i]++;
                }

                if (pos[i] >= m) return -1;

                if (mat[i][pos[i]] == cur_max) {
                    count++;
                    if (count == n) return cur_max;
                } else {
                    count = 1;
                    cur_max = mat[i][pos[i]];
                }
            }

        }
    }

}