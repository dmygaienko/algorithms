package com.mygaienko.common.algorithms.leetcode.intersection_of_three_sorted_arrays;

import java.util.ArrayList;
import java.util.List;

class SolutionV2 {

    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        var temp = merge(arr1, arr2);
        var merged = merge(temp, arr3);

        var result = new ArrayList<Integer>();

        var count = 0;
        var val = Integer.MIN_VALUE;
        for (int i = 0; i < merged.length; i++) {
            if (val != merged[i]) {
                count = 1;
                val = merged[i];
            } else if (val == merged[i]) {
                count++;
            }

            if (count == 3) {
                result.add(merged[i]);
            }
        }
        return result;
    }

    private int[] merge(int[] arr1, int[] arr2) {
        var n = arr1.length + arr2.length;
        var result = new int[n];

        int j = 0;
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (j < arr1.length && k < arr2.length) {
                if (arr1[j] <= arr2[k]) {
                    result[i] = arr1[j];
                    j++;
                } else {
                    result[i] = arr2[k];
                    k++;
                }
            } else if (j < arr1.length) {
                result[i] = arr1[j];
                j++;
            } else {
                result[i] = arr2[k];
                k++;
            }
        }

        return result;
    }

}
