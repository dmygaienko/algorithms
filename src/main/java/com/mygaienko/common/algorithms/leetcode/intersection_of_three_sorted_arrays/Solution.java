package com.mygaienko.common.algorithms.leetcode.intersection_of_three_sorted_arrays;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        var result = new ArrayList<Integer>();

        var p1 = 0;
        var p2 = 0;
        var p3 = 0;

        while (p1 < arr1.length && p2 < arr2.length && p3 < arr3.length) {
            if (arr1[p1] == arr2[p2] && arr2[p2] == arr3[p3]) {
                result.add(arr1[p1]);
                p1++;
                p2++;
                p3++;
            } else if (arr1[p1] < arr2[p2]) {
                p1++;
            } else if (arr2[p2] < arr3[p3]) {
                p2++;
            } else {
                p3++;
            }
        }


        return result;
    }

}
