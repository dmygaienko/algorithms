package com.mygaienko.common.algorithms.leetcode.find_k_closest_elements;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int value = arr[mid];

            if (value == x) {
                return getClosestElements(arr, k, mid, x);
            } else if (mid + 1 < arr.length && isCloser(value, arr[mid+1], x)
                    && mid - 1 >= 0 && isCloser(value, arr[mid-1], x)) {
                return getClosestElements(arr, k, mid, x);
            } else if (isCloser(arr[left], arr[right], x)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return getClosestElements(arr, k, Math.max(left, right), x);
    }

    private boolean isCloser(int left, int right, int value) {
        return Math.abs(value - left) < Math.abs(value - right) ||
                (Math.abs(value - left) == Math.abs(value - right) && left < right);
    }

    private List<Integer> getClosestElements(int[] arr, int k, int index, int x) {
        int from = index;
        int to = index;
        k--;
        while (k > 0) {
            if (from - 1 >= 0) {
                if (to + 1 < arr.length && isCloser(arr[to + 1], arr[from - 1], x)) {
                    to++;
                } else {
                    from--;
                }
            } else {
                to++;
            }
            k--;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = from;i <= to; i++) {
            result.add(arr[i]);
        }
        return result;
    }

}

