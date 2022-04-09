package com.mygaienko.common.algorithms.leetcode.find_k_closest_elements;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int value = arr[mid];

            if (value == x) {
                return getClosestElements(arr, k, mid);
            } else if (value < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return getClosestElements(arr, k, 0);
    }

    private List<Integer> getClosestElements(int[] arr, int k, int index) {
        int i = Math.max(index - k/2, 0);
        List<Integer> result = new ArrayList<>();
        for (;i < k; i++) {
            result.add(arr[i]);
        }
        return result;
    }

}
