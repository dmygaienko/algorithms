package com.mygaienko.common.algorithms.leetcode.counting_elements;

import java.util.Arrays;

class SolutionV2 {
    public int countElements(int[] arr) {
        Arrays.sort(arr);

        var result = 0;

        for (int i = 0; i + 1 < arr.length; i++) {
            var val = arr[i];
            var count = 1;

            while (i + 1 < arr.length && val == arr[i + 1]) {
                count++;
                i++;
            }

            if (i + 1 < arr.length && val + 1 == arr[i + 1]) {
                result += count;
            }
        }
        return result;
    }
}